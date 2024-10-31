package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthManager.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0321z implements Observer {

    /* renamed from: a, reason: collision with root package name */
    public boolean f4932a = false;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ReentrantLock f4933b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ A f4934c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Condition f4935d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ E f4936e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0321z(E e2, ReentrantLock reentrantLock, A a2, Condition condition) {
        this.f4936e = e2;
        this.f4933b = reentrantLock;
        this.f4934c = a2;
        this.f4935d = condition;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeAuthLoginNotification, this);
        com.adobe.creativesdk.foundation.internal.notification.c cVar = (com.adobe.creativesdk.foundation.internal.notification.c) obj;
        if (cVar.b() != null && cVar.b().get("Error") != null) {
            AdobeAuthException adobeAuthException = (AdobeAuthException) cVar.b().get("Error");
            if (adobeAuthException != null && adobeAuthException.getErrorCode() == AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_USER_INTERACTION_REQUIRED) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "Authentication", "emergency logout()");
                this.f4936e.p();
            }
        } else {
            this.f4932a = true;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "Authentication", "reAuthenticate() successful");
        }
        this.f4933b.lock();
        this.f4934c.f4744a = true;
        this.f4935d.signal();
        this.f4933b.unlock();
    }
}
