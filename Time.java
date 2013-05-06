/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author griffin
 */
public class Time {
    private int horas,minutos,segundo;

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

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

    
    @Override
    public String toString() {
        return "Time{" + "horas=" + horas + ", minutos=" + minutos + ", segundo=" + segundo + '}';
    }
     
       //equals
    public boolean equals(Object o) {
    if (this==o) return true;
    if((o==null)||(this.getClass() != o.getClass()))
     return false;
     else { Time v = (Time) o;
         return (this.getHoras()== v.getHoras()&&this.getMinutos() == v.getMinutos()&&this.getSegundo()== v.getSegundo());
        }
    
    }
}
