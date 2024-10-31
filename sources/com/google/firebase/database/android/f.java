package com.google.firebase.database.android;

import android.content.Context;
import android.os.Handler;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.logging.LogWrapper;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class f extends DefaultRunLoop {

    /* renamed from: b */
    final /* synthetic */ LogWrapper f16675b;

    /* renamed from: c */
    final /* synthetic */ AndroidPlatform f16676c;

    public f(AndroidPlatform androidPlatform, LogWrapper logWrapper) {
        this.f16676c = androidPlatform;
        this.f16675b = logWrapper;
    }

    @Override // com.google.firebase.database.core.utilities.DefaultRunLoop
    public void a(Throwable th) {
        Context context;
        String b2 = DefaultRunLoop.b(th);
        this.f16675b.a(b2, th);
        context = this.f16676c.f16656a;
        new Handler(context.getMainLooper()).post(new e(this, b2, th));
        b().shutdownNow();
    }
}
