package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.inject.Provider;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
@KeepForSdk
/* loaded from: classes2.dex */
public interface ComponentContainer {
    @KeepForSdk
    <T> T a(Class<T> cls);

    @KeepForSdk
    <T> Provider<T> b(Class<T> cls);
}
