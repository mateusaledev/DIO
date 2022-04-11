
public abstract class Conta implements IConta{
	
	protected static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	private Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	
	
	@Override
	public void sacar(double valor) {
		this.saldo = saldo - valor;
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		if(this.saldo > valor) {
			this.sacar(valor);
			contaDestino.depositar(valor);	
		}else {
			System.err.println("Tentativa de tranferencia!!");
			System.err.println("SALDO INSUFICIENTE");
		}
		
		
	}
	
	
	public int getAgencia() {
		return agencia;
	}
	public int getNumero() {
		return numero;
	}
	public double getSaldo() {
		return saldo;
	}
	
	protected void imprimirInfos() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero da Conta: %d", this.numero));
		System.out.println(String.format("Saldo da Conta: %.2f", this.saldo));
	}
	
}
