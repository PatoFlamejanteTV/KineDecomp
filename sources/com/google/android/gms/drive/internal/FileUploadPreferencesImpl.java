package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;

/* loaded from: classes2.dex */
public final class FileUploadPreferencesImpl implements SafeParcelable, FileUploadPreferences {
    public static final Parcelable.Creator<FileUploadPreferencesImpl> CREATOR = new zzag();

    /* renamed from: a, reason: collision with root package name */
    final int f1091a;
    int b;
    int c;
    boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileUploadPreferencesImpl(int i, int i2, int i3, boolean z) {
        this.f1091a = i;
        this.b = i2;
        this.c = i3;
        this.d = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzag.a(this, parcel, i);
    }
}
