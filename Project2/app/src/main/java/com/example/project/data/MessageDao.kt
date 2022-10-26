package com.example.project.data

import androidx.lifecycle.LiveData
import androidx.room.*
/* Emil Suuronen - 1909931
7.10.2022
 */

// Data access object for the queries from message room database
@Dao
interface MessageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(message: Message)

    @Query("SELECT * FROM messages_table WHERE person_number = :personNumber")
    fun getMessages(personNumber: Int): LiveData<List<Message>>
}