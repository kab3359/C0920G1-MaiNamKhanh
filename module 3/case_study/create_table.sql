Drop DATABASE IF EXISTS  furama;
CREATE DATABASE furama;
use furama;

CREATE TABLE vi_tri(
id_vi_tri int PRIMARY KEY AUTO_INCREMENT,
ten_vi_tri VARCHAR(45)
);

CREATE TABLE trinh_do(
id_trinh_do int PRIMARY KEY AUTO_INCREMENT,
ten_trinh_do VARCHAR(45)
);

CREATE TABLE bo_phan(
id_bo_phan int PRIMARY KEY AUTO_INCREMENT,
ten_bo_phan VARCHAR(45)
);

CREATE TABLE nhan_vien(
id_nhan_vien int PRIMARY KEY AUTO_INCREMENT,
ho_ten VARCHAR(45),
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh DATE,
so_cmnd VARCHAR(45),
luong DOUBLE,
sdt VARCHAR(45),
email VARCHAR(45),
dia_chi VARCHAR(45),
FOREIGN KEY (id_vi_tri) REFERENCES vi_tri(id_vi_tri),
FOREIGN KEY (id_trinh_do) REFERENCES trinh_do(id_trinh_do),
FOREIGN KEY (id_bo_phan) REFERENCES bo_phan(id_bo_phan)
);

CREATE TABLE dich_vu_di_kem(
id_dich_vu_di_kem int PRIMARY KEY AUTO_INCREMENT,
ten_dich_vu_di_kem VARCHAR(45),
gia DOUBLE,
don_vi VARCHAR(45),
trang_thai_kha_dung VARCHAR(45)
);

CREATE TABLE loai_khach(
id_loai_khach int PRIMARY KEY AUTO_INCREMENT,
ten_loai_khach VARCHAR(45)
);

CREATE TABLE khach_hang(
id_khach_hang int PRIMARY KEY AUTO_INCREMENT,
id_loai_khach int,
ho_ten VARCHAR(45),
ngay_sinh DATE,
so_cmnd VARCHAR(45),
sdt VARCHAR(45),
email VARCHAR(45),
dia_chi VARCHAR(45),
FOREIGN KEY (id_loai_khach) REFERENCES loai_khach(id_loai_khach)
);

CREATE TABLE kieu_thue(
id_kieu_thue int PRIMARY KEY AUTO_INCREMENT,
ten_kieu_thue VARCHAR(45),
gia DOUBLE
);

CREATE TABLE loai_dich_vu(
id_loai_dich_vu int PRIMARY KEY AUTO_INCREMENT,
ten_loai_dich_vu VARCHAR(45)
);

CREATE TABLE dich_vu(
id_dich_vu int PRIMARY KEY AUTO_INCREMENT,
ten_dich_vu VARCHAR(45),
dien_tich int,
so_tang int,
so_nguoi_toi_da int,
chi_phi_thue DOUBLE,
id_kieu_thue int,
id_loai_dich_vu int,
trang_thai VARCHAR(45),
FOREIGN KEY (id_kieu_thue) REFERENCES kieu_thue(id_kieu_thue),
FOREIGN KEY (id_loai_dich_vu) REFERENCES loai_dich_vu(id_loai_dich_vu)
);

CREATE TABLE hop_dong(
id_hop_dong int PRIMARY KEY AUTO_INCREMENT,
id_nhan_vien int,
id_khach_hang int,
id_dich_vu int,
ngay_lam_hop_dong DATE,
ngay_ket_thuc DATE,
tien_dat_coc DOUBLE,
FOREIGN KEY (id_nhan_vien) REFERENCES nhan_vien(id_nhan_vien) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (id_khach_hang) REFERENCES khach_hang(id_khach_hang)  ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (id_dich_vu) REFERENCES dich_vu(id_dich_vu)  ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE hop_dong_chi_tiet(
id_hop_dong_chi_tiet int PRIMARY KEY AUTO_INCREMENT,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,
FOREIGN KEY(id_hop_dong) REFERENCES hop_dong(id_hop_dong) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (id_dich_vu_di_kem) REFERENCES dich_vu_di_kem(id_dich_vu_di_kem) ON UPDATE CASCADE ON DELETE CASCADE
);



