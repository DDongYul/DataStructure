package main.tree;

import java.util.ArrayList;

public class MyBinNode extends MyNode {

    public MyBinNode() {
        super();
    }

    public MyBinNode(Object e) {
        super(e);
    }

    @Override
    public Object element() {
        return super.element();
    }

    @Override
    public MyNode parent() {
        return super.parent();
    }

    @Override
    public ArrayList children() {
        return super.children();
    }

    @Override
    public int degree() {
        return super.degree();
    }

    @Override
    public void setElement(Object e) {
        super.setElement(e);
    }

    @Override
    public void setParent(MyNode p) {
        super.setParent(p);
    }

    @Override
    public void setChildren(ArrayList c) {
        super.setChildren(c);
    }

    public MyBinNode left() {
        return (MyBinNode) children().get(0);
    }

    public MyBinNode right() {
        return (MyBinNode) children().get(1);
    }

    public void setLeft(MyBinNode v) {
        v.children().add(0,v);
    }

    public void setRight(MyBinNode v) {
        v.children().add(1,v);
    }
}
