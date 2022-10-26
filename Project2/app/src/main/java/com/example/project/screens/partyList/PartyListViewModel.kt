package com.example.project.screens.partyList

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.project.data.ApplicationDatabase
import com.example.project.repositories.MepsRepository
/* Emil Suuronen - 1909931
25.9.2022
 */
class PartyListViewModel(application: Application) : ViewModel() {

    private val repo = MepsRepository(ApplicationDatabase.getInstance(application))

    var allParties = repo.getAllParties()

    private var _partyNavigation = MutableLiveData<String?>()
    val partyNavigation: LiveData<String?>
        get() = _partyNavigation

    fun navigateToMepListFragment(party : String) {
        _partyNavigation.value = party
    }

    // function to avoid an infinite loop when navigating by setting the navigation value to null
    fun navigationDone() {
        _partyNavigation.value = null
    }
}