package com.example.mp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name should not be empty")
    @Size(min = 8, max = 50, message = "Name size should be {8 : 50}")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Address should not be empty")
    @Size(min = 10, max = 255, message = "Address size should be {10 : 255}")
    @Column(name = "address")
    private String address;

    @NotBlank(message = "Login should not be empty")
    @Size(min = 3, max = 16, message = "Login size should be {3 : 16}")
    @Column(name = "login")
    private String login;

    @NotBlank(message = "Password should not be empty")
    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleid")
    private Role role;

    @OneToMany(mappedBy = "itemOwner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<Item> itemSet;

    @OneToMany(mappedBy = "highestBidUser", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<AuctionLot> auctionLotBidSet;
}

