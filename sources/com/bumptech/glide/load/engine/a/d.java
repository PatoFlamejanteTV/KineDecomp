package com.bumptech.glide.load.engine.a;

import com.bumptech.glide.load.engine.a.m;
import java.util.Queue;

/* compiled from: BaseKeyPool.java */
/* loaded from: classes.dex */
abstract class d<T extends m> {

    /* renamed from: a */
    private final Queue<T> f8799a = com.bumptech.glide.g.n.a(20);

    abstract T a();

    public void a(T t) {
        if (this.f8799a.size() < 20) {
            this.f8799a.offer(t);
        }
    }

    public T b() {
        T poll = this.f8799a.poll();
        return poll == null ? a() : poll;
    }
}
