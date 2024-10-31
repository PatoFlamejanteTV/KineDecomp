package com.facebook.appevents.codeless;

/* compiled from: CodelessMatcher.java */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CodelessMatcher f9168a;

    public c(CodelessMatcher codelessMatcher) {
        this.f9168a = codelessMatcher;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9168a.matchViews();
    }
}
