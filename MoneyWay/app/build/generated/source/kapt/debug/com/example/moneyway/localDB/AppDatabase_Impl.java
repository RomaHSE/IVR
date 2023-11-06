package com.example.moneyway.localDB;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserDao _userDao;

  private volatile SpendingsDataDBDao _spendingsDataDBDao;

  private volatile BudgetPlansDBDao _budgetPlansDBDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(15) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Users` (`uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `u_name` TEXT NOT NULL, `u_login` TEXT NOT NULL, `u_password` TEXT NOT NULL, `is_online` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `SpendingsDataDB` (`sid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `s_amount` INTEGER NOT NULL, `s_type` TEXT, `s_date` TEXT NOT NULL, `s_description` TEXT NOT NULL, `s_user` INTEGER NOT NULL, FOREIGN KEY(`s_user`) REFERENCES `Users`(`uid`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `BudgetPlansDB` (`bid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `b_sum` INTEGER NOT NULL, `b_profit` INTEGER NOT NULL, `b_restaurants` INTEGER NOT NULL, `b_transport` INTEGER NOT NULL, `b_goods` INTEGER NOT NULL, `b_services` INTEGER NOT NULL, `b_transactions` INTEGER NOT NULL, `b_other` INTEGER NOT NULL, `b_user` INTEGER NOT NULL, FOREIGN KEY(`b_user`) REFERENCES `Users`(`uid`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '836a3419e9d197af822033db37075e99')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Users`");
        _db.execSQL("DROP TABLE IF EXISTS `SpendingsDataDB`");
        _db.execSQL("DROP TABLE IF EXISTS `BudgetPlansDB`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(5);
        _columnsUsers.put("uid", new TableInfo.Column("uid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("u_name", new TableInfo.Column("u_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("u_login", new TableInfo.Column("u_login", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("u_password", new TableInfo.Column("u_password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("is_online", new TableInfo.Column("is_online", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("Users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(_db, "Users");
        if (! _infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "Users(com.example.moneyway.localDB.User).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsSpendingsDataDB = new HashMap<String, TableInfo.Column>(6);
        _columnsSpendingsDataDB.put("sid", new TableInfo.Column("sid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSpendingsDataDB.put("s_amount", new TableInfo.Column("s_amount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSpendingsDataDB.put("s_type", new TableInfo.Column("s_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSpendingsDataDB.put("s_date", new TableInfo.Column("s_date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSpendingsDataDB.put("s_description", new TableInfo.Column("s_description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSpendingsDataDB.put("s_user", new TableInfo.Column("s_user", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSpendingsDataDB = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysSpendingsDataDB.add(new TableInfo.ForeignKey("Users", "CASCADE", "NO ACTION",Arrays.asList("s_user"), Arrays.asList("uid")));
        final HashSet<TableInfo.Index> _indicesSpendingsDataDB = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSpendingsDataDB = new TableInfo("SpendingsDataDB", _columnsSpendingsDataDB, _foreignKeysSpendingsDataDB, _indicesSpendingsDataDB);
        final TableInfo _existingSpendingsDataDB = TableInfo.read(_db, "SpendingsDataDB");
        if (! _infoSpendingsDataDB.equals(_existingSpendingsDataDB)) {
          return new RoomOpenHelper.ValidationResult(false, "SpendingsDataDB(com.example.moneyway.localDB.SpendingsDataDB).\n"
                  + " Expected:\n" + _infoSpendingsDataDB + "\n"
                  + " Found:\n" + _existingSpendingsDataDB);
        }
        final HashMap<String, TableInfo.Column> _columnsBudgetPlansDB = new HashMap<String, TableInfo.Column>(10);
        _columnsBudgetPlansDB.put("bid", new TableInfo.Column("bid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBudgetPlansDB.put("b_sum", new TableInfo.Column("b_sum", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBudgetPlansDB.put("b_profit", new TableInfo.Column("b_profit", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBudgetPlansDB.put("b_restaurants", new TableInfo.Column("b_restaurants", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBudgetPlansDB.put("b_transport", new TableInfo.Column("b_transport", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBudgetPlansDB.put("b_goods", new TableInfo.Column("b_goods", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBudgetPlansDB.put("b_services", new TableInfo.Column("b_services", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBudgetPlansDB.put("b_transactions", new TableInfo.Column("b_transactions", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBudgetPlansDB.put("b_other", new TableInfo.Column("b_other", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBudgetPlansDB.put("b_user", new TableInfo.Column("b_user", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBudgetPlansDB = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysBudgetPlansDB.add(new TableInfo.ForeignKey("Users", "CASCADE", "NO ACTION",Arrays.asList("b_user"), Arrays.asList("uid")));
        final HashSet<TableInfo.Index> _indicesBudgetPlansDB = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBudgetPlansDB = new TableInfo("BudgetPlansDB", _columnsBudgetPlansDB, _foreignKeysBudgetPlansDB, _indicesBudgetPlansDB);
        final TableInfo _existingBudgetPlansDB = TableInfo.read(_db, "BudgetPlansDB");
        if (! _infoBudgetPlansDB.equals(_existingBudgetPlansDB)) {
          return new RoomOpenHelper.ValidationResult(false, "BudgetPlansDB(com.example.moneyway.localDB.BudgetPlansDB).\n"
                  + " Expected:\n" + _infoBudgetPlansDB + "\n"
                  + " Found:\n" + _existingBudgetPlansDB);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "836a3419e9d197af822033db37075e99", "71590cc7f5a6fb37a0ba0e43260baec4");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Users","SpendingsDataDB","BudgetPlansDB");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `Users`");
      _db.execSQL("DELETE FROM `SpendingsDataDB`");
      _db.execSQL("DELETE FROM `BudgetPlansDB`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SpendingsDataDBDao.class, SpendingsDataDBDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(BudgetPlansDBDao.class, BudgetPlansDBDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public SpendingsDataDBDao spendingsDao() {
    if (_spendingsDataDBDao != null) {
      return _spendingsDataDBDao;
    } else {
      synchronized(this) {
        if(_spendingsDataDBDao == null) {
          _spendingsDataDBDao = new SpendingsDataDBDao_Impl(this);
        }
        return _spendingsDataDBDao;
      }
    }
  }

  @Override
  public BudgetPlansDBDao budgetPlansDao() {
    if (_budgetPlansDBDao != null) {
      return _budgetPlansDBDao;
    } else {
      synchronized(this) {
        if(_budgetPlansDBDao == null) {
          _budgetPlansDBDao = new BudgetPlansDBDao_Impl(this);
        }
        return _budgetPlansDBDao;
      }
    }
  }
}
