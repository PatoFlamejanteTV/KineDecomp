package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class PaymentMethodTokenizationParameters implements SafeParcelable {
    public static final Parcelable.Creator<PaymentMethodTokenizationParameters> CREATOR = new zzp();

    /* renamed from: a, reason: collision with root package name */
    int f2292a;
    Bundle b;
    private final int c;

    /* loaded from: classes.dex */
    public final class Builder {
    }

    private PaymentMethodTokenizationParameters() {
        this.b = new Bundle();
        this.c = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PaymentMethodTokenizationParameters(int i, int i2, Bundle bundle) {
        this.b = new Bundle();
        this.c = i;
        this.f2292a = i2;
        this.b = bundle;
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
        zzp.a(this, parcel, i);
    }
}
