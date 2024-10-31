package com.facebook.login;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceAuthDialog.java */
/* renamed from: com.facebook.login.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0745d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeviceAuthDialog f9381a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0745d(DeviceAuthDialog deviceAuthDialog) {
        this.f9381a = deviceAuthDialog;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9381a.poll();
    }
}
