package com.example.mp.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "auction_lot")
public class AuctionLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "startprice")
    private BigDecimal startPrice;

    @Column(name = "bid_inc")
    private BigDecimal bidInc;

    @Column(name = "bestoffer")
    private BigDecimal bestOffer;

    @Column(name = "stopdate")
    private Date stopDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itemid")
    @ToString.Exclude
    private Item item;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bidderid")
    private User highestBidUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "statusid")
    private Status status;
}
