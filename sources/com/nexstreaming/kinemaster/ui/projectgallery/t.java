package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.io.File;
import java.util.List;

/* compiled from: ExportFileListActivity.java */
/* loaded from: classes.dex */
class t extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExportFileListActivity f4221a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ExportFileListActivity exportFileListActivity) {
        this.f4221a = exportFileListActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        list = this.f4221a.c;
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List list;
        list = this.f4221a.c;
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        List list;
        com.nexstreaming.kinemaster.project.f e;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        View.OnClickListener onClickListener3;
        list = this.f4221a.c;
        File file = (File) list.get(i);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.export_file_list_item, viewGroup, false);
        }
        e = this.f4221a.e();
        if (e != null && file.exists()) {
            String str = " / " + this.f4221a.getResources().getString(R.string.export_actual_size, Float.valueOf((((float) file.length()) / 1024.0f) / 1024.0f));
        }
        ((TextView) view.findViewById(R.id.qualityLabel)).setText("Medium Definition");
        ((TextView) view.findViewById(R.id.qualityDetails)).setText("1280*720 / 150MB / 2015-10-13 ");
        view.findViewById(R.id.filePlayButton).setTag(Integer.valueOf(i));
        view.findViewById(R.id.fileShareButton).setTag(Integer.valueOf(i));
        view.findViewById(R.id.fileDeleteButton).setTag(Integer.valueOf(i));
        View findViewById = view.findViewById(R.id.filePlayButton);
        onClickListener = this.f4221a.g;
        findViewById.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(R.id.fileShareButton);
        onClickListener2 = this.f4221a.g;
        findViewById2.setOnClickListener(onClickListener2);
        View findViewById3 = view.findViewById(R.id.fileDeleteButton);
        onClickListener3 = this.f4221a.g;
        findViewById3.setOnClickListener(onClickListener3);
        return view;
    }
}
