package com.cwbase.platform.demo;

import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;

import com.cwbase.model.Order;
import com.cwbase.salesplatform.ILogisticUpdateProcessor;
import com.cwbase.salesplatform.ISalesOrderParser;
import com.cwbase.salesplatform.ISalesPlatformProvider;

public class DemoSalesPlatformProvider implements ISalesPlatformProvider {

	@Override
	public String getSalesPlatformID() {
		return "1";
	}

	@Override
	public ISalesOrderParser getOrderParser() {
		return new ISalesOrderParser() {

			@Override
			public Iterator<String> parse(String rawOrders) {
				return Arrays.asList(rawOrders.split("\\n")).iterator();
			}

			@Override
			public Order extract(String rawOrder, URL rawOrderSourceURL) {
				return new Order();
			}

		};
	}

	@Override
	public ILogisticUpdateProcessor getLogisticUpdateProcessor() {
		return new ILogisticUpdateProcessor() {

		};
	}

}
