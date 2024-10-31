package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class PhoneAuthCredential extends AuthCredential implements Cloneable {
    public static final Parcelable.Creator<PhoneAuthCredential> CREATOR = new zzw();

    /* renamed from: a */
    private String f16403a;

    /* renamed from: b */
    private String f16404b;

    /* renamed from: c */
    private boolean f16405c;

    /* renamed from: d */
    private String f16406d;

    /* renamed from: e */
    private boolean f16407e;

    /* renamed from: f */
    private String f16408f;

    @SafeParcelable.Constructor
    public PhoneAuthCredential(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) String str4) {
        Preconditions.a((z && !TextUtils.isEmpty(str3)) || !((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))), "Cannot create PhoneAuthCredential without either verificationProof, sessionInfo, ortemprary proof.");
        this.f16403a = str;
        this.f16404b = str2;
        this.f16405c = z;
        this.f16406d = str3;
        this.f16407e = z2;
        this.f16408f = str4;
    }

    public String a() {
        return this.f16404b;
    }

    public final PhoneAuthCredential b(boolean z) {
        this.f16407e = false;
        return this;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new PhoneAuthCredential(this.f16403a, a(), this.f16405c, this.f16406d, this.f16407e, this.f16408f);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return PlaceFields.PHONE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f16403a, false);
        SafeParcelWriter.a(parcel, 2, a(), false);
        SafeParcelWriter.a(parcel, 3, this.f16405c);
        SafeParcelWriter.a(parcel, 4, this.f16406d, false);
        SafeParcelWriter.a(parcel, 5, this.f16407e);
        SafeParcelWriter.a(parcel, 6, this.f16408f, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
