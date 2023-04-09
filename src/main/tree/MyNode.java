package main.tree;

import java.util.ArrayList;

public class MyNode {
    private Object element;
    private MyNode parent;
    private ArrayList children;

    public MyNode(){
        element = null;
        parent = null;
        children = null;
    }

    public MyNode(Object element) {
        this.element = element;
    }

    public Object element() {
        return element;
    }

    public MyNode parent() {
        return parent;
    }

    public ArrayList children() {
        return children;
    }

    public int degree() {
        return children.size();
    }

    public void setElement(Object e) {
        element = e;
    }

    public void setParent(MyNode p) {
        parent = p;
    }

    public void setChildren(ArrayList c) {
        children = c;
    }

}
