package com.tinybank.api.web.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;
    private String displayName;

    public AccountEntity(CustomerEntity customerEntity, String displayName) {
        this.customerEntity = customerEntity;
        this.displayName = displayName;
    }
}
