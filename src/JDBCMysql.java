/**
 * @author mutagen
 */
public class JDBCMysql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Object mysqlDrv =  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println(mysqlDrv);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
