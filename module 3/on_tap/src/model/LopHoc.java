package model;

public class LopHoc {
    private int id;
    private String name;
    private int soPhong;
    private String tenTruong;

    public LopHoc() {
    }

    public LopHoc(int id, String name, int soPhong, String tenTruong) {
        this.id = id;
        this.name = name;
        this.soPhong = soPhong;
        this.tenTruong = tenTruong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

    public String getTenTruong() {
        return tenTruong;
    }

    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }
}
