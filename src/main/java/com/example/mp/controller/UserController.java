package com.example.mp.controller;

import com.example.mp.entity.AuctionLot;
import com.example.mp.entity.Item;
import com.example.mp.service.AuctionLotService;
import com.example.mp.service.ItemService;
import com.example.mp.service.SecurityService;
import com.example.mp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final ItemService itemService;
    private final AuctionLotService auctionLotService;
    private final SecurityService securityService;

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model){
        List<Item> items = new ArrayList<>(userService.findById(id).getItemSet());
        items.sort(Comparator.comparing(Item::getId).reversed());
        model.addAttribute("items", items);
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("authUser", securityService.getAuthUser());
        return "profile";
    }

    @GetMapping("/{id}/newitem")
    public String createItem(@PathVariable("id") Long id,
                             @ModelAttribute("item") Item item,
                             Model model){
        if (!securityService.getAuthUser().getId().equals(id)){
            return "redirect:/user/" + id;
        }
        model.addAttribute("user", userService.findById(id));
        return "add_item";
    }

    @PostMapping("/{id}/newitem")
    public String createItem(@PathVariable("id") Long userId,
                             @ModelAttribute("item") @Valid Item item,
                             BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "add_item";
        }
        itemService.create(userId, item);
        return "redirect:/user/" + userId;
    }

    @GetMapping("/{userId}/item/{itemId}/edit")
    public String editItem(@PathVariable("userId") long userID,
                           @PathVariable("itemId") long itemID,
                           Model model){
        if (!securityService.getAuthUser().getId().equals(userID)){
            return "redirect:/user/" + userID;
        }
        model.addAttribute("item", itemService.findById(itemID));
        model.addAttribute("user", userService.findById(userID));
        return "edit_item";
    }

    @PatchMapping("/{userId}/item/{itemId}")
    public String editItem(@PathVariable("userId") long userID,
                           @PathVariable("itemId") long itemID,
                           @ModelAttribute("item") @Valid Item item,
                           BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "edit_item";
        }
        itemService.update(itemID, item);
        return "redirect:/user/" + userID;
    }

    @GetMapping("/{userId}/item/{itemId}/createlot")
    public String createLot(@PathVariable("userId") long userID,
                            @PathVariable("itemId") long itemID,
                            @ModelAttribute("lot") AuctionLot auctionLot,
                            Model model){
        if (!securityService.getAuthUser().getId().equals(userID)){
            return "redirect:/user/" + userID;
        }
        model.addAttribute("item", itemService.findById(itemID));
        model.addAttribute("user", userService.findById(userID));
        return "create_lot";
    }

    @PostMapping("/{userId}/item/{itemId}/createlot")
    public String createLot(@PathVariable("userId") long userID,
                            @PathVariable("itemId") long itemID,
                            @ModelAttribute("lot") AuctionLot auctionLot,
                            BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "create_lot";
        }
        auctionLotService.create(itemID, auctionLot);
        return "redirect:/";
    }
}
