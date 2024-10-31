package com.facebook.login.widget;

import com.facebook.internal.FetchedAppSettings;

/* compiled from: LoginButton.java */
/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FetchedAppSettings f9407a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f9408b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar, FetchedAppSettings fetchedAppSettings) {
        this.f9408b = cVar;
        this.f9407a = fetchedAppSettings;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9408b.f9410b.showToolTipPerSettings(this.f9407a);
    }
}
