package com.example.demo.repository

import com.example.demo.contracts.Message
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.util.*

interface IMessageRepository : CrudRepository<Message, String>

@Service
class MessageRepository(val db: IMessageRepository) {

    fun findAll(): List<Message> = db.findAll().toList()

    fun findById(id: String): List<Message> = db.findById(id).toList()

    fun create(message: Message) {
        db.save(message)
    }

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}