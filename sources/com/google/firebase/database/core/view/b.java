package com.google.firebase.database.core.view;

import com.google.firebase.database.logging.LogWrapper;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ArrayList f17144a;

    /* renamed from: b */
    final /* synthetic */ EventRaiser f17145b;

    public b(EventRaiser eventRaiser, ArrayList arrayList) {
        this.f17145b = eventRaiser;
        this.f17144a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        LogWrapper logWrapper;
        LogWrapper logWrapper2;
        Iterator it = this.f17144a.iterator();
        while (it.hasNext()) {
            Event event = (Event) it.next();
            logWrapper = this.f17145b.f17116b;
            if (logWrapper.a()) {
                logWrapper2 = this.f17145b.f17116b;
                logWrapper2.a("Raising " + event.toString(), new Object[0]);
            }
            event.a();
        }
    }
}
