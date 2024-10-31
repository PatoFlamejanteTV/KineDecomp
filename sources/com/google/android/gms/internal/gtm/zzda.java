package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class zzda extends zzan {
    private String zzaau;
    private String zzaav;
    protected int zzaax;
    private int zzacu;
    protected boolean zzacv;
    private boolean zzacw;
    private boolean zzacx;

    public zzda(zzap zzapVar) {
        super(zzapVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void zzaw() {
        ApplicationInfo applicationInfo;
        int i;
        zzcc zzq;
        int i2;
        Context context = getContext();
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            zzd("PackageManager doesn't know about the app package", e2);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            zzt("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null || (i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) <= 0 || (zzq = new zzca(zzcm()).zzq(i)) == null) {
            return;
        }
        zzq("Loading global XML config values");
        if (zzq.zzaau != null) {
            String str = zzq.zzaau;
            this.zzaau = str;
            zzb("XML config - app name", str);
        }
        if (zzq.zzaav != null) {
            String str2 = zzq.zzaav;
            this.zzaav = str2;
            zzb("XML config - app version", str2);
        }
        if (zzq.zzaaw != null) {
            String lowerCase = zzq.zzaaw.toLowerCase(Locale.US);
            if ("verbose".equals(lowerCase)) {
                i2 = 0;
            } else if ("info".equals(lowerCase)) {
                i2 = 1;
            } else if ("warning".equals(lowerCase)) {
                i2 = 2;
            } else {
                i2 = "error".equals(lowerCase) ? 3 : -1;
            }
            if (i2 >= 0) {
                this.zzacu = i2;
                zza("XML config - log level", Integer.valueOf(i2));
            }
        }
        if (zzq.zzaax >= 0) {
            int i3 = zzq.zzaax;
            this.zzaax = i3;
            this.zzacv = true;
            zzb("XML config - dispatch period (sec)", Integer.valueOf(i3));
        }
        int i4 = zzq.zzaay;
        if (i4 != -1) {
            boolean z = i4 == 1;
            this.zzacx = z;
            this.zzacw = true;
            zzb("XML config - dry run", Boolean.valueOf(z));
        }
    }

    public final String zzaz() {
        zzdb();
        return this.zzaau;
    }

    public final String zzba() {
        zzdb();
        return this.zzaav;
    }

    public final boolean zzgh() {
        zzdb();
        return false;
    }

    public final boolean zzgi() {
        zzdb();
        return this.zzacw;
    }

    public final boolean zzgj() {
        zzdb();
        return this.zzacx;
    }
}
