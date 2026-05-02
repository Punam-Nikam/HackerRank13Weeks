// Given n cities, a list of possible bidirectional roads that can be built (each at cost c_road), and the cost to build a library in any city (c_lib), what is the minimum total cost to ensure every citizen has access to a library, either in their own city or via roads to a city with a library?


import java.util.*;

class Result {
    
    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // If building a library is cheaper or equal to building a road,
        // the optimal solution is to put a library in every city.
        // No roads needed → total cost = n * c_lib.
        if (c_lib <= c_road) {
            return (long) n * c_lib;
        }

        // ---------- Union-Find (Disjoint Set) to find connected components ----------
        // parent[i] = representative of the set containing city i
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;                // initially each city is its own component
        }

        // Union the endpoints of every available road.
        // This groups cities that are directly or indirectly connectable.
        for (List<Integer> edge : cities) {
            int u = edge.get(0);
            int v = edge.get(1);
            union(parent, u, v);
        }

        // ---------- Count the size of each component ----------
        // Map: component root -> number of cities in that component
        Map<Integer, Integer> componentSize = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int root = find(parent, i);
            componentSize.put(root, componentSize.getOrDefault(root, 0) + 1);
        }

        // ---------- Compute minimal cost per component ----------
        // For a component of 'size' cities, we have two strategies:
        //   1. Build one library and (size-1) roads (connecting all cities into a tree).
        //      Cost = c_lib + (size-1) * c_road
        //   2. Build a library in every city.
        //      Cost = size * c_lib
        // We take the minimum of the two, and sum over all components.
        long total = 0;
        for (int size : componentSize.values()) {
            long costWithOneLib = (long) c_lib + (long) (size - 1) * c_road;
            long costWithAllLibs = (long) size * c_lib;
            total += Math.min(costWithOneLib, costWithAllLibs);
        }
        return total;
    }

    /**
     * Find the representative (root) of the set containing x.
     * Uses path compression to flatten the tree.
     */
    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);   // recursively find root and compress path
        }
        return parent[x];
    }

    /**
     * Union the sets containing a and b.
     * Simple version: attach root of b under root of a (no rank optimisation needed here,
     * but works fine because the graph size is moderate and we only call union for each edge).
     */
    private static void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA != rootB) {
            parent[rootB] = rootA;   // make rootA the parent of rootB
        }
    }
}public class CitiesAndLibraries {
 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
   
        System.out.print("Enter number of queries: ");
        
        int q = scanner.nextInt();
        
        for (int queryNum = 1; queryNum <= q; queryNum++) {
            
            System.out.print("Enter number of cities (n), number of possible roads (m),  cost to build a library (c_lib), cost to build a road (c_road): ");
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int c_lib = scanner.nextInt();
            int c_road = scanner.nextInt();
            
            List<List<Integer>> cities = new ArrayList<>();
            System.out.println("Enter " + m + " roads (each as 'u v'):");
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                cities.add(Arrays.asList(u, v));
            }
            
            long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);
            System.out.println("Minimum cost: " + result);
        }
        
        scanner.close();
        
    }
}
