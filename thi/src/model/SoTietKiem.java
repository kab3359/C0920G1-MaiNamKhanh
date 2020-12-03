package model;

public abstract class SoTietKiem {
    protected String maSoso;
    protected  String maKhachHang;
    protected String ngayMoSo;
    protected String thoiGianBatDauGui;

    public SoTietKiem() {
    }

    public SoTietKiem(String maSoso, String maKhachHang, String ngayMoSo, String thoiGianBatDauGui) {
        this.maSoso = maSoso;
        this.maKhachHang = maKhachHang;
        this.ngayMoSo = ngayMoSo;
        this.thoiGianBatDauGui = thoiGianBatDauGui;
    }

    public String getMaSoso() {
        return maSoso;
    }

    public void setMaSoso(String maSoso) {
        this.maSoso = maSoso;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getNgayMoSo() {
        return ngayMoSo;
    }

    public void setNgayMoSo(String ngayMoSo) {
        this.ngayMoSo = ngayMoSo;
    }

    public String getThoiGianBatDauGui() {
        return thoiGianBatDauGui;
    }

    public void setThoiGianBatDauGui(String thoiGianBatDauGui) {
        this.thoiGianBatDauGui = thoiGianBatDauGui;
    }

    public abstract void showInfo();
}
