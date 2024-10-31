package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zze extends AsyncTaskLoader<Void> implements SignInConnectionListener {
    private Semaphore p;
    private Set<GoogleApiClient> q;

    public zze(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.p = new Semaphore(0);
        this.q = set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.support.v4.content.AsyncTaskLoader
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final Void loadInBackground() {
        Iterator<GoogleApiClient> it = this.q.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().a(this)) {
                i++;
            }
        }
        try {
            this.p.tryAcquire(i, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e2) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e2);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // android.support.v4.content.Loader
    protected final void e() {
        this.p.drainPermits();
        forceLoad();
    }

    @Override // com.google.android.gms.common.api.internal.SignInConnectionListener
    public final void onComplete() {
        this.p.release();
    }
}
