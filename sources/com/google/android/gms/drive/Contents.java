package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class Contents implements SafeParcelable {
    public static final Parcelable.Creator<Contents> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final int f1050a;
    final ParcelFileDescriptor b;
    final int c;
    final int d;
    final DriveId e;
    final boolean f;
    final String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Contents(int i, ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, DriveId driveId, boolean z, String str) {
        this.f1050a = i;
        this.b = parcelFileDescriptor;
        this.c = i2;
        this.d = i3;
        this.e = driveId;
        this.f = z;
        this.g = str;
    }

    public int a() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
