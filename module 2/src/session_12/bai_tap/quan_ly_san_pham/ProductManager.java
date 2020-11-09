package session_12.bai_tap.quan_ly_san_pham;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManager implements Comparator<Product> {
    private List<Product> productList = new ArrayList<>();

    public ProductManager() {
    }
    public void addProduct(){
        int idProduct = (productList.size() > 0) ? (productList.size() + 1) : 1;
        System.out.println("product id = " + idProduct);
        String nameProduct = inputName();
        Double priceProduct = inputPrice();
        Product product = new Product(idProduct, nameProduct, priceProduct);
        productList.add(product);
    }
    private String inputName(){
        System.out.println("nhập tên sản phẩm");
//        Main.input.nextLine();
        return Main.input.nextLine();
    }
    private double inputPrice(){
        System.out.println("nhập giá sản phẩm");
        return Main.input.nextDouble();
    }
    public void show() {
        for (Product product : productList) {
            System.out.println("ID: " + product.getId());
            System.out.println("Sản phẩm: " + product.getName());
            System.out.println("Giá: " + product.getPrice());
        }
    }
    public void edit(int idProduct){

        boolean isExited = false;
        for (int i=0; i<productList.size(); i++){
            if (productList.get(i).getId() == idProduct){
                isExited = true;
                Main.input.nextLine();
                productList.get(i).setName(inputName());
                productList.get(i).setPrice(inputPrice());
                break;
            }
        }if (!isExited){
            System.out.println(idProduct + " không tồn tại");
        }
    }
    public void delete(int idProduct){
        boolean isExited = false;
        for (int i=0; i<productList.size(); i++){
            if(productList.get(i).getId() == idProduct){
                isExited = true;
                productList.remove(productList.get(i));
            }
            productList.get(i).setId(i+1);
        }
        if (!isExited){
            System.out.println(idProduct + "không tồn tại");
        }
    }
    public void searchNameProduct(String nameProduct){
        boolean isExited = false;
        for(int i=0; i<productList.size(); i++){
            if(productList.get(i).getName().equals(nameProduct)){
                isExited = true;
                System.out.println("ID: " + productList.get(i).getId() + " Name " + productList.get(i).getName() + " Price: "
                        + productList.get(i).getPrice());
            }
        }
        if(!isExited){
            System.out.println("không có " + nameProduct);
        }
    }
    public void sortProductByPriceGiam(){
        Collections.sort(productList);
        show();
    }

    public void sortProductByPriceTang(){
        Collections.sort(productList, new ProductManager());
        show();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductManager{");
        sb.append("productList=").append(productList);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compare(Product o1, Product o2) {
        if(o1.getPrice() < o2.getPrice()){
            return -1;
        }else if(o1.getPrice() > o2.getPrice()){
            return 1;
        }
        return 0;
    }
}
