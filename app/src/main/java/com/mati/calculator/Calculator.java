package com.mati.calculator;

/**
 * Created by Mati on 23.03.2018.
 */

public class Calculator {

    private double v1=0;
    private double v2=0;
    private double score;
    private boolean minusWard=true;
    private char member='+';


    public double cCalculation(double var, char s){

        if(s=='=')
            calcResult(var,member);
        else {
            switch (member) {
                case '+':
                    calcPlus(var, s);
                    break;
                case '-':
                    calcMinus(var, s);
                    break;
                case 'x':
                    calcMulti(var,s);
                    break;
                case '/':
                    calcDivide(var,s);
                    break;
            }
        }

        return score;
    }

    public void resetWork(){
        v1=0;
        v2=0;
        minusWard=true;
        member='+';
    }

    private void calcPlus(double v, char s){
        v2=v;
        score=v1+v2;
        v1=score;

        member=s;
    }

    private void calcResult(double v,char e){
        v2=v;
        switch(e) {
            case '+':
                score = v1 + v2;
                break;
            case '-':
                score = v1 - v2;
                break;
            case 'x':
                score = v1 * v2;
                break;
            case '/':
                score = v1/v2;
                break;
        }

        v1=0;
        member='+';
        minusWard=true;
    }
    private void calcMinus(double v, char s){
        v2=v;
        score=v1-v2;;
        v1=score;

        member=s;
    }
    private void calcMulti(double v, char s){
        v2=v;
        score = v1 * v2;
        v1=score;

        member=s;
    }

    private void calcDivide(double v, char s){
        v2=v;
        score=v1/v2;
        v1=score;

        member=s;
    }

}
