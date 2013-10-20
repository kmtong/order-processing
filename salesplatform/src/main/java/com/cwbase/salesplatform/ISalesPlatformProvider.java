package com.cwbase.salesplatform;

/**
 * Sales Platform Provider API.
 * 
 * Service Provider need to implement several aspect of interactions with the
 * sales platform.
 * 
 * @author kmtong
 * 
 */
public interface ISalesPlatformProvider {

	/**
	 * Sales Order Format Parser / Converter
	 * 
	 * @return
	 */
	ISalesOrderParser getOrderParser();

	/**
	 * Logistic Tracking Number Update back to the Platform
	 * 
	 * @return
	 */
	ILogisticUpdateProcessor getLogisticUpdateProcessor();
}
