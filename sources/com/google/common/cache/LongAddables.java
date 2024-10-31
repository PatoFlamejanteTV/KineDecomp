package com.google.common.cache;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class LongAddables {

    /* renamed from: a */
    private static final Supplier<m> f15246a;

    /* loaded from: classes2.dex */
    public static final class PureJavaLongAddable extends AtomicLong implements m {
        private PureJavaLongAddable() {
        }

        @Override // com.google.common.cache.m
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // com.google.common.cache.m
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.cache.m
        public long sum() {
            return get();
        }

        public /* synthetic */ PureJavaLongAddable(n nVar) {
            this();
        }
    }

    static {
        Supplier<m> oVar;
        try {
            new LongAdder();
            oVar = new n();
        } catch (Throwable unused) {
            oVar = new o();
        }
        f15246a = oVar;
    }

    public static m a() {
        return f15246a.get();
    }
}
