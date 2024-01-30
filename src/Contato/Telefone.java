package Contato;

public class Telefone {
    //private Long id;
    private String ddd;
    private String numero;

    public Telefone (String ddd, String numero){
        this.ddd = ddd;
        this.numero = numero;
    }

    /*
    public long getId(){
        return this.id;
    }
    */
    public String getDdd(){
        return this.ddd;
    }

    public String getNumero() {
        return this.numero;
    }

    /*@Override
    public String toString(){
        return Long.toString(getId()) + ";" + getDdd() + ";" + getNumero();
    }
    */
    @Override
    public String toString(){
        return getDdd() + ";" + getNumero();
    }

}
