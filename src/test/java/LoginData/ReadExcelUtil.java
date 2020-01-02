package LoginData;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;


public class ReadExcelUtil {
    /**
     * read excel  利用poi来读取excel数据
     * @param
     * @return
     */
    public static List<Map<String, String>> getExcuteList(String filePath) {
        Workbook wb = null;
        //Sheet（工作表）
        Sheet sheet = null;
        //Row（行）  column（列）
        Row row = null;
        List<Map<String, String>> list = null;
        String cellData = null;
        //三个变量名称
        String columns[] = {"name", "pwd", "exp"};

        //自定义，readExcel()方法，返回一个Workbook
        wb = readExcel(filePath);
        if (wb != null) {
            //用来存放表中数据
            list = new ArrayList<Map<String, String>>();
            //获取到excel的第一个sheet页
            sheet = wb.getSheetAt(0);
            //获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row = sheet.getRow(0);
            //获取最大列数
            int column = row.getPhysicalNumberOfCells();
            System.out.println("列数："+column);
            System.out.println("行数："+rownum);

            for (int i = 1; i < rownum; i++) {
                //每一行的数据生成一个map，遍历获取每一行的内容
                Map<String, String> map = new LinkedHashMap<String, String>();
                row = sheet.getRow(i);
                if (row != null) {
                    for (int j = 0; j < column; j++) {
                        //获取excel中的内容
                        // cellData =(String) getCellFormatValue(row.getCell(j));
                        //简单的情况下这种方法好像也可以
                        cellData =row.getCell(j).toString();
                        map.put(columns[j], cellData);
                    }
                } else {
                    break;
                }
                list.add(map);
            }
        }
        return list;
    }

    /**
     * 判断excel文件的类型
     *
     * @param filePath
     * @return
     */
    public static Workbook readExcel(String filePath) {
        Workbook wb = null;
        if (filePath == null) {
            return null;
        }
        //获取excel文件后缀
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if (".xls".equals(extString)) {
                //如果后缀是.xls，声明HSSFWorkbook对象
                return wb = new HSSFWorkbook(is);
                //如果后缀是.xlsx,声明XSSFWorkbook对象
            } else if (".xlsx".equals(extString)) {
                return wb = new XSSFWorkbook(is);
            } else {
                return wb = null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }


    public static Object getCellFormatValue(Cell cell) {
        Object cellValue = null;
        if (cell != null) {
            //判断cell类型
            switch (cell.getCellType()) {
                case NUMERIC: {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                case FORMULA: {
                    //判断cell是否为日期格式
                    if (DateUtil.isCellDateFormatted(cell)) {
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    } else {
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case STRING: {
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        } else {
            cellValue = "";
        }
        return cellValue;
    }

    /**
     * 把不同类型的单元格转换成字符串，并返回
     * @param cell cell
     * @return 当个单元格值
     */
    public static String getCellValue2(Cell cell) {
        String value = "";
        switch (cell.getCellType()) {
            case STRING:
                value = String.valueOf(cell.getRichStringCellValue());
                return value;
            case NUMERIC:
                value = String.valueOf(cell.getNumericCellValue());
                return value;
            case BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                return value;

            case FORMULA:
                value = String.valueOf(cell.getCellFormula());
                return value;

            case ERROR:
                value = String.valueOf(cell.getErrorCellValue());
                return value;
            case BLANK:
                return value;
            default:
                return value;

        }
    }



}


