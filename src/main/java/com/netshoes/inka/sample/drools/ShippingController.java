package com.netshoes.inka.sample.drools;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netshoes.inka.sample.drools.facts.DynamicShipping;
import com.netshoes.inka.sample.drools.facts.Order;

@RestController
public class ShippingController {

	@Autowired
	ShippingService shippingService;

	@RequestMapping(value = "calculate", method = { GET, POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DynamicShipping> calculate(@RequestBody Order order) {

		DynamicShipping dynamicShipping = shippingService.calculate(order);

		return ResponseEntity.ok(dynamicShipping);
	}

}
