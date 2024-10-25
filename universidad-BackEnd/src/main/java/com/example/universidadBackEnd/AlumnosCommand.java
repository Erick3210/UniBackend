package com.example.universidadBackEnd;

import com.example.universidadBackEnd.modeloentidades.Alumno;
import com.example.universidadBackEnd.modeloentidades.Carrera;
import com.example.universidadBackEnd.modeloentidades.Direccion;
import com.example.universidadBackEnd.modeloentidades.Persona;
import com.example.universidadBackEnd.servicios.contratos.AlumnoDAO;
import com.example.universidadBackEnd.servicios.contratos.CarreraDAO;
import com.example.universidadBackEnd.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

// La anotación @Component indica que esta clase será un bean administrado por Spring, 
// lo que permitirá que Spring lo detecte automáticamente y lo ejecute cuando la aplicación arranque.
@Component
public class AlumnosCommand implements CommandLineRunner {

    // Inyectamos una implementación de PersonaDAO en esta clase.
    // @Qualifier se usa para especificar cuál implementación de PersonaDAO queremos
    // usar en caso de que haya varias.
    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDAO;

    // Inyectamos CarreraDAO para interactuar con las carreras (obtener, actualizar,
    // etc.)
    @Autowired
    private CarreraDAO carreraDAO;

    @Autowired
    @Lazy
    private AlumnoDAO alumnoDAO;

    // El método 'run' se ejecutará cuando la aplicación Spring Boot arranque.
    @Override
    public void run(String... args) throws Exception {
        // Código comentado: la intención aquí era obtener una carrera con ID 2
        // (Ingeniería en Sistemas)
        // y asignar esa carrera a cada alumno registrado en la base de datos.
        /*
         * Optional<Carrera> ingSistemas = carreraDAO.findById(2);
         * 
         * // Obtiene todos los alumnos y les asigna la carrera obtenida (ingSistemas)
         * Iterable<Persona> alumnos = personaDAO.findAll();
         * alumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(ingSistemas.get()));
         * alumnos.forEach(alumno -> personaDAO.save(alumno));
         */

        // Código comentado: búsqueda de un alumno por su ID
        /*
         * Optional<Persona> alumno_1 = personaDAO.findById(1);
         * 
         * // Búsqueda por nombre y apellido de un alumno
         * Optional<Persona> personaNomApe =
         * personaDAO.buscarPorNombreYApellido(alumno_1.get().getNombre(),
         * alumno_1.get().getApellido());
         * System.out.println(personaNomApe.toString());
         * 
         * // Búsqueda de alumno por su DNI
         * Optional<Persona> personaDni =
         * personaDAO.buscarPorDni(alumno_1.get().getDni());
         * System.out.println(personaDni.toString());
         * 
         * // Búsqueda de personas por su apellido y mostrar los resultados
         * Iterable<Persona> personasApellido =
         * personaDAO.buscarPersonaPorApellido(alumno_1.get().getApellido());
         * personasApellido.forEach(System.out::println);
         * 
         * 
         * 
         * Optional<Carrera> ingSistemas = carreraDAO.findById(2);
         * if (ingSistemas.isPresent()) {
         * Iterable<Persona> alumnosCarrera = ((AlumnoDAO) personaDAO)
         * .buscarAlumnosPorNombreCarrera(ingSistemas.get().getNombre());
         * alumnosCarrera.forEach(System.out::println);
         * } else {
         * System.out.println("No se encontró la carrera con ID 2");
         * }
         * 
         * 
         * 
         * 
         *  
         */

      
 // Crear un nuevo alumno (como ejemplo)
 Persona nuevoAlumno = new Persona();
 nuevoAlumno.setNombre("Erick");
 nuevoAlumno.setApellido("Castillo");
 nuevoAlumno.setDni("1234567664");

 // Guardar el alumno en la base de datos
 alumnoDAO.save(nuevoAlumno);

 // Mostrar el alumno guardado
 System.out.println("Alumno guardado: " + nuevoAlumno);


   
    }
}
