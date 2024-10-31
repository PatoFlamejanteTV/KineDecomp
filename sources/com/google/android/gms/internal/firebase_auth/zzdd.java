package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzdd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdd> CREATOR = new zzde();
    private List<zzdb> zzpm;

    public zzdd() {
        this.zzpm = new ArrayList();
    }

    public static zzdd zza(zzdd zzddVar) {
        List<zzdb> list = zzddVar.zzpm;
        zzdd zzddVar2 = new zzdd();
        if (list != null) {
            zzddVar2.zzpm.addAll(list);
        }
        return zzddVar2;
    }

    public static zzdd zzc(List<zzm> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzm zzmVar = list.get(i);
            arrayList.add(new zzdb(Strings.a(zzmVar.zzbg()), Strings.a(zzmVar.getDisplayName()), Strings.a(zzmVar.zzal()), Strings.a(zzmVar.getProviderId()), null, Strings.a(zzmVar.getPhoneNumber()), Strings.a(zzmVar.getEmail())));
        }
        return new zzdd(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.d(parcel, 2, this.zzpm, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final List<zzdb> zzdu() {
        return this.zzpm;
    }

    @SafeParcelable.Constructor
    public zzdd(@SafeParcelable.Param(id = 2) List<zzdb> list) {
        if (list != null && !list.isEmpty()) {
            this.zzpm = Collections.unmodifiableList(list);
        } else {
            this.zzpm = Collections.emptyList();
        }
    }
}
