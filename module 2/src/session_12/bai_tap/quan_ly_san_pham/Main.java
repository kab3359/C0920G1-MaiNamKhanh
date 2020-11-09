package session_12.bai_tap.quan_ly_san_pham;

import java.util.Scanner;

public class Main {
    public  static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        String choose = null;
        boolean exit = true;
        while (exit){
            showMenu();
            choose = input.nextLine();
            switch (choose){
                case "1": productManager.addProduct();
                break;
                case "2":
                    System.out.println("nhập ID cần edit");
                    productManager.edit(input.nextInt());
                break;
                case "3":
                    System.out.println("nhập ID cần xóa");
                    productManager.delete(input.nextInt());
                    break;
                case "4":
                    productManager.sortProductByPriceGiam();
                    break;
                case "5":
                    System.out.println("nhập tên sản phẩm cần tìm:");
                    productManager.searchNameProduct(input.nextLine());
                    break;
                case "6": productManager.show();
                break;
                case "7": productManager.sortProductByPriceTang();
                break;
                case "0": exit = false;
                break;
                default:
                    System.out.println("sai");
            }
        }
    }
    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Add product.");
        System.out.println("2. Edit product by id.");
        System.out.println("3. Delete product by id.");
        System.out.println("4. Sort product by price giảm dần.");
        System.out.println("5. Search product by name.");
        System.out.println("6. Show product.");
        System.out.println("7. Sort product by price tăng dần.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }
}
