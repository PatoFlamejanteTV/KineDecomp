package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;

/* loaded from: classes2.dex */
public interface zzam<A extends Api.AnyClient, ResultT> {
    String a();

    TaskApiCall<A, ResultT> b();

    zzam<A, ResultT> c();
}
