package org.example.Controller;

import org.example.service.Service;

import java.util.Scanner;


    public class NSD {
        public int znach1;
        public int znach2;
        private Service service;
        private int ans;
        public NSD(int znach1, int znach2) {
            this.znach1=znach1;
            this.znach2=znach2;
            this.service=new Service(znach1,znach2);
            System.out.print("Oтримати лише результат - введіть 1,отримати результат і історію введіть-2\n");
            Scanner in = new Scanner(System.in);
            this.ans=in.nextInt();
            if(this.ans==1){
                System.out.print(this.service.res);
            }else {
                System.out.print("Кроки\n"+this.service.history+"\nРезультат\n"+this.service.res);
            }

        }

        public NSD(NSD prevelius) {
            System.out.print("\nOтримати лише результат - введіть 1,отримати результат і історію введіть будь-що інше\n");
            Scanner in = new Scanner(System.in);
            this.service=prevelius.service;
            this.ans=in.nextInt();
            if(this.ans==1){
                System.out.print(this.service.res);
            }else {
                System.out.print("Кроки\n"+this.service.history+"\nРезультат\n"+this.service.res);
            }

        }

    }

