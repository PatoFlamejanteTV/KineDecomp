package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* loaded from: classes2.dex */
public final class C implements ComponentCallbacks2 {

    /* renamed from: a */
    private final /* synthetic */ TagManager f14159a;

    public C(TagManager tagManager) {
        this.f14159a = tagManager;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20) {
            this.f14159a.a();
        }
    }
}
