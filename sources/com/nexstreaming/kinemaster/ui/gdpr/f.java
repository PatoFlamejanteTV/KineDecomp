package com.nexstreaming.kinemaster.ui.gdpr;

import android.support.v4.widget.NestedScrollView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GDPRFragment.java */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ NestedScrollView f21597a;

    /* renamed from: b */
    final /* synthetic */ g f21598b;

    public f(g gVar, NestedScrollView nestedScrollView) {
        this.f21598b = gVar;
        this.f21597a = nestedScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21597a.scrollTo(0, 0);
    }
}
