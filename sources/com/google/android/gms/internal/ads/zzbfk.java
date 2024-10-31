package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class zzbfk implements Releasable {
    protected Context mContext;
    protected String zzeiz;
    protected WeakReference<zzbdz> zzewo;

    public zzbfk(zzbdz zzbdzVar) {
        this.mContext = zzbdzVar.getContext();
        this.zzeiz = com.google.android.gms.ads.internal.zzbv.e().zzo(this.mContext, zzbdzVar.zzabz().zzdp);
        this.zzewo = new WeakReference<>(zzbdzVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String zzez(String str) {
        char c2;
        switch (str.hashCode()) {
            case -1947652542:
                if (str.equals("interrupted")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -1396664534:
                if (str.equals("badUrl")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 3387234:
                if (str.equals("noop")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 96784904:
                if (str.equals("error")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            default:
                return UMModuleRegister.INNER;
            case 6:
            case 7:
                return "io";
            case '\b':
            case '\t':
                return "network";
            case '\n':
            case 11:
                return "policy";
        }
    }

    public abstract void abort();

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    @VisibleForTesting
    public final void zza(String str, String str2, long j, long j2, boolean z, int i, int i2) {
        zzbat.zztu.post(new RunnableC1054qf(this, str, str2, j, j2, z, i, i2));
    }

    @VisibleForTesting
    public final void zzc(String str, String str2, long j) {
        zzbat.zztu.post(new RunnableC1081sf(this, str, str2, j));
    }

    public void zzcz(int i) {
    }

    public void zzda(int i) {
    }

    public void zzdb(int i) {
    }

    public void zzdc(int i) {
    }

    public abstract boolean zzex(String str);

    public String zzey(String str) {
        zzwu.zzpv();
        return zzbat.zzei(str);
    }

    public final void zza(String str, String str2, int i) {
        zzbat.zztu.post(new RunnableC1067rf(this, str, str2, i));
    }

    @VisibleForTesting
    public final void zza(String str, String str2, String str3, String str4) {
        zzbat.zztu.post(new RunnableC1095tf(this, str, str2, str3, str4));
    }

    public final void zza(String str, Map<String, String> map) {
        zzbdz zzbdzVar = this.zzewo.get();
        if (zzbdzVar != null) {
            zzbdzVar.zza(str, map);
        }
    }
}
