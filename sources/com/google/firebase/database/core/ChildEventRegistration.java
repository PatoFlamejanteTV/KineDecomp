package com.google.firebase.database.core;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class ChildEventRegistration extends EventRegistration {

    /* renamed from: d, reason: collision with root package name */
    private final Repo f16831d;

    /* renamed from: e, reason: collision with root package name */
    private final ChildEventListener f16832e;

    /* renamed from: f, reason: collision with root package name */
    private final QuerySpec f16833f;

    public ChildEventRegistration(@NotNull Repo repo, @NotNull ChildEventListener childEventListener, @NotNull QuerySpec querySpec) {
        this.f16831d = repo;
        this.f16832e = childEventListener;
        this.f16833f = querySpec;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public boolean a(Event.EventType eventType) {
        return eventType != Event.EventType.VALUE;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ChildEventRegistration) {
            ChildEventRegistration childEventRegistration = (ChildEventRegistration) obj;
            if (childEventRegistration.f16832e.equals(this.f16832e) && childEventRegistration.f16831d.equals(this.f16831d) && childEventRegistration.f16833f.equals(this.f16833f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f16832e.hashCode() * 31) + this.f16831d.hashCode()) * 31) + this.f16833f.hashCode();
    }

    public String toString() {
        return "ChildEventRegistration";
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public DataEvent a(Change change, QuerySpec querySpec) {
        return new DataEvent(change.b(), this, InternalHelpers.a(InternalHelpers.a(this.f16831d, querySpec.c().d(change.a())), change.c()), change.e() != null ? change.e().a() : null);
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public void a(DataEvent dataEvent) {
        if (b()) {
            return;
        }
        int i = C1585a.f16965a[dataEvent.b().ordinal()];
        if (i == 1) {
            this.f16832e.b(dataEvent.e(), dataEvent.d());
            return;
        }
        if (i == 2) {
            this.f16832e.a(dataEvent.e(), dataEvent.d());
        } else if (i == 3) {
            this.f16832e.c(dataEvent.e(), dataEvent.d());
        } else {
            if (i != 4) {
                return;
            }
            this.f16832e.a(dataEvent.e());
        }
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public void a(DatabaseError databaseError) {
        this.f16832e.a(databaseError);
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public EventRegistration a(QuerySpec querySpec) {
        return new ChildEventRegistration(this.f16831d, this.f16832e, querySpec);
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public boolean a(EventRegistration eventRegistration) {
        return (eventRegistration instanceof ChildEventRegistration) && ((ChildEventRegistration) eventRegistration).f16832e.equals(this.f16832e);
    }

    @Override // com.google.firebase.database.core.EventRegistration
    @NotNull
    public QuerySpec a() {
        return this.f16833f;
    }
}
