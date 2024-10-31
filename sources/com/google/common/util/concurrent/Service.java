package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;

@Beta
/* loaded from: classes2.dex */
public interface Service {

    @Beta
    /* loaded from: classes2.dex */
    public interface Listener {
        void a(State state, Throwable th);
    }

    @Beta
    /* loaded from: classes2.dex */
    public enum State {
        NEW,
        STARTING,
        RUNNING,
        STOPPING,
        TERMINATED,
        FAILED
    }

    State a();
}
