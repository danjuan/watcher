package cmt.app.watcher.db;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import cmt.app.watcher.MyApp;
import cmt.app.watcher.model.Info;

public class InfoDao {
    private DatabaseHelper helper;
    private Dao<Info, Integer> helperDao;

    public InfoDao(Context context, Class clazz) {
        try {
            this.helper = DatabaseHelper.getHelper(context);
            this.helperDao = this.helper.getDao(clazz);
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public void add(Info info) {
        try {
            this.helperDao.create(info);
            MyApp.getInstance().getConcreteWatched().notifyWatchers(true);
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public List<Info> queryAll() {
        try {
            return this.helperDao.queryForAll();
        } catch (SQLException var2) {
            var2.printStackTrace();
            return null;
        }
    }
}
