package com.facebook.appevents;

import android.content.Context;
import com.facebook.appevents.AppEventsLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventsLogger.java */
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f254a;
    final /* synthetic */ AppEventsLogger.AccessTokenAppIdPair b;
    final /* synthetic */ AppEventsLogger.AppEvent c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, AppEventsLogger.AccessTokenAppIdPair accessTokenAppIdPair, AppEventsLogger.AppEvent appEvent) {
        this.f254a = context;
        this.b = accessTokenAppIdPair;
        this.c = appEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppEventsLogger.d sessionEventsState;
        sessionEventsState = AppEventsLogger.getSessionEventsState(this.f254a, this.b);
        sessionEventsState.a(this.c);
        AppEventsLogger.flushIfNecessary();
    }
}
