package com.google.android.gms.internal.clearcut;

/* loaded from: classes2.dex */
public class zzfl extends Enum<zzfl> {
    public static final zzfl zzqk;
    public static final zzfl zzql = new zzfl("GROUP", 9, zzfq.MESSAGE, 3) { // from class: com.google.android.gms.internal.clearcut.zzfn
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            int i5 = 9;
            int i6 = 3;
            Ra ra = null;
        }
    };
    public static final zzfl zzqm;
    public static final zzfl zzqn;
    private static final /* synthetic */ zzfl[] zzqw;
    private final zzfq zzqu;
    private final int zzqv;
    public static final zzfl zzqc = new zzfl("DOUBLE", 0, zzfq.DOUBLE, 1);
    public static final zzfl zzqd = new zzfl("FLOAT", 1, zzfq.FLOAT, 5);
    public static final zzfl zzqe = new zzfl("INT64", 2, zzfq.LONG, 0);
    public static final zzfl zzqf = new zzfl("UINT64", 3, zzfq.LONG, 0);
    public static final zzfl zzqg = new zzfl("INT32", 4, zzfq.INT, 0);
    public static final zzfl zzqh = new zzfl("FIXED64", 5, zzfq.LONG, 1);
    public static final zzfl zzqi = new zzfl("FIXED32", 6, zzfq.INT, 5);
    public static final zzfl zzqj = new zzfl("BOOL", 7, zzfq.BOOLEAN, 0);
    public static final zzfl zzqo = new zzfl("UINT32", 12, zzfq.INT, 0);
    public static final zzfl zzqp = new zzfl("ENUM", 13, zzfq.ENUM, 0);
    public static final zzfl zzqq = new zzfl("SFIXED32", 14, zzfq.INT, 5);
    public static final zzfl zzqr = new zzfl("SFIXED64", 15, zzfq.LONG, 1);
    public static final zzfl zzqs = new zzfl("SINT32", 16, zzfq.INT, 0);
    public static final zzfl zzqt = new zzfl("SINT64", 17, zzfq.LONG, 0);

    static {
        int i = 2;
        zzqk = new zzfl("STRING", 8, zzfq.STRING, i) { // from class: com.google.android.gms.internal.clearcut.zzfm
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i4 = 8;
                int i5 = 2;
                Ra ra = null;
            }
        };
        zzqm = new zzfl("MESSAGE", 10, zzfq.MESSAGE, i) { // from class: com.google.android.gms.internal.clearcut.zzfo
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i6 = 10;
                int i7 = 2;
                Ra ra = null;
            }
        };
        zzqn = new zzfl("BYTES", 11, zzfq.BYTE_STRING, i) { // from class: com.google.android.gms.internal.clearcut.zzfp
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i7 = 11;
                int i8 = 2;
                Ra ra = null;
            }
        };
        zzqw = new zzfl[]{zzqc, zzqd, zzqe, zzqf, zzqg, zzqh, zzqi, zzqj, zzqk, zzql, zzqm, zzqn, zzqo, zzqp, zzqq, zzqr, zzqs, zzqt};
    }

    private zzfl(String str, int i, zzfq zzfqVar, int i2) {
        super(str, i);
        this.zzqu = zzfqVar;
        this.zzqv = i2;
    }

    public /* synthetic */ zzfl(String str, int i, zzfq zzfqVar, int i2, Ra ra) {
        this(str, i, zzfqVar, i2);
    }

    public static zzfl[] values() {
        return (zzfl[]) zzqw.clone();
    }

    public final zzfq zzek() {
        return this.zzqu;
    }

    public final int zzel() {
        return this.zzqv;
    }
}
