package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class k extends i {

    /* renamed from: e */
    private final Callable<String> f11184e;

    /* JADX INFO: Access modifiers changed from: private */
    public k(Callable<String> callable) {
        super(false, null, null);
        this.f11184e = callable;
    }

    @Override // com.google.android.gms.common.i
    final String a() {
        try {
            return this.f11184e.call();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public /* synthetic */ k(Callable callable, j jVar) {
        this(callable);
    }
}
