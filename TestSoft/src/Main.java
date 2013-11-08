import net.sf.jasperreports.engine.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Richi
 * Date: 31.10.13
 * Time: 18:51
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args){


        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "select * from table";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dexma", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        HashMap<String, Object> attrMap = new HashMap<String, Object>();

        attrMap.put("attrMap", new HashMap<>());
        attrMap.put("attrMap", new HashMap<>());

        JasperReport jasperReport;
        JasperPrint jasperPrint;
        try
        {

            jasperReport = JasperCompileManager.compileReport(
                    "reports/main.jrxml");
//            jasperPrint = JasperFillManager.fillReport(
//                    jasperReport, dataMap, conn);
//            JasperExportManager.exportReportToHtmlFile(
//                    jasperPrint, "reports/simple_report.html");
        }
        catch (JRException e)
        {
            e.printStackTrace();

        }
    }
}
