package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("request")
public class SpringMVCService {
	@Autowired
	TestService testService;

	@RequestMapping("/greeting")
	public String greeting() {
		return testService.getMessage();
	}
}
