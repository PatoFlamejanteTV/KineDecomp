package com.google.firebase.auth.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.internal.InternalTokenResult;

@KeepForSdk
/* loaded from: classes2.dex */
public interface IdTokenListener {
    @KeepForSdk
    void a(InternalTokenResult internalTokenResult);
}
