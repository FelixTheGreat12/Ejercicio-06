package com.upiiz.orm.Models;

// Persistencia de datos
import jakarta.persistence.*;
// Validacion antes de guardar en la base de datos
import jakarta.validation.constraints.*;

// Lombok para reducir el codigo
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//mapear (ORM)
// reducir codigo(lombok)
// Validar(Bean Validation)
@Data
//Constructor con todos los atributos
@AllArgsConstructor
//Constructor vacio
@NoArgsConstructor
//Mapear esta clase a una tabla de la base de datos
@Entity
//Clase ClienteEntity -> tabla cliente
@Table(name = "cliente")
public class ClienteEntity {
    // LLave primaria y que MySQL se encargue de generarla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // En caso  de requerir un nombre de columna diferente
    @NotBlank
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    @Column(name = "nombre_cliente")
    private String nombre;

    @NotBlank(message = "El apellido es requerido")
    private String apellido;

    @NotBlank(message = "El email es requerido")
    // Validar que sea un email
    @Email(message = "El email no es valido")
    //VALIDAR QUE NO SE REPITA
    @Column(unique = true)
    private String email;

    @NotBlank(message = "El telefono es requerido")
    @Size(min = 10, max = 10, message = "El telefono debe tener 10 digitos")
    // El patron del telefono debe empezar con 492 y tener 10 digitos
    @Pattern(regexp = "^[0-9]{10}$", message = "El telefono solo debe contener numeros")
    private String telefono;

    @NotBlank(message = "La direccion es requerida")
    private String direccion;

    @NotNull(message = "La edad es requerida")
    @Min(value = 18, message = "La edad minima es 18")
    private int edad;

    @NotBlank(message = "El rfc es requerido")
    @Pattern(regexp = "^[A-Z]{4}[0-9]{6}[A-Z0-9]{3}$", message = "El RFC no es valido")
    private String rfc;
}
