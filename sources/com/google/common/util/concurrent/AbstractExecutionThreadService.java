package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.Service;
import java.util.logging.Logger;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class AbstractExecutionThreadService implements Service {

    /* renamed from: a */
    private static final Logger f16106a = Logger.getLogger(AbstractExecutionThreadService.class.getName());

    /* renamed from: b */
    private final Service f16107b = new a(this);

    protected AbstractExecutionThreadService() {
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State a() {
        return this.f16107b.a();
    }

    protected String b() {
        return AbstractExecutionThreadService.class.getSimpleName();
    }

    public String toString() {
        return b() + " [" + a() + "]";
    }
}
