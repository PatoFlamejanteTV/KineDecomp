package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

@zzark
/* renamed from: com.google.android.gms.internal.ads.se */
/* loaded from: classes2.dex */
final class C1080se {

    /* renamed from: a */
    private final Object f12515a = new Object();

    /* renamed from: b */
    private final List<Runnable> f12516b = new ArrayList();

    /* renamed from: c */
    private boolean f12517c = false;

    public final void a(Runnable runnable, Executor executor) {
        synchronized (this.f12515a) {
            if (this.f12517c) {
                executor.execute(runnable);
            } else {
                this.f12516b.add(new Runnable(executor, runnable) { // from class: com.google.android.gms.internal.ads.te

                    /* renamed from: a, reason: collision with root package name */
                    private final Executor f12549a;

                    /* renamed from: b, reason: collision with root package name */
                    private final Runnable f12550b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f12549a = executor;
                        this.f12550b = runnable;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f12549a.execute(this.f12550b);
                    }
                });
            }
        }
    }

    public final void a() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f12515a) {
            if (this.f12517c) {
                return;
            }
            arrayList.addAll(this.f12516b);
            this.f12516b.clear();
            this.f12517c = true;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((Runnable) obj).run();
            }
        }
    }
}
