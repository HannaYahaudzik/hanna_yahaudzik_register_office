package eu.senla.database;

import eu.senla.responses.getApplication.ApplicationData;
import eu.senla.utilities.ReadPropertyFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DataBaseConnection {

    private static final String DB_URL = ReadPropertyFile.getProperties("DB_URL");
    private static final String DB_USERNAME = ReadPropertyFile.getProperties("DB_USERNAME");
    private static final String DB_PASSWORD = ReadPropertyFile.getProperties("DB_PASSWORD");

    private static final Logger LOGGER = LoggerFactory.getLogger(DataBaseConnection.class);

    private static String executeQuery(final String query, final String columnName) throws SQLException {
        String result;
        try (
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            LOGGER.info("Connection to DB is successful!\nBD query was sent: " + query);
            resultSet.next();
            result = resultSet.getString(columnName);
        }
        return result;
    }

    private static ApplicationData executeQuery(final String query, final int applicationId) throws SQLException {
        try (
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            LOGGER.info("Connection to DB is successful!\nBD query was sent:\n" + query);
            resultSet.next();
            return new ApplicationData(
                    applicationId,
                    resultSet.getInt("citizenid"),
                    resultSet.getInt("applicantid"),
                    (resultSet.getInt("staffid") != 0 ? resultSet.getInt("staffid") : null),
                    resultSet.getString("dateofapplication"),
                    resultSet.getString("kindofapplication"),
                    resultSet.getString("statusofapplication"),
                    resultSet.getString("channel"),
                    null
            );
        }
    }

    public static String getApplicationCount() throws SQLException {
        String columnName = "applicationCount";
        String query = "SELECT count(*) AS " + columnName + " FROM reg_office.applications";
        return executeQuery(query, columnName);
    }

    public static ApplicationData getApplicationData(final int applicationId) throws SQLException {
        String query = "SELECT channel, image , a.staffid , a.citizenid ,a.applicantid ,a.applicationid ,a.dateofapplication , "
                + "a.kindofapplication ,a.statusofapplication \n"
                + "FROM reg_office.applications a\n"
                + "inner join reg_office.citizens c on c.citizenid = a.citizenid\n"
                + "WHERE applicationid = " + applicationId;
        return executeQuery(query, applicationId);
    }

    private DataBaseConnection() {

    }
}
