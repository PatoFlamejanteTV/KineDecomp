package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public class zabu extends zal {

    /* renamed from: f, reason: collision with root package name */
    private TaskCompletionSource<Void> f10901f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zal
    public final void a(ConnectionResult connectionResult, int i) {
        this.f10901f.a(ApiExceptionUtil.a(new Status(connectionResult.a(), connectionResult.O(), connectionResult.P())));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void b() {
        super.b();
        this.f10901f.b(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }

    @Override // com.google.android.gms.common.api.internal.zal
    protected final void f() {
        int c2 = this.f10952e.c(this.f10774a.d());
        if (c2 == 0) {
            this.f10901f.a((TaskCompletionSource<Void>) null);
        } else {
            if (this.f10901f.a().d()) {
                return;
            }
            b(new ConnectionResult(c2, null), 0);
        }
    }
}
