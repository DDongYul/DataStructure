package main;

import main.queue.StackQueue;
import main.stack.ArrayStack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stack_Queue_practice2();    //실습 2 실행
        Stack_Queue_practice3();    //실습 3 실행
    }

    //실습 2 실행코드
    private static void Stack_Queue_practice2() {
        ArrayStack arrayStack = new ArrayStack();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            arrayStack.push(input.charAt(i));
        }

        arrayStack.revPrint();
    }

    //실습 3 실행코드
    private static void Stack_Queue_practice3() {
        StackQueue stackQueue = new StackQueue();
        //1
        stackQueue.enqueue('a');
        stackQueue.enqueue('b');
        stackQueue.enqueue('c');
        stackQueue.enqueue('d');
        stackQueue.enqueue('e');
        //2
        stackQueue.dequeue();
        stackQueue.dequeue();
        stackQueue.dequeue();
        //3
        stackQueue.enqueue('f');
        stackQueue.enqueue('g');
        stackQueue.enqueue('h');
        stackQueue.enqueue('i');
        stackQueue.enqueue('j');
        //4
        stackQueue.dequeue();
        stackQueue.dequeue();
        stackQueue.dequeue();
        //5
        stackQueue.enqueue('k');
        stackQueue.enqueue('l');
        stackQueue.enqueue('m');
        stackQueue.enqueue('n');
        stackQueue.enqueue('o');
        //6
        stackQueue.dequeue();
        stackQueue.dequeue();
        stackQueue.dequeue();
        stackQueue.dequeue();
        stackQueue.dequeue();
        stackQueue.dequeue();
        //7
        while (!stackQueue.isEmpty()){
            System.out.println(stackQueue.dequeue());
        }
        
    }

}
