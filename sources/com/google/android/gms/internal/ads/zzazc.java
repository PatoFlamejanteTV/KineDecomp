package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

@zzark
/* loaded from: classes2.dex */
public final class zzazc {
    private Handler handler;
    private final Context mContext;
    private int state;
    private String zzboa;
    private String zzbuk;
    private final float zzdqe;
    private String zzebe;
    private String zzelo;
    private float zzelp;
    private float zzelq;
    private float zzelr;
    private int zzels;
    private float zzelt;
    private float zzelu;
    private float zzelv;
    private float zzelw;
    private Runnable zzelx;

    public zzazc(Context context) {
        this.state = 0;
        this.zzelx = new Runnable(this) { // from class: com.google.android.gms.internal.ads.Hd

            /* renamed from: a, reason: collision with root package name */
            private final zzazc f11562a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f11562a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f11562a.zzaaf();
            }
        };
        this.mContext = context;
        this.zzdqe = context.getResources().getDisplayMetrics().density;
        this.zzels = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        com.google.android.gms.ads.internal.zzbv.u().zzaak();
        this.handler = com.google.android.gms.ads.internal.zzbv.u().getHandler();
    }

    private final boolean zza(float f2, float f3, float f4, float f5) {
        return Math.abs(this.zzelt - f2) < ((float) this.zzels) && Math.abs(this.zzelu - f3) < ((float) this.zzels) && Math.abs(this.zzelv - f4) < ((float) this.zzels) && Math.abs(this.zzelw - f5) < ((float) this.zzels);
    }

    public final void setAdUnitId(String str) {
        this.zzboa = str;
    }

    public final void showDialog() {
        try {
            if (!(this.mContext instanceof Activity)) {
                zzbbd.zzen("Can not create dialog without Activity Context");
                return;
            }
            String str = !TextUtils.isEmpty(com.google.android.gms.ads.internal.zzbv.o().zzaag()) ? "Creative Preview (Enabled)" : "Creative Preview";
            String str2 = com.google.android.gms.ads.internal.zzbv.o().zzaah() ? "Troubleshooting (Enabled)" : "Troubleshooting";
            ArrayList arrayList = new ArrayList();
            int zza = zza((List<String>) arrayList, "Ad Information", true);
            int zza2 = zza((List<String>) arrayList, str, true);
            int zza3 = zza((List<String>) arrayList, str2, true);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext, com.google.android.gms.ads.internal.zzbv.g().zzaab());
            builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener(this, zza, zza2, zza3) { // from class: com.google.android.gms.internal.ads.Id

                /* renamed from: a, reason: collision with root package name */
                private final zzazc f11591a;

                /* renamed from: b, reason: collision with root package name */
                private final int f11592b;

                /* renamed from: c, reason: collision with root package name */
                private final int f11593c;

                /* renamed from: d, reason: collision with root package name */
                private final int f11594d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f11591a = this;
                    this.f11592b = zza;
                    this.f11593c = zza2;
                    this.f11594d = zza3;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f11591a.zza(this.f11592b, this.f11593c, this.f11594d, dialogInterface, i);
                }
            });
            builder.create().show();
        } catch (WindowManager.BadTokenException e2) {
            if (zzaxz.zzza()) {
                Log.v("Ads", "", e2);
            }
        }
    }

    public final /* synthetic */ void zzaad() {
        com.google.android.gms.ads.internal.zzbv.o().zza(this.mContext, this.zzboa, this.zzbuk, this.zzebe);
    }

    public final /* synthetic */ void zzaae() {
        com.google.android.gms.ads.internal.zzbv.o().zzf(this.mContext, this.zzboa, this.zzbuk);
    }

    public final /* synthetic */ void zzaaf() {
        this.state = 4;
        showDialog();
    }

    public final void zze(MotionEvent motionEvent) {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwd)).booleanValue()) {
            int actionMasked = motionEvent.getActionMasked();
            int historySize = motionEvent.getHistorySize();
            int pointerCount = motionEvent.getPointerCount();
            if (actionMasked == 0) {
                this.state = 0;
                this.zzelt = motionEvent.getX();
                this.zzelu = motionEvent.getY();
                return;
            }
            int i = this.state;
            if (i != -1) {
                boolean z = true;
                if (i == 0 && actionMasked == 5) {
                    this.state = 5;
                    this.zzelv = motionEvent.getX(1);
                    this.zzelw = motionEvent.getY(1);
                    this.handler.postDelayed(this.zzelx, ((Long) zzwu.zzpz().zzd(zzaan.zzcwe)).longValue());
                    return;
                }
                if (this.state == 5) {
                    if (pointerCount == 2) {
                        if (actionMasked == 2) {
                            boolean z2 = false;
                            for (int i2 = 0; i2 < historySize; i2++) {
                                if (!zza(motionEvent.getHistoricalX(0, i2), motionEvent.getHistoricalY(0, i2), motionEvent.getHistoricalX(1, i2), motionEvent.getHistoricalY(1, i2))) {
                                    z2 = true;
                                }
                            }
                            if (zza(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1))) {
                                z = z2;
                            }
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        this.state = -1;
                        this.handler.removeCallbacks(this.zzelx);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        int historySize2 = motionEvent.getHistorySize();
        for (int i3 = 0; i3 < historySize2; i3++) {
            zza(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i3), motionEvent.getHistoricalY(0, i3));
        }
        zza(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }

    public final void zzee(String str) {
        this.zzbuk = str;
    }

    public final void zzef(String str) {
        this.zzelo = str;
    }

    public final void zzeg(String str) {
        this.zzebe = str;
    }

    @VisibleForTesting
    private final void zza(int i, float f2, float f3) {
        if (i == 0) {
            this.state = 0;
            this.zzelp = f2;
            this.zzelq = f3;
            this.zzelr = f3;
            return;
        }
        int i2 = this.state;
        if (i2 == -1) {
            return;
        }
        if (i != 2) {
            if (i == 1 && i2 == 4) {
                showDialog();
                return;
            }
            return;
        }
        if (f3 > this.zzelq) {
            this.zzelq = f3;
        } else if (f3 < this.zzelr) {
            this.zzelr = f3;
        }
        if (this.zzelq - this.zzelr > this.zzdqe * 30.0f) {
            this.state = -1;
            return;
        }
        int i3 = this.state;
        if (i3 == 0 || i3 == 2) {
            if (f2 - this.zzelp >= this.zzdqe * 50.0f) {
                this.zzelp = f2;
                this.state++;
            }
        } else if ((i3 == 1 || i3 == 3) && f2 - this.zzelp <= this.zzdqe * (-50.0f)) {
            this.zzelp = f2;
            this.state++;
        }
        int i4 = this.state;
        if (i4 == 1 || i4 == 3) {
            if (f2 > this.zzelp) {
                this.zzelp = f2;
            }
        } else {
            if (i4 != 2 || f2 >= this.zzelp) {
                return;
            }
            this.zzelp = f2;
        }
    }

    public zzazc(Context context, String str) {
        this(context);
        this.zzelo = str;
    }

    private static int zza(List<String> list, String str, boolean z) {
        list.add(str);
        return list.size() - 1;
    }

    public final /* synthetic */ void zza(String str, DialogInterface dialogInterface, int i) {
        com.google.android.gms.ads.internal.zzbv.e();
        zzayh.zza(this.mContext, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006e, code lost:            if (android.text.TextUtils.isEmpty(r1) == false) goto L44;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void zza(int r1, int r2, int r3, android.content.DialogInterface r4, int r5) {
        /*
            r0 = this;
            if (r5 != r1) goto L9b
            android.content.Context r1 = r0.mContext
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 != 0) goto Le
            java.lang.String r1 = "Can not create dialog without Activity Context"
            com.google.android.gms.internal.ads.zzbbd.zzen(r1)
            return
        Le:
            java.lang.String r1 = r0.zzelo
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L71
            java.lang.String r2 = "\\+"
            java.lang.String r3 = "%20"
            java.lang.String r1 = r1.replaceAll(r2, r3)
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            android.net.Uri$Builder r1 = r2.encodedQuery(r1)
            android.net.Uri r1 = r1.build()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.google.android.gms.ads.internal.zzbv.e()
            java.util.Map r1 = com.google.android.gms.internal.ads.zzayh.zzg(r1)
            java.util.Set r3 = r1.keySet()
            java.util.Iterator r3 = r3.iterator()
        L3f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L62
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r5 = " = "
            r2.append(r5)
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r4 = "\n\n"
            r2.append(r4)
            goto L3f
        L62:
            java.lang.String r1 = r2.toString()
            java.lang.String r1 = r1.trim()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L71
            goto L73
        L71:
            java.lang.String r1 = "No debug information"
        L73:
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            android.content.Context r3 = r0.mContext
            r2.<init>(r3)
            r2.setMessage(r1)
            java.lang.String r3 = "Ad Information"
            r2.setTitle(r3)
            com.google.android.gms.internal.ads.Jd r3 = new com.google.android.gms.internal.ads.Jd
            r3.<init>(r0, r1)
            java.lang.String r1 = "Share"
            r2.setPositiveButton(r1, r3)
            android.content.DialogInterface$OnClickListener r1 = com.google.android.gms.internal.ads.Kd.f11640a
            java.lang.String r3 = "Close"
            r2.setNegativeButton(r3, r1)
            android.app.AlertDialog r1 = r2.create()
            r1.show()
            return
        L9b:
            if (r5 != r2) goto Lab
            java.lang.String r1 = "Debug mode [Creative Preview] selected."
            com.google.android.gms.internal.ads.zzbbd.zzdn(r1)
            com.google.android.gms.internal.ads.Ld r1 = new com.google.android.gms.internal.ads.Ld
            r1.<init>(r0)
            com.google.android.gms.internal.ads.zzayf.zzc(r1)
            return
        Lab:
            if (r5 != r3) goto Lba
            java.lang.String r1 = "Debug mode [Troubleshooting] selected."
            com.google.android.gms.internal.ads.zzbbd.zzdn(r1)
            com.google.android.gms.internal.ads.Md r1 = new com.google.android.gms.internal.ads.Md
            r1.<init>(r0)
            com.google.android.gms.internal.ads.zzayf.zzc(r1)
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazc.zza(int, int, int, android.content.DialogInterface, int):void");
    }
}
