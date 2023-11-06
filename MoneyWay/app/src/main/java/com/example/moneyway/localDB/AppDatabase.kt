package com.example.moneyway.localDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
//Создаю базу данных, подключая таблицы и интерфейсы с функциями для работы с таблицами
@Database(entities = [User::class, SpendingsDataDB::class, BudgetPlansDB::class], version = 15, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun spendingsDao(): SpendingsDataDBDao
    abstract fun budgetPlansDao(): BudgetPlansDBDao

    companion object{
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase{
            if(instance == null){
                instance = Room.databaseBuilder(context,
                    AppDatabase::class.java,
                    "MoneyWayDB").allowMainThreadQueries().fallbackToDestructiveMigration().build()
            }
            return instance as AppDatabase
        }
    }
}
