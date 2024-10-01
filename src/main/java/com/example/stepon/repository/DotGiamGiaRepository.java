package com.example.stepon.repository;

import com.example.stepon.entity.DotGiamGia;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class DotGiamGiaRepository {
    private List<DotGiamGia> dgg;
    public DotGiamGiaRepository(){
        this.dgg = new ArrayList<>();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            this.dgg.add(new DotGiamGia(1,"Siêu thu giảm giá","DGGThu","1",100,dateFormat.parse("07-08-2024"),dateFormat.parse("20-08-2024"),1));
            this.dgg.add(new DotGiamGia(2,"Siêu xuân giảm giá","DGGXuan","2",50,dateFormat.parse("07-02-2024"),dateFormat.parse("20-02-2024"),0));
            this.dgg.add(new DotGiamGia(3,"Siêu hạ giảm giá","DGGHa","3",20,dateFormat.parse("07-05-2024"),dateFormat.parse("20-05-2024"),0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<DotGiamGia> getAll() {
        return this.dgg;
    }
    public void create(DotGiamGia gg){
        this.dgg.add(gg);
    }
    public void delete(DotGiamGia gg, Integer id) {
        Optional<DotGiamGia> existingGG = this.dgg.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();

        if (existingGG.isPresent()) {
            this.dgg.remove(existingGG.get());
            System.out.println("Discount deleted successfully.");
        } else {
            System.out.println("Discount not found with ID: " + id);
        }
    }
    public void deleteById(int id){
        for (int i = 0; i < this.dgg.size(); i++){
            DotGiamGia sp= this.dgg.get(i);
            if (sp.getId() == id){
                this.dgg.remove(i);
            }
        }
    }
        public void update(DotGiamGia newValue) {
            for (int i = 0; i < this.dgg.size(); i++) {
                DotGiamGia oldValue = this.dgg.get(i);
                if (oldValue.getId() == newValue.getId()) {
                    this.dgg.set(i,newValue);
                }
            }
        }
    public DotGiamGia findById(Integer id) {
        for (int i = 0; i < this.dgg.size(); i++) {
            DotGiamGia sp = this.dgg.get(i);
            if (sp.getId() == id) {
                return sp;
            }
        }
        return null;
    }


    // Update method
//    public void update(DotGiamGia gg, Integer id) {
//        Optional<DotGiamGia> existingGG = this.dgg.stream()
//                .filter(d -> d.getId().equals(id))
//                .findFirst();
//
//        if (existingGG.isPresent()) {
//            DotGiamGia foundGG = existingGG.get();
//            // Update the found object with the new values
//            foundGG.setName(gg.getName());
//            foundGG.setCode(gg.getCode());
//            foundGG.setDiscountType(gg.getDiscountType());
//            foundGG.setPercentage(gg.getPercentage());
//            foundGG.setStartDate(gg.getStartDate());
//            foundGG.setEndDate(gg.getEndDate());
//            foundGG.setStatus(gg.getStatus());
//
//            System.out.println("Discount updated successfully.");
//        } else {
//            System.out.println("Discount not found with ID: " + id);
//        }
//    }
}
