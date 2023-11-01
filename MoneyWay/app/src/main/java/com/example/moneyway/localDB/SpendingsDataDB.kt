package com.example.moneyway.localDB

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update
import com.example.moneyway.SpendingsData

@Entity(tableName = "SpendingsDataDB",
    foreignKeys = [ForeignKey(entity = User::class,
        parentColumns = arrayOf("uid"),
        childColumns = arrayOf("s_user"),
        onDelete = ForeignKey.CASCADE)])
data class SpendingsDataDB(
    @PrimaryKey(autoGenerate = true) val sid: Int,
    @ColumnInfo(name = "s_amount") val s_amount: Int,
    @ColumnInfo(name = "s_type") val s_type: String?,
    @ColumnInfo(name = "s_date") val s_date: String,
    @ColumnInfo(name = "s_description") val s_description: String,
    @ColumnInfo(name = "s_user") val s_user: Int
)

data class SpendingsDataDBInsert(
    val s_amount: Int,
    val s_type: String?,
    val s_date: String,
    val s_description: String,
    val s_user: Int?
)

@Dao
interface SpendingsDataDBDao{

    @Query("SELECT * FROM SpendingsDataDB")
    fun getAll(): List<SpendingsDataDB>

    @Query("SELECT * FROM SpendingsDataDB WHERE sid IN (:spendingsId)")
    fun getBySid(spendingsId: IntArray): List<SpendingsDataDB>

    @Query("SELECT * FROM SpendingsDataDB WHERE s_user=:userId")
    fun getByUid(userId: Int): List<SpendingsDataDB>

    @Query("DELETE FROM SpendingsDataDB WHERE sid IN(:spendingsId)")
    fun deleteBySid(spendingsId: IntArray)

    @Insert(entity = SpendingsDataDB::class, onConflict = OnConflictStrategy.IGNORE)
    fun insert(sInsert: SpendingsDataDBInsert)

    @Update
    fun update(user: User)

    @Delete(entity = SpendingsDataDB::class)
    fun delete(spending: SpendingsDataDB)
}
