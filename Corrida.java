import java.io.Serializable;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Collection;

public class Corrida implements Comparable<Corrida>, Serializable {

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
		
		s.append("----------------------- Corrida -------------------------\n");
		s.append("Circuito: " + this.crt.getNomeCircuito() + "\n");
		s.append("Numero de voltas: " + this.crt.getNvoltas() + "\n");
		s.append("Numero de veiculos: " + this.conjveiculos.size() + "\n");
		s.append("Tempo Recorde: " + getTempoMS(this.crt.getTrecord())+"\n");
		s.append("Piso Molhado: " + this.piso + "\n");
		s.append("---------------------------------------------------------\n");

		return s.toString();
	}

	public Corrida clone() {
		return new Corrida(this);
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

	public HashMap<Veiculo, Integer> fazVolta() {
		int x = 0, min = Integer.MAX_VALUE;
		Veiculo vw  = null;
		HashMap<Veiculo, Integer> aux = new HashMap<>();
		HashSet<Veiculo> percorrer = this.getConjuntoVeiculos();
		
		for (Veiculo v : percorrer) {
			try { 
				conjveiculos.remove(v);
				x = v.tempoProximaVolta(this.crt, this.piso);
				conjveiculos.add(v);
				aux.put(v, x);
				if(x<min) {
					min = x;
					vw = v.clone();
				}
			} catch (Exception e) {

				conjveiculos.remove(v);
				aux.put(v, -1);
			}
		}
		System.out.println("Vencedor " + vw.getMarca()+" " + vw.getModelo()+ " Tempo: " + getTempoMS(min));
		if(min<this.getCircuito().getTrecord()){ 
			
			if(vw.getPactivo()== true){  
			
			Circuito c = this.getCircuito();
			c.setTrecord(min); c.setRecordista(vw.getPiloto1());
			this.setCircuito(c);
			
		}else {Circuito c = this.getCircuito();
		c.setTrecord(min); c.setRecordista(vw.getPiloto2());
		this.setCircuito(c);}       
			
		
		}
		return aux;
	}

	public void fazVoltas(HashMap<Veiculo, Integer> c, int nvoltas) {
		HashMap<Veiculo, Integer> aux = new HashMap<>();
		
		for (Veiculo v : conjveiculos) {
			v.voltaracio(nvoltas);
		}
		
		for (int i = 1; i <= nvoltas; i++) {
			System.out.println("\nVolta "+ i);
			aux = this.fazVolta();
			for (Veiculo v : aux.keySet()) {
				if (aux.get(v) != -1)
					c.put(v, c.get(v) + aux.get(v));
				else {
					c.put(v, -1);
				    System.out.println( v.getMarca() +" "+ v.getModelo() +" DNF " );					
				}
			}
			try{
				Thread.sleep(1000);			
			} catch(Exception e) {}
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
<<<<<<< HEAD
<<<<<<< HEAD

			System.out.println(this.crt.getNomeCircuito());
			System.out.println("Chuva: "+ this.getPiso());

=======
			System.out.println(this.crt.getNomeCircuito()+"\nPiso Molhado: "+this.piso);
>>>>>>> eb8488516340092c18259e5f56712b4da53129b2
=======
			System.out.println(this.crt.getNomeCircuito()+"\nPiso Molhado: "+this.piso);
>>>>>>> eb8488516340092c18259e5f56712b4da53129b2
		this.fazVoltas(aux, crt.getNvoltas());
		
		for (Veiculo v : conjveiculos) {
			if(aux2.containsKey(aux.get(v))==false)
				aux2.put(aux.get(v), v);
			else
				aux2.put(aux.get(v)+1, v);
		}

		Collection<Veiculo> ca = aux2.values();
		Iterator<Veiculo> aux2it = ca.iterator();
		System.out.println("#########################################################");
		System.out.println("################# CLASSIFICACAO CORRIDA #################");
		System.out.println("#                                                       #");
		
		while (aux2it.hasNext()) {
			v1 = (Veiculo) aux2it.next();
			System.out.println("#  "+(x+1)+"º Classificado "+v1.getMarca()+" "+v1.getModelo()+"\t"+getTempoMS(aux.get(v1)));
			
            if(c.get(v1) < 0 && v1.veHib() == false )
                c.put(v1, (30 - x * 2));
			else
				if (c.get(v1) >= 0 && v1.veHib() == false )
					c.put(v1, c.get(v1) + (30 - x * 2));
			x++;
		}
		aux2it = ca.iterator();
		x = 0;
		while (aux2it.hasNext()) {
			v1 = (Veiculo) aux2it.next();

            if(c.get(v1) < 0&& v1.veHib() == true) {
            	c.put(v1,   (30 - x * 2)); 
            	x++;
            } else 
            	if(c.get(v1) >= 0 &&v1.veHib() == true) {
            		c.put(v1, c.get(v1) + (30 - x * 2));
            		x++;
            	}
		}
		
		System.out.println("#                                                       #");
		System.out.println("#########################################################");
		
		return aux;
	}
	
	private String getTempoMS(int tempo) {
		return (((tempo/1000)/60)+":"+((tempo/1000)%60)+"."+(tempo%1000));
	}

	public static Circuito geraCircuito() {
		Piloto p = new Piloto(Piloto.geraPiloto());
		Circuito c = new Circuito();
		Random r = new Random();
		int n = r.nextInt(30);
        
		switch (n) {
            case 0:	c = new Circuito("Autodromo Internacional do Algarve", 4664, 16, 100908, 103345, 108568, 112230, 91464, 13310, 16000, p); break;
            case 1: c = new Circuito("Autodromo do Estoril", 4182, 13, 83195, 84997, 87236, 89343, 76085, 6329, 22000, p); break;
            case 2:	c = new Circuito("Marrakech Street Circuit", 4624, 15, 88089, 91254, 95010, 98213, 80089, 9303, 19000, p); break;
            case 3:	c = new Circuito("Kyalami Grand Prix Circuit", 4261, 13, 86640, 89542, 92423, 95856, 79410, 8827, 25000, p); break;
            case 4:	c = new Circuito("Dubai Autodrome", 5390, 16, 109638, 112038, 115267, 119265, 104786, 6129, 20000, p); break;
            case 5: c = new Circuito("Guia Circuit", 6120, 19, 136241, 138372, 139623, 141237, 129232, 11673, 22000, p); break;
            case 6: c = new Circuito("Okayama International Circuit", 3703, 13, 82003, 85871, 87128, 90125, 74889, 8912, 22000, p); break;
            case 7: c = new Circuito("Marina Bay Street Circuit", 5073, 23, 128087, 134152, 136710, 140762, 120762, 13342, 23000, p); break;
            case 8: c = new Circuito("Sydney Motorsports Park", 3930, 12, 76433, 78917, 81023, 83123, 69915, 9173, 20000, p); break;
            case 9: c = new Circuito("Queensland Raceway", 3120, 10, 59477, 61375, 63112, 64876, 53483, 5213, 18000, p); break;
            case 10: c = new Circuito("Red Bull Ring", 4326, 11, 84967, 86239, 87341, 89346, 76113, 8197, 26000, p); break;
            case 11: c = new Circuito("Hockenheimring", 4574, 13, 90812, 92763, 95391, 96713, 78725, 12492, 18000, p); break;
            case 12: c = new Circuito("Nurburgring", 5148, 16, 110123, 112472, 113853, 115834, 99439, 10634, 24000, p); break;
            case 13: c = new Circuito("Circuit de Catalunya", 4655, 16, 97304, 99141, 101642, 104794, 87233, 9163, 28000, p); break;
            case 14: c = new Circuito("Circuito de Jerez", 4428, 13, 99111, 101134, 102471, 105182, 83135, 12842, 19000, p); break;
            case 15: c = new Circuito("Valencia Street Circuit", 5419, 25, 120192, 123987, 124364, 127347, 102163, 13521, 22000, p); break;
            case 16: c = new Circuito("Circuit de Nevers Magny-Cours", 4411, 17, 92912, 93751, 97512, 98361, 83129, 7102, 22000, p); break;
            case 17: c = new Circuito("Circuit du Val de Vienne", 3768, 13, 93689, 95823, 96916, 98361, 85671, 5213, 19500, p); break;
            case 18: c = new Circuito("Pau Circuit", 2769, 15, 74578, 76128, 77152, 79563, 62621, 7926, 18000, p); break;
            case 19: c = new Circuito("Rockingham Motor Speedway", 3120, 13, 74419, 78231, 81987, 88521, 62972, 6512, 27000, p); break;
            case 20: c = new Circuito("Silverstone Circuit", 5901, 18, 106279, 110803, 114503, 119382, 100279, 15192, 23000, p); break;
            case 21: c = new Circuito("Euro-Ring", 2750, 21, 70323, 76911, 77123, 79701, 64835, 4822, 14000, p); break;
            case 22: c = new Circuito("Circuit de Monaco",3340, 18, 90641, 91989, 93871, 96823, 86219, 7420, 25000, p); break;
            case 23: c = new Circuito("Autodrom Moscow",3275, 16, 80225, 86277, 90187, 95123, 73659, 5556, 15000, p); break;
            case 24: c = new Circuito("Istanbul Park", 5338, 14, 106243, 111623, 115238, 116261, 101639, 15609, 26000, p); break;
            case 25: c = new Circuito("Moscow Raceway", 4080, 15, 78841, 86696, 91272, 94881, 74672, 12508, 18000, p); break;
            case 26: c = new Circuito("Autodromo Hermanos Rodriguez", 4438, 17, 85552, 93752, 95719, 99263, 77216, 11999, 22000, p); break;
            case 27: c = new Circuito("Toronto Street Circuit", 2824, 12, 54948, 55250, 61112, 65288, 51923, 8182, 15000, p); break;
            case 28: c = new Circuito("Long Beach Street Circuit", 3167, 14, 69517, 70208, 73001, 76934, 63851, 8762, 25000, p); break;
            case 29: c = new Circuito("Circuit of the Americas", 5513, 22, 99463, 109053, 113512, 118641, 92641, 9906, 19000, p); break;
		}
		return c;
	}
	
	public int compareTo(Corrida c1) {
		if(c1.crt.gettempoPC1() < this.crt.gettempoPC1())
			return 1;
		if(c1.crt.gettempoPC1() > this.crt.gettempoPC1())
			return -1;
		else
			return 0;
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
