package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXSyncGroupMonitor.java */
/* loaded from: classes.dex */
public class Ra extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ya f4230a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ra(Ya ya) {
        this.f4230a = ya;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f4230a.a(false);
    }
}
