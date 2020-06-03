package com.alvaro.pruebabackend.dao

import com.alvaro.pruebabackend.model.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonaRepository : JpaRepository<Persona, Long>