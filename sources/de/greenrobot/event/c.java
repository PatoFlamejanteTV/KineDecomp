package de.greenrobot.event;

import de.greenrobot.event.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventBus.java */
/* loaded from: classes3.dex */
public class c extends ThreadLocal<e.a> {

    /* renamed from: a */
    final /* synthetic */ e f26673a;

    public c(e eVar) {
        this.f26673a = eVar;
    }

    @Override // java.lang.ThreadLocal
    public e.a initialValue() {
        return new e.a();
    }
}
