package by.htp.reflection;

public class ConcreteComponent implements SomeContainerComponent {

	public void init() {
		System.out.println("Init method.");
		
	}

	public String execute(String params) {
		System.out.println("params=" + params);
		return "result string";
	}

}
