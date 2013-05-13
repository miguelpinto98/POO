
public class Time {
	private int horas,
	minutos,
	segundo;

	public Time(int horas, int minutos, int segundo) {
		this.horas = horas;
		this.minutos = minutos;
		this.segundo = segundo;
	}

	public Time() {
		this.horas = 0;
		this.minutos = 0;
		this.segundo = 0;
	}
	public Time(Time t) {
		this.horas = t.getHoras();
		this.minutos = t.getMinutos();
		this.segundo = t.getSegundo();
	}

	//get
	public int getHoras() {
		return horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public int getSegundo() {
		return segundo;
	}

	//set
	public void setHoras(int horas) {
		this.horas = horas;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}

	//toString
	public String toString() {
		StringBuilder s = new StringBuilder("Time  ");
		s.append("horas=" + horas);
		s.append(", minutos=" + minutos);
		s.append(", segundos=" + segundo);

		return s.toString();

	}

	//equals
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			Time v = (Time)o;
			return (  this.getHoras() == v.getHoras() &&  this.getMinutos() == v.getMinutos() && this.getSegundo() == v.getSegundo());
		}

	}

	//clone

	public Time clone() {
		return new Time(this);
	}
}