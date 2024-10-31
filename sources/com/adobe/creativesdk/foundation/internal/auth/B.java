package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.facebook.GraphResponse;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthManager.java */
/* loaded from: classes.dex */
public class B implements W {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4791a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.analytics.f f4792b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ E f4793c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(E e2, String str, com.adobe.creativesdk.foundation.internal.analytics.f fVar) {
        this.f4793c = e2;
        this.f4791a = str;
        this.f4792b = fVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.W
    public void onSuccess() {
        com.adobe.creativesdk.foundation.internal.analytics.q.a("Logout Success", this.f4791a);
        this.f4792b.b(GraphResponse.SUCCESS_KEY);
        this.f4792b.a();
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeAuthLogoutNotification, null));
    }
}
