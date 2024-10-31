package com.google.android.gms.internal.firebase_dynamic_links;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.appinvite.AppInviteReferral;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class h extends a {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ g f13116a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f13116a = gVar;
    }

    @Override // com.google.android.gms.internal.firebase_dynamic_links.a, com.google.android.gms.internal.firebase_dynamic_links.zzp
    public final void zza(Status status, Intent intent) {
        boolean z;
        WeakReference weakReference;
        WeakReference weakReference2;
        this.f13116a.a((g) new zzo(status, intent));
        if (AppInviteReferral.a(intent)) {
            z = this.f13116a.t;
            if (z) {
                weakReference = this.f13116a.s;
                if (weakReference != null) {
                    weakReference2 = this.f13116a.s;
                    Activity activity = (Activity) weakReference2.get();
                    if (activity != null) {
                        activity.startActivity(intent);
                    }
                }
            }
        }
    }
}
