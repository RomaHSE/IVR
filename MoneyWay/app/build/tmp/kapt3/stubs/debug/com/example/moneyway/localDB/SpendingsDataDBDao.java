package com.example.moneyway.localDB;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u0007\u001a\u00020\bH\'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\r\u001a\u00020\u000eH\'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\'\u00a8\u0006\u0015"}, d2 = {"Lcom/example/moneyway/localDB/SpendingsDataDBDao;", "", "delete", "", "spending", "Lcom/example/moneyway/localDB/SpendingsDataDB;", "deleteBySid", "spendingsId", "", "getAll", "", "getBySid", "getByUid", "userId", "", "insert", "sInsert", "Lcom/example/moneyway/localDB/SpendingsDataDBInsert;", "update", "user", "Lcom/example/moneyway/localDB/User;", "app_debug"})
@androidx.room.Dao
public abstract interface SpendingsDataDBDao {
    
    @androidx.room.Query(value = "SELECT * FROM SpendingsDataDB")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.moneyway.localDB.SpendingsDataDB> getAll();
    
    @androidx.room.Query(value = "SELECT * FROM SpendingsDataDB WHERE sid IN (:spendingsId)")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.moneyway.localDB.SpendingsDataDB> getBySid(@org.jetbrains.annotations.NotNull
    int[] spendingsId);
    
    @androidx.room.Query(value = "SELECT * FROM SpendingsDataDB WHERE s_user=:userId")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.moneyway.localDB.SpendingsDataDB> getByUid(int userId);
    
    @androidx.room.Query(value = "DELETE FROM SpendingsDataDB WHERE sid IN(:spendingsId)")
    public abstract void deleteBySid(@org.jetbrains.annotations.NotNull
    int[] spendingsId);
    
    @androidx.room.Insert(entity = com.example.moneyway.localDB.SpendingsDataDB.class, onConflict = 5)
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.example.moneyway.localDB.SpendingsDataDBInsert sInsert);
    
    @androidx.room.Update
    public abstract void update(@org.jetbrains.annotations.NotNull
    com.example.moneyway.localDB.User user);
    
    @androidx.room.Delete(entity = com.example.moneyway.localDB.SpendingsDataDB.class)
    public abstract void delete(@org.jetbrains.annotations.NotNull
    com.example.moneyway.localDB.SpendingsDataDB spending);
}