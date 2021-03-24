package com.example.mp.controller;

import com.example.mp.entity.AuctionLot;
import com.example.mp.service.AuctionLotService;
import com.example.mp.service.SecurityService;
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
    private final SecurityService securityService;

    @GetMapping()
    public String index(Model model){
        List<AuctionLot> lots = auctionLotService.findAll();
        lots.sort(Comparator.comparing(AuctionLot::getId).reversed());
        model.addAttribute("lots", lots);
        model.addAttribute("authUser", securityService.getAuthUser());
        return "index";
    }

    @PostMapping("/bids/{id}")
    public String makeBid(@PathVariable("id") Long lotId,
                          @RequestParam("bid") BigDecimal bid){
        auctionLotService.update(securityService.getAuthUser().getId(), lotId, bid);
        return "redirect:/";
    }

}
