package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.Map;

@zzgr
/* loaded from: classes.dex */
public class zzif {
    private final Context mContext;
    private int mState;
    private final float zzAC;
    private String zzII;
    private float zzIJ;
    private float zzIK;
    private float zzIL;

    public zzif(Context context) {
        this.mState = 0;
        this.mContext = context;
        this.zzAC = context.getResources().getDisplayMetrics().density;
    }

    public zzif(Context context, String str) {
        this(context);
        this.zzII = str;
    }

    private void showDialog() {
        if (!(this.mContext instanceof Activity)) {
            com.google.android.gms.ads.internal.util.client.zzb.c("Can not create dialog without Activity Context");
            return;
        }
        String zzaD = zzaD(this.zzII);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setMessage(zzaD);
        builder.setTitle("Ad Information");
        builder.setPositiveButton("Share", new dv(this, zzaD));
        builder.setNegativeButton("Close", new dw(this));
        builder.create().show();
    }

    static String zzaD(String str) {
        if (TextUtils.isEmpty(str)) {
            return "No debug information";
        }
        Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
        StringBuilder sb = new StringBuilder();
        Map<String, String> zze = com.google.android.gms.ads.internal.zzp.e().zze(build);
        for (String str2 : zze.keySet()) {
            sb.append(str2).append(" = ").append(zze.get(str2)).append("\n\n");
        }
        String trim = sb.toString().trim();
        return TextUtils.isEmpty(trim) ? "No debug information" : trim;
    }

    void zza(int i, float f, float f2) {
        if (i == 0) {
            this.mState = 0;
            this.zzIJ = f;
            this.zzIK = f2;
            this.zzIL = f2;
            return;
        }
        if (this.mState != -1) {
            if (i != 2) {
                if (i == 1 && this.mState == 4) {
                    showDialog();
                    return;
                }
                return;
            }
            if (f2 > this.zzIK) {
                this.zzIK = f2;
            } else if (f2 < this.zzIL) {
                this.zzIL = f2;
            }
            if (this.zzIK - this.zzIL > 30.0f * this.zzAC) {
                this.mState = -1;
                return;
            }
            if (this.mState == 0 || this.mState == 2) {
                if (f - this.zzIJ >= 50.0f * this.zzAC) {
                    this.zzIJ = f;
                    this.mState++;
                }
            } else if ((this.mState == 1 || this.mState == 3) && f - this.zzIJ <= (-50.0f) * this.zzAC) {
                this.zzIJ = f;
                this.mState++;
            }
            if (this.mState == 1 || this.mState == 3) {
                if (f > this.zzIJ) {
                    this.zzIJ = f;
                }
            } else {
                if (this.mState != 2 || f >= this.zzIJ) {
                    return;
                }
                this.zzIJ = f;
            }
        }
    }

    public void zzaC(String str) {
        this.zzII = str;
    }

    public void zze(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            zza(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        zza(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
