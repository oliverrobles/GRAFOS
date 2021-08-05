
public class Test {

    public static void main(String[] args) {
        
        Grafo Grafo1 = new Grafo();
        
        int tam = 5;
	System.out.println("Lista de adyacencia\n");
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
	
	
	GrafoDFS g2 = new GrafoDFS(6);
 	
	System.out.println("DFS\n");
        g2.addDir(0, 1);
        g2.addDir(0, 2);
        g2.addDir(1, 0);
        g2.addDir(1, 3);
        g2.addDir(2, 0);
        g2.addDir(2, 3);
        g2.addDir(3, 4);
        g2.addDir(3, 5);
        g2.addDir(4, 3);
        g2.addDir(5, 3);
 
        System.out.println(
            "A continuación se muestra el recorrido en profundidad: ");
 
        g2.DFS(0);
	    
	    
	GrafoBFS grafo3 = new GrafoBFS(6);
 	
	System.out.println("BFS\n");
        grafo3.addDir(3, 5);
        grafo3.addDir(4, 5);
        grafo3.addDir(1, 3);
        grafo3.addDir(1, 4);
        grafo3.addDir(1, 2);
        grafo3.addDir(0, 1);
        grafo3.addDir(1, 0);
        grafo3.addDir(2, 5);
        grafo3.addDir(5, 1);
        grafo3.addDir(5, 2);
        grafo3.addDir(0, 5);
        grafo3.addDir(0, 3);
 
        System.out.println("El recorrido en anchura es la siguiente:");
 
        grafo3.BFS(0);
	    
	Dijkstra.Arista[] GrafoD = {
            new Dijkstra.Arista("a", "b", 7),
            new Dijkstra.Arista("a", "c", 9),
            new Dijkstra.Arista("a", "f", 14),
            new Dijkstra.Arista("b", "c", 10),
            new Dijkstra.Arista("b", "d", 15),
            new Dijkstra.Arista("c", "d", 11),
            new Dijkstra.Arista("c", "f", 2),
            new Dijkstra.Arista("d", "e", 6),
            new Dijkstra.Arista("e", "f", 9),
            };
        String START = "a";
        String END = "e";
	    
	Dijkstra g4 = new Dijkstra(GrafoD);
        g4.dijkstra(START);
        System.out.println("\n\nDijkstra\n");
        System.out.println("Camino mas corto:");
        g4.camino(END);
        System.out.println("\n\n");
        
        System.out.println("Todos los caminos:");
        g4.caminos();
    }
}
