package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class DrivePreferences implements SafeParcelable {
    public static final Parcelable.Creator<DrivePreferences> CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    final int f1056a;
    final boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DrivePreferences(int i, boolean z) {
        this.f1056a = i;
        this.b = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.a(this, parcel, i);
    }
}
