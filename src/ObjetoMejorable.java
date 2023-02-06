public class ObjetoMejorable {
    enum TIPO_RECURSO {ORO,ELIXIR,OSCURO}
    enum TIPO_OBJETO {ESTRUCTURA,TROPA,HEROE}
    private int niveles;
    private int[] tiempos;
    private int[] costes;
    private TIPO_RECURSO tipo_recurso;
    private TIPO_OBJETO tipo_objeto;
    public ObjetoMejorable(int niveles,int[]tiempos,int[]costes,String tipo_recurso,String tipo_objeto){
        this.niveles = niveles;
        this.tiempos = tiempos;
        this.costes = costes;
        this.tipo_recurso = TIPO_RECURSO.valueOf(tipo_recurso);
        this.tipo_objeto = TIPO_OBJETO.valueOf(tipo_objeto);
    }
    public int getNiveles(){
        return this.niveles;
    }
    public int getCoste(int nivel){ //cuánto cuesta mejorarlo al [nivel]
        return costes[nivel-1];
    }
    public int getTiempo(int nivel){ //cuánto tarda mejorarlo al [nivel] (en segundos)
        return tiempos[nivel-1];
    }
    public String getTipoRecurso(){
        return tipo_recurso.name();
    }
    public String getTipoObjeto(){
        return tipo_objeto.name();
    }
}
