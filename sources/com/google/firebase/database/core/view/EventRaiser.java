package com.google.firebase.database.core.view;

import com.google.firebase.database.core.Context;
import com.google.firebase.database.core.EventTarget;
import com.google.firebase.database.logging.LogWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class EventRaiser {

    /* renamed from: a */
    private final EventTarget f17115a;

    /* renamed from: b */
    private final LogWrapper f17116b;

    public EventRaiser(Context context) {
        this.f17115a = context.e();
        this.f17116b = context.a("EventRaiser");
    }

    public void a(List<? extends Event> list) {
        if (this.f17116b.a()) {
            this.f17116b.a("Raising " + list.size() + " event(s)", new Object[0]);
        }
        this.f17115a.a(new b(this, new ArrayList(list)));
    }
}
