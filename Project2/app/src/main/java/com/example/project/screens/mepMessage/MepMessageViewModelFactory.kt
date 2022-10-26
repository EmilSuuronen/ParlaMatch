package com.example.project.screens.mepMessage

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/* Emil Suuronen - 1909931
9.10.2022
 */

//viewModel factory for the messages screen ViewModel
class MepMessageViewModelFactory(val application: Application, val personNumber: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("unchecked_cast")
        return MepMessageViewModel(application, personNumber) as T
        throw IllegalArgumentException("Unknown ViewModel")
    }
}