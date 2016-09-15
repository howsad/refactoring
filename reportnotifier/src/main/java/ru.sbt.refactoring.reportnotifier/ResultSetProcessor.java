package ru.sbt.refactoring.reportnotifier;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alexander Ushakov on 15.09.2016.
 */
public class ResultSetProcessor {
    private static final String HTML_BEGIN = "<html><body><table><tr><td>Employee</td><td>Salary</td></tr>";
    private static final String ROW_START_TAG = "<tr>";
    private static final String ROW_END_TAG = "</tr>";
    private static final String CELL_START_TAG = "<td>";
    private static final String CELL_END_TAG = "</td>";
    private static final String TOTAL_ROW_BEGIN = "<tr><td>Total</td><td>";
    private static final String HTML_END = "</table></body></html>";

    public static String process(ResultSet results) throws SQLException {
        StringBuilder resultingHtml = new StringBuilder();
        resultingHtml.append(HTML_BEGIN);
        double totalSalary = 0;
        while (results.next()) {
            resultingHtml.append(ROW_START_TAG);
            String employeeName = results.getString("emp_name");
            resultingHtml.append(CELL_START_TAG).append(employeeName).append(CELL_END_TAG);
            double employeeSalary = results.getDouble("salary");
            resultingHtml.append(CELL_START_TAG).append(employeeSalary).append(CELL_END_TAG);
            resultingHtml.append(ROW_END_TAG);
            totalSalary += employeeSalary;
        }
        resultingHtml.append(TOTAL_ROW_BEGIN).append(totalSalary).append(CELL_END_TAG).append(ROW_END_TAG);
        resultingHtml.append(HTML_END);
        return resultingHtml.toString();
    }
}
