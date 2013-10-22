package com.cwbase.dispatcher;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.Headers;

import com.cwbase.model.Order;
import com.cwbase.salesplatform.ISalesPlatformProvider;

public class SalesPlatformProcessor {

	public static String SALES_PLATFORM_ID_HEADER = "SalesPlatformID";

	List<ISalesPlatformProvider> salesPlatformProviders;

	public List<ISalesPlatformProvider> getSalesPlatformProviders() {
		return salesPlatformProviders;
	}

	public void setSalesPlatformProviders(
			List<ISalesPlatformProvider> salesPlatformProviders) {
		this.salesPlatformProviders = salesPlatformProviders;
	}

	/**
	 * Process Order Splitting
	 * 
	 * @param headers
	 * @param rawData
	 * @return
	 */
	public Iterator<String> processSplit(@Headers Map<String, String> headers,
			@Body String rawData) {
		String salesPlatformID = headers.get(SALES_PLATFORM_ID_HEADER);
		ISalesPlatformProvider p = getSalesPlatformProvider(salesPlatformID);
		if (p == null) {
			throw new RuntimeException(
					"No Support Plugin to Support SalesPlatformID: "
							+ salesPlatformID);
		}
		return p.getOrderParser().parse(rawData);
	}

	/**
	 * Parse order raw data to standard order
	 * 
	 * @param headers
	 * @param rawOrder
	 * @return
	 */
	public Order processParse(@Headers Map<String, String> headers,
			@Body String rawOrder) {
		String salesPlatformID = headers.get(SALES_PLATFORM_ID_HEADER);
		ISalesPlatformProvider p = getSalesPlatformProvider(salesPlatformID);
		if (p == null) {
			throw new RuntimeException(
					"No Support Plugin to Support SalesPlatformID: "
							+ salesPlatformID);
		}
		// XXX save to raw order repository
		URL rawOrderSourceURL = null;
		return p.getOrderParser().extract(rawOrder, rawOrderSourceURL);
	}

	protected ISalesPlatformProvider getSalesPlatformProvider(
			String salesPlatformID) {
		for (ISalesPlatformProvider p : salesPlatformProviders) {
			if (p.getSalesPlatformID() != null
					&& p.getSalesPlatformID().equals(salesPlatformID)) {
				return p;
			}
		}
		return null;
	}
}
