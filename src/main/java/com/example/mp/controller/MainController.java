package com.example.mp.controller;

import com.example.mp.entity.AuctionLot;
import com.example.mp.service.AuctionLotService;
import com.example.mp.service.UserService;
import com.example.mp.test.TestUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class MainController {
    private final AuctionLotService auctionLotService;
    private final UserService userService;

    //todo
    @GetMapping()
    public String index(Model model, @ModelAttribute("bid") AuctionLot auctionLot){
        List<AuctionLot> lots = auctionLotService.findAll();
        lots.sort(Comparator.comparing(AuctionLot::getId).reversed());
        model.addAttribute("lots", lots);
        model.addAttribute("user", userService.findById(TestUser.id));
        return "index";
    }
    //todo
    @PostMapping("/{id}")
    public String makeBid(@PathVariable("id") Long lotId, @ModelAttribute("bid") AuctionLot auctionLot){
        auctionLotService.update(TestUser.id, lotId, auctionLot.getBidInc());
        return "redirect:/";
    }

}
