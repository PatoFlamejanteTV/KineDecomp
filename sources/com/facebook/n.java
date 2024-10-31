package com.facebook;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;

/* compiled from: FacebookSdk.java */
/* loaded from: classes.dex */
public final class n implements Callable<Void> {

    /* renamed from: a */
    final /* synthetic */ FacebookSdk.InitializeCallback f331a;

    public n(FacebookSdk.InitializeCallback initializeCallback) {
        this.f331a = initializeCallback;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public Void call() throws Exception {
        d.a().c();
        ac.a().c();
        if (AccessToken.getCurrentAccessToken() != null && Profile.getCurrentProfile() == null) {
            Profile.fetchProfileForCurrentAccessToken();
        }
        if (this.f331a != null) {
            this.f331a.onInitialized();
            return null;
        }
        return null;
    }
}
