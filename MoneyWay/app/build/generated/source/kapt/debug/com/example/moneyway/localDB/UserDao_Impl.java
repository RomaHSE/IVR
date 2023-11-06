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
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserInsert> __insertionAdapterOfUserInsertAsUser;

  private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  private final SharedSQLiteStatement __preparedStmtOfUpdateOnlineSt;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByUid;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUserData;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserInsertAsUser = new EntityInsertionAdapter<UserInsert>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Users` (`u_name`,`u_login`,`u_password`,`is_online`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserInsert value) {
        if (value.getU_name() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getU_name());
        }
        if (value.getU_login() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getU_login());
        }
        if (value.getU_password() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getU_password());
        }
        final int _tmp = value.is_online() ? 1 : 0;
        stmt.bindLong(4, _tmp);
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Users` WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getUid());
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
    this.__preparedStmtOfUpdateOnlineSt = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Users SET is_online=? WHERE uid=?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteByUid = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Users WHERE uid=?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateUserData = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Users SET u_name=?, u_login=?, u_password=? WHERE uid=?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final UserInsert uInsert) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUserInsertAsUser.insert(uInsert);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handle(user);
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
  public void updateOnlineSt(final int uid, final int setStatus) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateOnlineSt.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, setStatus);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, uid);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateOnlineSt.release(_stmt);
    }
  }

  @Override
  public void deleteByUid(final int userId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByUid.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, userId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteByUid.release(_stmt);
    }
  }

  @Override
  public void updateUserData(final String userName, final String userLogin,
      final String userPassword, final int userId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUserData.acquire();
    int _argIndex = 1;
    if (userName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, userName);
    }
    _argIndex = 2;
    if (userLogin == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, userLogin);
    }
    _argIndex = 3;
    if (userPassword == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, userPassword);
    }
    _argIndex = 4;
    _stmt.bindLong(_argIndex, userId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateUserData.release(_stmt);
    }
  }

  @Override
  public List<User> getAll() {
    final String _sql = "SELECT * FROM Users";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfUName = CursorUtil.getColumnIndexOrThrow(_cursor, "u_name");
      final int _cursorIndexOfULogin = CursorUtil.getColumnIndexOrThrow(_cursor, "u_login");
      final int _cursorIndexOfUPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "u_password");
      final int _cursorIndexOfIsOnline = CursorUtil.getColumnIndexOrThrow(_cursor, "is_online");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        final String _tmpU_name;
        if (_cursor.isNull(_cursorIndexOfUName)) {
          _tmpU_name = null;
        } else {
          _tmpU_name = _cursor.getString(_cursorIndexOfUName);
        }
        final String _tmpU_login;
        if (_cursor.isNull(_cursorIndexOfULogin)) {
          _tmpU_login = null;
        } else {
          _tmpU_login = _cursor.getString(_cursorIndexOfULogin);
        }
        final String _tmpU_password;
        if (_cursor.isNull(_cursorIndexOfUPassword)) {
          _tmpU_password = null;
        } else {
          _tmpU_password = _cursor.getString(_cursorIndexOfUPassword);
        }
        final boolean _tmpIs_online;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsOnline);
        _tmpIs_online = _tmp != 0;
        _item = new User(_tmpUid,_tmpU_name,_tmpU_login,_tmpU_password,_tmpIs_online);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<User> getOnline() {
    final String _sql = "SELECT * FROM Users WHERE is_online=1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfUName = CursorUtil.getColumnIndexOrThrow(_cursor, "u_name");
      final int _cursorIndexOfULogin = CursorUtil.getColumnIndexOrThrow(_cursor, "u_login");
      final int _cursorIndexOfUPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "u_password");
      final int _cursorIndexOfIsOnline = CursorUtil.getColumnIndexOrThrow(_cursor, "is_online");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        final String _tmpU_name;
        if (_cursor.isNull(_cursorIndexOfUName)) {
          _tmpU_name = null;
        } else {
          _tmpU_name = _cursor.getString(_cursorIndexOfUName);
        }
        final String _tmpU_login;
        if (_cursor.isNull(_cursorIndexOfULogin)) {
          _tmpU_login = null;
        } else {
          _tmpU_login = _cursor.getString(_cursorIndexOfULogin);
        }
        final String _tmpU_password;
        if (_cursor.isNull(_cursorIndexOfUPassword)) {
          _tmpU_password = null;
        } else {
          _tmpU_password = _cursor.getString(_cursorIndexOfUPassword);
        }
        final boolean _tmpIs_online;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsOnline);
        _tmpIs_online = _tmp != 0;
        _item = new User(_tmpUid,_tmpU_name,_tmpU_login,_tmpU_password,_tmpIs_online);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<User> getByIds(final int[] userIds) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM Users WHERE uid IN (");
    final int _inputSize = userIds.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(" )");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int _item : userIds) {
      _statement.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfUName = CursorUtil.getColumnIndexOrThrow(_cursor, "u_name");
      final int _cursorIndexOfULogin = CursorUtil.getColumnIndexOrThrow(_cursor, "u_login");
      final int _cursorIndexOfUPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "u_password");
      final int _cursorIndexOfIsOnline = CursorUtil.getColumnIndexOrThrow(_cursor, "is_online");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item_1;
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        final String _tmpU_name;
        if (_cursor.isNull(_cursorIndexOfUName)) {
          _tmpU_name = null;
        } else {
          _tmpU_name = _cursor.getString(_cursorIndexOfUName);
        }
        final String _tmpU_login;
        if (_cursor.isNull(_cursorIndexOfULogin)) {
          _tmpU_login = null;
        } else {
          _tmpU_login = _cursor.getString(_cursorIndexOfULogin);
        }
        final String _tmpU_password;
        if (_cursor.isNull(_cursorIndexOfUPassword)) {
          _tmpU_password = null;
        } else {
          _tmpU_password = _cursor.getString(_cursorIndexOfUPassword);
        }
        final boolean _tmpIs_online;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsOnline);
        _tmpIs_online = _tmp != 0;
        _item_1 = new User(_tmpUid,_tmpU_name,_tmpU_login,_tmpU_password,_tmpIs_online);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<User> getUserByLogin(final String search_login) {
    final String _sql = "SELECT * FROM Users WHERE u_login=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (search_login == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, search_login);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfUName = CursorUtil.getColumnIndexOrThrow(_cursor, "u_name");
      final int _cursorIndexOfULogin = CursorUtil.getColumnIndexOrThrow(_cursor, "u_login");
      final int _cursorIndexOfUPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "u_password");
      final int _cursorIndexOfIsOnline = CursorUtil.getColumnIndexOrThrow(_cursor, "is_online");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        final String _tmpU_name;
        if (_cursor.isNull(_cursorIndexOfUName)) {
          _tmpU_name = null;
        } else {
          _tmpU_name = _cursor.getString(_cursorIndexOfUName);
        }
        final String _tmpU_login;
        if (_cursor.isNull(_cursorIndexOfULogin)) {
          _tmpU_login = null;
        } else {
          _tmpU_login = _cursor.getString(_cursorIndexOfULogin);
        }
        final String _tmpU_password;
        if (_cursor.isNull(_cursorIndexOfUPassword)) {
          _tmpU_password = null;
        } else {
          _tmpU_password = _cursor.getString(_cursorIndexOfUPassword);
        }
        final boolean _tmpIs_online;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsOnline);
        _tmpIs_online = _tmp != 0;
        _item = new User(_tmpUid,_tmpU_name,_tmpU_login,_tmpU_password,_tmpIs_online);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
