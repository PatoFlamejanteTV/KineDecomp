package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.Service;
import java.util.logging.Logger;

@Beta
/* loaded from: classes2.dex */
public abstract class AbstractExecutionThreadService implements Service {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f2949a = Logger.getLogger(AbstractExecutionThreadService.class.getName());
    private final Service b = new a(this);

    protected AbstractExecutionThreadService() {
    }

    public String toString() {
        return b() + " [" + a() + "]";
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State a() {
        return this.b.a();
    }

    protected String b() {
        return getClass().getSimpleName();
    }
}
