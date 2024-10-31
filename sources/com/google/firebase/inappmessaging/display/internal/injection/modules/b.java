package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.squareup.okhttp.E;
import com.squareup.okhttp.H;
import com.squareup.okhttp.z;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
class b implements z {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PicassoModule f17677a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PicassoModule picassoModule) {
        this.f17677a = picassoModule;
    }

    @Override // com.squareup.okhttp.z
    public H a(z.a aVar) throws IOException {
        E.a g2 = aVar.a().g();
        g2.a(io.fabric.sdk.android.services.common.a.HEADER_ACCEPT, "image/*");
        return aVar.a(g2.a());
    }
}
