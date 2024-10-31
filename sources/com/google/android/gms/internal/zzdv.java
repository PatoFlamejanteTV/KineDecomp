package com.google.android.gms.internal;

import com.google.android.gms.common.api.Releasable;

@zzgr
/* loaded from: classes.dex */
public abstract class zzdv implements Releasable {
    protected zziz zzoM;

    public zzdv(zziz zzizVar) {
        this.zzoM = zzizVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String zzad(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1396664534:
                if (str.equals("badUrl")) {
                    c = 6;
                    break;
                }
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    c = 2;
                    break;
                }
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    c = 7;
                    break;
                }
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    c = 3;
                    break;
                }
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    c = 1;
                    break;
                }
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    c = '\b';
                    break;
                }
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    c = '\t';
                    break;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    c = 0;
                    break;
                }
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    c = 5;
                    break;
                }
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
                return "internal";
            case 4:
            case 5:
                return "io";
            case 6:
            case 7:
                return "network";
            case '\b':
            case '\t':
                return "policy";
            default:
                return "internal";
        }
    }

    public abstract void abort();

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zza(String str, String str2, int i) {
        com.google.android.gms.ads.internal.util.client.zza.f654a.post(new ax(this, str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zza(String str, String str2, int i, int i2, boolean z) {
        com.google.android.gms.ads.internal.util.client.zza.f654a.post(new aw(this, str, str2, i, i2, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zza(String str, String str2, String str3, String str4) {
        com.google.android.gms.ads.internal.util.client.zza.f654a.post(new ay(this, str, str2, str3, str4));
    }

    public abstract boolean zzab(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public String zzac(String str) {
        return com.google.android.gms.ads.internal.client.zzl.a().a(str);
    }
}
