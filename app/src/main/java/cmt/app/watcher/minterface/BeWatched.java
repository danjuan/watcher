package cmt.app.watcher.minterface;

public interface BeWatched {
    void addWatcher(Watcher var1);

    void removeWatcher(Watcher var1);

    void notifyWatchers(boolean var1);
}
