package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/* loaded from: classes.dex */
public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    private final int f1922a;
    private StreetViewPanoramaCamera b;
    private String c;
    private LatLng d;
    private Integer e;
    private Boolean f;
    private Boolean g;
    private Boolean h;
    private Boolean i;
    private Boolean j;

    public StreetViewPanoramaOptions() {
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.f1922a = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreetViewPanoramaOptions(int i, StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b, byte b2, byte b3, byte b4, byte b5) {
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.f1922a = i;
        this.b = streetViewPanoramaCamera;
        this.d = latLng;
        this.e = num;
        this.c = str;
        this.f = com.google.android.gms.maps.internal.zza.a(b);
        this.g = com.google.android.gms.maps.internal.zza.a(b2);
        this.h = com.google.android.gms.maps.internal.zza.a(b3);
        this.i = com.google.android.gms.maps.internal.zza.a(b4);
        this.j = com.google.android.gms.maps.internal.zza.a(b5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1922a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte b() {
        return com.google.android.gms.maps.internal.zza.a(this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte c() {
        return com.google.android.gms.maps.internal.zza.a(this.g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte d() {
        return com.google.android.gms.maps.internal.zza.a(this.h);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte e() {
        return com.google.android.gms.maps.internal.zza.a(this.i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte f() {
        return com.google.android.gms.maps.internal.zza.a(this.j);
    }

    public StreetViewPanoramaCamera g() {
        return this.b;
    }

    public LatLng h() {
        return this.d;
    }

    public Integer i() {
        return this.e;
    }

    public String j() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
