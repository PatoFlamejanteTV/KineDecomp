package com.facebook.internal;

/* compiled from: FacebookWebFallbackDialog.java */
/* loaded from: classes.dex */
class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookWebFallbackDialog f294a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FacebookWebFallbackDialog facebookWebFallbackDialog) {
        this.f294a = facebookWebFallbackDialog;
    }

    @Override // java.lang.Runnable
    public void run() {
        super/*com.facebook.internal.WebDialog*/.cancel();
    }
}
