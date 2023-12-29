package com.example.contactlist.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface ContactDao {

    @Insert
    suspend fun insertAll(ContactList: MutableList<Contact>)

    @Query("SELECT * FROM contact ORDER BY name ASC")
     fun getAll(): Flow<MutableList<Contact>>

    @Query("DELETE from contact WHERE id = :id ")
    suspend fun deleteById(id: Int)

    // @Update(onConflict = OnConflictStrategy.REPLACE)
    //fun update(contact: Contact)
    @Query("UPDATE contact set name = :newName, surname = :newSurname, years= :newYears, phone= :newPhone WHERE id =:id")
    suspend fun update(
        id: String,
        newName: String,
        newSurname: String,
        newYears: String,
        newPhone: String
    )


}