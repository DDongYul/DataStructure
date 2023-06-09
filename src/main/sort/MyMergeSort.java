package main.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.lang.Math.*;

public class MyMergeSort {
    private ArrayList L1;
    private ArrayList L2;
    private Comparator comp;

    // Constructor
    public MyMergeSort(Comparator c) {
        L1 = new ArrayList();
        L2 = new ArrayList();
        comp = c;
    }

    // Implement the following methods
    public void sort(ArrayList l) {

        L1 = (ArrayList) l.clone();
        int d = 0;
        int cnt = 1;
        boolean flag = true; //true면 L1 -> L2 false면 L2-> L1

        while(cnt<l.size()){
            for(int i = 0; i<l.size(); i+=cnt*2){
                int start;
                int end;

                if(i+cnt*2-1>=l.size()){
                    start = cnt*2;
                    end = l.size()-1;
                }
                else{
                    start = i;
                    end = i+cnt*2-1;
                }

                if (flag){
                    merge(L1,L2,start,end);
                }
                else{
                    merge(L2,L1,start,end);
                }
            }
            if(flag) {
                flag = false;
                L1.clear();
            }
            else {
                flag = true;
                L2.clear();
            }
            d++;
            cnt = (int) Math.pow(2,d);
        }


    }

    public void merge(ArrayList inputArr, ArrayList outputArr, int start, int end){
        System.out.println("start = " + start);
        System.out.println("end = " + end);

        int left = start;
        int mid = (end-start+1)/2 + start;
        int right = mid;
        while (left<mid && right<=end){
            int rst = comp.compare(inputArr.get(left),inputArr.get(right));

            if(rst>0){
                outputArr.add(inputArr.get(left));
                left++;
            }
            else{
                outputArr.add(inputArr.get(right));
                right++;
            }
        }

        while(left<mid){
            outputArr.add(inputArr.get(left));
            left++;
        }

        while(right<=end){
            outputArr.add(inputArr.get(right));
            right++;
        }
        print(L1);
        print(L2);
    }

    public Comparator setComparator(Comparator c) {
        comp = c;
        return comp;
    }

    public void print(ArrayList l) {
        for(int i=0; i<l.size(); i++) {
            System.out.print(l.get(i) + " ");
        }
        System.out.println();
    }
}
