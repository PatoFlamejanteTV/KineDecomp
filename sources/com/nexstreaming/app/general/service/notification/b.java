package com.nexstreaming.app.general.service.notification;

import com.nexstreaming.kinemaster.network.C1819h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationHelper.java */
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NotificationData f19730a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f19731b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar, NotificationData notificationData) {
        this.f19731b = cVar;
        this.f19730a = notificationData;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1819h.a(this.f19731b.a()).a().a(this.f19730a.imageUrl, new a(this));
    }
}
