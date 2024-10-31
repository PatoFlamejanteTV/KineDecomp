package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public class zzbuj extends Enum<zzbuj> {
    public static final zzbuj zzfvh;
    public static final zzbuj zzfvi = new zzbuj("GROUP", 9, zzbuo.MESSAGE, 3) { // from class: com.google.android.gms.internal.ads.zzbul
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            int i5 = 9;
            int i6 = 3;
            Wi wi = null;
        }
    };
    public static final zzbuj zzfvj;
    public static final zzbuj zzfvk;
    private static final /* synthetic */ zzbuj[] zzfvt;
    private final zzbuo zzfvr;
    private final int zzfvs;
    public static final zzbuj zzfuz = new zzbuj("DOUBLE", 0, zzbuo.DOUBLE, 1);
    public static final zzbuj zzfva = new zzbuj("FLOAT", 1, zzbuo.FLOAT, 5);
    public static final zzbuj zzfvb = new zzbuj("INT64", 2, zzbuo.LONG, 0);
    public static final zzbuj zzfvc = new zzbuj("UINT64", 3, zzbuo.LONG, 0);
    public static final zzbuj zzfvd = new zzbuj("INT32", 4, zzbuo.INT, 0);
    public static final zzbuj zzfve = new zzbuj("FIXED64", 5, zzbuo.LONG, 1);
    public static final zzbuj zzfvf = new zzbuj("FIXED32", 6, zzbuo.INT, 5);
    public static final zzbuj zzfvg = new zzbuj("BOOL", 7, zzbuo.BOOLEAN, 0);
    public static final zzbuj zzfvl = new zzbuj("UINT32", 12, zzbuo.INT, 0);
    public static final zzbuj zzfvm = new zzbuj("ENUM", 13, zzbuo.ENUM, 0);
    public static final zzbuj zzfvn = new zzbuj("SFIXED32", 14, zzbuo.INT, 5);
    public static final zzbuj zzfvo = new zzbuj("SFIXED64", 15, zzbuo.LONG, 1);
    public static final zzbuj zzfvp = new zzbuj("SINT32", 16, zzbuo.INT, 0);
    public static final zzbuj zzfvq = new zzbuj("SINT64", 17, zzbuo.LONG, 0);

    static {
        int i = 2;
        zzfvh = new zzbuj("STRING", 8, zzbuo.STRING, i) { // from class: com.google.android.gms.internal.ads.zzbuk
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i4 = 8;
                int i5 = 2;
                Wi wi = null;
            }
        };
        zzfvj = new zzbuj("MESSAGE", 10, zzbuo.MESSAGE, i) { // from class: com.google.android.gms.internal.ads.zzbum
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i6 = 10;
                int i7 = 2;
                Wi wi = null;
            }
        };
        zzfvk = new zzbuj("BYTES", 11, zzbuo.BYTE_STRING, i) { // from class: com.google.android.gms.internal.ads.zzbun
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i7 = 11;
                int i8 = 2;
                Wi wi = null;
            }
        };
        zzfvt = new zzbuj[]{zzfuz, zzfva, zzfvb, zzfvc, zzfvd, zzfve, zzfvf, zzfvg, zzfvh, zzfvi, zzfvj, zzfvk, zzfvl, zzfvm, zzfvn, zzfvo, zzfvp, zzfvq};
    }

    private zzbuj(String str, int i, zzbuo zzbuoVar, int i2) {
        super(str, i);
        this.zzfvr = zzbuoVar;
        this.zzfvs = i2;
    }

    public static zzbuj[] values() {
        return (zzbuj[]) zzfvt.clone();
    }

    public final zzbuo zzapj() {
        return this.zzfvr;
    }

    public final int zzapk() {
        return this.zzfvs;
    }

    public /* synthetic */ zzbuj(String str, int i, zzbuo zzbuoVar, int i2, Wi wi) {
        this(str, i, zzbuoVar, i2);
    }
}
