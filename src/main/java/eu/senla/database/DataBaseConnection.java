package eu.senla.database;

import eu.senla.utilities.ReadPropertyFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DataBaseConnection {

    private static final String DBurl = ReadPropertyFile.getProperties("DB_URL");
    private static final String user = ReadPropertyFile.getProperties("DB_USERNAME");
    private static final String password = ReadPropertyFile.getProperties("DB_PASSWORD");

    private static final Logger log = LoggerFactory.getLogger(DataBaseConnection.class);

    private static Connection connection;

    // to remove
    private static Statement stmt = null;
    //    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    public static Connection connectToDB() {
        log.info("Connect to DB " + DBurl + " by " + user);

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(DBurl, user, password);
            log.info("Connection to DB successful!");

        } catch (SQLException e) {
            log.error("Connection to DB failed!\n" + e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
        }

        return connection;
    }

    public static String checkDatabase() throws SQLException {

        String selectQuery = "SELECT a.* FROM reg_office.applicants AS a";
        String value = null;
        try {
            stmt = connectToDB().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            log.info("Send request to DB: " + selectQuery);
            rs = stmt.executeQuery(selectQuery);
            if (rs.next()) {
                value = rs.getString(1);
            } else {
                value = null;
            }

        } finally {
            connection.close();
            return value;
        }
    }

    public static String getApplicationCount() throws SQLException {
        String query = "SELECT count(*) FROM reg_office.applications";
        String result = null;

        try{
            stmt = connectToDB().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            log.info("Send request to DB: " + query);
            rs = stmt.executeQuery(query);

            rs.next();
            result = rs.getString(1);
        }finally {
            connection.close();
            return result;
        }
    }

}
