package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class IdToken extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<IdToken> CREATOR = new zzk();

    /* renamed from: a */
    private final String f10529a;

    /* renamed from: b */
    private final String f10530b;

    @SafeParcelable.Constructor
    public IdToken(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        Preconditions.a(!TextUtils.isEmpty(str), "account type string cannot be null or empty");
        Preconditions.a(!TextUtils.isEmpty(str2), "id token string cannot be null or empty");
        this.f10529a = str;
        this.f10530b = str2;
    }

    public final String a() {
        return this.f10529a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdToken)) {
            return false;
        }
        IdToken idToken = (IdToken) obj;
        return Objects.a(this.f10529a, idToken.f10529a) && Objects.a(this.f10530b, idToken.f10530b);
    }

    public final String getIdToken() {
        return this.f10530b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, a(), false);
        SafeParcelWriter.a(parcel, 2, getIdToken(), false);
        SafeParcelWriter.a(parcel, a2);
    }
}
