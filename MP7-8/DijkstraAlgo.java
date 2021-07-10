import java.io.*;
import java.util.*;

public class DijkstraAlgo {
    static Scanner in = new Scanner(System.in);
    static Vector<Vector<Integer>> table_status;
    static Vector<Vector<Boolean>> visited_status;
    
    static int InputTableSize() {
        int n = 0;
        while (true) {
            System.out.print("Enter table size [2, 3, 4, 5, 6]: ");
            n = in.nextInt();
            if (n != 2 && n != 3 && n != 4 && n != 5 && n != 6) {
                System.out.println("Please try again.");
                continue;
            }
            break;
        }
        return n;
    }
    
    static char[] CreateLetterColumn(int n) {
        char[] letters = new char[n];
        for (int i = 0, start = 65; i < n; i++, start++) {
            letters[i] = (char) (start);
        }
        return letters;
    }
    
    static boolean InputType(int n) {
        boolean random = false;
        while (true) {
            System.out.print("\nRandomize values? (Y or N): ");
            char ch = in.next().charAt(0);
            if (ch == 'Y' || ch == 'y') {
                random = true;
                break;
            } else if (ch == 'N' || ch == 'n') {
                break;
            } else {
                System.out.println("Please try again.");
            }
        }
        return random;
    }
    
    static int[][] InputTable(int n, boolean random) {
        int[][] a = new int[n][n];
        int start = 1;
        int end = 20;
        if (!random) {
            System.out.println("\nEnter values in [" + n + " x " + n + "] table: ");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (random) {
                    if (i != j) {
                        a[i][j] = (int) Math.floor(Math.random() * (end - start + 1) + start);
                        continue;
                    }
                    a[i][j] = 0;
                } else {
                    a[i][j] = in.nextInt();
                }
            }
        }
        return a;
    }
    
    static void PrintOriginal(int[][] a, int n, char[] letters) {
        System.out.println("\nOriginal Table:\n");
        for (int i = 0; i < n; i++) {
            System.out.print("\t" + letters[i]);
        }
        System.out.println("");
        for (int i = 0; i < n; i++) {
            System.out.print(letters[i]);
            for (int j = 0; j < n; j++) {
                System.out.print("\t" + a[i][j]);
            }
            System.out.println("");
        }
    }
    
    static int ConvertLetter(int n, char starting_vertex, char[] letters) {
        int vertex = -1;
        for (int i = 0; i < n; i++) {
            if (letters[i] == starting_vertex) {
                vertex = i;
                break;
            }
        }
        return vertex;
    }
    
    static char DetermineStartVertex(int n, char[] letters) {
        char starting_vertex = 'A';
        while (true) {
            System.out.print("\nChoose starting vertex " + Arrays.toString(letters) + ": ");
            starting_vertex = in.next().charAt(0);
            starting_vertex = Character.toUpperCase(starting_vertex);
            boolean checker = false;
            for (int i = 0; i < n; i++) {
                if (starting_vertex == letters[i]) {
                    checker = true;
                    break;
                }
            }
            if (checker) {
                break;
            }
            System.out.println("Please try again.");
        }
        return starting_vertex;
    }
    
    static int GetMinimumDistance(int[] distance, boolean[] visited) {
        int mn = Integer.MAX_VALUE;
        int id = -1;
        for (int i = 0; i < (int) distance.length; i++) {
            if (!visited[i] && distance[i] <= mn) {
                mn = distance[i];
                id = i;
            }
        }
        return id;
    }
    
    static Vector<Integer> ConvertIntegerArray(int[] distance) {
        Vector<Integer> temp_1D = new Vector<Integer>();
        for (int i = 0; i < (int) distance.length; i++) {
            temp_1D.add(distance[i]);
        }
        return temp_1D;
    }
    
    static Vector<Boolean> ConvertBooleanArray(boolean[] visited) {
        Vector<Boolean> temp_1D = new Vector<Boolean>();
        for (int i = 0; i < (int) visited.length; i++) {
            temp_1D.add(visited[i]);
        }
        return temp_1D;
    }
    
    static int[] GetShortestPath(int[][] a, int start) {
        int n = (int) a.length;
        table_status = new Vector<Vector<Integer>>();
        visited_status = new Vector<Vector<Boolean>>();
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        distance[start] = 0;
        table_status.add(ConvertIntegerArray(distance));
        visited[start] = true;
        visited_status.add(ConvertBooleanArray(visited));
        visited[start] = false;
        for (int i = 0; i < n; i++) {
            int origin = GetMinimumDistance(distance, visited);
            visited[origin] = true;
            for (int j = 0; j < n; j++) {
                int alternative = distance[origin] + a[origin][j];
                if (!visited[j] && a[origin][j] != 0 && distance[origin] != Integer.MAX_VALUE && alternative < distance[j]) {
                    distance[j] = alternative;
                }
            }
            table_status.add(ConvertIntegerArray(distance));
            visited_status.add(ConvertBooleanArray(visited));
        }
        return distance;
    }
    
    static void Simulate(char[] letters) {
        System.out.println("\nSimulation:\n");
        for (int i = 0; i < (int) table_status.size(); i++) {
            for (int j = 0; j < (int) table_status.get(i).size(); j++) {
                int element = table_status.get(i).get(j);
                System.out.print(letters[j] + ": ");
                System.out.println((element == Integer.MAX_VALUE ? "INF" : element) + " ");
            }
            System.out.println("\nUnvisited Vertices:\n");
            for (int j = 0; j < (int) visited_status.get(i).size(); j++) {
                boolean element = visited_status.get(i).get(j);
                String status = (element ? "Visited" : "Not Yet Visited");
                System.out.println(letters[j] + ": " + status);
            }
            System.out.println("\n-----\n");
        }
    }
    
    static void PrintShortestDistance(char starting_vertex, char[] letters, int[] res) {
        System.out.println("Starting Vertex: " + starting_vertex + "\n");
        for (int i = 0; i < (int) res.length; i++) {
            System.out.println(letters[i] + ": " + (res[i] == Integer.MAX_VALUE ? "INF" : res[i]));
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // get table size
        int n = InputTableSize();
        // create corresponding letters
        char[] letters = CreateLetterColumn(n);
        // choose between random or user input
        boolean random = InputType(n);
        // input table
        int[][] a = InputTable(n, random);
        // choose starting vertex
        char starting_vertex = DetermineStartVertex(n, letters);
        // print original table
        PrintOriginal(a, n, letters);
        // find the numerical equivalent of 'starting_vertex'
        int vertex = ConvertLetter(n, starting_vertex, letters);
        // use the algorithm to find the answer
        int[] res = GetShortestPath(a, vertex);
        // print simulation
        Simulate(letters);
        // print final answer
        PrintShortestDistance(starting_vertex, letters, res);
    }
}
