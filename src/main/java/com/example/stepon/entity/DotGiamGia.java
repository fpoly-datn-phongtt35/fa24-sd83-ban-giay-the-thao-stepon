package com.example.stepon.entity;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class DotGiamGia {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Integer id;
//    @Column(name = "ten")
    private String ten;
//    @Column(name = "ma_giam_gia")
    private String magiamgia;
//    @Column(name = "loai")
    private String loai;
//    @Column(name = "gia_tri_dot_giam_gia")
    private float gtdgiamgia;
//    @Column(name = "ngay_bat_dau")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaybatdau;
//    @Column(name = "ngay_ket_thuc")
@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayketthuc;
//    @Column(name = "trang_thai")
    private Integer trangthai;
}
