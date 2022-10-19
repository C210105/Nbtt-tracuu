DROP TABLE IF EXISTS tracuu_thongtin;
CREATE TABLE tracuu_thongtin(
    sTT INT NOT NULL PRIMARY KEY,
    ten NCHAR(40),
    hangSanXuat NCHAR(30),
    gia INT,
    maSP NCHAR(5),
    tacDung NCHAR(200),
    tonKho INT
);

DROP TABLE IF EXISTS tracuu_nhanhieu;
CREATE TABLE tracuu_nhanhieu(
    maSP NCHAR(5) NOT NULL PRIMARY KEY,
    loaiSP NCHAR(30)
);