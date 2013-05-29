import java.util.HashSet;
import java.util.Random;

public class GeraCampeonato {

	public HashSet<Veiculo> geraVeiculos() {
		Random r = new Random();
		int x = r.nextInt(8) + 12;
		int y = 0;
		HashSet<Veiculo> aux = new HashSet<Veiculo>();
		while (y < x) {
			aux.add(geraVeiculo());

			y++;
		}
		return aux;

	}

	public String daMarca() {
		String s = "FAFAFA";
		return s;
	}

	public String daModelo() {
		String s = "FAFAFA";
		return s;
	}

	public Veiculo gerahibrido(Piloto p1, Piloto p2) {
		Veiculo v = null;
		Random r = new Random();
		int x = r.nextInt(2);
		if (x == 0) {
			v = new PC1(daMarca(), daModelo(), r.nextInt(), r.nextInt(), p1,
					p2, r.nextInt());
		}
		if (x == 1) {
			v = new PC1(daMarca(), daModelo(), r.nextInt(), r.nextInt(), p1,
					p2, r.nextInt());
		}
		if (x == 2) {
			v = new PC1(daMarca(), daModelo(), r.nextInt(), r.nextInt(), p1,
					p2, r.nextInt());
		}
		return v;
	}

	public Veiculo geraVeiculo() {
		Piloto p1 = geraPiloto();
		Piloto p2 = geraPiloto();
		Veiculo v = null;
		Random r = new Random();

		int x = r.nextInt(4);
		if (x == 0) {
			v = gerahibrido(p1, p2);
		} else if (x == 1) {
			v = new PC1(daMarca(), daModelo(), r.nextInt(), r.nextInt(), p1,
					p2, r.nextInt());
		}
		if (x == 2) {
			v = new PC2(daMarca(), daModelo(), r.nextInt(), r.nextInt(), p1,
					p2, r.nextInt());
		}
		if (x == 3) {
			v = new SC(daMarca(), daModelo(), r.nextInt(), r.nextInt(), p1, p2,
					r.nextInt());
		}
		if (x == 4) {
			v = new GT(daMarca(), daModelo(), r.nextInt(), r.nextInt(), p1, p2,
					r.nextInt());
		}

		return v;
	}

	public String daNome() {
		String s = "Jusebio";
		return s;
	}

	public String daNacionalidade() {
		String s = "Pretogal";
		return s;
	}

	public Piloto geraPiloto() {
		Random r = new Random();
		int quali = r.nextInt(9) + 1;
		int palmares = r.nextInt(50);
		boolean chuva = r.nextBoolean();

		return new Piloto(daNome(), daNacionalidade(), palmares, quali, chuva);

	}

	public Corrida geraCorrida(HashSet<Veiculo> aux) {
		Circuito ra = new Circuito();
		ra = geraCircuito();
		Corrida y = null;

		Random r = new Random();
		int x = r.nextInt(1);
		if (x == 1) {
			y = new Corrida(aux, ra, true);
		}
		if (x == 0) {
			y = new Corrida(aux, ra, false);
		}

		return y;
	}

	public Campeonato GeraCampeonato() {

		Random r = new Random();
		int x = r.nextInt(5) + 4;
		int i = 0;
		HashSet<Corrida> aux = new HashSet<Corrida>();
		HashSet<Veiculo> aux2 = new HashSet<Veiculo>();
		aux2 = geraVeiculos();
		while (i < x) {
			aux.add(geraCorrida(aux2));
			i++;

		}
		Campeonato c = new Campeonato(aux);
		return c;

	}

	public Circuito geraCircuito() {
		Piloto p = new Piloto(geraPiloto());
		Circuito c = new Circuito();
		Random r = new Random();
		int n = r.nextInt(10);

		switch (n) {
		case 0:	c = new Circuito("Autódromo Internacional do Algarve", 4664, 16, 100908, 103345, 108568, 112230, 91464, 13310, 16000, p); break;
		case 1: c = new Circuito("Autódromo do Estoril", 4182, 13, 83195, 84997, 87236, 89343, 76085, 6329, 22000, p); break;
		case 2:	c = new Circuito("Marrakech Street Circuit", 4624, 15, 88089, 91254, 95010, 98213, 80089, 9303, 19000, p); break;
		case 3:	c = new Circuito("Kyalami Grand Prix Circuit", 4261, 13, 86640, 89542, 92423, 95856, 79410, 8827, 25000, p); break;
		case 4:	c = new Circuito("Dubai Autodrome", 5390, 16, 109638, 112038, 115267, 117265, 104786, 6129, 20000, p); break;
		case 5: c = new Circuito("Guia Circuit", 6120, 19, 136241, 138372, 139623, 141237, 129232, 11673, 22000, p); break;
		case 6: c = new Circuito("Okayama International Circuit", 3703, 13, 82003, 84871, 87128, 90125, 74889, 8912, 22000, p); break;
		case 7: c = new Circuito("Marina Bay Street Circuit", 5073, 23, 128087, 130152, 133710, 116762,134762, 12342, 23000, p); break;
		case 8: c = new Circuito("Sydney Motorsports Park", 3930, 12, 76433, 78917, 81023, 83123, 69915, 9173, 20000, p); break;
		case 9: c = new Circuito("Queensland Raceway", 3120, 6, 59477, 61375, 63112, 64876, 53483, 5213, 18000, p); break;
		case 10: c = new Circuito();
		}
		return c;
	}
}
