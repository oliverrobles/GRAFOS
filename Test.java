
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
	
	
	GrafoDFS g = new GrafoDFS(6);
 
        g.addDir(0, 1);
        g.addDir(0, 2);
        g.addDir(1, 0);
        g.addDir(1, 3);
        g.addDir(2, 0);
        g.addDir(2, 3);
        g.addDir(3, 4);
        g.addDir(3, 5);
        g.addDir(4, 3);
        g.addDir(5, 3);
 
        System.out.println(
            "A continuación se muestra el recorrido en profundidad: ");
 
        g.DFS(0);
    }
    
}
