import java.util.HashSet;
import java.util.Random;

public class GeraCampeonato {
	
	public static String daNome() {
		Random r = new Random();
		int x = r.nextInt(31);
		StringBuilder s = new StringBuilder();
		
		switch(x) {
            case 0: s.append("Haywood "); break;
            case 1: s.append("Willis "); break;
            case 2: s.append("Dewitt "); break;
            case 3: s.append("Claude "); break;
            case 4: s.append("Felipe "); break;
            case 5: s.append("Ellis "); break;
            case 6: s.append("Efren "); break;
            case 7: s.append("Forest "); break;
            case 8: s.append("Ira "); break;
            case 9: s.append("Neil "); break;
            case 10: s.append("Chase "); break;
            case 11: s.append("Sean "); break;
            case 12: s.append("Curt "); break;
            case 13: s.append("Mose "); break;
            case 14: s.append("Boris "); break;
            case 15: s.append("Miguel "); break;
            case 16: s.append("Len "); break;
            case 17: s.append("Forrest "); break;
            case 18: s.append("Buck "); break;
            case 19: s.append("Pedro "); break;
            case 20: s.append("Jonas "); break;
            case 21: s.append("Stewart "); break;
            case 22: s.append("Stephan "); break;
            case 23: s.append("Randy "); break;
            case 24: s.append("Steven "); break;
            case 25: s.append("Johnie "); break;
            case 26: s.append("Hayden "); break;
            case 27: s.append("Cole "); break;
            case 28: s.append("James "); break;
            case 29: s.append("Jim "); break;
            case 30: s.append("Kim "); break;
		}
		
		x = r.nextInt(31);
		switch(x) {
            case 0: s.append("Hommel"); break;
            case 1: s.append("Wordlaw"); break;
            case 2: s.append("Doney"); break;
            case 3: s.append("Chatterton"); break;
            case 4: s.append("Fenderson"); break;
            case 5: s.append("Encinas"); break;
            case 6: s.append("Espinoza"); break;
            case 7: s.append("Foland"); break;
            case 8: s.append("Lima"); break;
            case 9: s.append("Pinto"); break;
            case 10: s.append("Faria"); break;
            case 11: s.append("Insley"); break;
            case 12: s.append("Nehls"); break;
            case 13: s.append("Cleghorn"); break;
            case 14: s.append("Secord"); break;
            case 15: s.append("Courchesne"); break;
            case 16: s.append("Mcdade"); break;
            case 17: s.append("Brinn"); break;
            case 18: s.append("Wills"); break;
            case 19: s.append("Laufer"); break;
            case 20: s.append("Fickett"); break;
            case 21: s.append("Bradt"); break;
            case 22: s.append("Strauch"); break;
            case 23: s.append("Stills"); break;
            case 24: s.append("Rizer"); break;
            case 25: s.append("Shackleford"); break;
            case 26: s.append("Janson"); break;
            case 27: s.append("Hitt"); break;
            case 28: s.append("Carone"); break;
            case 29: s.append("Jusino"); break;
            case 30: s.append("Kampa"); break;
		}
		return s.toString();
	}
	
	public static String daNacionalidade() {
		Random r = new Random();
		int  x = r.nextInt(31);
		String s = "";
        
		switch(x) {
            case 0: s = "Portuguesa"; break;
            case 1: s = "Albanesa,"; break;
            case 2: s = "Alemã"; break;
            case 3: s = "Austríaca"; break;
            case 4: s = "Belga"; break;
            case 5: s = "Croata"; break;
            case 6: s = "Dinamarquesa"; break;
            case 7: s = "Eslovaca"; break;
            case 8: s = "Espanhola"; break;
            case 9: s = "Francesa"; break;
            case 10: s = "Grega"; break;
            case 11: s = "Irlandesa"; break;
            case 12: s = "Italiana"; break;
            case 13: s = "Holandesa"; break;
            case 14: s = "Polaca"; break;
            case 15: s = "Inglesa"; break;
            case 16: s = "Russa"; break;
            case 17: s = "Sueca"; break;
            case 18: s = "Turca"; break;
            case 19: s = "Ucraniana"; break;
            case 20: s = "Argentina"; break;
            case 21: s = "Chilena"; break;
            case 22: s = "Cubana"; break;
            case 23: s = "Mexicana"; break;
            case 24: s = "Chinesa"; break;
            case 25: s = "Indiana"; break;
            case 26: s = "Iraniana"; break;
            case 27: s = "Japonesa"; break;
            case 28: s = "Sul Africano"; break;
            case 29: s = "Angolano"; break;
            case 30: s = "Cabo Verdiano"; break;
		}
		return s;
	}
    
	public static Piloto geraPiloto() {
		Random r = new Random();
        
		return new Piloto(daNome(), daNacionalidade(), r.nextInt(50), r.nextInt(9) + 1, r.nextBoolean());
	}
	
	public static String daMarca() {
		Random r = new Random();
		int x = r.nextInt(37);
		String s = "";
		
		switch(x) {
            case 0: s = "Agrale"; break;
            case 1: s = "Aston Martin"; break;
            case 2: s = "Audi"; break;
            case 3: s = "Bentley"; break;
            case 4: s = "BMW"; break;
            case 5: s = "Changan"; break;
            case 6: s = "Chery"; break;
            case 7: s = "Chevrolet"; break;
            case 8: s = "Chrysler"; break;
            case 9: s = "Citroën"; break;
            case 10: s = "Dodge"; break;
            case 11: s = "Effa"; break;
            case 12: s = "Ferrari"; break;
            case 13: s = "Fiat"; break;
            case 14: s = "Ford"; break;
            case 15: s = "Hafei"; break;
            case 16: s = "Honda"; break;
            case 17: s = "Hyundai"; break;
            case 18: s = "Iveco"; break;
            case 19: s = "Jac Motors"; break;
            case 20: s = "Jaguar"; break;
            case 21: s = "Jeep"; break;
            case 22: s = "Jinbei"; break;
            case 23: s = "Kia"; break;
            case 24: s = "Lamborghini"; break;
            case 25: s = "Land Rover"; break;
            case 26: s = "Maserati"; break;
            case 27: s = "Mercedes-Benz"; break;
            case 28: s = "Mini"; break;
            case 29: s = "Nissan"; break;
            case 30: s = "Peugeot"; break;
            case 31: s = "Porsche"; break;
            case 32: s = "Renault"; break;
            case 33: s = "Subaru"; break;
            case 34: s = "Toyota"; break;
            case 35: s = "Volkswagen"; break;
            case 36: s = "Volvo"; break;
		}
		return s;
	}
    
	public static String daModelo() {
		Random r = new Random();
		int x = r.nextInt(50);
		String s = "";
		
		switch(x) {
            case 0: s = "MiTO"; break;
            case 1: s = "Vantage"; break;
            case 2: s = "RS5"; break;
            case 3: s = "TT"; break;
            case 4: s = "Continental"; break;
            case 5: s = "Z4"; break;
            case 6: s = "Camaro"; break;
            case 7: s = "Corvette"; break;
            case 8: s = "Spark"; break;
            case 9: s = "C1"; break;
            case 10: s = "C-Crosser"; break;
            case 11: s = "Nemo"; break;
            case 12: s = "Duster"; break;
            case 13: s = "Journey"; break;
            case 14: s = "612 Scaglietti"; break;
            case 15: s = "F599"; break;
            case 16: s = "500"; break;
            case 17: s = "Strada"; break;
            case 18: s = "Punto"; break;
            case 19: s = "Fiesta"; break;
            case 20: s = "Transit Connect"; break;
            case 21: s = "S-Max"; break;
            case 22: s = "Civic"; break;
            case 23: s = "Jazz"; break;
            case 24: s = "Rock"; break;
            case 25: s = "Pop"; break;
            case 26: s = "Veloster"; break;
            case 27: s = "NLR"; break;
            case 28: s = "Daily"; break;
            case 29: s = "XKR"; break;
            case 30: s = "Grand Cherokee"; break;
            case 31: s = "Gallardo"; break;
            case 32: s = "Ypsilon"; break;
            case 33: s = "Discovery"; break;
            case 34: s = "Sport"; break;
            case 35: s = "Exige"; break;
            case 36: s = "Quattroporte"; break;
            case 37: s = "MX-5"; break;
            case 38: s = "SLK"; break;
            case 39: s = "Roadster"; break;
            case 40: s = "Outlander"; break;
            case 41: s = "NV200"; break;
            case 42: s = "Primastar"; break;
            case 43: s = "RCZ"; break;
            case 44: s = "Panamera"; break;
            case 45: s = "Twizy"; break;
            case 46: s = "Octavia"; break;
            case 47: s = "Impreza"; break;
            case 48: s = "GT 86"; break;
            case 49: s = "XC90"; break;
		}
		return s;
	}
    
	public static Veiculo geraHibrido(Piloto p1, Piloto p2) { //falta a ideia do griffin no fim
		Veiculo v = null;
		Random r = new Random();
		int x = r.nextInt(3);
		
		if(x==0)
			v= new PC1Hibrido(daMarca(), daModelo(), 6000, r.nextInt(600) + 700, p1, p2, r.nextInt(),0);
		if(x==1)
			v= new PC2Hibrido(daMarca(), daModelo(), (r.nextInt(2000) + 4000), r.nextInt(400) + 550, p1, p2, r.nextInt());
		if(x==2)
			v= new GTHibrido(daMarca(), daModelo(), (r.nextInt(1500) + 3000), r.nextInt(200) + 400, p1, p2, r.nextInt());
		return v;
	}
    
	public static Veiculo geraVeiculo() { //falta a ideia do griffin no fim
		Piloto p1 = geraPiloto();
		Piloto p2 = geraPiloto();
		Veiculo v = null;
		Random r = new Random();
		int x = r.nextInt(5);
		
		if(x==0)
			v= geraHibrido(p1,p2);
		if(x==1)
			v= new PC1Normal(daMarca(), daModelo(), 6000, r.nextInt(600) + 700, p1, p2, r.nextInt());
		if(x==2)
			v= new PC2Normal(daMarca(), daModelo(), (r.nextInt(2000) + 4000), r.nextInt(400) + 550, p1, p2, r.nextInt());
		if(x==3)
			v= new GTNormal(daMarca(), daModelo(), (r.nextInt(1500) + 3000), r.nextInt(200) + 400, p1, p2, r.nextInt());
		if(x==4)
			v= new SC(daMarca(), daModelo(), 2500, r.nextInt(100) + 100, p1, p2, r.nextInt());
		
		return v;
	}
	
	public static HashSet<Veiculo> geraVeiculos() {
		Random r = new Random();
		int x = r.nextInt(15) + 12, i=0;
		HashSet<Veiculo> aux = new HashSet<Veiculo>();
		
		while (i<x) {
			aux.add(geraVeiculo());
			i++;
		}
		return aux;
	}
	
	public static Circuito geraCircuito() {
		Piloto p = new Piloto(geraPiloto());
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
    
	public static Campeonato geraCampeonato() {
		Random r = new Random();
		int x=r.nextInt(10)+11, i=0;
		HashSet<Corrida> aux = new HashSet<Corrida>();
		HashSet<Veiculo> aux2 = new HashSet<Veiculo>();
		
		aux2=geraVeiculos();
		while (i<x) {
			aux.add(geraCorrida(aux2));
			i++;
		}
		return (new Campeonato(aux));
	}
	
	public static void main(String[] args){
		Campeonato k2 = geraCampeonato() ;
			
		System.out.println("asda "+k2.toString()+'\n');
	}
	
}
