package com.nexstreaming.app.general.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ListenerRegistry.java */
/* loaded from: classes2.dex */
public class u<LISTENER> {

    /* renamed from: a */
    private List<WeakReference<LISTENER>> f19885a = new ArrayList();

    /* compiled from: ListenerRegistry.java */
    /* loaded from: classes2.dex */
    public interface a<LISTENER> {
        void a(LISTENER listener);
    }

    public void a(LISTENER listener) {
        b(null);
        this.f19885a.add(new WeakReference<>(listener));
    }

    public void b(LISTENER listener) {
        ArrayList arrayList = new ArrayList();
        for (WeakReference<LISTENER> weakReference : this.f19885a) {
            LISTENER listener2 = weakReference.get();
            if (listener2 == null || listener2 == listener) {
                arrayList.add(weakReference);
            }
        }
        this.f19885a.removeAll(arrayList);
    }

    public void a(a<LISTENER> aVar) {
        Iterator<WeakReference<LISTENER>> it = this.f19885a.iterator();
        while (it.hasNext()) {
            LISTENER listener = it.next().get();
            if (listener != null) {
                aVar.a(listener);
            }
        }
    }
}
