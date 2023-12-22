package com.example.contactlist.Data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity
data class Contact(


    val name: String,
    val surname: String,
    val years: String,
    val phone: String


) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0


}
