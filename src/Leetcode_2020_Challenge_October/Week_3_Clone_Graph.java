package Leetcode_2020_Challenge_October;

import java.util.*;

public class Week_3_Clone_Graph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (node.neighbors.size() == 0) return new Node(node.val);
        Map<Integer, Node> mark = new HashMap<>();
        Node result = new Node(node.val);
        Node currentNode;
        mark.put(node.val, result);
        Stack<Node> trackOld = new Stack<>();
        trackOld.push(node);
        int val;
        while (!trackOld.isEmpty()) {
            Node temp = trackOld.peek();
            trackOld.pop();
            currentNode = mark.get(temp.val);
            for (Node i: temp.neighbors) {
                val = i.val;
                if (!mark.containsKey(val)) {
                    Node newNode = new Node(val);
                    trackOld.push(i);
                    currentNode.neighbors.add(newNode);
                    mark.put(val, newNode);
                } else {
                    currentNode.neighbors.add(mark.get(val));
                }
            }
        }
        return result;
    }

    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
