package com.example.moneyway.localDB;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\f\u001a\u00020\rH\'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\'J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\'J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\'J(\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\'\u00a8\u0006\u001d"}, d2 = {"Lcom/example/moneyway/localDB/UserDao;", "", "delete", "", "user", "Lcom/example/moneyway/localDB/User;", "deleteByUid", "userId", "", "getAll", "", "getByIds", "userIds", "", "getOnline", "getUserByLogin", "search_login", "", "insert", "uInsert", "Lcom/example/moneyway/localDB/UserInsert;", "update", "updateOnlineSt", "uid", "setStatus", "updateUserData", "userName", "userLogin", "userPassword", "app_debug"})
@androidx.room.Dao
public abstract interface UserDao {
    
    @androidx.room.Query(value = "SELECT * FROM Users")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.moneyway.localDB.User> getAll();
    
    @androidx.room.Query(value = "SELECT * FROM Users WHERE is_online=1")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.moneyway.localDB.User> getOnline();
    
    @androidx.room.Query(value = "SELECT * FROM Users WHERE uid IN (:userIds )")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.moneyway.localDB.User> getByIds(@org.jetbrains.annotations.NotNull
    int[] userIds);
    
    @androidx.room.Query(value = "SELECT * FROM Users WHERE u_login=:search_login")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.moneyway.localDB.User> getUserByLogin(@org.jetbrains.annotations.NotNull
    java.lang.String search_login);
    
    @androidx.room.Query(value = "UPDATE Users SET is_online=:setStatus WHERE uid=:uid")
    public abstract void updateOnlineSt(int uid, int setStatus);
    
    @androidx.room.Query(value = "DELETE FROM Users WHERE uid=:userId")
    public abstract void deleteByUid(int userId);
    
    @androidx.room.Query(value = "UPDATE Users SET u_name=:userName, u_login=:userLogin, u_password=:userPassword WHERE uid=:userId")
    public abstract void updateUserData(@org.jetbrains.annotations.NotNull
    java.lang.String userName, @org.jetbrains.annotations.NotNull
    java.lang.String userLogin, @org.jetbrains.annotations.NotNull
    java.lang.String userPassword, int userId);
    
    @androidx.room.Insert(entity = com.example.moneyway.localDB.User.class, onConflict = 5)
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.example.moneyway.localDB.UserInsert uInsert);
    
    @androidx.room.Update
    public abstract void update(@org.jetbrains.annotations.NotNull
    com.example.moneyway.localDB.User user);
    
    @androidx.room.Delete
    public abstract void delete(@org.jetbrains.annotations.NotNull
    com.example.moneyway.localDB.User user);
}