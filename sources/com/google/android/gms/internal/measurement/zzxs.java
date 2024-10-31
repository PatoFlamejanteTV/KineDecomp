package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public class zzxs extends Enum<zzxs> {
    public static final zzxs zzcdp;
    public static final zzxs zzcdq = new zzxs("GROUP", 9, zzxx.MESSAGE, 3) { // from class: com.google.android.gms.internal.measurement.zzxu
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            int i5 = 9;
            int i6 = 3;
            Eb eb = null;
        }
    };
    public static final zzxs zzcdr;
    public static final zzxs zzcds;
    private static final /* synthetic */ zzxs[] zzceb;
    private final zzxx zzcdz;
    private final int zzcea;
    public static final zzxs zzcdh = new zzxs("DOUBLE", 0, zzxx.DOUBLE, 1);
    public static final zzxs zzcdi = new zzxs("FLOAT", 1, zzxx.FLOAT, 5);
    public static final zzxs zzcdj = new zzxs("INT64", 2, zzxx.LONG, 0);
    public static final zzxs zzcdk = new zzxs("UINT64", 3, zzxx.LONG, 0);
    public static final zzxs zzcdl = new zzxs("INT32", 4, zzxx.INT, 0);
    public static final zzxs zzcdm = new zzxs("FIXED64", 5, zzxx.LONG, 1);
    public static final zzxs zzcdn = new zzxs("FIXED32", 6, zzxx.INT, 5);
    public static final zzxs zzcdo = new zzxs("BOOL", 7, zzxx.BOOLEAN, 0);
    public static final zzxs zzcdt = new zzxs("UINT32", 12, zzxx.INT, 0);
    public static final zzxs zzcdu = new zzxs("ENUM", 13, zzxx.ENUM, 0);
    public static final zzxs zzcdv = new zzxs("SFIXED32", 14, zzxx.INT, 5);
    public static final zzxs zzcdw = new zzxs("SFIXED64", 15, zzxx.LONG, 1);
    public static final zzxs zzcdx = new zzxs("SINT32", 16, zzxx.INT, 0);
    public static final zzxs zzcdy = new zzxs("SINT64", 17, zzxx.LONG, 0);

    static {
        int i = 2;
        zzcdp = new zzxs("STRING", 8, zzxx.STRING, i) { // from class: com.google.android.gms.internal.measurement.zzxt
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i4 = 8;
                int i5 = 2;
                Eb eb = null;
            }
        };
        zzcdr = new zzxs("MESSAGE", 10, zzxx.MESSAGE, i) { // from class: com.google.android.gms.internal.measurement.zzxv
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i6 = 10;
                int i7 = 2;
                Eb eb = null;
            }
        };
        zzcds = new zzxs("BYTES", 11, zzxx.BYTE_STRING, i) { // from class: com.google.android.gms.internal.measurement.zzxw
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i7 = 11;
                int i8 = 2;
                Eb eb = null;
            }
        };
        zzceb = new zzxs[]{zzcdh, zzcdi, zzcdj, zzcdk, zzcdl, zzcdm, zzcdn, zzcdo, zzcdp, zzcdq, zzcdr, zzcds, zzcdt, zzcdu, zzcdv, zzcdw, zzcdx, zzcdy};
    }

    private zzxs(String str, int i, zzxx zzxxVar, int i2) {
        super(str, i);
        this.zzcdz = zzxxVar;
        this.zzcea = i2;
    }

    public static zzxs[] values() {
        return (zzxs[]) zzceb.clone();
    }

    public final zzxx zzyv() {
        return this.zzcdz;
    }

    public final int zzyw() {
        return this.zzcea;
    }

    public /* synthetic */ zzxs(String str, int i, zzxx zzxxVar, int i2, Eb eb) {
        this(str, i, zzxxVar, i2);
    }
}
