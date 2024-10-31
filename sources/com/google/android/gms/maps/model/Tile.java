package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class Tile implements SafeParcelable {
    public static final zzn CREATOR = new zzn();

    /* renamed from: a, reason: collision with root package name */
    public final int f1996a;
    public final int b;
    public final byte[] c;
    private final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tile(int i, int i2, int i3, byte[] bArr) {
        this.d = i;
        this.f1996a = i2;
        this.b = i3;
        this.c = bArr;
    }

    public Tile(int i, int i2, byte[] bArr) {
        this(1, i, i2, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.a(this, parcel, i);
    }
}
