package com.mixpanel.android.viewcrawler;

import com.mixpanel.android.mpmetrics.af;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewCrawler.java */
/* loaded from: classes.dex */
public class l implements af.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f3102a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f3102a = kVar;
    }

    @Override // com.mixpanel.android.mpmetrics.af.a
    public void a() {
        this.f3102a.h.sendMessage(this.f3102a.h.obtainMessage(4));
    }
}
