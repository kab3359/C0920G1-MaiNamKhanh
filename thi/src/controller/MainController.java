package controller;

import common.FileUtils;
import common.Validate;
import model.*;

import java.util.List;
import java.util.Scanner;

public class MainController {
    public static Scanner input = new Scanner(System.in);
    private static final String SO_NGAN_HAN_FILE = "src/data/shortTerm.csv";
    private static final String SO_DAI_HAN_FILE = "src/data/longTerm.csv";
    private static final String CUSTOMER_FILE = "src/data/customer.csv";
    public static void menu(){
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN \n" +
                "Chọn chức năng theo số (để tiếp tục) \n" +
                "1. Thêm mới sổ tiết kiệm \n" +
                "2. Xóa sổ tiết kiệm \n" +
                "3. Xem danh sách sổ tiết kiệm \n" +
                "4. Xem thông tin khách hàng \n" +
                "5. Tìm kiếm sổ tiết kiệm \n" +
                "6. Thoát \n" +
                "Chọn chức năng");
        String choose = input.nextLine();
        do {
            switch (choose){
                case "1":
                    themSoTietKiem();
                    break;
                case "2":
                    xoaSoTietKiem();
                    break;
                case "3":
                    System.out.println("chọn loại \n" +
                            "1. có hạn \n" +
                            "2. vô hạn \n" +
                            "3. dài hạn");
                    String chooseType = input.nextLine();
                    switch (chooseType){
                        case "1":
                            xemDanhSachSoTietKiem(SO_NGAN_HAN_FILE, "cothoihan");
                            break;
                        case "2":
                            xemDanhSachSoTietKiem(SO_NGAN_HAN_FILE, "vothoihan");
                            break;
                        case "3":
                            xemDanhSachSoTietKiem(SO_DAI_HAN_FILE, "daihan");
                            break;
                        default:
                            System.out.println("chọn lại");
                    }
                    break;
                case "4":
                    xemThongTinKhachHang();
                    break;
                case "5":
//                    timSoTietKiem();
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println("chọn lại");
            }
        }while (Integer.parseInt(choose) < 0 && Integer.parseInt(choose) > 6);

    }

    public static void themSoTietKiem(){
        System.out.println("thêm ngắn hạn hay dài hạn \n" +
                "1. ngắn hạn \n" +
                "2. dài hạn");
        String choose = null;
        choose = input.nextLine();

        String chonThoiHan = null;
        System.out.println("nhập mã số sổ");
        String maSoSo = input.nextLine();
        xemThongTinKhachHang();
        System.out.println("nhập mã khách hàng");
        String maKhachHang = input.nextLine();
        maKhachHang = inputMaKhachHang(maKhachHang);
        System.out.println("nhập ngày mở sở");
        String ngayMoSo = input.nextLine();
        System.out.println("thời gian bắt đầu gửi");
        String thoiGianBatDauGui = input.nextLine();
        do {
            switch (choose){
                case "1":
                    System.out.println("1. Vô thời hạn \n" +
                            "2. Có thời hạn");
                    do {
                        chonThoiHan = input.nextLine();
                        switch (chonThoiHan){
                            case "1":
                                chonThoiHan = "1";
                                System.out.println("so tien gui");
                                String soTienGui = input.nextLine();
                                System.out.println("lai suat");
                                String laiSuat = input.nextLine();
                                String line = maSoSo + "," + maKhachHang + "," + ngayMoSo + "," + thoiGianBatDauGui + "," + soTienGui
                                        + "," + laiSuat;
                                FileUtils.writeFile(SO_NGAN_HAN_FILE, line, true);
                                break;
                            case "2":
                                chonThoiHan = "2";
                                System.out.println("so tien gui");
                                String soTienGui1 = input.nextLine();
                                System.out.println("lai suat");
                                String laiSuat1 = input.nextLine();
                                System.out.println("thời hạn");
                                String thoiHan = input.nextLine();
                                String line1 = maSoSo + "," + maKhachHang + "," + ngayMoSo + "," + thoiGianBatDauGui + "," + soTienGui1
                                        + "," + laiSuat1 + "," + thoiHan;
                                FileUtils.writeFile(SO_NGAN_HAN_FILE, line1, true);
                                break;
                            default:
                                System.out.println("chọn lại");
                        }
                    }while (Integer.parseInt(chonThoiHan) < 0 && Integer.parseInt(chonThoiHan) > 2);
                    break;
                case "2":
                    choose = "2";
                    break;
                default:
                    System.out.println("chọn lại");
            }
        }while (Integer.parseInt(choose) < 0 && Integer.parseInt(choose) > 2);




         if (choose.equals("2")){
            System.out.println("so tien gui");
            String soTienGui = input.nextLine();
            System.out.println("lai suat");
            String laiSuat = input.nextLine();
            System.out.println("thời hạn");
            String thoiHan = input.nextLine();
            System.out.println("ưu đãi");
            String uuDai = input.nextLine();
            String line =  maSoSo + "," + maKhachHang + "," + ngayMoSo + "," + thoiGianBatDauGui + "," + soTienGui
                    + "," + laiSuat + "," + thoiHan + "," + uuDai;
            FileUtils.writeFile(SO_DAI_HAN_FILE, line, true);
        }
        menu();
    }

    public static void xemThongTinKhachHang(){
        List<String> listCustomer = FileUtils.readFile(CUSTOMER_FILE);
//        ArrayList<Customer> listCustomer1 = new ArrayList<>();
        System.out.println("Show All Customer");
        for (String customer: listCustomer){
            String[] lineSplit = customer.split(",");
            KhachHang customer1 = new KhachHang(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4],
                    lineSplit[5]);
            customer1.showInfo();
//            listCustomer1.add(customer1);
        }
    }

    public static String inputMaKhachHang(String maKhachHang){
        List<String> listCustomer = FileUtils.readFile(CUSTOMER_FILE);
        for (String customer: listCustomer){
            String[] lineSplit = customer.split(",");
            if (maKhachHang.equals(lineSplit[0])){
                return maKhachHang;
            }
        }return maKhachHang;
    }

    public static void xoaSoTietKiem(){
        System.out.println("nhập ID cần xóa:");
        String ID = input.nextLine();
        List<String> listDaiHan = FileUtils.readFile(SO_DAI_HAN_FILE);
        for (int i=0; i<listDaiHan.size(); i++){
            String[] lineSplit = listDaiHan.get(i).split(",");
            if (lineSplit[0].equals(ID)) {
                System.out.println("Chọn Yes hoặc No");
                String confirm = input.nextLine();
                if (confirm.equals("Yes")) {
                    listDaiHan.remove(i);
                    break;
                } else if (confirm.equals("No")) {
                    menu();
                }
            }
        }
        List<String> listNganHan = FileUtils.readFile(SO_NGAN_HAN_FILE);
        for (int i=0; i<listNganHan.size(); i++){
            String[] lineSplit = listNganHan.get(i).split(",");
            if (lineSplit[0].equals(ID)) {
                System.out.println("Chọn Yes hoặc No");
                String confirm = input.nextLine();
                if (confirm.equals("Yes")) {
                    listNganHan.remove(i);
                    break;
                } else if (confirm.equals("No")) {
                    menu();
                }
            }
        }
        String temp = "";
        for (String element: listDaiHan){
            if (temp == "") {
                temp += element;
            }else {
                temp += "\n" + element;
            }
        }
        FileUtils.writeFile(SO_DAI_HAN_FILE, temp, false);
        String temp1 = "";
        for (String element: listNganHan){
            if (temp1 == "") {
                temp1 += element;
            }else {
                temp1 += "\n" + element;
            }
        }
        FileUtils.writeFile(SO_NGAN_HAN_FILE, temp, false);
    }
    public static void xemDanhSachSoTietKiem(String path, String type){
        List<String> list = FileUtils.readFile((path));
        SoTietKiem services = null;
        for (String element: list){
            String[] lineSplit = element.split(",");
            if (path.equals(SO_DAI_HAN_FILE)){
                services = new SoDaiHan(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5],
                        lineSplit[6], lineSplit[7]);
            }else if (path.equals(SO_NGAN_HAN_FILE) && type.equals("cothoihan")){
                services = new SoCoThoiHan(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5],
                        lineSplit[6]);
            }else if (path.equals(SO_NGAN_HAN_FILE) && type.equals("vothoihan")){
                System.out.println("Show All Room");
                services = new SoVoThoiHan(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5]);
            }
            services.showInfo();
        }
    }
//    public static void timSoTietKiem(){
//        System.out.println("nhập tên cần tìm");
//        String name = input.nextLine();
//        List<String> list = FileUtils.readFile(SO_NGAN_HAN_FILE);
//
//        boolean isExit = false;
//        for (String list: listCustomer){
//            String[] lineSplit = list.split(COMMA);
//            Customer customer = new Customer(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4],
//                    lineSplit[5], lineSplit[6], lineSplit[7], lineSplit[8]);
//            if (customer.getName().contains(name)){
//                isExit = true;
//                customer.showInfo();
//            }
//        }if(!isExit){
//            System.err.println("ko tìm thấy tên: " + name);
//        }
//    }
}
