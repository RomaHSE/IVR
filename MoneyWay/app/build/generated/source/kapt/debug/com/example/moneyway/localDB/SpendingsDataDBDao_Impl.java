package com.example.moneyway.localDB;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
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
public final class SpendingsDataDBDao_Impl implements SpendingsDataDBDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SpendingsDataDBInsert> __insertionAdapterOfSpendingsDataDBInsertAsSpendingsDataDB;

  private final EntityDeletionOrUpdateAdapter<SpendingsDataDB> __deletionAdapterOfSpendingsDataDB;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  public SpendingsDataDBDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSpendingsDataDBInsertAsSpendingsDataDB = new EntityInsertionAdapter<SpendingsDataDBInsert>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `SpendingsDataDB` (`s_amount`,`s_type`,`s_date`,`s_description`,`s_user`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SpendingsDataDBInsert value) {
        stmt.bindLong(1, value.getS_amount());
        if (value.getS_type() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getS_type());
        }
        if (value.getS_date() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getS_date());
        }
        if (value.getS_description() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getS_description());
        }
        if (value.getS_user() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getS_user());
        }
      }
    };
    this.__deletionAdapterOfSpendingsDataDB = new EntityDeletionOrUpdateAdapter<SpendingsDataDB>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `SpendingsDataDB` WHERE `sid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SpendingsDataDB value) {
        stmt.bindLong(1, value.getSid());
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
  }

  @Override
  public void insert(final SpendingsDataDBInsert sInsert) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSpendingsDataDBInsertAsSpendingsDataDB.insert(sInsert);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final SpendingsDataDB spending) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSpendingsDataDB.handle(spending);
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
  public List<SpendingsDataDB> getAll() {
    final String _sql = "SELECT * FROM SpendingsDataDB";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSid = CursorUtil.getColumnIndexOrThrow(_cursor, "sid");
      final int _cursorIndexOfSAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "s_amount");
      final int _cursorIndexOfSType = CursorUtil.getColumnIndexOrThrow(_cursor, "s_type");
      final int _cursorIndexOfSDate = CursorUtil.getColumnIndexOrThrow(_cursor, "s_date");
      final int _cursorIndexOfSDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "s_description");
      final int _cursorIndexOfSUser = CursorUtil.getColumnIndexOrThrow(_cursor, "s_user");
      final List<SpendingsDataDB> _result = new ArrayList<SpendingsDataDB>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SpendingsDataDB _item;
        final int _tmpSid;
        _tmpSid = _cursor.getInt(_cursorIndexOfSid);
        final int _tmpS_amount;
        _tmpS_amount = _cursor.getInt(_cursorIndexOfSAmount);
        final String _tmpS_type;
        if (_cursor.isNull(_cursorIndexOfSType)) {
          _tmpS_type = null;
        } else {
          _tmpS_type = _cursor.getString(_cursorIndexOfSType);
        }
        final String _tmpS_date;
        if (_cursor.isNull(_cursorIndexOfSDate)) {
          _tmpS_date = null;
        } else {
          _tmpS_date = _cursor.getString(_cursorIndexOfSDate);
        }
        final String _tmpS_description;
        if (_cursor.isNull(_cursorIndexOfSDescription)) {
          _tmpS_description = null;
        } else {
          _tmpS_description = _cursor.getString(_cursorIndexOfSDescription);
        }
        final int _tmpS_user;
        _tmpS_user = _cursor.getInt(_cursorIndexOfSUser);
        _item = new SpendingsDataDB(_tmpSid,_tmpS_amount,_tmpS_type,_tmpS_date,_tmpS_description,_tmpS_user);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<SpendingsDataDB> getBySid(final int[] spendingsId) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM SpendingsDataDB WHERE sid IN (");
    final int _inputSize = spendingsId.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int _item : spendingsId) {
      _statement.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSid = CursorUtil.getColumnIndexOrThrow(_cursor, "sid");
      final int _cursorIndexOfSAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "s_amount");
      final int _cursorIndexOfSType = CursorUtil.getColumnIndexOrThrow(_cursor, "s_type");
      final int _cursorIndexOfSDate = CursorUtil.getColumnIndexOrThrow(_cursor, "s_date");
      final int _cursorIndexOfSDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "s_description");
      final int _cursorIndexOfSUser = CursorUtil.getColumnIndexOrThrow(_cursor, "s_user");
      final List<SpendingsDataDB> _result = new ArrayList<SpendingsDataDB>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SpendingsDataDB _item_1;
        final int _tmpSid;
        _tmpSid = _cursor.getInt(_cursorIndexOfSid);
        final int _tmpS_amount;
        _tmpS_amount = _cursor.getInt(_cursorIndexOfSAmount);
        final String _tmpS_type;
        if (_cursor.isNull(_cursorIndexOfSType)) {
          _tmpS_type = null;
        } else {
          _tmpS_type = _cursor.getString(_cursorIndexOfSType);
        }
        final String _tmpS_date;
        if (_cursor.isNull(_cursorIndexOfSDate)) {
          _tmpS_date = null;
        } else {
          _tmpS_date = _cursor.getString(_cursorIndexOfSDate);
        }
        final String _tmpS_description;
        if (_cursor.isNull(_cursorIndexOfSDescription)) {
          _tmpS_description = null;
        } else {
          _tmpS_description = _cursor.getString(_cursorIndexOfSDescription);
        }
        final int _tmpS_user;
        _tmpS_user = _cursor.getInt(_cursorIndexOfSUser);
        _item_1 = new SpendingsDataDB(_tmpSid,_tmpS_amount,_tmpS_type,_tmpS_date,_tmpS_description,_tmpS_user);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<SpendingsDataDB> getByUid(final int userId) {
    final String _sql = "SELECT * FROM SpendingsDataDB WHERE s_user=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSid = CursorUtil.getColumnIndexOrThrow(_cursor, "sid");
      final int _cursorIndexOfSAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "s_amount");
      final int _cursorIndexOfSType = CursorUtil.getColumnIndexOrThrow(_cursor, "s_type");
      final int _cursorIndexOfSDate = CursorUtil.getColumnIndexOrThrow(_cursor, "s_date");
      final int _cursorIndexOfSDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "s_description");
      final int _cursorIndexOfSUser = CursorUtil.getColumnIndexOrThrow(_cursor, "s_user");
      final List<SpendingsDataDB> _result = new ArrayList<SpendingsDataDB>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SpendingsDataDB _item;
        final int _tmpSid;
        _tmpSid = _cursor.getInt(_cursorIndexOfSid);
        final int _tmpS_amount;
        _tmpS_amount = _cursor.getInt(_cursorIndexOfSAmount);
        final String _tmpS_type;
        if (_cursor.isNull(_cursorIndexOfSType)) {
          _tmpS_type = null;
        } else {
          _tmpS_type = _cursor.getString(_cursorIndexOfSType);
        }
        final String _tmpS_date;
        if (_cursor.isNull(_cursorIndexOfSDate)) {
          _tmpS_date = null;
        } else {
          _tmpS_date = _cursor.getString(_cursorIndexOfSDate);
        }
        final String _tmpS_description;
        if (_cursor.isNull(_cursorIndexOfSDescription)) {
          _tmpS_description = null;
        } else {
          _tmpS_description = _cursor.getString(_cursorIndexOfSDescription);
        }
        final int _tmpS_user;
        _tmpS_user = _cursor.getInt(_cursorIndexOfSUser);
        _item = new SpendingsDataDB(_tmpSid,_tmpS_amount,_tmpS_type,_tmpS_date,_tmpS_description,_tmpS_user);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public void deleteBySid(final int[] spendingsId) {
    __db.assertNotSuspendingTransaction();
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("DELETE FROM SpendingsDataDB WHERE sid IN(");
    final int _inputSize = spendingsId.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final SupportSQLiteStatement _stmt = __db.compileStatement(_sql);
    int _argIndex = 1;
    for (int _item : spendingsId) {
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
