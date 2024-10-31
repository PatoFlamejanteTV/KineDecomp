package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.zzi;

/* loaded from: classes.dex */
public final class TileOverlayOptions implements SafeParcelable {
    public static final zzo CREATOR = new zzo();

    /* renamed from: a, reason: collision with root package name */
    private final int f1998a;
    private com.google.android.gms.maps.model.internal.zzi b;
    private TileProvider c;
    private boolean d;
    private float e;
    private boolean f;

    public TileOverlayOptions() {
        this.d = true;
        this.f = true;
        this.f1998a = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TileOverlayOptions(int i, IBinder iBinder, boolean z, float f, boolean z2) {
        this.d = true;
        this.f = true;
        this.f1998a = i;
        this.b = zzi.zza.a(iBinder);
        this.c = this.b == null ? null : new a(this);
        this.d = z;
        this.e = f;
        this.f = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1998a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder b() {
        return this.b.asBinder();
    }

    public float c() {
        return this.e;
    }

    public boolean d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo.a(this, parcel, i);
    }
}
