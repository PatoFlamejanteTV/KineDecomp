package com.google.android.gms.internal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzgr
/* loaded from: classes.dex */
public class zzfc extends zzfh {
    static final Set<String> zzAb = new HashSet(Arrays.asList("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"));
    private String zzAc;
    private boolean zzAd;
    private int zzAe;
    private int zzAf;
    private int zzAg;
    private int zzAh;
    private final Activity zzAi;
    private ImageView zzAj;
    private LinearLayout zzAk;
    private zzfi zzAl;
    private PopupWindow zzAm;
    private RelativeLayout zzAn;
    private ViewGroup zzAo;
    private int zznQ;
    private int zznR;
    private final zziz zzoM;
    private final Object zzpd;
    private AdSizeParcel zzzm;

    public zzfc(zziz zzizVar, zzfi zzfiVar) {
        super(zzizVar, "resize");
        this.zzAc = "top-right";
        this.zzAd = true;
        this.zzAe = 0;
        this.zzAf = 0;
        this.zznR = -1;
        this.zzAg = 0;
        this.zzAh = 0;
        this.zznQ = -1;
        this.zzpd = new Object();
        this.zzoM = zzizVar;
        this.zzAi = zzizVar.zzgZ();
        this.zzAl = zzfiVar;
    }

    private int[] zzee() {
        if (!zzeg()) {
            return null;
        }
        if (this.zzAd) {
            return new int[]{this.zzAe + this.zzAg, this.zzAf + this.zzAh};
        }
        int[] zzh = com.google.android.gms.ads.internal.zzp.e().zzh(this.zzAi);
        int[] zzj = com.google.android.gms.ads.internal.zzp.e().zzj(this.zzAi);
        int i = zzh[0];
        int i2 = this.zzAe + this.zzAg;
        int i3 = this.zzAf + this.zzAh;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.zznQ + i2 > i) {
            i2 = i - this.zznQ;
        }
        if (i3 < zzj[0]) {
            i3 = zzj[0];
        } else if (this.zznR + i3 > zzj[1]) {
            i3 = zzj[1] - this.zznR;
        }
        return new int[]{i2, i3};
    }

    private void zzf(Map<String, String> map) {
        if (!TextUtils.isEmpty(map.get("width"))) {
            this.zznQ = com.google.android.gms.ads.internal.zzp.e().zzaA(map.get("width"));
        }
        if (!TextUtils.isEmpty(map.get("height"))) {
            this.zznR = com.google.android.gms.ads.internal.zzp.e().zzaA(map.get("height"));
        }
        if (!TextUtils.isEmpty(map.get("offsetX"))) {
            this.zzAg = com.google.android.gms.ads.internal.zzp.e().zzaA(map.get("offsetX"));
        }
        if (!TextUtils.isEmpty(map.get("offsetY"))) {
            this.zzAh = com.google.android.gms.ads.internal.zzp.e().zzaA(map.get("offsetY"));
        }
        if (!TextUtils.isEmpty(map.get("allowOffscreen"))) {
            this.zzAd = Boolean.parseBoolean(map.get("allowOffscreen"));
        }
        String str = map.get("customClosePosition");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zzAc = str;
    }

    public void zza(int i, int i2, boolean z) {
        synchronized (this.zzpd) {
            this.zzAe = i;
            this.zzAf = i2;
            if (this.zzAm != null && z) {
                int[] zzee = zzee();
                if (zzee != null) {
                    this.zzAm.update(com.google.android.gms.ads.internal.client.zzl.a().a(this.zzAi, zzee[0]), com.google.android.gms.ads.internal.client.zzl.a().a(this.zzAi, zzee[1]), this.zzAm.getWidth(), this.zzAm.getHeight());
                    zzc(zzee[0], zzee[1]);
                } else {
                    zzn(true);
                }
            }
        }
    }

    void zzb(int i, int i2) {
        if (this.zzAl != null) {
            this.zzAl.zza(i, i2, this.zznQ, this.zznR);
        }
    }

    void zzc(int i, int i2) {
        zzb(i, i2 - com.google.android.gms.ads.internal.zzp.e().zzj(this.zzAi)[0], this.zznQ, this.zznR);
    }

    public void zzd(int i, int i2) {
        this.zzAe = i;
        this.zzAf = i2;
    }

    boolean zzed() {
        return this.zznQ > -1 && this.zznR > -1;
    }

    public boolean zzef() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzAm != null;
        }
        return z;
    }

    boolean zzeg() {
        int i;
        int i2;
        int[] zzh = com.google.android.gms.ads.internal.zzp.e().zzh(this.zzAi);
        int[] zzj = com.google.android.gms.ads.internal.zzp.e().zzj(this.zzAi);
        int i3 = zzh[0];
        int i4 = zzh[1];
        if (this.zznQ < 50 || this.zznQ > i3) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Width is too small or too large.");
            return false;
        }
        if (this.zznR < 50 || this.zznR > i4) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Height is too small or too large.");
            return false;
        }
        if (this.zznR == i4 && this.zznQ == i3) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Cannot resize to a full-screen ad.");
            return false;
        }
        if (this.zzAd) {
            String str = this.zzAc;
            char c = 65535;
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1012429441:
                    if (str.equals("top-left")) {
                        c = 0;
                        break;
                    }
                    break;
                case -655373719:
                    if (str.equals("bottom-left")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1163912186:
                    if (str.equals("bottom-right")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1288627767:
                    if (str.equals("bottom-center")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1755462605:
                    if (str.equals("top-center")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    i = this.zzAg + this.zzAe;
                    i2 = this.zzAf + this.zzAh;
                    break;
                case 1:
                    i = ((this.zzAe + this.zzAg) + (this.zznQ / 2)) - 25;
                    i2 = this.zzAf + this.zzAh;
                    break;
                case 2:
                    i = ((this.zzAe + this.zzAg) + (this.zznQ / 2)) - 25;
                    i2 = ((this.zzAf + this.zzAh) + (this.zznR / 2)) - 25;
                    break;
                case 3:
                    i = this.zzAg + this.zzAe;
                    i2 = ((this.zzAf + this.zzAh) + this.zznR) - 50;
                    break;
                case 4:
                    i = ((this.zzAe + this.zzAg) + (this.zznQ / 2)) - 25;
                    i2 = ((this.zzAf + this.zzAh) + this.zznR) - 50;
                    break;
                case 5:
                    i = ((this.zzAe + this.zzAg) + this.zznQ) - 50;
                    i2 = ((this.zzAf + this.zzAh) + this.zznR) - 50;
                    break;
                default:
                    i = ((this.zzAe + this.zzAg) + this.zznQ) - 50;
                    i2 = this.zzAf + this.zzAh;
                    break;
            }
            if (i < 0 || i + 50 > i3 || i2 < zzj[0] || i2 + 50 > zzj[1]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void zzg(Map<String, String> map) {
        char c;
        synchronized (this.zzpd) {
            if (this.zzAi == null) {
                zzak("Not an activity context. Cannot resize.");
                return;
            }
            if (this.zzoM.zzaN() == null) {
                zzak("Webview is not yet available, size is not set.");
                return;
            }
            if (this.zzoM.zzaN().e) {
                zzak("Is interstitial. Cannot resize an interstitial.");
                return;
            }
            if (this.zzoM.zzhi()) {
                zzak("Cannot resize an expanded banner.");
                return;
            }
            zzf(map);
            if (!zzed()) {
                zzak("Invalid width and height options. Cannot resize.");
                return;
            }
            Window window = this.zzAi.getWindow();
            if (window == null || window.getDecorView() == null) {
                zzak("Activity context is not ready, cannot get window or decor view.");
                return;
            }
            int[] zzee = zzee();
            if (zzee == null) {
                zzak("Resize location out of screen or close button is not visible.");
                return;
            }
            int a2 = com.google.android.gms.ads.internal.client.zzl.a().a(this.zzAi, this.zznQ);
            int a3 = com.google.android.gms.ads.internal.client.zzl.a().a(this.zzAi, this.zznR);
            ViewParent parent = this.zzoM.getView().getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                zzak("Webview is detached, probably in the middle of a resize or expand.");
                return;
            }
            ((ViewGroup) parent).removeView(this.zzoM.getView());
            if (this.zzAm == null) {
                this.zzAo = (ViewGroup) parent;
                Bitmap zzk = com.google.android.gms.ads.internal.zzp.e().zzk(this.zzoM.getView());
                this.zzAj = new ImageView(this.zzAi);
                this.zzAj.setImageBitmap(zzk);
                this.zzzm = this.zzoM.zzaN();
                this.zzAo.addView(this.zzAj);
            } else {
                this.zzAm.dismiss();
            }
            this.zzAn = new RelativeLayout(this.zzAi);
            this.zzAn.setBackgroundColor(0);
            this.zzAn.setLayoutParams(new ViewGroup.LayoutParams(a2, a3));
            this.zzAm = com.google.android.gms.ads.internal.zzp.e().zza((View) this.zzAn, a2, a3, false);
            this.zzAm.setOutsideTouchable(true);
            this.zzAm.setTouchable(true);
            this.zzAm.setClippingEnabled(!this.zzAd);
            this.zzAn.addView(this.zzoM.getView(), -1, -1);
            this.zzAk = new LinearLayout(this.zzAi);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.google.android.gms.ads.internal.client.zzl.a().a(this.zzAi, 50), com.google.android.gms.ads.internal.client.zzl.a().a(this.zzAi, 50));
            String str = this.zzAc;
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1012429441:
                    if (str.equals("top-left")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -655373719:
                    if (str.equals("bottom-left")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1163912186:
                    if (str.equals("bottom-right")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1288627767:
                    if (str.equals("bottom-center")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1755462605:
                    if (str.equals("top-center")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    break;
                case 1:
                    layoutParams.addRule(10);
                    layoutParams.addRule(14);
                    break;
                case 2:
                    layoutParams.addRule(13);
                    break;
                case 3:
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                    break;
                case 4:
                    layoutParams.addRule(12);
                    layoutParams.addRule(14);
                    break;
                case 5:
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    break;
                default:
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    break;
            }
            this.zzAk.setOnClickListener(new cg(this));
            this.zzAk.setContentDescription("Close button");
            this.zzAn.addView(this.zzAk, layoutParams);
            try {
                this.zzAm.showAtLocation(window.getDecorView(), 0, com.google.android.gms.ads.internal.client.zzl.a().a(this.zzAi, zzee[0]), com.google.android.gms.ads.internal.client.zzl.a().a(this.zzAi, zzee[1]));
                zzb(zzee[0], zzee[1]);
                this.zzoM.zza(new AdSizeParcel(this.zzAi, new AdSize(this.zznQ, this.zznR)));
                zzc(zzee[0], zzee[1]);
                zzam("resized");
            } catch (RuntimeException e) {
                zzak("Cannot show popup window: " + e.getMessage());
                this.zzAn.removeView(this.zzoM.getView());
                if (this.zzAo != null) {
                    this.zzAo.removeView(this.zzAj);
                    this.zzAo.addView(this.zzoM.getView());
                    this.zzoM.zza(this.zzzm);
                }
            }
        }
    }

    public void zzn(boolean z) {
        synchronized (this.zzpd) {
            if (this.zzAm != null) {
                this.zzAm.dismiss();
                this.zzAn.removeView(this.zzoM.getView());
                if (this.zzAo != null) {
                    this.zzAo.removeView(this.zzAj);
                    this.zzAo.addView(this.zzoM.getView());
                    this.zzoM.zza(this.zzzm);
                }
                if (z) {
                    zzam("default");
                    if (this.zzAl != null) {
                        this.zzAl.zzbc();
                    }
                }
                this.zzAm = null;
                this.zzAn = null;
                this.zzAo = null;
                this.zzAk = null;
            }
        }
    }
}
