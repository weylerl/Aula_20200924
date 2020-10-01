import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente implements Serializable{
	
	private String nome;
	private String CPF;
	private Date dataNasc;
	private Double rendaMensal;
	
	public Cliente(String nome, String cPF, Date dataNasc, Double renda) {
		super();
		this.nome = nome;
		CPF = cPF;
		this.dataNasc = dataNasc;
		this.rendaMensal = renda;
	}
	
	public Cliente(String nome, String cPF, Date dataNasc) {
		super();
		this.nome = nome;
		CPF = cPF;
		this.dataNasc = dataNasc;
		this.rendaMensal = 0.00;
	}
	
	public String getNome() {
		return nome;
	}

	public void setCliente(Double renda) {
		this.rendaMensal = renda;
	}

	public String toString() {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		return "Cliente [nome=" + nome + ", CPF=" + CPF + ", dataNasc=" + formatoData.format(dataNasc) + ", renda=" + rendaMensal + "]";
	}

}
