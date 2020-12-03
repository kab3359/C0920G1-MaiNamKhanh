package model;

public class SoCoThoiHan extends SoTietKiem {
    private String kyHan;
    private String soTienGui;
    private String laiSuat;
    public SoCoThoiHan(){};

    public SoCoThoiHan(String maSoso, String maKhachHang, String ngayMoSo, String thoiGianBatDauGui, String kyHan,
                       String soTienGui, String laiSuat) {
        super(maSoso, maKhachHang, ngayMoSo, thoiGianBatDauGui);
        this.kyHan = kyHan;
        this.soTienGui = soTienGui;
        this.laiSuat = laiSuat;
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    public String getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(String soTienGui) {
        this.soTienGui = soTienGui;
    }

    public String getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(String laiSuat) {
        this.laiSuat = laiSuat;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SoCoThoiHan{");
        sb.append("kyHan='").append(kyHan).append('\'');
        sb.append(", soTienGui='").append(soTienGui).append('\'');
        sb.append(", laiSuat='").append(laiSuat).append('\'');
        sb.append(", maSoso='").append(maSoso).append('\'');
        sb.append(", maKhachHang='").append(maKhachHang).append('\'');
        sb.append(", ngayMoSo='").append(ngayMoSo).append('\'');
        sb.append(", thoiGianBatDauGui='").append(thoiGianBatDauGui).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void showInfo() {
        this.toString();
    }
}
