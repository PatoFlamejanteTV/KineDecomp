package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PopoutListMenu.java */
/* loaded from: classes.dex */
public class g extends j {

    /* renamed from: a, reason: collision with root package name */
    b f4391a;
    private View d;
    private ListView e;
    private List<a> f;
    private boolean g;
    private boolean h;
    private BaseAdapter i;

    /* compiled from: PopoutListMenu.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(g gVar, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PopoutListMenu.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final int f4392a;
        final String b;
        final Drawable c;

        /* synthetic */ a(int i, String str, Drawable drawable, h hVar) {
            this(i, str, drawable);
        }

        private a(int i, String str, Drawable drawable) {
            this.f4392a = i;
            this.b = str;
            this.c = drawable;
        }
    }

    public g(Context context) {
        super(context);
        this.f = new ArrayList();
        this.g = false;
        this.h = false;
        this.i = new h(this);
    }

    public g(Context context, boolean z) {
        super(context);
        this.f = new ArrayList();
        this.g = false;
        this.h = false;
        this.i = new h(this);
        this.g = z;
    }

    public g(Context context, boolean z, boolean z2) {
        super(context);
        this.f = new ArrayList();
        this.g = false;
        this.h = false;
        this.i = new h(this);
        this.g = z;
        this.h = z2;
    }

    public void a(int i, int i2, int i3) {
        this.f.add(new a(i, this.c.getResources().getString(i2), i3 == 0 ? null : this.c.getResources().getDrawable(i3), null));
        this.i.notifyDataSetChanged();
    }

    public void a(int i, int i2) {
        this.f.add(new a(i, this.c.getResources().getString(i2), null, 0 == true ? 1 : 0));
        this.i.notifyDataSetChanged();
    }

    public void a(int i, String str) {
        this.f.add(new a(i, str, null, 0 == true ? 1 : 0));
        this.i.notifyDataSetChanged();
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.j
    protected View a(Context context) {
        this.d = LayoutInflater.from(context).inflate(R.layout.list_menu_popout, (ViewGroup) null, false);
        if (this.g) {
            this.d.setBackground(null);
        }
        this.e = (ListView) this.d.findViewById(R.id.listMenuContent);
        this.e.setOnItemClickListener(new i(this));
        this.e.setAdapter((ListAdapter) this.i);
        int dividerHeight = this.e.getDividerHeight();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.action_overflow_popout_max_height);
        int i = 0;
        int i2 = 0;
        View view = null;
        for (int i3 = 0; i3 < this.i.getCount(); i3++) {
            view = this.i.getView(i3, view, this.e);
            view.measure(0, 0);
            int measuredHeight = view.getMeasuredHeight();
            int measuredWidth = view.getMeasuredWidth();
            if (i2 + measuredHeight <= dimensionPixelSize) {
                i2 += measuredHeight;
                if (i3 > 0) {
                    i2 += dividerHeight;
                }
            }
            i = Math.max(i, measuredWidth);
        }
        this.e.getLayoutParams().width = i;
        this.e.getLayoutParams().height = i2;
        return this.d;
    }

    public void a(b bVar) {
        this.f4391a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.widget.j
    public void b() {
        this.d = null;
        this.e = null;
        this.f4391a = null;
        super.b();
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.j
    public void a() {
        if (this.b != null) {
            this.b.dismiss();
        }
    }
}
