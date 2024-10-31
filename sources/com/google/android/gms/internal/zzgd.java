package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.internal.zzja;
import org.keyczar.Keyczar;

@zzgr
/* loaded from: classes.dex */
public class zzgd implements Runnable {
    private final Handler zzDk;
    private final long zzDl;
    private long zzDm;
    private zzja.zza zzDn;
    protected boolean zzDo;
    protected boolean zzDp;
    private final int zznQ;
    private final int zznR;
    protected final zziz zzoM;

    /* loaded from: classes.dex */
    protected final class zza extends AsyncTask<Void, Void, Boolean> {
        private final WebView zzDq;
        private Bitmap zzDr;

        public zza(WebView webView) {
            this.zzDq = webView;
        }

        @Override // android.os.AsyncTask
        protected synchronized void onPreExecute() {
            this.zzDr = Bitmap.createBitmap(zzgd.this.zznQ, zzgd.this.zznR, Bitmap.Config.ARGB_8888);
            this.zzDq.setVisibility(0);
            this.zzDq.measure(View.MeasureSpec.makeMeasureSpec(zzgd.this.zznQ, 0), View.MeasureSpec.makeMeasureSpec(zzgd.this.zznR, 0));
            this.zzDq.layout(0, 0, zzgd.this.zznQ, zzgd.this.zznR);
            this.zzDq.draw(new Canvas(this.zzDr));
            this.zzDq.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public synchronized Boolean doInBackground(Void... voidArr) {
            boolean z;
            int width = this.zzDr.getWidth();
            int height = this.zzDr.getHeight();
            if (width == 0 || height == 0) {
                z = false;
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.zzDr.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                z = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            zzgd.zzc(zzgd.this);
            if (bool.booleanValue() || zzgd.this.zzfx() || zzgd.this.zzDm <= 0) {
                zzgd.this.zzDp = bool.booleanValue();
                zzgd.this.zzDn.zza(zzgd.this.zzoM, true);
            } else if (zzgd.this.zzDm > 0) {
                if (com.google.android.gms.ads.internal.util.client.zzb.a(2)) {
                    com.google.android.gms.ads.internal.util.client.zzb.a("Ad not detected, scheduling another run.");
                }
                zzgd.this.zzDk.postDelayed(zzgd.this, zzgd.this.zzDl);
            }
        }
    }

    public zzgd(zzja.zza zzaVar, zziz zzizVar, int i, int i2) {
        this(zzaVar, zzizVar, i, i2, 200L, 50L);
    }

    public zzgd(zzja.zza zzaVar, zziz zzizVar, int i, int i2, long j, long j2) {
        this.zzDl = j;
        this.zzDm = j2;
        this.zzDk = new Handler(Looper.getMainLooper());
        this.zzoM = zzizVar;
        this.zzDn = zzaVar;
        this.zzDo = false;
        this.zzDp = false;
        this.zznR = i2;
        this.zznQ = i;
    }

    static /* synthetic */ long zzc(zzgd zzgdVar) {
        long j = zzgdVar.zzDm - 1;
        zzgdVar.zzDm = j;
        return j;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.zzoM == null || zzfx()) {
            this.zzDn.zza(this.zzoM, true);
        } else {
            new zza(this.zzoM.getWebView()).execute(new Void[0]);
        }
    }

    public void zza(AdResponseParcel adResponseParcel) {
        zza(adResponseParcel, new zzji(this, this.zzoM, adResponseParcel.q));
    }

    public void zza(AdResponseParcel adResponseParcel, zzji zzjiVar) {
        this.zzoM.setWebViewClient(zzjiVar);
        this.zzoM.loadDataWithBaseURL(TextUtils.isEmpty(adResponseParcel.b) ? null : com.google.android.gms.ads.internal.zzp.e().zzaz(adResponseParcel.b), adResponseParcel.c, "text/html", Keyczar.DEFAULT_ENCODING, null);
    }

    public void zzfv() {
        this.zzDk.postDelayed(this, this.zzDl);
    }

    public synchronized void zzfw() {
        this.zzDo = true;
    }

    public synchronized boolean zzfx() {
        return this.zzDo;
    }

    public boolean zzfy() {
        return this.zzDp;
    }
}
