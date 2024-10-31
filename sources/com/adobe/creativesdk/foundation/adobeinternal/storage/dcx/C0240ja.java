package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import java.lang.ref.WeakReference;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ja, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0240ja extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WeakReference f4397a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Aa f4398b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0240ja(Aa aa, WeakReference weakReference) {
        this.f4398b = aa;
        this.f4397a = weakReference;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        eb ebVar = (eb) this.f4397a.get();
        if (ebVar != null) {
            this.f4398b.a(ebVar);
        }
    }
}
