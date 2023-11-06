package com.example.moneyway.localDB;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003JG\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0006H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lcom/example/moneyway/localDB/SpendingsDataDB;", "", "sid", "", "s_amount", "s_type", "", "s_date", "s_description", "s_user", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getS_amount", "()I", "getS_date", "()Ljava/lang/String;", "getS_description", "getS_type", "getS_user", "getSid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "SpendingsDataDB", foreignKeys = {@androidx.room.ForeignKey(entity = com.example.moneyway.localDB.User.class, parentColumns = {"uid"}, childColumns = {"s_user"}, onDelete = 5)})
public final class SpendingsDataDB {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final int sid = 0;
    @androidx.room.ColumnInfo(name = "s_amount")
    private final int s_amount = 0;
    @androidx.room.ColumnInfo(name = "s_type")
    @org.jetbrains.annotations.Nullable
    private final java.lang.String s_type = null;
    @androidx.room.ColumnInfo(name = "s_date")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String s_date = null;
    @androidx.room.ColumnInfo(name = "s_description")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String s_description = null;
    @androidx.room.ColumnInfo(name = "s_user")
    private final int s_user = 0;
    
    public SpendingsDataDB(int sid, int s_amount, @org.jetbrains.annotations.Nullable
    java.lang.String s_type, @org.jetbrains.annotations.NotNull
    java.lang.String s_date, @org.jetbrains.annotations.NotNull
    java.lang.String s_description, int s_user) {
        super();
    }
    
    public final int getSid() {
        return 0;
    }
    
    public final int getS_amount() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getS_type() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getS_date() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getS_description() {
        return null;
    }
    
    public final int getS_user() {
        return 0;
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.moneyway.localDB.SpendingsDataDB copy(int sid, int s_amount, @org.jetbrains.annotations.Nullable
    java.lang.String s_type, @org.jetbrains.annotations.NotNull
    java.lang.String s_date, @org.jetbrains.annotations.NotNull
    java.lang.String s_description, int s_user) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}