-- Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt 
-- đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự
SELECT * FROM nhan_vien
WHERE (ho_ten LIKE 'K%' OR ho_ten LIKE 'H%' OR ho_ten LIKE 'T%') AND char_length(ho_ten) <= 15;

-- Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến
-- 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT * FROM khach_hang
WHERE year(now()) - year(ngay_sinh) BETWEEN 18 AND 50
 and (dia_chi like "Đà Nẵng" or dia_chi like "Quảng Trị");
 
 -- Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
 -- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
 -- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
SELECT khach_hang.*, count(khach_hang.id_khach_hang) as so_lan_dat_phong FROM khach_hang JOIN hop_dong
on khach_hang.id_khach_hang = hop_dong.id_khach_hang JOIN loai_khach
on khach_hang.id_loai_khach = loai_khach.id_loai_khach
WHERE loai_khach.ten_loai_khach = 'Diamond'
GROUP BY khach_hang.id_khach_hang
ORDER BY so_lan_dat_phong;

-- task 5
SELECT khach_hang.id_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, hop_dong.id_hop_dong,
dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc,
sum(dich_vu.chi_phi_thue + dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong) as tong_tien
FROM khach_hang LEFT JOIN loai_khach
on khach_hang.id_loai_khach = loai_khach.id_loai_khach LEFT JOIN hop_dong
on khach_hang.id_khach_hang = hop_dong.id_khach_hang LEFT JOIN dich_vu
on hop_dong.id_dich_vu = dich_vu.id_dich_vu LEFT JOIN hop_dong_chi_tiet
on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong LEFT JOIN dich_vu_di_kem
on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
GROUP BY khach_hang.id_khach_hang;

-- task 6
SELECT dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, 
loai_dich_vu.ten_loai_dich_vu FROM loai_dich_vu LEFT JOIN dich_vu
on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu LEFT JOIN hop_dong
on dich_vu.id_dich_vu = hop_dong.id_dich_vu
WHERE loai_dich_vu.ten_loai_dich_vu NOT in 
(SELECT loai_dich_vu.ten_loai_dich_vu FROM dich_vu JOIN loai_dich_vu
on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu JOIN hop_dong
on dich_vu.id_dich_vu = hop_dong.id_dich_vu
WHERE hop_dong.ngay_ket_thuc BETWEEN '2019-01-01' and now()
GROUP BY loai_dich_vu.ten_loai_dich_vu);

-- task 7
SELECT dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da,
dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu FROM dich_vu JOIN loai_dich_vu
on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu JOIN hop_dong
on dich_vu.id_dich_vu = hop_dong.id_dich_vu
WHERE hop_dong.ngay_ket_thuc BETWEEN '2018-01-01' and '2018-12-31'
AND loai_dich_vu.ten_loai_dich_vu not in (
SELECT loai_dich_vu.ten_loai_dich_vu FROM dich_vu JOIN loai_dich_vu
on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu JOIN hop_dong
on dich_vu.id_dich_vu = hop_dong.id_dich_vu
WHERE hop_dong.ngay_ket_thuc BETWEEN '2019-01-01' and now()
GROUP BY loai_dich_vu.ten_loai_dich_vu)
GROUP BY dich_vu.ten_dich_vu;

-- task 8
SELECT DISTINCT ho_ten FROM khach_hang;

-- task 9
SELECT month(ngay_lam_hop_dong) as thang, count(id_khach_hang) as so_luong_khach_dat_phong
FROM hop_dong
WHERE year(ngay_lam_hop_dong) = 2019
GROUP BY thang
ORDER BY thang;

-- task 10
SELECT hop_dong_chi_tiet.id_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, 
hop_dong.tien_dat_coc, count(hop_dong_chi_tiet.id_hop_dong_chi_tiet) as so_luong_dich_vu_di_kem FROM hop_dong_chi_tiet
JOIN hop_dong
on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
GROUP BY hop_dong_chi_tiet.id_hop_dong
ORDER BY hop_dong_chi_tiet.id_hop_dong;

-- task 11
SELECT  dich_vu_di_kem.*, loai_khach.ten_loai_khach, khach_hang.dia_chi FROM dich_vu_di_kem JOIN hop_dong_chi_tiet
on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem JOIN hop_dong
on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong JOIN khach_hang
on hop_dong.id_khach_hang = khach_hang.id_khach_hang JOIN loai_khach
on loai_khach.id_loai_khach = khach_hang.id_loai_khach
WHERE loai_khach.ten_loai_khach = 'Diamond'
and khach_hang.dia_chi in ('Vinh', 'Quảng Ngãi')
GROUP BY dich_vu_di_kem.id_dich_vu_di_kem ;

-- task 12
SELECT hop_dong.id_hop_dong, nhan_vien.ho_ten as ten_nhan_vien, khach_hang.ho_ten as ten_khach_hang,
khach_hang.sdt, dich_vu.ten_dich_vu, count(hop_dong_chi_tiet.id_hop_dong_chi_tiet) as so_luong_dich_vu_di_kem,
hop_dong.tien_dat_coc, hop_dong.ngay_lam_hop_dong FROM hop_dong_chi_tiet
JOIN hop_dong
on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
JOIN khach_hang
on khach_hang.id_khach_hang = hop_dong.id_khach_hang
JOIN dich_vu
on hop_dong.id_dich_vu = dich_vu.id_dich_vu
JOIN dich_vu_di_kem
on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
JOIN nhan_vien
on nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
WHERE month(hop_dong.ngay_lam_hop_dong) in (10, 11, 12) AND year(hop_dong.ngay_lam_hop_dong) = 2019 
and hop_dong.id_dich_vu NOT in(select hop_dong.id_dich_vu FROM hop_dong 
WHERE  month(hop_dong.ngay_lam_hop_dong) BETWEEN 1 and 6 AND year(hop_dong.ngay_lam_hop_dong) = 2019)
GROUP BY hop_dong_chi_tiet.id_hop_dong
ORDER BY hop_dong_chi_tiet.id_hop_dong;

-- task 13
SELECT dich_vu_di_kem.*, count(dich_vu_di_kem.id_dich_vu_di_kem) as so_lan_dat FROM 
dich_vu_di_kem JOIN hop_dong_chi_tiet
on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
GROUP BY dich_vu_di_kem.id_dich_vu_di_kem;

SELECT dich_vu_di_kem.*, max(t.so_lan_dat) as so_lan_dat FROM dich_vu_di_kem, (
SELECT count(dich_vu_di_kem.id_dich_vu_di_kem) as so_lan_dat FROM 
dich_vu_di_kem JOIN hop_dong_chi_tiet
on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
GROUP BY dich_vu_di_kem.id_dich_vu_di_kem) as t;

-- task 14
SELECT hop_dong_chi_tiet.id_hop_dong, loai_dich_vu.ten_loai_dich_vu, dich_vu_di_kem.ten_dich_vu_di_kem,
count(dich_vu_di_kem.id_dich_vu_di_kem) as so_lan_su_dung FROM dich_vu_di_kem JOIN hop_dong_chi_tiet
on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem JOIN hop_dong
on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong JOIN dich_vu
on hop_dong.id_dich_vu = dich_vu.id_dich_vu JOIN loai_dich_vu
on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
GROUP BY dich_vu_di_kem.id_dich_vu_di_kem
HAVING so_lan_su_dung = 1;

-- task 15
SELECT nhan_vien.id_nhan_vien, nhan_vien.ho_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan,
nhan_vien.sdt, nhan_vien.dia_chi, count(hop_dong.id_nhan_vien) as so_hop_dong
FROM nhan_vien JOIN bo_phan
on bo_phan.id_bo_phan = nhan_vien.id_bo_phan JOIN trinh_do
on trinh_do.id_trinh_do = nhan_vien.id_trinh_do JOIN hop_dong
on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
WHERE year(hop_dong.ngay_lam_hop_dong) = 2018 
GROUP BY nhan_vien.id_nhan_vien 
HAVING so_hop_dong <= 3;

-- task 16
SET SQL_SAFE_UPDATES = 0;
	DELETE FROM nhan_vien
	WHERE NOT EXISTS (SELECT hop_dong.id_nhan_vien FROM hop_dong
	WHERE hop_dong.ngay_lam_hop_dong BETWEEN '2017-01-01' AND '2019-12-31' 
		AND hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien) ;	
        SET SQL_SAFE_UPDATES = 1;

-- task 17
UPDATE khach_hang
SET id_loai_khach = 4
WHERE id_loai_khach = 2 AND EXISTS
(SELECT khach_hang.id_khach_hang, hop_dong.ngay_lam_hop_dong,
sum(dich_vu.chi_phi_thue + dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong) as tong_tien
FROM loai_khach JOIN hop_dong JOIN dich_vu JOIN hop_dong_chi_tiet
JOIN dich_vu_di_kem
WHERE khach_hang.id_loai_khach = loai_khach.id_loai_khach 
AND khach_hang.id_khach_hang = hop_dong.id_khach_hang 
AND hop_dong.id_dich_vu = dich_vu.id_dich_vu 
AND hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong 
AND hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
GROUP BY khach_hang.id_khach_hang
HAVING tong_tien > 10000000 AND year(hop_dong.ngay_lam_hop_dong) = 2019 );

-- task 18
DELETE FROM khach_hang
WHERE EXISTS (SELECT * FROM hop_dong
WHERE year(hop_dong.ngay_lam_hop_dong) < 2016
AND hop_dong.id_khach_hang = khach_hang.id_khach_hang);

-- task 19
UPDATE dich_vu_di_kem
SET dich_vu_di_kem.gia = dich_vu_di_kem.gia * 2
WHERE EXISTS (SELECT hop_dong_chi_tiet.id_dich_vu_di_kem, count(hop_dong_chi_tiet.id_dich_vu_di_kem) 
as so_lan FROM hop_dong_chi_tiet 
JOIN hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
WHERE year(hop_dong.ngay_lam_hop_dong) = 2019
AND dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
GROUP BY hop_dong_chi_tiet.id_dich_vu_di_kem
HAVING so_lan > 10);

-- task 20
SELECT id_nhan_vien as id, ho_ten, email, sdt, ngay_sinh, dia_chi,"nhan vien" as loai FROM nhan_vien UNION ALL
SELECT id_khach_hang as id, ho_ten, email, sdt, ngay_sinh, dia_chi,"khách hàng" as loai FROM khach_hang;

-- task 21
CREATE VIEW V_NHANVIEN AS
SELECT nhan_vien.* FROM nhan_vien
JOIN hop_dong
WHERE nhan_vien.dia_chi = 'Hải Châu' AND nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
AND hop_dong.ngay_lam_hop_dong = '2019-12-12'
GROUP BY nhan_vien.id_nhan_vien;

SELECT * FROM V_NHANVIEN;

-- task 22
UPDATE nhan_vien, V_NHANVIEN
SET nhan_vien.dia_chi = 'Liên Chiểu'
WHERE nhan_vien.dia_chi = V_NHANVIEN.dia_chi;

-- task 23
Delimiter $$
DROP PROCEDURE IF EXISTS Sp_1 $$
CREATE PROCEDURE Sp_1(id INT)
BEGIN
DELETE FROM khach_hang
WHERE khach_hang.id_khach_hang = id;
END $$
Delimiter $$;

CALL Sp_1(2);

-- tas 24
Delimiter $$
DROP PROCEDURE IF EXISTS Sp_2 $$
CREATE PROCEDURE Sp_2(id_khach_hang int, id_loai_khach int, ho_ten VARCHAR(45), ngay_sinh DATE, 
so_cmnd VARCHAR(45), sdt VARCHAR(45), email VARCHAR(45), dia_chi VARCHAR(45))
BEGIN
INSERT INTO khach_hang(id_khach_hang, id_loai_khach, ho_ten, ngay_sinh, so_cmnd, sdt, email, dia_chi)
VALUES(id_khach_hang, id_loai_khach, ho_ten, ngay_sinh, so_cmnd, sdt, email, dia_chi);
END $$
Delimiter $$;

CALL Sp_2('5', '1', 'Trần Thành Công', '1975-10-08', '234521', '2344543', 'abc@abc.com', 'Quảng Trị')



