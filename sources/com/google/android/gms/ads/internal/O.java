package com.google.android.gms.ads.internal;

import android.view.View;
import com.google.android.gms.internal.ads.zzawr;

/* loaded from: classes.dex */
final class O implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzw f10007a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ L f10008b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(L l, zzw zzwVar) {
        this.f10008b = l;
        this.f10007a = zzwVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f10007a.a();
        zzawr zzawrVar = this.f10008b.f10001b;
        if (zzawrVar != null) {
            zzawrVar.zzxr();
        }
    }
}
