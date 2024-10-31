package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.xd */
/* loaded from: classes2.dex */
public final class ThreadFactoryC1149xd implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f12655a = new AtomicInteger(1);

    /* renamed from: b */
    private final /* synthetic */ String f12656b;

    public ThreadFactoryC1149xd(String str) {
        this.f12656b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.f12656b;
        int andIncrement = this.f12655a.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
