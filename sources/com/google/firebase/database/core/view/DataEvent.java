package com.google.firebase.database.core.view;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.view.Event;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class DataEvent implements Event {

    /* renamed from: a, reason: collision with root package name */
    private final Event.EventType f17109a;

    /* renamed from: b, reason: collision with root package name */
    private final EventRegistration f17110b;

    /* renamed from: c, reason: collision with root package name */
    private final DataSnapshot f17111c;

    /* renamed from: d, reason: collision with root package name */
    private final String f17112d;

    public DataEvent(Event.EventType eventType, EventRegistration eventRegistration, DataSnapshot dataSnapshot, String str) {
        this.f17109a = eventType;
        this.f17110b = eventRegistration;
        this.f17111c = dataSnapshot;
        this.f17112d = str;
    }

    @Override // com.google.firebase.database.core.view.Event
    public void a() {
        this.f17110b.a(this);
    }

    public Event.EventType b() {
        return this.f17109a;
    }

    public Path c() {
        Path a2 = this.f17111c.c().a();
        return this.f17109a == Event.EventType.VALUE ? a2 : a2.getParent();
    }

    public String d() {
        return this.f17112d;
    }

    public DataSnapshot e() {
        return this.f17111c;
    }

    @Override // com.google.firebase.database.core.view.Event
    public String toString() {
        if (this.f17109a == Event.EventType.VALUE) {
            return c() + ": " + this.f17109a + ": " + this.f17111c.a(true);
        }
        return c() + ": " + this.f17109a + ": { " + this.f17111c.b() + ": " + this.f17111c.a(true) + " }";
    }
}
