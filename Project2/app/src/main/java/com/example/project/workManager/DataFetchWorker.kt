package com.example.project.workManager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.project.data.*
import com.example.project.repositories.MepsRepository
import retrofit2.HttpException
/* Emil Suuronen - 1909931
2.10.2022
 */

//worker for the mepApp application
class DataFetchWorker (context: Context, parameters: WorkerParameters) : CoroutineWorker(context, parameters){

    companion object {
        const val WORK_NAME = "FetchData"
    }

    override suspend fun doWork(): Result {

        // Getting an instance of the main Application database and passing it to the repository
        val database = ApplicationDatabase.getInstance(applicationContext)
        val repo = MepsRepository(database)
        try {
            Log.d("Worker", "refreshing database")
            // doing a function to refresh the database from the internet through repository
            repo.refreshDatabase()
            return Result.success()
        } catch (exception: HttpException) {
            Log.d("DataBase","Error in creation")
            return Result.retry()
        }

    }
}