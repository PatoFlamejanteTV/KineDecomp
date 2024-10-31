package com.adobe.creativesdk.foundation.internal.storage.controllers;

import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetViewFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.db, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0375db implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractC0414hb f6009a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0375db(AbstractC0414hb abstractC0414hb) {
        this.f6009a = abstractC0414hb;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        this.f6009a.p(((Integer) ((com.adobe.creativesdk.foundation.internal.notification.c) obj).b().get("unreadCount")).intValue());
    }
}
