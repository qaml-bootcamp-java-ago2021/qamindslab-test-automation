package com.qamindslab.moduleone.java.exercise.challenge;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class StockSpan {
    public static void main(String[] args) {
        int [] valores = new int[]{100, 60,70,65,80,85};
        int [] newList = new int[valores.length];
        for (int i=1; i<=valores.length-1; i++) {
            int flag =0;
            for (int j = i-1 ; j>=0; j--) {
                if (valores[j] <= valores[i]) {
                    flag = flag + 1;
                }else break;
            }
            newList[i]=flag+1;
        }
        newList[0]=1;
        for (Integer intvalores:newList) {
            System.out.println(intvalores);
        }
    }

    }


