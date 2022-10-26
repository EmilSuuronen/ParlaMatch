package com.example.project.data

import androidx.room.ColumnInfo
import androidx.room.Entity


/* Emil Suuronen - 1909931
2.10.2022
 */

// data class object to represent the member of parliament
@Entity(tableName = "meps_table", primaryKeys = ["person_number"])
data class Mep(
    @ColumnInfo(name = "person_number")
    val personNumber: Int,
    @ColumnInfo(name = "seat_number")
    val seatNumber: Int,
    @ColumnInfo(name = "last_name")
    val last: String,
    @ColumnInfo(name = "first_name")
    val first: String,
    @ColumnInfo(name = "party")
    val party: String,
    @ColumnInfo(name = "is_minister")
    val minister: Boolean,
    @ColumnInfo(name = "picture")
    val picture: String,
    @ColumnInfo(name = "twitter")
    val twitter: String,
    @ColumnInfo(name = "year_born")
    val bornYear: Int,
    @ColumnInfo(name = "constituency")
    val constituency: String
)

