package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzf implements AuthResult {
    public static final Parcelable.Creator<zzf> CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    private zzl f16522a;

    /* renamed from: b, reason: collision with root package name */
    private zzd f16523b;

    /* renamed from: c, reason: collision with root package name */
    private com.google.firebase.auth.zzd f16524c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzf(@SafeParcelable.Param(id = 1) zzl zzlVar, @SafeParcelable.Param(id = 2) zzd zzdVar, @SafeParcelable.Param(id = 3) com.google.firebase.auth.zzd zzdVar2) {
        this.f16522a = zzlVar;
        this.f16523b = zzdVar;
        this.f16524c = zzdVar2;
    }

    public final AdditionalUserInfo a() {
        return this.f16523b;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final FirebaseUser getUser() {
        return this.f16522a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, (Parcelable) getUser(), i, false);
        SafeParcelWriter.a(parcel, 2, (Parcelable) a(), i, false);
        SafeParcelWriter.a(parcel, 3, (Parcelable) this.f16524c, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public zzf(zzl zzlVar) {
        Preconditions.a(zzlVar);
        this.f16522a = zzlVar;
        List<zzh> aa = this.f16522a.aa();
        this.f16523b = null;
        for (int i = 0; i < aa.size(); i++) {
            if (!TextUtils.isEmpty(aa.get(i).getRawUserInfo())) {
                this.f16523b = new zzd(aa.get(i).getProviderId(), aa.get(i).getRawUserInfo(), zzlVar.isNewUser());
            }
        }
        if (this.f16523b == null) {
            this.f16523b = new zzd(zzlVar.isNewUser());
        }
        this.f16524c = zzlVar.zzcv();
    }
}
