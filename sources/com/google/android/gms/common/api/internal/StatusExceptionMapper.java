package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;

@KeepForSdk
/* loaded from: classes.dex */
public interface StatusExceptionMapper {
    @KeepForSdk
    Exception a(Status status);
}
