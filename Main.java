package LabSession3Adatastructure;

import java.util.ArrayList;


 class Node {
     Node left;
     Node right;
     int data;


     static Node newNode(int data) {
         Node temp = new Node();
         temp.data = data;
         temp.left = null;
         temp.right = null;
         return temp;
     }

     public static ArrayList<Integer> longestPath(Node root) {
         if (root == null) {
             ArrayList<Integer> output = new ArrayList<>();
             return output;

         }
         ArrayList<Integer> right = longestPath(root.right);
         ArrayList<Integer> left = longestPath(root.left);

         if (right.size() < left.size()) {
             left.add(root.data);

         } else {
             right.add(root.data);
         }
         return (left.size() > right.size() ? left : right);

     }
         public static void main(String[] args, int n) {

             Node root = newNode(100);
             Node node1 = newNode(20);
             Node node2 = newNode(130);
             Node node3 = newNode(10);
             Node node4 = newNode(50);
             Node node5 = newNode(110);
             Node node6 = newNode(140);
             Node node7 = newNode(5);

             node3.left = node7;

             node1.left = node3;
             node1.right = node4;

             node2.left = node5;
             node2.right = node6;

             ArrayList<Integer> output = longestPath(root);
             System.out.print(output.get(n - 1));
             for (int i = n - 2; i >= 0; i--) {
                 System.out.print("->" + output.get(i));
             }
         }

     }

