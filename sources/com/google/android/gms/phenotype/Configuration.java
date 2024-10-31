package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@KeepForSdk
/* loaded from: classes2.dex */
public class Configuration extends AbstractSafeParcelable implements Comparable<Configuration> {

    @KeepForSdk
    public static final Parcelable.Creator<Configuration> CREATOR = new zzc();

    /* renamed from: a */
    private final int f14089a;

    /* renamed from: b */
    private final zzi[] f14090b;

    /* renamed from: c */
    private final String[] f14091c;

    /* renamed from: d */
    private final Map<String, zzi> f14092d = new TreeMap();

    @SafeParcelable.Constructor
    public Configuration(@SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) zzi[] zziVarArr, @SafeParcelable.Param(id = 4) String[] strArr) {
        this.f14089a = i;
        this.f14090b = zziVarArr;
        for (zzi zziVar : zziVarArr) {
            this.f14092d.put(zziVar.f14112b, zziVar);
        }
        this.f14091c = strArr;
        String[] strArr2 = this.f14091c;
        if (strArr2 != null) {
            Arrays.sort(strArr2);
        }
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Configuration configuration) {
        return this.f14089a - configuration.f14089a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Configuration) {
            Configuration configuration = (Configuration) obj;
            if (this.f14089a == configuration.f14089a && zzn.a(this.f14092d, configuration.f14092d) && Arrays.equals(this.f14091c, configuration.f14091c)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Configuration(");
        sb.append(this.f14089a);
        sb.append(", ");
        sb.append("(");
        Iterator<zzi> it = this.f14092d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(", ");
        }
        sb.append(")");
        sb.append(", ");
        sb.append("(");
        String[] strArr = this.f14091c;
        if (strArr != null) {
            for (String str : strArr) {
                sb.append(str);
                sb.append(", ");
            }
        } else {
            sb.append("null");
        }
        sb.append(")");
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.f14089a);
        SafeParcelWriter.a(parcel, 3, (Parcelable[]) this.f14090b, i, false);
        SafeParcelWriter.a(parcel, 4, this.f14091c, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
