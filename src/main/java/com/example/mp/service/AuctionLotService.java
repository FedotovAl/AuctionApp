package com.example.mp.service;


import com.example.mp.entity.AuctionLot;
import com.example.mp.entity.Item;
import com.example.mp.entity.Status;
import com.example.mp.entity.User;
import com.example.mp.repository.AuctionLotRepository;
import com.example.mp.repository.ItemRepository;
import com.example.mp.repository.StatusRepository;
import com.example.mp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class AuctionLotService {

    private final AuctionLotRepository auctionLotRepository;
    private final ItemRepository itemRepository;
    private final StatusRepository statusRepository;
    private final UserRepository userRepository;

    public List<AuctionLot> findAll(){
        return auctionLotRepository.findAll();
    }

    public void create(long itemId, AuctionLot auctionLot){
        Item item = itemRepository.findById(itemId);
        Status status = statusRepository.findByName("ACTIVE");
        auctionLot.setItem(item);
        auctionLot.setStatus(status);
        auctionLotRepository.create(auctionLot);
    }
    public void update(long userId, long lotId, BigDecimal bid){
        User user = userRepository.findById(userId);
        AuctionLot auctionLot = auctionLotRepository.findById(lotId);
        auctionLot.setBestOffer(bid);
        auctionLot.setHighestBidUser(user);
        auctionLotRepository.update(auctionLot);

    }
}
