import java.util.*;

public class TestaManager {
	public static void main(String[] args) throws Exception {

		Piloto p1 = new Piloto("Muito Fraco", "China", 0, 10, false);
		Piloto p2 = new Piloto("Fraco", "Portugal", 5, 10, false);
		Piloto p3 = new Piloto("Razoavel", "Espanha", 10, 10, false);
		Piloto p4 = new Piloto("Bom", "Reino Unido", 15, 10, false);
		Piloto p5 = new Piloto("Mt bom", "França", 20, 10, false);

		PC1 p11 = new PC1Normal("Koenigsegg", "Agera R", 6000, 600, p1, p1); // 960cv
		PC1 p12 = new PC1Normal("SSC", "Tuatara", 6000, 800, p2, p2); // 1350cv
		PC1 p13 = new PC1Normal("SSC", "Ultimate Aero TT", 6000, 1000, p3, p3); // 1280cv
		PC1 p14 = new PC1Normal("Bugatti", "Veyron", 6000, 1200, p4, p4); // 1200cv
		PC1 p15 = new PC1Normal("Venom", "GT", 6000, 1350, p5, p5); // 1261cv
		
		PC1 p16 = new PC1Hibrido("Koenigsegg", "Agera R", 6000, 600, p1, p1, 40); // 960cv
		PC1 p17 = new PC1Hibrido("SSC", "Tuatara", 6000, 800, p2, p2, 75); // 1350cv
		PC1 p18 = new PC1Hibrido("SSC", "Ultimate Aero TT", 6000, 1000, p3, p3, 100); // 1280cv
		PC1 p19 = new PC1Hibrido("Bugatti", "Veyron", 6000, 1200, p4, p4, 150); // 1200cv
		PC1 p110 = new PC1Hibrido("Venom", "GT", 6000, 1350, p5, p5, 200); // 1261cv

		PC2 p21 = new PC2Normal("Ferrari Enzo", "", 4000, 450, p1, p1);
		PC2 p22 = new PC2Normal("As Ascari A10", "", 4500, 650, p2, p1);
		PC2 p23 = new PC2Normal("Aston Martin ", "", 5000, 700, p3, p3);
		PC2 p24 = new PC2Normal("Edonis", "", 5500, 850, p4, p4);
		PC2 p25 = new PC2Normal("Mercedes-Benz", "", 6000, 1000, p5, p5);
		
		PC2 p26 = new PC2Hibrido("Ferrari Enzo", "", 4000, 450, p1, p1, 40);
		PC2 p27 = new PC2Hibrido("As Ascari A10", "", 4500, 650, p2, p2, 75);
		PC2 p28 = new PC2Hibrido("Aston Martin ", "", 5000, 700, p3, p3, 100);
		PC2 p29 = new PC2Hibrido("Edonis", "", 5500, 850, p4, p4, 150);
		PC2 p210 = new PC2Hibrido("Mercedes-Benz", "", 6000, 1000, p5, p5, 200);

		GT g1 = new GTNormal("Peugeot 908 Equipe Peugeot", "", 3000, 200, p1, p1);
		GT g2 = new GTNormal("Ferrari F10", "", 3400, 350, p2, p2);
		GT g3 = new GTNormal("Mazda 787B Race Car", "", 3800, 500, p3, p3);
		GT g4 = new GTNormal("Red Bull X2010 S.Vettel", "", 4100, 600, p4, p4);
		GT g5 = new GTNormal("Hennessey Venom GT", "", 4500, 750, p5, p5);
		
		GT g6 = new GTHibrido("Peugeot 908 Equipe Peugeot", "", 3000, 200, p1, p1, 40);
		GT g7 = new GTHibrido("Ferrari F10", "", 3400, 350, p2, p2, 95);
		GT g8 = new GTHibrido("Mazda 787B Race Car", "", 3800, 500, p3, p3, 130);
		GT g9 = new GTHibrido("Red Bull X2010 S.Vettel", "", 4100, 600, p4, p4, 180);
		GT g10 = new GTHibrido("Hennessey Venom GT", "", 4500, 750, p5, p5,210);

		SC s1 = new SC("Ferrari FXX", "", 2500, 100, p5, p1);
		SC s2 = new SC("Saleen S7", "", 2500, 200, p4, p2);
		SC s3 = new SC("Koenigsegg Agera", "", 2500, 300, p3, p3);
		SC s4 = new SC("SSC Ultimate Aero", "", 2500, 400, p2, p4);
		SC s5 = new SC("Koenigsegg Agera R", "", 2500, 500, p1, p5);

		Circuito ct1 = new Circuito("ALGARVE", 4664, 16, 100908, 103345,
				108568, 112230, 91464, 20000, 16000, p3);
		Circuito ct2 = new Circuito("ALGARVE", 4664, 16, 100908, 103345,
				108568, 112230, 91464, 20000, 16000, p3);

		HashSet<Veiculo> v = new HashSet<Veiculo>();
		v.add(p11);

		Corrida c2 = new Corrida(v, ct1, false);
		Corrida c3 = new Corrida(v, ct2, true);
		Corrida c4 = new Corrida(v, ct2, true);
		HashSet<Corrida> v96 = new HashSet<Corrida>();
		v96.add(c2);
		v96.add(c3);
		v96.add(c3);
		//Campeonato k1 = new Campeonato(v96);
		
		Campeonato c = Campeonato.geraCampeonato();
		//System.out.println(c.toString());
		
		Veiculo vx = Veiculo.geraVeiculo();
		//System.out.println(vx.toString());
		
		double tx1 = 0, tx2 = 0, tx3 = 0, tx4 = 0, tx5 = 0;
		
		  for(int i = 0 ; i < 5; i++){ double x1 =
		  g1.tempoProximaVolta(ct1,false); double x2 =
		  g2.tempoProximaVolta(ct1,false); double x3 =
		  g3.tempoProximaVolta(ct1,false); double x4 =
		  g4.tempoProximaVolta(ct1,false); double x5 =
		  g5.tempoProximaVolta(ct1,false);
		  
		  tx1+=x1; tx2+=x2; tx3+=x3; tx4+=x4; tx5+=x5;
		  
		  System.out.println("P1 " + x1/1000 + "\tP2 " + x2/1000 + "\tP3 " +
		  x3/1000 + "\tP4 " + x4/1000 + "\tP5 " + x5/1000); }
		  System.out.println("\nP1 " + tx1/1000 + "\tP2 " + tx2/1000 + "\tP3 "
		  + tx3/1000 + "\tP4 " + tx4/1000 + "\tP5 " + tx5/1000 + "\n");
		  
		  System.out.println("\nNORMAL");
		 tx1=0; tx2=0; tx3=0; tx4=0; tx5=0; for(int i = 0 ; i < 5; i++){
		 double x1 = g6.tempoProximaVolta(ct1,false); double x2 =
		 g7.tempoProximaVolta(ct1,false); double x3 =
		 g8.tempoProximaVolta(ct1,false); double x4 =
		 g9.tempoProximaVolta(ct1,false); double x5 =
		 g10.tempoProximaVolta(ct1,false);
		 
		 tx1+=x1; tx2+=x2; tx3+=x3; tx4+=x4; tx5+=x5;
		 
		 System.out.println("P1 " + x1/1000 + "\tP2 " + x2/1000 + "\tP3 " +
		 x3/1000 + "\tP4 " + x4/1000 + "\tP5 " + x5/1000); }
		 System.out.println("\nP1 " + tx1/1000 + "\tP2 " + tx2/1000 + "\tP3 "
		 + tx3/1000 + "\tP4 " + tx4/1000 + "\tP5 " + tx5/1000 + "\n");
		 
		/*tx1 = 0;
		tx2 = 0;
		tx3 = 0;
		tx4 = 0;
		tx5 = 0;
		for (int i = 0; i < 5; i++) {
			double x1 = g1.tempoProximaVolta(ct1, false);
			double x2 = g2.tempoProximaVolta(ct1, false);
			double x3 = g3.tempoProximaVolta(ct1, false);
			double x4 = g4.tempoProximaVolta(ct1, false);
			double x5 = g5.tempoProximaVolta(ct1, false);

			tx1 += x1;
			tx2 += x2;
			tx3 += x3;
			tx4 += x4;
			tx5 += x5;

			System.out.println("P1 " + x1 / 1000 + "\tP2 " + x2 / 1000
					+ "\tP3 " + x3 / 1000 + "\tP4 " + x4 / 1000 + "\tP5 " + x5
					/ 1000);
		}
		System.out.println("\nP1 " + tx1 / 1000 + "\tP2 " + tx2 / 1000
				+ "\tP3 " + tx3 / 1000 + "\tP4 " + tx4 / 1000 + "\tP5 " + tx5
				/ 1000 + "\n");

		/*
		 * tx1=0; tx2=0; tx3=0; tx4=0; tx5=0; for(int i = 0 ; i < 5; i++){
		 * double x1 = s1.tempoProximaVolta(ct1,false); double x2 =
		 * s2.tempoProximaVolta(ct1,false); double x3 =
		 * s3.tempoProximaVolta(ct1,false); double x4 =
		 * s4.tempoProximaVolta(ct1,false); double x5 =
		 * s5.tempoProximaVolta(ct1,false);
		 * 
		 * tx1+=x1; tx2+=x2; tx3+=x3; tx4+=x4; tx5+=x5;
		 * 
		 * System.out.println("P1 " + x1/1000 + "\tP2 " + x2/1000 + "\tP3 " +
		 * x3/1000 + "\tP4 " + x4/1000 + "\tP5 " + x5/1000); }
		 * System.out.println("\nP1 " + tx1/1000 + "\tP2 " + tx2/1000 + "\tP3 "
		 * + tx3/1000 + "\tP4 " + tx4/1000 + "\tP5 " + tx5/1000 + "\n");
		 */
/*
		HashMap<Veiculo, Integer> arroz = new HashMap<Veiculo, Integer>();
		HashMap<Veiculo, Integer> batata = new HashMap<Veiculo, Integer>();

		
		for (Corrida r : k1.getCorridas()) {
			
			for (Veiculo va : r.getConjuntoVeiculos()) {
					batata.put(va, 0);
			}
			arroz=r.fazCorrida(batata);
		}
		
			for(Veiculo x : arroz.keySet()) {
				//System.out.println(arroz.get(x)/1000);
			}
			
			for (Veiculo ve : batata.keySet()) {
				System.out.println(batata.get(ve) + " ");
			}*/
	}
}
