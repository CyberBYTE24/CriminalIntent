package com.sample.criminalintent

import java.util.Date

data class Intent(
    val id : Int,
    val title : String,
    val date : Date,
    val isDone : Boolean,
    val photo : ByteArray
)