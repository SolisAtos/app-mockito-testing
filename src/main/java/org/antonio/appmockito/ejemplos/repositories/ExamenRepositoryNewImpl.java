package org.antonio.appmockito.ejemplos.repositories;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.antonio.appmockito.ejemplos.Datos;
import org.antonio.appmockito.ejemplos.models.Examen;

public class ExamenRepositoryNewImpl implements ExamenRepository {

    @Override
    public List<Examen> findAll() {
        System.out.println("ExamenRepositoryNewImpl.findAll()");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Datos.EXAMENES;
    }

    @Override
    public Examen guardar(Examen examen) {
        System.out.println("ExamenRepositoryNewImpl.guardar()");
        return null;
    }

}
