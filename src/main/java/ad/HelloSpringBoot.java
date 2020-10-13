package ad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //是spring4里的新注解，是@ResponseBody和@Controller的缩写
public class HelloSpringBoot {
	
	@RequestMapping("/slideshow")
	public String hello() {
		return "homepage/slideshow";
	}
}
