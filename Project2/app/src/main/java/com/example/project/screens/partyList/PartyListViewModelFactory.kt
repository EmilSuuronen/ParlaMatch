package com.example.project.screens.partyList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/* Emil Suuronen - 1909931
25.9.2022
 */
class PartyListViewModelFactory(val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("unchecked_cast")
        if (modelClass.isAssignableFrom(PartyListViewModel::class.java))
        return PartyListViewModel(application) as T
        throw IllegalArgumentException("Unknown ViewModel")
    }
}