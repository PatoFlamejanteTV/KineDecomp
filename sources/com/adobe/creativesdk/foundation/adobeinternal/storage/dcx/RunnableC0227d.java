package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXComposite.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0227d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0231f f4340a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0231f f4341b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0227d(C0231f c0231f, C0231f c0231f2) {
        this.f4341b = c0231f;
        this.f4340a = c0231f2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ob obVar;
        jb jbVar;
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        jb jbVar2;
        obVar = this.f4341b.l;
        if (obVar.b(this.f4340a) != -1) {
            jbVar = this.f4341b.w;
            if (jbVar != null) {
                jbVar2 = this.f4341b.w;
                jbVar2.b(this.f4340a);
            }
            boolean z = false;
            while (!z) {
                atomicInteger = this.f4341b.f4369g;
                int intValue = atomicInteger.intValue();
                atomicInteger2 = this.f4341b.f4369g;
                boolean compareAndSet = atomicInteger2.compareAndSet(intValue, 0);
                if (compareAndSet && intValue > 1) {
                    this.f4340a.O();
                }
                z = compareAndSet;
            }
        }
    }
}
