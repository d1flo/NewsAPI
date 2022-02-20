//this class was created in order to have all the exceptions together to avoid repeating throw exception each time 

package exception;

public class NewsAPIException extends Exception {
	public NewsAPIException() {
        super();
    }

    public NewsAPIException(String message) {
        super(message);
    }

    public NewsAPIException(String message, Throwable cause) {
        super(message, cause);
    }

    public NewsAPIException(Throwable cause) {
        super(cause);
    }

    protected NewsAPIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
