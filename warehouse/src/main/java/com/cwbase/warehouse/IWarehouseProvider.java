package com.cwbase.warehouse;

/**
 * A typical warehouse processing API. Implementation should implement a
 * warehouse type, not a particular location. A warehouse API should support
 * multiple location.
 * 
 * This interface support both internal warehouse management system and
 * third-party warehouses.
 * 
 * @author kmtong
 * 
 */
public interface IWarehouseProvider {

	/**
	 * Warehouse Type ID.
	 * 
	 * @return
	 */
	String getWarehouseTypeID();

	/**
	 * Query Service for a Warehouse Type.
	 * 
	 * @return
	 */
	IWarehouseQueryService getWarehouseQueryService();

	/**
	 * Warehouse Activity Service
	 * 
	 * @return
	 */
	IWarehouseActivityService getWarehouseActivityService();
}
