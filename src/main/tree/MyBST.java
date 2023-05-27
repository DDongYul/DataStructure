package main.tree;

import java.util.ArrayList;

public class MyBST extends MyBinTree{
    ArrayList<MyBinNode> inOrderResult = new ArrayList<MyBinNode>();

    public MyBST() {
        super();
    }

    public MyBST(Object e){
        super(e);
    }

    private MyBinNode nextNode(MyBinNode v) {
        inOrder(root());
        int idx = 0;
        for (MyBinNode node : inOrderResult) {
            if(node == v){
                break;
            }
            else {
                idx+=1;
            }
        }
        if (idx<= inOrderResult.size()-2){
            return inOrderResult.get(idx+1);
        }
        return null;
    }

    private void inOrder(MyBinNode node){
        if(isExternal(node.left()) && isExternal(node.right())){
            inOrderResult.add(node);
        }
        else if(isExternal(node.left())){
            inOrderResult.add(node);
            inOrder(node.right());
        }
        else if(isExternal(node.right())){
            inOrder(node.left());
        }
        else{
            inOrder(node.left());
        }
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
            insertLeft((MyBinNode) searchNode.parent(), k);
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
        MyBinNode searchNode = (MyBinNode) find((int) k);
        if(searchNode == null){
            return null;
        }
        else{
            if (isExternal(searchNode.left()) && isExternal(searchNode.right())){
                MyBinNode parent = (MyBinNode) searchNode.parent();
                if (searchNode == parent.left()) {
                    parent.setLeft(new MyBinNode());
                }
                else{
                    parent.setRight(new MyBinNode());
                }
                return searchNode;
            }
            else if(isExternal(searchNode.left())){
                MyBinNode parent = (MyBinNode) searchNode.parent();
                MyBinNode nextNode = nextNode(searchNode);
                nextNode.setParent(parent);
                parent.setLeft(nextNode);
            }
            else if(isExternal(searchNode.right())){
                MyBinNode parent = (MyBinNode) searchNode.parent();
                MyBinNode nextNode = nextNode(searchNode);
                nextNode.setParent(parent);
                parent.setRight(nextNode);
            }
            else{
                MyBinNode parent = (MyBinNode) searchNode.parent();
                MyBinNode nextNode = nextNode(searchNode);
                nextNode.setParent(parent);
            }
            return searchNode;
        }
    }
}
