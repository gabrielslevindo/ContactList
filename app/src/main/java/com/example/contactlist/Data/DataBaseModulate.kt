package com.example.contactlist.Data

import android.content.Context
import androidx.room.Room
import com.comunidadedevspace.taskbeats.data.local.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModulate {


    @Singleton
    @Provides
    fun provideDB(

        @ApplicationContext context: Context

    ) = Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        "ContactList-DataBase"
    ).build()

    @Singleton
    @Provides
    fun providesDao(dataBase: AppDataBase) = dataBase.contactDao()





}