package com.google.android.gms.playlog.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzse;
import com.google.android.gms.playlog.internal.zza;
import com.google.android.gms.playlog.internal.zzb;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class zzf extends zzj<zza> {

    /* renamed from: a, reason: collision with root package name */
    private final String f2150a;
    private final zzd b;
    private final zzb c;
    private final Object d;
    private boolean e;

    public zzf(Context context, Looper looper, zzd zzdVar, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, looper, 24, zzfVar, zzdVar, zzdVar);
        this.f2150a = context.getPackageName();
        this.b = (zzd) zzx.a(zzdVar);
        this.b.a(this);
        this.c = new zzb();
        this.d = new Object();
        this.e = true;
    }

    private void b(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.c.a(playLoggerContext, logEvent);
    }

    private void c() {
        PlayLoggerContext playLoggerContext;
        com.google.android.gms.common.internal.zzb.a(!this.e);
        if (this.c.e()) {
            return;
        }
        PlayLoggerContext playLoggerContext2 = null;
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<zzb.zza> it = this.c.a().iterator();
            while (it.hasNext()) {
                zzb.zza next = it.next();
                if (next.c != null) {
                    zzpc().a(this.f2150a, next.f2148a, zzse.zzf(next.c));
                } else {
                    if (next.f2148a.equals(playLoggerContext2)) {
                        arrayList.add(next.b);
                        playLoggerContext = playLoggerContext2;
                    } else {
                        if (!arrayList.isEmpty()) {
                            zzpc().a(this.f2150a, playLoggerContext2, arrayList);
                            arrayList.clear();
                        }
                        PlayLoggerContext playLoggerContext3 = next.f2148a;
                        arrayList.add(next.b);
                        playLoggerContext = playLoggerContext3;
                    }
                    playLoggerContext2 = playLoggerContext;
                }
            }
            if (!arrayList.isEmpty()) {
                zzpc().a(this.f2150a, playLoggerContext2, arrayList);
            }
            this.c.b();
        } catch (RemoteException e) {
            Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
        }
    }

    private void c(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        try {
            c();
            zzpc().a(this.f2150a, playLoggerContext, logEvent);
        } catch (RemoteException e) {
            Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
            b(playLoggerContext, logEvent);
        } catch (IllegalStateException e2) {
            Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
            b(playLoggerContext, logEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zza zzW(IBinder iBinder) {
        return zza.AbstractBinderC0044zza.a(iBinder);
    }

    public void a() {
        synchronized (this.d) {
            if (isConnecting() || isConnected()) {
                return;
            }
            this.b.a(true);
            zzoZ();
        }
    }

    public void a(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        synchronized (this.d) {
            if (this.e) {
                b(playLoggerContext, logEvent);
            } else {
                c(playLoggerContext, logEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        synchronized (this.d) {
            boolean z2 = this.e;
            this.e = z;
            if (z2 && !this.e) {
                c();
            }
        }
    }

    public void b() {
        synchronized (this.d) {
            this.b.a(false);
            disconnect();
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.playlog.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }
}
