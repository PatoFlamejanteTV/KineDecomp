package com.google.android.gms.internal.gtm;

import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class zzcm extends zzan {
    private SharedPreferences zzabv;
    private long zzabw;
    private long zzabx;
    private final zzco zzaby;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzcm(zzap zzapVar) {
        super(zzapVar);
        this.zzabx = -1L;
        this.zzaby = new zzco(this, "monitoring", zzby.zzaao.get().longValue());
    }

    public final void zzad(String str) {
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        SharedPreferences.Editor edit = this.zzabv.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (edit.commit()) {
            return;
        }
        zzt("Failed to commit campaign data");
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void zzaw() {
        this.zzabv = getContext().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final long zzfv() {
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        if (this.zzabw == 0) {
            long j = this.zzabv.getLong("first_run", 0L);
            if (j != 0) {
                this.zzabw = j;
            } else {
                long a2 = zzcn().a();
                SharedPreferences.Editor edit = this.zzabv.edit();
                edit.putLong("first_run", a2);
                if (!edit.commit()) {
                    zzt("Failed to commit first run time");
                }
                this.zzabw = a2;
            }
        }
        return this.zzabw;
    }

    public final I zzfw() {
        return new I(zzcn(), zzfv());
    }

    public final long zzfx() {
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        if (this.zzabx == -1) {
            this.zzabx = this.zzabv.getLong("last_dispatch", 0L);
        }
        return this.zzabx;
    }

    public final void zzfy() {
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        long a2 = zzcn().a();
        SharedPreferences.Editor edit = this.zzabv.edit();
        edit.putLong("last_dispatch", a2);
        edit.apply();
        this.zzabx = a2;
    }

    public final String zzfz() {
        com.google.android.gms.analytics.zzk.d();
        zzdb();
        String string = this.zzabv.getString("installation_campaign", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    public final zzco zzga() {
        return this.zzaby;
    }
}
