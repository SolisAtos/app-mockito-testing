package org.antonio.appmockito.ejemplos.repositories;

import java.util.List;

import org.antonio.appmockito.ejemplos.models.Examen;

public interface ExamenRepository {
    List<Examen> findAll();
}
