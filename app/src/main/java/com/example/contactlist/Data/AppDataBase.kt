package com.comunidadedevspace.taskbeats.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactlist.Data.Contact
import com.example.contactlist.Data.ContactDao
import kotlinx.coroutines.CoroutineScope


@Database(entities = [Contact::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun contactDao(): ContactDao

    companion object {

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getAppDataBaseInstance(context: Context): AppDataBase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(


                    context.applicationContext, AppDataBase::class.java, "ContactList-DataBase").build()


                INSTANCE = instance
                instance


            }


        }


    }


}

