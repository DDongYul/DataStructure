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
        MyBinNode findNode = search((int) k, root());
        if (isExternal(findNode)){
            return null;
        }
        return findNode;
    }

    private MyBinNode search(int k, MyBinNode v) {
        if (isExternal(v)) {
            return v;
        }
        if (k == (int) v.element()) {
            return v;
        }
        if (k > (int) v.element()) {
            search(k, v.right());
        }
        else if(k< (int) v.element()) {
            search(k,v.left());
        }
        return null;
    }

    public ArrayList findAll(Object k) {
        ArrayList<MyBinNode> result = new ArrayList<>();
        MyBinNode curr = root();
        while (!isExternal(curr)) {
            curr =(MyBinNode) find((int)k);
            if (isExternal(curr)) {
                break;
            }
            result.add(curr);
        }
        return result;
    }

    public Object insert(Object k) {
        MyBinNode searchNode = search((int) k, root());
        if (isExternal(searchNode)){
            searchNode.setElement(k);
            searchNode.setLeft(new MyBinNode());
            searchNode.setRight(new MyBinNode());
            return searchNode;
        }
        else{
            while (!isExternal(searchNode)){
                MyBinNode searchNode2 = search((int) k, searchNode.left());
                if (isExternal(searchNode2)){
                    searchNode.setElement(k);
                    searchNode.setLeft(new MyBinNode());
                    searchNode.setRight(new MyBinNode());
                    return searchNode;
                }
            }
        }
        return null;
    }

    public Object remove(Object k) {

    }
}
