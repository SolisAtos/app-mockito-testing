package org.antonio.appmockito.ejemplos.services;

import java.util.Optional;

import org.antonio.appmockito.ejemplos.models.Examen;
import org.antonio.appmockito.ejemplos.repositories.ExamenRepository;

public class ExamenServiceImpl implements ExamenService {
    private ExamenRepository examenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    @Override
    public Optional<Examen> findExamenPorNombre(String nombre) {
        return examenRepository.findAll().stream()
                .filter(e -> e.getNombre().contains(nombre)).findFirst();

    }

}
