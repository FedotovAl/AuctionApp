package com.example.mp.repository;

import com.example.mp.entity.AuctionLot;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class AuctionLotRepositoryImpl implements AuctionLotRepository{

    private final SessionFactory sessionFactory;

    @Override
    public List<AuctionLot> findAll()
    {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from AuctionLot", AuctionLot.class).getResultList();
    }

    @Override
    public AuctionLot findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(AuctionLot.class, id);
    }

    @Override
    public void create(AuctionLot auctionLot) {
        Session session = sessionFactory.getCurrentSession();
        session.save(auctionLot);
    }

    @Override
    public void update(AuctionLot auctionLot) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(auctionLot);
    }

    @Override
    public void deleteById(long id) {

    }
}
