package com.example.demo.controllers

import com.example.demo.contracts.Message
import com.example.demo.repository.MessageRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController(val repository: MessageRepository) {

    @GetMapping("/")
    fun index(): List<Message> = repository.findAll()

    @GetMapping("/{id}")
    fun getById(@RequestHeader id: String): List<Message> =
        repository.findById(id)

    @PostMapping("/")
    fun post(@RequestBody message: Message) {
        repository.create(message)
    }
}