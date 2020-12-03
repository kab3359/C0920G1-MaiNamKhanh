package model;

public class KhachHang {
    private String maKhachHang;
    private String tenKhachHang;
    private String ngaySinh;
    private String gioiTinh;
    private String soDienThoai;
    private String diaChi;

    public KhachHang(String maKhachHang, String tenKhachHang, String ngaySinh, String gioiTinh, String soDienThoai,
                     String diaChi) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    public KhachHang() {
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KhachHang{");
        sb.append("maKhachHang='").append(maKhachHang).append('\'');
        sb.append(", tenKhachHang='").append(tenKhachHang).append('\'');
        sb.append(", ngaySinh='").append(ngaySinh).append('\'');
        sb.append(", gioiTinh='").append(gioiTinh).append('\'');
        sb.append(", soDienThoai='").append(soDienThoai).append('\'');
        sb.append(", diaChi='").append(diaChi).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void showInfo(){
        this.toString();
    }
}
