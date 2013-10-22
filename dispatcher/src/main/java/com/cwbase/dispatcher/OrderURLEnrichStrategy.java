package com.cwbase.dispatcher;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

/**
 * Archive the order to the repository service, return the URL from the raw
 * order repository service, mixing the attribute to the header field.
 * 
 * @author kmtong
 * 
 */
public class OrderURLEnrichStrategy implements AggregationStrategy {

	public final static String ORDER_URL_HEADER = "RawOrderURL";

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		oldExchange.getIn().setHeader(ORDER_URL_HEADER,
				newExchange.getIn().getBody());
		return oldExchange;
	}

}
