package Serializador;

import java.io.File;

public interface Serializador <T>{
	
	public void Gravar(T t, File file)throws SerializadorException;
	
	public T Ler(File file)throws SerializadorException;
}
