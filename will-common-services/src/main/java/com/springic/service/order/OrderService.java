package com.springic.service.order;


import com.springic.entity.order.OrdersEntity;
import com.springic.req.order.OrderInsertReq;
import com.springic.req.order.OrderQueryReq;

import java.util.List;

/**
 * @author will
 * @date 2017/11/9 下午10:20
 * @description
 */
public interface OrderService {


    List<OrdersEntity> findOrdersForBuyer(OrderQueryReq orderQueryReq, String buyerId);

    List<OrdersEntity> findOrdersForSeller(OrderQueryReq orderQueryReq, String sellerId);

    List<OrdersEntity> findOrdersForAdmin(OrderQueryReq orderQueryReq);

    String placeOrder(OrderInsertReq orderInsertReq, String buyerId);

    String pay(String orderId, String userId);

    void cancelOrder(String orderId, String userId);

    void confirmDelivery(String orderId, String expressNo, String userId);

    void confirmReceive(String orderId, String userId);

}
