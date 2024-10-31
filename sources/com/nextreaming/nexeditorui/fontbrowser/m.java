package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.fonts.Font;
import java.util.List;

/* compiled from: FontListAdapter.java */
/* loaded from: classes2.dex */
public class m extends BaseAdapter {

    /* renamed from: a */
    public int f24280a = 100;

    /* renamed from: b */
    private Context f24281b;

    /* renamed from: c */
    private List<Font> f24282c;

    public m(Context context, List<Font> list) {
        this.f24281b = context;
        this.f24282c = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f24282c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f24282c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.f24281b.getSystemService("layout_inflater")).inflate(R.layout.panel_font_browser_font_item, (ViewGroup) null);
        }
        ListView listView = (ListView) viewGroup;
        Font font = (Font) getItem(i);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView_font_thumbnail);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar_font_download);
        view.setTag(font.getId());
        view.setOnClickListener(new k(this, listView, i));
        view.setOnLongClickListener(new l(this, listView, i));
        Bitmap a2 = font.a(this.f24281b);
        if (a2 != null) {
            imageView.setImageBitmap(a2);
        }
        progressBar.setVisibility(8);
        return view;
    }
}
