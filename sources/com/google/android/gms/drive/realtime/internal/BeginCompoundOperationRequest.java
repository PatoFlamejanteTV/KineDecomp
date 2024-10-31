package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class BeginCompoundOperationRequest implements SafeParcelable {
    public static final Parcelable.Creator<BeginCompoundOperationRequest> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f1171a;
    final boolean b;
    final String c;
    final boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BeginCompoundOperationRequest(int i, boolean z, String str, boolean z2) {
        this.f1171a = i;
        this.b = z;
        this.c = str;
        this.d = z2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
