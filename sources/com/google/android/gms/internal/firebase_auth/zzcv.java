package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzcv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcv> CREATOR = new zzcw();
    private List<zzct> zzpe;

    public zzcv() {
        this.zzpe = new ArrayList();
    }

    public static zzcv zza(zzcv zzcvVar) {
        Preconditions.a(zzcvVar);
        List<zzct> list = zzcvVar.zzpe;
        zzcv zzcvVar2 = new zzcv();
        if (list != null && !list.isEmpty()) {
            zzcvVar2.zzpe.addAll(list);
        }
        return zzcvVar2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.d(parcel, 2, this.zzpe, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final List<zzct> zzdt() {
        return this.zzpe;
    }

    @SafeParcelable.Constructor
    public zzcv(@SafeParcelable.Param(id = 2) List<zzct> list) {
        List<zzct> unmodifiableList;
        if (list == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list);
        }
        this.zzpe = unmodifiableList;
    }

    public static zzcv zza(zzj.zzg zzgVar) {
        ArrayList arrayList = new ArrayList(zzgVar.zzx());
        for (int i = 0; i < zzgVar.zzx(); i++) {
            zzr zza = zzgVar.zza(i);
            arrayList.add(new zzct(Strings.a(zza.getLocalId()), Strings.a(zza.getEmail()), zza.zzan(), Strings.a(zza.getDisplayName()), Strings.a(zza.zzal()), zzdd.zzc(zza.zzak()), Strings.a(zza.zzbm()), Strings.a(zza.getPhoneNumber()), zza.zzbl(), zza.zzbk(), false, null));
        }
        return new zzcv(arrayList);
    }
}
