package com.playground.LinkedLists;

public class ResultNode {
    private Node result;

    private int carry;

    public ResultNode(Node result, int carry) {
        this.result = result;
        this.carry = carry;
    }

    public Node getResult() {
        return result;
    }

    public void setResult(Node result) {
        this.result = result;
    }

    public int getCarry() {
        return carry;
    }

    public void setCarry(int carry) {
        this.carry = carry;
    }
}
