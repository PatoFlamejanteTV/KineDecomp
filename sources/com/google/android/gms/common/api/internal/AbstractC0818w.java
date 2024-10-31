package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.common.api.internal.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0818w {

    /* renamed from: a, reason: collision with root package name */
    private final zabd f10861a;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0818w(zabd zabdVar) {
        this.f10861a = zabdVar;
    }

    protected abstract void a();

    public final void a(zabe zabeVar) {
        Lock lock;
        Lock lock2;
        zabd zabdVar;
        lock = zabeVar.f10889a;
        lock.lock();
        try {
            zabdVar = zabeVar.k;
            if (zabdVar != this.f10861a) {
                return;
            }
            a();
        } finally {
            lock2 = zabeVar.f10889a;
            lock2.unlock();
        }
    }
}
