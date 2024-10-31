package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;

/* loaded from: classes.dex */
public final class GoogleMapOptions implements SafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    private final int f1910a;
    private Boolean b;
    private Boolean c;
    private int d;
    private CameraPosition e;
    private Boolean f;
    private Boolean g;
    private Boolean h;
    private Boolean i;
    private Boolean j;
    private Boolean k;
    private Boolean l;
    private Boolean m;
    private Boolean n;

    public GoogleMapOptions() {
        this.d = -1;
        this.f1910a = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleMapOptions(int i, byte b, byte b2, int i2, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11) {
        this.d = -1;
        this.f1910a = i;
        this.b = com.google.android.gms.maps.internal.zza.a(b);
        this.c = com.google.android.gms.maps.internal.zza.a(b2);
        this.d = i2;
        this.e = cameraPosition;
        this.f = com.google.android.gms.maps.internal.zza.a(b3);
        this.g = com.google.android.gms.maps.internal.zza.a(b4);
        this.h = com.google.android.gms.maps.internal.zza.a(b5);
        this.i = com.google.android.gms.maps.internal.zza.a(b6);
        this.j = com.google.android.gms.maps.internal.zza.a(b7);
        this.k = com.google.android.gms.maps.internal.zza.a(b8);
        this.l = com.google.android.gms.maps.internal.zza.a(b9);
        this.m = com.google.android.gms.maps.internal.zza.a(b10);
        this.n = com.google.android.gms.maps.internal.zza.a(b11);
    }

    public static GoogleMapOptions a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, com.google.android.gms.R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_mapType)) {
            googleMapOptions.a(obtainAttributes.getInt(com.google.android.gms.R.styleable.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.a(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.b(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.d(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.h(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.e(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.g(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.f(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.c(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.i(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.j(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiMapToolbar, true));
        }
        if (obtainAttributes.hasValue(com.google.android.gms.R.styleable.MapAttrs_ambientEnabled)) {
            googleMapOptions.k(obtainAttributes.getBoolean(com.google.android.gms.R.styleable.MapAttrs_ambientEnabled, false));
        }
        googleMapOptions.a(CameraPosition.a(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1910a;
    }

    public GoogleMapOptions a(int i) {
        this.d = i;
        return this;
    }

    public GoogleMapOptions a(CameraPosition cameraPosition) {
        this.e = cameraPosition;
        return this;
    }

    public GoogleMapOptions a(boolean z) {
        this.b = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte b() {
        return com.google.android.gms.maps.internal.zza.a(this.b);
    }

    public GoogleMapOptions b(boolean z) {
        this.c = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte c() {
        return com.google.android.gms.maps.internal.zza.a(this.c);
    }

    public GoogleMapOptions c(boolean z) {
        this.f = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte d() {
        return com.google.android.gms.maps.internal.zza.a(this.f);
    }

    public GoogleMapOptions d(boolean z) {
        this.g = Boolean.valueOf(z);
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte e() {
        return com.google.android.gms.maps.internal.zza.a(this.g);
    }

    public GoogleMapOptions e(boolean z) {
        this.h = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte f() {
        return com.google.android.gms.maps.internal.zza.a(this.h);
    }

    public GoogleMapOptions f(boolean z) {
        this.i = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte g() {
        return com.google.android.gms.maps.internal.zza.a(this.i);
    }

    public GoogleMapOptions g(boolean z) {
        this.j = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte h() {
        return com.google.android.gms.maps.internal.zza.a(this.j);
    }

    public GoogleMapOptions h(boolean z) {
        this.k = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte i() {
        return com.google.android.gms.maps.internal.zza.a(this.k);
    }

    public GoogleMapOptions i(boolean z) {
        this.l = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte j() {
        return com.google.android.gms.maps.internal.zza.a(this.l);
    }

    public GoogleMapOptions j(boolean z) {
        this.m = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte k() {
        return com.google.android.gms.maps.internal.zza.a(this.m);
    }

    public GoogleMapOptions k(boolean z) {
        this.n = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte l() {
        return com.google.android.gms.maps.internal.zza.a(this.n);
    }

    public int m() {
        return this.d;
    }

    public CameraPosition n() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
