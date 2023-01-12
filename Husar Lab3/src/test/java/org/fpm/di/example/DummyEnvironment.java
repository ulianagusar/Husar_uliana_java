package org.fpm.di.example;

import org.fpm.di.Binder;
import org.fpm.di.Configuration;
import org.fpm.di.Container;
import org.fpm.di.Environment;

public class DummyEnvironment implements Environment {

    @Override
    public Container configure(Configuration configuration) {
        Binder BINER=new DummyBinder();
        configuration.configure(BINER);
        return new DummyContainer(BINER.getClases(),BINER.getClasesASSingleton(), BINER.getClasesextends());
    }
}
