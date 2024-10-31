package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@Beta
/* loaded from: classes2.dex */
public final class Monitor {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f2966a;
    private final ReentrantLock b;

    @GuardedBy
    private final ArrayList<Guard> c;

    @Beta
    /* loaded from: classes2.dex */
    public static abstract class Guard {
        public final boolean equals(Object obj) {
            return this == obj;
        }

        public final int hashCode() {
            return super.hashCode();
        }
    }

    public Monitor() {
        this(false);
    }

    public Monitor(boolean z) {
        this.c = Lists.b(1);
        this.f2966a = z;
        this.b = new ReentrantLock(z);
    }
}
