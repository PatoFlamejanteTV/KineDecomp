package com.google.common.util.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractScheduledService.java */
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f2975a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f2975a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ReentrantLock reentrantLock;
        ReentrantLock reentrantLock2;
        RuntimeException b;
        reentrantLock = this.f2975a.b;
        reentrantLock.lock();
        try {
            try {
                this.f2975a.f2974a.b();
            } finally {
            }
        } finally {
            reentrantLock2 = this.f2975a.b;
            reentrantLock2.unlock();
        }
    }
}
