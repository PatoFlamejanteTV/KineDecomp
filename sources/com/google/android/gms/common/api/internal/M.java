package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class M implements IBinder.DeathRecipient, N {

    /* renamed from: a */
    private final WeakReference<BasePendingResult<?>> f10782a;

    /* renamed from: b */
    private final WeakReference<com.google.android.gms.common.api.zac> f10783b;

    /* renamed from: c */
    private final WeakReference<IBinder> f10784c;

    private M(BasePendingResult<?> basePendingResult, com.google.android.gms.common.api.zac zacVar, IBinder iBinder) {
        this.f10783b = new WeakReference<>(zacVar);
        this.f10782a = new WeakReference<>(basePendingResult);
        this.f10784c = new WeakReference<>(iBinder);
    }

    @Override // com.google.android.gms.common.api.internal.N
    public final void a(BasePendingResult<?> basePendingResult) {
        a();
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        a();
    }

    private final void a() {
        BasePendingResult<?> basePendingResult = this.f10782a.get();
        com.google.android.gms.common.api.zac zacVar = this.f10783b.get();
        if (zacVar != null && basePendingResult != null) {
            zacVar.a(basePendingResult.d().intValue());
        }
        IBinder iBinder = this.f10784c.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
            } catch (NoSuchElementException unused) {
            }
        }
    }

    public /* synthetic */ M(BasePendingResult basePendingResult, com.google.android.gms.common.api.zac zacVar, IBinder iBinder, L l) {
        this(basePendingResult, null, iBinder);
    }
}
