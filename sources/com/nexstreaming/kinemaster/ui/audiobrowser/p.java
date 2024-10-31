package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.List;

/* compiled from: GroupAdapter.java */
/* loaded from: classes.dex */
public class p extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private List<l> f3682a;
    private boolean b;

    public p(List<l> list, boolean z) {
        this.f3682a = list;
        this.b = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3682a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f3682a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.f3682a.get(i).b();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        l lVar = this.f3682a.get(i);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.n2_amediabrowser_album_text, viewGroup, false);
        }
        ((TextView) view.findViewById(R.id.AlbumName)).setText(lVar.a());
        if (this.b) {
            int c = lVar.c();
            String quantityString = viewGroup.getContext().getResources().getQuantityString(R.plurals.audiobrowser_track_count, c, Integer.valueOf(c));
            ((TextView) view.findViewById(R.id.NoOfTracks)).setVisibility(0);
            ((TextView) view.findViewById(R.id.NoOfTracks)).setText(quantityString);
        }
        return view;
    }
}
