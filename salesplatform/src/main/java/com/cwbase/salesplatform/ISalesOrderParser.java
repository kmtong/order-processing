package com.cwbase.salesplatform;

import java.net.URL;
import java.util.Iterator;

import com.cwbase.model.Order;

/**
 * Parse the raw order to standard order model.
 * 
 * Normally sales orders are downloaded from the sales platform in batch. The
 * interface is responsible to:
 * 
 * <ol>
 * <li>extract the original batch file into many individual raw orders</li>
 * <li>convert from a raw order to a standard order</li>
 * </ol>
 * 
 * Orders are uniquely identified by Sales Platform ID and the Order ID.
 * 
 * @author kmtong
 * 
 */
public interface ISalesOrderParser {

	/**
	 * Parse the raw order files, and convert into individual orders.
	 * 
	 * @param rawOrders
	 * @return
	 */
	Iterator<String> parse(String rawOrders);

	/**
	 * Extract a raw order to standard order format.
	 * 
	 * @param rawOrder
	 * @param rawOrderSourceURL
	 * @return
	 */
	Order extract(String rawOrder, URL rawOrderSourceURL);
}
