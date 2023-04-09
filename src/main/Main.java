package main;

import main.list.MyArrayList;
import main.list.MyQueue;
import main.list.MyStack;
import main.queue.StackQueue;
import main.stack.ArrayStack;
import main.tree.MyNode;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Stack_Queue_practice2();    //3주차 실습 2 실행
//        Stack_Queue_practice3();    //3주차 실습 3 실행
//        List_and_Iterators_Practice2_1(); //4주차 실습 2-1
//        System.out.println("-------------------");
//        List_and_Iterators_Practice2_2(); //4주차 실습 2-2
        Trees_1();
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

    private static void Trees_1(){
        MyNode myNode = new MyNode();
        MyNode myNode1 = new MyNode();

        ArrayList<MyNode> arrayList = new ArrayList<>();
        arrayList.add(myNode1);
        myNode.setChildren(arrayList);
        System.out.println(myNode.children().get(0));
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
