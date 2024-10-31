package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class zzbwh {
    public static final zzbwh zzgda = new zzbwh(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzbwh zzgdb = new zzbwh(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzbwh zzgdc = new zzbwh(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzbwh zzgdd = new zzbwh(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: a */
    private final double f12737a;

    /* renamed from: b */
    private final double f12738b;

    /* renamed from: c */
    private final double f12739c;

    /* renamed from: d */
    private final double f12740d;
    private final double w;
    private final double zzgcw;
    private final double zzgcx;
    private final double zzgcy;
    private final double zzgcz;

    private zzbwh(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        this.zzgcw = d6;
        this.zzgcx = d7;
        this.w = d8;
        this.f12737a = d2;
        this.f12738b = d3;
        this.f12739c = d4;
        this.f12740d = d5;
        this.zzgcy = d9;
        this.zzgcz = d10;
    }

    public static zzbwh zzq(ByteBuffer byteBuffer) {
        double zzd = zzbb.zzd(byteBuffer);
        double zzd2 = zzbb.zzd(byteBuffer);
        double zze = zzbb.zze(byteBuffer);
        return new zzbwh(zzd, zzd2, zzbb.zzd(byteBuffer), zzbb.zzd(byteBuffer), zze, zzbb.zze(byteBuffer), zzbb.zze(byteBuffer), zzbb.zzd(byteBuffer), zzbb.zzd(byteBuffer));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzbwh.class != obj.getClass()) {
            return false;
        }
        zzbwh zzbwhVar = (zzbwh) obj;
        return Double.compare(zzbwhVar.f12737a, this.f12737a) == 0 && Double.compare(zzbwhVar.f12738b, this.f12738b) == 0 && Double.compare(zzbwhVar.f12739c, this.f12739c) == 0 && Double.compare(zzbwhVar.f12740d, this.f12740d) == 0 && Double.compare(zzbwhVar.zzgcy, this.zzgcy) == 0 && Double.compare(zzbwhVar.zzgcz, this.zzgcz) == 0 && Double.compare(zzbwhVar.zzgcw, this.zzgcw) == 0 && Double.compare(zzbwhVar.zzgcx, this.zzgcx) == 0 && Double.compare(zzbwhVar.w, this.w) == 0;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzgcw);
        long doubleToLongBits2 = Double.doubleToLongBits(this.zzgcx);
        int i = (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.w);
        int i2 = (i * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.f12737a);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(this.f12738b);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
        long doubleToLongBits6 = Double.doubleToLongBits(this.f12739c);
        int i5 = (i4 * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)));
        long doubleToLongBits7 = Double.doubleToLongBits(this.f12740d);
        int i6 = (i5 * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)));
        long doubleToLongBits8 = Double.doubleToLongBits(this.zzgcy);
        int i7 = (i6 * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)));
        long doubleToLongBits9 = Double.doubleToLongBits(this.zzgcz);
        return (i7 * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(zzgda)) {
            return "Rotate 0°";
        }
        if (equals(zzgdb)) {
            return "Rotate 90°";
        }
        if (equals(zzgdc)) {
            return "Rotate 180°";
        }
        if (equals(zzgdd)) {
            return "Rotate 270°";
        }
        double d2 = this.zzgcw;
        double d3 = this.zzgcx;
        double d4 = this.w;
        double d5 = this.f12737a;
        double d6 = this.f12738b;
        double d7 = this.f12739c;
        double d8 = this.f12740d;
        double d9 = this.zzgcy;
        double d10 = this.zzgcz;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d2);
        sb.append(", v=");
        sb.append(d3);
        sb.append(", w=");
        sb.append(d4);
        sb.append(", a=");
        sb.append(d5);
        sb.append(", b=");
        sb.append(d6);
        sb.append(", c=");
        sb.append(d7);
        sb.append(", d=");
        sb.append(d8);
        sb.append(", tx=");
        sb.append(d9);
        sb.append(", ty=");
        sb.append(d10);
        sb.append("}");
        return sb.toString();
    }
}
