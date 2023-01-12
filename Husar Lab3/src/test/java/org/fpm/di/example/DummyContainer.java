package org.fpm.di.example;

import org.fpm.di.Container;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

public class DummyContainer implements Container {
    public ArrayList<Class> Clases;
    public HashMap<Class,HashMap> ClasesASSingleton;

    public HashMap<Integer,ArrayList<Class>> Claseextention;
    public HashMap<Integer,HashMap> ForClaseextention;
    public DummyContainer(ArrayList<Class> clases, HashMap<Class,HashMap> ClasesASSingleton , ArrayList<ArrayList<Class>> Claseextention) {
        this.Clases=clases;
        this.Claseextention=new HashMap<Integer,ArrayList<Class>>();
        this.ForClaseextention=new HashMap<Integer,HashMap>();

        int indexForClaseextention=0;
        for (Class ClassfromAll : this.Clases){
            if (ClassfromAll.isAnnotationPresent(Singleton.class)||(ClasesASSingleton.containsKey(ClassfromAll))){
                for (ArrayList<Class> Classfromextention : Claseextention){
                    if ((Classfromextention.get(0)==ClassfromAll)||(Classfromextention.get(1)==ClassfromAll)){
                        indexForClaseextention=indexForClaseextention+1;
                        this.Claseextention.put(indexForClaseextention,Classfromextention);
                        this.ForClaseextention.put(indexForClaseextention,null);

                    }else {
                        HashMap forbean=new HashMap<>();
                        forbean.put("true",null);
                        ClasesASSingleton.put(ClassfromAll,forbean);
                    }
                }

            }
        }
        this.ClasesASSingleton=ClasesASSingleton;

    }

    @Override
    public <T> T getComponent(Class<T> clazz) {
        T bean;
        Class component = clazz;
        try {
           for(Constructor constructor : clazz.getConstructors()){
                if (constructor.isAnnotationPresent(Inject.class)){
                     Object[] listofobject = new Object [constructor.getParameterCount()];
                     int indexForlistofobject=0;
                    for (Class  parametr : constructor.getParameterTypes()) {
                        listofobject[indexForlistofobject]=this.getComponent(parametr);
                        indexForlistofobject=indexForlistofobject+1;

                    }
                    bean = (T) clazz.getConstructor(constructor.getParameterTypes()).newInstance(listofobject);
                }
           }
            if (!Claseextention.isEmpty()){
                for (int indexForClaseextention=0;indexForClaseextention<=Claseextention.size();indexForClaseextention++){
                    if(Claseextention.get(indexForClaseextention)!=null){
                    if ((Claseextention.get(indexForClaseextention).get(0)==clazz)||(Claseextention.get(indexForClaseextention).get(1)==clazz)) {
                        if (ForClaseextention.get(indexForClaseextention)==null){
                            bean= (T) component.getDeclaredConstructor().newInstance();
                            HashMap forbean=new HashMap<>();
                            forbean.put(indexForClaseextention,bean);
                            this.ForClaseextention.remove(indexForClaseextention);
                            this.ForClaseextention.put(indexForClaseextention, forbean);
                            return bean;
                        }else {
                            bean= (T) ForClaseextention.get(indexForClaseextention).get(indexForClaseextention);
                            return bean;
                        }

                    }
                }}

            }
            if (this.ClasesASSingleton.containsKey(clazz) ){
                if(this.ClasesASSingleton.get(clazz).containsKey("true")) {
                    bean= (T) component.getDeclaredConstructor().newInstance();
                    HashMap forbean=new HashMap<>();
                    forbean.put("false",bean);
                    this.ClasesASSingleton.remove(clazz);
                    this.ClasesASSingleton.put(clazz,forbean);
                }else if(this.ClasesASSingleton.get(clazz).containsKey("false")) {

                    bean= (T) ClasesASSingleton.get(clazz).get("false");
                }else {
                    bean= (T) ClasesASSingleton.get(clazz).get("another");
                }


            }else {
                bean= (T) component.getDeclaredConstructor().newInstance();
            }



            return bean;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }

}
