package PTIT_Practice;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class P202PROA {
    private static final Scanner reader = new Scanner(System.in);
    private static int n, numDoc;
    private static boolean[] isCheck;
    private static arrayList[] bossOfStaff;
    private static arrayList[] documentOfStaff;
    public static void main(String[] args) {
        n = reader.nextInt();
        int m = reader.nextInt();
        isCheck = new boolean[n+1];
        bossOfStaff = new arrayList[n+1];
        documentOfStaff = new arrayList[n+1];
        for (int i = 1; i <= n; i++) {
            bossOfStaff[i] = new arrayList();
            documentOfStaff[i] = new arrayList();
        }
        numDoc = 0;
        int staff, boss, doc;
        initCheckVariable();
        for (int i = 1; i <= m; i++) {
            int input = reader.nextInt();
            if (input == 1) {
                staff = reader.nextInt();
                boss = reader.nextInt();
                bossOfStaff[staff].add(boss);
            } else if (input == 2) {
                int numStaff = reader.nextInt();
                ++numDoc;
                updateDoc(numStaff);
            } else if (input == 3) {
                staff = reader.nextInt();
                doc = reader.nextInt();
                if (documentOfStaff[staff].contain(doc)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static void updateDoc(int numStaff) {
        initCheckVariable();
        documentOfStaff[numStaff].add(numDoc);
        Stack<Integer> stack = new Stack<>();
        stack.push(numStaff);
        isCheck[numStaff] = true;
        while (!stack.isEmpty()) {
            int u = stack.peek();
            stack.pop();
            for (Integer i : bossOfStaff[u].list) {
                if (!isCheck[i]) {
                    isCheck[i] = true;
                    documentOfStaff[i].add(numDoc);
                    stack.push(i);
                }
            }
        }
    }

    private static void initCheckVariable() {
        for (int i = 1; i <= n; i++)
            isCheck[i] = false;
    }
}

class arrayList {
    ArrayList<Integer> list;

    public arrayList() {
        list = new ArrayList<>();
    }

    public void add(int boss) {
        list.add(boss);
    }
    public boolean contain(int doc) {
        return list.contains(doc);
    }
}