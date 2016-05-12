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
		
		Class<?>[] vet = t.getClass().getInterfaces();
		
		boolean achou = false;
		
		for(Class<?> class1 : vet){
			if(class1.equals(Serializable.class)){
				achou = true;
				break;
			}
		}
		if(!achou){
			throw new SerializadorException("Classe nao" + "Implementa Serializable.");
		}
		try(FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(t);
		}catch(Exception e){
			throw new SerializadorException(e);
		}
	}
	

	@Override
	public T Ler(File file) throws SerializadorException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
