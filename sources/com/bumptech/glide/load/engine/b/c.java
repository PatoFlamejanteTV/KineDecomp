package com.bumptech.glide.load.engine.b;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiskCacheWriteLocker.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    private final Map<String, a> f8835a = new HashMap();

    /* renamed from: b */
    private final b f8836b = new b();

    /* compiled from: DiskCacheWriteLocker.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        final Lock f8837a = new ReentrantLock();

        /* renamed from: b */
        int f8838b;

        a() {
        }
    }

    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f8835a.get(str);
            if (aVar == null) {
                aVar = this.f8836b.a();
                this.f8835a.put(str, aVar);
            }
            aVar.f8838b++;
        }
        aVar.f8837a.lock();
    }

    public void b(String str) {
        a aVar;
        synchronized (this) {
            a aVar2 = this.f8835a.get(str);
            com.bumptech.glide.g.l.a(aVar2);
            aVar = aVar2;
            if (aVar.f8838b >= 1) {
                aVar.f8838b--;
                if (aVar.f8838b == 0) {
                    a remove = this.f8835a.remove(str);
                    if (remove.equals(aVar)) {
                        this.f8836b.a(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f8838b);
            }
        }
        aVar.f8837a.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskCacheWriteLocker.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        private final Queue<a> f8839a = new ArrayDeque();

        b() {
        }

        a a() {
            a poll;
            synchronized (this.f8839a) {
                poll = this.f8839a.poll();
            }
            return poll == null ? new a() : poll;
        }

        void a(a aVar) {
            synchronized (this.f8839a) {
                if (this.f8839a.size() < 10) {
                    this.f8839a.offer(aVar);
                }
            }
        }
    }
}
