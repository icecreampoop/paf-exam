package ibf2024.assessment.paf.batch4.services;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public class BeerService {

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public String placeOrder(MultiValueMap<String,Integer> form) {
		// TODO: Task 5 
		String uuid = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
		String orderNumber = uuid.substring(uuid.length() - 8);
		//TODO map sanitize form into order quantity etc.
		// map to json
		// im out of time lol
		LocalDate currentDate = LocalDate. now();
		return orderNumber;
	}

}
