package com.ldxx.util;

import com.ldxx.bean.DicPeifangjipei;
import com.ldxx.dao.DicPeifangjipeiDao;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ExcelUtils {

    @Autowired
    private DicPeifangjipeiDao jipeidao;

    private static ExcelUtils excelUtils;

    @PostConstruct
    public void init(){
        excelUtils = this;
    }

    public static List<DicPeifangjipei> excelToShopIdList(InputStream inputStream,String pfId,String pfName) {

        List<DicPeifangjipei> list = new ArrayList<>();
        //创建Excel工作薄
        Workbook  work=null;
        try {
            work = WorkbookFactory.create(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Sheet sheet = null;
        Row row = null;
        // 循环工作表Sheet
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }
            // 循环行Row()15-19行
            for (int j = 15; j <= 19; j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }else{
                    DicPeifangjipei jipei=new DicPeifangjipei();
                    //获取固定单元格
                    Cell cell = row.getCell(0);
                    Cell cell1 = row.getCell(1);//集料名称(代号)
                    Cell cell2 = row.getCell(2);
                    Cell cell3 = row.getCell(3);//37.5
                    Cell cell4 = row.getCell(4);//31.5
                    Cell cell5 = row.getCell(5);//26.5
                    Cell cell6 = row.getCell(6);//19
                    Cell cell7 = row.getCell(7);//16
                    Cell cell8 = row.getCell(8);//13.2
                    Cell cell9 = row.getCell(9);//9.5
                    Cell cell10 = row.getCell(10);//4.75
                    Cell cell11 = row.getCell(11);//2.36
                    Cell cell12 = row.getCell(12);//1.18
                    Cell cell13 = row.getCell(13);//0.6
                    Cell cell14 = row.getCell(14);//0.3
                    Cell cell15 = row.getCell(15);//0.15
                    Cell cell16 = row.getCell(16);//0.075

                    String value1 = getCellValue(cell1);
                    if(value1!=null&&value1!=""){
                        int countName = excelUtils.jipeidao.getCountName(value1, pfId);
                        if(countName>0){
                            continue;
                        }

                        jipei.setId(LDXXUtils.getUUID12());
                        jipei.setName(value1);
                        jipei.setPeifangId(pfId);
                        jipei.setPeifangName(pfName);
                        String mark;
                        switch (value1){
                            case "5#仓":
                                mark="5";
                                break;
                            case  "4#仓":
                                mark="4";
                                break;
                            case  "3#仓":
                                mark="3";
                                break;
                            case  "2#仓":
                                mark="2";
                                break;
                            case  "矿粉":
                                mark="kf";
                                break;
                            default:
                                mark ="";
                                break;
                        }
                        jipei.setMark(mark);

                        String value4 = getCellValue(cell4);
                        if(value4!="/"&&!"/".equals(value4)){
                            BigDecimal bigDecimal = new BigDecimal(value4);
                            jipei.setRate315(BigDecimal.ZERO.add(bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP)));
                        }
                        String value5 = getCellValue(cell5);
                        if(value5!="/"&&!"/".equals(value5)){
                            BigDecimal bigDecimal = new BigDecimal(value5);
                            jipei.setRate265(BigDecimal.ZERO.add(bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP)));
                        }
                        String value6 = getCellValue(cell6);
                        if(value6!="/"&&!"/".equals(value6)){
                            BigDecimal bigDecimal = new BigDecimal(value6);
                            jipei.setRate19(BigDecimal.ZERO.add(bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP)));
                        }
                        String value7 = getCellValue(cell7);
                        if(value7!="/"&&!"/".equals(value7)){
                            BigDecimal bigDecimal = new BigDecimal(value7);
                            jipei.setRate16(BigDecimal.ZERO.add(bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP)));
                        }
                        String value8 = getCellValue(cell8);
                        if(value8!="/"&&!"/".equals(value8)){
                            BigDecimal bigDecimal = new BigDecimal(value8);
                            jipei.setRate132(BigDecimal.ZERO.add(bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP)));
                        }
                        String value9 = getCellValue(cell9);
                        if(value9!="/"&&!"/".equals(value9)){
                            BigDecimal bigDecimal = new BigDecimal(value9);
                            jipei.setRate95(BigDecimal.ZERO.add(bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP)));
                        }
                        String value10 = getCellValue(cell10);
                        if(value10!="/"&&!"/".equals(value10)){
                            BigDecimal bigDecimal = new BigDecimal(value10);
                            jipei.setRate475(BigDecimal.ZERO.add(bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP)));
                        }
                        String value11 = getCellValue(cell11);
                        if(value11!="/"&&!"/".equals(value11)){
                            BigDecimal bigDecimal = new BigDecimal(value11);
                            jipei.setRate236(BigDecimal.ZERO.add(bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP)));
                        }
                        String value12 = getCellValue(cell12);
                        if(value12!="/"&&!"/".equals(value12)){
                            BigDecimal bigDecimal = new BigDecimal(value12);
                            jipei.setRate118(BigDecimal.ZERO.add(bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP)));
                        }
                        String value13 = getCellValue(cell13);
                        if(value13!="/"&&!"/".equals(value13)){
                            BigDecimal bigDecimal = new BigDecimal(value13);
                            jipei.setRate06(BigDecimal.ZERO.add(bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP)));
                        }
                        String value14 = getCellValue(cell14);
                        if(value14!="/"&&!"/".equals(value14)){
                            BigDecimal bigDecimal = new BigDecimal(value14);
                            jipei.setRate03(BigDecimal.ZERO.add(bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP)));
                        }
                        String value15 = getCellValue(cell15);
                        if(value15!="/"&&!"/".equals(value15)){
                            BigDecimal bigDecimal = new BigDecimal(value15);
                            jipei.setRate015(BigDecimal.ZERO.add(bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP)));
                        }
                        String value16 = getCellValue(cell16);
                        if(value16!="/"&&!"/".equals(value16)){
                            BigDecimal bigDecimal = new BigDecimal(value16);
                            jipei.setRate0075(BigDecimal.ZERO.add(bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP)));
                        }
                        list.add(jipei);
                    }
                }

            }
        }

        return list;
   }


    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        //判断数据的类型
        //判断数据的类型
        switch (cell.getCellTypeEnum()) {
            case NUMERIC: //数字
                cellValue = stringDateProcess(cell);
                break;
            case STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case BLANK: //空值
                cellValue = "";
                break;
            case ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }


    public static String stringDateProcess(Cell cell) {
        String result = new String();
        if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
            SimpleDateFormat sdf = null;
            if (cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
                sdf = new SimpleDateFormat("HH:mm");
            } else {// 日期
                sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            }
            Date date = cell.getDateCellValue();
            result = sdf.format(date);
        } else if (cell.getCellStyle().getDataFormat() == 58) {
            // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            double value = cell.getNumericCellValue();
            Date date = org.apache.poi.ss.usermodel.DateUtil
                    .getJavaDate(value);
            result = sdf.format(date);
        } else {
            double value = cell.getNumericCellValue();
            CellStyle style = cell.getCellStyle();
            DecimalFormat format = new DecimalFormat();
            String temp = style.getDataFormatString();
            // 单元格设置成常规
            if (temp.equals("General")) {
                format.applyPattern("#");
            }
            result = format.format(value);
        }

        return result;
    }
}
