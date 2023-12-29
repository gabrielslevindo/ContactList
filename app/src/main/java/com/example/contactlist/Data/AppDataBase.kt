package com.comunidadedevspace.taskbeats.data.local


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contactlist.Data.Contact
import com.example.contactlist.Data.ContactDao



@Database(entities = [Contact::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun contactDao(): ContactDao


}

