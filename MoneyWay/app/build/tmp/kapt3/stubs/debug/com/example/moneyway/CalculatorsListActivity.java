package com.example.moneyway;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006!"}, d2 = {"Lcom/example/moneyway/CalculatorsListActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/moneyway/databinding/ActivityCalculatorsListBinding;", "db", "Lcom/example/moneyway/localDB/AppDatabase;", "getDb", "()Lcom/example/moneyway/localDB/AppDatabase;", "setDb", "(Lcom/example/moneyway/localDB/AppDatabase;)V", "uDao", "Lcom/example/moneyway/localDB/UserDao;", "getUDao", "()Lcom/example/moneyway/localDB/UserDao;", "setUDao", "(Lcom/example/moneyway/localDB/UserDao;)V", "onClickClassicCalculatorButton", "", "view", "Landroid/view/View;", "onClickCreditCalculatorButton", "onClickSavingsCalculatorButton", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "app_debug"})
public final class CalculatorsListActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.moneyway.databinding.ActivityCalculatorsListBinding binding;
    public com.example.moneyway.localDB.AppDatabase db;
    public com.example.moneyway.localDB.UserDao uDao;
    
    public CalculatorsListActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.moneyway.localDB.AppDatabase getDb() {
        return null;
    }
    
    public final void setDb(@org.jetbrains.annotations.NotNull
    com.example.moneyway.localDB.AppDatabase p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.moneyway.localDB.UserDao getUDao() {
        return null;
    }
    
    public final void setUDao(@org.jetbrains.annotations.NotNull
    com.example.moneyway.localDB.UserDao p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    public final void onClickClassicCalculatorButton(@org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
    
    public final void onClickCreditCalculatorButton(@org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
    
    public final void onClickSavingsCalculatorButton(@org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
}