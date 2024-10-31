package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;

/* loaded from: classes2.dex */
public final class zzew<ResultT, CallbackT> implements P<ResultT> {

    /* renamed from: a, reason: collision with root package name */
    private final Q<ResultT, CallbackT> f16482a;

    /* renamed from: b, reason: collision with root package name */
    private final TaskCompletionSource<ResultT> f16483b;

    public zzew(Q<ResultT, CallbackT> q, TaskCompletionSource<ResultT> taskCompletionSource) {
        this.f16482a = q;
        this.f16483b = taskCompletionSource;
    }

    @Override // com.google.firebase.auth.api.internal.P
    public final void a(ResultT resultt, Status status) {
        Preconditions.a(this.f16483b, "completion source cannot be null");
        if (status != null) {
            Q<ResultT, CallbackT> q = this.f16482a;
            AuthCredential authCredential = q.p;
            if (authCredential != null) {
                this.f16483b.a(zzds.a(status, authCredential, q.q));
                return;
            } else {
                this.f16483b.a(zzds.a(status));
                return;
            }
        }
        this.f16483b.a((TaskCompletionSource<ResultT>) resultt);
    }
}
