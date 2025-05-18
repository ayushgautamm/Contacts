package com.example.contactsmanger.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface ContactsDAO {
    @Insert
     suspend fun insertContacts(contacts: Contacts): Long
     @Update
     suspend fun updateContacts(contacts: Contacts)
     @Delete
     suspend fun  deleteContacs(contacts: Contacts)
      @Query("Delete from contacts_table")
     suspend fun deleteAll()
     @Query("Select * from contacts_table")
     fun  getallContactsinDB(): LiveData<List<Contacts>>
}