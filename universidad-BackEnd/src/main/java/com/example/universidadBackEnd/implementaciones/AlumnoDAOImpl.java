package com.example.universidadBackEnd.implementaciones;

import com.example.universidadBackEnd.modeloentidades.Persona;
import com.example.universidadBackEnd.repositorios.AlumnoRepository;
import com.example.universidadBackEnd.repositorios.PersonaRepository;
import com.example.universidadBackEnd.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO {

    @Autowired
    public AlumnoDAOImpl(@Qualifier("repositorioAlumnos")PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly =true)
    public Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre) {
        return ((AlumnoRepository)repository).buscarAlumnosPorNombreCarrera(nombre);
    }


    @Autowired
    private AlumnoDAO alumnoDAO;

    public void guardarAlumno(Persona alumno) {
        alumnoDAO.save(alumno); // Guardar o actualizar el alumno
    }
}
