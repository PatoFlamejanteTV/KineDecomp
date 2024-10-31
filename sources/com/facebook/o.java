package com.facebook;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FacebookSdk.java */
/* loaded from: classes.dex */
public final class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f332a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context, String str) {
        this.f332a = context;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        FacebookSdk.publishInstallAndWaitForResponse(this.f332a, this.b);
    }
}
