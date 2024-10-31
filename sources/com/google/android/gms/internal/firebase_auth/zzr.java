package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzr extends zzft<zzr, zza> implements zzhe {
    private static final zzr zzfl = new zzr();
    private static volatile zzhm<zzr> zzm;
    private String zzby;
    private boolean zzcg;
    private long zzcs;
    private long zzct;
    private zzgb<zzm> zzcv;
    private boolean zzcy;
    private String zzei;
    private zzeh zzfe;
    private zzeh zzff;
    private int zzfg;
    private long zzfh;
    private long zzfi;
    private boolean zzfj;
    private String zzfk;
    private int zzi;
    private String zzao = "";
    private String zzat = "";
    private String zzcd = "";
    private zzgb<String> zzcf = zzft.zzhf();
    private String zzdp = "";
    private String zzcn = "";
    private String zzdq = "";
    private String zzdr = "";

    /* loaded from: classes2.dex */
    public static final class zza extends zzft.zza<zzr, zza> implements zzhe {
        private zza() {
            super(zzr.zzfl);
        }

        /* synthetic */ zza(_a _aVar) {
            this();
        }
    }

    static {
        zzft.zza((Class<zzr>) zzr.class, zzfl);
    }

    private zzr() {
        zzeh zzehVar = zzeh.zzso;
        this.zzfe = zzehVar;
        this.zzff = zzehVar;
        this.zzcv = zzft.zzhf();
        this.zzei = "";
        this.zzfk = "";
        this.zzby = "";
    }

    public final String getDisplayName() {
        return this.zzcd;
    }

    public final String getEmail() {
        return this.zzat;
    }

    public final String getLocalId() {
        return this.zzao;
    }

    public final String getPhoneNumber() {
        return this.zzby;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.firebase_auth.zzft
    public final Object zza(int i, Object obj, Object obj2) {
        _a _aVar = null;
        switch (_a.f13009a[i - 1]) {
            case 1:
                return new zzr();
            case 2:
                return new zza(_aVar);
            case 3:
                return zzft.zza(zzfl, "\u0001\u0016\u0000\u0001\u0001\u0016\u0016\u0000\u0002\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u001a\u0005\b\u0003\u0006\b\u0004\u0007\b\u0005\b\b\u0006\t\n\u0007\n\n\b\u000b\u0004\t\f\u0007\n\r\u0002\u000b\u000e\u001b\u000f\u0002\f\u0010\u0007\r\u0011\u0002\u000e\u0012\u0002\u000f\u0013\b\u0010\u0014\u0007\u0011\u0015\b\u0012\u0016\b\u0013", new Object[]{"zzi", "zzao", "zzat", "zzcd", "zzcf", "zzdp", "zzcn", "zzdq", "zzdr", "zzfe", "zzff", "zzfg", "zzcg", "zzfh", "zzcv", zzm.class, "zzfi", "zzcy", "zzcs", "zzct", "zzei", "zzfj", "zzfk", "zzby"});
            case 4:
                return zzfl;
            case 5:
                zzhm<zzr> zzhmVar = zzm;
                if (zzhmVar == null) {
                    synchronized (zzr.class) {
                        zzhmVar = zzm;
                        if (zzhmVar == null) {
                            zzhmVar = new zzft.zzb<>(zzfl);
                            zzm = zzhmVar;
                        }
                    }
                }
                return zzhmVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final List<zzm> zzak() {
        return this.zzcv;
    }

    public final String zzal() {
        return this.zzcn;
    }

    public final boolean zzan() {
        return this.zzcg;
    }

    public final long zzbk() {
        return this.zzcs;
    }

    public final long zzbl() {
        return this.zzct;
    }

    public final String zzbm() {
        return this.zzfk;
    }
}
