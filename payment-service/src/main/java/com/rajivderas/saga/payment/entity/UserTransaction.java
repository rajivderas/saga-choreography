package com.rajivderas.saga.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_TRANSACTION_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTransaction {

    @Id
    private Integer orderId;
    private Integer userId;
    private Integer amount;


}
