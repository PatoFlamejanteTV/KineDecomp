package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.mj */
/* loaded from: classes2.dex */
public final class RunnableC1002mj implements Runnable {
    /* JADX INFO: Access modifiers changed from: private */
    public RunnableC1002mj() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            MessageDigest unused = C0960jj.f12231b = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused2) {
        } finally {
            C0960jj.f12234e.countDown();
        }
    }

    public /* synthetic */ RunnableC1002mj(C0988lj c0988lj) {
        this();
    }
}
