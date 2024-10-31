package com.google.firebase.database.core.utilities;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class DefaultClock implements Clock {
    @Override // com.google.firebase.database.core.utilities.Clock
    public long a() {
        return System.currentTimeMillis();
    }
}
