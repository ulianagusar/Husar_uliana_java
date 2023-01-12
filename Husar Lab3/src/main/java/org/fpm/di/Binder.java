package org.fpm.di;

import java.util.ArrayList;
import java.util.HashMap;

public interface Binder {
    <T> void bind(Class<T> clazz);

    <T> void bind(Class<T> clazz, Class<? extends T> implementation);

    <T> void bind(Class<T> clazz, T instance);


    ArrayList<Class> getClases();
    HashMap<Class, HashMap> getClasesASSingleton();
    ArrayList<ArrayList<Class>> getClasesextends();
}
