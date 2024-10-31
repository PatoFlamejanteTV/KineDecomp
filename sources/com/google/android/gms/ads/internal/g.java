package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.internal.zzaj;
import com.google.android.gms.internal.zzam;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzic;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
@zzgr
/* loaded from: classes.dex */
public class g implements zzaj, Runnable {
    private zzq d;
    private final List<Object[]> b = new Vector();
    private final AtomicReference<zzaj> c = new AtomicReference<>();

    /* renamed from: a, reason: collision with root package name */
    CountDownLatch f580a = new CountDownLatch(1);

    public g(zzq zzqVar) {
        this.d = zzqVar;
        if (com.google.android.gms.ads.internal.client.zzl.a().b()) {
            zzic.zza(this);
        } else {
            run();
        }
    }

    private Context a(Context context) {
        Context applicationContext;
        return (zzby.zzuw.get().booleanValue() && (applicationContext = context.getApplicationContext()) != null) ? applicationContext : context;
    }

    private void b() {
        if (this.b.isEmpty()) {
            return;
        }
        for (Object[] objArr : this.b) {
            if (objArr.length == 1) {
                this.c.get().zza((MotionEvent) objArr[0]);
            } else if (objArr.length == 3) {
                this.c.get().zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.b.clear();
    }

    protected zzaj a(String str, Context context, boolean z) {
        return zzam.zza(str, context, z);
    }

    protected void a(zzaj zzajVar) {
        this.c.set(zzajVar);
    }

    protected boolean a() {
        try {
            this.f580a.await();
            return true;
        } catch (InterruptedException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a(a(this.d.e.b, a(this.d.c), !zzby.zzuI.get().booleanValue() || this.d.e.e));
        } finally {
            this.f580a.countDown();
            this.d = null;
        }
    }

    @Override // com.google.android.gms.internal.zzaj
    public void zza(int i, int i2, int i3) {
        zzaj zzajVar = this.c.get();
        if (zzajVar == null) {
            this.b.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else {
            b();
            zzajVar.zza(i, i2, i3);
        }
    }

    @Override // com.google.android.gms.internal.zzaj
    public void zza(MotionEvent motionEvent) {
        zzaj zzajVar = this.c.get();
        if (zzajVar == null) {
            this.b.add(new Object[]{motionEvent});
        } else {
            b();
            zzajVar.zza(motionEvent);
        }
    }

    @Override // com.google.android.gms.internal.zzaj
    public String zzb(Context context) {
        zzaj zzajVar;
        if (!a() || (zzajVar = this.c.get()) == null) {
            return "";
        }
        b();
        return zzajVar.zzb(a(context));
    }

    @Override // com.google.android.gms.internal.zzaj
    public String zzb(Context context, String str) {
        zzaj zzajVar;
        if (!a() || (zzajVar = this.c.get()) == null) {
            return "";
        }
        b();
        return zzajVar.zzb(a(context), str);
    }
}
