package eu.senla.database;

import eu.senla.responses.getApplication.ApplicationData;
import eu.senla.utilities.ReadPropertyFile;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

    private static final String DB_URL = ReadPropertyFile.getProperties("DB_URL");
    private static final String DB_USERNAME = ReadPropertyFile.getProperties("DB_USERNAME");
    private static final String DB_PASSWORD = ReadPropertyFile.getProperties("DB_PASSWORD");

//    private static final Logger log = LoggerFactory.getLogger(DataBaseConnection.class);

    private static String executeQuery(final String query, final String columnName) throws SQLException {
        String result;
        try (
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            resultSet.next();

            result = resultSet.getString(columnName);
        }
        return result;
    }

    private static ApplicationData executeQuery(final String query) throws SQLException {
        ApplicationData applicationData = new ApplicationData();
        try (
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            resultSet.next();
            System.out.println("ResultSet = " + resultSet.toString());
            applicationData.setCitizenId(resultSet.getInt("citizenid"));
            applicationData.setApplicantId(resultSet.getInt("applicantid"));
            applicationData.setStaffId(resultSet.getInt("staffid"));
            applicationData.setDateOfApplication(resultSet.getString("dateofapplication"));
            applicationData.setKindOfApplication(resultSet.getString("kindofapplication"));
            applicationData.setStatusOfApplication(resultSet.getString("statusofapplication"));
            applicationData.setChannel(resultSet.getString("channel"));
        }
        return applicationData;
    }

    public static String getApplicationCount() throws SQLException {
        String columnName = "applicationCount";
        String query = "SELECT count(*) AS " + columnName + " FROM reg_office.applications";
        return executeQuery(query, columnName);
    }

    public static ApplicationData getApplicationData(final int applicationId) throws SQLException {
        String query = "SELECT * FROM reg_office.applications WHERE applicationid = " + applicationId;
        return executeQuery(query);
    }
}
