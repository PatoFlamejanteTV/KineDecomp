package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

/* loaded from: classes2.dex */
public class OnContentsResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnContentsResponse> CREATOR = new zzaw();

    /* renamed from: a, reason: collision with root package name */
    final int f1100a;
    final Contents b;
    final boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnContentsResponse(int i, Contents contents, boolean z) {
        this.f1100a = i;
        this.b = contents;
        this.c = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaw.a(this, parcel, i);
    }
}
