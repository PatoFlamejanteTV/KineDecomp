package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

/* loaded from: classes.dex */
public class TokenData implements SafeParcelable {
    public static final zzd CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    final int f781a;
    private final String b;
    private final Long c;
    private final boolean d;
    private final boolean e;
    private final List<String> f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TokenData(int i, String str, Long l, boolean z, boolean z2, List<String> list) {
        this.f781a = i;
        this.b = zzx.a(str);
        this.c = l;
        this.d = z;
        this.e = z2;
        this.f = list;
    }

    public static TokenData a(Bundle bundle, String str) {
        bundle.setClassLoader(TokenData.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(TokenData.class.getClassLoader());
        return (TokenData) bundle2.getParcelable("TokenData");
    }

    public String a() {
        return this.b;
    }

    public Long b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<String> e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.b, tokenData.b) && zzw.a(this.c, tokenData.c) && this.d == tokenData.d && this.e == tokenData.e && zzw.a(this.f, tokenData.f);
    }

    public int hashCode() {
        return zzw.a(this.b, this.c, Boolean.valueOf(this.d), Boolean.valueOf(this.e), this.f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.a(this, parcel, i);
    }
}
