package io.fabric.sdk.android.services.settings;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Settings.java */
/* loaded from: classes3.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<u> f27050a;

    /* renamed from: b, reason: collision with root package name */
    private final CountDownLatch f27051b;

    /* renamed from: c, reason: collision with root package name */
    private t f27052c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f27053d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Settings.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final s f27054a = new s();
    }

    public static s b() {
        return a.f27054a;
    }

    public synchronized s a(io.fabric.sdk.android.l lVar, IdManager idManager, io.fabric.sdk.android.services.network.f fVar, String str, String str2, String str3) {
        if (this.f27053d) {
            return this;
        }
        if (this.f27052c == null) {
            Context context = lVar.getContext();
            String e2 = idManager.e();
            String d2 = new io.fabric.sdk.android.services.common.i().d(context);
            String h2 = idManager.h();
            this.f27052c = new k(lVar, new x(d2, idManager.i(), idManager.j(), idManager.k(), idManager.b(), idManager.f(), idManager.d(), CommonUtils.a(CommonUtils.n(context)), str2, str, DeliveryMechanism.determineFrom(h2).getId(), CommonUtils.c(context)), new io.fabric.sdk.android.services.common.y(), new l(), new j(lVar), new m(lVar, str3, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", e2), fVar));
        }
        this.f27053d = true;
        return this;
    }

    public synchronized boolean c() {
        u a2;
        a2 = this.f27052c.a();
        a(a2);
        return a2 != null;
    }

    public synchronized boolean d() {
        u a2;
        a2 = this.f27052c.a(SettingsCacheBehavior.SKIP_CACHE_LOOKUP);
        a(a2);
        if (a2 == null) {
            io.fabric.sdk.android.f.f().c("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return a2 != null;
    }

    private s() {
        this.f27050a = new AtomicReference<>();
        this.f27051b = new CountDownLatch(1);
        this.f27053d = false;
    }

    public u a() {
        try {
            this.f27051b.await();
            return this.f27050a.get();
        } catch (InterruptedException unused) {
            io.fabric.sdk.android.f.f().e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    private void a(u uVar) {
        this.f27050a.set(uVar);
        this.f27051b.countDown();
    }
}
