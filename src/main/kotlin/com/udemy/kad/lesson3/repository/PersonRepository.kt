package com.udemy.kad.lesson3.repository

import com.udemy.kad.lesson3.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long>