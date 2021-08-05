
import java.util.*;

public class GrafoBFS {
    
    private int v;
    private LinkedList<Integer> adyacencia[];
    private Queue<Integer> cola;
 
    GrafoBFS(int vert){
        v = vert;
        adyacencia = new LinkedList[vert];
        for (int i=0; i<vert; i++){
            adyacencia[i] = new LinkedList<>();
        }
        cola = new LinkedList<Integer>();
    }

 
    void addDir(int v,int w){
        adyacencia[v].add(w);
    }
 
    void BFS(int n){

        boolean nodes[] = new boolean[v];
        int a = 0;
 
        nodes[n]=true;                  
        cola.add(n);
 
        while (cola.size() != 0){
            n = cola.poll();
            System.out.print(n+" ");
 
            for (int i = 0; i < adyacencia[n].size(); i++){
                a = adyacencia[n].get(i);
                if (!nodes[a]){
                    nodes[a] = true;
                    cola.add(a);
                }
            }  
        }
    }
}
