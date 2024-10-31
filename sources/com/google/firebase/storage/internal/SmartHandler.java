package com.google.firebase.storage.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.storage.StorageTaskScheduler;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public class SmartHandler {

    /* renamed from: a */
    static boolean f18169a = false;

    /* renamed from: b */
    private final Handler f18170b;

    /* renamed from: c */
    private final Executor f18171c;

    public SmartHandler(Executor executor) {
        this.f18171c = executor;
        if (this.f18171c == null) {
            if (!f18169a) {
                this.f18170b = new Handler(Looper.getMainLooper());
                return;
            } else {
                this.f18170b = null;
                return;
            }
        }
        this.f18170b = null;
    }

    public void a(Runnable runnable) {
        Preconditions.a(runnable);
        Handler handler = this.f18170b;
        if (handler == null) {
            Executor executor = this.f18171c;
            if (executor != null) {
                executor.execute(runnable);
                return;
            } else {
                StorageTaskScheduler.a().a(runnable);
                return;
            }
        }
        handler.post(runnable);
    }
}
