package com.example.project.screens.randomMep

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/* Emil Suuronen - 1909931
3.10.2022
 */

class RandomMepViewModelFactory(val application: Application, val party: String): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("unchecked_cast")
        return RandomMepViewModel(application, party) as T
        throw IllegalArgumentException("Unknown ViewModel")
    }
}