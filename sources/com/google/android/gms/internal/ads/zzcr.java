package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public abstract class zzcr implements zzcq {
    protected static volatile zzdl zzqo;
    protected MotionEvent zzqu;
    protected double zzrd;
    private double zzre;
    private double zzrf;
    protected float zzrg;
    protected float zzrh;
    protected float zzri;
    protected float zzrj;
    protected DisplayMetrics zzrm;
    protected LinkedList<MotionEvent> zzqv = new LinkedList<>();
    protected long zzqw = 0;
    protected long zzqx = 0;
    protected long zzqy = 0;
    protected long zzqz = 0;
    protected long zzra = 0;
    protected long zzrb = 0;
    protected long zzrc = 0;
    private boolean zzrk = false;
    protected boolean zzrl = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzcr(Context context) {
        try {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzctq)).booleanValue()) {
                C0960jj.a();
            } else {
                Oj.a(zzqo);
            }
            this.zzrm = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    protected abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzdi;

    protected abstract zzbl zza(Context context, View view, Activity activity);

    protected abstract zzbl zza(Context context, zzbi zzbiVar);

    @Override // com.google.android.gms.internal.ads.zzcq
    public final String zza(Context context) {
        if (zzds.isMainThread()) {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcts)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return zza(context, null, false, null, null, null);
    }

    protected abstract zzdr zzb(MotionEvent motionEvent) throws zzdi;

    @Override // com.google.android.gms.internal.ads.zzcq
    public void zzb(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzcq
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzcq
    public final String zza(Context context, String str, View view, Activity activity) {
        return zza(context, str, true, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzcq
    public final void zza(MotionEvent motionEvent) {
        boolean z = false;
        if (this.zzrk) {
            this.zzqz = 0L;
            this.zzqy = 0L;
            this.zzqx = 0L;
            this.zzqw = 0L;
            this.zzra = 0L;
            this.zzrc = 0L;
            this.zzrb = 0L;
            Iterator<MotionEvent> it = this.zzqv.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.zzqv.clear();
            this.zzqu = null;
            this.zzrk = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzrd = 0.0d;
            this.zzre = motionEvent.getRawX();
            this.zzrf = motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = motionEvent.getRawX();
            double rawY = motionEvent.getRawY();
            double d2 = this.zzre;
            Double.isNaN(rawX);
            double d3 = rawX - d2;
            double d4 = this.zzrf;
            Double.isNaN(rawY);
            double d5 = rawY - d4;
            this.zzrd += Math.sqrt((d3 * d3) + (d5 * d5));
            this.zzre = rawX;
            this.zzrf = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            try {
                if (action2 == 1) {
                    this.zzqu = MotionEvent.obtain(motionEvent);
                    this.zzqv.add(this.zzqu);
                    if (this.zzqv.size() > 6) {
                        this.zzqv.remove().recycle();
                    }
                    this.zzqy++;
                    this.zzra = zza(new Throwable().getStackTrace());
                } else if (action2 == 2) {
                    this.zzqx += motionEvent.getHistorySize() + 1;
                    zzdr zzb = zzb(motionEvent);
                    if ((zzb == null || zzb.zzgn == null || zzb.zztp == null) ? false : true) {
                        this.zzrb += zzb.zzgn.longValue() + zzb.zztp.longValue();
                    }
                    if (this.zzrm != null && zzb != null && zzb.zzgl != null && zzb.zztq != null) {
                        z = true;
                    }
                    if (z) {
                        this.zzrc += zzb.zzgl.longValue() + zzb.zztq.longValue();
                    }
                } else if (action2 == 3) {
                    this.zzqz++;
                }
            } catch (zzdi unused) {
            }
        } else {
            this.zzrg = motionEvent.getX();
            this.zzrh = motionEvent.getY();
            this.zzri = motionEvent.getRawX();
            this.zzrj = motionEvent.getRawY();
            this.zzqw++;
        }
        this.zzrl = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcq
    public final void zza(int i, int i2, int i3) {
        MotionEvent motionEvent = this.zzqu;
        if (motionEvent != null) {
            motionEvent.recycle();
        }
        DisplayMetrics displayMetrics = this.zzrm;
        if (displayMetrics != null) {
            float f2 = displayMetrics.density;
            this.zzqu = MotionEvent.obtain(0L, i3, 1, i * f2, i2 * f2, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzqu = null;
        }
        this.zzrl = false;
    }

    private final String zza(Context context, String str, boolean z, View view, Activity activity, byte[] bArr) {
        zzbl zza;
        try {
            if (z) {
                zza = zza(context, view, activity);
                this.zzrk = true;
            } else {
                zza = zza(context, null);
            }
            if (zza != null && zza.zzamj() != 0) {
                return C0960jj.a(zza, str);
            }
            return Integer.toString(5);
        } catch (UnsupportedEncodingException | GeneralSecurityException unused) {
            return Integer.toString(7);
        } catch (Throwable unused2) {
            return Integer.toString(3);
        }
    }
}
