package com.google.android.gms.internal;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes.dex */
public class zzqy {
    private final Context mContext;
    private final PowerManager.WakeLock zzaVs;
    private WorkSource zzaVt;
    private final int zzaVu;
    private final String zzaVv;
    private boolean zzaVw;
    private int zzaVx;
    private int zzaVy;
    private final String zzaia;
    private static String TAG = "WakeLock";
    private static boolean DEBUG = false;

    public zzqy(Context context, int i, String str) {
        this(context, i, str, null, null);
    }

    public zzqy(Context context, int i, String str, String str2, String str3) {
        this.zzaVw = true;
        com.google.android.gms.common.internal.zzx.a(str, (Object) "Wake lock name can NOT be empty");
        this.zzaVu = i;
        this.zzaia = str;
        this.zzaVv = str2;
        this.mContext = context.getApplicationContext();
        this.zzaVs = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (zznc.zzar(this.mContext)) {
            if (zznb.zzcA(str3)) {
                if (com.google.android.gms.common.internal.zzd.f1003a && zzlr.isInitialized()) {
                    Log.e(TAG, "callingPackage is not supposed to be empty for wakelock " + this.zzaia + "!", new IllegalArgumentException());
                    str3 = "com.google.android.gms";
                } else {
                    str3 = context.getPackageName();
                }
            }
            this.zzaVt = zznc.zzm(context, str3);
            zzc(this.zzaVt);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0075, code lost:            if (r0 == false) goto L11;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007e, code lost:            if (r8.zzaVy == 1) goto L15;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void zzeu(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = r8.zzev(r9)
            java.lang.String r5 = r8.zzj(r9, r0)
            boolean r1 = com.google.android.gms.internal.zzqy.DEBUG
            if (r1 == 0) goto L68
            java.lang.String r1 = com.google.android.gms.internal.zzqy.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Release:\n mWakeLockName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r8.zzaia
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\n mSecondaryName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r8.zzaVv
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nmReferenceCounted: "
            java.lang.StringBuilder r2 = r2.append(r3)
            boolean r3 = r8.zzaVw
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nreason: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r3 = "\n mOpenEventCount"
            java.lang.StringBuilder r2 = r2.append(r3)
            int r3 = r8.zzaVy
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nuseWithReason: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r3 = "\ntrackingName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r1, r2)
        L68:
            monitor-enter(r8)
            boolean r1 = r8.zzaVw     // Catch: java.lang.Throwable -> La3
            if (r1 == 0) goto L77
            int r1 = r8.zzaVx     // Catch: java.lang.Throwable -> La3
            int r1 = r1 + (-1)
            r8.zzaVx = r1     // Catch: java.lang.Throwable -> La3
            if (r1 == 0) goto L80
            if (r0 != 0) goto L80
        L77:
            boolean r0 = r8.zzaVw     // Catch: java.lang.Throwable -> La3
            if (r0 != 0) goto La1
            int r0 = r8.zzaVy     // Catch: java.lang.Throwable -> La3
            r1 = 1
            if (r0 != r1) goto La1
        L80:
            com.google.android.gms.common.stats.zzi r0 = com.google.android.gms.common.stats.zzi.a()     // Catch: java.lang.Throwable -> La3
            android.content.Context r1 = r8.mContext     // Catch: java.lang.Throwable -> La3
            android.os.PowerManager$WakeLock r2 = r8.zzaVs     // Catch: java.lang.Throwable -> La3
            java.lang.String r2 = com.google.android.gms.common.stats.zzg.a(r2, r5)     // Catch: java.lang.Throwable -> La3
            r3 = 8
            java.lang.String r4 = r8.zzaia     // Catch: java.lang.Throwable -> La3
            int r6 = r8.zzaVu     // Catch: java.lang.Throwable -> La3
            android.os.WorkSource r7 = r8.zzaVt     // Catch: java.lang.Throwable -> La3
            java.util.List r7 = com.google.android.gms.internal.zznc.zzb(r7)     // Catch: java.lang.Throwable -> La3
            r0.a(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> La3
            int r0 = r8.zzaVy     // Catch: java.lang.Throwable -> La3
            int r0 = r0 + (-1)
            r8.zzaVy = r0     // Catch: java.lang.Throwable -> La3
        La1:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> La3
            return
        La3:
            r0 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> La3
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqy.zzeu(java.lang.String):void");
    }

    private boolean zzev(String str) {
        return (TextUtils.isEmpty(str) || str.equals(this.zzaVv)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x007f, code lost:            if (r0 == false) goto L11;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0087, code lost:            if (r10.zzaVy == 0) goto L15;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void zzi(java.lang.String r11, long r12) {
        /*
            r10 = this;
            boolean r0 = r10.zzev(r11)
            java.lang.String r5 = r10.zzj(r11, r0)
            boolean r1 = com.google.android.gms.internal.zzqy.DEBUG
            if (r1 == 0) goto L72
            java.lang.String r1 = com.google.android.gms.internal.zzqy.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Acquire:\n mWakeLockName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r10.zzaia
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\n mSecondaryName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r10.zzaVv
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nmReferenceCounted: "
            java.lang.StringBuilder r2 = r2.append(r3)
            boolean r3 = r10.zzaVw
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nreason: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r11)
            java.lang.String r3 = "\nmOpenEventCount"
            java.lang.StringBuilder r2 = r2.append(r3)
            int r3 = r10.zzaVy
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nuseWithReason: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r3 = "\ntrackingName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r3 = "\ntimeout: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r12)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r1, r2)
        L72:
            monitor-enter(r10)
            boolean r1 = r10.zzaVw     // Catch: java.lang.Throwable -> Lac
            if (r1 == 0) goto L81
            int r1 = r10.zzaVx     // Catch: java.lang.Throwable -> Lac
            int r2 = r1 + 1
            r10.zzaVx = r2     // Catch: java.lang.Throwable -> Lac
            if (r1 == 0) goto L89
            if (r0 != 0) goto L89
        L81:
            boolean r0 = r10.zzaVw     // Catch: java.lang.Throwable -> Lac
            if (r0 != 0) goto Laa
            int r0 = r10.zzaVy     // Catch: java.lang.Throwable -> Lac
            if (r0 != 0) goto Laa
        L89:
            com.google.android.gms.common.stats.zzi r0 = com.google.android.gms.common.stats.zzi.a()     // Catch: java.lang.Throwable -> Lac
            android.content.Context r1 = r10.mContext     // Catch: java.lang.Throwable -> Lac
            android.os.PowerManager$WakeLock r2 = r10.zzaVs     // Catch: java.lang.Throwable -> Lac
            java.lang.String r2 = com.google.android.gms.common.stats.zzg.a(r2, r5)     // Catch: java.lang.Throwable -> Lac
            r3 = 7
            java.lang.String r4 = r10.zzaia     // Catch: java.lang.Throwable -> Lac
            int r6 = r10.zzaVu     // Catch: java.lang.Throwable -> Lac
            android.os.WorkSource r7 = r10.zzaVt     // Catch: java.lang.Throwable -> Lac
            java.util.List r7 = com.google.android.gms.internal.zznc.zzb(r7)     // Catch: java.lang.Throwable -> Lac
            r8 = r12
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lac
            int r0 = r10.zzaVy     // Catch: java.lang.Throwable -> Lac
            int r0 = r0 + 1
            r10.zzaVy = r0     // Catch: java.lang.Throwable -> Lac
        Laa:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> Lac
            return
        Lac:
            r0 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> Lac
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqy.zzi(java.lang.String, long):void");
    }

    private String zzj(String str, boolean z) {
        return (this.zzaVw && z) ? str : this.zzaVv;
    }

    public void acquire(long j) {
        if (!zzmx.zzqx() && this.zzaVw) {
            Log.wtf(TAG, "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: " + this.zzaia);
        }
        zzi(null, j);
        this.zzaVs.acquire(j);
    }

    public boolean isHeld() {
        return this.zzaVs.isHeld();
    }

    public void release() {
        zzeu(null);
        this.zzaVs.release();
    }

    public void setReferenceCounted(boolean z) {
        this.zzaVs.setReferenceCounted(z);
        this.zzaVw = z;
    }

    public void zzc(WorkSource workSource) {
        if (!zznc.zzar(this.mContext) || workSource == null) {
            return;
        }
        if (this.zzaVt != null) {
            this.zzaVt.add(workSource);
        } else {
            this.zzaVt = workSource;
        }
        this.zzaVs.setWorkSource(this.zzaVt);
    }
}
