package com.facebook;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FacebookSdk.java */
/* loaded from: classes.dex */
public class o implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookSdk.InitializeCallback f9448a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f9449b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FacebookSdk.InitializeCallback initializeCallback, Context context) {
        this.f9448a = initializeCallback;
        this.f9449b = context;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        Context context;
        String str;
        AccessTokenManager.getInstance().loadCurrentAccessToken();
        ProfileManager.getInstance().loadCurrentProfile();
        if (AccessToken.isCurrentAccessTokenActive() && Profile.getCurrentProfile() == null) {
            Profile.fetchProfileForCurrentAccessToken();
        }
        FacebookSdk.InitializeCallback initializeCallback = this.f9448a;
        if (initializeCallback != null) {
            initializeCallback.onInitialized();
        }
        context = FacebookSdk.applicationContext;
        str = FacebookSdk.applicationId;
        AppEventsLogger.initializeLib(context, str);
        AppEventsLogger.newLogger(this.f9449b.getApplicationContext()).flush();
        return null;
    }
}
