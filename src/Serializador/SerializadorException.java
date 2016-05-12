package Serializador;

public class SerializadorException extends Exception {

	private static final long serialVersionUID = 5950646091103095787L;

	public SerializadorException(Exception e){
		super(e);
	} 
	
	public SerializadorException(String string){
		super(string);
	}
	
	
}
