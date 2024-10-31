package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes2.dex */
public final class zzi extends AbstractSafeParcelable implements Comparable<zzi> {
    public static final Parcelable.Creator<zzi> CREATOR = new zzk();

    /* renamed from: a */
    private static final Comparator<zzi> f14111a = new e();

    /* renamed from: b */
    public final String f14112b;

    /* renamed from: c */
    private final long f14113c;

    /* renamed from: d */
    private final boolean f14114d;

    /* renamed from: e */
    private final double f14115e;

    /* renamed from: f */
    private final String f14116f;

    /* renamed from: g */
    private final byte[] f14117g;

    /* renamed from: h */
    private final int f14118h;
    public final int i;

    @SafeParcelable.Constructor
    public zzi(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) double d2, @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) byte[] bArr, @SafeParcelable.Param(id = 8) int i, @SafeParcelable.Param(id = 9) int i2) {
        this.f14112b = str;
        this.f14113c = j;
        this.f14114d = z;
        this.f14115e = d2;
        this.f14116f = str2;
        this.f14117g = bArr;
        this.f14118h = i;
        this.i = i2;
    }

    private static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzi zziVar) {
        zzi zziVar2 = zziVar;
        int compareTo = this.f14112b.compareTo(zziVar2.f14112b);
        if (compareTo != 0) {
            return compareTo;
        }
        int a2 = a(this.f14118h, zziVar2.f14118h);
        if (a2 != 0) {
            return a2;
        }
        int i = this.f14118h;
        if (i == 1) {
            long j = this.f14113c;
            long j2 = zziVar2.f14113c;
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }
        if (i == 2) {
            boolean z = this.f14114d;
            if (z == zziVar2.f14114d) {
                return 0;
            }
            return z ? 1 : -1;
        }
        if (i == 3) {
            return Double.compare(this.f14115e, zziVar2.f14115e);
        }
        if (i == 4) {
            String str = this.f14116f;
            String str2 = zziVar2.f14116f;
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return str.compareTo(str2);
        }
        if (i != 5) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Invalid enum value: ");
            sb.append(i);
            throw new AssertionError(sb.toString());
        }
        byte[] bArr = this.f14117g;
        byte[] bArr2 = zziVar2.f14117g;
        if (bArr == bArr2) {
            return 0;
        }
        if (bArr == null) {
            return -1;
        }
        if (bArr2 == null) {
            return 1;
        }
        for (int i2 = 0; i2 < Math.min(this.f14117g.length, zziVar2.f14117g.length); i2++) {
            int i3 = this.f14117g[i2] - zziVar2.f14117g[i2];
            if (i3 != 0) {
                return i3;
            }
        }
        return a(this.f14117g.length, zziVar2.f14117g.length);
    }

    public final boolean equals(Object obj) {
        int i;
        if (obj instanceof zzi) {
            zzi zziVar = (zzi) obj;
            if (zzn.a(this.f14112b, zziVar.f14112b) && (i = this.f14118h) == zziVar.f14118h && this.i == zziVar.i) {
                if (i != 1) {
                    if (i == 2) {
                        return this.f14114d == zziVar.f14114d;
                    }
                    if (i == 3) {
                        return this.f14115e == zziVar.f14115e;
                    }
                    if (i == 4) {
                        return zzn.a(this.f14116f, zziVar.f14116f);
                    }
                    if (i == 5) {
                        return Arrays.equals(this.f14117g, zziVar.f14117g);
                    }
                    StringBuilder sb = new StringBuilder(31);
                    sb.append("Invalid enum value: ");
                    sb.append(i);
                    throw new AssertionError(sb.toString());
                }
                if (this.f14113c == zziVar.f14113c) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Flag(");
        sb.append(this.f14112b);
        sb.append(", ");
        int i = this.f14118h;
        if (i == 1) {
            sb.append(this.f14113c);
        } else if (i == 2) {
            sb.append(this.f14114d);
        } else if (i != 3) {
            if (i == 4) {
                sb.append("'");
                str = this.f14116f;
            } else {
                if (i != 5) {
                    String str2 = this.f14112b;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 27);
                    sb2.append("Invalid type: ");
                    sb2.append(str2);
                    sb2.append(", ");
                    sb2.append(i);
                    throw new AssertionError(sb2.toString());
                }
                if (this.f14117g == null) {
                    sb.append("null");
                } else {
                    sb.append("'");
                    str = Base64.encodeToString(this.f14117g, 3);
                }
            }
            sb.append(str);
            sb.append("'");
        } else {
            sb.append(this.f14115e);
        }
        sb.append(", ");
        sb.append(this.f14118h);
        sb.append(", ");
        sb.append(this.i);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.f14112b, false);
        SafeParcelWriter.a(parcel, 3, this.f14113c);
        SafeParcelWriter.a(parcel, 4, this.f14114d);
        SafeParcelWriter.a(parcel, 5, this.f14115e);
        SafeParcelWriter.a(parcel, 6, this.f14116f, false);
        SafeParcelWriter.a(parcel, 7, this.f14117g, false);
        SafeParcelWriter.a(parcel, 8, this.f14118h);
        SafeParcelWriter.a(parcel, 9, this.i);
        SafeParcelWriter.a(parcel, a2);
    }
}
