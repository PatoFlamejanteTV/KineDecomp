package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.firebase.FirebaseExceptionMapper;
import java.util.Collections;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class N implements Callable<C1561a<zzef>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzef f16430a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f16431b;

    public N(zzef zzefVar, Context context) {
        this.f16430a = zzefVar;
        this.f16431b = context;
    }

    private final GoogleApi<zzef> a(boolean z, Context context) {
        zzef zzefVar = (zzef) this.f16430a.clone();
        zzefVar.f16468a = z;
        return new zzal(context, zzed.f16479c, zzefVar, new FirebaseExceptionMapper());
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ C1561a<zzef> call() throws Exception {
        int a2 = DynamiteModule.a(this.f16431b, "com.google.firebase.auth");
        int i = 1;
        GoogleApi<zzef> a3 = a2 != 0 ? a(true, this.f16431b) : null;
        if (a2 != 0) {
            int a4 = GoogleApiAvailability.a().a(this.f16431b, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            i = (a4 == 0 || a4 == 2) ? DynamiteModule.b(this.f16431b, "com.google.android.gms.firebase_auth") : 0;
        }
        return new C1561a<>(i != 0 ? a(false, this.f16431b) : null, a3, new C1562b(i, a2, Collections.emptyMap()));
    }
}
