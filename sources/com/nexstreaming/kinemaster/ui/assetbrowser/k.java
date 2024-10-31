package com.nexstreaming.kinemaster.ui.assetbrowser;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import c.e.a.a.d;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nexstreaming.app.general.util.J;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;

/* compiled from: AssetChildAdapter.kt */
/* loaded from: classes.dex */
public final class k extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public static final b f21386a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private c.e.a.a.f f21387b;

    /* renamed from: c, reason: collision with root package name */
    private int f21388c = -1;

    /* renamed from: d, reason: collision with root package name */
    private List<? extends r> f21389d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private boolean f21390e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f21391f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f21392g;

    /* compiled from: AssetChildAdapter.kt */
    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private ImageView f21393a;

        /* renamed from: b, reason: collision with root package name */
        private View f21394b;

        /* renamed from: c, reason: collision with root package name */
        private TextView f21395c;

        public final ImageView a() {
            return this.f21393a;
        }

        public final TextView b() {
            return this.f21395c;
        }

        public final View c() {
            return this.f21394b;
        }

        public final void a(ImageView imageView) {
            this.f21393a = imageView;
        }

        public final void a(View view) {
            this.f21394b = view;
        }

        public final void a(TextView textView) {
            this.f21395c = textView;
        }
    }

    /* compiled from: AssetChildAdapter.kt */
    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public k(Context context, boolean z, FragmentManager fragmentManager) {
        this.f21391f = context;
        this.f21392g = z;
        if (this.f21387b == null) {
            this.f21387b = new j(this, this.f21391f);
            d.a aVar = new d.a(this.f21391f, "ITEM_INFO_CACHE");
            c.e.a.a.f fVar = this.f21387b;
            if (fVar != null) {
                fVar.a(fragmentManager, aVar);
            }
        }
    }

    public final boolean b() {
        return this.f21390e;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<? extends r> list = this.f21389d;
        if (list != null) {
            return list.size();
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<? extends r> list = this.f21389d;
        if (list != null) {
            return list.get(i);
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        TextView b2;
        kotlin.jvm.internal.h.b(viewGroup, "parent");
        if (view == null) {
            if (this.f21392g) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.asset_grid_title_item, viewGroup, false);
                aVar = new a();
                aVar.a((ImageView) view.findViewById(R.id.assetImageView));
                aVar.a(view.findViewById(R.id.selectView));
                aVar.a((TextView) view.findViewById(R.id.asset_name));
            } else {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.asset_grid_item, viewGroup, false);
                aVar = new a();
                aVar.a((ImageView) view.findViewById(R.id.assetImageView));
                aVar.a(view.findViewById(R.id.selectView));
            }
            kotlin.jvm.internal.h.a((Object) view, "holderView");
            view.setTag(aVar);
        } else {
            Object tag = view.getTag();
            if (tag == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.ui.assetbrowser.AssetChildAdapter.AssetViewHolder");
            }
            aVar = (a) tag;
        }
        List<? extends r> list = this.f21389d;
        if (list != null) {
            r rVar = list.get(i);
            if (this.f21392g && (b2 = aVar.b()) != null) {
                b2.setText(J.a(viewGroup.getContext(), rVar.getLabel()));
            }
            c.e.a.a.f fVar = this.f21387b;
            if (fVar != null) {
                fVar.a(rVar, aVar.a(), R.drawable.n2_loading_image_1_img);
            }
            View c2 = aVar.c();
            if (c2 != null) {
                c2.setSelected(this.f21388c == i);
            }
            View c3 = aVar.c();
            if (c3 != null) {
                c3.setVisibility(this.f21390e ? 8 : 0);
            }
            ImageView a2 = aVar.a();
            if (a2 != null) {
                a2.setEnabled(!this.f21390e);
            }
            TextView b3 = aVar.b();
            if (b3 != null) {
                b3.setEnabled(!this.f21390e);
            }
            return view;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    public final int a() {
        return this.f21388c;
    }

    public final void a(int i) {
        this.f21388c = i;
        notifyDataSetInvalidated();
    }

    public final void a(boolean z) {
        this.f21390e = z;
        notifyDataSetChanged();
    }

    public final void a(List<? extends r> list) {
        kotlin.jvm.internal.h.b(list, "list");
        ArrayList arrayList = new ArrayList();
        for (r rVar : list) {
            if (!rVar.isHidden()) {
                arrayList.add(rVar);
            }
        }
        this.f21389d = arrayList;
        notifyDataSetInvalidated();
    }
}
