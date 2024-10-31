package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class zzd {
    protected final zzl zzYC;
    private final String zzYD;
    private zzn zzYE;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzd(String str, String str2, String str3) {
        zzf.a(str);
        this.zzYD = str;
        this.zzYC = new zzl(str2);
        setSessionLabel(str3);
    }

    public final String getNamespace() {
        return this.zzYD;
    }

    public void setSessionLabel(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zzYC.a(str);
    }

    public final void zza(zzn zznVar) {
        this.zzYE = zznVar;
        if (this.zzYE == null) {
            zzmP();
        }
    }

    protected final void zza(String str, long j, String str2) throws IOException {
        this.zzYC.a("Sending text message: %s to: %s", str, str2);
        this.zzYE.a(this.zzYD, str, j, str2);
    }

    public void zzb(long j, int i) {
    }

    public void zzbK(String str) {
    }

    public void zzmP() {
    }

    protected final long zzmQ() {
        return this.zzYE.a();
    }
}
