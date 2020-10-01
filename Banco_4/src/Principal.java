import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws ParseException {

		Banco banco = new Banco("Popular");
		
	//	banco.transferirDinheiro(1, 4, 100.00);
		
	//	banco.insereConta(new Conta(5, new Cliente("Roberto Carlos", "89473678949", new SimpleDateFormat("dd/MM/yyyy").parse("27/06/1942"))));
		
	//	banco.depositaConta(5, 600.00);
		
		ArrayList<Conta> contas = banco.buscaContas();
		
		contas
		.stream()
		.forEach(System.out::println);
		
		banco.finalize();

	}

}
