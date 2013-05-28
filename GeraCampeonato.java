import java.util.HashSet;
import java.util.Random;


public class GeraCampeonato {
	
	
	public  HashSet<Veiculo> geraVeiculos(){
		Random r = new Random();
		int x = r.nextInt(8)+12;
		int y = 0;
		HashSet<Veiculo> aux = new HashSet<Veiculo>();
		while (y<x){
			aux.add(geraVeiculo());
			
			y++;
		}
		return aux;
		
	}
	public String daMarca(){
		String s = "FAFAFA";
	   return s;
	}
	public String daModelo(){
		String s = "FAFAFA";
	   return s;
	}

	public Veiculo gerahibrido(Piloto p1, Piloto p2){
		Veiculo v = null;
		Random r = new Random();
		int x = r.nextInt(2);
		if(x==0){ v =  new PC1  (daMarca(), daModelo(),r.nextInt(), r.nextInt(),
				p1,p2, r.nextInt());}
		if(x==1){ v = new PC1  (daMarca(), daModelo(),r.nextInt(), r.nextInt(),
				p1,p2, r.nextInt());}
		if(x==2){ v = new PC1  (daMarca(), daModelo(),r.nextInt(), r.nextInt(),
				p1,p2, r.nextInt());}
		return v;
	}
	
	public Veiculo geraVeiculo(){ 
		Piloto p1 = geraPiloto();
		Piloto p2 = geraPiloto();
		Veiculo v = null;
		Random r = new Random();
		
		int x = r.nextInt(4);
		if (x==0){  v = gerahibrido(p1,p2);}else 
			if(x==1){ v = new PC1  (daMarca(), daModelo(),r.nextInt(), r.nextInt(),
					p1,p2, r.nextInt());}
				if(x==2){v = new PC2  (daMarca(), daModelo(),r.nextInt(), r.nextInt(),
						p1,p2, r.nextInt());}
					if(x==3){v = new SC  (daMarca(), daModelo(),r.nextInt(), r.nextInt(),
							p1,p2, r.nextInt());}
						if(x==4){v = new GT  (daMarca(), daModelo(),r.nextInt(), r.nextInt(),
								p1,p2, r.nextInt());}
		
		
		
		return v;
	}

		public String daNome(){
			String s = "Jusebio";
			return s;
		}
		public String daNacionalidade(){
			String s = "Pretogal";
			return s;
		}
		
		public Piloto geraPiloto(){
			Random r = new Random(); int quali = r.nextInt(9)+1; int palmares = r.nextInt(50); boolean chuva = r.nextBoolean();
			
			return new Piloto(daNome(),daNacionalidade(),  palmares,
					quali,  chuva);
			
			
		}
		public Corrida geraCorrida(HashSet<Veiculo> aux){
			Circuito ra = new Circuito();
			ra = geraCircuito();
			Corrida y= null;
			
			Random r = new Random();
			int x = r.nextInt(1);
			if(x==1 ){ y = new Corrida(aux,ra,true);}
			if(x==0) { y = new Corrida(aux,ra,false);}
			
			return y;
		}
		public Campeonato GeraCampeonato(){
			
			Random r = new Random();
			int x = r.nextInt(5)+4;
			int i =0 ;
			HashSet<Corrida> aux = new  HashSet<Corrida>();
			 HashSet<Veiculo> aux2 = new HashSet<Veiculo>(); 
			 aux2 = geraVeiculos();
			while (i<x){
				aux.add(geraCorrida(aux2));
				i++;
				
			}
			Campeonato c = new Campeonato(aux);
			return c;
			
		}
		
		public Circuito geraCircuito(){
			Piloto p = new Piloto(geraPiloto());
			Circuito c1 = new Circuito(), c2 = new Circuito();
			
			 c1 = new Circuito("Algarve", 4664, 16, 100908, 103345,108568, 112230, 91464, 13310, 16000, p);
			 c2 = new Circuito("Marrakech", 4624, 15, 88089, 91254, 95010, 98213, 80089, 8303, 19000, p);
			 c2 = new Circuito("Kyalami", 4261, 13, 86640, 89542, 92423, 95856, 79410, 7827, 25000, p);
						
			 return c1;
		}

}
