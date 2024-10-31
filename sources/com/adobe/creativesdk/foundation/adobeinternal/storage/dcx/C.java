package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
class C {

    /* renamed from: a */
    final Lock f4128a = new ReentrantLock();

    /* renamed from: b */
    final Condition f4129b = this.f4128a.newCondition();

    /* renamed from: c */
    int f4130c;

    /* renamed from: d */
    final /* synthetic */ ArrayList f4131d;

    /* JADX WARN: Multi-variable type inference failed */
    public C(int i, int i2) {
        this.f4131d = i2;
        this.f4130c = i;
    }

    public void a(AdobeCSDKException adobeCSDKException) {
        this.f4128a.lock();
        if (adobeCSDKException != null) {
            this.f4131d.add(adobeCSDKException);
        }
        this.f4130c--;
        this.f4129b.signal();
        this.f4128a.unlock();
    }

    public void a() {
        this.f4128a.lock();
        while (this.f4130c > 0) {
            try {
                this.f4129b.await();
            } catch (InterruptedException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXCompositeXfer.internalDownloadComponents", e2.getMessage());
            }
        }
        this.f4128a.unlock();
    }
}
