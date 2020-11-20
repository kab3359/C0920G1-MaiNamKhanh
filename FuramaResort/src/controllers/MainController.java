package controllers;

import models.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MainController {
    public  static Scanner input = new Scanner(System.in);
    public static Villa villa = new Villa();
    public static StringBuilder sb = new StringBuilder();
    public static final String VILLA_FILE = "src/data/Villa.csv";
    public static final String HOUSE_FILE = "src/data/House.csv";
    public static final String ROOM_FILE = "src/data/Room.csv";
    public static final String CUSTOMER_FILE = "src/data/Customer.csv";
    public static final String EMPLOYEE_FILE = "src/data/Employee.csv";
    public static final String COMMA = ",";
    public static List<String> listVilla;
    public static List<String> listHouse;
    public static List<String> listRoom;
    public static List<String> listCustomer;
    public static List<String> listEmployee;

    public static void  displayMainMenu(){
        String choose = null;
        boolean exit = true;
        while (exit){
            System.out.println("1. Add New Services");
            System.out.println("2. Show Services");
            System.out.println("3. Add New Customer");
            System.out.println("4. Show Information of Customer");
            System.out.println("5. Add New Booking");
            System.out.println("6. Show Information of Employee");
            System.out.println("7. Sell Ticket");
            System.out.println("8. Search Employee");
            System.out.println("9. Exit");
            choose = input.nextLine();
            switch (choose){
                case "1":
                    addNewServices();
                    break;
                case "2":
                    showServices();
                    break;
                case "3":
                    addNewCustomer();
                    break;
                case "4":
                    showInformationOfCustomer();
                    break;
                case "6":
                    showInformationOfEmployee();
                    break;
                case "7":
                    sellTicket();
                    break;
                case "8":
//                    searchEmployee();
                    break;
                case "0":
                    exit = false;
                    break;
                default:
                    System.out.println("sai");
            }
        }
    }
    public static void addNewServices() {
        String choose;
        boolean exit = true;
        while (exit) {
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back to menu");
            System.out.println("5. Exit");
            choose = input.nextLine();
            switch (choose) {
                case "1":
                    addVilla();
                    break;
                case "2":
                    addHouse();
                    break;
                case "3":
                    addRoom();
                    break;
                case "4":
                    displayMainMenu();
                    break;
                case "0":
                    exit = false;
                    break;
                default:
                    System.out.println("sai");
                    break;
            }
        }
    }
    public static void showServices(){
        System.out.println("1. Show all Villa");
        System.out.println("2. Show all House");
        System.out.println("3. Show all Room");
        System.out.println("4. Show All Name Villa Not Duplicate");
        System.out.println("5. Show All Name House Not Duplicate");
        System.out.println("6. Show All Name Name Not Duplicate");
        System.out.println("7. Back to menu");
        System.out.println("8. Exit");
        String choose = null;
        boolean exit = true;
        while (exit) {
            choose = input.nextLine();
            switch (choose) {
                case "1":
                    showVilla();
                    break;
                case "2":
                    showHouse();
                    break;
                case "3":
                    showRoom();
                    break;
                case "4":
                    showNameVillaNotDuplicate();

            }
        }
    }
    public static void addNewCustomer(){
        listCustomer = FileUtils.readFile(CUSTOMER_FILE);
        String ID = setID(listCustomer);
        System.out.println("ID: " + ID);
        System.out.println("Enter name:");
        String name = input.nextLine();
        name = checkType(name);
        System.out.println("Enter dateOfBirth:");
        String dateOfBirth = input.nextLine();
        dateOfBirth = checkDateOfBirth(dateOfBirth);
        System.out.println("Enter gender:");
        String gender = input.nextLine();
        gender = checkGender(gender);
        System.out.println("Enter cmnd:");
        String cmnd = input.nextLine();
        cmnd = checkIdCard(cmnd);
        System.out.println("Enter phone:");
        String phone = input.nextLine();
        phone = checkPhone(phone);
        System.out.println("Enter email:");
        String email = input.nextLine();
        email = checkEmail(email);
        String typeCustomer = inputTypeCustomer();
        System.out.println("Enter address:");
        String address = input.nextLine();
//        String choose = null;
//        boolean exit = true;
//        Villa villa1 = null;
//        while (exit){
//            System.out.println("1. Villa");
//            System.out.println("2. House");
//            System.out.println("3. Room");
//            choose = input.nextLine();
//            switch (choose){
//                case "1":
//                    showVilla();
//                    while (exit){
//                        System.out.println("chọn Villa");
//                        choose = input.nextLine();
//                        for(String villa : listVilla){
//                            String[] lineSplit = villa.split(COMMA);
//                            villa1 = new Villa(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5],
//                                    lineSplit[6], lineSplit[7], lineSplit[8], lineSplit[9]);
//                            if(choose.equals(villa1.getNameService())){
//                                customer.setServices(villa1);
//                                listCustomer1.add(customer);
//                                customer.showInfo();
//                                exit = false;
//                                break;
//                            }
//                        }
//                    }
//                    break;
//                default:
//                    System.out.println("sai");
//            }
//        }
        Customer customer = new Customer(ID, name, dateOfBirth, gender, cmnd, phone, email, typeCustomer, address);
        String line = customer.getID() + COMMA + customer.getName() + COMMA + customer.getDateOfBirth()
                + COMMA + customer.getGender() + COMMA + customer.getCmnd() + COMMA + customer.getPhone() + COMMA
                + customer.getEmail() + COMMA + customer.getType() + COMMA + customer.getAddress();
        FileUtils.writeFile(CUSTOMER_FILE, line);
    }

    public static void addNewBooking(){

    }

    private static String inputTypeCustomer() {
        System.out.println("Choose type: \n" +
                "1. Diamond \n" +
                "2. Platinum \n" +
                "3. Gold \n" +
                "4. Silver \n" +
                "5. Member");
        String type;
        boolean check;
        do{
            check = false;
            type = input.nextLine();
            switch (type){
                case "1":
                    type = "Diamond";
                    break;
                case "2":
                    type = "Platinum";
                    break;
                case "3":
                    type = "Gold";
                    break;
                case "4":
                    type = "Silver";
                    break;
                case "5":
                    type = "Member";
                    break;
                default:
                    System.out.println("chọn lại");
                    check = true;
            }
        }while (check);
        return type;
    }

    public static String setID(List<String> list){
        return list.size() == 0 ? "1" : Integer.parseInt(String.valueOf(list.get(list.size()-1).charAt(0)))+1+"";
    }

    public static void addVilla(){
//        listVilla = FileUtils.readFile(VILLA_FILE);
//        String ID = setID(listVilla);
//        System.out.println("ID: " + ID);
        System.out.println("Enter ID");
        String ID = input.nextLine();
        ID = checkID(ID, "VL");
        System.out.println("Enter nameService");
        String nameService = input.nextLine();
        nameService = checkType(nameService);
        System.out.println("Enter areaUsed");
        String areaUsed = input.nextLine();
        areaUsed = checkArea(areaUsed);
        System.out.println("Enter costRent");
        String costRent = input.nextLine();
        costRent = checkCostRent(costRent);
        System.out.println("Enter numPeople");
        String numPeople = input.nextLine();
        numPeople = checkNumPeople(numPeople);
        System.out.println("Enter typeRent") ;
        String typeRent = input.nextLine();
        typeRent = checkTypeRent(typeRent);
        System.out.println("Enter standardRoom");
        String standardRoom = input.nextLine();
        standardRoom = checkType(standardRoom);
        System.out.println("Enter descriptionComfort");
        String descriptionComfort = input.nextLine();
        System.out.println("Enter areaPool");
        String areaPool = input.nextLine();
        areaPool = checkArea(areaPool);
        System.out.println("Enter numFloor");
        String numFloor = input.nextLine();
        numFloor = checkNumFloor(numFloor);
        Villa villa = new Villa(ID, nameService, areaUsed, costRent, numPeople, typeRent, standardRoom, descriptionComfort,
                areaPool, numFloor);
        String line = villa.getId() + COMMA + villa.getNameService() + COMMA + villa.getAreaUsed() + COMMA + villa.getCostRent()
                + COMMA + villa.getNumPeople() + COMMA + villa.getTypeRent() + COMMA + villa.getStandardRoom()
                + COMMA + villa.getDescriptionComfort() + COMMA + villa.getAreaPool() + COMMA + villa.getNumFloor();
        FileUtils.writeFile(VILLA_FILE, line);
    }

    private static String checkType(String type) {
        while (!Validate.checkServiceName(type)){
            System.err.println("Định dạng kiểu sai - kiểu phải viết in hoa chữ đầu và ko có số hoặc kí tự đặc biệt");
            type = input.nextLine();
        }
        return type;
    }
    private static String checkID(String ID, String type) {
        while (!Validate.checkID(ID, type)){
            System.err.println("Định dạng phải theo kiểu SVXX-YYYY, với YYYY là các số từ 0-9, XX thì theo VL, HO, RO");
            ID = input.nextLine();
        }
        return ID;
    }
    private static String checkPhone(String type){
        while (!Validate.checkPhone(type)){
            System.err.println("phone phải có định dạng 0-XXXXXXXXX hoặc 84-XXXXXXXXX, trong đó X là 1 số");
            type = input.nextLine();
        }
        return type;
    }
    private static String checkIdCard(String type){
        while (!Validate.checkIdCard(type)){
            System.err.println("Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX");
            type = input.nextLine();
        }
        return type;
    }
    private static String checkDateOfBirth(String type){
        while (!Validate.checkDateOfBirth(type)){
            System.err.println("ngày tháng năm sinh phải theo dd/mm/yyyy và năm sinh phải từ 1901 - 2002");
            type = input.nextLine();
        }
        return type;
    }
    private  static String checkGender(String type){
        while (!Validate.checkGender(type)){
            System.err.println("Gender phải có định đạng: Male, Female, Unknown");
            type = input.nextLine();
        }
        type = type.toLowerCase();
        if (type.equals("male")){
            type = "Male";
        }else if (type.equals("female")){
            type = "Female";
        }else if (type.equals("unknown")){
            type = "Known";
        }
        return type;
    }
    private static String checkEmail(String type){
        while (!Validate.checkEmail(type)){
            System.err.println("Email phải có định dạng abc@abc.abc");
            type = input.nextLine();
        }
        return type;
    }
    private static String checkTypeRent(String type){
        while (!Validate.checkTypeRent(type)){
            System.err.println("Chọn Year, Month, Date, Hour");
            type = input.nextLine();
        }
        return type;
    }

    private static String checkArea(String area) {
        boolean check = true;
        while (check){
            try{
                while (!Validate.checkArea(Double.parseDouble(area))){
                    System.err.println("Diện tích phải lớn hơn 30");
                    area = input.nextLine();
                }
                check = false;
            }catch (NumberFormatException e){
                System.err.println("phải nhập một số");
                area = input.nextLine();
            }
        }
        return area;
    }
    private static String checkCostRent(String costRent) {
        boolean check = true;
        while (check){
            try{
                while (!Validate.checkCostRent(Double.parseDouble(costRent))){
                    System.err.println("Chi phí thuê phải lớn hơn 0");
                    costRent = input.nextLine();
                }
                check = false;
            }catch (NumberFormatException e){
                System.err.println("phải nhập một số");
                costRent = input.nextLine();
            }
        }
        return costRent;
    }
    private static String checkNumFloor(String num) {
        boolean check = true;
        while (check){
            try{
                while (!Validate.checkNumFloor(Integer.parseInt(num))){
                    System.err.println("Chi phí thuê phải lớn hơn 0");
                    num = input.nextLine();
                }
                check = false;
            }catch (NumberFormatException e){
                System.err.println("phải nhập một số");
                num = input.nextLine();
            }
        }
        return num;
    }

    private static String checkNumPeople(String numPeople) {
        boolean check = true;
        while (check){
            try{
                while (!Validate.checkNumPeople(Integer.parseInt(numPeople))){
                    System.err.println("Số lượng người phải lớn hơn 0 và nhỏ hơn 20");
                    numPeople = input.nextLine();
                }
                check = false;
            }catch (NumberFormatException e){
                System.err.println("phải nhập một số");
                numPeople = input.nextLine();
            }
        }
        return numPeople;
    }

    public static void addHouse(){
//        listHouse = FileUtils.readFile(HOUSE_FILE);
//        String ID = setID(listHouse);
//        System.out.println("ID: " + ID);
        System.out.println("Enter ID");
        String ID = input.nextLine();
        ID = checkID(ID, "HO");
        System.out.println("Enter nameService");
        String nameService = input.nextLine();
        nameService = checkType(nameService);
        System.out.println("Enter areaUsed");
        String areaUsed = input.nextLine();
        areaUsed = checkArea(areaUsed);
        System.out.println("Enter costRent");
        String costRent = input.nextLine();
        costRent = checkCostRent(costRent);
        System.out.println("Enter numPeople");
        String numPeople = input.nextLine();
        numPeople = checkNumPeople(numPeople);
        System.out.println("Enter typeRent") ;
        String typeRent = input.nextLine();
        typeRent = checkType(typeRent);
        System.out.println("Enter standardRoom");
        String standardRoom = input.nextLine();
        standardRoom = checkType(standardRoom);
        System.out.println("Enter descriptionComfort");
        String descriptionComfort = input.nextLine();
        System.out.println("Enter numFloor");
        String numFloor = input.nextLine();
        numFloor = checkNumFloor(numFloor);
        House house = new House(ID, nameService, areaUsed, costRent, numPeople, standardRoom, typeRent, descriptionComfort, numFloor);
        String line = house.getId() + COMMA + house.getNameService() + COMMA + house.getAreaUsed() + COMMA + house.getCostRent()
                + COMMA + house.getNumPeople() + COMMA + house.getTypeRent() + COMMA + house.getStandardRoom()
                + COMMA + house.getDescriptionComfort() + COMMA + house.getNumFloor();
        FileUtils.writeFile(HOUSE_FILE, line);
    }
    public static void addRoom(){
//        listRoom = FileUtils.readFile(ROOM_FILE);
//        String ID = setID(listRoom);
//        System.out.println("ID: " + ID);
        System.out.println("Enter ID");
        String ID = input.nextLine();
        ID = checkID(ID, "RO");
        System.out.println("Enter nameService");
        String nameService = input.nextLine();
        nameService = checkType(nameService);
        System.out.println("Enter areaUsed");
        String areaUsed = input.nextLine();
        areaUsed = checkArea(areaUsed);
        System.out.println("Enter costRent");
        String costRent = input.nextLine();
        costRent = checkCostRent(costRent);
        System.out.println("Enter numPeople");
        String numPeople = input.nextLine();
        numPeople = checkNumPeople(numPeople);
        System.out.println("Enter typeRent") ;
        String typeRent = input.nextLine();
        typeRent = checkType(typeRent);
        System.out.println("Enter freeService");
        String freeService = input.nextLine();
        Room room = new Room(ID, nameService, areaUsed, costRent, numPeople, typeRent, freeService);
        String line = room.getId() + COMMA + room.getNameService() + COMMA + room.getAreaUsed() + COMMA + room.getCostRent()
                + COMMA + room.getNumPeople() + COMMA + room.getTypeRent() + COMMA + room.getFreeService();
        FileUtils.writeFile(ROOM_FILE, line);
    }

    public static void showVilla(){
        listVilla = FileUtils.readFile(VILLA_FILE);
        System.out.println("Show All Villa");
        for (String villa: listVilla) {
            String[] lineSplit = villa.split(COMMA);
            Villa villa1 = new Villa(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5],
                    lineSplit[6], lineSplit[7], lineSplit[8], lineSplit[9]);
            villa1.showInfo();
        }
        showServices();
    }

    public static void showHouse(){
        listHouse = FileUtils.readFile(HOUSE_FILE);
        System.out.println("Show All House");
        for (String house: listHouse){
            String[] lineSplit = house.split(COMMA);
            House house1 = new House(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5],
                    lineSplit[6], lineSplit[7], lineSplit[8]);
            house1.showInfo();
        }
        showServices();
    }
    public static void showRoom(){
        listRoom = FileUtils.readFile(ROOM_FILE);
        System.out.println("Show All Room");
        for (String room: listRoom){
            String[] lineSplit = room.split(COMMA);
            Room room1 = new Room(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5], lineSplit[6]);
            room1.showInfo();
        }
        showServices();
    }
    public static void showInformationOfCustomer(){
        listCustomer = FileUtils.readFile(CUSTOMER_FILE);
        ArrayList<Customer> listCustomer1 = new ArrayList<>();
        System.out.println("Show All Customer");
        for (String customer: listCustomer){
            String[] lineSplit = customer.split(COMMA);
            Customer customer1 = new Customer(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5],
                    lineSplit[6], lineSplit[7], lineSplit[8]);
            listCustomer1.add(customer1);
        }
        Collections.sort(listCustomer1, new SortCustomer());
        for (Customer list: listCustomer1){
            list.showInfo();
        }
        System.out.println("-------------------------------------------------");
    }
    public static void showNameVillaNotDuplicate(){
        listVilla = FileUtils.readFile(VILLA_FILE);
        TreeSet<String> listVillaNotDuplicate = new TreeSet<>();
        for (String list : listVilla){
            String[] lineSplit = list.split(COMMA);
            listVillaNotDuplicate.add(lineSplit[1]);
        }
        System.out.println("Danh sách tên các Villa ko trùng nhau: " + listVillaNotDuplicate);
        showServices();
    }
    public static void showInformationOfEmployee(){
        listEmployee = FileUtils.readFile(EMPLOYEE_FILE);
        Map<String, Object> employee = new TreeMap<>();
        for (String elementEmployee: listEmployee){
            String[] lineSplit = elementEmployee.split(COMMA);
            Employee employee1 = new Employee(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3]);
            employee.put(lineSplit[0], employee1);
        }
        System.out.println(employee);
    }
    public static void sellTicket(){
        Queue queue = new LinkedList();
        System.out.println("nhập số lượng vé trong ngày");
        int numTicket = input.nextInt();
        input.nextLine();
        do {
            System.out.println("nhập tên khách hàng");
            String name = input.nextLine();
            switch (name){
                case "DISPLAY":
                    System.out.println("Danh sách khách hàng mua vé trong ngày: " + queue);
                    break;
                default:
                    queue.add(name);
                    numTicket--;
                    System.out.println("số vé còn lại: " + numTicket);
            }
        }while (numTicket != 0);
        System.out.println("Danh sách khách hàng mua vé trong ngày: " + queue);
    }
//    public static void searchEmployee(){
//        listEmployee = FileUtils.readFile(EMPLOYEE_FILE);
//        Stack filingCabinets = new Stack();
//        Employee employee1 = null;
//        for (String elementEmployee: listEmployee){
//            String[] lineSplit = elementEmployee.split(COMMA);
//            employee1 = new Employee(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3]);
//            filingCabinets.push(employee1);
//        }
//        System.out.println("nhập tên nhân viên cần tìm:");
//        String name = input.nextLine();
//        if (name == employee1.getName())
//        System.out.println(filingCabinets.);
//    }

}


