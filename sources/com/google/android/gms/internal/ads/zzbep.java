package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzark
/* loaded from: classes2.dex */
public final class zzbep implements zzov {
    private boolean isOpen;
    private Uri uri;
    private InputStream zzevf;
    private final zzov zzevg;
    private final zzpn<zzov> zzevh;
    private final zzbeq zzevi;
    private final Context zzsp;

    public zzbep(Context context, zzov zzovVar, zzpn<zzov> zzpnVar, zzbeq zzbeqVar) {
        this.zzsp = context;
        this.zzevg = zzovVar;
        this.zzevh = zzpnVar;
        this.zzevi = zzbeqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final void close() throws IOException {
        if (this.isOpen) {
            this.isOpen = false;
            this.uri = null;
            InputStream inputStream = this.zzevf;
            if (inputStream != null) {
                IOUtils.a(inputStream);
                this.zzevf = null;
            } else {
                this.zzevg.close();
            }
            zzpn<zzov> zzpnVar = this.zzevh;
            if (zzpnVar != null) {
                zzpnVar.zze(this);
                return;
            }
            return;
        }
        throw new IOException("Attempt to close an already closed CacheDataSource.");
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read;
        if (this.isOpen) {
            InputStream inputStream = this.zzevf;
            if (inputStream != null) {
                read = inputStream.read(bArr, i, i2);
            } else {
                read = this.zzevg.read(bArr, i, i2);
            }
            zzpn<zzov> zzpnVar = this.zzevh;
            if (zzpnVar != null) {
                zzpnVar.zzc(this, read);
            }
            return read;
        }
        throw new IOException("Attempt to read closed CacheDataSource.");
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final long zza(zzoz zzozVar) throws IOException {
        Long l;
        zzoz zzozVar2 = zzozVar;
        if (!this.isOpen) {
            this.isOpen = true;
            this.uri = zzozVar2.uri;
            zzpn<zzov> zzpnVar = this.zzevh;
            if (zzpnVar != null) {
                zzpnVar.zza(this, zzozVar2);
            }
            zzty zzd = zzty.zzd(zzozVar2.uri);
            if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcvv)).booleanValue()) {
                zztv zztvVar = null;
                if (zzd != null) {
                    zzd.zzcab = zzozVar2.zzaha;
                    zztvVar = com.google.android.gms.ads.internal.zzbv.k().zza(zzd);
                }
                if (zztvVar != null && zztvVar.zzoe()) {
                    this.zzevf = zztvVar.zzof();
                    return -1L;
                }
            } else if (zzd != null) {
                zzd.zzcab = zzozVar2.zzaha;
                if (zzd.zzcaa) {
                    l = (Long) zzwu.zzpz().zzd(zzaan.zzcvx);
                } else {
                    l = (Long) zzwu.zzpz().zzd(zzaan.zzcvw);
                }
                long longValue = l.longValue();
                long c2 = com.google.android.gms.ads.internal.zzbv.l().c();
                com.google.android.gms.ads.internal.zzbv.A();
                Future<InputStream> zza = zzul.zza(this.zzsp, zzd);
                try {
                    try {
                        this.zzevf = zza.get(longValue, TimeUnit.MILLISECONDS);
                        long c3 = com.google.android.gms.ads.internal.zzbv.l().c() - c2;
                        this.zzevi.zzb(true, c3);
                        StringBuilder sb = new StringBuilder(44);
                        sb.append("Cache connection took ");
                        sb.append(c3);
                        sb.append("ms");
                        zzaxz.v(sb.toString());
                        return -1L;
                    } catch (InterruptedException unused) {
                        zza.cancel(true);
                        Thread.currentThread().interrupt();
                        long c4 = com.google.android.gms.ads.internal.zzbv.l().c() - c2;
                        this.zzevi.zzb(false, c4);
                        StringBuilder sb2 = new StringBuilder(44);
                        sb2.append("Cache connection took ");
                        sb2.append(c4);
                        sb2.append("ms");
                        zzaxz.v(sb2.toString());
                    } catch (ExecutionException | TimeoutException unused2) {
                        zza.cancel(true);
                        long c5 = com.google.android.gms.ads.internal.zzbv.l().c() - c2;
                        this.zzevi.zzb(false, c5);
                        StringBuilder sb3 = new StringBuilder(44);
                        sb3.append("Cache connection took ");
                        sb3.append(c5);
                        sb3.append("ms");
                        zzaxz.v(sb3.toString());
                    }
                } catch (Throwable th) {
                    long c6 = com.google.android.gms.ads.internal.zzbv.l().c() - c2;
                    this.zzevi.zzb(false, c6);
                    StringBuilder sb4 = new StringBuilder(44);
                    sb4.append("Cache connection took ");
                    sb4.append(c6);
                    sb4.append("ms");
                    zzaxz.v(sb4.toString());
                    throw th;
                }
            }
            if (zzd != null) {
                zzozVar2 = new zzoz(Uri.parse(zzd.url), zzozVar2.zzbft, zzozVar2.zzbfu, zzozVar2.zzaha, zzozVar2.zzcc, zzozVar2.zzcb, zzozVar2.flags);
            }
            return this.zzevg.zza(zzozVar2);
        }
        throw new IOException("Attempt to open an already open CacheDataSource.");
    }
}
