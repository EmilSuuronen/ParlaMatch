package com.example.project.repositories

import androidx.lifecycle.LiveData
import com.example.project.data.Message
import com.example.project.data.MessageDatabase

/* Emil Suuronen - 1909931
8.10.2022
 */


//repository for the messages to insert and fetch from local database
class MessagesRepository (private val database: MessageDatabase) {

    suspend fun insertMessage(message: Message) {
        database.dao.insert(message)
    }

    fun getMessages(personNumber: Int) : LiveData<List<Message>> = database.dao.getMessages(personNumber)
}