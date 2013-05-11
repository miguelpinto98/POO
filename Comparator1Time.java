 import java.util.Comparator;

 public class Comparator1Time implements Comparator < Time > {

 	public int compareTo(Time p) {
 		if (this.getHoras() < p.getHoras())
 			return -1;
 		if (this.getHoras() > p.getHoras())
 			return 1;
 		if (this.getMinutos() < p.getMinutos())
 			return -1;
 		if (this.getMinutos() > getMinutos())
 			return 1;
 		if (this.getSegundo() < p.getSegundo())
 			return -1;
 		if (this.getSegundo() > p.getSegundo())
 			return 1;
 		else
 			return 0;

 	}

 }