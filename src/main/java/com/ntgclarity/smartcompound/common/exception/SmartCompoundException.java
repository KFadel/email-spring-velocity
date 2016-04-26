package com.ntgclarity.smartcompound.common.exception;

/**
*
* @author Mai and karim 
*/
public class SmartCompoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8285317130490037653L;
	
	private String message = null;

	public SmartCompoundException()
	{
	}

	public SmartCompoundException(String message)
	{
		super(message);
		this.message = message;
	}

	public SmartCompoundException(Throwable cause)
	{
		super(cause);
	}

	public SmartCompoundException(String message, Throwable cause)
	{
		super(message, cause);
		this.message = message;
	}

	public SmartCompoundException(String message, Throwable cause, 
                                       boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
		this.message = message;
	}
	
	@Override
    public String toString() {
        return message;
    }
 
    @Override
    public String getMessage() {
        return message;
    }

	@Override
	public String getLocalizedMessage() {
		return message;
	}
    

}
