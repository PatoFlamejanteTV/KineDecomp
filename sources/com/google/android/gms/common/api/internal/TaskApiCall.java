package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {

    /* renamed from: a */
    private final Feature[] f10800a;

    /* renamed from: b */
    private final boolean f10801b;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class Builder<A extends Api.AnyClient, ResultT> {

        /* renamed from: a */
        private RemoteCall<A, TaskCompletionSource<ResultT>> f10802a;

        /* renamed from: b */
        private boolean f10803b;

        /* renamed from: c */
        private Feature[] f10804c;

        private Builder() {
            this.f10803b = true;
        }

        @KeepForSdk
        public Builder<A, ResultT> a(RemoteCall<A, TaskCompletionSource<ResultT>> remoteCall) {
            this.f10802a = remoteCall;
            return this;
        }

        @KeepForSdk
        public Builder<A, ResultT> a(Feature... featureArr) {
            this.f10804c = featureArr;
            return this;
        }

        /* synthetic */ Builder(H h2) {
            this();
        }

        @KeepForSdk
        public Builder<A, ResultT> a(boolean z) {
            this.f10803b = z;
            return this;
        }

        @KeepForSdk
        public TaskApiCall<A, ResultT> a() {
            Preconditions.a(this.f10802a != null, "execute parameter required");
            return new I(this, this.f10804c, this.f10803b);
        }
    }

    @KeepForSdk
    @Deprecated
    public TaskApiCall() {
        this.f10800a = null;
        this.f10801b = false;
    }

    @KeepForSdk
    public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> a() {
        return new Builder<>();
    }

    @KeepForSdk
    public abstract void a(A a2, TaskCompletionSource<ResultT> taskCompletionSource) throws RemoteException;

    @KeepForSdk
    public boolean b() {
        return this.f10801b;
    }

    public final Feature[] c() {
        return this.f10800a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @KeepForSdk
    public TaskApiCall(Feature[] featureArr, boolean z) {
        this.f10800a = featureArr;
        this.f10801b = z;
    }

    public /* synthetic */ TaskApiCall(Feature[] featureArr, boolean z, H h2) {
        this(featureArr, z);
    }
}
