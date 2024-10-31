package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final long f17383a;

    /* renamed from: b, reason: collision with root package name */
    private final PowerManager.WakeLock f17384b = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");

    /* renamed from: c, reason: collision with root package name */
    private final FirebaseInstanceId f17385c;

    /* renamed from: d, reason: collision with root package name */
    private final zzan f17386d;

    /* renamed from: e, reason: collision with root package name */
    private final v f17387e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public t(FirebaseInstanceId firebaseInstanceId, zzan zzanVar, v vVar, long j) {
        this.f17385c = firebaseInstanceId;
        this.f17386d = zzanVar;
        this.f17387e = vVar;
        this.f17383a = j;
        this.f17384b.setReferenceCounted(false);
    }

    @VisibleForTesting
    private final boolean d() {
        try {
            if (this.f17385c.k()) {
                return true;
            }
            this.f17385c.l();
            return true;
        } catch (IOException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.e("FirebaseInstanceId", valueOf.length() != 0 ? "Build channel failed: ".concat(valueOf) : new String("Build channel failed: "));
            return false;
        }
    }

    @VisibleForTesting
    private final boolean e() {
        s f2 = this.f17385c.f();
        if (f2 != null && !f2.b(this.f17386d.b())) {
            return true;
        }
        try {
            String g2 = this.f17385c.g();
            if (g2 == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if (f2 == null || (f2 != null && !g2.equals(f2.f17380b))) {
                Context b2 = b();
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", g2);
                zzav.b(b2, intent);
                zzav.a(b2, new Intent("com.google.firebase.iid.TOKEN_REFRESH"));
            }
            return true;
        } catch (IOException | SecurityException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.e("FirebaseInstanceId", valueOf.length() != 0 ? "Token retrieval failed: ".concat(valueOf) : new String("Token retrieval failed: "));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context b() {
        return this.f17385c.e().b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c() {
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17384b.acquire();
        try {
            this.f17385c.a(true);
            if (!this.f17385c.j()) {
                this.f17385c.a(false);
                return;
            }
            if (!c()) {
                new u(this).a();
                return;
            }
            if (d() && e() && this.f17387e.a(this.f17385c)) {
                this.f17385c.a(false);
            } else {
                this.f17385c.a(this.f17383a);
            }
        } finally {
            this.f17384b.release();
        }
    }
}
