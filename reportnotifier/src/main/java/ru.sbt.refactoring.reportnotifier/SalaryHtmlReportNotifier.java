package ru.sbt.refactoring.reportnotifier;

import javax.mail.MessagingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SalaryHtmlReportNotifier {
    private final Connection connection;

    public SalaryHtmlReportNotifier(Connection databaseConnection) {
        this.connection = databaseConnection;
    }

    public void generateAndSendHtmlSalaryReport(String departmentId, LocalDate dateFrom, LocalDate dateTo, String recipients) {
        try {
            ResultSet results = SOLQueryHandler.getResultSet(connection, departmentId, dateFrom, dateTo);
            String htmlMessageText = ResultSetProcessor.process(results);
            new MessageSender().sendMessage(recipients, htmlMessageText);
        } catch (SQLException | MessagingException e) {
            e.printStackTrace();
        }
    }
}