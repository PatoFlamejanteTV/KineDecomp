package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.adobe.creativesdk.foundation.storage.C0533a;

/* compiled from: AdobeMultiPageFragmentController.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    protected u f6308a;

    /* renamed from: b, reason: collision with root package name */
    protected o f6309b;

    /* renamed from: c, reason: collision with root package name */
    protected g f6310c;

    /* renamed from: d, reason: collision with root package name */
    private v f6311d;

    /* renamed from: e, reason: collision with root package name */
    protected View f6312e;

    /* renamed from: f, reason: collision with root package name */
    protected View f6313f;

    /* renamed from: g, reason: collision with root package name */
    protected View f6314g;

    /* renamed from: h, reason: collision with root package name */
    protected View f6315h;
    protected Context i;
    protected C0533a j;
    protected AdobeMultiPageViewState k;
    protected AdobeMultiPageViewState l;

    public void a(AdobeMultiPageViewState adobeMultiPageViewState) {
        this.k = adobeMultiPageViewState;
    }

    public void b() {
        this.l = this.k;
        this.k = AdobeMultiPageViewState.AdobeMultiPageListView;
        if (this.f6311d.a().c() != null) {
            this.f6311d.a().c().k();
        }
        this.f6312e.setVisibility(4);
        this.f6314g.setVisibility(4);
        this.f6313f.setVisibility(0);
        this.f6309b.d();
        ((ViewGroup) this.f6315h).bringChildToFront(this.f6313f);
    }

    public AdobeMultiPageViewState c() {
        return this.l;
    }

    public AdobeMultiPageViewState d() {
        return this.k;
    }

    public void e() {
        u uVar = this.f6308a;
        if (uVar != null) {
            uVar.a();
        }
    }

    public View f() {
        AdobeMultiPageViewState adobeMultiPageViewState = this.k;
        if (adobeMultiPageViewState == AdobeMultiPageViewState.AdobeMultiPageGridView) {
            a();
        } else if (adobeMultiPageViewState == AdobeMultiPageViewState.AdobeMultiPageListView) {
            b();
        } else {
            a(0);
        }
        return this.f6315h;
    }

    public void g() {
        g gVar = this.f6310c;
        if (gVar != null) {
            gVar.d();
        }
        o oVar = this.f6309b;
        if (oVar != null) {
            oVar.e();
        }
    }

    public void h() {
        g gVar = this.f6310c;
        if (gVar != null) {
            gVar.e();
        }
        o oVar = this.f6309b;
        if (oVar != null) {
            oVar.f();
        }
    }

    public void a(View view) {
        this.f6315h = view;
    }

    public void a(C0533a c0533a) {
        this.j = c0533a;
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar) {
        if (fVar == null) {
            return;
        }
        g gVar = this.f6310c;
        if (gVar != null) {
            gVar.a(fVar);
        }
        o oVar = this.f6309b;
        if (oVar != null) {
            oVar.a(fVar);
        }
        u uVar = this.f6308a;
        if (uVar != null) {
            uVar.a(fVar);
        }
    }

    @SuppressLint({"InflateParams"})
    public void a(Context context) {
        this.i = context;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f6312e = layoutInflater.inflate(c.a.a.a.b.g.fragment_multipage_asset_viewpager, (ViewGroup) null, false);
        this.f6314g = layoutInflater.inflate(c.a.a.a.b.g.adobe_multipage_autofit_recycler_view, (ViewGroup) null, false);
        this.f6313f = layoutInflater.inflate(c.a.a.a.b.g.adobe_multipage_recycler_view, (ViewGroup) null, false);
        ((ViewGroup) this.f6315h).addView(this.f6312e);
        ((ViewGroup) this.f6315h).addView(this.f6314g);
        ((ViewGroup) this.f6315h).addView(this.f6313f);
        this.f6308a = new u();
        this.f6310c = new g();
        this.f6309b = new o();
        this.f6308a.a(this.f6311d.a());
        this.f6308a.a(this.f6312e);
        this.f6308a.a(this.j);
        this.f6308a.a(this.i);
        this.f6310c.a(this.f6314g);
        this.f6310c.a(this.j);
        this.f6310c.a(this.i);
        this.f6309b.a(this.f6313f);
        this.f6309b.a(this.j);
        this.f6309b.a(this.i);
        this.f6308a.a(this);
        this.f6310c.a(this);
        this.f6309b.a(this);
    }

    public void a() {
        this.l = this.k;
        this.k = AdobeMultiPageViewState.AdobeMultiPageGridView;
        if (this.f6311d.a().c() != null) {
            this.f6311d.a().c().k();
        }
        this.f6312e.setVisibility(4);
        this.f6313f.setVisibility(4);
        this.f6314g.setVisibility(0);
        this.f6310c.c();
        ((ViewGroup) this.f6315h).bringChildToFront(this.f6314g);
    }

    public void a(int i) {
        this.l = this.k;
        this.k = AdobeMultiPageViewState.AdobeMultiPageViewPager;
        this.f6314g.setVisibility(4);
        this.f6313f.setVisibility(4);
        this.f6312e.setVisibility(0);
        ((ViewGroup) this.f6315h).bringChildToFront(this.f6312e);
        this.f6308a.a(i);
    }

    public void a(v vVar) {
        this.f6311d = vVar;
    }
}
