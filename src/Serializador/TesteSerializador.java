package Serializador;

import java.io.File;

import br.univel.Cliente;

public class TesteSerializador {

	public static void main(String[]args){
		Cliente c = new Cliente();
		c.setId(1);
		c.setNome("Gabriel Pontin");
		
		File file = new File("Cliente.dat");
		ImplementaSerializador<Cliente> ser = new ImplementaSerializador<Cliente>();
		
		try{
			ser.Gravar(c, file);
			
			Cliente cLido = ser.Ler(file);
			
			System.out.println(cLido.getId());
			System.out.println(cLido.getNome());
		}catch(SerializadorException e){
			e.printStackTrace();
		}
	}
	
}
