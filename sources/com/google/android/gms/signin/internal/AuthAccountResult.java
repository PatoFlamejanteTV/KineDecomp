package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class AuthAccountResult implements SafeParcelable {
    public static final Parcelable.Creator<AuthAccountResult> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f2193a;

    public AuthAccountResult() {
        this(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AuthAccountResult(int i) {
        this.f2193a = i;
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
