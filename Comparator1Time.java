 import java.util.Comparator;

 public class Comparator1Time implements Comparator<Time> {

 	public int compare(Time c, Time p) {
 		if (c.getHoras() < p.getHoras())
 			return -1;
 		if (c.getHoras() > p.getHoras())
 			return 1;
 		if (c.getMinutos() < p.getMinutos())
 			return -1;
 		if (c.getMinutos() > p.getMinutos())
 			return 1;
 		if (c.getSegundo() < p.getSegundo())
 			return -1;
 		if (c.getSegundo() > p.getSegundo())
 			return 1;
 		else
 			return 0;

 	}

 }