import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RepositorioContas implements Repositorio{

	String arquivo;

	public RepositorioContas(String arquivo) {
		super();
		this.arquivo = arquivo;
	}

	@Override
	public ArrayList<Conta> load() {
		ArrayList<Conta> contas = null;
		try
		{
			FileInputStream fis = new FileInputStream(this.arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			contas = (ArrayList<Conta>) ois.readObject();
			ois.close();
		}
		catch (Exception e) 
		{e.printStackTrace(); }
		
		return contas;
	}

@Override
public void save(ArrayList<Conta> contas) {
	
	try
	{
		FileOutputStream fos = new FileOutputStream(this.arquivo);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(contas);
		oos.flush();
		oos.close();
	}
	catch (Exception e)
	{
		System.out.println(e);
	}

}

}
