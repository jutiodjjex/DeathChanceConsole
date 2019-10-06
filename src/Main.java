public class Main {

    public static void main(String[] args) {

        ResearchingObject researchTest = new ResearchingObject("Smeshnoy", "Stas", "901351", 66, "Ukraine", "Penza", "A", 53);


        researchTest.researchingObjectDataPrint();

        TestConnect mysqlConnect = new TestConnect();

        mysqlConnect.connect();

        mysqlConnect.checkIfFirstVisit(researchTest);
        mysqlConnect.putObjectDataInDatabase(researchTest.getObjectData());

        mysqlConnect.disconnect();

    }
}
