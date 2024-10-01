package com.example.stepon.controller;

import com.example.stepon.entity.DotGiamGia;
import com.example.stepon.repository.DotGiamGiaRepository;
import com.example.stepon.service.DotGiamGiaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("api")
public class DotGiamGiaController {

    DotGiamGiaRepository ggRepo = new DotGiamGiaRepository();

    @GetMapping("dotgiamgia")
    public String getAll(Model model) {
        List<DotGiamGia> gg = this.ggRepo.getAll();
        model.addAttribute("giamgia", gg);
        return "dot_giam_gia/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("dotGiamGia", new DotGiamGia());
        return "dot_giam_gia/add";
    }

    @PostMapping("store")
    public String store(@Valid DotGiamGia gg, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            // Nếu có lỗi, trả về lại form cùng với thông báo lỗi
            model.addAttribute("dotGiamGia", gg); // Giữ lại dữ liệu mà người dùng đã nhập
            return "dot_giam_gia/add";  // Trả về lại trang thêm để sửa lỗi
        }

        // Nếu không có lỗi, lưu đối tượng DotGiamGia vào database
        this.ggRepo.create(gg);

        // Thêm thông báo thành công và chuyển hướng về trang danh sách
        redirectAttributes.addFlashAttribute("successMessage", "Đợt giảm giá đã được tạo thành công!");
        return "redirect:/api/dotgiamgia";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        this.ggRepo.deleteById(id);
        return "redirect:/api/dotgiamgia";
    }
    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        DotGiamGia gg = this.ggRepo.findById(id);
        model.addAttribute("dotGiamGia", gg);
        return "dot_giam_gia/detail";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        DotGiamGia gg = this.ggRepo.findById(id);
        model.addAttribute("dotGiamGia", gg);
        return "dot_giam_gia/edit";
    }

    @PostMapping("update/{id}")
    public String update(DotGiamGia gg){
        this.ggRepo.update(gg);
        return "redirect:/api/dotgiamgia";
    }

}
