package team.selfChoice.Excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import team.selfChoice.Entity.AbsoluteTeam;
import team.selfChoice.Entity.Player;
import team.selfChoice.Entity.Profile;
import team.selfChoice.Entity.Team;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelFileExporter {
    public static ByteArrayInputStream ProfileToExcelFile(Long id) {
        try(Workbook workbook = new XSSFWorkbook()){
            Sheet sheet = workbook.createSheet("Player");
            Profile profile = new Profile(1L, "name", "nickname", new Date(System.currentTimeMillis()), true, "RU", 1, new ArrayList<AbsoluteTeam>(), "88005553535", "some_info");

            Row dataRow = sheet.createRow(1);
            dataRow.createCell(0).setCellValue(profile.getId());
            dataRow.createCell(1).setCellValue(profile.getName());
            dataRow.createCell(2).setCellValue(profile.getNickname());
            dataRow.createCell(3).setCellValue(profile.getBirthday());
            dataRow.createCell(4).setCellValue(profile.isMale());
            dataRow.createCell(5).setCellValue(profile.getCountry());
            dataRow.createCell(6).setCellValue(profile.getCategory());
            dataRow.createCell(7).setCellValue(profile.getContacts());
            dataRow.createCell(8).setCellValue(profile.getDescription());

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
