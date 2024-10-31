package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes2.dex */
public class zzba extends zzbvy implements Closeable {
    private static zzbwg zzco = zzbwg.zzk(zzba.class);

    public zzba(zzbwa zzbwaVar, zzaz zzazVar) throws IOException {
        zza(zzbwaVar, zzbwaVar.size(), zzazVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbvy, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.zzgcl.close();
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public String toString() {
        String obj = this.zzgcl.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
