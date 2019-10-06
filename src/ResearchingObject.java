import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ResearchingObject {

    private String name;
    private String surname;

    private String passSerialNumber;

    private int    yearsOld;

    private String country;
    private String city;
    private String street;
    private int    house;

    private int[] illness;

    private HashMap<String, String> researchingObjectDataHashMap = new HashMap<>();

    private String visitDate;

    private boolean firstVisit;




    public ResearchingObject(String name, String surname, String passSerialNumber, int yearsOld, String country,
                             String city, String street, int house){

        this.name = name;
        this.surname = surname;

        this.passSerialNumber = passSerialNumber;

        this.yearsOld = yearsOld;

        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;

        objectDataIntoHashMap(name, surname, passSerialNumber, yearsOld, country, city, street, house);
    }






    public void researchingObjectDataPrint(){

        System.out.println("Patient UID: " + researchingObjectDataHashMap.get("uid"));
        System.out.println("First visit: " + researchingObjectDataHashMap.get("firstVisit"));
        System.out.println("Patient name: " + researchingObjectDataHashMap.get("name"));
        System.out.println("Patient surname: " + researchingObjectDataHashMap.get("surname"));
        System.out.println("Patient y/o: " + researchingObjectDataHashMap.get("yearsOld"));

        System.out.println("Patient pass serial number: " + researchingObjectDataHashMap.get("passSerialNumber"));

        System.out.println("Patient living location: " + "\"" + researchingObjectDataHashMap.get("location") + "\"");

        System.out.println("Visit date: " + researchingObjectDataHashMap.get("visitDateString"));

    }






    private void objectDataIntoHashMap(String name, String surname, String passSerialNumber, int yearsOld, String country,
                                                    String city, String street, int house){

        researchingObjectDataHashMap.put("name", name);
        researchingObjectDataHashMap.put("surname", surname);

        researchingObjectDataHashMap.put("passSerialNumber", passSerialNumber);

        researchingObjectDataHashMap.put("yearsOld", String.valueOf(yearsOld));

        researchingObjectDataHashMap.put("country", country);
        researchingObjectDataHashMap.put("city", city);
        researchingObjectDataHashMap.put("street", street);
        researchingObjectDataHashMap.put("house", String.valueOf(house));

        String location = "Country: " + country + ", city: " + city
                + ", street: " + street + ", house: " + house;

        researchingObjectDataHashMap.put("location", location);
        researchingObjectDataHashMap.put("visitDateInt", String.valueOf(visitDate));

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy'split'HH:mm");
        Date currentDate = new Date(System.currentTimeMillis());

        researchingObjectDataHashMap.put("visitDateString", parseVisitDate(formatter.format(currentDate)));

        researchingObjectDataHashMap.put("uid", createSeedFromDocuments());

    }





    private String parseVisitDate(String visitDate){

        String visitDateString;
        String month = "";
        String visitDateArray[] = String.valueOf(visitDate).split("split"); // DD:MM:YY

        String visitDateYear[] = visitDateArray[0].split("-");


        switch (visitDateYear[1]){
            case "01":
                month = "January";
                break;
            case "02":
                month = "February";
                break;
            case "03":
                month = "March";
                break;
            case "04":
                month = "April";
                break;
            case "05":
                month = "May";
                break;
            case "06":
                month = "June";
                break;
            case "07":
                month = "July";
                break;
            case "08":
                month = "August";
                break;
            case "09":
                month = "September";
                break;
            case "10":
                month = "October";
                break;
            case "11":
                month = "November";
                break;
            case "12":
                month = "December";
                break;
        }

        visitDateString = month + " " + visitDateYear[0] + ", " + visitDateYear[2] + "; (" + visitDateArray[1] + ")";


        return visitDateString;
    }



    public HashMap<String, String> getObjectData(){

        return researchingObjectDataHashMap;
    }

    public void setObjectDataVisit(Boolean isFirstVisit){
        researchingObjectDataHashMap.put("firstVisit", String.valueOf(isFirstVisit));
    }




    private String createSeedFromDocuments(){

        String nameUID = generateUID(researchingObjectDataHashMap.get("name"));
        String surnameUID = generateUID(researchingObjectDataHashMap.get("surname"));
        String passUID = researchingObjectDataHashMap.get("passSerialNumber");

        return nameUID + "-" + surnameUID + "-" + passUID;
    }





    private String generateUID(String stringToConvert){
        stringToConvert.toLowerCase();
        String tempString = "";
        char[] ch  = stringToConvert.toCharArray();
        for(char c : ch)
        {
            switch (c){
                case 'a' :
                    tempString += "7";
                    break;
                case 'b' :
                    tempString += "4";
                    break;
                case 'c' :
                    tempString += "1";
                    break;
                case 'd' :
                    tempString += "0";
                    break;
                case 'e' :
                    tempString += "7";
                    break;
                case 'f' :
                    tempString += "3";
                    break;
                case 'g' :
                    tempString += "9";
                    break;
                case 'h' :
                    tempString += "2";
                    break;
                case 'i' :
                    tempString += "6";
                    break;
                case 'j' :
                    tempString += "3";
                    break;
                case 'k' :
                    tempString += "11";
                    break;
                case 'l' :
                    tempString += "69";
                    break;
                case 'm' :
                    tempString += "3";
                    break;
                case 'n' :
                    tempString += "1";
                    break;
                case 'o' :
                    tempString += "52";
                    break;
                case 'p' :
                    tempString += "8";
                    break;
                case 'q' :
                    tempString += "43";
                    break;
                case 'r' :
                    tempString += "74";
                    break;
                case 's' :
                    tempString += "23";
                    break;
                case 't' :
                    tempString += "3";
                    break;
                case 'u' :
                    tempString += "2";
                    break;
                case 'v' :
                    tempString += "0";
                    break;
                case 'w' :
                    tempString += "63";
                    break;
                case 'x' :
                    tempString += "85";
                    break;
                case 'y' :
                    tempString += "4";
                    break;
                case 'z' :
                    tempString += "9";


                case '0' :
                    tempString += "7";
                    break;
                case '1' :
                    tempString += "3";
                    break;
                case '2' :
                    tempString += "235";
                    break;
                case '3' :
                    tempString += "0";
                    break;
                case '4' :
                    tempString += "00";
                    break;
                case '5' :
                    tempString += "000";
                    break;
                case '6' :
                    tempString += "3";
                    break;
                case '7' :
                    tempString += "21";
                    break;
                case '8' :
                    tempString += "1";
                    break;
                case '9' :
                    tempString += "11";


                default:
                    tempString += "5";
                    break;
            }
        }

        return tempString;

    }


}
