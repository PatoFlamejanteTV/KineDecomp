package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
@zzark
/* loaded from: classes2.dex */
public final class I {

    /* renamed from: a */
    private final List<InterfaceC0951ja> f11588a = new ArrayList();

    public final void a(C0965ka c0965ka) {
        Handler handler = zzayh.zzelc;
        Iterator<InterfaceC0951ja> it = this.f11588a.iterator();
        while (it.hasNext()) {
            handler.post(new RunnableC0938ia(this, it.next(), c0965ka));
        }
        this.f11588a.clear();
    }
}
