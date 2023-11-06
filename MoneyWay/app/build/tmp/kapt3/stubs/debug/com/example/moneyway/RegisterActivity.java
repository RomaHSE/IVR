package com.example.moneyway;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u0002042\u0006\u00105\u001a\u000206J\u0012\u00108\u001a\u0002042\b\u00109\u001a\u0004\u0018\u00010:H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020%X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\'\"\u0004\b,\u0010)R\u001a\u0010-\u001a\u00020%X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\'\"\u0004\b/\u0010)R\u001a\u00100\u001a\u00020%X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\'\"\u0004\b2\u0010)\u00a8\u0006;"}, d2 = {"Lcom/example/moneyway/RegisterActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/moneyway/databinding/ActivityRegisterBinding;", "getBinding", "()Lcom/example/moneyway/databinding/ActivityRegisterBinding;", "setBinding", "(Lcom/example/moneyway/databinding/ActivityRegisterBinding;)V", "db", "Lcom/example/moneyway/localDB/AppDatabase;", "getDb", "()Lcom/example/moneyway/localDB/AppDatabase;", "setDb", "(Lcom/example/moneyway/localDB/AppDatabase;)V", "error_text", "Landroid/widget/TextView;", "getError_text", "()Landroid/widget/TextView;", "setError_text", "(Landroid/widget/TextView;)V", "log_in_link_button", "Landroid/widget/Button;", "getLog_in_link_button", "()Landroid/widget/Button;", "setLog_in_link_button", "(Landroid/widget/Button;)V", "reg_button", "getReg_button", "setReg_button", "uDao", "Lcom/example/moneyway/localDB/UserDao;", "getUDao", "()Lcom/example/moneyway/localDB/UserDao;", "setUDao", "(Lcom/example/moneyway/localDB/UserDao;)V", "user_login", "", "getUser_login", "()Ljava/lang/String;", "setUser_login", "(Ljava/lang/String;)V", "user_name", "getUser_name", "setUser_name", "user_password", "getUser_password", "setUser_password", "user_password2", "getUser_password2", "setUser_password2", "onClickLogInLinkButton", "", "view", "Landroid/view/View;", "onClickRegButton", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class RegisterActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.example.moneyway.databinding.ActivityRegisterBinding binding;
    public java.lang.String user_name;
    public java.lang.String user_login;
    public java.lang.String user_password;
    public java.lang.String user_password2;
    public android.widget.Button reg_button;
    public android.widget.Button log_in_link_button;
    public android.widget.TextView error_text;
    public com.example.moneyway.localDB.AppDatabase db;
    public com.example.moneyway.localDB.UserDao uDao;
    
    public RegisterActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.moneyway.databinding.ActivityRegisterBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.moneyway.databinding.ActivityRegisterBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUser_name() {
        return null;
    }
    
    public final void setUser_name(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUser_login() {
        return null;
    }
    
    public final void setUser_login(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUser_password() {
        return null;
    }
    
    public final void setUser_password(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUser_password2() {
        return null;
    }
    
    public final void setUser_password2(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.Button getReg_button() {
        return null;
    }
    
    public final void setReg_button(@org.jetbrains.annotations.NotNull
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.Button getLog_in_link_button() {
        return null;
    }
    
    public final void setLog_in_link_button(@org.jetbrains.annotations.NotNull
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView getError_text() {
        return null;
    }
    
    public final void setError_text(@org.jetbrains.annotations.NotNull
    android.widget.TextView p0) {
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
    
    public final void onClickRegButton(@org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
    
    public final void onClickLogInLinkButton(@org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
}