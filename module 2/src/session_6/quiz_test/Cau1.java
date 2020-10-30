package session_6.quiz_test;

public class Cau1 {
    public static class NhanVien {
        public double getThuNhap() {
            return 1;
        }
    }

    public static class TruongPhong extends NhanVien {
        public double getThuNhap() {
            return 2;
        }
    }

    public static void main(String[] args) {
        NhanVien nv1 = new NhanVien();
        NhanVien nv2 = new TruongPhong();
        TruongPhong nv3 = new TruongPhong();
        System.out.println(nv2.getThuNhap());
    }

}
