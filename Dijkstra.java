
import java.util.*;

public class Dijkstra {
    private final Map<String, Vertice> Dijkstra;
    public static class Arista {
        public final String v1, v2;
        public final int dist;

        public Arista(String v1, String v2, int dist) {
            this.v1 = v1;
            this.v2 = v2;
            this.dist = dist;
        }
    }

    public static class Vertice implements Comparable<Vertice> {
        public final String nombre;
        public int dist = Integer.MAX_VALUE;
        public Vertice anterior = null;
        public final Map<Vertice, Integer> vecinos = new HashMap<>();

        public Vertice(String n) {
            this.nombre = n;
        }

        private void camino() {
            if (this == this.anterior) {
                System.out.printf("%s", this.nombre);
            } else if (this.anterior == null) {
                System.out.printf("%s(inalcanzado)", this.nombre);
            } else {
                this.anterior.camino();
                System.out.printf(" -> %s(%d)", this.nombre, this.dist);
            }
        }

        public int compareTo(Vertice o) {
            if (dist == o.dist) return nombre.compareTo(o.nombre);
      
            return Integer.compare(dist, o.dist);
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            if (!super.equals(object)) return false;

            Vertice vert = (Vertice) object;

            if (dist != vert.dist) return false;
            if (nombre != null ? !nombre.equals(vert.nombre) : vert.nombre != null) return false;
            if (anterior != null ? !anterior.equals(vert.anterior) : vert.anterior != null)
                return false;
            if (vecinos != null ? !vecinos.equals(vert.vecinos) : vert.vecinos != null)
                return false;

            return true;
        }

        @Override
        public String toString() {
            return "(" + nombre + ", " + dist + ")";
        }
    }

    public Dijkstra(Arista[] a) {
        Dijkstra = new HashMap<>(a.length);

        for (Arista e : a) {
            if (!Dijkstra.containsKey(e.v1)) Dijkstra.put(e.v1, new Vertice(e.v1));
            if (!Dijkstra.containsKey(e.v2)) Dijkstra.put(e.v2, new Vertice(e.v2));
        }

        for (Arista e : a) {
            Dijkstra.get(e.v1).vecinos.put(Dijkstra.get(e.v2), e.dist);
        }
    }

    public void dijkstra(String nInic) {
        if (!Dijkstra.containsKey(nInic)) {
            System.err.printf("El grafo no contiene el vértice inicial \"%s\"%n", nInic);
            return;
        }
        final Vertice f = Dijkstra.get(nInic);
        NavigableSet<Vertice> q = new TreeSet<>();

        for (Vertice v : Dijkstra.values()) {
            v.anterior = v == f ? f : null;
            v.dist = v == f ? 0 : Integer.MAX_VALUE;
            q.add(v);
        }

        dijkstra(q);
    }

    private void dijkstra(final NavigableSet<Vertice> q) {
        Vertice u, v;
        while (!q.isEmpty()) {
            u = q.pollFirst();
            if (u.dist == Integer.MAX_VALUE)
                break;

            for (Map.Entry<Vertice, Integer> a : u.vecinos.entrySet()) {
                v = a.getKey();
                final int alterDist = u.dist + a.getValue();
                if (alterDist < v.dist) {
                    q.remove(v);
                    v.dist = alterDist;
                    v.anterior = u;
                    q.add(v);
                }
            }
        }
    }

    public void camino(String nFin) {
        if (!Dijkstra.containsKey(nFin)) {
            System.err.printf("El grafo no contiene vértice final \"%s\"%n", nFin);
            return;
        }

        Dijkstra.get(nFin).camino();
        System.out.println();
    }

    public void caminos() {
        for (Vertice v : Dijkstra.values()) {
            v.camino();
            System.out.println();
        }
    }
}
