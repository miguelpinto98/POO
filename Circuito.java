/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author griffin
 */
import java.sql.Time;
public class Circuito {
    private int distancia,nvoltas;
    private Time tpc1,tpc2,tgt,tsc,trecord,tdesviom,tboxes;
    private Piloto recordista;

    public int getDistancia() {
        return distancia;
    }

    public int getNvoltas() {
        return nvoltas;
    }

    public Time getTpc1() {
        return tpc1;
    }

    public Time getTpc2() {
        return tpc2;
    }

    public Time getTgt() {
        return tgt;
    }

    public Time getTsc() {
        return tsc;
    }

    public Time getTrecord() {
        return trecord;
    }

    public Time getTdesviom() {
        return tdesviom;
    }

    public Time getTboxes() {
        return tboxes;
    }

    public Piloto getRecordista() {
        return recordista;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public void setNvoltas(int nvoltas) {
        this.nvoltas = nvoltas;
    }

    public void setTpc1(Time tpc1) {
        this.tpc1 = tpc1;
    }

    public void setTpc2(Time tpc2) {
        this.tpc2 = tpc2;
    }

    public void setTgt(Time tgt) {
        this.tgt = tgt;
    }

    public void setTsc(Time tsc) {
        this.tsc = tsc;
    }

    public void setTrecord(Time trecord) {
        this.trecord = trecord;
    }

    public void setTdesviom(Time tdesviom) {
        this.tdesviom = tdesviom;
    }

    public void setTboxes(Time tboxes) {
        this.tboxes = tboxes;
    }

    public void setRecordista(Piloto recordista) {
        this.recordista = recordista;
    }

    @Override
    public String toString() {
        return "Circuito{" + "distancia=" + distancia + ", nvoltas=" + nvoltas + ", tpc1=" + tpc1 + ", tpc2=" + tpc2 + ", tgt=" + tgt + ", tsc=" + tsc + ", trecord=" + trecord + ", tdesviom=" + tdesviom + ", tboxes=" + tboxes + ", recordista=" + recordista + '}';
    }

    public Circuito(int distancia, int nvoltas, Time tpc1, Time tpc2, Time tgt, Time tsc, Time trecord, Time tdesviom, Time tboxes, Piloto recordista) {
        this.distancia = distancia;
        this.nvoltas = nvoltas;
        this.tpc1 = tpc1;
        this.tpc2 = tpc2;
        this.tgt = tgt;
        this.tsc = tsc;
        this.trecord = trecord;
        this.tdesviom = tdesviom;
        this.tboxes = tboxes;
        this.recordista = recordista;
    }

    public Circuito() {
         this.distancia = 0;
        this.nvoltas = 0;
        this.tpc1 = new Time();
        this.tpc2 = new Time;
        this.tgt = new Time();
        this.tsc = new Time();
        this.trecord = new Time();
        this.tdesviom = new Time();
        this.tboxes = new Time();
        this.recordista = new Piloto();
        
    }

    public Circuito(Circuito c) {
         this.distancia = c.getDistancia();
        this.nvoltas = c.getNvoltas();
        this.tpc1 = c.getTpc1();
        this.tpc2 = c.getTpc2();
        this.tgt = c.getTgt();
        this.tsc = c.getTsc();
        this.trecord = c.getTrecord();
        this.tdesviom = c.getTdesviom();
        this.tboxes = c.getTboxes();
        this.recordista = c.getRecordista().clone();
        
    }

    
    
}
