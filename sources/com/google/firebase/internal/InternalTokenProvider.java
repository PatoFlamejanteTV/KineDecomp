package com.google.firebase.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.GetTokenResult;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
@KeepForSdk
@Deprecated
/* loaded from: classes2.dex */
public interface InternalTokenProvider {
    @KeepForSdk
    Task<GetTokenResult> a(boolean z);
}
