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
public final class zzdp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdp> CREATOR = new zzdq();
    private final int versionCode;
    private List<String> zzpw;

    public zzdp() {
        this(null);
    }

    public static zzdp zza(zzdp zzdpVar) {
        return new zzdp(zzdpVar != null ? zzdpVar.zzpw : null);
    }

    public static zzdp zzec() {
        return new zzdp(null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.versionCode);
        SafeParcelWriter.c(parcel, 2, this.zzpw, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final List<String> zzeb() {
        return this.zzpw;
    }

    private zzdp(List<String> list) {
        this.versionCode = 1;
        this.zzpw = new ArrayList();
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzpw.addAll(list);
    }

    @SafeParcelable.Constructor
    public zzdp(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) List<String> list) {
        this.versionCode = i;
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                list.set(i2, Strings.a(list.get(i2)));
            }
            this.zzpw = Collections.unmodifiableList(list);
            return;
        }
        this.zzpw = Collections.emptyList();
    }
}
