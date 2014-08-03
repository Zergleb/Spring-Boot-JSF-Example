package hello;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("session")
public class TestService {

	private int counter = 0;

	public String getMessage() {
		return "This is my message " + counter++;
	}
}
