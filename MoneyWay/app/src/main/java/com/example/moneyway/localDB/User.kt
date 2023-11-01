package com.example.moneyway.localDB

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update

@Entity(tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "u_name") val u_name: String,
    @ColumnInfo(name = "u_login") val u_login: String,
    @ColumnInfo(name = "u_password") val u_password: String,
    @ColumnInfo(name = "is_online") val is_online: Boolean
)

data class UserInsert(
    val u_name: String,
    val u_login: String,
    val u_password: String,
    val is_online: Boolean
)

@Dao
interface UserDao {

    @Query("SELECT * FROM Users")
    fun getAll(): List<User>

    @Query("SELECT * FROM Users WHERE is_online=1")
    fun getOnline(): List<User>

    @Query("SELECT * FROM Users WHERE uid IN (:userIds )")
    fun getByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM Users WHERE u_login=:search_login")
    fun getUserByLogin(search_login: String): List<User>

    @Query("UPDATE Users SET is_online=:setStatus WHERE uid=:uid")
    fun updateOnlineSt(uid: Int, setStatus: Int)

    @Insert(entity = User::class, onConflict = OnConflictStrategy.IGNORE)
    fun insert(uInsert: UserInsert)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

}