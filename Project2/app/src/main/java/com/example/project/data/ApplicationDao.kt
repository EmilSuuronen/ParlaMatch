package com.example.project.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
/* Emil Suuronen - 1909931
1.10.2022
 */

//Data Access object for the querys from the room database
@Dao
interface ApplicationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(meps_table: List<Mep>)

    @Query("SELECT DISTINCT party FROM meps_table")
    fun getAllParties(): LiveData<List<String>>

    @Query("SELECT * FROM meps_table")
    fun getAllMeps(): LiveData<List<Mep>>

    @Query("SELECT * FROM meps_table WHERE party = :party")
    fun getPartyMembers(party: String): LiveData<List<Mep>>

    @Query("SELECT * FROM meps_table WHERE party = :party ORDER BY RANDOM() LIMIT 1")
    fun getMep(party: String): LiveData<Mep>

    @Query("SELECT * FROM meps_table WHERE person_number = :personNumber")
    fun getMepById(personNumber: Int): LiveData<Mep>

    @Query("SELECT person_number FROM meps_table WHERE party = :party ORDER BY RANDOM() LIMIT 1")
    fun getPartyMembersId(party: String): LiveData<Int>
}