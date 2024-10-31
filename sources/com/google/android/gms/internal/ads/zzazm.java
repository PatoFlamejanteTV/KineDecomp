package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;

@zzark
/* loaded from: classes2.dex */
public final class zzazm extends zzaj {
    private final Context mContext;

    private zzazm(Context context, zzar zzarVar) {
        super(zzarVar);
        this.mContext = context;
    }

    public static zzv zzbd(Context context) {
        zzv zzvVar = new zzv(new zzam(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzazm(context, new zzas()));
        zzvVar.start();
        return zzvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaj, com.google.android.gms.internal.ads.zzm
    public final zzp zzc(zzr<?> zzrVar) throws zzae {
        if (zzrVar.zzi() && zzrVar.getMethod() == 0) {
            if (Pattern.matches((String) zzwu.zzpz().zzd(zzaan.zzcvz), zzrVar.getUrl())) {
                zzwu.zzpv();
                if (zzbat.zzc(this.mContext, 13400000)) {
                    zzp zzc = new zzaft(this.mContext).zzc(zzrVar);
                    if (zzc != null) {
                        String valueOf = String.valueOf(zzrVar.getUrl());
                        zzaxz.v(valueOf.length() != 0 ? "Got gmscore asset response: ".concat(valueOf) : new String("Got gmscore asset response: "));
                        return zzc;
                    }
                    String valueOf2 = String.valueOf(zzrVar.getUrl());
                    zzaxz.v(valueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(valueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.zzc(zzrVar);
    }
}
