package org.antonio.appmockito.ejemplos.services;

import java.util.List;
import java.util.Optional;

import org.antonio.appmockito.ejemplos.models.Examen;
import org.antonio.appmockito.ejemplos.repositories.ExamenRepository;
import org.antonio.appmockito.ejemplos.repositories.PreguntaRepository;

public class ExamenServiceImpl implements ExamenService {
    private ExamenRepository examenRepository;
    private PreguntaRepository preguntaRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository, PreguntaRepository preguntaRepository) {
        this.examenRepository = examenRepository;
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public Optional<Examen> findExamenPorNombre(String nombre) {
        return examenRepository.findAll().stream()
                .filter(e -> e.getNombre().contains(nombre)).findFirst();

    }

    @Override
    public Examen findExamenPorNombreConPreguntas(String nombre) {
        Optional<Examen> examenOptional = findExamenPorNombre(nombre);
        Examen examen = null;

        if (examenOptional.isPresent()) {
            examen = examenOptional.orElseThrow(null);
            List<String> preguntas = preguntaRepository.findPreguntasPorExamenId(examen.getId());
            examen.setPreguntas(preguntas);
        }

        return examen;
    }

}
