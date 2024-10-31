package com.google.firebase.inappmessaging.model;

import com.google.auto.value.AutoValue;
import com.google.firebase.inappmessaging.model.k;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
@AutoValue
/* loaded from: classes2.dex */
public abstract class RateLimit {

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    @AutoValue.Builder
    /* loaded from: classes2.dex */
    public static abstract class Builder {
        public abstract Builder a(long j);

        public abstract Builder a(String str);

        public abstract RateLimit a();

        public abstract Builder b(long j);
    }

    public static Builder a() {
        return new k.a();
    }

    public abstract long b();

    public abstract String c();

    public abstract long d();
}
