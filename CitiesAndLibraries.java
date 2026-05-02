// Given n cities, a list of possible bidirectional roads that can be built (each at cost c_road), and the cost to build a library in any city (c_lib), what is the minimum total cost to ensure every citizen has access to a library, either in their own city or via roads to a city with a library?


import java.util.*;

class Result {
    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
 
        if (c_lib <= c_road) {
            return (long) n * c_lib;
        }
        
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (List<Integer> edge : cities) {
            int u = edge.get(0);
            int v = edge.get(1);
            union(parent, u, v);
        }
        
        Map<Integer, Integer> componentSize = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int root = find(parent, i);
            componentSize.put(root, componentSize.getOrDefault(root, 0) + 1);
        }
        
        long total = 0;
        for (int size : componentSize.values()) {
            total += Math.min((long) c_lib + (long) (size - 1) * c_road, (long) size * c_lib);
        }
        return total;
    }
    
    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    
    private static void union(int[] parent, int a, int b) {
        int ra = find(parent, a);
        int rb = find(parent, b);
        if (ra != rb) {
            parent[rb] = ra;
        }
    }
}
public class CitiesAndLibraries {
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
