package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ql implements ThreadFactory {

    /* renamed from: a */
    private final /* synthetic */ String f11792a;

    public Ql(String str) {
        this.f11792a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f11792a);
    }
}
