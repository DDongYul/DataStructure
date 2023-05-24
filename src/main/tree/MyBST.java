package main.tree;

import java.util.ArrayList;

public class MyBST extends MyBinTree{
    MyBST() {
        super();
    }
    MyBST(Object e){
        super(e);
    }

    private MyBinNode nextNode(MyBinNode v) {

    }

    public Object find(Object k) {
        MyBinNode result = search((int) k, root());
        return result;
    }

    private MyBinNode search(int k, MyBinNode v) {
        if (isExternal(v)) {
            return null;
        }
        if (k == (int) v.element()) {
            return v;
        }
        if (k > (int) v.element()) {
            search(k, v.right());
        }
        else if(k< (int) v.element()) {
            search(k,v.right());
        }
        return null;
    }

    public ArrayList findAll(Object k) {
        ArrayList<MyBinNode> result = new ArrayList<>();
        MyBinNode curr = root();
        while (curr != null) {
            curr =(MyBinNode) find((int)k);
            if (curr == null) {
                break;
            }
            result.add(curr);
        }
        return result;
    }

    public Object insert(Object k) {  }
    public Object remove(Object k) {  }
}
