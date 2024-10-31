package com.adobe.creativesdk.foundation.internal.collaboration;

import com.adobe.creativesdk.foundation.internal.net.A;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: AdobeCollaborationSessionModel.java */
/* loaded from: classes.dex */
class i extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    boolean f5006a = false;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ A f5007b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Timer f5008c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ j f5009d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(j jVar, A a2, Timer timer) {
        this.f5009d = jVar;
        this.f5007b = a2;
        this.f5008c = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.f5007b.f()) {
            cancel();
            this.f5008c.cancel();
        } else if (!this.f5006a) {
            this.f5007b.g();
            this.f5006a = true;
        } else {
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeStorageServiceDisconnectedNotification, null));
            cancel();
            this.f5008c.cancel();
        }
    }
}
