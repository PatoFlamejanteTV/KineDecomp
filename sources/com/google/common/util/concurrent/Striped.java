package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import java.util.concurrent.locks.ReadWriteLock;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class Striped<L> {

    /* renamed from: a */
    private static final Supplier<ReadWriteLock> f16193a = new x();

    private Striped() {
    }
}
