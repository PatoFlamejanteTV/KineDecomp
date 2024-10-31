package io.grpc.internal;

import javax.annotation.concurrent.ThreadSafe;

/* compiled from: ObjectPool.java */
@ThreadSafe
/* loaded from: classes3.dex */
public interface Ub<T> {
    T a(Object obj);

    T getObject();
}
