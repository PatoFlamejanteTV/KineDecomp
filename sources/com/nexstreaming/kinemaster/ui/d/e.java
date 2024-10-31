package com.nexstreaming.kinemaster.ui.d;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;

/* compiled from: OptionChildAdapter.kt */
/* loaded from: classes.dex */
public final class e extends BaseAdapter {

    /* renamed from: a */
    public static final b f21537a = new b(null);

    /* renamed from: b */
    private int f21538b = -1;

    /* renamed from: c */
    private List<? extends f> f21539c = new ArrayList();

    /* renamed from: d */
    private boolean f21540d;

    /* renamed from: e */
    private final Context f21541e;

    /* renamed from: f */
    private final boolean f21542f;

    /* compiled from: OptionChildAdapter.kt */
    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a */
        private ImageView f21543a;

        /* renamed from: b */
        private View f21544b;

        /* renamed from: c */
        private TextView f21545c;

        public final ImageView a() {
            return this.f21543a;
        }

        public final TextView b() {
            return this.f21545c;
        }

        public final View c() {
            return this.f21544b;
        }

        public final void a(ImageView imageView) {
            this.f21543a = imageView;
        }

        public final void a(View view) {
            this.f21544b = view;
        }

        public final void a(TextView textView) {
            this.f21545c = textView;
        }
    }

    /* compiled from: OptionChildAdapter.kt */
    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public e(Context context, boolean z) {
        this.f21541e = context;
        this.f21542f = z;
    }

    public final void a(int i) {
        this.f21538b = i;
        notifyDataSetInvalidated();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<? extends f> list = this.f21539c;
        if (list != null) {
            return list.size();
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<? extends f> list = this.f21539c;
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
        kotlin.jvm.internal.h.b(viewGroup, "parent");
        if (view == null) {
            if (this.f21542f) {
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
                throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.ui.optiongroup.OptionChildAdapter.ChildViewHolder");
            }
            aVar = (a) tag;
        }
        List<? extends f> list = this.f21539c;
        if (list != null) {
            f fVar = list.get(i);
            if (this.f21542f) {
                TextView b2 = aVar.b();
                if (b2 != null) {
                    b2.setText(fVar.getTitle());
                }
                if (this.f21538b == i) {
                    TextView b3 = aVar.b();
                    if (b3 != null) {
                        b3.setTextColor(ContextCompat.getColor(viewGroup.getContext(), R.color.optmenu_item_text_color_press));
                    }
                } else {
                    TextView b4 = aVar.b();
                    if (b4 != null) {
                        b4.setTextColor(ContextCompat.getColor(viewGroup.getContext(), R.color.optmenu_item_text_color_normal));
                    }
                }
            }
            ImageView a2 = aVar.a();
            if (a2 != null) {
                Context context = this.f21541e;
                if (context == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                a2.setImageDrawable(fVar.a(context));
            }
            View c2 = aVar.c();
            if (c2 != null) {
                c2.setSelected(this.f21538b == i);
            }
            View c3 = aVar.c();
            if (c3 != null) {
                c3.setVisibility(this.f21540d ? 8 : 0);
            }
            ImageView a3 = aVar.a();
            if (a3 != null) {
                a3.setEnabled(!this.f21540d);
            }
            TextView b5 = aVar.b();
            if (b5 != null) {
                b5.setEnabled(!this.f21540d);
            }
            return view;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    public final boolean a() {
        return this.f21540d;
    }

    public final void a(boolean z) {
        this.f21540d = z;
        notifyDataSetChanged();
    }

    public final void a(List<? extends f> list) {
        kotlin.jvm.internal.h.b(list, "list");
        this.f21539c = list;
        notifyDataSetInvalidated();
    }
}
