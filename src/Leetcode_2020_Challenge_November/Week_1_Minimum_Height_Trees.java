package Leetcode_2020_Challenge_November;

import java.util.*;

public class Week_1_Minimum_Height_Trees {

    public static void main(String[] args) {
//        int n = 8;
//        int[][] edges = {
//                {1, 0}, {1, 2}, {3, 2}, {0, 4}, {5, 4}, {4,6}, {6,7}
//        };
        int n = 6;
        int[][] edges = {
                {3,0}, {3,1}, {3,2}, {3,4}, {5,4}
        };
//        int n = 10;
//        int[][] edges = {
//                {0,1}, {0,2}, {0,3}, {2,4}, {0,5}, {5,6}, {6,7}, {2,8}, {7,9}
//        };
        System.out.println(findMinHeightTrees(n, edges).toString());
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();
        Vector<Vector<Integer>> rootEdge = new Vector<>();
        int heightOfTree;
        if (edges.length == 0) {
            result.add(0);
            return result;
        }
        if (n == 2) {
            result.add(0);
            result.add(1);
            return result;
        }

        for (int i = 0; i < n; i++) {
            rootEdge.add(new Vector<>());
        }
        for (int[] edge : edges) {
            rootEdge.get(edge[0]).add(edge[1]);
            rootEdge.get(edge[1]).add(edge[0]);
        }

        int[] heightOfEachEdges = new int[n];
        int minHeight = Integer.MAX_VALUE;
        Vector<Integer> possibleEdges = new Vector<>();
        for (int i = 0; i < n; i++) {
            if (rootEdge.get(i).size() > 1) {
                possibleEdges.add(i);
            }
        }

        System.out.println(possibleEdges.toString());
        System.out.println("___________________");
        for (int i : possibleEdges) {
            System.out.print(i + "-->");
            heightOfTree = calHeightStack(i, n, rootEdge);
            heightOfEachEdges[i] = heightOfTree;
            minHeight = Math.min(minHeight, heightOfTree);
            System.out.println("___________________");
        }

        for (int i = 0; i < heightOfEachEdges.length; i++) {
            System.out.println(i + ": " + heightOfEachEdges[i]);
            if (heightOfEachEdges[i] == minHeight) {
                result.add(i);
            }
        }
        return result;
    }

//    private static void calHeight(int currentHeight, int root) {
//        for (int i : rootEdge.get(root)) {
//            if (rootEdge.get(i).size() > 1 && !isCheck[i]) {
//                System.out.print(i + " ");
//                isCheck[i] = true;
//                calHeight(++currentHeight, i);
//                --currentHeight;
//                isCheck[i] = false;
//            }
//        }
//        heightOfTree = Math.max(heightOfTree, currentHeight);
//    }
//
//    private static void calHeightQueue(int root) {
//        Queue<Integer> queue = new LinkedList<>();
//        int currentHeight = 1;
//        queue.add(root);
//        isCheck[root] = true;
//        int u;
//        boolean hasPossibleEdge;
//        while (!queue.isEmpty()) {
//            u = queue.poll();
//            hasPossibleEdge = false;
//            System.out.print(u + ": ");
//            for (int i: rootEdge.get(u)) {
//                if (rootEdge.get(i).size() > 1 && !isCheck[i]) {
//                    isCheck[i] = true;
//                    queue.add(i);
//                    hasPossibleEdge = true;
//                    System.out.print(i + " ");
//                }
//            }
//            System.out.println();
//            if (!hasPossibleEdge) {
//                heightOfTree = Math.max(heightOfTree, currentHeight);
//                --currentHeight;
//            } else {
//                ++currentHeight;
//            }
//        }
//    }

    private static int calHeightStack(int root, int n, Vector<Vector<Integer>> rootEdge) {
        boolean[] isCheck = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        int heightOfTree = -1;
        int currentHeight = 1;
        stack.add(root);
        isCheck[root] = true;
        int u;
        boolean hasPossibleEdge;
        while (!stack.isEmpty()) {
            u = stack.peek();
            hasPossibleEdge = false;
            System.out.print(u + ": ");
            for (int i: rootEdge.get(u)) {
                if (rootEdge.get(i).size() > 1 && !isCheck[i]) {
                    isCheck[i] = true;
                    stack.push(i);
                    hasPossibleEdge = true;
                    System.out.print(i + " ");
                    break;
                }
            }
            System.out.println();
            if (!hasPossibleEdge) {
                heightOfTree = Math.max(heightOfTree, currentHeight);
                --currentHeight;
                stack.pop();
            } else {
                ++currentHeight;
            }
        }
        return heightOfTree;
    }
}
