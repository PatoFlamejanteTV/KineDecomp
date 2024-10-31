package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* compiled from: AssetsListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.pb */
/* loaded from: classes.dex */
public abstract class AbstractC0457pb {

    /* renamed from: a */
    protected Context f6372a;

    /* renamed from: b */
    protected WeakReference<InterfaceC0362ad> f6373b;

    /* compiled from: AssetsListView.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.pb$a */
    /* loaded from: classes.dex */
    public class a {
        public a() {
        }
    }

    /* compiled from: AssetsListView.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.pb$b */
    /* loaded from: classes.dex */
    protected class b extends RecyclerView.ItemDecoration {

        /* renamed from: a */
        private int f6375a;

        public b(int i) {
            this.f6375a = i;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            int itemCount = state.getItemCount();
            int childPosition = recyclerView.getChildPosition(view);
            if (itemCount > 0 && childPosition == itemCount - 1) {
                rect.set(0, 0, 0, this.f6375a);
            } else {
                rect.set(0, 0, 0, 0);
            }
        }
    }

    public AbstractC0457pb(Context context) {
        this.f6372a = context;
    }

    public void a(InterfaceC0362ad interfaceC0362ad) {
        this.f6373b = new WeakReference<>(interfaceC0362ad);
    }

    public abstract void a(a aVar);

    public Activity b() {
        InterfaceC0362ad interfaceC0362ad;
        WeakReference<InterfaceC0362ad> weakReference = this.f6373b;
        if (weakReference == null || (interfaceC0362ad = weakReference.get()) == null) {
            return null;
        }
        return interfaceC0362ad.x();
    }

    public abstract a c();

    public abstract View d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public void a(boolean z) {
        RelativeLayout relativeLayout = (RelativeLayout) d().findViewById(c.a.a.a.b.e.adobe_search_empty_layout);
        if (relativeLayout != null) {
            if (z) {
                relativeLayout.setVisibility(0);
            } else {
                relativeLayout.setVisibility(8);
            }
        }
    }
}
