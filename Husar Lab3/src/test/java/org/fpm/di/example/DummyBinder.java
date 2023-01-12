package org.fpm.di.example;

import org.fpm.di.Binder;

import java.util.ArrayList;
import java.util.HashMap;

public class DummyBinder implements Binder {
    public ArrayList<Class> Clases;
    public HashMap<Class, HashMap> ClasesASSingleton;

    public ArrayList<ArrayList<Class>> Claseextends;
    public DummyBinder(){
        Clases=new ArrayList<Class>();
        ClasesASSingleton= new HashMap<>();
        Claseextends= new ArrayList<ArrayList<Class>>();
    }
    @Override
    public <T> void bind(Class<T> clazz) {
        this.Clases.add(clazz);
    }

    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {
        ArrayList<Class> lis= new ArrayList<Class>();
        lis.add(clazz);
        lis.add(implementation);
        this.Claseextends.add(lis);
        this.Clases.add(clazz);
        this.Clases.add(implementation);
    }

    @Override
    public <T> void bind(Class<T> clazz, T instance) {
        this.Clases.add(clazz);
        HashMap forbean=new HashMap<>();
        forbean.put("another",instance);
        this.ClasesASSingleton.put(clazz,forbean);

    }
    @Override
    public ArrayList<Class> getClases() {
        return this.Clases;
    }
    @Override
    public HashMap<Class, HashMap> getClasesASSingleton() {
        return this.ClasesASSingleton;
    }
    @Override
    public ArrayList<ArrayList<Class>> getClasesextends() {
        return this.Claseextends;
    }
}
