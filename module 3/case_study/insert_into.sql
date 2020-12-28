use furama;
INSERT INTO trinh_do(ten_trinh_do)
VALUES ("đại học"),
("cao đẳng"),
("trung cấp");

INSERT INTO vi_tri(ten_vi_tri)
VALUES ("giám đóc"),
("trưởng phòng"),
("chủ tịch");

INSERT INTO bo_phan(ten_bo_phan)
VALUES ("kế toán"),
("sửa chữa"),
("thu ngân");

-- SET foreign_key_checks = 0; 
-- TRUNCATE TABLE nhan_vien;
-- SET foreign_key_checks = 1; 

INSERT INTO nhan_vien(ho_ten, id_vi_tri, id_trinh_do,
 id_bo_phan, ngay_sinh, so_cmnd, luong, sdt, email, dia_chi)
 VALUES ("Mai Nam Khánh", 3, 1, 1, "1992-08-10", '111222333', 10000000, '123456789', 'abc@abc.abc', 'Đà Nẵng'),
 ("Hồ Nguyên Trừng", 2, 2, 2, "1982-08-10", '111222333', 5000000, '123456789', 'abc@abc.abc', 'Huế'),
 ("Trần Hoàng Long", 1, 2, 3, "1982-08-31", '111222333', 2000000, '123456789', 'abc@abc.abc', 'Quảng Nam'),
 ("Khúc Thị Kim Khuê", 3, 2, 1, "1982-12-31", '111222333', 500000, '123456789', 'abc@abc.abc', 'Đà Nẵng');
 
 INSERT INTO loai_khach(ten_loai_khach)
 VALUES ("Vip"), ("Diamond"), ("Standard");
 
 INSERT INTO khach_hang(id_loai_khach, ho_ten, ngay_sinh, so_cmnd, sdt, email, dia_chi)
 VALUES
 (1, "Trần Ngọc Hân", '1992-10-08', '234521', '2344543', 'abc@abc.com', 'Đà Nẵng'),
 (2, "Nguyễn Tuấn", '1952-10-08', '234521', '2344543', 'abc@abc.com', 'Đà Nẵng'),
 (3, "Lê Quang Long", '2005-10-08', '234521', '2344543', 'abc@abc.com', 'Quảng Trị'),
 (2, "Cao Xuân Huy", '1975-10-08', '234521', '2344543', 'abc@abc.com', 'Quảng Trị'),
 (1, "Nguyễn Thị Kim Anh", '1981-10-08', '234521', '2344543', 'abc@abc.com', 'Quảng Nam'),
 (3, "Phạm Thị Tường Vy", '1989-10-08', '234521', '2344543', 'abc@abc.com', 'Quảng Nam');
 
 INSERT INTO loai_dich_vu(ten_loai_dich_vu)
 VALUES('Buffet'), ('Drink'), ('Massage');
 
 INSERT INTO kieu_thue(ten_kieu_thue, gia)
 VALUES('Day', 500000), ('Month', 150000000), ('Year', 1500000000);
 
 INSERT INTO dich_vu(ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue, 
 id_kieu_thue, id_loai_dich_vu, trang_thai)
 VALUES
 ('Resort', 15, 2, 5, 500000, 1, 1, 'còn'),
 ('House', 30, 3, 10, 1000000, 1, 1, 'còn'),
 ('Room', 20, 2, 5, 500000, 1, 3, 'hết'),
 ('Villa', 50, 5, 15, 2000000, 2, 1, 'còn'),
 ('Golf', 100, 0, 50, 50000000, 3, 2, 'còn');
 
 INSERT INTO hop_dong(id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, 
 tien_dat_coc)
 VALUES
 (1, 5, 1, '2019-01-01', '2019-03-31', 100000),
 (2, 4, 2, '2019-01-01', '2019-01-31', 200000),
 (3, 3, 3, '2020-01-01', '2020-03-31', 300000),
 (2, 1, 1, '2019-03-01', '2019-06-30', 400000),
 (1, 2, 2, '2019-06-01', '2019-09-30', 500000),
 (1, 3, 3, '2019-09-01', '2019-12-31', 600000),
 (2, 4, 1, '2018-01-01', '2018-03-31', 700000),
 (3, 3, 2, '2018-10-01', '2018-12-31', 800000),
 (1, 5, 3, '2019-01-01', '2019-03-31', 900000),
 (1, 1, 1, '2018-01-01', '2018-03-31', 1000000);
 
 INSERT INTO dich_vu_di_kem(ten_dich_vu_di_kem, gia, don_vi, trang_thai_kha_dung)
 VALUES ('Water', 200000, 'chai', 'còn'),
 ('Relax', 200000, 'giờ', 'hết'),
 ('Shower', 500000, 'giờ', 'còn');
 
 INSERT INTO hop_dong_chi_tiet(id_hop_dong, id_dich_vu_di_kem, so_luong)
 VALUES (1, 1, 100), (2, 2, 24), (3, 3, 1), (4, 1, 1);
 
 INSERT INTO hop_dong_chi_tiet(id_hop_dong, id_dich_vu_di_kem, so_luong)
 VALUES (5, 1, 50), (6, 2, 1), (7, 3, 1), (8, 1, 10);
 
 ALTER TABLE dich_vu_di_kem
 MODIFY COLUMN gia DOUBLE DEFAULT 0;
 
