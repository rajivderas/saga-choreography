package com.rajivderas.saga.order.repository;

import com.rajivderas.saga.order.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<PurchaseOrder, Integer> {
}
