package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new zzd();

    /* renamed from: a */
    @Deprecated
    private String f10578a;

    /* renamed from: b */
    private GoogleSignInAccount f10579b;

    /* renamed from: c */
    @Deprecated
    private String f10580c;

    @SafeParcelable.Constructor
    public SignInAccount(@SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 7) GoogleSignInAccount googleSignInAccount, @SafeParcelable.Param(id = 8) String str2) {
        this.f10579b = googleSignInAccount;
        Preconditions.a(str, (Object) "8.3 and 8.4 SDKs require non-null email");
        this.f10578a = str;
        Preconditions.a(str2, (Object) "8.3 and 8.4 SDKs require non-null userId");
        this.f10580c = str2;
    }

    @Nullable
    public final GoogleSignInAccount a() {
        return this.f10579b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 4, this.f10578a, false);
        SafeParcelWriter.a(parcel, 7, (Parcelable) this.f10579b, i, false);
        SafeParcelWriter.a(parcel, 8, this.f10580c, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
