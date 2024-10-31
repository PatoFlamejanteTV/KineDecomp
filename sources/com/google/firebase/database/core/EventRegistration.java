package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public abstract class EventRegistration {

    /* renamed from: b */
    private EventRegistrationZombieListener f16855b;

    /* renamed from: a */
    private AtomicBoolean f16854a = new AtomicBoolean(false);

    /* renamed from: c */
    private boolean f16856c = false;

    public abstract EventRegistration a(QuerySpec querySpec);

    public abstract DataEvent a(Change change, QuerySpec querySpec);

    @NotNull
    public abstract QuerySpec a();

    public abstract void a(DatabaseError databaseError);

    public void a(EventRegistrationZombieListener eventRegistrationZombieListener) {
        this.f16855b = eventRegistrationZombieListener;
    }

    public abstract void a(DataEvent dataEvent);

    public abstract boolean a(EventRegistration eventRegistration);

    public abstract boolean a(Event.EventType eventType);

    public boolean b() {
        return this.f16854a.get();
    }

    public void c() {
        EventRegistrationZombieListener eventRegistrationZombieListener;
        if (!this.f16854a.compareAndSet(false, true) || (eventRegistrationZombieListener = this.f16855b) == null) {
            return;
        }
        eventRegistrationZombieListener.a(this);
        this.f16855b = null;
    }

    public void a(boolean z) {
        this.f16856c = z;
    }
}
