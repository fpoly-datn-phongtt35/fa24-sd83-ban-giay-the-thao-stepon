package com.example.stepon.service;

import com.example.stepon.entity.DotGiamGia;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class DotGiamGiaService {
    private List<DotGiamGia> dgg;
    public DotGiamGiaService(){
        this.dgg = new ArrayList<>();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            this.dgg.add(new DotGiamGia(1,"Siêu thu giảm giá","DGGThu","1",100,dateFormat.parse("07-08-2024"),dateFormat.parse("20-08-2024"),1));
            this.dgg.add(new DotGiamGia(2,"Siêu xuân giảm giá","DGGXuan","2",50,dateFormat.parse("07-02-2024"),dateFormat.parse("20-02-2024"),1));
            this.dgg.add(new DotGiamGia(3,"Siêu hạ giảm giá","DGGHa","3",20,dateFormat.parse("07-05-2024"),dateFormat.parse("20-05-2024"),1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<DotGiamGia> getAll() {
        return this.dgg;
    }
}
