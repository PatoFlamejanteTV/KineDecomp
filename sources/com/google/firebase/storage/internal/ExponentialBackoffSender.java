package com.google.firebase.storage.internal;

import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.network.NetworkRequest;
import java.util.Random;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public class ExponentialBackoffSender {

    /* renamed from: a, reason: collision with root package name */
    static Sleeper f18163a = new SleeperImpl();

    /* renamed from: b, reason: collision with root package name */
    static Clock f18164b = DefaultClock.d();

    /* renamed from: c, reason: collision with root package name */
    private static Random f18165c = new Random();

    /* renamed from: d, reason: collision with root package name */
    private FirebaseApp f18166d;

    /* renamed from: e, reason: collision with root package name */
    private long f18167e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f18168f;

    public ExponentialBackoffSender(FirebaseApp firebaseApp, long j) {
        this.f18166d = firebaseApp;
        this.f18167e = j;
    }

    public void a(NetworkRequest networkRequest) {
        a(networkRequest, true);
    }

    public boolean a(int i) {
        return (i >= 500 && i < 600) || i == -2 || i == 429 || i == 408;
    }

    public void b() {
        this.f18168f = false;
    }

    public void a(NetworkRequest networkRequest, boolean z) {
        Preconditions.a(networkRequest);
        long c2 = f18164b.c() + this.f18167e;
        if (z) {
            networkRequest.a(Util.a(this.f18166d), this.f18166d.b());
        } else {
            networkRequest.b(Util.a(this.f18166d));
        }
        int i = 1000;
        while (f18164b.c() + i <= c2 && !networkRequest.p() && a(networkRequest.k())) {
            try {
                f18163a.a(f18165c.nextInt(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + i);
                if (i < 30000) {
                    if (networkRequest.k() != -2) {
                        i *= 2;
                        Log.w("ExponenentialBackoff", "network error occurred, backing off/sleeping.");
                    } else {
                        Log.w("ExponenentialBackoff", "network unavailable, sleeping.");
                        i = 1000;
                    }
                }
                if (this.f18168f) {
                    return;
                }
                networkRequest.r();
                if (z) {
                    networkRequest.a(Util.a(this.f18166d), this.f18166d.b());
                } else {
                    networkRequest.b(Util.a(this.f18166d));
                }
            } catch (InterruptedException unused) {
                Log.w("ExponenentialBackoff", "thread interrupted during exponential backoff.");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public void a() {
        this.f18168f = true;
    }
}
