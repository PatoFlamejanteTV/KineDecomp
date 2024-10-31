package com.google.android.gms.common.internal;

import android.content.Intent;
import android.support.v4.app.Fragment;

/* loaded from: classes.dex */
final class b extends DialogRedirect {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Intent f11141a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Fragment f11142b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ int f11143c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Intent intent, Fragment fragment, int i) {
        this.f11141a = intent;
        this.f11142b = fragment;
        this.f11143c = i;
    }

    @Override // com.google.android.gms.common.internal.DialogRedirect
    public final void a() {
        Intent intent = this.f11141a;
        if (intent != null) {
            this.f11142b.startActivityForResult(intent, this.f11143c);
        }
    }
}
