package com.example.mp.repository;

import com.example.mp.entity.AuctionLot;

import java.util.List;

public interface AuctionLotRepository {
    List<AuctionLot> findAll();
    AuctionLot findById(long id);
    void create(AuctionLot auctionLot);
    void update(AuctionLot auctionLot);
    void deleteById(long id);
}
