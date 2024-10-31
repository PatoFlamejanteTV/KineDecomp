package com.google.android.gms.internal.ads;

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
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;
import java.util.Set;

@zzark
/* loaded from: classes2.dex */
public final class zzaoa extends zzaok {
    private static final Set<String> zzdpf = CollectionUtils.b("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private final Object mLock;
    private zzaol zzdgd;
    private final zzbgg zzdin;
    private final Activity zzdow;
    private String zzdpg;
    private boolean zzdph;
    private int zzdpi;
    private int zzdpj;
    private int zzdpk;
    private int zzdpl;
    private zzbht zzdpm;
    private ImageView zzdpn;
    private LinearLayout zzdpo;
    private PopupWindow zzdpp;
    private RelativeLayout zzdpq;
    private ViewGroup zzdpr;
    private int zzvt;
    private int zzvu;

    public zzaoa(zzbgg zzbggVar, zzaol zzaolVar) {
        super(zzbggVar, "resize");
        this.zzdpg = "top-right";
        this.zzdph = true;
        this.zzdpi = 0;
        this.zzdpj = 0;
        this.zzvu = -1;
        this.zzdpk = 0;
        this.zzdpl = 0;
        this.zzvt = -1;
        this.mLock = new Object();
        this.zzdin = zzbggVar;
        this.zzdow = zzbggVar.zzabw();
        this.zzdgd = zzaolVar;
    }

    private final void zzh(int i, int i2) {
        zzb(i, i2 - com.google.android.gms.ads.internal.zzbv.e().zzi(this.zzdow)[0], this.zzvt, this.zzvu);
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0110, code lost:            if ((r5 + 50) <= r1[1]) goto L144;     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0123 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int[] zzvl() {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaoa.zzvl():int[]");
    }

    public final void zza(int i, int i2, boolean z) {
        synchronized (this.mLock) {
            this.zzdpi = i;
            this.zzdpj = i2;
            if (this.zzdpp != null && z) {
                int[] zzvl = zzvl();
                if (zzvl != null) {
                    PopupWindow popupWindow = this.zzdpp;
                    zzwu.zzpv();
                    int zza = zzbat.zza(this.zzdow, zzvl[0]);
                    zzwu.zzpv();
                    popupWindow.update(zza, zzbat.zza(this.zzdow, zzvl[1]), this.zzdpp.getWidth(), this.zzdpp.getHeight());
                    zzh(zzvl[0], zzvl[1]);
                } else {
                    zzx(true);
                }
            }
        }
    }

    public final void zzi(int i, int i2) {
        this.zzdpi = i;
        this.zzdpj = i2;
    }

    public final void zzk(Map<String, String> map) {
        synchronized (this.mLock) {
            if (this.zzdow == null) {
                zzda("Not an activity context. Cannot resize.");
                return;
            }
            if (this.zzdin.zzadj() == null) {
                zzda("Webview is not yet available, size is not set.");
                return;
            }
            if (this.zzdin.zzadj().zzafb()) {
                zzda("Is interstitial. Cannot resize an interstitial.");
                return;
            }
            if (this.zzdin.zzadq()) {
                zzda("Cannot resize an expanded banner.");
                return;
            }
            if (!TextUtils.isEmpty(map.get("width"))) {
                com.google.android.gms.ads.internal.zzbv.e();
                this.zzvt = zzayh.zzdy(map.get("width"));
            }
            if (!TextUtils.isEmpty(map.get("height"))) {
                com.google.android.gms.ads.internal.zzbv.e();
                this.zzvu = zzayh.zzdy(map.get("height"));
            }
            if (!TextUtils.isEmpty(map.get("offsetX"))) {
                com.google.android.gms.ads.internal.zzbv.e();
                this.zzdpk = zzayh.zzdy(map.get("offsetX"));
            }
            if (!TextUtils.isEmpty(map.get("offsetY"))) {
                com.google.android.gms.ads.internal.zzbv.e();
                this.zzdpl = zzayh.zzdy(map.get("offsetY"));
            }
            if (!TextUtils.isEmpty(map.get("allowOffscreen"))) {
                this.zzdph = Boolean.parseBoolean(map.get("allowOffscreen"));
            }
            String str = map.get("customClosePosition");
            if (!TextUtils.isEmpty(str)) {
                this.zzdpg = str;
            }
            if (!(this.zzvt >= 0 && this.zzvu >= 0)) {
                zzda("Invalid width and height options. Cannot resize.");
                return;
            }
            Window window = this.zzdow.getWindow();
            if (window != null && window.getDecorView() != null) {
                int[] zzvl = zzvl();
                if (zzvl == null) {
                    zzda("Resize location out of screen or close button is not visible.");
                    return;
                }
                zzwu.zzpv();
                int zza = zzbat.zza(this.zzdow, this.zzvt);
                zzwu.zzpv();
                int zza2 = zzbat.zza(this.zzdow, this.zzvu);
                ViewParent parent = this.zzdin.getView().getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.zzdin.getView());
                    if (this.zzdpp == null) {
                        this.zzdpr = (ViewGroup) parent;
                        com.google.android.gms.ads.internal.zzbv.e();
                        Bitmap zzt = zzayh.zzt(this.zzdin.getView());
                        this.zzdpn = new ImageView(this.zzdow);
                        this.zzdpn.setImageBitmap(zzt);
                        this.zzdpm = this.zzdin.zzadj();
                        this.zzdpr.addView(this.zzdpn);
                    } else {
                        this.zzdpp.dismiss();
                    }
                    this.zzdpq = new RelativeLayout(this.zzdow);
                    this.zzdpq.setBackgroundColor(0);
                    this.zzdpq.setLayoutParams(new ViewGroup.LayoutParams(zza, zza2));
                    com.google.android.gms.ads.internal.zzbv.e();
                    this.zzdpp = zzayh.zza((View) this.zzdpq, zza, zza2, false);
                    this.zzdpp.setOutsideTouchable(true);
                    this.zzdpp.setTouchable(true);
                    this.zzdpp.setClippingEnabled(!this.zzdph);
                    char c2 = 65535;
                    this.zzdpq.addView(this.zzdin.getView(), -1, -1);
                    this.zzdpo = new LinearLayout(this.zzdow);
                    zzwu.zzpv();
                    int zza3 = zzbat.zza(this.zzdow, 50);
                    zzwu.zzpv();
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(zza3, zzbat.zza(this.zzdow, 50));
                    String str2 = this.zzdpg;
                    switch (str2.hashCode()) {
                        case -1364013995:
                            if (str2.equals("center")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case -1012429441:
                            if (str2.equals("top-left")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case -655373719:
                            if (str2.equals("bottom-left")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 1163912186:
                            if (str2.equals("bottom-right")) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case 1288627767:
                            if (str2.equals("bottom-center")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 1755462605:
                            if (str2.equals("top-center")) {
                                c2 = 1;
                                break;
                            }
                            break;
                    }
                    if (c2 == 0) {
                        layoutParams.addRule(10);
                        layoutParams.addRule(9);
                    } else if (c2 == 1) {
                        layoutParams.addRule(10);
                        layoutParams.addRule(14);
                    } else if (c2 == 2) {
                        layoutParams.addRule(13);
                    } else if (c2 == 3) {
                        layoutParams.addRule(12);
                        layoutParams.addRule(9);
                    } else if (c2 == 4) {
                        layoutParams.addRule(12);
                        layoutParams.addRule(14);
                    } else if (c2 != 5) {
                        layoutParams.addRule(10);
                        layoutParams.addRule(11);
                    } else {
                        layoutParams.addRule(12);
                        layoutParams.addRule(11);
                    }
                    this.zzdpo.setOnClickListener(new Lb(this));
                    this.zzdpo.setContentDescription("Close button");
                    this.zzdpq.addView(this.zzdpo, layoutParams);
                    try {
                        PopupWindow popupWindow = this.zzdpp;
                        View decorView = window.getDecorView();
                        zzwu.zzpv();
                        int zza4 = zzbat.zza(this.zzdow, zzvl[0]);
                        zzwu.zzpv();
                        popupWindow.showAtLocation(decorView, 0, zza4, zzbat.zza(this.zzdow, zzvl[1]));
                        int i = zzvl[0];
                        int i2 = zzvl[1];
                        if (this.zzdgd != null) {
                            this.zzdgd.zza(i, i2, this.zzvt, this.zzvu);
                        }
                        this.zzdin.zza(zzbht.zzr(zza, zza2));
                        zzh(zzvl[0], zzvl[1]);
                        zzdc("resized");
                        return;
                    } catch (RuntimeException e2) {
                        String valueOf = String.valueOf(e2.getMessage());
                        zzda(valueOf.length() != 0 ? "Cannot show popup window: ".concat(valueOf) : new String("Cannot show popup window: "));
                        this.zzdpq.removeView(this.zzdin.getView());
                        if (this.zzdpr != null) {
                            this.zzdpr.removeView(this.zzdpn);
                            this.zzdpr.addView(this.zzdin.getView());
                            this.zzdin.zza(this.zzdpm);
                        }
                        return;
                    }
                }
                zzda("Webview is detached, probably in the middle of a resize or expand.");
                return;
            }
            zzda("Activity context is not ready, cannot get window or decor view.");
        }
    }

    public final boolean zzvm() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdpp != null;
        }
        return z;
    }

    public final void zzx(boolean z) {
        synchronized (this.mLock) {
            if (this.zzdpp != null) {
                this.zzdpp.dismiss();
                this.zzdpq.removeView(this.zzdin.getView());
                if (this.zzdpr != null) {
                    this.zzdpr.removeView(this.zzdpn);
                    this.zzdpr.addView(this.zzdin.getView());
                    this.zzdin.zza(this.zzdpm);
                }
                if (z) {
                    zzdc("default");
                    if (this.zzdgd != null) {
                        this.zzdgd.zzjk();
                    }
                }
                this.zzdpp = null;
                this.zzdpq = null;
                this.zzdpr = null;
                this.zzdpo = null;
            }
        }
    }
}
