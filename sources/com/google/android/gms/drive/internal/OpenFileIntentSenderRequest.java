package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

/* loaded from: classes2.dex */
public class OpenFileIntentSenderRequest implements SafeParcelable {
    public static final Parcelable.Creator<OpenFileIntentSenderRequest> CREATOR = new zzbm();

    /* renamed from: a, reason: collision with root package name */
    final int f1115a;
    final String b;
    final String[] c;
    final DriveId d;
    final FilterHolder e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenFileIntentSenderRequest(int i, String str, String[] strArr, DriveId driveId, FilterHolder filterHolder) {
        this.f1115a = i;
        this.b = str;
        this.c = strArr;
        this.d = driveId;
        this.e = filterHolder;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbm.a(this, parcel, i);
    }
}
