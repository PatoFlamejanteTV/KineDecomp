package com.google.android.gms.internal.firebase_auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzct extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzct> CREATOR = new zzcu();
    private String zzgh;
    private String zzgi;
    private String zzhq;
    private String zzhw;
    private String zzhx;
    private com.google.firebase.auth.zzd zzin;
    private String zzoq;
    private boolean zzor;
    private boolean zzpa;
    private zzdd zzpb;
    private long zzpc;
    private long zzpd;

    public zzct() {
        this.zzpb = new zzdd();
    }

    public final long getCreationTimestamp() {
        return this.zzpc;
    }

    public final String getDisplayName() {
        return this.zzhw;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final long getLastSignInTimestamp() {
        return this.zzpd;
    }

    public final String getLocalId() {
        return this.zzoq;
    }

    public final String getPhoneNumber() {
        return this.zzhq;
    }

    public final Uri getPhotoUri() {
        if (TextUtils.isEmpty(this.zzhx)) {
            return null;
        }
        return Uri.parse(this.zzhx);
    }

    public final boolean isEmailVerified() {
        return this.zzpa;
    }

    public final boolean isNewUser() {
        return this.zzor;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.zzoq, false);
        SafeParcelWriter.a(parcel, 3, this.zzgh, false);
        SafeParcelWriter.a(parcel, 4, this.zzpa);
        SafeParcelWriter.a(parcel, 5, this.zzhw, false);
        SafeParcelWriter.a(parcel, 6, this.zzhx, false);
        SafeParcelWriter.a(parcel, 7, (Parcelable) this.zzpb, i, false);
        SafeParcelWriter.a(parcel, 8, this.zzgi, false);
        SafeParcelWriter.a(parcel, 9, this.zzhq, false);
        SafeParcelWriter.a(parcel, 10, this.zzpc);
        SafeParcelWriter.a(parcel, 11, this.zzpd);
        SafeParcelWriter.a(parcel, 12, this.zzor);
        SafeParcelWriter.a(parcel, 13, (Parcelable) this.zzin, i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final zzct zza(com.google.firebase.auth.zzd zzdVar) {
        this.zzin = zzdVar;
        return this;
    }

    public final zzct zzb(List<zzdb> list) {
        Preconditions.a(list);
        this.zzpb = new zzdd();
        this.zzpb.zzdu().addAll(list);
        return this;
    }

    public final zzct zzbx(String str) {
        this.zzgh = str;
        return this;
    }

    public final zzct zzby(String str) {
        this.zzhw = str;
        return this;
    }

    public final zzct zzbz(String str) {
        this.zzhx = str;
        return this;
    }

    public final zzct zzca(String str) {
        Preconditions.b(str);
        this.zzgi = str;
        return this;
    }

    public final com.google.firebase.auth.zzd zzcv() {
        return this.zzin;
    }

    public final List<zzdb> zzdu() {
        return this.zzpb.zzdu();
    }

    public final zzdd zzdv() {
        return this.zzpb;
    }

    public final zzct zzo(boolean z) {
        this.zzor = z;
        return this;
    }

    @SafeParcelable.Constructor
    public zzct(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) zzdd zzddVar, @SafeParcelable.Param(id = 8) String str5, @SafeParcelable.Param(id = 9) String str6, @SafeParcelable.Param(id = 10) long j, @SafeParcelable.Param(id = 11) long j2, @SafeParcelable.Param(id = 12) boolean z2, @SafeParcelable.Param(id = 13) com.google.firebase.auth.zzd zzdVar) {
        zzdd zza;
        this.zzoq = str;
        this.zzgh = str2;
        this.zzpa = z;
        this.zzhw = str3;
        this.zzhx = str4;
        if (zzddVar == null) {
            zza = new zzdd();
        } else {
            zza = zzdd.zza(zzddVar);
        }
        this.zzpb = zza;
        this.zzgi = str5;
        this.zzhq = str6;
        this.zzpc = j;
        this.zzpd = j2;
        this.zzor = z2;
        this.zzin = zzdVar;
    }
}
