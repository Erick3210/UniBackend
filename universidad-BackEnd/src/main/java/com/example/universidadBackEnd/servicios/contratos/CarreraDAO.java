package com.example.universidadBackEnd.servicios.contratos;

import com.example.universidadBackEnd.modeloentidades.Carrera;

public interface CarreraDAO extends GenericoDAO<Carrera> {

    Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

}
