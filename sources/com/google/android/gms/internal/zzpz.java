package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;

/* loaded from: classes2.dex */
public class zzpz implements PanoramaApi {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class a extends c<PanoramaApi.PanoramaResult> {
        public a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PanoramaApi.PanoramaResult zzb(Status status) {
            return new ih(status, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b extends zzpx.zza {

        /* renamed from: a, reason: collision with root package name */
        private final zzlb.zzb<PanoramaApi.PanoramaResult> f1815a;

        public b(zzlb.zzb<PanoramaApi.PanoramaResult> zzbVar) {
            this.f1815a = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzpx
        public void zza(int i, Bundle bundle, int i2, Intent intent) {
            this.f1815a.zzp(new ih(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    /* loaded from: classes2.dex */
    private static abstract class c<R extends Result> extends zzlb.zza<R, zzqa> {
        protected c(GoogleApiClient googleApiClient) {
            super(Panorama.f2143a, googleApiClient);
        }

        protected abstract void a(Context context, zzpy zzpyVar) throws RemoteException;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlb.zza
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void zza(zzqa zzqaVar) throws RemoteException {
            a(zzqaVar.getContext(), zzqaVar.zzpc());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Context context, zzpy zzpyVar, zzpx zzpxVar, Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission("com.google.android.gms", uri, 1);
        try {
            zzpyVar.zza(new ig(context, uri, zzpxVar), uri, bundle, true);
        } catch (RemoteException e) {
            zza(context, uri);
            throw e;
        } catch (RuntimeException e2) {
            zza(context, uri);
            throw e2;
        }
    }

    public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfo(GoogleApiClient googleApiClient, Uri uri) {
        return googleApiClient.zza((GoogleApiClient) new ie(this, googleApiClient, uri));
    }

    public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient googleApiClient, Uri uri) {
        return googleApiClient.zza((GoogleApiClient) new Cif(this, googleApiClient, uri));
    }
}
