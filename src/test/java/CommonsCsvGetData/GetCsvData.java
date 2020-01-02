package CommonsCsvGetData;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaofenShentu on 2019/12/24 15:00
 */
public class GetCsvData {
    static final String filePath = "D:\\IDEA\\Workspace\\com.TestNG\\src\\test\\java\\LoginData";

    @DataProvider
    public Object[][] getData() {
        List<Object[]> list = new LinkedList<Object[]>();

        try {
            FileReader reader = new FileReader(filePath + "\\bug.csv");
            CSVParser parser = CSVFormat.DEFAULT.withHeader("name", "pwd", "exp").parse(reader);
            for (CSVRecord record : parser) {
                Object[] data = new Object[3];
                data[0] = record.get("name");
                data[1] = record.get("pwd");
                data[2] = record.get("exp");
                list.add(data);
            } reader.close();
        } catch (Exception E) {

        }

        Object[][] datas=new Object[list.size()][];
        for (int i = 0; i <list.size() ; i++) {
            datas[i]=list.get(i);
        }

         return datas;

    }

    /**
     * 注意需要是csv格式的excl，否则写入的文件会在同一列单元格
     */

    @Test
    public void write() throws IOException {
        File file = new File(filePath+"\\bug.csv");
        if (!file.exists()) {
            file.createNewFile();
        }
        Appendable printWriter = new PrintWriter(file);//指定GBK,解决Microsoft不兼容
        CSVPrinter csvPrinter = CSVFormat.EXCEL.withHeader("name","pwd", "exp").print(printWriter);
        csvPrinter.printRecord("stxf", "123456","LoginSuccess");
        csvPrinter.printRecord("admin", "admin","LoginSuccesAdmin");
        csvPrinter.printRecord("zhangsan", "123456","LoginnameOrPasswordIsError");
        csvPrinter.printRecord("admin", "","用户名或密码不能为空");


        csvPrinter.flush();
        csvPrinter.close();
    }




}