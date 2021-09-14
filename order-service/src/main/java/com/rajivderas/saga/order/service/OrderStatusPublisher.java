package com.rajivderas.saga.order.service;


import com.rajivderas.saga.commons.dto.OrderRequestDto;
import com.rajivderas.saga.commons.event.OrderEvent;
import com.rajivderas.saga.commons.event.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
public class OrderStatusPublisher {

    @Autowired
    private Sinks.Many<OrderEvent> orderSinks;

    public void publishOrderEvent(OrderRequestDto orderRequestDto, OrderStatus orderStatus) {
        OrderEvent orderEvent = new OrderEvent(orderRequestDto, orderStatus);
        orderSinks.tryEmitNext(orderEvent);
    }
}
