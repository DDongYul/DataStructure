package main;

import main.list.MyArrayList;
import main.list.MyQueue;
import main.list.MyStack;
import main.pq.IntComparator;
import main.pq.MyEntry;
import main.pq.MyPQ;
import main.queue.StackQueue;
import main.stack.ArrayStack;
import main.tree.MyBinNode;
import main.tree.MyBinTree;
import main.tree.MyNode;
import main.tree.MyTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Stack_Queue_practice2();    //3주차 실습 2 실행
//        Stack_Queue_practice3();    //3주차 실습 3 실행
//        List_and_Iterators_Practice2_1(); //4주차 실습 2-1
//        System.out.println("-------------------");
//        List_and_Iterators_Practice2_2(); //4주차 실습 2-2
//        Trees_3();
//        System.out.println();
//        System.out.println("-------------------");
//        Trees_4_1();
//        System.out.println("-------------------");
//        Trees_4_2();
//        Trees2_1(); //6주차 실습
        PQ1_2();
    }

    //8주차 실습 1-2
    private static void PQ1_2() {
        IntComparator c = new IntComparator();
        MyPQ pq = new MyPQ(c);
        pq.insert(30, null);
        pq.insert(10, null);
        pq.insert(20, null);
        System.out.println((Integer) pq.removeMin().getKey());
        System.out.println((Integer) pq.removeMin().getKey());
        System.out.println((Integer) pq.removeMin().getKey());
    }

    //6주차 실습
    private static void Trees2_1() {
        //3-1번
        MyBinTree binTree = new MyBinTree();

        MyBinNode binNode1 = binTree.addRoot("+");
        MyBinNode binNode2 =binTree.addNode("*");
        MyBinNode binNode3 =binTree.addNode("*");
        MyBinNode binNode4 =binTree.addNode(2);
        MyBinNode binNode5 =binTree.addNode("-");
        MyBinNode binNode6 =binTree.addNode(3);
        MyBinNode binNode7 =binTree.addNode(2);
        MyBinNode binNode10 =binTree.addNode(3);
        MyBinNode binNode11 =binTree.addNode(1);

        binNode1.setLeft(binNode2);
        binNode1.setRight(binNode3);
        binNode2.setLeft(binNode4);
        binNode2.setRight(binNode5);
        binNode3.setLeft(binNode6);
        binNode3.setRight(binNode7);
        binNode5.setLeft(binNode10);
        binNode5.setRight(binNode11);

        //3-2번
        inOrder(binTree,binNode1);
        //3-3번
        System.out.println();
        System.out.print("= ");
        System.out.print(postOrder(binTree,binNode1));
    }

    private static void inOrder(MyBinTree tree, MyBinNode node){
        if(!tree.isExternal(node)){
            System.out.print("(");
            if (tree.hasLeft(node)) {
                inOrder(tree, node.left());
                System.out.print(node.element());
                if (tree.hasRight(node)) {
                    inOrder(tree,node.right());
                }
            }
            else{
                System.out.print(node.element());
                inOrder(tree,node.right());
            }
            System.out.print(")");
        }
        else{
            if (node == tree.parent(node).left()) {
                System.out.print(node.element());
            }
            else{
                System.out.print(node.element());
            }
        }
    }

    private static int postOrder(MyBinTree tree, MyBinNode node) {
        if(!tree.isExternal(node)){
            if (tree.hasLeft(node) && tree.hasRight(node)) {
                int left = postOrder(tree, node.left());
                int right = postOrder(tree,node.right());

                if (node.element() == "+"){
                    return left + right;
                }
                else if(node.element() == "-"){
                    return left - right;
                }
                else if(node.element() == "*"){
                    return left * right;
                }
                else{
                    return left / right;
                }
            }
        }
        else{
            return (int)(node.element());
        }
        return 0;
    }

    //5주차 실습 3번 코드
    private static void Trees_3(){
        MyTree tree = new MyTree();

        //root와 함께 트리 생성
        MyNode root = tree.addRoot("Computers’R Us");
        System.out.println("[Level 0]");
        System.out.println(root.element());
        System.out.println();

        //depth 1
        MyNode node2 = tree.addChild(root, "sales");
        MyNode node3 = tree.addChild(root, "Manufacturing");
        MyNode node4 = tree.addChild(root, "R&D");

        System.out.println("[Level 1]");
        System.out.printf("%s,%s,%s",node2.element(),node3.element(),node4.element());
        System.out.println();
        System.out.println();

        //depth 2
        MyNode node5 = tree.addChild(node2,"US");
        MyNode node6 = tree.addChild(node2,"International");
        MyNode node7 = tree.addChild(node3,"Laptops");
        MyNode node8 = tree.addChild(node3,"Desktops");

        System.out.println("[Level 2]");
        System.out.printf("%s,%s,%s,%s",node5.element(),node6.element(),node7.element(),node8.element());
        System.out.println();
        System.out.println();

        //depth 3
        MyNode node9 = tree.addChild(node6,"Europe");
        MyNode node10 = tree.addChild(node6,"Asia");
        MyNode node11 = tree.addChild(node6,"Canada");

        System.out.println("[Level 3]");
        System.out.printf("%s,%s,%s",node9.element(),node10.element(),node11.element());
        System.out.println();
        System.out.println();

        System.out.printf("* Tree size = Total %d Nodes",tree.size());
    }

    //5주차 실습 4번코드
    private static void Trees_4_1(){
        MyTree tree = new MyTree();

        MyNode root = tree.addRoot("Make Money Fast!");

        //depth 1
        MyNode node2 = tree.addChild(root, "1. Motivation");
        MyNode node3 = tree.addChild(root, "2. Methods");
        MyNode node4 = tree.addChild(root, "3. References");

        //depth2
        tree.addChild(node2, "1.1 Greed");
        tree.addChild(node2,"1.2 Greed");
        tree.addChild(node3, "2.1 Stock Fraud");
        tree.addChild(node3, "2.2 Ponzi Scheme");
        tree.addChild(node3, "2.3 Bank Robbery");

        preOrder(tree,root,0);
    }

    private static void preOrder(MyTree tree, MyNode node, int depth) {
        for (int i =0; i<depth; i++) {
            System.out.printf(" ");     //depth 만큼 들여쓰기
        }
        System.out.println(node.element());
        if(!tree.isExternal(node)){
            for (int i =0; i<node.children().size(); i++){
                preOrder(tree, (MyNode) node.children().get(i),depth+1);
            }
        }
    }

    //4주차 실습
    private static void Trees_4_2(){

        MyTree tree = new MyTree();

        MyNode root = tree.addRoot("cs16/");

        //depth 1
        MyNode node2 = tree.addChild(root, "homeworks/");
        MyNode node3 = tree.addChild(root, "programs/");
        MyNode node4 = tree.addChild(root, "todo.txt(1K)");

        //depth2
        tree.addChild(node2, "h1c.doc(3K)");
        tree.addChild(node2,"h1nc.doc(2K)");
        tree.addChild(node3, "DDR.java(10K)");
        tree.addChild(node3, "Stocks.java(25K)");
        tree.addChild(node3, "Robot.java(20K)");

        postOrder(tree,root);
    }

    private static int postOrder(MyTree tree, MyNode node) {
        if(node.element().toString().endsWith("/")){
            int size = 0;
            for(int i = 0; i<node.children().size(); i++){
                size+= postOrder(tree,(MyNode) node.children().get(i));
            }
            System.out.println(node.element().toString() +" = "+size + "KB");
            return size;
        }
        else{
            return Integer.valueOf(node.element().toString().split("\\(")[1].split("K")[0]);
        }
    }

    private static void List_and_Iterators_Practice2_1(){
        MyStack stack = new MyStack();
        for (int i =1; i<11; i ++){
            stack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }
    }

    private static void List_and_Iterators_Practice2_2(){
        MyQueue queue = new MyQueue();
        for (int i =1; i<11; i ++){
            queue.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.dequeue());
        }
    }
//    //3주차 실습 2 실행코드
//    private static void Stack_Queue_practice2() {
//        ArrayStack arrayStack = new ArrayStack();
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//
//        for (int i = 0; i < input.length(); i++) {
//            arrayStack.push(input.charAt(i));
//        }
//
//        arrayStack.revPrint();
//    }
//
//    //3주차 실습 3 실행코드
//    private static void Stack_Queue_practice3() {
//        StackQueue stackQueue = new StackQueue();
//        //1
//        stackQueue.enqueue('a');
//        stackQueue.enqueue('b');
//        stackQueue.enqueue('c');
//        stackQueue.enqueue('d');
//        stackQueue.enqueue('e');
//        //2
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        //3
//        stackQueue.enqueue('f');
//        stackQueue.enqueue('g');
//        stackQueue.enqueue('h');
//        stackQueue.enqueue('i');
//        stackQueue.enqueue('j');
//        //4
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        //5
//        stackQueue.enqueue('k');
//        stackQueue.enqueue('l');
//        stackQueue.enqueue('m');
//        stackQueue.enqueue('n');
//        stackQueue.enqueue('o');
//        //6
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        stackQueue.dequeue();
//        //7
//        while (!stackQueue.isEmpty()){
//            System.out.println(stackQueue.dequeue());
//        }
//
//    }

}
