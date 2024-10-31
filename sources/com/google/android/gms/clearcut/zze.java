package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.clearcut.zzha;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();

    /* renamed from: a */
    public zzr f10637a;

    /* renamed from: b */
    public byte[] f10638b;

    /* renamed from: c */
    private int[] f10639c;

    /* renamed from: d */
    private String[] f10640d;

    /* renamed from: e */
    private int[] f10641e;

    /* renamed from: f */
    private byte[][] f10642f;

    /* renamed from: g */
    private ExperimentTokens[] f10643g;

    /* renamed from: h */
    private boolean f10644h;
    public final zzha i;
    public final ClearcutLogger.zzb j;
    public final ClearcutLogger.zzb k;

    public zze(zzr zzrVar, zzha zzhaVar, ClearcutLogger.zzb zzbVar, ClearcutLogger.zzb zzbVar2, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr, ExperimentTokens[] experimentTokensArr, boolean z) {
        this.f10637a = zzrVar;
        this.i = zzhaVar;
        this.j = zzbVar;
        this.k = null;
        this.f10639c = iArr;
        this.f10640d = null;
        this.f10641e = iArr2;
        this.f10642f = null;
        this.f10643g = null;
        this.f10644h = z;
    }

    @SafeParcelable.Constructor
    public zze(@SafeParcelable.Param(id = 2) zzr zzrVar, @SafeParcelable.Param(id = 3) byte[] bArr, @SafeParcelable.Param(id = 4) int[] iArr, @SafeParcelable.Param(id = 5) String[] strArr, @SafeParcelable.Param(id = 6) int[] iArr2, @SafeParcelable.Param(id = 7) byte[][] bArr2, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) ExperimentTokens[] experimentTokensArr) {
        this.f10637a = zzrVar;
        this.f10638b = bArr;
        this.f10639c = iArr;
        this.f10640d = strArr;
        this.i = null;
        this.j = null;
        this.k = null;
        this.f10641e = iArr2;
        this.f10642f = bArr2;
        this.f10643g = experimentTokensArr;
        this.f10644h = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zze) {
            zze zzeVar = (zze) obj;
            if (Objects.a(this.f10637a, zzeVar.f10637a) && Arrays.equals(this.f10638b, zzeVar.f10638b) && Arrays.equals(this.f10639c, zzeVar.f10639c) && Arrays.equals(this.f10640d, zzeVar.f10640d) && Objects.a(this.i, zzeVar.i) && Objects.a(this.j, zzeVar.j) && Objects.a(this.k, zzeVar.k) && Arrays.equals(this.f10641e, zzeVar.f10641e) && Arrays.deepEquals(this.f10642f, zzeVar.f10642f) && Arrays.equals(this.f10643g, zzeVar.f10643g) && this.f10644h == zzeVar.f10644h) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.a(this.f10637a, this.f10638b, this.f10639c, this.f10640d, this.i, this.j, this.k, this.f10641e, this.f10642f, this.f10643g, Boolean.valueOf(this.f10644h));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LogEventParcelable[");
        sb.append(this.f10637a);
        sb.append(", LogEventBytes: ");
        byte[] bArr = this.f10638b;
        sb.append(bArr == null ? null : new String(bArr));
        sb.append(", TestCodes: ");
        sb.append(Arrays.toString(this.f10639c));
        sb.append(", MendelPackages: ");
        sb.append(Arrays.toString(this.f10640d));
        sb.append(", LogEvent: ");
        sb.append(this.i);
        sb.append(", ExtensionProducer: ");
        sb.append(this.j);
        sb.append(", VeProducer: ");
        sb.append(this.k);
        sb.append(", ExperimentIDs: ");
        sb.append(Arrays.toString(this.f10641e));
        sb.append(", ExperimentTokens: ");
        sb.append(Arrays.toString(this.f10642f));
        sb.append(", ExperimentTokensParcelables: ");
        sb.append(Arrays.toString(this.f10643g));
        sb.append(", AddPhenotypeExperimentTokens: ");
        sb.append(this.f10644h);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.f10637a, i, false);
        SafeParcelWriter.a(parcel, 3, this.f10638b, false);
        SafeParcelWriter.a(parcel, 4, this.f10639c, false);
        SafeParcelWriter.a(parcel, 5, this.f10640d, false);
        SafeParcelWriter.a(parcel, 6, this.f10641e, false);
        SafeParcelWriter.a(parcel, 7, this.f10642f, false);
        SafeParcelWriter.a(parcel, 8, this.f10644h);
        SafeParcelWriter.a(parcel, 9, (Parcelable[]) this.f10643g, i, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
