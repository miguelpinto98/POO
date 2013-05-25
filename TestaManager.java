import java.util.*;

public class TestaManager {
	public static void main(String[] args) {

		Piloto p1 = new Piloto("Muito Fraco", "China", 0, 2, false);
		Piloto p2 = new Piloto("Fraco", "Portugal", 5, 4, false);
		Piloto p3 = new Piloto("Razoavel", "Espanha", 10, 6, false);
		Piloto p4 = new Piloto("Bom", "Reino Unido", 15, 8, false);
		Piloto p5 = new Piloto("Mt bom", "França", 20, 10, false);
		
		PC1 p11 = new PC1("Koenigsegg", "Agera R", 6000, 600, p1, p1, 0); 		//960cv
		PC1 p12 = new PC1("SSC", "Tuatara", 6000, 800, p2, p2, 0); 				//1350cv
		PC1 p13 = new PC1("SSC", "Ultimate Aero TT", 6000, 1000, p3, p3, 0);		//1280cv
		PC1 p14 = new PC1("Bugatti", "Veyron", 6000, 1200, p4, p4, 0);			//1200cv
		PC1 p15 = new PC1("Venom", "GT", 6000, 1350, p5, p5, 0);					//1261cv
		
		PC2 p21 = new PC2("Ferrari Enzo", "", 4000, 450, p1, p1, 0);
		PC2 p22 = new PC2("As Ascari A10", "", 4500, 650, p2, p2, 0);
		PC2 p23 = new PC2("Aston Martin ", "", 5000, 700, p3, p3, 0);
		PC2 p24 = new PC2("Edonis", "", 5500, 850, p4, p4, 0);
		PC2 p25 = new PC2("Mercedes-Benz", "", 6000, 1000, p5, p5, 0);
		
		
		GT g1 = new GT("Peugeot 908 Equipe Peugeot", "", 3000, 200, p1, p1, 0);
		GT g2 = new GT("Ferrari F10", "", 3400, 350, p2, p2, 0);
		GT g3 = new GT("Mazda 787B Race Car", "", 3800, 500, p3, p3, 0);
		GT g4 = new GT("Red Bull X2010 S.Vettel", "", 4100, 600, p4, p4, 0);
		GT g5 = new GT("Hennessey Venom GT", "", 4500, 750, p5, p5, 0);

		
		SC s1 = new SC("Ferrari FXX", "", 2500, 100, p1, p1, 0);
		SC s2 = new SC("Saleen S7", "", 2500, 200, p2, p2, 0);
		SC s3 = new SC("Koenigsegg Agera", "", 2500, 300, p3, p3, 0);
		SC s4 = new SC("SSC Ultimate Aero", "", 2500, 400, p4, p4, 0);
		SC s5 = new SC("Koenigsegg Agera R", "", 2500, 500, p5, p5, 0);
        
        Circuito ct1 = new Circuito("ALGARVE", 4664, 16, 100908, 103345, 108568, 112230, 91464, 20000, 16000, p3);
		Circuito ct2 = new Circuito("Estoril",4182, 13, 84000, 0, 0, 0, 84000, 40000, 50000, p3);

		HashSet<Veiculo> v = new HashSet<Veiculo>();
		v.add(p21);
		v.add(p22);
		
		Corrida c2 = new Corrida (v, ct1 ,false);
		Corrida c3 = new Corrida( v, ct2,true);

		HashSet<Corrida> v96= new HashSet<Corrida>();
		v96.add(c2);
		v96.add(c3);
		Campeonato k1 = new Campeonato(v96);
        		
		double tx1=0, tx2=0, tx3=0, tx4=0, tx5=0;
		for(int i = 0 ; i < 5; i++){
			double x1 = p11.tempoProximaVolta(ct1,false);
			double x2 = p12.tempoProximaVolta(ct1,false);
			double x3 = p13.tempoProximaVolta(ct1,false);
			double x4 = p14.tempoProximaVolta(ct1,false);
			double x5 = p15.tempoProximaVolta(ct1,false);
			
			tx1+=x1;
			tx2+=x2;
			tx3+=x3;
			tx4+=x4;
			tx5+=x5;

			System.out.println("P1 " + x1/1000 + "\tP2 " + x2/1000 + "\tP3 " + x3/1000 + "\tP4 " + x4/1000 + "\tP5 " + x5/1000);
		}
        System.out.println("\nP1 " + tx1/1000 + "\tP2 " + tx2/1000 + "\tP3 " + tx3/1000 + "\tP4 " + tx4/1000 + "\tP5 " + tx5/1000 + "\n");
        
		tx1=0; tx2=0; tx3=0; tx4=0; tx5=0;
        for(int i = 0 ; i < 5; i++){
			double x1 = p21.tempoProximaVolta(ct1,false);
			double x2 = p22.tempoProximaVolta(ct1,false);
			double x3 = p23.tempoProximaVolta(ct1,false);
			double x4 = p24.tempoProximaVolta(ct1,false);
			double x5 = p25.tempoProximaVolta(ct1,false);
			
			tx1+=x1;
			tx2+=x2;
			tx3+=x3;
			tx4+=x4;
			tx5+=x5;

			System.out.println("P1 " + x1/1000 + "\tP2 " + x2/1000 + "\tP3 " + x3/1000 + "\tP4 " + x4/1000 + "\tP5 " + x5/1000);
		}
        System.out.println("\nP1 " + tx1/1000 + "\tP2 " + tx2/1000 + "\tP3 " + tx3/1000 + "\tP4 " + tx4/1000 + "\tP5 " + tx5/1000 + "\n");
        
    	tx1=0; tx2=0; tx3=0; tx4=0; tx5=0;
        for(int i = 0 ; i < 5; i++){
			double x1 = g1.tempoProximaVolta(ct1,false);
			double x2 = g2.tempoProximaVolta(ct1,false);
			double x3 = g3.tempoProximaVolta(ct1,false);
			double x4 = g4.tempoProximaVolta(ct1,false);
			double x5 = g5.tempoProximaVolta(ct1,false);
			
			tx1+=x1;
			tx2+=x2;
			tx3+=x3;
			tx4+=x4;
			tx5+=x5;

			System.out.println("P1 " + x1/1000 + "\tP2 " + x2/1000 + "\tP3 " + x3/1000 + "\tP4 " + x4/1000 + "\tP5 " + x5/1000);
		}
        System.out.println("\nP1 " + tx1/1000 + "\tP2 " + tx2/1000 + "\tP3 " + tx3/1000 + "\tP4 " + tx4/1000 + "\tP5 " + tx5/1000 + "\n");
        
    	tx1=0; tx2=0; tx3=0; tx4=0; tx5=0;
        for(int i = 0 ; i < 5; i++){
			double x1 = s1.tempoProximaVolta(ct1,false);
			double x2 = s2.tempoProximaVolta(ct1,false);
			double x3 = s3.tempoProximaVolta(ct1,false);
			double x4 = s4.tempoProximaVolta(ct1,false);
			double x5 = s5.tempoProximaVolta(ct1,false);
			
			tx1+=x1;
			tx2+=x2;
			tx3+=x3;
			tx4+=x4;
			tx5+=x5;

			System.out.println("P1 " + x1/1000 + "\tP2 " + x2/1000 + "\tP3 " + x3/1000 + "\tP4 " + x4/1000 + "\tP5 " + x5/1000);
		}
        System.out.println("\nP1 " + tx1/1000 + "\tP2 " + tx2/1000 + "\tP3 " + tx3/1000 + "\tP4 " + tx4/1000 + "\tP5 " + tx5/1000 + "\n");
        
		//for(Integer vaa : k1.fazCampeonato().keySet()){ System.out.println("um " + k1.fazCampeonato().get(vaa)/1000+ "\n");}
	}	
}
