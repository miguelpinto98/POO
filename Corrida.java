import java.util.HashSet;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Collection;
import java.io.*;

public class Corrida {

	private HashSet<Veiculo> conjveiculos;
	private Circuito crt;
	private boolean piso;

	public Corrida() {
		this.conjveiculos = new HashSet<Veiculo>();
		this.crt = new Circuito();
		this.piso = false;
	}

	public Corrida(HashSet<Veiculo> v, Circuito c, boolean p) {
		this.conjveiculos = new HashSet<Veiculo>();
		for (Veiculo vc : v)
			this.conjveiculos.add(vc);
		this.crt = c;
		this.piso = p;
	}

	public Corrida(Corrida c) {
		this.conjveiculos = c.getConjuntoVeiculos();
		this.crt = c.getCircuito();
		this.piso = c.getPiso();
	}

	public HashSet<Veiculo> getConjuntoVeiculos() {
		HashSet<Veiculo> aux = new HashSet<Veiculo>();

		for (Veiculo vc : this.conjveiculos)
			aux.add(vc.clone());

		return aux;
	}

	public Circuito getCircuito() {
		return this.crt;
	}

	public boolean getPiso() {
		return this.piso;
	}

	public void setConjuntoVeiculos(HashSet<Veiculo> vc) {
		this.conjveiculos = vc;
	}

	public void setCircuito(Circuito c) {
		this.crt = c;
	}

	public void setPiso(boolean p) {
		this.piso = p;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		s.append("----------------- Corrida -------------------\n");
		s.append("Número de Veiculos: " + this.conjveiculos.size() + "\n");
		s.append("Circuito: " + this.crt.getNomeCircuito() +" " + this.crt.getNvoltas() + "\n");
		s.append("Piso Molhado: " + this.piso + "\n");
		s.append("---------------------------------------------\n");

		return s.toString();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null || (o.getClass() != this.getClass()))
			return false;
		Corrida v = (Corrida) o;
		return this.conjveiculos.equals(v.getConjuntoVeiculos())
				&& this.crt.equals(v.getCircuito())
				&& this.piso == (v.getPiso());
	}

	public Corrida clone() {
		return new Corrida(this);
	}

	public HashMap<Veiculo, Integer> fazVolta(boolean troca) {
		int x = 0, min = 900000; Veiculo vw  = null;
		HashMap<Veiculo, Integer> aux = new HashMap<Veiculo, Integer>();
		HashSet<Veiculo> percorrer = this.getConjuntoVeiculos();
		for (Veiculo v :percorrer) {

			try {
				x = v.tempoProximaVolta(this.crt, this.piso);
				
				aux.put(v, x);
				if (x < min){ min = x;  vw = v.clone();}

			} catch (Exception e) {

				conjveiculos.remove(v);
				aux.put(v, -1);
			}

			
		}
		System.out.println("Vencedor " + vw.getMarca()+" " + vw.getModelo()+ " Tempo: " + min/1000);
		return aux;
	}

	public void fazVoltas(HashMap<Veiculo, Integer> c, int nvoltas) {
		HashMap<Veiculo, Integer> aux = new HashMap<Veiculo, Integer>();
		
		boolean troca = false;
		for (Veiculo v : aux.keySet()) {
			v.voltaracio(nvoltas);
		}
		for (int i = 1; i <= nvoltas; i++) {
			
			System.out.println("Volta "+ i);
			aux = fazVolta(troca);
			

			for (Veiculo v : aux.keySet()) {

				if (aux.get(v) != -1)
					c.put(v, c.get(v) + aux.get(v));
				else{
					
					c.put(v, -1);
				    System.out.println( v.getMarca() +" "+ v.getModelo() +" DNF " );
					
					
			   
					
				}
			}

		}

	}

	

	public HashMap<Veiculo, Integer> fazCorrida(HashMap<Veiculo, Integer> c) {
		HashMap<Veiculo, Integer> aux = new HashMap<Veiculo, Integer>();
		TreeMap<Integer, Veiculo> aux2 = new TreeMap<Integer, Veiculo>();
		int x = 0;
		Veiculo v1 = null;

		for (Veiculo v : conjveiculos) {
			aux.put(v, 0);
		}
System.out.println(this.crt.getNomeCircuito());
		this.fazVoltas(aux, crt.getNvoltas());
		
		for (Veiculo v : conjveiculos) {
			aux2.put(aux.get(v), v);
		}

		Collection<Veiculo> ca = aux2.values();
		Iterator<Veiculo> aux2it = ca.iterator();

		while (aux2it.hasNext()) {
			v1 = (Veiculo) aux2it.next();

			c.put(v1, c.get(v1) + (30 - x * 2));
			x++;
		}
		return aux;
	}
	
	public static Circuito geraCircuito() {
		Piloto p = new Piloto(Piloto.geraPiloto());
		Circuito c = new Circuito();
		Random r = new Random();
		int n = r.nextInt(21);
        
		switch (n) {
            case 0:	c = new Circuito("Autódromo Internacional do Algarve", 4664, 16, 100908, 103345, 108568, 112230, 91464, 13310, 16000, p); break;
            case 1: c = new Circuito("Autódromo do Estoril", 4182, 13, 83195, 84997, 87236, 89343, 76085, 6329, 22000, p); break;
            case 2:	c = new Circuito("Marrakech Street Circuit", 4624, 15, 88089, 91254, 95010, 98213, 80089, 9303, 19000, p); break;
            case 3:	c = new Circuito("Kyalami Grand Prix Circuit", 4261, 13, 86640, 89542, 92423, 95856, 79410, 8827, 25000, p); break;
            case 4:	c = new Circuito("Dubai Autodrome", 5390, 16, 109638, 112038, 115267, 119265, 104786, 6129, 20000, p); break;
            case 5: c = new Circuito("Guia Circuit", 6120, 19, 136241, 138372, 139623, 141237, 129232, 11673, 22000, p); break;
            case 6: c = new Circuito("Okayama International Circuit", 3703, 13, 82003, 85871, 87128, 90125, 74889, 8912, 22000, p); break;
            case 7: c = new Circuito("Marina Bay Street Circuit", 5073, 23, 128087, 130152, 133710, 116762,134762, 12342, 23000, p); break;
            case 8: c = new Circuito("Sydney Motorsports Park", 3930, 12, 76433, 78917, 81023, 83123, 69915, 9173, 20000, p); break;
            case 9: c = new Circuito("Queensland Raceway", 3120, 6, 59477, 61375, 63112, 64876, 53483, 5213, 18000, p); break;
            case 10: c = new Circuito("Red Bull Ring", 4326, 10, 84967, 86239, 87341, 89346, 76113, 8197, 26000, p); break;
            case 11: c = new Circuito("Hockenheimring", 4574, 13, 90812, 92763, 95391, 96713, 78725, 12492, 18000, p); break;
            case 12: c = new Circuito("Nurburgring", 5148, 16, 110123, 112472, 113853, 115834, 99439, 10634, 24000, p); break;
            case 13: c = new Circuito("Circuit de Catalunya", 4655, 16, 97304, 99141, 101642, 104794, 87233, 9163, 28000, p); break;
            case 14: c = new Circuito("Circuito de Jerez", 4428, 13, 99111, 101134, 102471, 105182, 83135, 12842, 19000, p); break;
            case 15: c = new Circuito("Valencia Street Circuit", 5419, 25, 120192, 123987, 124364, 127347, 102163, 13521, 22000, p); break;
            case 16: c = new Circuito("Circuit de Nevers Magny-Cours", 4411, 17, 92912, 93751, 97512, 98361, 83129, 7102, 22000, p); break;
            case 17: c = new Circuito("Circuit du Val de Vienne", 3768, 13, 93689, 95823, 96916, 98361, 85671, 5213, 19500, p); break;
            case 18: c = new Circuito("Pau Circuit", 2769, 15, 74578, 76128, 77152, 79563, 62621, 7926, 18000, p); break;
            case 19: c = new Circuito("Rockingham Motor Speedway", 3120, 12, 74419, 78231, 81987, 88521, 62972, 6512, 27000, p); break;
            case 20: c = new Circuito("Silverstone Circuit", 5901, 18, 106279, 110803, 114503, 119382, 100279, 15192, 23000, p); break;
		}
		return c;
	}
	
	public static Corrida geraCorrida(HashSet<Veiculo> aux) {
		Corrida crr = null;
		Random r = new Random();
		boolean b = r.nextBoolean();
		
		if(b)
			crr = new Corrida(aux, geraCircuito(), true);
		else
			crr = new Corrida(aux, geraCircuito(), false);
		
		return crr;
	}

}
