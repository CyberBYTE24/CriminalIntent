package com.sample.criminalintent

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "intents")
data class IntentEntity(
    @PrimaryKey
    val id: Int,
    val title: String?,
    val date: Int?,
    val isDone: Boolean,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    val photo: ByteArray
)