import java.io.Serializable;

public class Conta implements Serializable{
	
	private int numero;
	private Cliente cliente;
	protected Double saldo;
	
	public Conta(int numero, Cliente cliente, Double saldo) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = saldo;
	}

	public Conta(int numero, Cliente cliente) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0.00;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public int getNumero() {
		return numero;
	}
	
	public Double getSaldo() {
		return saldo;
	}

	public void deposita(double valor) {
		this.saldo = this.saldo + valor;
	}
		
	public void debita(double valor) {
		if (valor > this.saldo) 
			System.out.println("Saldo insuficiente!!");
		else
			this.saldo = this.saldo - valor;
	}
		

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", nomeCliente=" + cliente.getNome() + ", saldo=" + saldo + "]";
	}
	
	
	
}
