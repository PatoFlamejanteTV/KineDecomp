package com.facebook.internal;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlatformServiceClient.java */
/* loaded from: classes.dex */
public class A extends Handler {

    /* renamed from: a */
    final /* synthetic */ PlatformServiceClient f9265a;

    public A(PlatformServiceClient platformServiceClient) {
        this.f9265a = platformServiceClient;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f9265a.handleMessage(message);
    }
}
