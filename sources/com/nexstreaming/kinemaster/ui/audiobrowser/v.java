package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: CategoryAdapter.kt */
/* loaded from: classes.dex */
public final class v extends BaseAdapter {

    /* renamed from: a */
    private AudioCategory[] f21483a;

    /* compiled from: CategoryAdapter.kt */
    /* loaded from: classes.dex */
    private final class a {

        /* renamed from: a */
        private ImageView f21484a;

        /* renamed from: b */
        private TextView f21485b;

        public a() {
        }

        public final ImageView a() {
            return this.f21484a;
        }

        public final TextView b() {
            return this.f21485b;
        }

        public final void a(ImageView imageView) {
            this.f21484a = imageView;
        }

        public final void a(TextView textView) {
            this.f21485b = textView;
        }
    }

    public v(AudioCategory[] audioCategoryArr) {
        kotlin.jvm.internal.h.b(audioCategoryArr, "categories");
        this.f21483a = audioCategoryArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f21483a.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f21483a[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.f21483a[i].label_id;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        TextView b2;
        ImageView a2;
        if (view == null) {
            view = viewGroup != null ? LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.n2_amediabrowser_cat_text, viewGroup, false) : null;
            aVar = new a();
            aVar.a(view != null ? (TextView) view.findViewById(R.id.sfx) : null);
            aVar.a(view != null ? (ImageView) view.findViewById(R.id.iconView) : null);
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
        AudioCategory audioCategory = this.f21483a[i];
        if (aVar != null && (a2 = aVar.a()) != null) {
            a2.setImageResource(audioCategory.icon_id);
        }
        if (aVar != null && (b2 = aVar.b()) != null) {
            b2.setText(audioCategory.label_id);
            c.d.b.m.n.a(b2, 6, 15);
        }
        if (view != null) {
            return view;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }
}
