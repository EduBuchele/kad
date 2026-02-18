package com.udemy.kad.lesson3.service

import com.udemy.kad.lesson3.exception.NotFoundException
import com.udemy.kad.lesson3.model.Person
import com.udemy.kad.lesson3.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> = repository.findAll()

    fun findById(id: Long) : Person {
        logger.info("Search person by ID: $id")
        return repository.findById(id)
            .orElseThrow{ NotFoundException("No records found this id $id")}
    }

    fun create(person: Person) : Person {
        logger.info("Creating person: ${person.firstName}")
        return repository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("Update person with this ID: ${person.id}")
        val entity = repository.findById(person.id)
            .orElseThrow { NotFoundException("No records found this id ${person.id}") }

        person.firstName.takeIf { it.isNotBlank() }?.let { entity.firstName = it }
        person.lastName.takeIf { it.isNotBlank() }?.let { entity.lastName = it }
        person.address.takeIf { it.isNotBlank() }?.let { entity.address = it }
        person.gender.takeIf { it.isNotBlank() }?.let { entity.gender = it }

        return repository.save(entity)
    }


    fun delete(id: Long) {
        logger.info("Delete person with this ID: ${id}")
        val person = repository.findById(id)
            .orElseThrow { NotFoundException("No records found this id $id") }
        repository.delete(person)

    }
}