package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;

/* loaded from: classes.dex */
final class f implements PendingResultUtil.zaa {
    @Override // com.google.android.gms.common.internal.PendingResultUtil.zaa
    public final ApiException a(Status status) {
        return ApiExceptionUtil.a(status);
    }
}
