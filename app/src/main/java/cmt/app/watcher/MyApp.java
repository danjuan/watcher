package cmt.app.watcher;

import android.app.Application;

import java.util.ArrayList;

import cmt.app.watcher.minterface.ConcreteWatched;
import cmt.app.watcher.minterface.Watcher;

public class MyApp extends Application {
    private ArrayList<Watcher> concreteWatched_list;
    private static MyApp instance;
    private ConcreteWatched concreteWatched;

    public MyApp() {
    }

    public void onCreate() {
        super.onCreate();
        instance = this;
        this.concreteWatched_list = new ArrayList();
        this.concreteWatched = new ConcreteWatched();
    }

    public static MyApp getInstance() {
        return instance;
    }

    public ArrayList<Watcher> getConcreteWatched_list() {
        return this.concreteWatched_list;
    }

    public ConcreteWatched getConcreteWatched() {
        return this.concreteWatched;
    }
}
