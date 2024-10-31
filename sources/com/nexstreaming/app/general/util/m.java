package com.nexstreaming.app.general.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ListenerRegistry.java */
/* loaded from: classes.dex */
public class m<LISTENER> {

    /* renamed from: a, reason: collision with root package name */
    private List<WeakReference<LISTENER>> f3231a = new ArrayList();

    /* compiled from: ListenerRegistry.java */
    /* loaded from: classes.dex */
    public interface a<LISTENER> {
        void a(LISTENER listener);
    }

    public void a(LISTENER listener) {
        b(null);
        this.f3231a.add(new WeakReference<>(listener));
    }

    public void b(LISTENER listener) {
        ArrayList arrayList = new ArrayList();
        for (WeakReference<LISTENER> weakReference : this.f3231a) {
            LISTENER listener2 = weakReference.get();
            if (listener2 == null || listener2 == listener) {
                arrayList.add(weakReference);
            }
        }
        this.f3231a.removeAll(arrayList);
    }

    public void a(a<LISTENER> aVar) {
        Iterator<WeakReference<LISTENER>> it = this.f3231a.iterator();
        while (it.hasNext()) {
            LISTENER listener = it.next().get();
            if (listener != null) {
                aVar.a(listener);
            }
        }
    }
}
