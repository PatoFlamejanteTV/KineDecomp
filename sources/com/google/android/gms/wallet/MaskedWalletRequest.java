package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class MaskedWalletRequest implements SafeParcelable {
    public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new zzl();

    /* renamed from: a, reason: collision with root package name */
    String f2288a;
    boolean b;
    boolean c;
    boolean d;
    String e;
    String f;
    String g;
    Cart h;
    boolean i;
    boolean j;
    CountrySpecification[] k;
    boolean l;
    boolean m;
    ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> n;
    PaymentMethodTokenizationParameters o;
    ArrayList<Integer> p;
    private final int q;

    /* loaded from: classes.dex */
    public final class Builder {
    }

    MaskedWalletRequest() {
        this.q = 3;
        this.l = true;
        this.m = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaskedWalletRequest(int i, String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4, Cart cart, boolean z4, boolean z5, CountrySpecification[] countrySpecificationArr, boolean z6, boolean z7, ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> arrayList, PaymentMethodTokenizationParameters paymentMethodTokenizationParameters, ArrayList<Integer> arrayList2) {
        this.q = i;
        this.f2288a = str;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = cart;
        this.i = z4;
        this.j = z5;
        this.k = countrySpecificationArr;
        this.l = z6;
        this.m = z7;
        this.n = arrayList;
        this.o = paymentMethodTokenizationParameters;
        this.p = arrayList2;
    }

    public int a() {
        return this.q;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.a(this, parcel, i);
    }
}
