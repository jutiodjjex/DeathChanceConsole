

import java.sql.*;
import java.util.HashMap;
import java.util.Properties;

public class TestConnect {
    // init database constants
    private static final String DATABASE_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/patientbd?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // init connection object
    private Connection connection;
    // init properties object
    private Properties properties;

    // create properties
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
        }
        return properties;
    }

    // connect database
    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void putObjectDataInDatabase(HashMap<String, String> objectDataHashMap){
        try {
            String query = " insert into patients (uid, firstVisit, name, surname, passSerialNumber, yearsOld, country, city, street, house, visitDate, location)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);

            preparedStmt.setString(1, objectDataHashMap.get("uid"));
            preparedStmt.setString(2, objectDataHashMap.get("firstVisit"));
            preparedStmt.setString(3, objectDataHashMap.get("name"));
            preparedStmt.setString(4, objectDataHashMap.get("surname"));
            preparedStmt.setString(5, objectDataHashMap.get("passSerialNumber"));
            preparedStmt.setString(6, objectDataHashMap.get("yearsOld"));
            preparedStmt.setString(7, objectDataHashMap.get("country"));
            preparedStmt.setString(8, objectDataHashMap.get("city"));
            preparedStmt.setString(9, objectDataHashMap.get("street"));
            preparedStmt.setString(10, objectDataHashMap.get("house"));
            preparedStmt.setString(11, objectDataHashMap.get("visitDateString"));
            preparedStmt.setString(12, objectDataHashMap.get("location"));

            preparedStmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void checkIfFirstVisit(ResearchingObject patient){

        String query = "SELECT uid FROM patients";
        String oldId = patient.getObjectData().get("uid");

        boolean ifFirstVisit = false;
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            if(rs == null)
                ifFirstVisit = true;

            while (rs.next())
            {
                String id = rs.getString("uid");

                if(oldId.equals(id)){
                    ifFirstVisit = false;
                } else {
                    ifFirstVisit =  true;
                }
            }
            st.close();

            patient.setObjectDataVisit(ifFirstVisit);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // disconnect database
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
