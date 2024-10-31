package com.facebook.internal;

/* compiled from: FacebookWebFallbackDialog.java */
/* loaded from: classes.dex */
class n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ FacebookWebFallbackDialog f9323a;

    public n(FacebookWebFallbackDialog facebookWebFallbackDialog) {
        this.f9323a = facebookWebFallbackDialog;
    }

    @Override // java.lang.Runnable
    public void run() {
        super/*com.facebook.internal.WebDialog*/.cancel();
    }
}
