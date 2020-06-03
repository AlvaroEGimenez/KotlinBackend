package com.alvaro.pruebabackend.business

import com.alvaro.pruebabackend.dao.PersonaRepository
import com.alvaro.pruebabackend.exceptions.BusinessException
import com.alvaro.pruebabackend.exceptions.NotFoundException
import com.alvaro.pruebabackend.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature

@Service
class PersonaBusiness : IPersonaBusiness {

    @Autowired
    val personaRepository : PersonaRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<Persona> {
        try {
            return  personaRepository!!.findAll()
        }catch (e : Exception){
            throw BusinessException(e.message)
        }

    }
    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idPersona: Long): Persona {
        val op : Optional<Persona>
        try {
            op = personaRepository!!.findById(idPersona)
        }catch (e: Exception){
            throw BusinessException(e.message)
        }

        if (op.isPresent)
            return op.get()
        else
            throw NotFoundException("No se encontro la persona con el ID $idPersona")
    }

    @Throws(BusinessException::class)
    override fun save(persona: Persona): Persona {
       try {
           return personaRepository!!.save(persona)
       }catch (e: Exception){
           throw BusinessException(e.message)
       }
    }

    override fun remove(idPersona: Long) {
        val op : Optional<Persona>
        try {
            op = personaRepository!!.findById(idPersona)
        }catch (e: Exception){
            throw BusinessException(e.message)
        }

        if (op.isPresent)
            try {
                personaRepository!!.deleteById(idPersona)
            }catch (e: Exception){
                throw BusinessException(e.message)
            }
        else
            throw NotFoundException("No se encontro a la persona con el ID $idPersona")
    }
}