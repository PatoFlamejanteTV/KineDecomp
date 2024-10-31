package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public final class SearchAdRequestParcel implements SafeParcelable {
    public static final zzae CREATOR = new zzae();

    /* renamed from: a, reason: collision with root package name */
    public final int f535a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final String j;
    public final int k;
    public final String l;
    public final int m;
    public final int n;
    public final String o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SearchAdRequestParcel(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        this.f535a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = i8;
        this.i = i9;
        this.j = str;
        this.k = i10;
        this.l = str2;
        this.m = i11;
        this.n = i12;
        this.o = str3;
    }

    public SearchAdRequestParcel(SearchAdRequest searchAdRequest) {
        this.f535a = 1;
        this.b = searchAdRequest.a();
        this.c = searchAdRequest.b();
        this.d = searchAdRequest.c();
        this.e = searchAdRequest.d();
        this.f = searchAdRequest.e();
        this.g = searchAdRequest.f();
        this.h = searchAdRequest.g();
        this.i = searchAdRequest.h();
        this.j = searchAdRequest.i();
        this.k = searchAdRequest.j();
        this.l = searchAdRequest.k();
        this.m = searchAdRequest.l();
        this.n = searchAdRequest.m();
        this.o = searchAdRequest.n();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzae.a(this, parcel, i);
    }
}
