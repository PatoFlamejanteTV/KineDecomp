package com.nexstreaming.kinemaster.ui.gdpr;

import android.support.v4.widget.NestedScrollView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GDPRFragment.java */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ NestedScrollView f21594a;

    /* renamed from: b */
    final /* synthetic */ g f21595b;

    public d(g gVar, NestedScrollView nestedScrollView) {
        this.f21595b = gVar;
        this.f21594a = nestedScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21594a.scrollTo(0, 0);
    }
}
