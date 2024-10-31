package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends DialogRedirect {

    /* renamed from: a */
    private final /* synthetic */ Intent f11138a;

    /* renamed from: b */
    private final /* synthetic */ Activity f11139b;

    /* renamed from: c */
    private final /* synthetic */ int f11140c;

    public a(Intent intent, Activity activity, int i) {
        this.f11138a = intent;
        this.f11139b = activity;
        this.f11140c = i;
    }

    @Override // com.google.android.gms.common.internal.DialogRedirect
    public final void a() {
        Intent intent = this.f11138a;
        if (intent != null) {
            this.f11139b.startActivityForResult(intent, this.f11140c);
        }
    }
}
