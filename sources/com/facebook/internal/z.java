package com.facebook.internal;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlatformServiceClient.java */
/* loaded from: classes.dex */
public class z extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PlatformServiceClient f302a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PlatformServiceClient platformServiceClient) {
        this.f302a = platformServiceClient;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f302a.handleMessage(message);
    }
}
