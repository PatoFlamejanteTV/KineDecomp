package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.internal.zzf;
import java.util.Locale;

/* loaded from: classes.dex */
public class zzk extends com.google.android.gms.common.internal.zzj<zzf> {

    /* renamed from: a, reason: collision with root package name */
    private final PlacesParams f1893a;
    private final Locale b;

    /* loaded from: classes.dex */
    public static class zza extends Api.zza<zzk, PlacesOptions> {

        /* renamed from: a, reason: collision with root package name */
        private final String f1894a;
        private final String b;

        public zza(String str, String str2) {
            this.f1894a = str;
            this.b = str2;
        }

        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public zzk zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, PlacesOptions placesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzk(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener, this.f1894a != null ? this.f1894a : context.getPackageName(), this.b != null ? this.b : context.getPackageName(), placesOptions == null ? new PlacesOptions.Builder().a() : placesOptions);
        }
    }

    public zzk(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, String str2, PlacesOptions placesOptions) {
        super(context, looper, 67, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.b = Locale.getDefault();
        this.f1893a = new PlacesParams(str, this.b, zzfVar.b() != null ? zzfVar.b().name : null, placesOptions.f1877a, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzf zzW(IBinder iBinder) {
        return zzf.zza.a(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }
}
