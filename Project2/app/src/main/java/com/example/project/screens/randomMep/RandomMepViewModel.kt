package com.example.project.screens.randomMep

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.project.data.ApplicationDatabase
import com.example.project.repositories.MepsRepository

/* Emil Suuronen - 1909931
3.10.2022
 */

class RandomMepViewModel (application: Application, private val party: String) : ViewModel()  {

    private val repo = MepsRepository(ApplicationDatabase.getInstance(application))

    var randomMep = repo.getMep(party)

    fun likeClick() {
        randomMep = repo.getMep(party)
    }

    fun dislikeClick() {
        randomMep = repo.getMep(party)
    }

    fun navigationDone() {

    }
}