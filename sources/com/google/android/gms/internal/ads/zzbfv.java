package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.nio.ByteBuffer;

@zzark
/* loaded from: classes2.dex */
public final class zzbfv extends zzbfk implements zzpn<zzov> {
    private String url;
    private ByteBuffer zzaep;
    private final zzbdy zzeuo;
    private boolean zzexf;
    private final C1109uf zzexg;
    private final zzbfc zzexh;
    private boolean zzexi;
    private final Object zzexj;
    private boolean zzexk;

    public zzbfv(zzbdz zzbdzVar, zzbdy zzbdyVar) {
        super(zzbdzVar);
        this.zzeuo = zzbdyVar;
        this.zzexg = new C1109uf();
        this.zzexh = new zzbfc();
        this.zzexj = new Object();
    }

    private final void zzabm() {
        int a2 = (int) this.zzexg.a();
        int zzl = (int) this.zzexh.zzl(this.zzaep);
        int round = Math.round(zzl * (this.zzaep.position() / a2));
        boolean z = round > 0;
        int zzacx = zzbes.zzacx();
        int zzacy = zzbes.zzacy();
        String str = this.url;
        zza(str, zzey(str), round, zzl, z, zzacx, zzacy);
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void abort() {
        this.zzexf = true;
    }

    public final ByteBuffer getByteBuffer() {
        synchronized (this.zzexj) {
            if (this.zzaep != null && !this.zzexi) {
                this.zzaep.flip();
                this.zzexi = true;
            }
            this.zzexf = true;
        }
        return this.zzaep;
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // com.google.android.gms.internal.ads.zzpn
    public final /* synthetic */ void zza(zzov zzovVar, zzoz zzozVar) {
        zzov zzovVar2 = zzovVar;
        if (zzovVar2 instanceof zzpb) {
            this.zzexg.a((zzpb) zzovVar2);
        }
    }

    public final boolean zzadc() {
        return this.zzexk;
    }

    @Override // com.google.android.gms.internal.ads.zzpn
    public final /* bridge */ /* synthetic */ void zzc(zzov zzovVar, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzpn
    public final /* bridge */ /* synthetic */ void zze(zzov zzovVar) {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:? -> B:50:0x013a). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzbfk
    public final boolean zzex(String str) {
        String str2;
        this.url = str;
        String zzey = zzey(str);
        String str3 = "error";
        int i = 0;
        try {
            zzov zzpbVar = new zzpb(this.zzeiz, null, this, this.zzeuo.zzetn, this.zzeuo.zzetp, true, null);
            if (this.zzeuo.zzets) {
                try {
                    zzpbVar = new zzbep(this.mContext, zzpbVar, null, null);
                } catch (Exception e2) {
                    e = e2;
                    String canonicalName = e.getClass().getCanonicalName();
                    String message = e.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 1 + String.valueOf(message).length());
                    sb.append(canonicalName);
                    sb.append(":");
                    sb.append(message);
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(sb2).length());
                    sb3.append("Failed to preload url ");
                    sb3.append(str);
                    sb3.append(" Exception: ");
                    sb3.append(sb2);
                    zzbbd.zzeo(sb3.toString());
                    zza(str, zzey, str3, sb2);
                    return false;
                }
            }
            zzpbVar.zza(new zzoz(Uri.parse(str)));
            zzbdz zzbdzVar = this.zzewo.get();
            if (zzbdzVar != null) {
                zzbdzVar.zza(zzey, this);
            }
            Clock l = com.google.android.gms.ads.internal.zzbv.l();
            long a2 = l.a();
            long longValue = ((Long) zzwu.zzpz().zzd(zzaan.zzcox)).longValue();
            long longValue2 = ((Long) zzwu.zzpz().zzd(zzaan.zzcow)).longValue();
            this.zzaep = ByteBuffer.allocate(this.zzeuo.zzetm);
            int i2 = 8192;
            byte[] bArr = new byte[8192];
            long j = a2;
            while (true) {
                int read = zzpbVar.read(bArr, i, Math.min(this.zzaep.remaining(), i2));
                if (read == -1) {
                    this.zzexk = true;
                    zzc(str, zzey, (int) this.zzexh.zzl(this.zzaep));
                    return true;
                }
                synchronized (this.zzexj) {
                    try {
                        if (this.zzexf) {
                            str2 = str3;
                        } else {
                            str2 = str3;
                            try {
                                this.zzaep.put(bArr, 0, read);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        try {
                            if (this.zzaep.remaining() <= 0) {
                                zzabm();
                                return true;
                            }
                            if (!this.zzexf) {
                                long a3 = l.a();
                                if (a3 - j >= longValue) {
                                    zzabm();
                                    j = a3;
                                }
                                if (a3 - a2 > 1000 * longValue2) {
                                    StringBuilder sb4 = new StringBuilder(49);
                                    sb4.append("Timeout exceeded. Limit: ");
                                    sb4.append(longValue2);
                                    sb4.append(" sec");
                                    throw new IOException(sb4.toString());
                                }
                                str3 = str2;
                                i2 = 8192;
                                i = 0;
                            } else {
                                int limit = this.zzaep.limit();
                                StringBuilder sb5 = new StringBuilder(35);
                                sb5.append("Precache abort at ");
                                sb5.append(limit);
                                sb5.append(" bytes");
                                throw new IOException(sb5.toString());
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str3 = str2;
                            String canonicalName2 = e.getClass().getCanonicalName();
                            String message2 = e.getMessage();
                            StringBuilder sb6 = new StringBuilder(String.valueOf(canonicalName2).length() + 1 + String.valueOf(message2).length());
                            sb6.append(canonicalName2);
                            sb6.append(":");
                            sb6.append(message2);
                            String sb22 = sb6.toString();
                            StringBuilder sb32 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(sb22).length());
                            sb32.append("Failed to preload url ");
                            sb32.append(str);
                            sb32.append(" Exception: ");
                            sb32.append(sb22);
                            zzbbd.zzeo(sb32.toString());
                            zza(str, zzey, str3, sb22);
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbfk
    public final String zzey(String str) {
        String valueOf = String.valueOf(super.zzey(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }
}
