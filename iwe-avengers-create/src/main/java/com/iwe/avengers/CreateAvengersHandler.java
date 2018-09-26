package com.iwe.avengers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.iwe.avenger.dynamodb.entity.Avenger;
import com.iwe.avenger.lambda.response.HandlerResponse;
import com.iwe.avengers.dao.AvengerDAO;

public class CreateAvengersHandler implements RequestHandler<Avenger, HandlerResponse> {
	
	private AvengerDAO dao = new AvengerDAO();
	
	@Override
	public HandlerResponse handleRequest(final Avenger avenger, final Context context) {
		
		final Avenger avengerCreated = dao.save(avenger);
		
		final HandlerResponse response = HandlerResponse.builder().setObjectBody(avengerCreated).build();
		
		return response;

	}
}
