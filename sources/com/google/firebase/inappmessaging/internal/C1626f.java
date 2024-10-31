package com.google.firebase.inappmessaging.internal;

import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.f */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1626f implements EventHandler {

    /* renamed from: a */
    private final DataCollectionHelper f17858a;

    private C1626f(DataCollectionHelper dataCollectionHelper) {
        this.f17858a = dataCollectionHelper;
    }

    public static EventHandler a(DataCollectionHelper dataCollectionHelper) {
        return new C1626f(dataCollectionHelper);
    }

    @Override // com.google.firebase.events.EventHandler
    public void a(Event event) {
        this.f17858a.f17728b.set(((DataCollectionDefaultChange) event.a()).f16320a);
    }
}
