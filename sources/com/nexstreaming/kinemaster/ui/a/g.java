package com.nexstreaming.kinemaster.ui.a;

import android.support.v4.widget.NestedScrollView;

/* compiled from: NexDialogFragment.java */
/* loaded from: classes.dex */
class g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ NestedScrollView f21333a;

    /* renamed from: b */
    final /* synthetic */ k f21334b;

    public g(k kVar, NestedScrollView nestedScrollView) {
        this.f21334b = kVar;
        this.f21333a = nestedScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21333a.scrollTo(0, 0);
    }
}
