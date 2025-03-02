package com.example.universidadBackEnd.modeloentidades;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;



@Entity
@Table(name = "pabellones")
public class Pabellon  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "metros_cuadrados")
    private Double mts2;

    @Column(name = "nombre_pabellon", unique = true, nullable = false)
    private String nombre;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")),
            @AttributeOverride(name = "dpto", column = @Column(name = "departamento"))
    })
    private Direccion direccion;

    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    // Corregir el mapeo de la relación
    @OneToMany(mappedBy = "pabellon", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Aula> aulas;

    public Pabellon() {
    }

    public Pabellon(Integer id, Double mts2, String nombre, Direccion direccion, LocalDateTime fechaAlta,
            LocalDateTime fechaModificacion) {
        this.id = id;
        this.mts2 = mts2;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMts2() {
        return mts2;
    }

    public void setMts2(Double mts2) {
        this.mts2 = mts2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }


    public Set<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(Set<Aula> aulas) {
        this.aulas = aulas;
    }

    @PrePersist
    private void antesDePersistir(){
        this.fechaAlta = LocalDateTime.now();
    }

    @PreUpdate
    private void antesDeUpdate(){
        this.fechaModificacion = LocalDateTime.now();
    }

}
