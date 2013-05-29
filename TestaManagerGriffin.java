import java.util.*;

public class TestaManagerGriffin {
	public static void main(String[] args) {

		Piloto p1 = new Piloto("Muito Fraco", "China", 0, 2, false);
		Piloto p2 = new Piloto("Fraco", "Portugal", 5, 4, false);
		Piloto p3 = new Piloto("Razoavel", "Espanha", 10, 6, false);
		Piloto p4 = new Piloto("Bom", "Reino Unido", 15, 8, false);
		Piloto p5 = new Piloto("Mt bom", "Fran��a", 20, 10, false);

		PC1 p11 = new PC1Normal("Koenigsegg", "Agera R", 6000, 600, p1, p1, 0); // 960cv
		PC1 p12 = new PC1Normal("SSC", "Tuatara", 6000, 800, p2, p2, 0); // 1350cv
		PC1 p13 = new PC1Normal("SSC", "Ultimate Aero TT", 6000, 1000, p3, p3, 0); // 1280cv
		PC1 p14 = new PC1Normal("Bugatti", "Veyron", 6000, 1200, p4, p4, 0); // 1200cv
		PC1 p15 = new PC1Normal("Venom", "GT", 6000, 1350, p5, p5, 0); // 1261cv

		PC2 p21 = new PC2Normal("Ferrari Enzo", "", 4000, 450, p1, p1, 0);
		PC2 p22 = new PC2Normal("As Ascari A10", "", 4500, 650, p2, p2, 0);
		PC2 p23 = new PC2Normal("Aston Martin ", "", 5000, 700, p3, p3, 0);
		PC2 p24 = new PC2Normal("Edonis", "", 5500, 850, p4, p4, 0);
		PC2 p25 = new PC2Normal("Mercedes-Benz", "", 6000, 1000, p5, p5, 0);

		GT g1 = new GTNormal("Peugeot 908 Equipe Peugeot", "", 3000, 200, p1, p1, 0);
		GT g2 = new GTNormal("Ferrari F10", "", 3400, 350, p2, p2, 0);
		GT g3 = new GTNormal("Mazda 787B Race Car", "", 3800, 500, p3, p3, 0);
		GT g4 = new GTNormal("Red Bull X2010 S.Vettel", "", 4100, 600, p4, p4, 0);
		GT g5 = new GTNormal("Hennessey Venom GT", "", 4500, 750, p5, p5, 0);

		SC s1 = new SC("Ferrari FXX", "", 2500, 100, p5, p1, 0);
		SC s2 = new SC("Saleen S7", "", 2500, 200, p4, p2, 0);
		SC s3 = new SC("Koenigsegg Agera", "", 2500, 300, p3, p3, 0);
		SC s4 = new SC("SSC Ultimate Aero", "", 2500, 400, p2, p4, 0);
		SC s5 = new SC("Koenigsegg Agera R", "", 2500, 500, p1, p5, 0);

		Circuito ct1 = new Circuito("ALGARVE", 4664, 16, 100908, 103345,
				108568, 112230, 91464, 20000, 16000, p3);
		Circuito ct2 = new Circuito("ALGARVE", 4664, 16, 100908, 103345,
				108568, 112230, 91464, 20000, 16000, p3);

		HashSet<Veiculo> v = new HashSet<Veiculo>();
		v.add(p11);
		v.add(p12);
		v.add(p13);
		v.add(p14);
		v.add(p15);

		Corrida c2 = new Corrida(v, ct1, false);
		Corrida c3 = new Corrida(v, ct2, true);
		Corrida c4 = new Corrida(v, ct2, true);
		HashSet<Corrida> v96 = new HashSet<Corrida>();
		v96.add(c2);
		v96.add(c3);
		v96.add(c4);
		Campeonato k1 = new Campeonato(v96);

		
		HashMap<Veiculo, Integer> arroz = new HashMap<Veiculo, Integer>();
		HashMap<Veiculo, Integer> batata = new HashMap<Veiculo, Integer>();
		for (Corrida r : k1.getCorridas()) {	
		for (Veiculo va : r.getConjuntoVeiculos()) {
			batata.put(va, 0);
	}
		
		
	}
		
		for (Corrida r : k1.getCorridas()) {
			
			
			arroz=r.fazCorrida(batata);
		}
		
			for(Veiculo x : arroz.keySet()) {
				//System.out.println(arroz.get(x)/1000);
			}
			
			for (Veiculo ve : batata.keySet()) {
				System.out.println(batata.get(ve) + " Veiculo: " + ve.getMarca());
			}
	}
}
