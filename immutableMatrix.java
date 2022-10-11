package org.example;

import java.util.Scanner;

public final class immutableMatrix {
        private final int row;
        private final int col;
        private final float[][] array;
        public immutableMatrix(int n, int m){
            int ans;
            row=n;
            col=m;
            array=new float[row][col];
            Scanner in = new Scanner(System.in);
            System.out.print("Заповнити матрицю");
            ans=in.nextInt();
            if (ans==1){
                setArray();
            }else {
                setArrayRandom();
            }
        }
        public immutableMatrix(){
            row=0;
            col=0;
            array=new float[0][0];
        }
        public immutableMatrix(int[][] arrayCopy){
            array=new float[arrayCopy.length][arrayCopy[0].length];
            for (int i = 0; i < arrayCopy.length; i++)
                for (int j = 0; j < arrayCopy[0].length; j++) {
                    array[i][j]=arrayCopy[i][j];
                }
            row=arrayCopy.length;
            col=arrayCopy[0].length;

        }

        private void setArray(){
            Scanner in = new Scanner(System.in);
            for (float[] arr : array) {
                for (int i = 0; i < arr.length; i++) {
                    System.out.println("Введіть значення");
                    arr[i]=in.nextFloat();
                }

            }
        }
        private void setArrayRandom(){
            for (float[] arr : array) {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = (int) (Math.random() * 9 + 1);
                }

            }
        }
        public float getMatrixElemnt(int elrow, int elcol){
            return array[elrow][elcol];
        }

        public float[] getMatrixrow(int elrow){
            float[] arrayForRow;
            arrayForRow=new float[array[0].length];
            for (int i = 0; i < array[0].length; i++){
                arrayForRow[i]=array[elrow][i];
            }
            return arrayForRow;
        }
        public float[] getMatrixcol(int elcol){
            float[] arrayForcol;
            arrayForcol=new float[array.length];
            for (int i = 0; i < array.length; i++){
                arrayForcol[i]=array[i][elcol];
            }
            return arrayForcol;
        }

        public void getDimention(){
            System.out.print("Розмірність ="+array.length+"на"+array[0].length);
        }
        public float[][] getMatrix(){
            return array;
        }


}
