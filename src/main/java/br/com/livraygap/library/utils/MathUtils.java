package br.com.livraygap.library.utils;

public class MathUtils {
    private int valueInt;
    private double valueDouble;

    public MathUtils(int value){
        this.valueInt = value;
    }
    public MathUtils(double value){
        this.valueDouble = value;
    }

    public int subtract(int valueForSubtract){
        return this.valueInt - valueForSubtract;
    }
    public double subtract(double valueForSubtract){
        return this.valueDouble - valueForSubtract;
    }
    public int add(int valueForAdd){
        return this.valueInt + valueForAdd;
    }
    public double add(double valueForAdd){
        return this.valueInt + valueForAdd;
    }

}