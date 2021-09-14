package com.rajivderas.saga.commons.event;

import com.rajivderas.saga.commons.dto.OrderRequestDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
public class OrderEvent implements Event {

    private UUID eventId = UUID.randomUUID();
    private Date eventDate = new Date();
    private OrderRequestDto orderRequest;
    private OrderStatus orderStatus;

    public OrderEvent(OrderRequestDto orderRequest, OrderStatus orderStatus) {
        this.orderRequest = orderRequest;
        this.orderStatus = orderStatus;
    }

    @Override
    public UUID getEventId() {
        return eventId;
    }

    @Override
    public Date getDate() {
        return eventDate;
    }
}
