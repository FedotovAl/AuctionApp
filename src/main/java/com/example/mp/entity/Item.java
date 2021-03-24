package com.example.mp.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Item name should not be empty")
    @Size(min = 8, max = 50, message = "Item name size should be {8 : 50}")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Description should not be empty")
    @Size(min = 10, max = 255, message = "Description size should be {10 :255}")
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    private User itemOwner;

    @OneToOne(mappedBy = "item", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private AuctionLot auctionLot;
}
