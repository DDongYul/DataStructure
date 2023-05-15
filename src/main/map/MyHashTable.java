package main.map;

import java.util.ArrayList;

public class MyHashTable {
    private ArrayList bucketArray;
    private int bucketCapacity;

    public MyHashTable(int initialCapacity){
        bucketCapacity = initialCapacity;
        bucketArray = new ArrayList(initialCapacity);
        for(int i = 0; i<initialCapacity; i++){
            bucketArray.add(i,new ArrayList<>());
        }
    }

    private int hashFunc(String k) {
        int base = 33;
        int hashValue = 0;
        int p = 1;
        for (int i=k.length()-1; i>=0; i--){
            hashValue = (hashValue + (k.charAt(i)*p)) % bucketCapacity;
            p = (p*base) % bucketCapacity;
        }
        return hashValue;
    }

    public int size() {
        return bucketArray.size();
    }

    public String get(String k) {
        int idx = hashFunc(k);
        ArrayList lst = (ArrayList) bucketArray.get(idx);
        for (int i =0; i<lst.size(); i++){
            StudentInfo curr = (StudentInfo) lst.get(i);
            if (curr.getStudentID() == k) {
                String v = curr.getStudentName();
                return v;
            }
        }
        return null;
    }

    public String put(String k, String v){
        StudentInfo student = new StudentInfo(k,v);
        int idx = hashFunc(k);
        ArrayList lst = (ArrayList) bucketArray.get(idx);
        lst.add(student);
        return k;
    }

    public String remove(String k){
        int idx = hashFunc(k);
        ArrayList lst = (ArrayList) bucketArray.get(idx);
        for (int i =0; i<lst.size(); i++){
            StudentInfo curr = (StudentInfo) lst.get(i);
            if (curr.getStudentID() == k) {
                String v = curr.getStudentName();
                lst.remove(i);
                return v;
            }
        }
        return null;
    }

    public void printHashTable() {
        for (int i = 0; i<bucketArray.size(); i++){
            ArrayList arr = (ArrayList) bucketArray.get(i);
            System.out.print("index" + i + ": ");
            for (Object o1 : arr) {
                StudentInfo s = (StudentInfo)o1;
                System.out.print("("+s.getStudentID()+","+s.getStudentName()+")" + " ");
            }
            System.out.println();
        }
    }

}
