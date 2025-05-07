package com.example.contactsmanger.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Contacts::class], version = 1)
abstract class ContactsDB : RoomDatabase() {
    abstract val contactDAO : ContactsDAO
    // Singleton Design pattern only one instance of the database exists , avoiding unnecesary overhead
    // associated with repeated database creation
    //companion obj : define a static singleton instance of this DB class
    // @Volatile : prevents any possible race condition in multithreading
    companion object{
        @Volatile
        private var INSTANCE : ContactsDB? =null
        fun getInstance(context: Context) : ContactsDB {
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        ContactsDB::class.java,
                        "contact_db"
                    ).build()
                }
                INSTANCE =instance
                return  instance


            }
        }
    }

}