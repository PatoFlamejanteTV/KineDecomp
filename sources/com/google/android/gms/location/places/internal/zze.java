package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.internal.zzg;
import java.util.Locale;

/* loaded from: classes.dex */
public class zze extends com.google.android.gms.common.internal.zzj<zzg> {

    /* renamed from: a, reason: collision with root package name */
    private final PlacesParams f1887a;
    private final Locale b;

    /* loaded from: classes.dex */
    public static class zza extends Api.zza<zze, PlacesOptions> {

        /* renamed from: a, reason: collision with root package name */
        private final String f1888a;
        private final String b;

        public zza(String str, String str2) {
            this.f1888a = str;
            this.b = str2;
        }

        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public zze zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, PlacesOptions placesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zze(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener, this.f1888a != null ? this.f1888a : context.getPackageName(), this.b != null ? this.b : context.getPackageName(), placesOptions == null ? new PlacesOptions.Builder().a() : placesOptions);
        }
    }

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, String str2, PlacesOptions placesOptions) {
        super(context, looper, 65, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.b = Locale.getDefault();
        this.f1887a = new PlacesParams(str, this.b, zzfVar.b() != null ? zzfVar.b().name : null, placesOptions.f1877a, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzg zzW(IBinder iBinder) {
        return zzg.zza.a(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }
}
