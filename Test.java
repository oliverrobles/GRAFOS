
public class Test {

    public static void main(String[] args) {
        
        Grafo Grafo1 = new Grafo();
        
        int tam = 5;
	      Vertice [] vertices = new Vertice[tam];
	      char [] etiquetas = {'Z','X','V','T','R'};

	      for(int i = 0; i < vertices.length; i++){
	    	    vertices[i] = new Vertice(Character.toString(etiquetas[i]));
	     	    System.out.println(vertices[i]);	    	
	      }

	      System.out.println();

	      Grafo1.insertarArista(vertices[4], vertices[2], 10);
	      Grafo1.insertarArista(vertices[3], vertices[0], 6);
	      Grafo1.insertarArista(vertices[4], vertices[3], 40);	
	      Grafo1.insertarArista(vertices[4], vertices[3], 38);
	      Grafo1.insertarArista(vertices[3], vertices[2], 39);
	      Grafo1.insertarArista(vertices[1], vertices[4], 25);
        
        Grafo1.listAdyacencia(vertices);
    }
    
}
