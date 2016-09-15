package ru.sbt.refactoring.reportnotifier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by Alexander Ushakov on 15.09.2016.
 */
public class SOLQueryHandler {
    private static final String DEFAULT_QUERY = "select emp.id as emp_id, emp.name as amp_name, sum(salary) as salary " +
            "from employee emp left join " +
            "salary_payments sp on emp.id = sp.employee_id " +
            "where emp.department_id = ? and " +
            "sp.date >= ? and sp.date <= ? " +
            "group by emp.id, emp.name";

    private static PreparedStatement prepareStatement(Connection connection, String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    public static ResultSet getResultSet(Connection connection, String departmentId,
                                         LocalDate dateFrom, LocalDate dateTo) throws SQLException {
        PreparedStatement ps = prepareStatement(connection, DEFAULT_QUERY);
        ps.setString(0, departmentId);
        ps.setDate(1, new java.sql.Date(dateFrom.toEpochDay()));
        ps.setDate(2, new java.sql.Date(dateTo.toEpochDay()));

        return ps.executeQuery();
    }
}
