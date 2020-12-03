SELECT * FROM furama.nhan_vien;
INSERT into nhan_vien(ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmnd, luong, sdt, email, dia_chi)
VALUE ("Tưởng Thế Anh", 2, 2, 3, "1880-04-30", "292339", 500, 19283849, "qpa@oao.com", "Huế");

-- TASK 2
SELECT * FROM nhan_vien
WHERE CHAR_LENGTH(ho_ten) > 10 and (ho_ten like "L%" OR ho_ten like "T%");

-- TASK 3
SELECT * FROM nhan_vien
WHERE year(curdate()) - year(ngay_sinh) > 18 and year(curdate()) - year(ngay_sinh) < 50 and dia_chi like "Đà Nẵng";