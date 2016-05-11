package br.univel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TesteGravando {
	
	public static void main(String[]args){
		
		Cliente cl0riginal = new Cliente();
		cl0riginal.setId(1);
		cl0riginal.setNome("Pontin");
		
		File file = new File("arquivo.dat");
		
		try(FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(cl0riginal);
			
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("Executo");
	}
}
