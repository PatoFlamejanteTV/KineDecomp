package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements ComponentCallbacks2 {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TagManager f2226a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TagManager tagManager) {
        this.f2226a = tagManager;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 20) {
            this.f2226a.a();
        }
    }
}
