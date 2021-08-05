
import java.util.*;

public class Vertice {
    
    private ArrayList<Arista> vecinos;
    private String etiqueta;

    public Vertice (String etiqueta){
	      this.etiqueta = etiqueta;
	      this.vecinos = new ArrayList<Arista>();
    }

    public void insertarVecino(Arista arista){
	      if( !this.vecinos.contains(arista))
	          this.vecinos.add(arista);
    }

    public boolean contieneUnVecino(Arista arista){
	      return this.vecinos.contains(arista);
    }
    
    public Arista getVecino(int indice){
	      return this.vecinos.get(indice);
    }

    public Arista eliminarVecino(int indice){
	      return this.vecinos.remove(indice);
    }

    public void eliminarVecino(Arista arista){
	      this.vecinos.remove(arista);
    }

    public int getContarVecinos(){
	      return this.vecinos.size();
    }

    public String getEtiqueta(){
	      return this.etiqueta;
    }

    public boolean equals(Object vertice2){
	      if( !(vertice2 instanceof Vertice))
	          return false;
	      Vertice v = (Vertice) vertice2;
	      return this.etiqueta.equals(v.etiqueta);
    }

    public String toString(){
	      return "Vertice: " + this.etiqueta;
    }

    public ArrayList<Arista> getVecinos(){
	      return new ArrayList<Arista>(this.vecinos);
    }
}
