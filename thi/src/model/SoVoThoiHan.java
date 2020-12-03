package model;

public class SoVoThoiHan extends SoTietKiem {
    private String soTienGui;
    private String laiSuat;

    public SoVoThoiHan(){};

    public SoVoThoiHan(String maSoso, String maKhachHang, String ngayMoSo, String thoiGianBatDauGui, String soTienGui,
                       String laiSuat) {
        super(maSoso, maKhachHang, ngayMoSo, thoiGianBatDauGui);
        this.soTienGui = soTienGui;
        this.laiSuat = laiSuat;
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
    public void showInfo() {
        this.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SoVoThoiHan{");
        sb.append("soTienGui='").append(soTienGui).append('\'');
        sb.append(", laiSuat='").append(laiSuat).append('\'');
        sb.append(", maSoso='").append(maSoso).append('\'');
        sb.append(", maKhachHang='").append(maKhachHang).append('\'');
        sb.append(", ngayMoSo='").append(ngayMoSo).append('\'');
        sb.append(", thoiGianBatDauGui='").append(thoiGianBatDauGui).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
