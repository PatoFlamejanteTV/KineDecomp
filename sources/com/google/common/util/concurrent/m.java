package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Striped.java */
/* loaded from: classes2.dex */
final class m implements Supplier<ReadWriteLock> {
    @Override // com.google.common.base.Supplier
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ReadWriteLock get() {
        return new ReentrantReadWriteLock();
    }
}
