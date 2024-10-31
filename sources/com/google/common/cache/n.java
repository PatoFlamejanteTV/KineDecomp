package com.google.common.cache;

import com.google.common.base.Supplier;

/* compiled from: LongAddables.java */
/* loaded from: classes2.dex */
class n implements Supplier<m> {
    @Override // com.google.common.base.Supplier
    public m get() {
        return new LongAdder();
    }
}
