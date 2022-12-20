package org.example.service;

import org.example.repositories.repor;


public class Service {
    public String history;
    public String res;
    private repor Repor;
    public Service(int znach1, int znach2) {
        this.history="";
        this.res=getres(znach1,znach2);
        this.Repor=new repor(this.history,this.res);

    }
    private String getres(int znach1,int znach2){
        if(znach1==0){
            this.history=this.history+"0";
            return Integer.toString(znach2);
        }else {
            while (znach2!=0){
                if(znach1>znach2){
                    this.history=this.history+Integer.toString(znach1)+"-"+Integer.toString(znach2)+"\n";
                    znach1 =znach1-znach2;
                }else {
                    znach2 =znach2-znach1;
                    this.history=this.history+Integer.toString(znach2)+"-"+Integer.toString(znach1)+"\n";
                }
            }
            this.history=this.history+"0";
            return Integer.toString(znach1);
        }

    }

}
