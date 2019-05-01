package ns.DiscountService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class DiscountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscountServiceApplication.class, args);
	}

}
@RestController
@RequestMapping("/discount/{product}")
@Slf4j
class DiscountController{

	@GetMapping
	public int getDiscountPercentage(@PathVariable("product") String product){
		log.info("Getting Discount for Product {}",product);
		return  50;
	}

}
