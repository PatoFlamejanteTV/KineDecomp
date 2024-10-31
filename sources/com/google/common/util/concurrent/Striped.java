package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Supplier;
import java.util.concurrent.locks.ReadWriteLock;

@Beta
/* loaded from: classes2.dex */
public abstract class Striped<L> {

    /* renamed from: a, reason: collision with root package name */
    private static final Supplier<ReadWriteLock> f2970a = new m();

    private Striped() {
    }
}
