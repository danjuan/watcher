package cmt.app.watcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import cmt.app.watcher.adapter.MyAdapter;
import cmt.app.watcher.db.InfoDao;
import cmt.app.watcher.minterface.Watcher;
import cmt.app.watcher.model.Info;
import cmt.app.watcher.utils.TimeUtils;

public class MainActivity extends AppCompatActivity implements Watcher, View.OnClickListener {
    private InfoDao infoDao;
    private ListView listview;
    private MyAdapter adapter;
    private Button btn;

    public MainActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        MyApp.getInstance().getConcreteWatched().addWatcher(this);
        btn = (Button) this.findViewById(R.id.btn);
        btn.setOnClickListener(this);
        listview = (ListView) this.findViewById(R.id.listview);
        adapter = new MyAdapter(this);
        listview.setAdapter(this.adapter);
        infoDao = new InfoDao(this, Info.class);
    }

    public void updata(boolean b) {
        if (b) {
            List infos = this.infoDao.queryAll();
            this.adapter.resetData(infos);
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                Info info = new Info();
                info.setId(System.currentTimeMillis() + "");
                info.setName("添加一条数据" + TimeUtils.ToDate(System.currentTimeMillis() + ""));
                infoDao.add(info);
                break;
        }
    }
}
