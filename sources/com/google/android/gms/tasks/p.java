package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes2.dex */
public final class p<TResult> {

    /* renamed from: a */
    private final Object f14311a = new Object();

    /* renamed from: b */
    private Queue<o<TResult>> f14312b;

    /* renamed from: c */
    private boolean f14313c;

    public final void a(o<TResult> oVar) {
        synchronized (this.f14311a) {
            if (this.f14312b == null) {
                this.f14312b = new ArrayDeque();
            }
            this.f14312b.add(oVar);
        }
    }

    public final void a(Task<TResult> task) {
        o<TResult> poll;
        synchronized (this.f14311a) {
            if (this.f14312b != null && !this.f14313c) {
                this.f14313c = true;
                while (true) {
                    synchronized (this.f14311a) {
                        poll = this.f14312b.poll();
                        if (poll == null) {
                            this.f14313c = false;
                            return;
                        }
                    }
                    poll.onComplete(task);
                }
            }
        }
    }
}
