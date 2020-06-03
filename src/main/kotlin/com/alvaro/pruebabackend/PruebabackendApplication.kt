package com.alvaro.pruebabackend

import com.alvaro.pruebabackend.dao.PersonaRepository
import com.alvaro.pruebabackend.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import javax.swing.text.DateFormatter


@SpringBootApplication
class PruebabackendApplication : CommandLineRunner{
	@Autowired
	val personaRepository : PersonaRepository? = null

	override fun run(vararg args: String?) {
		val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
		val persona = Persona(111111,"Alvaro","Gimenez",LocalDate.parse("01-01-2020", formatter))
		personaRepository!!.save(persona)
	}

}

fun main(args: Array<String>) {
	runApplication<PruebabackendApplication>(*args)
}
