package com.google.android.gms.internal.firebase_auth;

/* loaded from: classes2.dex */
public class zzjf extends Enum<zzjf> {
    public static final zzjf zzacz;
    public static final zzjf zzada = new zzjf("GROUP", 9, zzjk.MESSAGE, 3) { // from class: com.google.android.gms.internal.firebase_auth.zzjh
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            int i5 = 9;
            int i6 = 3;
            Qa qa = null;
        }
    };
    public static final zzjf zzadb;
    public static final zzjf zzadc;
    private static final /* synthetic */ zzjf[] zzadl;
    private final zzjk zzadj;
    private final int zzadk;
    public static final zzjf zzacr = new zzjf("DOUBLE", 0, zzjk.DOUBLE, 1);
    public static final zzjf zzacs = new zzjf("FLOAT", 1, zzjk.FLOAT, 5);
    public static final zzjf zzact = new zzjf("INT64", 2, zzjk.LONG, 0);
    public static final zzjf zzacu = new zzjf("UINT64", 3, zzjk.LONG, 0);
    public static final zzjf zzacv = new zzjf("INT32", 4, zzjk.INT, 0);
    public static final zzjf zzacw = new zzjf("FIXED64", 5, zzjk.LONG, 1);
    public static final zzjf zzacx = new zzjf("FIXED32", 6, zzjk.INT, 5);
    public static final zzjf zzacy = new zzjf("BOOL", 7, zzjk.BOOLEAN, 0);
    public static final zzjf zzadd = new zzjf("UINT32", 12, zzjk.INT, 0);
    public static final zzjf zzade = new zzjf("ENUM", 13, zzjk.ENUM, 0);
    public static final zzjf zzadf = new zzjf("SFIXED32", 14, zzjk.INT, 5);
    public static final zzjf zzadg = new zzjf("SFIXED64", 15, zzjk.LONG, 1);
    public static final zzjf zzadh = new zzjf("SINT32", 16, zzjk.INT, 0);
    public static final zzjf zzadi = new zzjf("SINT64", 17, zzjk.LONG, 0);

    static {
        int i = 2;
        zzacz = new zzjf("STRING", 8, zzjk.STRING, i) { // from class: com.google.android.gms.internal.firebase_auth.zzjg
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i4 = 8;
                int i5 = 2;
                Qa qa = null;
            }
        };
        zzadb = new zzjf("MESSAGE", 10, zzjk.MESSAGE, i) { // from class: com.google.android.gms.internal.firebase_auth.zzji
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i6 = 10;
                int i7 = 2;
                Qa qa = null;
            }
        };
        zzadc = new zzjf("BYTES", 11, zzjk.BYTE_STRING, i) { // from class: com.google.android.gms.internal.firebase_auth.zzjj
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i7 = 11;
                int i8 = 2;
                Qa qa = null;
            }
        };
        zzadl = new zzjf[]{zzacr, zzacs, zzact, zzacu, zzacv, zzacw, zzacx, zzacy, zzacz, zzada, zzadb, zzadc, zzadd, zzade, zzadf, zzadg, zzadh, zzadi};
    }

    private zzjf(String str, int i, zzjk zzjkVar, int i2) {
        super(str, i);
        this.zzadj = zzjkVar;
        this.zzadk = i2;
    }

    public static zzjf[] values() {
        return (zzjf[]) zzadl.clone();
    }

    public final zzjk zzjy() {
        return this.zzadj;
    }

    public final int zzjz() {
        return this.zzadk;
    }

    public /* synthetic */ zzjf(String str, int i, zzjk zzjkVar, int i2, Qa qa) {
        this(str, i, zzjkVar, i2);
    }
}
