package com.facebook.login.widget;

import com.facebook.internal.Utility;

/* compiled from: LoginButton.java */
/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Utility.FetchedAppSettings f323a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Utility.FetchedAppSettings fetchedAppSettings) {
        this.b = aVar;
        this.f323a = fetchedAppSettings;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b.showToolTipPerSettings(this.f323a);
    }
}
