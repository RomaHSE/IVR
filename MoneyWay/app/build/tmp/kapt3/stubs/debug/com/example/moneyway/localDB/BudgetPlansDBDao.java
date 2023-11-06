package com.example.moneyway.localDB;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\'J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000f\u001a\u00020\bH\'J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u0011\u001a\u00020\fH\'J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\'J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\'JP\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\'\u00a8\u0006\""}, d2 = {"Lcom/example/moneyway/localDB/BudgetPlansDBDao;", "", "delete", "", "budget", "Lcom/example/moneyway/localDB/BudgetPlansDB;", "deleteByBid", "budgetId", "", "getAll", "", "getBidByUid", "", "uId", "getByBid", "budget_id", "getByUid", "userId", "insert", "bInsert", "Lcom/example/moneyway/localDB/BudgetPlans;", "update", "user", "Lcom/example/moneyway/localDB/User;", "updateInfo", "bId", "bSum", "bProfit", "bRestaurants", "bTransport", "bGoods", "bServices", "bTransactions", "bOther", "app_debug"})
@androidx.room.Dao
public abstract interface BudgetPlansDBDao {
    
    @androidx.room.Query(value = "SELECT * FROM BudgetPlansDB")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.moneyway.localDB.BudgetPlansDB> getAll();
    
    @androidx.room.Query(value = "SELECT * FROM BudgetPlansDB WHERE bid IN (:budget_id)")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.moneyway.localDB.BudgetPlansDB> getByBid(@org.jetbrains.annotations.NotNull
    int[] budget_id);
    
    @androidx.room.Query(value = "SELECT bid FROM BudgetPlansDB WHERE b_user = :uId")
    public abstract int getBidByUid(int uId);
    
    @androidx.room.Query(value = "SELECT * FROM BudgetPlansDB WHERE b_user=:userId")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.moneyway.localDB.BudgetPlansDB> getByUid(int userId);
    
    @androidx.room.Query(value = "DELETE FROM BudgetPlansDB WHERE bid IN(:budgetId)")
    public abstract void deleteByBid(@org.jetbrains.annotations.NotNull
    int[] budgetId);
    
    @androidx.room.Query(value = "UPDATE BudgetPlansDB SET b_sum = :bSum, b_profit = :bProfit, b_restaurants = :bRestaurants, b_transport = :bTransport, b_goods = :bGoods, b_services = :bServices, b_transactions = :bTransactions, b_other = :bOther WHERE bid = :bId")
    public abstract void updateInfo(int bId, int bSum, int bProfit, int bRestaurants, int bTransport, int bGoods, int bServices, int bTransactions, int bOther);
    
    @androidx.room.Insert(entity = com.example.moneyway.localDB.BudgetPlansDB.class, onConflict = 5)
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.example.moneyway.localDB.BudgetPlans bInsert);
    
    @androidx.room.Update
    public abstract void update(@org.jetbrains.annotations.NotNull
    com.example.moneyway.localDB.User user);
    
    @androidx.room.Delete(entity = com.example.moneyway.localDB.BudgetPlansDB.class)
    public abstract void delete(@org.jetbrains.annotations.NotNull
    com.example.moneyway.localDB.BudgetPlansDB budget);
}