package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.location.places.internal.zze;
import com.google.android.gms.location.places.internal.zzk;

/* loaded from: classes.dex */
public class Places {

    /* renamed from: a, reason: collision with root package name */
    public static final Api.zzc<com.google.android.gms.location.places.internal.zze> f1876a = new Api.zzc<>();
    public static final Api.zzc<com.google.android.gms.location.places.internal.zzk> b = new Api.zzc<>();
    public static final Api<PlacesOptions> c = new Api<>("Places.GEO_DATA_API", new zze.zza(null, null), f1876a);
    public static final Api<PlacesOptions> d = new Api<>("Places.PLACE_DETECTION_API", new zzk.zza(null, null), b);
    public static final GeoDataApi e = new com.google.android.gms.location.places.internal.zzd();
    public static final PlaceDetectionApi f = new com.google.android.gms.location.places.internal.zzj();

    private Places() {
    }
}
