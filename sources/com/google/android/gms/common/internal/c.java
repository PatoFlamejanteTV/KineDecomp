package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends DialogRedirect {

    /* renamed from: a */
    private final /* synthetic */ Intent f11144a;

    /* renamed from: b */
    private final /* synthetic */ LifecycleFragment f11145b;

    /* renamed from: c */
    private final /* synthetic */ int f11146c;

    public c(Intent intent, LifecycleFragment lifecycleFragment, int i) {
        this.f11144a = intent;
        this.f11145b = lifecycleFragment;
        this.f11146c = i;
    }

    @Override // com.google.android.gms.common.internal.DialogRedirect
    public final void a() {
        Intent intent = this.f11144a;
        if (intent != null) {
            this.f11145b.startActivityForResult(intent, this.f11146c);
        }
    }
}
