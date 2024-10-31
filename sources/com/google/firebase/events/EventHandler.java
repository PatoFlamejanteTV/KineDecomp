package com.google.firebase.events;

import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
@KeepForSdk
/* loaded from: classes2.dex */
public interface EventHandler<T> {
    @KeepForSdk
    void a(Event<T> event);
}
