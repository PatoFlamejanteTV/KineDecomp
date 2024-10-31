package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzli;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class zzlb {

    /* loaded from: classes.dex */
    public static abstract class zza<R extends Result, A extends Api.zzb> extends zzlc<R> implements zzb<R>, zzli.f<A> {
        private final Api.zzc<A> zzZM;
        private AtomicReference<zzli.e> zzabg;

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super(((GoogleApiClient) com.google.android.gms.common.internal.zzx.a(googleApiClient, "GoogleApiClient must not be null")).getLooper());
            this.zzabg = new AtomicReference<>();
            this.zzZM = (Api.zzc) com.google.android.gms.common.internal.zzx.a(zzcVar);
        }

        private void zza(RemoteException remoteException) {
            zzv(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        protected abstract void zza(A a2) throws RemoteException;

        @Override // com.google.android.gms.internal.zzli.f
        public void zza(zzli.e eVar) {
            this.zzabg.set(eVar);
        }

        @Override // com.google.android.gms.internal.zzli.f
        public final void zzb(A a2) throws DeadObjectException {
            try {
                zza((zza<R, A>) a2);
            } catch (DeadObjectException e) {
                zza(e);
                throw e;
            } catch (RemoteException e2) {
                zza(e2);
            }
        }

        @Override // com.google.android.gms.internal.zzli.f
        public void zznJ() {
            setResultCallback(null);
        }

        @Override // com.google.android.gms.internal.zzli.f
        public int zznK() {
            return 0;
        }

        @Override // com.google.android.gms.internal.zzlc
        protected void zznL() {
            zzli.e andSet = this.zzabg.getAndSet(null);
            if (andSet != null) {
                andSet.a(this);
            }
        }

        @Override // com.google.android.gms.internal.zzli.f
        public final Api.zzc<A> zznx() {
            return this.zzZM;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.zzlb.zzb
        public /* synthetic */ void zzp(Object obj) {
            super.zzb((zza<R, A>) obj);
        }

        @Override // com.google.android.gms.internal.zzlb.zzb, com.google.android.gms.internal.zzli.f
        public final void zzv(Status status) {
            com.google.android.gms.common.internal.zzx.b(!status.d(), "Failed result must not be success");
            zzb((zza<R, A>) zzb(status));
        }
    }

    /* loaded from: classes.dex */
    public interface zzb<R> {
        void zzp(R r);

        void zzv(Status status);
    }
}
