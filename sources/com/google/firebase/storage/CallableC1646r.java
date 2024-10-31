package com.google.firebase.storage;

import java.io.InputStream;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* renamed from: com.google.firebase.storage.r */
/* loaded from: classes2.dex */
class CallableC1646r implements Callable<InputStream> {

    /* renamed from: a */
    final /* synthetic */ StreamDownloadTask f18192a;

    public CallableC1646r(StreamDownloadTask streamDownloadTask) {
        this.f18192a = streamDownloadTask;
    }

    @Override // java.util.concurrent.Callable
    public InputStream call() throws Exception {
        InputStream x;
        x = this.f18192a.x();
        return x;
    }
}
