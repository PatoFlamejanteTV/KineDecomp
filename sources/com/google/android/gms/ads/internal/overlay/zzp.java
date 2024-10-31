package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzcc;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzig;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class zzp {

    /* renamed from: a */
    private final Context f607a;
    private final String b;
    private final VersionInfoParcel c;
    private final zzce d;
    private final zzcg e;
    private final long[] g;
    private final String[] h;
    private zzce i;
    private zzce j;
    private zzce k;
    private zzce l;
    private boolean m;
    private zzi n;
    private boolean o;
    private boolean p;
    private final zzig f = new zzig.zzb().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzgK();
    private long q = -1;

    public zzp(Context context, VersionInfoParcel versionInfoParcel, String str, zzcg zzcgVar, zzce zzceVar) {
        this.f607a = context;
        this.c = versionInfoParcel;
        this.b = str;
        this.e = zzcgVar;
        this.d = zzceVar;
        String str2 = zzby.zzuF.get();
        if (str2 == null) {
            this.h = new String[0];
            this.g = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.h = new String[split.length];
        this.g = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.g[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Unable to parse frame hash target time number.", e);
                this.g[i] = -1;
            }
        }
    }

    private void c(zzi zziVar) {
        long longValue = zzby.zzuG.get().longValue();
        long currentPosition = zziVar.getCurrentPosition();
        for (int i = 0; i < this.h.length; i++) {
            if (this.h[i] == null && longValue > Math.abs(currentPosition - this.g[i])) {
                this.h[i] = a((TextureView) zziVar);
                return;
            }
        }
    }

    private void e() {
        if (this.k != null && this.l == null) {
            zzcc.zza(this.e, this.k, "vff");
            zzcc.zza(this.e, this.d, "vtt");
            this.l = zzcc.zzb(this.e);
        }
        long nanoTime = com.google.android.gms.ads.internal.zzp.i().nanoTime();
        if (this.m && this.p && this.q != -1) {
            this.f.zza(TimeUnit.SECONDS.toNanos(1L) / (nanoTime - this.q));
        }
        this.p = this.m;
        this.q = nanoTime;
    }

    String a(TextureView textureView) {
        long j;
        Bitmap bitmap = textureView.getBitmap(8, 8);
        long j2 = 0;
        long j3 = 63;
        int i = 0;
        while (i < 8) {
            int i2 = 0;
            long j4 = j2;
            while (true) {
                j = j3;
                int i3 = i2;
                if (i3 < 8) {
                    int pixel = bitmap.getPixel(i3, i);
                    j4 |= (Color.green(pixel) + (Color.blue(pixel) + Color.red(pixel)) > 128 ? 1L : 0L) << ((int) j);
                    i2 = i3 + 1;
                    j3 = j - 1;
                }
            }
            i++;
            j3 = j;
            j2 = j4;
        }
        return String.format("%016X", Long.valueOf(j2));
    }

    public void a() {
        if (this.i == null || this.j != null) {
            return;
        }
        zzcc.zza(this.e, this.i, "vfr");
        this.j = zzcc.zzb(this.e);
    }

    public void a(zzi zziVar) {
        zzcc.zza(this.e, this.d, "vpc");
        this.i = zzcc.zzb(this.e);
        this.n = zziVar;
    }

    public void b() {
        if (!zzby.zzuE.get().booleanValue() || this.o) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "native-player-metrics");
        bundle.putString(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, this.b);
        bundle.putString("player", this.n.a());
        for (zzig.zza zzaVar : this.f.getBuckets()) {
            bundle.putString("fps_c_" + zzaVar.name, Integer.toString(zzaVar.count));
            bundle.putString("fps_p_" + zzaVar.name, Double.toString(zzaVar.zzIV));
        }
        for (int i = 0; i < this.g.length; i++) {
            String str = this.h[i];
            if (str != null) {
                bundle.putString("fh_" + Long.valueOf(this.g[i]), str);
            }
        }
        com.google.android.gms.ads.internal.zzp.e().zza(this.f607a, this.c.b, "gmob-apps", bundle, true);
        this.o = true;
    }

    public void b(zzi zziVar) {
        e();
        c(zziVar);
    }

    public void c() {
        this.m = true;
        if (this.j == null || this.k != null) {
            return;
        }
        zzcc.zza(this.e, this.j, "vfp");
        this.k = zzcc.zzb(this.e);
    }

    public void d() {
        this.m = false;
    }
}
