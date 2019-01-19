package pythagorean;

/**
 * Represents an error thrown by the InputPrompter class
 * 
 * @author japnaa
 */
public class InputError extends Exception {
	private static final long serialVersionUID = 8200172853872976718L;

	InputError(String message) {
		super(message);
	}

	InputError() {
		super();
	}
}
