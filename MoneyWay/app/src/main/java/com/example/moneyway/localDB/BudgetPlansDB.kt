package com.example.moneyway.localDB

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update

@Entity(tableName = "BudgetPlansDB",
    foreignKeys = [ForeignKey(entity = User::class,
        parentColumns = arrayOf("uid"),
        childColumns = arrayOf("b_user"),
        onDelete = ForeignKey.CASCADE)])
data class BudgetPlansDB(
    @PrimaryKey(autoGenerate = true) val bid: Int,
    @ColumnInfo(name = "b_sum") var b_sum: Int,
    @ColumnInfo(name = "b_profit") var b_profit: Int,
    @ColumnInfo(name = "b_restaurants") var b_restaurants: Int,
    @ColumnInfo(name = "b_transport") var b_transport: Int,
    @ColumnInfo(name = "b_goods") var b_goods: Int,
    @ColumnInfo(name = "b_services") var b_services: Int,
    @ColumnInfo(name = "b_transactions") var b_transactions: Int,
    @ColumnInfo(name = "b_other") var b_other: Int,
    @ColumnInfo(name = "b_user") val b_user: Int
)

data class BudgetPlans(
    var b_sum: Int,
    var b_profit: Int,
    var b_restaurants: Int,
    var b_transport: Int,
    var b_goods: Int,
    var b_services: Int,
    var b_transactions: Int,
    var b_other: Int,
    var b_user: Int
)

@Dao
interface BudgetPlansDBDao{
    @Query("SELECT * FROM BudgetPlansDB")
    fun getAll(): List<BudgetPlansDB>

    @Query("SELECT * FROM BudgetPlansDB WHERE bid IN (:budget_id)")
    fun getByBid(budget_id: IntArray): List<BudgetPlansDB>

    @Query("SELECT bid FROM BudgetPlansDB WHERE b_user = :uId")
    fun getBidByUid(uId: Int): Int

    @Query("SELECT * FROM BudgetPlansDB WHERE b_user=:userId")
    fun getByUid(userId: Int): List<BudgetPlansDB>

    @Query("DELETE FROM BudgetPlansDB WHERE bid IN(:budgetId)")
    fun deleteByBid(budgetId: IntArray)

    @Query("UPDATE BudgetPlansDB SET b_sum = :bSum, b_profit = :bProfit, b_restaurants = :bRestaurants, " +
            "b_transport = :bTransport, b_goods = :bGoods, b_services = :bServices, b_transactions = :bTransactions, " +
            "b_other = :bOther WHERE bid = :bId")
    fun updateInfo(bId: Int,
                   bSum: Int,
                   bProfit: Int,
                   bRestaurants: Int,
                   bTransport: Int,
                   bGoods: Int,
                   bServices: Int,
                   bTransactions: Int,
                   bOther: Int)

    @Insert(entity = BudgetPlansDB::class, onConflict = OnConflictStrategy.IGNORE)
    fun insert(bInsert: BudgetPlans)

    @Update
    fun update(user: User)

    @Delete(entity = BudgetPlansDB::class)
    fun delete(budget: BudgetPlansDB)
}