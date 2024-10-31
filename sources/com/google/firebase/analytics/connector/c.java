package com.google.firebase.analytics.connector;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;

/* loaded from: classes2.dex */
public final /* synthetic */ class c implements EventHandler {

    /* renamed from: a */
    static final EventHandler f16349a = new c();

    private c() {
    }

    @Override // com.google.firebase.events.EventHandler
    public final void a(Event event) {
        AnalyticsConnectorImpl.a(event);
    }
}
