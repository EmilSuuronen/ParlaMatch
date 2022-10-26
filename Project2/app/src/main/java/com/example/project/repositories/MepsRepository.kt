package com.example.project.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.project.api.MepApi
import com.example.project.data.ApplicationDatabase
import com.example.project.data.Mep
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

/* Emil Suuronen - 1909931
3.10.2022
 */

//repository for the members of parliament to insert and fetch from local database
class MepsRepository (private val database: ApplicationDatabase) {

    suspend fun refreshDatabase() {
        withContext(Dispatchers.IO) {
            try {
                val meps = MepApi.retrofitService.getMepData()
                database.dao.insertOrUpdate(meps)
                Log.e("Repository", "Trying to refresh")
            } catch (e: HttpException) {
                Log.e("Repository", "Error refreshing data")
            }
        }
    }

    fun getAllParties(): LiveData<List<String>> = database.dao.getAllParties()

    fun getMep(party: String) : LiveData<Mep> = database.dao.getMep(party)

    fun getMepById(personNumber: Int) : LiveData<Mep> = database.dao.getMepById(personNumber)

}