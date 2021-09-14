package com.rajivderas.saga.order.service;

import com.rajivderas.saga.commons.dto.OrderRequestDto;
import com.rajivderas.saga.commons.event.OrderStatus;
import com.rajivderas.saga.order.entity.PurchaseOrder;
import com.rajivderas.saga.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStatusPublisher orderStatusPublisher;

    @Transactional
    public PurchaseOrder createOrder(OrderRequestDto orderRequestDto) {
        PurchaseOrder order = orderRepository.save(convertDtoToEntity(orderRequestDto));
        orderRequestDto.setOrderId(order.getId());

        orderStatusPublisher.publishOrderEvent(orderRequestDto, OrderStatus.ORDER_CREATED);

        return order;
    }

    public List<PurchaseOrder> getAllOrders() {
        return orderRepository.findAll();
    }


    private PurchaseOrder convertDtoToEntity(OrderRequestDto orderRequestDto) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setProductId(orderRequestDto.getProductId());
        purchaseOrder.setPrice(orderRequestDto.getAmount());
        purchaseOrder.setOrderStatus(OrderStatus.ORDER_CREATED);
        purchaseOrder.setUserId(orderRequestDto.getUserId());

        return purchaseOrder;
    }
}
