package etc.exception;

import java.io.IOException;

public class MyException extends IOException{

	public MyException() {
		super();
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyException(String message) {
		super(message);
	}

	public MyException(Throwable cause) {
		super(cause);
	}
	
}
