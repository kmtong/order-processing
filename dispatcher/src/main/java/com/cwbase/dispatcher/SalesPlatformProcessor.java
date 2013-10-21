package com.cwbase.dispatcher;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.Headers;

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
		for (ISalesPlatformProvider p : salesPlatformProviders) {
			if (p.getSalesPlatformID() != null
					&& p.getSalesPlatformID().equals(
							headers.get(SALES_PLATFORM_ID_HEADER))) {
				return p.getOrderParser().parse(rawData);
			}
		}
		throw new RuntimeException(
				"No Support Plugin to Support SalesPlatformID");
	}
}
