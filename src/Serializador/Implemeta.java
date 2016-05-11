package Serializador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Implemeta<T> implements Serializador<T> {

	@Override
	public void Gravar(T t, File file) throws SerializadorException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T Ler(File file) throws SerializadorException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
