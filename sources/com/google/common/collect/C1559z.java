package com.google.common.collect;

/* compiled from: ComparisonChain.java */
/* renamed from: com.google.common.collect.z */
/* loaded from: classes2.dex */
public class C1559z extends ComparisonChain {
    public C1559z() {
        super(null);
    }

    @Override // com.google.common.collect.ComparisonChain
    public ComparisonChain a(Comparable comparable, Comparable comparable2) {
        return a(comparable.compareTo(comparable2));
    }

    @Override // com.google.common.collect.ComparisonChain
    public int d() {
        return 0;
    }

    ComparisonChain a(int i) {
        ComparisonChain comparisonChain;
        ComparisonChain comparisonChain2;
        ComparisonChain comparisonChain3;
        if (i < 0) {
            comparisonChain3 = ComparisonChain.f15355b;
            return comparisonChain3;
        }
        if (i > 0) {
            comparisonChain2 = ComparisonChain.f15356c;
            return comparisonChain2;
        }
        comparisonChain = ComparisonChain.f15354a;
        return comparisonChain;
    }
}
