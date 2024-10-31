package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Striped.java */
/* loaded from: classes2.dex */
class x implements Supplier<ReadWriteLock> {
    @Override // com.google.common.base.Supplier
    public ReadWriteLock get() {
        return new ReentrantReadWriteLock();
    }
}
