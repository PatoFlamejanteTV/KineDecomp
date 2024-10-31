package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
public class zzug extends Enum<zzug> {
    public static final zzug zzbfx;
    public static final zzug zzbfy = new zzug("GROUP", 9, zzul.MESSAGE, 3) { // from class: com.google.android.gms.internal.gtm.zzui
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            int i5 = 9;
            int i6 = 3;
            Bb bb = null;
        }
    };
    public static final zzug zzbfz;
    public static final zzug zzbga;
    private static final /* synthetic */ zzug[] zzbgj;
    private final zzul zzbgh;
    private final int zzbgi;
    public static final zzug zzbfp = new zzug("DOUBLE", 0, zzul.DOUBLE, 1);
    public static final zzug zzbfq = new zzug("FLOAT", 1, zzul.FLOAT, 5);
    public static final zzug zzbfr = new zzug("INT64", 2, zzul.LONG, 0);
    public static final zzug zzbfs = new zzug("UINT64", 3, zzul.LONG, 0);
    public static final zzug zzbft = new zzug("INT32", 4, zzul.INT, 0);
    public static final zzug zzbfu = new zzug("FIXED64", 5, zzul.LONG, 1);
    public static final zzug zzbfv = new zzug("FIXED32", 6, zzul.INT, 5);
    public static final zzug zzbfw = new zzug("BOOL", 7, zzul.BOOLEAN, 0);
    public static final zzug zzbgb = new zzug("UINT32", 12, zzul.INT, 0);
    public static final zzug zzbgc = new zzug("ENUM", 13, zzul.ENUM, 0);
    public static final zzug zzbgd = new zzug("SFIXED32", 14, zzul.INT, 5);
    public static final zzug zzbge = new zzug("SFIXED64", 15, zzul.LONG, 1);
    public static final zzug zzbgf = new zzug("SINT32", 16, zzul.INT, 0);
    public static final zzug zzbgg = new zzug("SINT64", 17, zzul.LONG, 0);

    static {
        int i = 2;
        zzbfx = new zzug("STRING", 8, zzul.STRING, i) { // from class: com.google.android.gms.internal.gtm.zzuh
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i4 = 8;
                int i5 = 2;
                Bb bb = null;
            }
        };
        zzbfz = new zzug("MESSAGE", 10, zzul.MESSAGE, i) { // from class: com.google.android.gms.internal.gtm.zzuj
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i6 = 10;
                int i7 = 2;
                Bb bb = null;
            }
        };
        zzbga = new zzug("BYTES", 11, zzul.BYTE_STRING, i) { // from class: com.google.android.gms.internal.gtm.zzuk
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i7 = 11;
                int i8 = 2;
                Bb bb = null;
            }
        };
        zzbgj = new zzug[]{zzbfp, zzbfq, zzbfr, zzbfs, zzbft, zzbfu, zzbfv, zzbfw, zzbfx, zzbfy, zzbfz, zzbga, zzbgb, zzbgc, zzbgd, zzbge, zzbgf, zzbgg};
    }

    private zzug(String str, int i, zzul zzulVar, int i2) {
        super(str, i);
        this.zzbgh = zzulVar;
        this.zzbgi = i2;
    }

    public static zzug[] values() {
        return (zzug[]) zzbgj.clone();
    }

    public final zzul zzrs() {
        return this.zzbgh;
    }

    public final int zzrt() {
        return this.zzbgi;
    }

    public /* synthetic */ zzug(String str, int i, zzul zzulVar, int i2, Bb bb) {
        this(str, i, zzulVar, i2);
    }
}
