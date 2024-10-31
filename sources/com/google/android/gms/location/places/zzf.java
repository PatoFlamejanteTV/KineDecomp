package com.google.android.gms.location.places;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.internal.zzh;
import com.google.android.gms.location.places.zzl;

/* loaded from: classes.dex */
public class zzf extends zzh.zza {

    /* renamed from: a, reason: collision with root package name */
    private final zzb f1904a;
    private final zza b;

    /* loaded from: classes.dex */
    public static abstract class zza<A extends Api.zzb> extends zzl.zzb<PlacePhotoResult, A> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlacePhotoResult zzb(Status status) {
            return new PlacePhotoResult(status, null);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zzb<A extends Api.zzb> extends zzl.zzb<PlacePhotoMetadataResult, A> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlacePhotoMetadataResult zzb(Status status) {
            return new PlacePhotoMetadataResult(status, null);
        }
    }

    @Override // com.google.android.gms.location.places.internal.zzh
    public void a(PlacePhotoMetadataResult placePhotoMetadataResult) throws RemoteException {
        this.f1904a.zzb((zzb) placePhotoMetadataResult);
    }

    @Override // com.google.android.gms.location.places.internal.zzh
    public void a(PlacePhotoResult placePhotoResult) throws RemoteException {
        this.b.zzb((zza) placePhotoResult);
    }
}
