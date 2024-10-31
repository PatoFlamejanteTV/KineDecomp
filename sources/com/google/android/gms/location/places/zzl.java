package com.google.android.gms.location.places;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzmz;
import com.google.android.gms.location.places.internal.zzi;

/* loaded from: classes.dex */
public class zzl extends zzi.zza {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1905a = zzl.class.getSimpleName();
    private final zzd b;
    private final zza c;
    private final zze d;
    private final zzf e;
    private final zzc f;
    private final Context g;

    /* loaded from: classes.dex */
    public static abstract class zza<A extends Api.zzb> extends zzb<AutocompletePredictionBuffer, A> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AutocompletePredictionBuffer zzb(Status status) {
            return new AutocompletePredictionBuffer(DataHolder.b(status.e()));
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zzb<R extends Result, A extends Api.zzb> extends zzlb.zza<R, A> {
    }

    /* loaded from: classes.dex */
    public static abstract class zzc<A extends Api.zzb> extends zzb<PlaceBuffer, A> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaceBuffer zzb(Status status) {
            return new PlaceBuffer(DataHolder.b(status.e()), null);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zzd<A extends Api.zzb> extends zzb<PlaceLikelihoodBuffer, A> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaceLikelihoodBuffer zzb(Status status) {
            return new PlaceLikelihoodBuffer(DataHolder.b(status.e()), 100, null);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zze<A extends Api.zzb> extends zzb<com.google.android.gms.location.places.personalized.zzd, A> {
    }

    /* loaded from: classes.dex */
    public static abstract class zzf<A extends Api.zzb> extends zzb<Status, A> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status zzb(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void a(Status status) throws RemoteException {
        this.e.zzb((zzf) status);
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void a(DataHolder dataHolder) throws RemoteException {
        zzx.a(this.b != null, "placeEstimator cannot be null");
        if (dataHolder != null) {
            this.b.zzb((zzd) new PlaceLikelihoodBuffer(dataHolder, 100, this.g));
            return;
        }
        if (Log.isLoggable(f1905a, 6)) {
            Log.e(f1905a, "onPlaceEstimated received null DataHolder: " + zzmz.zzqF());
        }
        this.b.zzv(Status.c);
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void b(DataHolder dataHolder) throws RemoteException {
        if (dataHolder != null) {
            this.c.zzb((zza) new AutocompletePredictionBuffer(dataHolder));
            return;
        }
        if (Log.isLoggable(f1905a, 6)) {
            Log.e(f1905a, "onAutocompletePrediction received null DataHolder: " + zzmz.zzqF());
        }
        this.c.zzv(Status.c);
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void c(DataHolder dataHolder) throws RemoteException {
        if (dataHolder != null) {
            this.d.zzb((zze) new com.google.android.gms.location.places.personalized.zzd(dataHolder));
            return;
        }
        if (Log.isLoggable(f1905a, 6)) {
            Log.e(f1905a, "onPlaceUserDataFetched received null DataHolder: " + zzmz.zzqF());
        }
        this.d.zzv(Status.c);
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void d(DataHolder dataHolder) throws RemoteException {
        this.f.zzb((zzc) new PlaceBuffer(dataHolder, this.g));
    }
}
