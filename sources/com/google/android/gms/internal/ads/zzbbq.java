package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzark
/* loaded from: classes2.dex */
public final class zzbbq {
    public static <V> void zza(final zzbcb<V> zzbcbVar, final zzbbn<V> zzbbnVar, Executor executor) {
        zzbcbVar.zza(new Runnable(zzbbnVar, zzbcbVar) { // from class: com.google.android.gms.internal.ads.ie

            /* renamed from: a, reason: collision with root package name */
            private final zzbbn f12210a;

            /* renamed from: b, reason: collision with root package name */
            private final zzbcb f12211b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12210a = zzbbnVar;
                this.f12211b = zzbcbVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbbn zzbbnVar2 = this.f12210a;
                try {
                    zzbbnVar2.zzl(this.f12211b.get());
                } catch (InterruptedException e2) {
                    e = e2;
                    Thread.currentThread().interrupt();
                    zzbbnVar2.zzb(e);
                } catch (ExecutionException e3) {
                    e = e3.getCause();
                    zzbbnVar2.zzb(e);
                } catch (Exception e4) {
                    e = e4;
                    zzbbnVar2.zzb(e);
                }
            }
        }, executor);
    }

    public static <T> C1053qe<T> zzd(Throwable th) {
        return new C1053qe<>(th);
    }

    public static <T> C1066re<T> zzm(T t) {
        return new C1066re<>(t);
    }

    public static <A, B> zzbcb<B> zza(final zzbcb<A> zzbcbVar, final zzbbm<A, B> zzbbmVar, Executor executor) {
        final zzbcl zzbclVar = new zzbcl();
        zzbcbVar.zza(new Runnable(zzbclVar, zzbbmVar, zzbcbVar) { // from class: com.google.android.gms.internal.ads.je

            /* renamed from: a, reason: collision with root package name */
            private final zzbcl f12223a;

            /* renamed from: b, reason: collision with root package name */
            private final zzbbm f12224b;

            /* renamed from: c, reason: collision with root package name */
            private final zzbcb f12225c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12223a = zzbclVar;
                this.f12224b = zzbbmVar;
                this.f12225c = zzbcbVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbcl zzbclVar2 = this.f12223a;
                try {
                    zzbclVar2.set(this.f12224b.apply(this.f12225c.get()));
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    zzbclVar2.setException(e2);
                } catch (CancellationException unused) {
                    zzbclVar2.cancel(true);
                } catch (ExecutionException e3) {
                    e = e3;
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        e = cause;
                    }
                    zzbclVar2.setException(e);
                } catch (Exception e4) {
                    zzbclVar2.setException(e4);
                }
            }
        }, executor);
        zza((zzbcb) zzbclVar, (Future) zzbcbVar);
        return zzbclVar;
    }

    public static <A, B> zzbcb<B> zza(final zzbcb<A> zzbcbVar, final zzbbl<? super A, ? extends B> zzbblVar, Executor executor) {
        final zzbcl zzbclVar = new zzbcl();
        zzbcbVar.zza(new Runnable(zzbclVar, zzbblVar, zzbcbVar) { // from class: com.google.android.gms.internal.ads.ke

            /* renamed from: a, reason: collision with root package name */
            private final zzbcl f12257a;

            /* renamed from: b, reason: collision with root package name */
            private final zzbbl f12258b;

            /* renamed from: c, reason: collision with root package name */
            private final zzbcb f12259c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12257a = zzbclVar;
                this.f12258b = zzbblVar;
                this.f12259c = zzbcbVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbbq.zza(this.f12257a, this.f12258b, this.f12259c);
            }
        }, executor);
        zza((zzbcb) zzbclVar, (Future) zzbcbVar);
        return zzbclVar;
    }

    public static <V> zzbcb<V> zza(zzbcb<V> zzbcbVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        final zzbcl zzbclVar = new zzbcl();
        zza((zzbcb) zzbclVar, (Future) zzbcbVar);
        final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable(zzbclVar) { // from class: com.google.android.gms.internal.ads.le

            /* renamed from: a, reason: collision with root package name */
            private final zzbcl f12294a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12294a = zzbclVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12294a.setException(new TimeoutException());
            }
        }, j, timeUnit);
        zza((zzbcb) zzbcbVar, zzbclVar);
        zzbclVar.zza(new Runnable(schedule) { // from class: com.google.android.gms.internal.ads.me

            /* renamed from: a, reason: collision with root package name */
            private final Future f12326a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12326a = schedule;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Future future = this.f12326a;
                if (future.isDone()) {
                    return;
                }
                future.cancel(true);
            }
        }, zzbcg.zzepp);
        return zzbclVar;
    }

    public static <V, X extends Throwable> zzbcb<V> zza(final zzbcb<? extends V> zzbcbVar, final Class<X> cls, final zzbbl<? super X, ? extends V> zzbblVar, final Executor executor) {
        final zzbcl zzbclVar = new zzbcl();
        zza((zzbcb) zzbclVar, (Future) zzbcbVar);
        zzbcbVar.zza(new Runnable(zzbclVar, zzbcbVar, cls, zzbblVar, executor) { // from class: com.google.android.gms.internal.ads.ne

            /* renamed from: a, reason: collision with root package name */
            private final zzbcl f12349a;

            /* renamed from: b, reason: collision with root package name */
            private final zzbcb f12350b;

            /* renamed from: c, reason: collision with root package name */
            private final Class f12351c;

            /* renamed from: d, reason: collision with root package name */
            private final zzbbl f12352d;

            /* renamed from: e, reason: collision with root package name */
            private final Executor f12353e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12349a = zzbclVar;
                this.f12350b = zzbcbVar;
                this.f12351c = cls;
                this.f12352d = zzbblVar;
                this.f12353e = executor;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbbq.zza(this.f12349a, this.f12350b, this.f12351c, this.f12352d, this.f12353e);
            }
        }, zzbcg.zzepp);
        return zzbclVar;
    }

    public static <T> T zza(Future<T> future, T t) {
        try {
            return future.get(((Long) zzwu.zzpz().zzd(zzaan.zzctd)).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            future.cancel(true);
            zzbbd.zzc("InterruptedException caught while resolving future.", e2);
            Thread.currentThread().interrupt();
            com.google.android.gms.ads.internal.zzbv.i().zzb(e2, "Futures.resolveFuture");
            return t;
        } catch (Exception e3) {
            future.cancel(true);
            zzbbd.zzb("Error waiting for future.", e3);
            com.google.android.gms.ads.internal.zzbv.i().zzb(e3, "Futures.resolveFuture");
            return t;
        }
    }

    public static <T> T zza(Future<T> future, T t, long j, TimeUnit timeUnit) {
        try {
            return future.get(j, timeUnit);
        } catch (InterruptedException e2) {
            future.cancel(true);
            zzbbd.zzc("InterruptedException caught while resolving future.", e2);
            Thread.currentThread().interrupt();
            com.google.android.gms.ads.internal.zzbv.i().zzb(e2, "Futures.resolveFuture");
            return t;
        } catch (Exception e3) {
            future.cancel(true);
            zzbbd.zzb("Error waiting for future.", e3);
            com.google.android.gms.ads.internal.zzbv.i().zzb(e3, "Futures.resolveFuture");
            return t;
        }
    }

    private static <V> void zza(final zzbcb<? extends V> zzbcbVar, final zzbcl<V> zzbclVar) {
        zza((zzbcb) zzbclVar, (Future) zzbcbVar);
        zzbcbVar.zza(new Runnable(zzbclVar, zzbcbVar) { // from class: com.google.android.gms.internal.ads.oe

            /* renamed from: a, reason: collision with root package name */
            private final zzbcl f12384a;

            /* renamed from: b, reason: collision with root package name */
            private final zzbcb f12385b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12384a = zzbclVar;
                this.f12385b = zzbcbVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbcl zzbclVar2 = this.f12384a;
                try {
                    zzbclVar2.set(this.f12385b.get());
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    zzbclVar2.setException(e2);
                } catch (ExecutionException e3) {
                    zzbclVar2.setException(e3.getCause());
                } catch (Exception e4) {
                    zzbclVar2.setException(e4);
                }
            }
        }, zzbcg.zzepp);
    }

    private static <A, B> void zza(final zzbcb<A> zzbcbVar, final Future<B> future) {
        zzbcbVar.zza(new Runnable(zzbcbVar, future) { // from class: com.google.android.gms.internal.ads.pe

            /* renamed from: a, reason: collision with root package name */
            private final zzbcb f12424a;

            /* renamed from: b, reason: collision with root package name */
            private final Future f12425b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12424a = zzbcbVar;
                this.f12425b = future;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbcb zzbcbVar2 = this.f12424a;
                Future future2 = this.f12425b;
                if (zzbcbVar2.isCancelled()) {
                    future2.cancel(true);
                }
            }
        }, zzbcg.zzepp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzbcl r1, com.google.android.gms.internal.ads.zzbcb r2, java.lang.Class r3, com.google.android.gms.internal.ads.zzbbl r4, java.util.concurrent.Executor r5) {
        /*
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Exception -> L8 java.lang.InterruptedException -> La java.util.concurrent.ExecutionException -> L13
            r1.set(r2)     // Catch: java.lang.Exception -> L8 java.lang.InterruptedException -> La java.util.concurrent.ExecutionException -> L13
            return
        L8:
            r2 = move-exception
            goto L18
        La:
            r2 = move-exception
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L18
        L13:
            r2 = move-exception
            java.lang.Throwable r2 = r2.getCause()
        L18:
            boolean r3 = r3.isInstance(r2)
            if (r3 == 0) goto L2a
            com.google.android.gms.internal.ads.re r2 = zzm(r2)
            com.google.android.gms.internal.ads.zzbcb r2 = zza(r2, r4, r5)
            zza(r2, r1)
            return
        L2a:
            r1.setException(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbq.zza(com.google.android.gms.internal.ads.zzbcl, com.google.android.gms.internal.ads.zzbcb, java.lang.Class, com.google.android.gms.internal.ads.zzbbl, java.util.concurrent.Executor):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(zzbcl zzbclVar, zzbbl zzbblVar, zzbcb zzbcbVar) {
        if (zzbclVar.isCancelled()) {
            return;
        }
        try {
            zza(zzbblVar.zzf(zzbcbVar.get()), zzbclVar);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            zzbclVar.setException(e2);
        } catch (CancellationException unused) {
            zzbclVar.cancel(true);
        } catch (ExecutionException e3) {
            zzbclVar.setException(e3.getCause());
        } catch (Exception e4) {
            zzbclVar.setException(e4);
        }
    }
}
