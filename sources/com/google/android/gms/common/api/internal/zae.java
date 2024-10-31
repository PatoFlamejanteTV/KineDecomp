package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager;

/* loaded from: classes.dex */
public final class zae<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> extends zab {

    /* renamed from: b, reason: collision with root package name */
    private final A f10928b;

    public zae(int i, A a2) {
        super(i);
        this.f10928b = a2;
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void a(GoogleApiManager.zaa<?> zaaVar) throws DeadObjectException {
        try {
            this.f10928b.b(zaaVar.f());
        } catch (RuntimeException e2) {
            a(e2);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void a(Status status) {
        this.f10928b.c(status);
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void a(RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 2 + String.valueOf(localizedMessage).length());
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        this.f10928b.c(new Status(10, sb.toString()));
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void a(zaab zaabVar, boolean z) {
        zaabVar.a(this.f10928b, z);
    }
}
