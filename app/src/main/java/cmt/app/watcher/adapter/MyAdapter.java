package cmt.app.watcher.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cmt.app.watcher.MainActivity;
import cmt.app.watcher.R;
import cmt.app.watcher.model.Info;
import cmt.app.watcher.utils.ListUtils;
import cmt.app.watcher.utils.ViewHolder;

/**
 * Created by caimantang on 16/5/30.
 */
public class MyAdapter extends BaseAdapter {
    private MainActivity mContext;
    private  List<Info> list;

    public MyAdapter(MainActivity mainActivity) {
        this.mContext = mainActivity;
        this.list = new ArrayList();
    }

    public int getCount() {
        return !ListUtils.isEmpty(this.list) ? this.list.size() : 0;
    }

    public Info getItem(int position) {
        return !ListUtils.isEmpty(this.list) ? (Info) this.list.get(position) : null;
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(this.mContext, R.layout.item,null);
        }

        TextView tv_name = (TextView) ViewHolder.get(convertView, R.id.tv_name);
        tv_name.setText(this.getItem(position).getName());
        return convertView;
    }

    public void resetData(List<Info> infos) {
        this.list.clear();
        if (!ListUtils.isEmpty(infos)) {
            this.list.addAll(infos);
        }

        this.notifyDataSetChanged();
    }
}
