package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb;
import com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager;

/* compiled from: AssetsRecyclerListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.tb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0476tb extends AbstractC0457pb {

    /* renamed from: c, reason: collision with root package name */
    protected RecyclerView.LayoutManager f6412c;

    /* renamed from: d, reason: collision with root package name */
    private View f6413d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f6414e;

    /* renamed from: f, reason: collision with root package name */
    protected SwipeRefreshLayout f6415f;

    /* renamed from: g, reason: collision with root package name */
    protected RecyclerView.Adapter<RecyclerView.ViewHolder> f6416g;

    /* renamed from: h, reason: collision with root package name */
    protected b f6417h;
    private RecyclerView.OnScrollListener i;
    protected RecyclerView.ItemDecoration j;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AssetsRecyclerListView.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.tb$a */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private int f6418a;

        public a(int i) {
            this.f6418a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AbstractC0476tb.this.a(view, this.f6418a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AssetsRecyclerListView.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.tb$b */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private int f6420a;

        public b(int i) {
            this.f6420a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AbstractC0476tb.this.a(this.f6420a, view);
        }
    }

    /* compiled from: AssetsRecyclerListView.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.tb$c */
    /* loaded from: classes.dex */
    protected class c extends AbstractC0457pb.a {

        /* renamed from: b, reason: collision with root package name */
        public Parcelable f6422b;

        protected c() {
            super();
        }
    }

    public AbstractC0476tb(Context context) {
        super(context);
        this.i = new C0462qb(this);
    }

    protected abstract RecyclerView.Adapter<RecyclerView.ViewHolder> a(Context context, RecyclerView recyclerView);

    protected abstract RecyclerView.ItemDecoration a(RecyclerView recyclerView, Context context);

    protected abstract RecyclerView a(Context context);

    protected abstract void a(int i, View view);

    protected abstract void a(View view, int i);

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void a(AbstractC0457pb.a aVar) {
        RecyclerView.LayoutManager layoutManager;
        if (aVar == null || (layoutManager = this.f6412c) == null || !(aVar instanceof c)) {
            return;
        }
        layoutManager.onRestoreInstanceState(((c) aVar).f6422b);
    }

    protected abstract RecyclerView.LayoutManager b(Context context);

    protected abstract View c(Context context);

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public AbstractC0457pb.a c() {
        if (this.f6412c == null) {
            return null;
        }
        c cVar = new c();
        cVar.f6422b = this.f6412c.onSaveInstanceState();
        return cVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public View d() {
        return this.f6413d;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void e() {
        this.f6416g.notifyDataSetChanged();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void f() {
        this.f6416g.notifyDataSetChanged();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void g() {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void h() {
        this.f6415f.setRefreshing(false);
    }

    protected void i() {
        this.f6414e.setOnScrollListener(this.i);
    }

    protected int j() {
        if (this.f6414e.getChildCount() == 0) {
            return 0;
        }
        RecyclerView recyclerView = this.f6414e;
        return recyclerView.getChildPosition(recyclerView.getChildAt(0));
    }

    protected int k() {
        int childCount = this.f6414e.getChildCount();
        if (childCount == 0) {
            return 0;
        }
        RecyclerView recyclerView = this.f6414e;
        return recyclerView.getChildPosition(recyclerView.getChildAt(childCount - 1));
    }

    protected abstract SwipeRefreshLayout l();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        InterfaceC0362ad interfaceC0362ad;
        int itemCount = this.f6416g.getItemCount();
        if (itemCount == 0) {
            return;
        }
        int j = j();
        int k = k();
        int i = k - j;
        if (itemCount - 1 == i) {
            return;
        }
        double d2 = k;
        double d3 = itemCount - i;
        Double.isNaN(d2);
        Double.isNaN(d3);
        if (d2 / d3 <= 0.8d || (interfaceC0362ad = this.f6373b.get()) == null) {
            return;
        }
        interfaceC0362ad.k();
    }

    protected boolean n() {
        return true;
    }

    public void o() {
        RecyclerView.LayoutManager layoutManager = this.f6412c;
        int e2 = layoutManager != null ? ((TwoWayLayoutManager) layoutManager).e() : -1;
        RecyclerView.ItemDecoration itemDecoration = this.j;
        if (itemDecoration != null) {
            this.f6414e.removeItemDecoration(itemDecoration);
        }
        this.f6412c = b(b());
        this.f6414e.setLayoutManager(this.f6412c);
        this.j = a(this.f6414e, (Context) null);
        this.f6414e.addItemDecoration(this.j);
        e();
        if (e2 != -1) {
            new Handler().post(new RunnableC0471sb(this, e2));
        }
    }

    public void p() {
        this.f6415f.setRefreshing(true);
    }

    public void d(Context context) {
        this.f6413d = c(context);
        this.f6414e = a(context);
        this.f6414e.setHasFixedSize(n());
        this.j = a(this.f6414e, context);
        this.f6414e.addItemDecoration(this.j);
        this.f6412c = b(context);
        this.f6414e.setLayoutManager(this.f6412c);
        this.f6415f = l();
        this.f6415f.setOnRefreshListener(new C0466rb(this));
        this.f6414e.addItemDecoration(new AbstractC0457pb.b((int) context.getResources().getDimension(c.a.a.a.b.c.adobe_csdk_recylerview_padding_bottom_offset)));
        int parseColor = Color.parseColor("#2098f5");
        int parseColor2 = Color.parseColor("#f5f9fa");
        this.f6415f.setColorSchemeColors(parseColor, parseColor2, parseColor, parseColor2);
        i();
        this.f6416g = a(context, this.f6414e);
        this.f6414e.setAdapter(this.f6416g);
    }
}
