package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.List;

/* compiled from: GroupAdapter.kt */
/* loaded from: classes.dex */
public final class w extends BaseAdapter {

    /* renamed from: a */
    private List<? extends s> f21487a;

    /* renamed from: b */
    private final boolean f21488b;

    /* renamed from: c */
    private final boolean f21489c;

    /* compiled from: GroupAdapter.kt */
    /* loaded from: classes.dex */
    private final class a {

        /* renamed from: a */
        private TextView f21490a;

        /* renamed from: b */
        private TextView f21491b;

        public a() {
        }

        public final TextView a() {
            return this.f21491b;
        }

        public final TextView b() {
            return this.f21490a;
        }

        public final void a(TextView textView) {
            this.f21491b = textView;
        }

        public final void b(TextView textView) {
            this.f21490a = textView;
        }
    }

    public w(List<? extends s> list, boolean z, boolean z2) {
        this.f21487a = list;
        this.f21488b = z;
        this.f21489c = z2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<? extends s> list = this.f21487a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        s sVar;
        List<? extends s> list = this.f21487a;
        if (list == null || (sVar = list.get(i)) == null) {
            return 0L;
        }
        return sVar.b();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        TextView b2;
        String str;
        TextView b3;
        Context context;
        Resources resources;
        TextView a2;
        if (view == null) {
            view = viewGroup != null ? LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.n2_amediabrowser_album_text, viewGroup, false) : null;
            aVar = new a();
            aVar.b(view != null ? (TextView) view.findViewById(R.id.NoOfTracks) : null);
            aVar.a(view != null ? (TextView) view.findViewById(R.id.tv_song_name) : null);
            if (view != null) {
                view.setTag(aVar);
            }
        } else {
            Object tag = view != null ? view.getTag() : null;
            if (!(tag instanceof a)) {
                tag = null;
            }
            aVar = (a) tag;
        }
        List<? extends s> list = this.f21487a;
        s sVar = list != null ? list.get(i) : null;
        if (aVar != null && (a2 = aVar.a()) != null) {
            a2.setText(sVar != null ? sVar.a() : null);
        }
        if (this.f21488b) {
            Integer valueOf = sVar != null ? Integer.valueOf(sVar.c()) : null;
            if (valueOf != null) {
                int intValue = valueOf.intValue();
                if (viewGroup == null || (context = viewGroup.getContext()) == null || (resources = context.getResources()) == null || (str = resources.getQuantityString(R.plurals.audiobrowser_track_count, intValue, Integer.valueOf(intValue))) == null) {
                    str = "";
                }
                if (aVar != null && (b3 = aVar.b()) != null) {
                    b3.setText(str);
                }
            }
            if (aVar != null && (b2 = aVar.b()) != null) {
                b2.setVisibility(0);
            }
        }
        if (view != null) {
            return view;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // android.widget.Adapter
    public s getItem(int i) {
        List<? extends s> list = this.f21487a;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }
}
