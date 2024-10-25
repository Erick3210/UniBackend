package com.example.universidadBackEnd.servicios.contratos;

import com.example.universidadBackEnd.modeloentidades.Persona;

public interface AlumnoDAO extends PersonaDAO {

    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);

}
