package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzdr;

/* loaded from: classes2.dex */
public class zzd extends zzv {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();

    /* renamed from: a */
    private final String f16558a;

    /* renamed from: b */
    private final String f16559b;

    /* renamed from: c */
    private final String f16560c;

    /* renamed from: d */
    private final zzdr f16561d;

    /* renamed from: e */
    private final String f16562e;

    @SafeParcelable.Constructor
    public zzd(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) zzdr zzdrVar, @SafeParcelable.Param(id = 5) String str4) {
        this.f16558a = str;
        this.f16559b = str2;
        this.f16560c = str3;
        this.f16561d = zzdrVar;
        this.f16562e = str4;
    }

    public static zzd a(String str, String str2, String str3) {
        return c(str, str2, str3, null);
    }

    public static zzd b(String str, String str2, String str3, String str4) {
        return c(str, str2, str3, str4);
    }

    private static zzd c(String str, String str2, String str3, String str4) {
        Preconditions.a(str, (Object) "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new zzd(str, str2, str3, null, str4);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return this.f16558a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, getProvider(), false);
        SafeParcelWriter.a(parcel, 2, this.f16559b, false);
        SafeParcelWriter.a(parcel, 3, this.f16560c, false);
        SafeParcelWriter.a(parcel, 4, (Parcelable) this.f16561d, i, false);
        SafeParcelWriter.a(parcel, 5, this.f16562e, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public static zzd a(zzdr zzdrVar) {
        Preconditions.a(zzdrVar, "Must specify a non-null webSignInCredential");
        return new zzd(null, null, null, zzdrVar, null);
    }

    public final String a() {
        return this.f16562e;
    }

    public static zzdr a(zzd zzdVar, String str) {
        Preconditions.a(zzdVar);
        zzdr zzdrVar = zzdVar.f16561d;
        return zzdrVar != null ? zzdrVar : new zzdr(zzdVar.f16559b, zzdVar.f16560c, zzdVar.getProvider(), null, null, null, str, zzdVar.f16562e);
    }
}
