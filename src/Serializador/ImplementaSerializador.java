package Serializador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public class ImplementaSerializador<T> implements Serializador<T> {

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
		
		try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			
			Object object = ois.readObject();
			
			Class<?> clGenType = (Class<?>) ((ParameterizedType)getClass()
					.getGenericSuperclass())
					.getActualTypeArguments()[0];
			if(!object.getClass().equals(clGenType)){
				throw new SerializadorException("Os tipos são Diferentes !");
			}
			
		return (T) object;
	
	}catch(Exception e){
		throw new SerializadorException(e);
	}
}

	
}
