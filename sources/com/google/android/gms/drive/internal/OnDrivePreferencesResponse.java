package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

/* loaded from: classes2.dex */
public class OnDrivePreferencesResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnDrivePreferencesResponse> CREATOR = new zzba();

    /* renamed from: a, reason: collision with root package name */
    final int f1104a;
    DrivePreferences b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnDrivePreferencesResponse(int i, DrivePreferences drivePreferences) {
        this.f1104a = i;
        this.b = drivePreferences;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzba.a(this, parcel, i);
    }
}
