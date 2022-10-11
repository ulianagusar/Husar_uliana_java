package org.example;
import java.util.Scanner;

public class Matrix {
    private int row;
    private int col;
    private float[][] array;
    public Matrix(int n, int m){
        row=n;
        col=m;
        array=new float[row][col];
    }
    public Matrix(){
        row=0;
        col=0;
        array=new float[0][0];
    }
    public Matrix(float[][] arrayCopy){
        array=new float[arrayCopy.length][arrayCopy[0].length];
        for (int i = 0; i < arrayCopy.length; i++)
            for (int j = 0; j < arrayCopy[0].length; j++) {
               array[i][j]=arrayCopy[i][j];
            }
        row=arrayCopy.length;
        col=arrayCopy[0].length;

    }

    public void setArray(){
        Scanner in = new Scanner(System.in);
        for (float[] arr : array) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println("Введіть значення");
                arr[i]=in.nextInt();
            }

        }
    }
    public void setArrayRandom(){
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
    public static int[][] OneMatrix(int RowColForOneMatrix){
        int[][] arrayForOneMatrix;
        arrayForOneMatrix=new int[RowColForOneMatrix][RowColForOneMatrix];
         for (int i = 0; i < RowColForOneMatrix; i++)
            for (int j = 0; j < RowColForOneMatrix; j++) {
                if(i==j){
                    arrayForOneMatrix[i][j]=1;
                }
                else {
                    arrayForOneMatrix[i][j]=0;
                }
            //  if (j == ar[0].length - 1) System.out.println();
         }
         return arrayForOneMatrix;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Matrix)) {
            return false;
        } else {
            Matrix matrix = (Matrix)obj;
            if (this.row == matrix.row && this.col == matrix.col) {
                for(int i = 0; i < this.row; i++) {
                    for(int j = 0; j < this.col; j++) {
                        if (this.array[i][j]!=matrix.array[i][j]) {
                            return false;
                        }
                    }
                }

                return true;
            } else {
                return false;
            }

        }
    }

    @Override
    public int hashCode() {
        int result;
        result=row+col;
        result=result+(31 *array.hashCode());
        return result;
    }
    public float[][] InverseMatrix(){
        if (row==col) {
            double temp;

            float[][] E = new float[row][row];


            for (int i = 0; i < row; i++)
                for (int j = 0; j < row; j++) {
                    E[i][j] = 0f;

                    if (i == j)
                        E[i][j] = 1f;
                }

            for (int k = 0; k < row; k++) {
                temp = array[k][k];

                for (int j = 0; j < row; j++) {
                    array[k][j] /= temp;
                    E[k][j] /= temp;
                }

                for (int i = k + 1; i < row; i++) {
                    temp = array[i][k];

                    for (int j = 0; j < row; j++) {
                        array[i][j] -= array[k][j] * temp;
                        E[i][j] -= E[k][j] * temp;
                    }
                }
            }

            for (int k = row - 1; k > 0; k--) {
                for (int i = k - 1; i >= 0; i--) {
                    temp = array[i][k];

                    for (int j = 0; j < row; j++) {
                        array[i][j] -= array[k][j] * temp;
                        E[i][j] -= E[k][j] * temp;
                    }
                }
            }


            for (int i = 0; i < row; i++)
                for (int j = 0; j < row; j++)
                    array[i][j] = E[i][j];


            for (int i = 0; i < array.length; i++)
                for (int j = 0; j < array[0].length; j++) {
                    System.out.print(E[i][j] + "\t");
                    if (j == array[0].length - 1) System.out.println();
                }
            return array;
        }else{
            System.out.print("до цієї матриці неможна знайти обернену");
            return array;
        }

    }






}


