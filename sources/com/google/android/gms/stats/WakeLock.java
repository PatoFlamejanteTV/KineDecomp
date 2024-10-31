package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

@ShowFirstParty
@ThreadSafe
@KeepForSdk
/* loaded from: classes2.dex */
public class WakeLock {

    /* renamed from: a */
    private static ScheduledExecutorService f14149a;

    /* renamed from: b */
    private static volatile zza f14150b = new a();

    /* renamed from: c */
    private final Object f14151c;

    /* renamed from: d */
    private final PowerManager.WakeLock f14152d;

    /* renamed from: e */
    private WorkSource f14153e;

    /* renamed from: f */
    private final int f14154f;

    /* renamed from: g */
    private final String f14155g;

    /* renamed from: h */
    private final String f14156h;
    private final String i;
    private final Context j;
    private boolean k;
    private final Map<String, Integer[]> l;
    private final Set<Future<?>> m;
    private int n;
    private AtomicInteger o;

    /* loaded from: classes2.dex */
    public interface zza {
    }

    @KeepForSdk
    public WakeLock(Context context, int i, String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    private final List<String> c() {
        return WorkSourceUtil.a(this.f14153e);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:            if (r2 == false) goto L52;     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005e, code lost:            com.google.android.gms.common.stats.WakeLockTracker.a().a(r13.j, com.google.android.gms.common.stats.StatsUtils.a(r13.f14152d, r6), 7, r13.f14155g, r6, null, r13.f14154f, c(), r14);        r13.n++;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:            if (r13.n == 0) goto L56;     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(long r14) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r13.o
            r0.incrementAndGet()
            r0 = 0
            java.lang.String r6 = r13.a(r0)
            java.lang.Object r0 = r13.f14151c
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.l     // Catch: java.lang.Throwable -> L96
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L96
            r2 = 0
            if (r1 == 0) goto L1a
            int r1 = r13.n     // Catch: java.lang.Throwable -> L96
            if (r1 <= 0) goto L29
        L1a:
            android.os.PowerManager$WakeLock r1 = r13.f14152d     // Catch: java.lang.Throwable -> L96
            boolean r1 = r1.isHeld()     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L29
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.l     // Catch: java.lang.Throwable -> L96
            r1.clear()     // Catch: java.lang.Throwable -> L96
            r13.n = r2     // Catch: java.lang.Throwable -> L96
        L29:
            boolean r1 = r13.k     // Catch: java.lang.Throwable -> L96
            r12 = 1
            if (r1 == 0) goto L56
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.l     // Catch: java.lang.Throwable -> L96
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L96
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L47
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.l     // Catch: java.lang.Throwable -> L96
            java.lang.Integer[] r3 = new java.lang.Integer[r12]     // Catch: java.lang.Throwable -> L96
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L96
            r3[r2] = r4     // Catch: java.lang.Throwable -> L96
            r1.put(r6, r3)     // Catch: java.lang.Throwable -> L96
            r2 = 1
            goto L54
        L47:
            r3 = r1[r2]     // Catch: java.lang.Throwable -> L96
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L96
            int r3 = r3 + r12
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L96
            r1[r2] = r3     // Catch: java.lang.Throwable -> L96
        L54:
            if (r2 != 0) goto L5e
        L56:
            boolean r1 = r13.k     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L7d
            int r1 = r13.n     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L7d
        L5e:
            com.google.android.gms.common.stats.WakeLockTracker r1 = com.google.android.gms.common.stats.WakeLockTracker.a()     // Catch: java.lang.Throwable -> L96
            android.content.Context r2 = r13.j     // Catch: java.lang.Throwable -> L96
            android.os.PowerManager$WakeLock r3 = r13.f14152d     // Catch: java.lang.Throwable -> L96
            java.lang.String r3 = com.google.android.gms.common.stats.StatsUtils.a(r3, r6)     // Catch: java.lang.Throwable -> L96
            r4 = 7
            java.lang.String r5 = r13.f14155g     // Catch: java.lang.Throwable -> L96
            r7 = 0
            int r8 = r13.f14154f     // Catch: java.lang.Throwable -> L96
            java.util.List r9 = r13.c()     // Catch: java.lang.Throwable -> L96
            r10 = r14
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L96
            int r1 = r13.n     // Catch: java.lang.Throwable -> L96
            int r1 = r1 + r12
            r13.n = r1     // Catch: java.lang.Throwable -> L96
        L7d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            android.os.PowerManager$WakeLock r0 = r13.f14152d
            r0.acquire()
            r0 = 0
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r2 <= 0) goto L95
            java.util.concurrent.ScheduledExecutorService r0 = com.google.android.gms.stats.WakeLock.f14149a
            com.google.android.gms.stats.b r1 = new com.google.android.gms.stats.b
            r1.<init>(r13)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r14, r2)
        L95:
            return
        L96:
            r14 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.a(long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0050, code lost:            if (r1 != false) goto L53;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005a, code lost:            com.google.android.gms.common.stats.WakeLockTracker.a().a(r12.j, com.google.android.gms.common.stats.StatsUtils.a(r12.f14152d, r6), 8, r12.f14155g, r6, null, r12.f14154f, c());        r12.n--;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:            if (r12.n == 1) goto L53;     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r12.o
            int r0 = r0.decrementAndGet()
            if (r0 >= 0) goto L19
            java.lang.String r0 = r12.f14155g
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = " release without a matched acquire!"
            java.lang.String r0 = r0.concat(r1)
            java.lang.String r1 = "WakeLock"
            android.util.Log.e(r1, r0)
        L19:
            r0 = 0
            java.lang.String r6 = r12.a(r0)
            java.lang.Object r0 = r12.f14151c
            monitor-enter(r0)
            boolean r1 = r12.k     // Catch: java.lang.Throwable -> L7e
            r10 = 1
            r11 = 0
            if (r1 == 0) goto L52
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.l     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L7e
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L33
        L31:
            r1 = 0
            goto L50
        L33:
            r2 = r1[r11]     // Catch: java.lang.Throwable -> L7e
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L7e
            if (r2 != r10) goto L42
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.l     // Catch: java.lang.Throwable -> L7e
            r1.remove(r6)     // Catch: java.lang.Throwable -> L7e
            r1 = 1
            goto L50
        L42:
            r2 = r1[r11]     // Catch: java.lang.Throwable -> L7e
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L7e
            int r2 = r2 - r10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L7e
            r1[r11] = r2     // Catch: java.lang.Throwable -> L7e
            goto L31
        L50:
            if (r1 != 0) goto L5a
        L52:
            boolean r1 = r12.k     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L79
            int r1 = r12.n     // Catch: java.lang.Throwable -> L7e
            if (r1 != r10) goto L79
        L5a:
            com.google.android.gms.common.stats.WakeLockTracker r1 = com.google.android.gms.common.stats.WakeLockTracker.a()     // Catch: java.lang.Throwable -> L7e
            android.content.Context r2 = r12.j     // Catch: java.lang.Throwable -> L7e
            android.os.PowerManager$WakeLock r3 = r12.f14152d     // Catch: java.lang.Throwable -> L7e
            java.lang.String r3 = com.google.android.gms.common.stats.StatsUtils.a(r3, r6)     // Catch: java.lang.Throwable -> L7e
            r4 = 8
            java.lang.String r5 = r12.f14155g     // Catch: java.lang.Throwable -> L7e
            r7 = 0
            int r8 = r12.f14154f     // Catch: java.lang.Throwable -> L7e
            java.util.List r9 = r12.c()     // Catch: java.lang.Throwable -> L7e
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L7e
            int r1 = r12.n     // Catch: java.lang.Throwable -> L7e
            int r1 = r1 - r10
            r12.n = r1     // Catch: java.lang.Throwable -> L7e
        L79:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            r12.a(r11)
            return
        L7e:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            goto L82
        L81:
            throw r1
        L82:
            goto L81
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.b():void");
    }

    private WakeLock(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, null, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private WakeLock(Context context, int i, String str, String str2, String str3, String str4) {
        this.f14151c = this;
        this.k = true;
        this.l = new HashMap();
        this.m = Collections.synchronizedSet(new HashSet());
        this.o = new AtomicInteger(0);
        Preconditions.a(context, "WakeLock: context must not be null");
        Preconditions.a(str, (Object) "WakeLock: wakeLockName must not be empty");
        this.f14154f = i;
        this.f14156h = null;
        this.i = null;
        this.j = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            this.f14155g = valueOf.length() != 0 ? "*gcore*:".concat(valueOf) : new String("*gcore*:");
        } else {
            this.f14155g = str;
        }
        this.f14152d = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (WorkSourceUtil.a(context)) {
            this.f14153e = WorkSourceUtil.a(context, Strings.b(str3) ? context.getPackageName() : str3);
            WorkSource workSource = this.f14153e;
            if (workSource != null && WorkSourceUtil.a(this.j)) {
                WorkSource workSource2 = this.f14153e;
                if (workSource2 != null) {
                    workSource2.add(workSource);
                } else {
                    this.f14153e = workSource;
                }
                try {
                    this.f14152d.setWorkSource(this.f14153e);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
                    Log.wtf("WakeLock", e2.toString());
                }
            }
        }
        if (f14149a == null) {
            f14149a = PooledExecutorsProvider.a().a();
        }
    }

    public final void a(int i) {
        if (this.f14152d.isHeld()) {
            try {
                this.f14152d.release();
            } catch (RuntimeException e2) {
                if (e2.getClass().equals(RuntimeException.class)) {
                    Log.e("WakeLock", String.valueOf(this.f14155g).concat(" was already released!"), e2);
                } else {
                    throw e2;
                }
            }
            this.f14152d.isHeld();
        }
    }

    private final String a(String str) {
        return (!this.k || TextUtils.isEmpty(str)) ? this.f14156h : str;
    }

    @KeepForSdk
    public void a(boolean z) {
        this.f14152d.setReferenceCounted(z);
        this.k = z;
    }

    @KeepForSdk
    public boolean a() {
        return this.f14152d.isHeld();
    }
}
