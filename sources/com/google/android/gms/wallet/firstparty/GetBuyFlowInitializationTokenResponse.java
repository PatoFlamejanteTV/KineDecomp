package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class GetBuyFlowInitializationTokenResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetBuyFlowInitializationTokenResponse> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    byte[] f2299a;
    private final int b;

    GetBuyFlowInitializationTokenResponse() {
        this(1, new byte[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetBuyFlowInitializationTokenResponse(int i, byte[] bArr) {
        this.b = i;
        this.f2299a = bArr;
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
        zzc.a(this, parcel, i);
    }
}
