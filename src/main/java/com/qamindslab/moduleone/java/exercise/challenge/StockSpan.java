package com.qamindslab.moduleone.java.exercise.challenge;

import java.util.Stack;
import java.util.Arrays;

 public class StockSpan {

     public static void main(String[] args) {
         int precio[] = {100, 60, 70, 65, 80, 85};
         int longArreglo = precio.length;
         int arregloSpan [] = new int[longArreglo];

         calcularSpan(precio, longArreglo, arregloSpan);

         imprimirArreglo(arregloSpan);

     }

     static void calcularSpan(int precio[], int longArreglo, int arregloSpan[]) {

         Stack<Integer> pila = new Stack<>();
         pila.push(0);

         arregloSpan[0] = 1;

         for (int i = 1; i < longArreglo; i++) {

             while (!pila.empty() && precio[pila.peek()] <= precio[i])
                 pila.pop();

             arregloSpan[i] = (pila.empty()) ? (i + 1) : (i - pila.peek());

             pila.push(i);
         }
     }
     static void imprimirArreglo(int arr[]) {
         System.out.print(Arrays.toString(arr));
     }
 }