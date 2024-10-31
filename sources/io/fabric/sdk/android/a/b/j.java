package io.fabric.sdk.android.a.b;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;

/* compiled from: TimeBasedFileRollOverRunnable.java */
/* loaded from: classes3.dex */
public class j implements Runnable {

    /* renamed from: a */
    private final Context f26825a;

    /* renamed from: b */
    private final f f26826b;

    public j(Context context, f fVar) {
        this.f26825a = context;
        this.f26826b = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            CommonUtils.c(this.f26825a, "Performing time based file roll over.");
            if (this.f26826b.rollFileOver()) {
                return;
            }
            this.f26826b.cancelTimeBasedFileRollOver();
        } catch (Exception e2) {
            CommonUtils.a(this.f26825a, "Failed to roll over file", e2);
        }
    }
}
