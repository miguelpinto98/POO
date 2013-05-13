public class Veiculo {
	private String marca;
	private String modelo;
	private int cilindrada;
	private int cv;
	private Piloto p1;
	private Piloto p2;
	
	public Veiculo() {
		this.marca = "";
		this.modelo = "";
		this.cilindrada = 0;
		this.cv = 0;
		this.p1 = new Piloto();
		this.p2 = new Piloto();
	}
	
	public Veiculo(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2) {
		this.marca = marca;
		this.modelo = modelo;
		this.cilindrada = cilindrada;
		this.cv = cv;
		this.p1 = p1;
		this.p2 = p2;
	}
	
	
}