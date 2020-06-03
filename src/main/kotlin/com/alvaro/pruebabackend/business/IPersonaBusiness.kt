package com.alvaro.pruebabackend.business

import com.alvaro.pruebabackend.model.Persona

interface IPersonaBusiness {

    fun list():List<Persona>
    fun load(idPersona:Long) : Persona
    fun save(persona:Persona): Persona
    fun remove(idPersona: Long)

}