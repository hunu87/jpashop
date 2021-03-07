package jpabook.jpashop.exception;

public class NotEnoughStockException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NotEnoughStockException() {
		super();
	}
	
	public NotEnoughStockException(String message) {
		super(message);
	}
	
	public NotEnoughStockException(String messege, Throwable cause) {
		super(messege, cause);
	}
	
	public NotEnoughStockException(Throwable cause) {
		super(cause);
	}
}
