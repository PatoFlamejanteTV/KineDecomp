package com.google.firebase.events;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
@KeepForSdk
/* loaded from: classes2.dex */
public interface Subscriber {
    @KeepForSdk
    <T> void a(Class<T> cls, EventHandler<? super T> eventHandler);

    @KeepForSdk
    <T> void a(Class<T> cls, Executor executor, EventHandler<? super T> eventHandler);

    @KeepForSdk
    <T> void b(Class<T> cls, EventHandler<? super T> eventHandler);
}
