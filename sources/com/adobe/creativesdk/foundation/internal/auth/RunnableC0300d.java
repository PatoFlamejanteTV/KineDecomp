package com.adobe.creativesdk.foundation.internal.auth;

/* compiled from: AdobeAuthContinuableEventActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0300d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAuthContinuableEventActivity f4880a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0300d(AdobeAuthContinuableEventActivity adobeAuthContinuableEventActivity) {
        this.f4880a = adobeAuthContinuableEventActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (c.a.a.a.a.a.a.b().h()) {
            this.f4880a.runOnUiThread(new RunnableC0299c(this));
        }
    }
}
