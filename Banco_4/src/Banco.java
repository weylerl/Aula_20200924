import java.util.ArrayList;

public class Banco {
	
	private String nome;
	private ArrayList<Conta> contas;
	private Repositorio rc;
	
	public Banco(String nome) {
		super();
		rc = new RepositorioContas("contas.txt");
//		rc = new RepositorioGson("contas.json");
		this.nome = nome;
//		this.contas = new ArrayList<Conta>();
		this.contas = rc.load();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void insereConta(Conta cta) {
		contas.add(cta);		
	}
	
	public void depositaConta(int num, double valor) {
		Conta cta = buscaConta(num);
		if (cta == null)
			System.out.println("Conta inexistente!!");
		else
			cta.deposita(valor);
	}
	
	public void debitaConta(int num, double valor) {
		Conta cta = buscaConta(num);
		if (cta == null)
			System.out.println("Conta inexistente!!");
		else
			cta.debita(valor);
	}

	public void transferirDinheiro(int numOrigem, int numDestino, Double valor){
		Conta ctaOrigem = buscaConta(numOrigem);
		Conta ctaDestino = buscaConta(numDestino);

		if(ctaOrigem.saldo < valor)
			System.out.println("Saldo insuficiente!!");
		else {
			ctaOrigem.debita(valor);
			ctaDestino.deposita(valor);
			System.out.println("Transferencia de " + valor + "\nOrigem: "+  
			ctaOrigem.getCliente() + " \nDestino: " + ctaDestino.getCliente() + "\n");
		}
	}
	
	public ArrayList<Conta> buscaContas() {
		return contas;
	}

	public Conta buscaConta(int num) {
		Conta c = contas
				.stream()
				.filter(conta -> conta.getNumero() == num)
				.findAny()
				.orElse(null);
		return c;
	}
	
	public void finalize() {
		rc.save(contas);
	}
}
