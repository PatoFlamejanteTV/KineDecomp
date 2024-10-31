package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import java.util.concurrent.TimeUnit;

@zzark
/* loaded from: classes2.dex */
public final class zzbea {
    private final Context mContext;
    private final zzbbi zzbpt;
    private final zzaba zzere;
    private boolean zzeri;
    private final String zzetu;
    private final zzaay zzetv;
    private final long[] zzetx;
    private final String[] zzety;
    private zzbdi zzeud;
    private boolean zzeue;
    private boolean zzeuf;
    private final zzazo zzetw = new zzazr().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzaaj();
    private boolean zzetz = false;
    private boolean zzeua = false;
    private boolean zzeub = false;
    private boolean zzeuc = false;
    private long zzeug = -1;

    public zzbea(Context context, zzbbi zzbbiVar, String str, zzaba zzabaVar, zzaay zzaayVar) {
        this.mContext = context;
        this.zzbpt = zzbbiVar;
        this.zzetu = str;
        this.zzere = zzabaVar;
        this.zzetv = zzaayVar;
        String str2 = (String) zzwu.zzpz().zzd(zzaan.zzcpa);
        if (str2 == null) {
            this.zzety = new String[0];
            this.zzetx = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.zzety = new String[split.length];
        this.zzetx = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzetx[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e2) {
                zzbbd.zzc("Unable to parse frame hash target time number.", e2);
                this.zzetx[i] = -1;
            }
        }
    }

    public final void onStop() {
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcoz)).booleanValue() || this.zzeue) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "native-player-metrics");
        bundle.putString(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, this.zzetu);
        bundle.putString("player", this.zzeud.zzaaz());
        for (zzazq zzazqVar : this.zzetw.zzaai()) {
            String valueOf = String.valueOf(zzazqVar.name);
            bundle.putString(valueOf.length() != 0 ? "fps_c_".concat(valueOf) : new String("fps_c_"), Integer.toString(zzazqVar.count));
            String valueOf2 = String.valueOf(zzazqVar.name);
            bundle.putString(valueOf2.length() != 0 ? "fps_p_".concat(valueOf2) : new String("fps_p_"), Double.toString(zzazqVar.zzems));
        }
        int i = 0;
        while (true) {
            long[] jArr = this.zzetx;
            if (i < jArr.length) {
                String str = this.zzety[i];
                if (str != null) {
                    String valueOf3 = String.valueOf(Long.valueOf(jArr[i]));
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 3);
                    sb.append("fh_");
                    sb.append(valueOf3);
                    bundle.putString(sb.toString(), str);
                }
                i++;
            } else {
                com.google.android.gms.ads.internal.zzbv.e().zza(this.mContext, this.zzbpt.zzdp, "gmob-apps", bundle, true);
                this.zzeue = true;
                return;
            }
        }
    }

    public final void zzacd() {
        this.zzeri = true;
        if (!this.zzeua || this.zzeub) {
            return;
        }
        zzaat.zza(this.zzere, this.zzetv, "vfp2");
        this.zzeub = true;
    }

    public final void zzace() {
        this.zzeri = false;
    }

    public final void zzb(zzbdi zzbdiVar) {
        zzaat.zza(this.zzere, this.zzetv, "vpc2");
        this.zzetz = true;
        zzaba zzabaVar = this.zzere;
        if (zzabaVar != null) {
            zzabaVar.zzg("vpn", zzbdiVar.zzaaz());
        }
        this.zzeud = zzbdiVar;
    }

    public final void zzc(zzbdi zzbdiVar) {
        if (this.zzeub && !this.zzeuc) {
            if (zzaxz.zzza() && !this.zzeuc) {
                zzaxz.v("VideoMetricsMixin first frame");
            }
            zzaat.zza(this.zzere, this.zzetv, "vff2");
            this.zzeuc = true;
        }
        long b2 = com.google.android.gms.ads.internal.zzbv.l().b();
        if (this.zzeri && this.zzeuf && this.zzeug != -1) {
            double nanos = TimeUnit.SECONDS.toNanos(1L);
            double d2 = b2 - this.zzeug;
            Double.isNaN(nanos);
            Double.isNaN(d2);
            this.zzetw.zza(nanos / d2);
        }
        this.zzeuf = this.zzeri;
        this.zzeug = b2;
        long longValue = ((Long) zzwu.zzpz().zzd(zzaan.zzcpb)).longValue();
        long currentPosition = zzbdiVar.getCurrentPosition();
        int i = 0;
        while (true) {
            String[] strArr = this.zzety;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] == null && longValue > Math.abs(currentPosition - this.zzetx[i])) {
                String[] strArr2 = this.zzety;
                int i2 = 8;
                Bitmap bitmap = zzbdiVar.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    long j3 = j;
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j2 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1L : 0L) << ((int) j3);
                        i4++;
                        j3--;
                        i2 = 8;
                    }
                    i3++;
                    j = j3;
                    i2 = 8;
                }
                strArr2[i] = String.format("%016X", Long.valueOf(j2));
                return;
            }
            i++;
        }
    }

    public final void zzcg() {
        if (!this.zzetz || this.zzeua) {
            return;
        }
        zzaat.zza(this.zzere, this.zzetv, "vfr2");
        this.zzeua = true;
    }
}
