
/**
 *
 * @author pedro
 */
public class Piloto {
    private String nome;
    private String nacionalidade;
    private int palmares;
    private int qualidade;
    private boolean chuva;

//construtores
    public Piloto(){
        this.nome="";
        this.nacionalidade="";
        this.palmares=0;
        this.qualidade=0;
        this.chuva=false;
    }
    
    public Piloto(String nome,String nacionalidade,int palmares,int qualidade,boolean chuva){
        this.nome=nome;
        this.nacionalidade=nacionalidade;
        this.palmares=palmares;
        this.qualidade=qualidade;
        this.chuva=chuva;
    }
    
   public Piloto(Piloto p) {
        
        this.nome=p.getNome();
        this.nacionalidade=p.getNacionalidade();
        this.palmares=p.getPalmares();
        this.qualidade=p.getQualidade();
        this.chuva=p.getChuva();
   }
   
//get
    public String getNacionalidade() {
        return nacionalidade;
    }

    public boolean getChuva() {
        return chuva;
    }
   
    public String getNome() {
        return nome;
    }

    public int getPalmares() {
        return palmares;
    }

    public int getQualidade() {
        return qualidade;
    }

    //set
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setPalmares(int palmares) {
        this.palmares = palmares;
    }

    public void setQualidade(int qualidade) {
        this.qualidade = qualidade;
    }

    public void setChuva(boolean chuva) {
        this.chuva = chuva;
    }
    
    
    
    ///Clone
    public Piloto clone() {
        return new Piloto(this);
    }
    
    //equals
    public boolean equals(Object o) {
    if (this==o) return true;
    if((o==null)||(this.getClass() != o.getClass()))
     return false;
     else { Piloto v = (Piloto) o;
         return (v.getNome().equals(o.getNome())&&v.getNacionalidade().equals(o.getNacionalidade()) && v.getPalmares() == o.getPalmares()  && this.getChuva()== o.getChuva() && v.getQualidade() == o.getQualidade()  );
        }
    
    }
//toString
    public String toString() {
        return "Piloto{" + "nome=" + nome + ", nacionalidade=" + nacionalidade + ", palmares=" + palmares + ", qualidade=" + qualidade + ", chuva=" + chuva + '}';
    }
}