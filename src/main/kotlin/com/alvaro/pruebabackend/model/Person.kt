package com.alvaro.pruebabackend.model

import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "Persona")
class Persona(val dni:Long = 0, val nombre:String = "", val apellido:String = "", val fechaNac:LocalDate? = null) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long = 0
}