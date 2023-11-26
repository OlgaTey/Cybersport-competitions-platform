package team.selfChoice.Service;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.selfChoice.Entity.*;
import team.selfChoice.repository.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Math.min;

@Service
public class ExportService {

    @Autowired
    private AbsoluteTeamRepo absoluteTeamRepo;

    @Autowired
    private DisciplineRepo disciplineRepo;

    @Autowired
    private MatchRepo matchRepo;

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private RefereeRepo refereeRepo;

    @Autowired
    private TeamRepo teamRepo;

    @Autowired
    private TournamentRepo tournamentRepo;

    public ByteArrayInputStream TournamentExport(Tournament t) {
        try(Workbook workbook = new XSSFWorkbook()){
            CreationHelper createHelper = workbook.getCreationHelper();

            CellStyle dateStyle = workbook.createCellStyle();
            dateStyle.setDataFormat(
                    createHelper.createDataFormat().getFormat("d/m/yy h:mm"));
            CellStyle centerStyle = workbook.createCellStyle();
            centerStyle.setAlignment(CellStyle.ALIGN_CENTER);
            centerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

            CellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(HSSFColor.LEMON_CHIFFON.index);
            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            style.setAlignment(CellStyle.ALIGN_CENTER);
            style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

            // Оформление титульного листа:
            Sheet title_sheet = workbook.createSheet("Титульный лист");
            Row row;
            Cell cell;


            row = title_sheet.createRow(0);
            row.createCell(0).setCellValue("Название соревнований:");
            row.createCell(1).setCellValue(t.getName());

            row = title_sheet.createRow(2);
            row.createCell(0).setCellValue("Место проведения:");
            row.createCell(1).setCellValue(t.getLocation());


            row = title_sheet.createRow(4);
            row.createCell(0).setCellValue("Начало регистрации:");
            cell = row.createCell(1);
            cell.setCellStyle(dateStyle);
            cell.setCellValue(t.getStartRegistration());

            row = title_sheet.createRow(5);
            row.createCell(0).setCellValue("Окончание регистрации:");
            cell = row.createCell(1);
            cell.setCellStyle(dateStyle);
            cell.setCellValue(t.getEndRegistration());

            row = title_sheet.createRow(6);
            row.createCell(0).setCellValue("Начало соревнований:");
            cell = row.createCell(1);
            cell.setCellStyle(dateStyle);
            cell.setCellValue(t.getStartDate());

            row = title_sheet.createRow(7);
            row.createCell(0).setCellValue("Окончание соревнований:");
            cell = row.createCell(1);
            cell.setCellStyle(dateStyle);
            cell.setCellValue(t.getEndDate());

            row = title_sheet.createRow(9);
            row.createCell(0).setCellValue("Дисциплина:");
            row.createCell(1).setCellValue(t.getDiscipline().getName());

            row = title_sheet.createRow(11);
            row.createCell(0).setCellValue("Главный судья соревнований:");

            row = title_sheet.createRow(13);
            row.createCell(0).setCellValue("___________________________ (подпись)");

            row = title_sheet.createRow(15);
            Long chiefId = t.getManager().getChiefRefereeId();
            Long managerProfileId = 1L;
            for (Referee i:
                    t.getReferees()) {
                if (Objects.equals(i.getId(), chiefId)) {
                    managerProfileId = i.getProfileId();
                }
            }
//            row.createCell(0).setCellValue(profileRepo.getReferenceById(managerProfileId).getName());

            row = title_sheet.createRow(17);
            SimpleDateFormat df = new SimpleDateFormat("dd:MM:yyy");
            row.createCell(0).setCellValue("Дата составления: " + df.format(new Date()));


            title_sheet.autoSizeColumn(0);
            title_sheet.autoSizeColumn(1);


            // Оформление листа судей:
            Sheet referee_sheet = workbook.createSheet("Судьи");

            referee_sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
            row = referee_sheet.createRow(0);
            cell = row.createCell(0);
            cell.setCellStyle(centerStyle);
            cell.setCellValue(t.getName());

            referee_sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 7));
            row = referee_sheet.createRow(1);
            cell = row.createCell(0);
            cell.setCellStyle(centerStyle);
            cell.setCellValue("Судейская бригада соревнований");


            row = referee_sheet.createRow(2);
            String[] head = new String[]{"№", "Ф.И.О", "Должность / Специализация", "Категория / Аттестат", "Субъект РФ / Страна", "Дата рожд.", "Проживает", "Контакты"};
            for (int i=0;i<head.length;i++) {
                row.createCell(i).setCellValue(head[i]);
            }
            List<Referee> referees = t.getReferees();
            for (int i=0;i<referees.size();i++) {
                Referee referee = referees.get(i);
//                Profile profile = profileRepo.getReferenceById(r.getProfileId());
                row = referee_sheet.createRow(3+i);
                row.createCell(0).setCellValue(i);
//                row.createCell(1).setCellValue(profile.getName());
                row.createCell(2).setCellValue(referee.getPost());
                row.createCell(3).setCellValue(referee.getCategory());
                row.createCell(4).setCellValue(referee.getCountry());
//                row.createCell(5).setCellValue(profile.getBirthday());
                row.createCell(6).setCellValue(referee.getCity());
//                row.createCell(7).setCellValue(profile.getContacts());
            }
            for (int i = 0; i < 7; i++) {
                referee_sheet.autoSizeColumn(i);
            }

            // Оформление листа участников:
            Sheet participants_sheet = workbook.createSheet("Участники");

            participants_sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 11));
            row = participants_sheet.createRow(0);
            cell = row.createCell(0);
            cell.setCellStyle(centerStyle);
            cell.setCellValue(t.getName());

            participants_sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 11));
            row = participants_sheet.createRow(1);
            cell = row.createCell(0);
            cell.setCellStyle(centerStyle);
            cell.setCellValue("Участники соревнования");


            row = participants_sheet.createRow(2);
            head = new String[]{"№", "ID", "Ф.И.О.", "Пол", "Дата рожд.", "Субъект РФ", "Команда", "Разряд", "Количество побед", "Занятое место", "Контакты", "ГТО"};
            for (int i=0;i<head.length;i++) {
                row.createCell(i).setCellValue(head[i]);
            }

            List<Team> teams = t.getParticipants();
            int last_index = 2;
            for (int i=0;i<teams.size();i++) {
                Team team = teams.get(i);
                List<Player> players = team.getPlayers();

                for (int j:
                        new int[] {0, 5, 6, 8, 9}) {
                    participants_sheet.addMergedRegion(new CellRangeAddress(last_index+1, last_index+players.size(), j, j));
                }
                row = participants_sheet.createRow(last_index+1);

                cell = row.createCell(0);
                cell.setCellValue(i+1);
                cell.setCellStyle(centerStyle);

//                cell = row.createCell(5);
//                cell.setCellValue(team.getCity() + "/" + team.getCountry());
//                cell.setCellStyle(centerStyle);

                cell = row.createCell(6);
                cell.setCellValue(team.getName());
                cell.setCellStyle(centerStyle);

//                cell = row.createCell(8);
//                cell.setCellValue(team.getPoints().get("1"));
//                cell.setCellStyle(centerStyle);

                cell = row.createCell(9);
                cell.setCellValue(team.getPosition());
                cell.setCellStyle(centerStyle);

                Player player = players.get(0);
//                    Profile profile = profileRepo.getReferenceById(player.getProfileId());
                row.createCell(1).setCellValue(player.getId());
                row.createCell(2).setCellValue(player.getNickname());
//                    row.createCell(3).setCellValue((p.getIsMale())?("М"):("Ж"));
//                    row.createCell(4).setCellValue(p.getBirth());
                row.createCell(4).setCellStyle(dateStyle);
//                    row.createCell(7).setCellValue(p.getCategory(t.getDiscipline().getId()));
//                    row.createCell(10).setCellValue(p.getContacts());
//                    row.createCell(11).setCellValue(p.getGTO()); // RWD?

                for (int j = 1; j < players.size(); j++) {
                    player = players.get(j);
//                    Profile profile = profileRepo.getReferenceById(player.getProfileId());
                    row = participants_sheet.createRow(last_index+1+j);
                    row.createCell(1).setCellValue(player.getId());
                    row.createCell(2).setCellValue(player.getNickname());
//                    row.createCell(3).setCellValue((p.getIsMale())?("М"):("Ж"));
//                    row.createCell(4).setCellValue(p.getBirth());
                    row.createCell(4).setCellStyle(dateStyle);
//                    row.createCell(7).setCellValue(p.getCategory(t.getDiscipline().getId()));
//                    row.createCell(10).setCellValue(p.getContacts());
//                    row.createCell(11).setCellValue(p.getGTO()); // RWD?
                }

                last_index+=players.size();
            }
            for (int i = 0; i < 12; i++) {
                participants_sheet.autoSizeColumn(i);

            }

            // Оформление листа ПД:
            Sheet agreement_sheet = workbook.createSheet("ПД");
            agreement_sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 11));
            row = agreement_sheet.createRow(0);
            cell = row.createCell(0);
            cell.setCellStyle(centerStyle);
            cell.setCellValue(t.getName());

            agreement_sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 11));
            row = agreement_sheet.createRow(1);
            cell = row.createCell(0);
            cell.setCellValue("Текст согласия");
//            cell.setCellValue(t.getAgreement());
            row.setHeight((short) 4000);

            row = agreement_sheet.createRow(2);
            head = new String[]{"№", "Ф.И.О.", "Дата рожд.", "Субъект РФ", "Команда", "Контакты", "Согласие"};
            for (int i=0;i<head.length;i++) {
                row.createCell(i).setCellValue(head[i]);
            }
            last_index = 2;
            for (int i=0;i<teams.size();i++) {
                Team team = teams.get(i);
                List<Player> players = team.getPlayers();
                for (int j:
                        new int[] {3, 4}) {
                    agreement_sheet.addMergedRegion(new CellRangeAddress(last_index+1, last_index+players.size(), j, j));
                }
                row = agreement_sheet.createRow(last_index+1);

//                row.createCell(3).setCellValue(team.getCity() + "/" + team.getCountry());
//                cell = row.createCell(3);
//                cell.setCellValue(team.getCity() + "/" + team.getCountry());
//                cell.setCellStyle(centerStyle);

                cell = row.createCell(4);
                cell.setCellValue(team.getName());
                cell.setCellStyle(centerStyle);


                Player player = players.get(0);
//                    profile = profileRepo.getReferenceById(player.getProfileId());
                row.createCell(0).setCellValue(last_index-1);
                row.createCell(1).setCellValue(player.getNickname());
//                    row.createCell(2).setCellValue(profile.getBirth());
                row.createCell(2).setCellStyle(dateStyle);
//                    row.createCell(5).setCellValue(profile.getContacts());
//                    row.createCell(6).setCellValue((player.getAgree())?("Согласен")("Не согласен"));

                for (int j = 1; j < players.size(); j++) {
                    player = players.get(j);
//                    profile = profileRepo.getReferenceById(player.getProfileId());
                    row = agreement_sheet.createRow(last_index+1+j);
                    row.createCell(0).setCellValue(last_index-1+j);
                    row.createCell(1).setCellValue(player.getNickname());
//                    row.createCell(2).setCellValue(profile.getBirth());
                    row.createCell(2).setCellStyle(dateStyle);
//                    row.createCell(5).setCellValue(profile.getContacts());
//                    row.createCell(6).setCellValue((player.getAgree())?("Согласен")("Не согласен"));
                }

                last_index+=players.size();
            }
            for (int i = 0; i < 7; i++) {
                agreement_sheet.autoSizeColumn(i);
            }
            // Оформление листа Сетки:
            Sheet grid_sheet = workbook.createSheet("Сетка");
            int team_number = teams.size();
            ArrayList<Double> indexes = new ArrayList<Double>();
            List<Match> matches = t.getMatches();
            int counter = 0;
            int h = 1;
            int level = 0;
            while (team_number != 0) {
                if (indexes.size() == 0) {
                    for (int i = 0;i<team_number;i++) {
//                        matches.getMatchesByLevel(level).get(i/2);
                        String name = matches.get(i/2).getParticipants().get(i%2).getName();
                        grid_sheet.addMergedRegion(new CellRangeAddress(3+(i*6), 6+(i*6), h, h+1));
                        row = grid_sheet.createRow(3+(i*6));
                        cell = row.createCell(1);
                        cell.setCellStyle(centerStyle);
                        cell.setCellValue(name);
                        cell.setCellStyle(style);
                        if (i%2==0) indexes.add((double) (3+(i*6)));
                        else indexes.add((double) (6+(i*6)));
                    }
                }
                else {
                    ArrayList<Double> indexes2 = new ArrayList<Double>();
                    for (int i = 0; i < indexes.size()-1; i+=2) {
                        if (indexes.size()>2) {
                            String name = matches.get(counter + (i / 4)).getParticipants().get((i % 4)/2).getName();
                            int start = (int) (((indexes.get(i) + indexes.get(i + 1))) / 2 - 1.5);
                            grid_sheet.addMergedRegion(new CellRangeAddress(start, start + 3, h, h + 1));
                            row = grid_sheet.createRow(start);
                            cell = row.createCell(h);
                            cell.setCellStyle(style);
                            cell.setCellValue(name);
                            if (i % 4 == 0) indexes2.add((double) (start));
                            else indexes2.add((double) (start + 3));
                        }
                        else {
                            String name = matches.get(matches.size()-1).getParticipants().get(1).getName();
                            int start = (int) (((indexes.get(i) + indexes.get(i + 1))) / 2 - 1.5);
                            grid_sheet.addMergedRegion(new CellRangeAddress(start, start + 3, h, h + 1));
                            row = grid_sheet.createRow(start);
                            cell = row.createCell(h);
                            cell.setCellStyle(style);
                            cell.setCellValue(name);
                        }
                    }
                    indexes = new ArrayList<Double>(indexes2);
                    level++;

                }
                counter+=(team_number/2);
                team_number /= 2;
                h+=3;
            }


            // Оформление листа Итого:
            Sheet result_sheet = workbook.createSheet("Итого");

            result_sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
            row = result_sheet.createRow(0);
            cell = row.createCell(0);
            cell.setCellStyle(centerStyle);
            cell.setCellValue(t.getName());


            result_sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 1));
            row = result_sheet.createRow(1);
            cell = row.createCell(0);
            cell.setCellStyle(centerStyle);
            cell.setCellValue("Результаты соревнований");

            for (int i = 0; i < min(4, teams.size()); i++) {
                row = result_sheet.createRow(2+i);
                row.createCell(0).setCellStyle(centerStyle);
                row.createCell(0).setCellValue(String.format("%s место", i));
                row.createCell(1).setCellStyle(centerStyle);
                int k = -1;
                for (int j = 0; j < teams.size(); j++) {
                    if (teams.get(j).getPosition() == (i+1)) {
                        k = j;
                        break;
                    }
                }
                if (k != -1) row.createCell(1).setCellValue(teams.get(k).getName());
            }

            row = result_sheet.createRow(6);
            row.createCell(0).setCellValue("Главный судья соревнований:");


            row = result_sheet.createRow(8);
//            row.createCell(0).setCellValue(profileRepo.getReferenceById(managerProfileId).getName());

            row = result_sheet.createRow(10);
            row.createCell(0).setCellValue("___________________________ (подпись)");


            row = result_sheet.createRow(12);
            row.createCell(0).setCellValue("Дата составления: " + df.format(new Date()));
            for (int i = 0; i < 2; i++) {
                result_sheet.autoSizeColumn(i);
            }


            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        }
        catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}