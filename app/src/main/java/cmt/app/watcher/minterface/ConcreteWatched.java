package cmt.app.watcher.minterface;

import java.util.ArrayList;

import cmt.app.watcher.MyApp;
import cmt.app.watcher.utils.ListUtils;

public class ConcreteWatched implements BeWatched {
    public ConcreteWatched() {
    }

    public void addWatcher(Watcher watcher) {
        ArrayList concreteWatched_list = MyApp.getInstance().getConcreteWatched_list();
        if(!concreteWatched_list.contains(watcher)) {
            MyApp.getInstance().getConcreteWatched_list().add(watcher);
        }

    }

    public void removeWatcher(Watcher watcher) {
        MyApp.getInstance().getConcreteWatched_list().remove(watcher);
    }

    public void notifyWatchers(boolean b) {
        ArrayList concreteWatched_list = MyApp.getInstance().getConcreteWatched_list();
        if(!ListUtils.isEmpty(concreteWatched_list)) {
            for(int i = 0; i < concreteWatched_list.size(); ++i) {
                ((Watcher)concreteWatched_list.get(i)).updata(b);
            }
        }

    }
}
