package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;

@KeepForSdk
/* loaded from: classes.dex */
public class BaseImplementation {

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface ResultHolder<R> {
        @KeepForSdk
        void a(R r);
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public static abstract class ApiMethodImpl<R extends Result, A extends Api.AnyClient> extends BasePendingResult<R> implements ResultHolder<R> {

        @KeepForSdk
        private final Api.AnyClientKey<A> q;

        @KeepForSdk
        private final Api<?> r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @KeepForSdk
        public ApiMethodImpl(Api<?> api, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            Preconditions.a(googleApiClient, "GoogleApiClient must not be null");
            Preconditions.a(api, "Api must not be null");
            this.q = (Api.AnyClientKey<A>) api.a();
            this.r = api;
        }

        @KeepForSdk
        private void a(RemoteException remoteException) {
            c(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        @KeepForSdk
        protected abstract void a(A a2) throws RemoteException;

        @KeepForSdk
        public final void b(A a2) throws DeadObjectException {
            if (a2 instanceof SimpleClientAdapter) {
                a2 = ((SimpleClientAdapter) a2).c();
            }
            try {
                a((ApiMethodImpl<R, A>) a2);
            } catch (DeadObjectException e2) {
                a((RemoteException) e2);
                throw e2;
            } catch (RemoteException e3) {
                a(e3);
            }
        }

        @KeepForSdk
        protected void c(R r) {
        }

        @KeepForSdk
        public final void c(Status status) {
            Preconditions.a(!status.Q(), "Failed result must not be success");
            R a2 = a(status);
            a((ApiMethodImpl<R, A>) a2);
            c((ApiMethodImpl<R, A>) a2);
        }

        @KeepForSdk
        public final Api<?> g() {
            return this.r;
        }

        @KeepForSdk
        public final Api.AnyClientKey<A> h() {
            return this.q;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        @KeepForSdk
        public /* bridge */ /* synthetic */ void a(Object obj) {
            super.a((ApiMethodImpl<R, A>) obj);
        }
    }
}
