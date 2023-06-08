package main.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.lang.Math.*;

public class MyMergeSort {
    private ArrayList L1;
    private ArrayList L2;
    private Comparator comp;

    // Constructor
    MyMergeSort(Comparator c) {

    }

    // Implement the following methods
    public void sort(ArrayList l) {
        int d = 0;
        int size = l.size();
        boolean flag = true;
        while(d < size ){
            if (!flag) flag = true;
            else flag = false;

            int cnt = (int) Math.pow(2,d);
            int idx = 0;
            for(int i = 0; i<size; i+=cnt){
                int left = i;
                int right = i+cnt;
                if(flag){
                    while(left<i+cnt && right<i+cnt+cnt){

                        int rst = comp.compare(L1.get(left),L1.get(right));
                        if(rst>0){
                            L2.set(idx,L1.get(right));
                            right+=1;
                        }
                        else{

                        }
                    }
                }
                else{

                }
            }
            d+=1
        }
        //비교 대상: 1 -> 01 23 45 67 2-> 0123 4567

    }

    public Comparator setComparator(Comparator c) {

    }
}
