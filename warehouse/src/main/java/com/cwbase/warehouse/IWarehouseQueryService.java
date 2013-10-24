package com.cwbase.warehouse;

import java.util.List;

/**
 * Query all aspects of the warehouse.
 * 
 * @author kmtong
 * 
 */
public interface IWarehouseQueryService {

	/**
	 * All warehouses
	 * 
	 * @return
	 */
	List<Warehouse> getAllWarehouses();
}
