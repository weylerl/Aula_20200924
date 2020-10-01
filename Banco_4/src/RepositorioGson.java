import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class RepositorioGson implements Repositorio{

	String arquivo;

	public RepositorioGson(String arquivo) {
		super();
		this.arquivo = arquivo;
	}

	@Override
	public ArrayList<Conta> load() {

		ArrayList<Conta> contas = null;
		
		GsonBuilder builder = new GsonBuilder(); 
		builder.setPrettyPrinting(); 

		Gson gson = builder.create(); 

		try {
			BufferedReader br = new BufferedReader(new FileReader(this.arquivo));
			Type meuTipo = new TypeToken<ArrayList<Conta>>(){}.getType();

			contas = gson.fromJson(br, meuTipo);

//			for (Cliente cli: clientes) {
//				System.out.println((Cliente)cli);
//			}  
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contas;
	}

@Override
public void save(ArrayList<Conta> contas) {
	
    GsonBuilder builder = new GsonBuilder(); 
    builder.setPrettyPrinting(); 

    Gson gson = builder.create(); 

	String json = gson.toJson(contas);

	try {
		FileWriter writer = new FileWriter(this.arquivo);
		writer.write(json);
		writer.close();

	} catch (IOException e) {
		e.printStackTrace();
	}

//	System.out.println(json);

}

}
