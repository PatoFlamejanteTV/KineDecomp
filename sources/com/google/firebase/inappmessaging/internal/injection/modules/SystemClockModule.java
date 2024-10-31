package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.internal.vendored.SystemClock;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class SystemClockModule {
    public Clock a() {
        return new SystemClock();
    }
}
