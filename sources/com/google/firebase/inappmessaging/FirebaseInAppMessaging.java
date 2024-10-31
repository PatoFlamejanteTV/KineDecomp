package com.google.firebase.inappmessaging;

import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.Logging;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import javax.inject.Inject;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
@FirebaseAppScope
/* loaded from: classes2.dex */
public class FirebaseInAppMessaging {

    /* renamed from: a */
    private final InAppMessageStreamManager f17471a;

    /* renamed from: b */
    private final DataCollectionHelper f17472b;

    /* renamed from: c */
    private final DisplayCallbacksFactory f17473c;

    /* renamed from: e */
    private io.reactivex.i<FirebaseInAppMessagingDisplay> f17475e = io.reactivex.i.b();

    /* renamed from: d */
    private boolean f17474d = false;

    @Inject
    @VisibleForTesting
    public FirebaseInAppMessaging(InAppMessageStreamManager inAppMessageStreamManager, DataCollectionHelper dataCollectionHelper, DisplayCallbacksFactory displayCallbacksFactory) {
        this.f17471a = inAppMessageStreamManager;
        this.f17472b = dataCollectionHelper;
        this.f17473c = displayCallbacksFactory;
        Logging.c("Starting InAppMessaging runtime with Instance ID " + FirebaseInstanceId.b().a());
        a();
    }

    private void a() {
        this.f17471a.a().b(j.a(this));
    }

    @Keep
    public static FirebaseInAppMessaging getInstance() {
        return (FirebaseInAppMessaging) FirebaseApp.c().a(FirebaseInAppMessaging.class);
    }

    @Keep
    public boolean areMessagesSuppressed() {
        return this.f17474d;
    }

    @Keep
    @KeepForSdk
    public void clearDisplayListener() {
        Logging.c("Removing display event listener");
        this.f17475e = io.reactivex.i.b();
    }

    @Keep
    public boolean isAutomaticDataCollectionEnabled() {
        return this.f17472b.a();
    }

    @Keep
    public void setAutomaticDataCollectionEnabled(boolean z) {
        this.f17472b.a(z);
    }

    @Keep
    public void setMessageDisplayComponent(FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay) {
        Logging.c("Setting display event listener");
        this.f17475e = io.reactivex.i.b(firebaseInAppMessagingDisplay);
    }

    @Keep
    public void setMessagesSuppressed(Boolean bool) {
        this.f17474d = bool.booleanValue();
    }
}
