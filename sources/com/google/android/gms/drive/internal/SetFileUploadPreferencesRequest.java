package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class SetFileUploadPreferencesRequest implements SafeParcelable {
    public static final Parcelable.Creator<SetFileUploadPreferencesRequest> CREATOR = new zzbr();

    /* renamed from: a, reason: collision with root package name */
    final int f1120a;
    final FileUploadPreferencesImpl b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SetFileUploadPreferencesRequest(int i, FileUploadPreferencesImpl fileUploadPreferencesImpl) {
        this.f1120a = i;
        this.b = fileUploadPreferencesImpl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbr.a(this, parcel, i);
    }
}
