package main;

import main.list.MyArrayList;
import main.list.MyQueue;
import main.list.MyStack;
import main.queue.StackQueue;
import main.stack.ArrayStack;
import main.tree.MyNode;
import main.tree.MyTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Stack_Queue_practice2();    //3주차 실습 2 실행
//        Stack_Queue_practice3();    //3주차 실습 3 실행
//        List_and_Iterators_Practice2_1(); //4주차 실습 2-1
//        System.out.println("-------------------");
//        List_and_Iterators_Practice2_2(); //4주차 실습 2-2
        Trees_3();
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
