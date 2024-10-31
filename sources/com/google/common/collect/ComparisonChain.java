package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ComparisonChain {

    /* renamed from: a */
    private static final ComparisonChain f15354a = new C1559z();

    /* renamed from: b */
    private static final ComparisonChain f15355b = new a(-1);

    /* renamed from: c */
    private static final ComparisonChain f15356c = new a(1);

    /* loaded from: classes2.dex */
    private static final class a extends ComparisonChain {

        /* renamed from: d */
        final int f15357d;

        a(int i) {
            super(null);
            this.f15357d = i;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain a(@Nullable Comparable comparable, @Nullable Comparable comparable2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public int d() {
            return this.f15357d;
        }
    }

    public /* synthetic */ ComparisonChain(C1559z c1559z) {
        this();
    }

    public static ComparisonChain e() {
        return f15354a;
    }

    public abstract ComparisonChain a(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract int d();

    private ComparisonChain() {
    }
}
