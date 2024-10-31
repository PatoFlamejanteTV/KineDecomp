package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ComparisonChain {

    /* renamed from: a, reason: collision with root package name */
    private static final ComparisonChain f2663a = new w();
    private static final ComparisonChain b = new a(-1);
    private static final ComparisonChain c = new a(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ComparisonChain(w wVar) {
        this();
    }

    private ComparisonChain() {
    }

    /* loaded from: classes2.dex */
    private static final class a extends ComparisonChain {

        /* renamed from: a, reason: collision with root package name */
        final int f2664a;

        a(int i) {
            super(null);
            this.f2664a = i;
        }
    }
}
