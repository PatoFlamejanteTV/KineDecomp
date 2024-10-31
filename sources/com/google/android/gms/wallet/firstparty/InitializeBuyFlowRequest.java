package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class InitializeBuyFlowRequest implements SafeParcelable {
    public static final Parcelable.Creator<InitializeBuyFlowRequest> CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    byte[][] f2302a;
    private final int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InitializeBuyFlowRequest(int i, byte[][] bArr) {
        this.b = i;
        this.f2302a = bArr;
    }

    public int a() {
        return this.b;
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
