package controllers;

import commons.FileUtils;
import commons.Validate;
import models.*;


import java.io.BufferedWriter;
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
    public static final String BOOKING_FILE = "src/data/Booking.csv";
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
            System.out.println("~~~~~~~~~~~MAIN MENU~~~~~~~~~~~~~~");
            System.out.println("1. Add New Services");
            System.out.println("2. Show Services");
            System.out.println("3. Add New Customer");
            System.out.println("4. Show Information of Customer");
            System.out.println("5. Add New Booking");
            System.out.println("6. Show Information of Employee");
            System.out.println("7. Sell Ticket");
            System.out.println("8. Delete Customer");
            System.out.println("9. Edit Customer");
            System.out.println("10. Search Customer");
            System.out.println("0. Exit");
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
                case "5":
                    addNewBooking();
                    break;
                case "6":
                    showInformationOfEmployee();
                    break;
                case "7":
                    sellTicket();
                    break;
                case "8":
                    delete(VILLA_FILE);
                    break;
                case "9":
                    edit();
                    break;
                case "10":
                    searchCustomer();
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
            System.out.println("~~~~~Add New Services~~~~~~~");
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
        System.out.println("~~~~~~~~~Show Services~~~~~~~~~~~~~");
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
                    show(VILLA_FILE);
                    break;
                case "2":
                    show(HOUSE_FILE);
                    break;
                case "3":
                    show(ROOM_FILE);
                    break;
                case "4":
                    showNameNotDuplicate(VILLA_FILE);
                    break;
                case "5":
                    showNameNotDuplicate(HOUSE_FILE);
                    break;
                case "6":
                    showNameNotDuplicate(ROOM_FILE);
                    break;
                case "7":
                    displayMainMenu();
                    break;
                case "8":
                    System.exit(0);
                    break;
                default:
                    System.out.println("chọn lại");
            }
        }
    }
    public static void addNewCustomer(){
        listCustomer = FileUtils.readFile(CUSTOMER_FILE);
        String ID = setID(listCustomer);
        System.out.println("ID: " + ID);
        String name = inputName("Enter name:");
        String dateOfBirth = inputDateOfBirth();
        String gender = inputGender();
        String cmnd = inputCmnd();
        String phone = inputPhone();
        String email = inputEmail();
        String typeCustomer = inputTypeCustomer();
        String address = inputAddress();
        Customer customer = new Customer(ID, name, dateOfBirth, gender, cmnd, phone, email, typeCustomer, address);
        String line = customer.getID() + COMMA + customer.getName() + COMMA + customer.getDateOfBirth()
                + COMMA + customer.getGender() + COMMA + customer.getCmnd() + COMMA + customer.getPhone() + COMMA
                + customer.getEmail() + COMMA + customer.getType() + COMMA + customer.getAddress();
        FileUtils.writeFile(CUSTOMER_FILE, line, true);
        System.out.println("Thêm thành công");
    }

    private static String inputAddress() {
        System.out.println("Enter address:");
        return input.nextLine();
    }

    private static String inputEmail() {
        System.out.println("Enter email:");
        String email = input.nextLine();
        email = checkEmail(email);
        return email;
    }

    private static String inputPhone() {
        System.out.println("Enter phone:");
        String phone = input.nextLine();
        phone = checkPhone(phone);
        return phone;
    }

    private static String inputCmnd() {
        System.out.println("Enter cmnd:");
        String cmnd = input.nextLine();
        cmnd = checkIdCard(cmnd);
        return cmnd;
    }

    private static String inputGender() {
        System.out.println("Enter gender:");
        String gender = input.nextLine();
        gender = checkGender(gender);
        return gender;
    }

    private static String inputDateOfBirth() {
        System.out.println("Enter dateOfBirth:");
        String dateOfBirth = input.nextLine();
        dateOfBirth = checkDateOfBirth(dateOfBirth);
        return dateOfBirth;
    }

    private static String inputName(String s) {
        System.out.println(s);
        String name = input.nextLine();
        name = checkType(name);
        return name;
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
    public static void addNewBooking(){
        showInformationOfCustomer();
        System.out.println("Nhập ID khách cần booking");
        String chooseCustomer = input.nextLine();
        System.out.println("Chọn loại booking");
        System.out.println("1. Booking Villa \n" +
                "2. Booking House \n" +
                "3. Booing House");
        String choose = input.nextLine();
        boolean check = true;
        while (check){
            if(choose.equals("1")|choose.equals("2")|choose.equals("3")){
                check = false;
            }else {
                System.out.println("chọn lại");
                choose = input.nextLine();
            }
        }
        Services services = null;
        Customer customer1 = null;
        String chooseService;
        boolean exit = true;
        while (exit){
            switch (choose){
                case "1":
                    exit = false;
                    services = bookingVilla(null);
                    break;
                case "2":
                    exit = false;
                    services = bookingHouse(null);
                    break;
                case "3":
                    exit = false;
                    services = bookingRoom(null);
                    break;
                default:
                    System.out.println("chọn lại");
            }
        }
        try {
            if(services == null){
                System.err.println("mã dịch vụ ko tìm thấy");
            }else {
                customer1 = bookingCustomer(chooseCustomer, services, null);
                String line = customer1.getID() + COMMA + customer1.getName() + COMMA + customer1.getDateOfBirth() + COMMA
                        + customer1.getGender() + COMMA + customer1.getCmnd() + COMMA + customer1.getPhone() + COMMA
                        + customer1.getEmail() + COMMA + customer1.getType() + COMMA + customer1.getAddress() + COMMA
                        + customer1.getServices();
                FileUtils.writeFile(BOOKING_FILE, line, true);
                System.out.println("Thêm thành công");
            }
        }catch (NullPointerException e){
            System.err.println("id khách hàng ko tìm thấy");
        }
    }

    private static Customer bookingCustomer(String chooseCustomer, Services services, Customer customer1) {
        for (String customer: listCustomer){
            String[] lineSplit = customer.split(COMMA);
            for (int i=0; i<lineSplit.length; i=i+9){
                if (chooseCustomer.equals(lineSplit[i])){
                    customer1 = new Customer(lineSplit[i], lineSplit[i+1], lineSplit[i+2], lineSplit[i+3],
                            lineSplit[i+4], lineSplit[i+5], lineSplit[i+6], lineSplit[i+7], lineSplit[i+8]);
                    customer1.setServices(services);
                    break;
                }
            }
        }
        return customer1;
    }

    private static Services bookingRoom(Services services) {
        String chooseService;
        show(ROOM_FILE);
        System.out.println("chọn mã Room cần booking");
        chooseService = input.nextLine();
        for (String room: listRoom){
            String[] lineSplit = room.split(COMMA);
            for (int i=0; i<lineSplit.length; i=i+9){
                if(chooseService.equals(lineSplit[i])){
                    services = new Room(lineSplit[i], lineSplit[i+1], lineSplit[i+2], lineSplit[i+3],
                            lineSplit[i+4], lineSplit[i+5], lineSplit[i+6]);
                    break;
                }
            }
        }
        return services;
    }

    private static Services bookingHouse(Services services) {
        String chooseService;
        show(HOUSE_FILE);
        System.out.println("chọn mã House cần booking");
        chooseService = input.nextLine();
        for (String house: listHouse){
            String[] lineSplit = house.split(COMMA);
            for (int i=0; i<lineSplit.length; i=i+9){
                if(chooseService.equals(lineSplit[i])){
                    services = new House(lineSplit[i], lineSplit[i+1], lineSplit[i+2], lineSplit[i+3],
                            lineSplit[i+4], lineSplit[i+5], lineSplit[i+6], lineSplit[i+7], lineSplit[i+8]);
                    break;
                }
            }
        }
        return services;
    }

    private static Services bookingVilla(Services services) {
        String chooseService;
        show(VILLA_FILE);
        System.out.println("chọn mã villa cần booking");
        chooseService = input.nextLine();
        for (String villa: listVilla){
            String[] lineSplit = villa.split(COMMA);
            for (int i=0; i<lineSplit.length; i=i+10){
                if(chooseService.equals(lineSplit[i])){
                    services = new Villa(lineSplit[i], lineSplit[i+1], lineSplit[i+2], lineSplit[i+3],
                            lineSplit[i+4], lineSplit[i+5], lineSplit[i+6], lineSplit[i+7], lineSplit[i+8],
                            lineSplit[9]);
                    break;
                }
            }
        }
        return services;
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
        listCustomer = FileUtils.readFile(CUSTOMER_FILE);
        String[] lineSplit = listCustomer.get(listCustomer.size()-1).split(COMMA);
        return list.size() == 0 ? "1" : String.valueOf(Integer.parseInt(lineSplit[0]) + 1);
    }

    public static void addVilla(){
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
        FileUtils.writeFile(VILLA_FILE, line, true);
        System.out.println("Thêm thành công");
    }

    private static String checkType(String type) {
//        while (!Validate.checkServiceName(type)){
//            System.err.println("Định dạng phải viết in hoa chữ đầu, ko có dấu và ko có số hoặc kí tự đặc biệt");
//            type = input.nextLine();
//        }
        boolean check = true;
        while (check){
            try {
                if(!Validate.checkServiceName(type)){
                    throw new NameException();
                }
                check = false;
            } catch (NameException e) {
                e.printStackTrace();
                type = input.nextLine();
            }
        }
        return type;
    }

    private static String checkID(String ID, String type) {
//        while (!Validate.checkID(ID, type)){
//            System.err.println("Định dạng phải theo kiểu SVXX-YYYY, với YYYY là các số từ 0-9, XX thì theo VL, HO, RO");
//            ID = input.nextLine();
//        }
//        while (!checkIdNotDuplicate(ID)){
//            System.err.println("ID bị trùng");
//            ID = input.nextLine();
//            checkID(ID, type);
//        }
        boolean check = true;
        while (check){
            if (!Validate.checkID(ID, type)){
                System.err.println("Định dạng phải theo kiểu SVXX-YYYY, với YYYY là các số từ 0-9 \n" +
                        "Nếu là Villa thì XX là VL, House thì XX là HO, Room thì XX là RO");
                ID = input.nextLine();
                check = true;
            }else if (!checkIdNotDuplicate(ID, type)){
                System.err.println("ID bị trùng");
                ID = input.nextLine();
                check = true;
            }else {
                check = false;
            }
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
            type = "Unknown";
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
            System.err.println("Định dạng theo kiểu: Year, Month, Date, Hour");
            type = input.nextLine();
        }
        return type;
    }

    private static String checkArea(String area) {
        boolean check = true;
        while (check){
            try{
                while (!Validate.checkArea(Double.parseDouble(area))){
                    System.err.println("Số phải lớn hơn 30");
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
                    System.err.println("Số phải lớn hơn 0");
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
                    System.err.println("Số phải lớn hơn 0");
                    num = input.nextLine();
                }
                check = false;
            }catch (NumberFormatException e){
                System.err.println("phải nhập một số nguyên");
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
                System.err.println("phải nhập một số nguyên");
                numPeople = input.nextLine();
            }
        }
        return numPeople;
    }

    public static void addHouse(){
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
        typeRent = checkTypeRent(typeRent);
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
        FileUtils.writeFile(HOUSE_FILE, line, true);
        System.out.println("Thêm thành công");
    }
    public static void addRoom(){
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
        typeRent = checkTypeRent(typeRent);
        System.out.println("Enter freeService");
        String freeService = input.nextLine();
        freeService = checkFreeService(freeService);
        Room room = new Room(ID, nameService, areaUsed, costRent, numPeople, typeRent, freeService);
        String line = room.getId() + COMMA + room.getNameService() + COMMA + room.getAreaUsed() + COMMA + room.getCostRent()
                + COMMA + room.getNumPeople() + COMMA + room.getTypeRent() + COMMA + room.getFreeService();
        FileUtils.writeFile(ROOM_FILE, line, true);
        System.out.println("Thêm thành công");
    }
    public static String checkFreeService(String str){
        while (!Validate.checkFreeService(str)){
            System.err.println("Kiểu có định dạng: Massage, Karaoke, Food, Water, Car");
            str = input.nextLine();
        }return str;
    }

    public static boolean checkIdNotDuplicate(String ID, String path){
        List<String> list = null;
        if(path.equals("VL")){
            list = FileUtils.readFile(VILLA_FILE);
        }else if(path.equals("HO")){
            list = FileUtils.readFile(HOUSE_FILE);
        }else if(path.equals("RO")){
            list = FileUtils.readFile(ROOM_FILE);
        }
        for (String list1: list){
            if(list1.substring(0,9).equals(ID)){
               return false;
            }
        } return true;
    }

    public static void show(String path){
        List<String> list = FileUtils.readFile((path));
        Services services = null;
        for (String element: list){
            String[] lineSplit = element.split(COMMA);
            if (path.equals(VILLA_FILE)){
                System.out.println("Show All Villa");
                services = new Villa(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5],
                        lineSplit[6], lineSplit[7], lineSplit[8], lineSplit[9]);
            }else if (path.equals(HOUSE_FILE)){
                System.out.println("Show All House");
                services = new House(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5],
                        lineSplit[6], lineSplit[7], lineSplit[8]);
            }else if (path.equals(ROOM_FILE)){
                System.out.println("Show All Room");
                services = new Room(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5],
                        lineSplit[6]);
            }else if (path.equals(CUSTOMER_FILE)){
                Customer customer = new Customer(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5],
                        lineSplit[6], lineSplit[7], lineSplit[8]);
                customer.showInfo();
            }
            services.showInfo();
        }
    }


    public static void showNameNotDuplicate(String path){
        List<String> list = FileUtils.readFile(path);
        TreeSet<String> listNotDuplicate = new TreeSet<>();
        for (String element: list){
            String[] lineSplit = element.split(COMMA);
            listNotDuplicate.add(lineSplit[1]);
        }
        System.out.println(listNotDuplicate);
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

    public static void delete(String path){
        show(path);
        System.out.println("nhập ID cần xóa:");
        String ID = input.nextLine();
        List<String> list = FileUtils.readFile(path);
        boolean isCheckId = false;
        boolean isRemove = false;
        for (int i=0; i<list.size(); i++){
            String[] lineSplit = list.get(i).split(COMMA);
            if (lineSplit[0].equals(ID)){
                isCheckId = true;
                System.out.println("bạn có đồng ý xóa id: " + ID + " ko? \n" +
                        "Bấm y để xác nhận và ký tự khác để từ chối");
                String confirm = input.nextLine();
                if (confirm.equals("y")){
                    list.remove(i);
                    isRemove = true;
                    break;
                }
            }
        }if(!isCheckId){
            System.err.println("ko tìm thấy ID: " + ID);
        }if (isRemove){
            System.out.println("Đã xóa ID: " + ID + " khỏi danh sách");
        }
        String temp = "";
        for (String element: list){
            if (temp == "") {
                temp += element;
            }else {
                temp += "\n" + element;
            }
        }
        FileUtils.writeFile(path, temp, false);
    }
    public static void edit(){
        showInformationOfCustomer();
        System.out.println("nhập ID cần sửa");
        String idCustomer = input.nextLine();
        List<Customer> customerList = new ArrayList<>();
        listCustomer = FileUtils.readFile(CUSTOMER_FILE);
        for (String list: listCustomer){
            String[] lineSplit = list.split(COMMA);
            Customer customer = new Customer(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4],
                    lineSplit[5], lineSplit[6], lineSplit[7], lineSplit[8]);
            customerList.add(customer);
        }
        boolean isExited = false;
        for (int i=0; i<customerList.size(); i++){
            if (customerList.get(i).getID().equals(idCustomer)){
                isExited = true;
                System.out.println("Name: " + customerList.get(i).getName());
                customerList.get(i).setName(inputName("Enter name"));
                System.out.println("DateOfBirth: " + customerList.get(i).getDateOfBirth());
                customerList.get(i).setDateOfBirth(inputDateOfBirth());
                System.out.println("Gender: " + customerList.get(i).getGender());
                customerList.get(i).setGender(inputGender());
                System.out.println("CMND: " + customerList.get(i).getCmnd());
                customerList.get(i).setCmnd(inputCmnd());
                System.out.println("Phone: " + customerList.get(i).getPhone());
                customerList.get(i).setPhone(inputPhone());
                System.out.println("Email: " + customerList.get(i).getEmail());
                customerList.get(i).setEmail(inputEmail());
                System.out.println("Type: " + customerList.get(i).getType());
                customerList.get(i).setType(inputTypeCustomer());
                System.out.println("Address: " + customerList.get(i).getAddress());
                customerList.get(i).setAddress(inputAddress());
                System.out.println("đã edit thông tin");
                break;
            }
        }if (!isExited){
            System.out.println("ID: " + idCustomer + " không tồn tại");
        }
        StringBuilder temp = new StringBuilder();
        for (Customer customer: customerList){
            if (temp.toString().equals("")) {
                temp.append(customer.writeFile());
            }else {
                temp.append("\n").append(customer.writeFile());
            }
        }
            FileUtils.writeFile(CUSTOMER_FILE, temp.toString(), false);
    }
    public static void searchCustomer(){
        System.out.println("nhập tên cần tìm");
        String name = input.nextLine();
        name = checkType(name);
        listCustomer = FileUtils.readFile(CUSTOMER_FILE);
        boolean isExit = false;
        for (String list: listCustomer){
            String[] lineSplit = list.split(COMMA);
            Customer customer = new Customer(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4],
                    lineSplit[5], lineSplit[6], lineSplit[7], lineSplit[8]);
            if (customer.getName().contains(name)){
                isExit = true;
                customer.showInfo();
            }
        }if(!isExit){
            System.err.println("ko tìm thấy tên: " + name);
        }
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


