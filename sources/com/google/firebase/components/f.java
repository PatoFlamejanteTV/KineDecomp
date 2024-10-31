package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
/* loaded from: classes2.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a */
    private final Map.Entry f16585a;

    /* renamed from: b */
    private final Event f16586b;

    private f(Map.Entry entry, Event event) {
        this.f16585a = entry;
        this.f16586b = event;
    }

    public static Runnable a(Map.Entry entry, Event event) {
        return new f(entry, event);
    }

    @Override // java.lang.Runnable
    public void run() {
        ((EventHandler) this.f16585a.getKey()).a(this.f16586b);
    }
}
