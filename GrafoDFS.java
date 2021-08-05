
import java.util.*;

public class GrafoDFS {
    
    int v;                                         
          
    LinkedList<Integer>[] adyacencia;
          
    GrafoDFS(int vert) { 
            this.v = vert; 
            adyacencia = new LinkedList[vert]; 
              
            for (int i = 0; i < adyacencia.length; i++) 
                adyacencia[i] = new LinkedList<Integer>(); 
              
    } 
          
    void addDir(int v, int w) { 
            adyacencia[v].add(w);
    } 
          
    void DFS(int n) { 
            boolean nodes[] = new boolean[v]; 
      
            Stack<Integer> pila = new Stack<>(); 
              
            pila.push(n);                                    
            int a = 0;
              
            while(!pila.empty()) { 
                n = pila.peek();                       
                pila.pop();                           
                  
                if(nodes[n] == false) { 
                    System.out.print(n + " "); 
                    nodes[n] = true; 
                } 
                  
                for (int i = 0; i < adyacencia[n].size(); i++) {
                    a = adyacencia[n].get(i);
                    if (!nodes[a]){
                        pila.push(a);
                    }
                }  
                  
            } 
    }
}
