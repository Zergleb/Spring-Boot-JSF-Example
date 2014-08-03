package hello;

public class Greeting {

	private final long id;
	private final String content;

	private String monkey;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getMonkey() {
		return monkey;
	}

	public void setMonkey(String monkey) {
		this.monkey = monkey;
	}
}
