package com.google.firebase.events;

import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
@KeepForSdk
/* loaded from: classes2.dex */
public class Event<T> {

    /* renamed from: a */
    private final Class<T> f17294a;

    /* renamed from: b */
    private final T f17295b;

    @KeepForSdk
    public T a() {
        return this.f17295b;
    }

    @KeepForSdk
    public Class<T> b() {
        return this.f17294a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.f17294a, this.f17295b);
    }
}
