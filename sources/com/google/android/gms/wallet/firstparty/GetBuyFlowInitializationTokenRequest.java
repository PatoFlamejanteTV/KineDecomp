package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
/* loaded from: classes.dex */
public final class GetBuyFlowInitializationTokenRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetBuyFlowInitializationTokenRequest> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    byte[] f2298a;
    byte[] b;
    private final int c;

    GetBuyFlowInitializationTokenRequest() {
        this(1, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetBuyFlowInitializationTokenRequest(int i, byte[] bArr, byte[] bArr2) {
        this.c = i;
        this.f2298a = bArr;
        this.b = bArr2;
    }

    public int a() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
