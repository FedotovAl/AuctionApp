package com.example.mp.controller;

import com.example.mp.entity.AuctionLot;
import com.example.mp.entity.Item;
import com.example.mp.service.AuctionLotService;
import com.example.mp.service.ItemService;
import com.example.mp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final UserService userService;
    private final ItemService itemService;
    private final AuctionLotService auctionLotService;

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model){
        List<Item> items = new ArrayList<>(userService.findById(id).getItemSet());
        items.sort(Comparator.comparing(Item::getId).reversed());
        model.addAttribute("items", items);
        model.addAttribute("user", userService.findById(id));
        return "profile";
    }

    @GetMapping("/{id}/newitem")
    public String createItem(@PathVariable("id") Long id,
                             Model model,
                             @ModelAttribute("item") Item item){
        model.addAttribute("user", userService.findById(id));
        return "add_item";
    }

    @PostMapping("/{id}/newitem")
    public String createItem(@PathVariable("id") Long userId, @ModelAttribute("item") Item item){
        itemService.create(userId, item);
        return "redirect:/profile/" + userId;
    }

    @GetMapping("/{p_id}/item/{i_id}/createlot")
    public String createLot(@PathVariable("p_id") long profileID,
                            @PathVariable("i_id") long itemID,
                            Model model,
                            @ModelAttribute("lot") AuctionLot auctionLot){
        model.addAttribute("item", itemService.findById(itemID));
        model.addAttribute("user", userService.findById(profileID));
        return "create_lot";
    }

    @PostMapping("/{p_id}/item/{i_id}/createlot")
    public String createLot(@PathVariable("p_id") long profileID,
                            @PathVariable("i_id") long itemID,
                            @ModelAttribute("lot") AuctionLot auctionLot){
        auctionLotService.create(itemID, auctionLot);
        return "redirect:/";
    }

    @GetMapping("/{p_id}/item/{i_id}/edit")
    public String editItem(@PathVariable("p_id") long profileID,
                           @PathVariable("i_id") long itemID,
                           Model model){
        model.addAttribute("item", itemService.findById(itemID));
        model.addAttribute("user", userService.findById(profileID));
        return "edit_item";
    }

    @PatchMapping("/{p_id}/item/{i_id}")
    public String editItem(@PathVariable("p_id") long profileID,
                           @PathVariable("i_id") long itemID,
                           @ModelAttribute("item") Item item){
        itemService.update(itemID, item);
        return "redirect:/profile/" + profileID;
    }

}
