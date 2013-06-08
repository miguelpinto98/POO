import java.io.Serializable;

public class Circuito implements Serializable{
    String nome;
	private int distancia,nvoltas;
	private int tempoPC1, tempoPC2, tempoGT, tempoSC, trecord, tdesviochuva, tboxes;
	private Piloto recordista;

	//construtores
	public Circuito(String nome,int distancia, int nvoltas, int tempoPC1, int tempoPC2, int tempoGT, int tempoSC, int trecord, int tdesviochuva, int tboxes, Piloto recordista) {
		this.nome = nome;
		this.distancia = distancia;
		this.nvoltas = nvoltas;
		this.tempoPC1 = tempoPC1;
		this.tempoPC2 = tempoPC2;
		this.tempoGT = tempoGT;
		this.tempoSC = tempoSC;
		this.trecord = trecord;
		this.tdesviochuva = tdesviochuva;
		this.tboxes = tboxes;
		this.recordista = recordista;
	}

	public Circuito() {
		this.nome = "";
		this.distancia = 0;
		this.nvoltas = 0;
		this.tempoPC1 = 0;
		this.tempoPC2 = 0;
		this.tempoGT = 0;
		this.tempoSC = 0;
		this.trecord = 0;
		this.tdesviochuva = 0;
		this.tboxes = 0;
		this.recordista = new Piloto();
	}

	public Circuito(Circuito c) {
		this.nome = c.getNomeCircuito();
		this.distancia = c.getDistancia();
		this.nvoltas = c.getNvoltas();
		this.tempoPC1 = c.gettempoPC1();
		this.tempoPC2 = c.gettempoPC2();
		this.tempoGT = c.gettempoGT();
		this.tempoSC = c.gettempoSC();
		this.trecord = c.getTrecord();
		this.tdesviochuva = c.getDesvioChuva();
		this.tboxes = c.getTboxes();
		this.recordista = c.getRecordista().clone();
	}

	//GETTERS
	
	public String getNomeCircuito() {
		return nome;
	}
	
	public int getDistancia() {
		return distancia;
	}

	public int getNvoltas() {
		return nvoltas;
	}

	public int gettempoPC1() {
		return tempoPC1;
	}

	public int gettempoPC2() {
		return tempoPC2;
	}

	public int gettempoGT() {
		return tempoGT;
	}

	public int gettempoSC() {
		return tempoSC;
	}

	public int getTrecord() {
		return trecord;
	}

	public int getDesvioChuva() {
		return tdesviochuva;
	}

	public int getTboxes() {
		return tboxes;
	}

	public Piloto getRecordista() {
		return recordista;
	}

	//set
	
	public void setNomeCircuito(String nome) {
		this.nome = nome;
	}
	
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public void setNvoltas(int nvoltas) {
		this.nvoltas = nvoltas;
	}

	public void settempoPC1(int tempoPC1) {
		this.tempoPC1 = tempoPC1;
	}

	public void settempoPC2(int tempoPC2) {
		this.tempoPC2 = tempoPC2;
	}

	public void settempoGT(int tempoGT) {
		this.tempoGT = tempoGT;
	}

	public void settempoSC(int tempoSC) {
		this.tempoSC = tempoSC;
	}

	public void setTrecord(int trecord) {
		this.trecord = trecord;
	}

	public void settdesviochuva(int tdesviochuva) {
		this.tdesviochuva = tdesviochuva;
	}

	public void setTboxes(int tboxes) {
		this.tboxes = tboxes;
	}

	public void setRecordista(Piloto recordista) {
		this.recordista = recordista;
	}

	//toString
	public String toString() {
		StringBuilder s = new StringBuilder("Circuito ");
		
		s.append("Distancia: " + this.distancia + "\n");
		s.append("Numero de voltas: " + this.nvoltas + "\n");
		s.append("Tempo medio PC1: " + this.tempoPC1 + "\n");
		s.append("Tempo medio PC2: " + this.tempoPC2 + "\n");
		s.append("Tempo medio GT: " + this.tempoGT + "\n");
		s.append("Tempo medio SC: " + this.tempoSC + "\n");
		s.append("Tempo Record: " + this.trecord + "\n");
		s.append("Tempo na box: " + this.tboxes + "\n");
		s.append("Tempo Desvio a chuva: " + this.tdesviochuva + "\n");
		s.append("Piloto Record: " + this.recordista.toString() + "\n");

		return s.toString();

	}

	//equals
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			Circuito v = (Circuito)o;
			return (this.getDistancia() == v.getDistancia() && this.getNvoltas() == v.getNvoltas() && this.getTrecord()==v.getTrecord());
		}
	}
	
	//Clone
	public Circuito clone() {
		return new Circuito(this);
	}
}