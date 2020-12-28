DROP DATABASE IF EXISTS furama; 
create database furama;

use furama;

create table vi_tri(
id_vi_tri int PRIMARY KEY,
ten_vi_tri varchar(45)
);


create table trinh_do(
id_trinh_do int PRIMARY KEY,
trinh_do varchar(45)
);

create table bo_phan(
id_bo_phan int PRIMARY KEY,
ten_bo_phan varchar(45)
);

create table nhan_vien(
id_nhan_vien int PRIMARY KEY,
ho_ten int,
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh date,
so_cmnd varchar(45),
luong varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
FOREIGN KEY (id_vi_tri) REFERENCES vi_tri(id_vi_tri),
FOREIGN KEY (id_trinh_do) REFERENCES trinh_do(id_trinh_do),
FOREIGN KEY (id_bo_phan) REFERENCES bo_phan(id_bo_phan)
);


create table dich_vu_di_kem(
id_dich_vu_di_kem int PRIMARY KEY,
ten_dich_vu_di_kem varchar(45),
gia int,
don_vi int,
trang_thai_kha_dung varchar(45)
);


create table loai_khach(
id_loai_khach int PRIMARY KEY,
ten_loai_khach varchar(45)
);

create table khach_hang(
id_khach_hang int PRIMARY KEY,
id_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
so_cmnd varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
FOREIGN KEY (id_loai_khach) REFERENCES loai_khach(id_loai_khach)
);


create table kieu_thue(
id_kieu_thue int PRIMARY KEY,
ten_kieu_thue varchar(45),
gia int
);


create table loai_dich_vu(
id_loai_dich_vu int PRIMARY KEY,
ten_loai_dich_vu varchar(45)
);

create table dich_vu(
id_dich_vu int PRIMARY KEY,
ten_dich_vu varchar(45),
dien_tich int,
so_tang int,
so_nguoi_toi_da varchar(45),
chi_phi_thue varchar(45),
id_kieu_thue int,
id_loai_dich_vu int,
trang_thai varchar(45),
FOREIGN KEY (id_kieu_thue) REFERENCES kieu_thue(id_kieu_thue),
FOREIGN KEY (id_loai_dich_vu) REFERENCES loai_dich_vu(id_loai_dich_vu)
);

create table hop_dong(
id_hop_dong int PRIMARY KEY,
id_nhan_vien int,
id_khach_hang int,
id_dich_vu int,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int,
FOREIGN KEY (id_nhan_vien) REFERENCES nhan_vien(id_nhan_vien),
FOREIGN KEY (id_khach_hang) REFERENCES khach_hang(id_khach_hang),
FOREIGN KEY (id_dich_vu) REFERENCES dich_vu(id_dich_vu)
);

create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int PRIMARY KEY,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,
FOREIGN KEY (id_dich_vu_di_kem) REFERENCES dich_vu_di_kem(id_dich_vu_di_kem),
FOREIGN KEY (id_hop_dong) REFERENCES hop_dong(id_hop_dong)
);


-- ALTER table hop_dong_chi_tiet
-- DROP FOREIGN KEY hop_dong_chi_tiet_ibfk_2;
-- ALTER table hop_dong_chi_tiet
-- MODIFY COLUMN id_hop_dong_chi_tiet int AUTO_INCREMENT;
-- ALTER table hop_dong_chi_tiet
-- ADD FOREIGN KEY (id_hop_dong) REFERENCES hop_dong(id_hop_dong);