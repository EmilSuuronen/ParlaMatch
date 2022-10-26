package com.example.project.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/* Emil Suuronen - 1909931
9.10.2022
 */

//data class object to represent the message
@Entity(tableName = "messages_table")
data class Message(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "person_number")
    val personNumber: Int,
    @ColumnInfo(name = "message")
    val comment: String,
)