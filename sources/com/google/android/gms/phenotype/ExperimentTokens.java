package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@KeepForSdk
/* loaded from: classes2.dex */
public class ExperimentTokens extends AbstractSafeParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<ExperimentTokens> CREATOR = new zzh();

    /* renamed from: a */
    private static final byte[][] f14093a = new byte[0];

    /* renamed from: b */
    private static final ExperimentTokens f14094b;

    /* renamed from: c */
    private static final a f14095c;

    /* renamed from: d */
    private static final a f14096d;

    /* renamed from: e */
    private static final a f14097e;

    /* renamed from: f */
    private static final a f14098f;

    /* renamed from: g */
    private final String f14099g;

    /* renamed from: h */
    private final byte[] f14100h;
    private final byte[][] i;
    private final byte[][] j;
    private final byte[][] k;
    private final byte[][] l;
    private final int[] m;
    private final byte[][] n;

    /* loaded from: classes2.dex */
    public interface a {
    }

    static {
        byte[][] bArr = f14093a;
        f14094b = new ExperimentTokens("", null, bArr, bArr, bArr, bArr, null, null);
        f14095c = new com.google.android.gms.phenotype.a();
        f14096d = new b();
        f14097e = new c();
        f14098f = new d();
    }

    @SafeParcelable.Constructor
    public ExperimentTokens(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) byte[] bArr, @SafeParcelable.Param(id = 4) byte[][] bArr2, @SafeParcelable.Param(id = 5) byte[][] bArr3, @SafeParcelable.Param(id = 6) byte[][] bArr4, @SafeParcelable.Param(id = 7) byte[][] bArr5, @SafeParcelable.Param(id = 8) int[] iArr, @SafeParcelable.Param(id = 9) byte[][] bArr6) {
        this.f14099g = str;
        this.f14100h = bArr;
        this.i = bArr2;
        this.j = bArr3;
        this.k = bArr4;
        this.l = bArr5;
        this.m = iArr;
        this.n = bArr6;
    }

    private static List<Integer> a(int[] iArr) {
        if (iArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static List<String> a(byte[][] bArr) {
        if (bArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte[] bArr2 : bArr) {
            arrayList.add(Base64.encodeToString(bArr2, 3));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static void a(StringBuilder sb, String str, byte[][] bArr) {
        String str2;
        sb.append(str);
        sb.append("=");
        if (bArr == null) {
            str2 = "null";
        } else {
            sb.append("(");
            int length = bArr.length;
            int i = 0;
            boolean z = true;
            while (i < length) {
                byte[] bArr2 = bArr[i];
                if (!z) {
                    sb.append(", ");
                }
                sb.append("'");
                sb.append(Base64.encodeToString(bArr2, 3));
                sb.append("'");
                i++;
                z = false;
            }
            str2 = ")";
        }
        sb.append(str2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ExperimentTokens) {
            ExperimentTokens experimentTokens = (ExperimentTokens) obj;
            if (zzn.a(this.f14099g, experimentTokens.f14099g) && Arrays.equals(this.f14100h, experimentTokens.f14100h) && zzn.a(a(this.i), a(experimentTokens.i)) && zzn.a(a(this.j), a(experimentTokens.j)) && zzn.a(a(this.k), a(experimentTokens.k)) && zzn.a(a(this.l), a(experimentTokens.l)) && zzn.a(a(this.m), a(experimentTokens.m)) && zzn.a(a(this.n), a(experimentTokens.n))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String sb;
        StringBuilder sb2 = new StringBuilder("ExperimentTokens");
        sb2.append("(");
        String str = this.f14099g;
        if (str == null) {
            sb = "null";
        } else {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 2);
            sb3.append("'");
            sb3.append(str);
            sb3.append("'");
            sb = sb3.toString();
        }
        sb2.append(sb);
        sb2.append(", ");
        byte[] bArr = this.f14100h;
        sb2.append("direct");
        sb2.append("=");
        if (bArr == null) {
            sb2.append("null");
        } else {
            sb2.append("'");
            sb2.append(Base64.encodeToString(bArr, 3));
            sb2.append("'");
        }
        sb2.append(", ");
        a(sb2, "GAIA", this.i);
        sb2.append(", ");
        a(sb2, "PSEUDO", this.j);
        sb2.append(", ");
        a(sb2, "ALWAYS", this.k);
        sb2.append(", ");
        a(sb2, "OTHER", this.l);
        sb2.append(", ");
        int[] iArr = this.m;
        sb2.append("weak");
        sb2.append("=");
        if (iArr == null) {
            sb2.append("null");
        } else {
            sb2.append("(");
            int length = iArr.length;
            int i = 0;
            boolean z = true;
            while (i < length) {
                int i2 = iArr[i];
                if (!z) {
                    sb2.append(", ");
                }
                sb2.append(i2);
                i++;
                z = false;
            }
            sb2.append(")");
        }
        sb2.append(", ");
        a(sb2, "directs", this.n);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.f14099g, false);
        SafeParcelWriter.a(parcel, 3, this.f14100h, false);
        SafeParcelWriter.a(parcel, 4, this.i, false);
        SafeParcelWriter.a(parcel, 5, this.j, false);
        SafeParcelWriter.a(parcel, 6, this.k, false);
        SafeParcelWriter.a(parcel, 7, this.l, false);
        SafeParcelWriter.a(parcel, 8, this.m, false);
        SafeParcelWriter.a(parcel, 9, this.n, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
