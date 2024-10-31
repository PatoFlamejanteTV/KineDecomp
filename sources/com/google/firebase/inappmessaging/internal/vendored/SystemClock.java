package com.google.firebase.inappmessaging.internal.vendored;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.inject.Inject;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class SystemClock implements Clock {
    @Inject
    public SystemClock() {
    }

    @Override // com.google.firebase.inappmessaging.internal.vendored.Clock
    @CanIgnoreReturnValue
    public long now() {
        return System.currentTimeMillis();
    }
}
