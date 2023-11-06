package com.example.moneyway.localDB;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BudgetPlansDBDao_Impl implements BudgetPlansDBDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BudgetPlans> __insertionAdapterOfBudgetPlansAsBudgetPlansDB;

  private final EntityDeletionOrUpdateAdapter<BudgetPlansDB> __deletionAdapterOfBudgetPlansDB;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  private final SharedSQLiteStatement __preparedStmtOfUpdateInfo;

  public BudgetPlansDBDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBudgetPlansAsBudgetPlansDB = new EntityInsertionAdapter<BudgetPlans>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `BudgetPlansDB` (`b_sum`,`b_profit`,`b_restaurants`,`b_transport`,`b_goods`,`b_services`,`b_transactions`,`b_other`,`b_user`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BudgetPlans value) {
        stmt.bindLong(1, value.getB_sum());
        stmt.bindLong(2, value.getB_profit());
        stmt.bindLong(3, value.getB_restaurants());
        stmt.bindLong(4, value.getB_transport());
        stmt.bindLong(5, value.getB_goods());
        stmt.bindLong(6, value.getB_services());
        stmt.bindLong(7, value.getB_transactions());
        stmt.bindLong(8, value.getB_other());
        stmt.bindLong(9, value.getB_user());
      }
    };
    this.__deletionAdapterOfBudgetPlansDB = new EntityDeletionOrUpdateAdapter<BudgetPlansDB>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `BudgetPlansDB` WHERE `bid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BudgetPlansDB value) {
        stmt.bindLong(1, value.getBid());
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Users` SET `uid` = ?,`u_name` = ?,`u_login` = ?,`u_password` = ?,`is_online` = ? WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getUid());
        if (value.getU_name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getU_name());
        }
        if (value.getU_login() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getU_login());
        }
        if (value.getU_password() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getU_password());
        }
        final int _tmp = value.is_online() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        stmt.bindLong(6, value.getUid());
      }
    };
    this.__preparedStmtOfUpdateInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE BudgetPlansDB SET b_sum = ?, b_profit = ?, b_restaurants = ?, b_transport = ?, b_goods = ?, b_services = ?, b_transactions = ?, b_other = ? WHERE bid = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final BudgetPlans bInsert) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBudgetPlansAsBudgetPlansDB.insert(bInsert);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final BudgetPlansDB budget) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfBudgetPlansDB.handle(budget);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateInfo(final int bId, final int bSum, final int bProfit, final int bRestaurants,
      final int bTransport, final int bGoods, final int bServices, final int bTransactions,
      final int bOther) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateInfo.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, bSum);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, bProfit);
    _argIndex = 3;
    _stmt.bindLong(_argIndex, bRestaurants);
    _argIndex = 4;
    _stmt.bindLong(_argIndex, bTransport);
    _argIndex = 5;
    _stmt.bindLong(_argIndex, bGoods);
    _argIndex = 6;
    _stmt.bindLong(_argIndex, bServices);
    _argIndex = 7;
    _stmt.bindLong(_argIndex, bTransactions);
    _argIndex = 8;
    _stmt.bindLong(_argIndex, bOther);
    _argIndex = 9;
    _stmt.bindLong(_argIndex, bId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateInfo.release(_stmt);
    }
  }

  @Override
  public List<BudgetPlansDB> getAll() {
    final String _sql = "SELECT * FROM BudgetPlansDB";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBid = CursorUtil.getColumnIndexOrThrow(_cursor, "bid");
      final int _cursorIndexOfBSum = CursorUtil.getColumnIndexOrThrow(_cursor, "b_sum");
      final int _cursorIndexOfBProfit = CursorUtil.getColumnIndexOrThrow(_cursor, "b_profit");
      final int _cursorIndexOfBRestaurants = CursorUtil.getColumnIndexOrThrow(_cursor, "b_restaurants");
      final int _cursorIndexOfBTransport = CursorUtil.getColumnIndexOrThrow(_cursor, "b_transport");
      final int _cursorIndexOfBGoods = CursorUtil.getColumnIndexOrThrow(_cursor, "b_goods");
      final int _cursorIndexOfBServices = CursorUtil.getColumnIndexOrThrow(_cursor, "b_services");
      final int _cursorIndexOfBTransactions = CursorUtil.getColumnIndexOrThrow(_cursor, "b_transactions");
      final int _cursorIndexOfBOther = CursorUtil.getColumnIndexOrThrow(_cursor, "b_other");
      final int _cursorIndexOfBUser = CursorUtil.getColumnIndexOrThrow(_cursor, "b_user");
      final List<BudgetPlansDB> _result = new ArrayList<BudgetPlansDB>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BudgetPlansDB _item;
        final int _tmpBid;
        _tmpBid = _cursor.getInt(_cursorIndexOfBid);
        final int _tmpB_sum;
        _tmpB_sum = _cursor.getInt(_cursorIndexOfBSum);
        final int _tmpB_profit;
        _tmpB_profit = _cursor.getInt(_cursorIndexOfBProfit);
        final int _tmpB_restaurants;
        _tmpB_restaurants = _cursor.getInt(_cursorIndexOfBRestaurants);
        final int _tmpB_transport;
        _tmpB_transport = _cursor.getInt(_cursorIndexOfBTransport);
        final int _tmpB_goods;
        _tmpB_goods = _cursor.getInt(_cursorIndexOfBGoods);
        final int _tmpB_services;
        _tmpB_services = _cursor.getInt(_cursorIndexOfBServices);
        final int _tmpB_transactions;
        _tmpB_transactions = _cursor.getInt(_cursorIndexOfBTransactions);
        final int _tmpB_other;
        _tmpB_other = _cursor.getInt(_cursorIndexOfBOther);
        final int _tmpB_user;
        _tmpB_user = _cursor.getInt(_cursorIndexOfBUser);
        _item = new BudgetPlansDB(_tmpBid,_tmpB_sum,_tmpB_profit,_tmpB_restaurants,_tmpB_transport,_tmpB_goods,_tmpB_services,_tmpB_transactions,_tmpB_other,_tmpB_user);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<BudgetPlansDB> getByBid(final int[] budget_id) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM BudgetPlansDB WHERE bid IN (");
    final int _inputSize = budget_id.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int _item : budget_id) {
      _statement.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBid = CursorUtil.getColumnIndexOrThrow(_cursor, "bid");
      final int _cursorIndexOfBSum = CursorUtil.getColumnIndexOrThrow(_cursor, "b_sum");
      final int _cursorIndexOfBProfit = CursorUtil.getColumnIndexOrThrow(_cursor, "b_profit");
      final int _cursorIndexOfBRestaurants = CursorUtil.getColumnIndexOrThrow(_cursor, "b_restaurants");
      final int _cursorIndexOfBTransport = CursorUtil.getColumnIndexOrThrow(_cursor, "b_transport");
      final int _cursorIndexOfBGoods = CursorUtil.getColumnIndexOrThrow(_cursor, "b_goods");
      final int _cursorIndexOfBServices = CursorUtil.getColumnIndexOrThrow(_cursor, "b_services");
      final int _cursorIndexOfBTransactions = CursorUtil.getColumnIndexOrThrow(_cursor, "b_transactions");
      final int _cursorIndexOfBOther = CursorUtil.getColumnIndexOrThrow(_cursor, "b_other");
      final int _cursorIndexOfBUser = CursorUtil.getColumnIndexOrThrow(_cursor, "b_user");
      final List<BudgetPlansDB> _result = new ArrayList<BudgetPlansDB>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BudgetPlansDB _item_1;
        final int _tmpBid;
        _tmpBid = _cursor.getInt(_cursorIndexOfBid);
        final int _tmpB_sum;
        _tmpB_sum = _cursor.getInt(_cursorIndexOfBSum);
        final int _tmpB_profit;
        _tmpB_profit = _cursor.getInt(_cursorIndexOfBProfit);
        final int _tmpB_restaurants;
        _tmpB_restaurants = _cursor.getInt(_cursorIndexOfBRestaurants);
        final int _tmpB_transport;
        _tmpB_transport = _cursor.getInt(_cursorIndexOfBTransport);
        final int _tmpB_goods;
        _tmpB_goods = _cursor.getInt(_cursorIndexOfBGoods);
        final int _tmpB_services;
        _tmpB_services = _cursor.getInt(_cursorIndexOfBServices);
        final int _tmpB_transactions;
        _tmpB_transactions = _cursor.getInt(_cursorIndexOfBTransactions);
        final int _tmpB_other;
        _tmpB_other = _cursor.getInt(_cursorIndexOfBOther);
        final int _tmpB_user;
        _tmpB_user = _cursor.getInt(_cursorIndexOfBUser);
        _item_1 = new BudgetPlansDB(_tmpBid,_tmpB_sum,_tmpB_profit,_tmpB_restaurants,_tmpB_transport,_tmpB_goods,_tmpB_services,_tmpB_transactions,_tmpB_other,_tmpB_user);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getBidByUid(final int uId) {
    final String _sql = "SELECT bid FROM BudgetPlansDB WHERE b_user = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, uId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<BudgetPlansDB> getByUid(final int userId) {
    final String _sql = "SELECT * FROM BudgetPlansDB WHERE b_user=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBid = CursorUtil.getColumnIndexOrThrow(_cursor, "bid");
      final int _cursorIndexOfBSum = CursorUtil.getColumnIndexOrThrow(_cursor, "b_sum");
      final int _cursorIndexOfBProfit = CursorUtil.getColumnIndexOrThrow(_cursor, "b_profit");
      final int _cursorIndexOfBRestaurants = CursorUtil.getColumnIndexOrThrow(_cursor, "b_restaurants");
      final int _cursorIndexOfBTransport = CursorUtil.getColumnIndexOrThrow(_cursor, "b_transport");
      final int _cursorIndexOfBGoods = CursorUtil.getColumnIndexOrThrow(_cursor, "b_goods");
      final int _cursorIndexOfBServices = CursorUtil.getColumnIndexOrThrow(_cursor, "b_services");
      final int _cursorIndexOfBTransactions = CursorUtil.getColumnIndexOrThrow(_cursor, "b_transactions");
      final int _cursorIndexOfBOther = CursorUtil.getColumnIndexOrThrow(_cursor, "b_other");
      final int _cursorIndexOfBUser = CursorUtil.getColumnIndexOrThrow(_cursor, "b_user");
      final List<BudgetPlansDB> _result = new ArrayList<BudgetPlansDB>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BudgetPlansDB _item;
        final int _tmpBid;
        _tmpBid = _cursor.getInt(_cursorIndexOfBid);
        final int _tmpB_sum;
        _tmpB_sum = _cursor.getInt(_cursorIndexOfBSum);
        final int _tmpB_profit;
        _tmpB_profit = _cursor.getInt(_cursorIndexOfBProfit);
        final int _tmpB_restaurants;
        _tmpB_restaurants = _cursor.getInt(_cursorIndexOfBRestaurants);
        final int _tmpB_transport;
        _tmpB_transport = _cursor.getInt(_cursorIndexOfBTransport);
        final int _tmpB_goods;
        _tmpB_goods = _cursor.getInt(_cursorIndexOfBGoods);
        final int _tmpB_services;
        _tmpB_services = _cursor.getInt(_cursorIndexOfBServices);
        final int _tmpB_transactions;
        _tmpB_transactions = _cursor.getInt(_cursorIndexOfBTransactions);
        final int _tmpB_other;
        _tmpB_other = _cursor.getInt(_cursorIndexOfBOther);
        final int _tmpB_user;
        _tmpB_user = _cursor.getInt(_cursorIndexOfBUser);
        _item = new BudgetPlansDB(_tmpBid,_tmpB_sum,_tmpB_profit,_tmpB_restaurants,_tmpB_transport,_tmpB_goods,_tmpB_services,_tmpB_transactions,_tmpB_other,_tmpB_user);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public void deleteByBid(final int[] budgetId) {
    __db.assertNotSuspendingTransaction();
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("DELETE FROM BudgetPlansDB WHERE bid IN(");
    final int _inputSize = budgetId.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final SupportSQLiteStatement _stmt = __db.compileStatement(_sql);
    int _argIndex = 1;
    for (int _item : budgetId) {
      _stmt.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
