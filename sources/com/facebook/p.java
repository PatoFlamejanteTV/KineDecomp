package com.facebook;

import android.content.Context;

/* compiled from: FacebookSdk.java */
/* loaded from: classes.dex */
public class p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f9450a;

    /* renamed from: b */
    final /* synthetic */ String f9451b;

    public p(Context context, String str) {
        this.f9450a = context;
        this.f9451b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        FacebookSdk.publishInstallAndWaitForResponse(this.f9450a, this.f9451b);
    }
}
