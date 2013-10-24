package com.cwbase.warehouse;

import java.util.List;

import com.cwbase.model.GoodReceive;
import com.cwbase.model.Order;

/**
 * Activities within a warehouse.
 * <ul>
 * <li>Receiving
 * <li>Wave/Batch Planning
 * <li>Picking
 * <li>Packing
 * <li>Shipping
 * <li>Returns
 * </ul>
 * 
 * Activities between warehouses
 * <ul>
 * <li>Transfer
 * </ul>
 * 
 * @author kmtong
 * 
 */
public interface IWarehouseActivityService {

	/**
	 * Good Receive may trigger Order Processing (for zero-stock SKUs).
	 * 
	 * @param receive
	 * @param at
	 */
	void receive(GoodReceive receive, Warehouse at);

	/**
	 * Take the orders and commit the warehouse will fulfill the orders.
	 * 
	 * @param orders
	 */
	void commit(List<Order> orders, Warehouse at);
}
