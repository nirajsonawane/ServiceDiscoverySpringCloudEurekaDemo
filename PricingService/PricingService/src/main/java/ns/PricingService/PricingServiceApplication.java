package ns.PricingService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class PricingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PricingServiceApplication.class, args);
	}

}
@RestController
@Slf4j
class ServiceInstanceRestController {

    @Autowired
    private DiscountServiceClient discountServiceClient;

    @GetMapping("/price/{product}")
    public String getPriceForProduct(@PathVariable("product") String product) {
      int discount = discountServiceClient.getDiscountPercentage("Test");
        log.info("Discount is {}",discount);
        return "Price";
    }
}

@FeignClient("discount-service")
interface DiscountServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/discount/{product}")
    int getDiscountPercentage(@PathVariable("product") String product);
}
