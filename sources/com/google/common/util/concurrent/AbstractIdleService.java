package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.Service;

@Beta
/* loaded from: classes2.dex */
public abstract class AbstractIdleService implements Service {

    /* renamed from: a, reason: collision with root package name */
    private final Service f2951a = new b(this);

    public String toString() {
        return b() + " [" + a() + "]";
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State a() {
        return this.f2951a.a();
    }

    private String b() {
        return getClass().getSimpleName();
    }
}
