package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes.dex */
public class TokenData extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<TokenData> CREATOR = new zzk();

    /* renamed from: a */
    private final int f10403a;

    /* renamed from: b */
    private final String f10404b;

    /* renamed from: c */
    private final Long f10405c;

    /* renamed from: d */
    private final boolean f10406d;

    /* renamed from: e */
    private final boolean f10407e;

    /* renamed from: f */
    private final List<String> f10408f;

    /* renamed from: g */
    private final String f10409g;

    @SafeParcelable.Constructor
    public TokenData(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) Long l, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) List<String> list, @SafeParcelable.Param(id = 7) String str2) {
        this.f10403a = i;
        Preconditions.b(str);
        this.f10404b = str;
        this.f10405c = l;
        this.f10406d = z;
        this.f10407e = z2;
        this.f10408f = list;
        this.f10409g = str2;
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

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.f10404b, tokenData.f10404b) && Objects.a(this.f10405c, tokenData.f10405c) && this.f10406d == tokenData.f10406d && this.f10407e == tokenData.f10407e && Objects.a(this.f10408f, tokenData.f10408f) && Objects.a(this.f10409g, tokenData.f10409g);
    }

    public int hashCode() {
        return Objects.a(this.f10404b, this.f10405c, Boolean.valueOf(this.f10406d), Boolean.valueOf(this.f10407e), this.f10408f, this.f10409g);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f10403a);
        SafeParcelWriter.a(parcel, 2, this.f10404b, false);
        SafeParcelWriter.a(parcel, 3, this.f10405c, false);
        SafeParcelWriter.a(parcel, 4, this.f10406d);
        SafeParcelWriter.a(parcel, 5, this.f10407e);
        SafeParcelWriter.c(parcel, 6, this.f10408f, false);
        SafeParcelWriter.a(parcel, 7, this.f10409g, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final String a() {
        return this.f10404b;
    }
}
