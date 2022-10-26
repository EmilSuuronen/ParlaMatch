package com.example.project.screens.mepMessage

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.data.ApplicationDatabase
import com.example.project.data.Mep
import com.example.project.data.Message
import com.example.project.data.MessageDatabase
import com.example.project.repositories.MepsRepository
import com.example.project.repositories.MessagesRepository
import kotlinx.coroutines.launch
/* Emil Suuronen - 1909931
9.10.2022
 */

//ViewModel for the messages screen
class MepMessageViewModel(application: Application, private val personNumber: Int): ViewModel() {

    private val messageRepo = MessagesRepository(MessageDatabase.getInstance(application))
    private val mepsRepo = MepsRepository(ApplicationDatabase.getInstance(application))

    val messages = messageRepo.getMessages(personNumber)

    private val _mep: LiveData<Mep> = mepsRepo.getMepById(personNumber)
    val mep: LiveData<Mep>
        get() = _mep

    // function which get input from view and inserts it to database through repository
    fun sendMessage (message: String) {
        Log.e("mes","before courotine")
        viewModelScope.launch {
                messageRepo.insertMessage(Message(0,personNumber,message))
            }
    }
}
