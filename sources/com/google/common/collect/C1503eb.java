package com.google.common.collect;

import com.google.common.base.Function;

/* compiled from: Range.java */
/* renamed from: com.google.common.collect.eb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1503eb implements Function<Range, Cut> {
    @Override // com.google.common.base.Function
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Cut apply(Range range) {
        return range.upperBound;
    }
}
