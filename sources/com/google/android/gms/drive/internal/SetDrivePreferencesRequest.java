package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

/* loaded from: classes2.dex */
public class SetDrivePreferencesRequest implements SafeParcelable {
    public static final Parcelable.Creator<SetDrivePreferencesRequest> CREATOR = new zzbq();

    /* renamed from: a, reason: collision with root package name */
    final int f1119a;
    final DrivePreferences b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SetDrivePreferencesRequest(int i, DrivePreferences drivePreferences) {
        this.f1119a = i;
        this.b = drivePreferences;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbq.a(this, parcel, i);
    }
}
