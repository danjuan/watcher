package cmt.app.watcher.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cmt.app.watcher.model.Info;

public class DatabaseHelper<T> extends OrmLiteSqliteOpenHelper {
    private Map<String, Dao> daos = new HashMap();
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper instance;

    private DatabaseHelper(Context context) {
        super(context, getUserDatabaseName(), null, 1);
    }

    private static String getUserDatabaseName() {
        return "watcherdemo.db";
    }

    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Info.class);
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Info.class, true);
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

    }

    public static synchronized DatabaseHelper getHelper(Context context) {
        context = context.getApplicationContext();
        if(instance == null) {
            Class var1 = DatabaseHelper.class;
            synchronized(DatabaseHelper.class) {
                if(instance == null) {
                    instance = new DatabaseHelper(context);
                }
            }
        }

        return instance;
    }

    public synchronized Dao getDao(Class clazz) throws SQLException {
        Dao dao = null;
        String className = clazz.getSimpleName();
        if(this.daos.containsKey(className)) {
            dao = (Dao)this.daos.get(className);
        }

        if(dao == null) {
            dao = super.getDao(clazz);
            this.daos.put(className, dao);
        }

        return dao;
    }

    public void close() {
        super.close();
        instance = null;

        Dao dao;
        for(Iterator var1 = this.daos.keySet().iterator(); var1.hasNext(); dao = null) {
            String key = (String)var1.next();
            dao = (Dao)this.daos.get(key);
        }

    }
}
