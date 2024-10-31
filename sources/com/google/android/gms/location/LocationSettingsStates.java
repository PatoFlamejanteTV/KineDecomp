package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class LocationSettingsStates implements SafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    private final int f1850a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationSettingsStates(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f1850a = i;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
        this.f = z5;
        this.g = z6;
        this.h = z7;
    }

    public int a() {
        return this.f1850a;
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.e;
    }

    public boolean d() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.f;
    }

    public boolean f() {
        return this.d;
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
