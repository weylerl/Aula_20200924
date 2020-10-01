import java.util.ArrayList;

public interface Repositorio {

	public ArrayList<Conta> load();  // carrega

	public void save(ArrayList<Conta> contas);  // salva

}