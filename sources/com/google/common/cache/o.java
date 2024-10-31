package com.google.common.cache;

import com.google.common.base.Supplier;
import com.google.common.cache.LongAddables;

/* compiled from: LongAddables.java */
/* loaded from: classes2.dex */
class o implements Supplier<m> {
    @Override // com.google.common.base.Supplier
    public m get() {
        return new LongAddables.PureJavaLongAddable(null);
    }
}
