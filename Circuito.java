

public class Circuito {
    String nome;
	private int distancia,nvoltas;
	private int tpc1,
	tpc2,
	tgt,
	tsc,
	trecord,
	tdesviom,
	tboxes;
	private Piloto recordista;

	//construtores
	public Circuito(int distancia, int nvoltas, int tpc1, int tpc2, int tgt, int tsc, int trecord, int tdesviom, int tboxes, Piloto recordista) {
		this.distancia = distancia;
		this.nvoltas = nvoltas;
		this.tpc1 = tpc1;
		this.tpc2 = tpc2;
		this.tgt = tgt;
		this.tsc = tsc;
		this.trecord = trecord;
		this.tdesviom = tdesviom;
		this.tboxes = tboxes;
		this.recordista = recordista;
	}

	public Circuito() {
		this.distancia = 0;
		this.nvoltas = 0;
		this.tpc1 = 0;
		this.tpc2 = 0;
		this.tgt = 0;
		this.tsc = 0;
		this.trecord = 0;
		this.tdesviom = 0;
		this.tboxes = 0;
		this.recordista = new Piloto();

	}

	public Circuito(Circuito c) {
		this.distancia = c.getDistancia();
		this.nvoltas = c.getNvoltas();
		this.tpc1 = c.getTpc1();
		this.tpc2 = c.getTpc2();
		this.tgt = c.getTgt();
		this.tsc = c.getTsc();
		this.trecord = c.getTrecord();
		this.tdesviom = c.getTdesviom();
		this.tboxes = c.getTboxes();
		this.recordista = c.getRecordista().clone();

	}

	//get
	public int getDistancia() {
		return distancia;
	}

	public int getNvoltas() {
		return nvoltas;
	}

	public int getTpc1() {
		return tpc1;
	}

	public int getTpc2() {
		return tpc2;
	}

	public int getTgt() {
		return tgt;
	}

	public int getTsc() {
		return tsc;
	}

	public int getTrecord() {
		return trecord;
	}

	public int getTdesviom() {
		return tdesviom;
	}

	public int getTboxes() {
		return tboxes;
	}

	public Piloto getRecordista() {
		return recordista;
	}

	//set
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public void setNvoltas(int nvoltas) {
		this.nvoltas = nvoltas;
	}

	public void setTpc1(int tpc1) {
		this.tpc1 = tpc1;
	}

	public void setTpc2(int tpc2) {
		this.tpc2 = tpc2;
	}

	public void setTgt(int tgt) {
		this.tgt = tgt;
	}

	public void setTsc(int tsc) {
		this.tsc = tsc;
	}

	public void setTrecord(int trecord) {
		this.trecord = trecord;
	}

	public void setTdesviom(int tdesviom) {
		this.tdesviom = tdesviom;
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
		s.append("distancia=" + distancia);
		s.append(", numero de voltas=" + nvoltas);
		s.append(", tempo dos pc1=" + tpc1);
		s.append(", tempo dos pc2=" + tpc2);
		s.append(", tempo dos gt=" + tgt);
		s.append(", tempo dos sc=" + tsc);
		s.append(", tempo record=" + trecord);
		s.append(", tempo nas boxes=" + tboxes);
		s.append(", desvio medio =" + tdesviom);
		s.append(", recordista=" + recordista.toString());

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