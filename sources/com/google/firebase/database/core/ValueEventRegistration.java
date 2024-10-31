package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class ValueEventRegistration extends EventRegistration {

    /* renamed from: d, reason: collision with root package name */
    private final Repo f16954d;

    /* renamed from: e, reason: collision with root package name */
    private final ValueEventListener f16955e;

    /* renamed from: f, reason: collision with root package name */
    private final QuerySpec f16956f;

    public ValueEventRegistration(Repo repo, ValueEventListener valueEventListener, @NotNull QuerySpec querySpec) {
        this.f16954d = repo;
        this.f16955e = valueEventListener;
        this.f16956f = querySpec;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public boolean a(Event.EventType eventType) {
        return eventType == Event.EventType.VALUE;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ValueEventRegistration) {
            ValueEventRegistration valueEventRegistration = (ValueEventRegistration) obj;
            if (valueEventRegistration.f16955e.equals(this.f16955e) && valueEventRegistration.f16954d.equals(this.f16954d) && valueEventRegistration.f16956f.equals(this.f16956f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f16955e.hashCode() * 31) + this.f16954d.hashCode()) * 31) + this.f16956f.hashCode();
    }

    public String toString() {
        return "ValueEventRegistration";
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public DataEvent a(Change change, QuerySpec querySpec) {
        return new DataEvent(Event.EventType.VALUE, this, InternalHelpers.a(InternalHelpers.a(this.f16954d, querySpec.c()), change.c()), null);
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public void a(DataEvent dataEvent) {
        if (b()) {
            return;
        }
        this.f16955e.a(dataEvent.e());
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public void a(DatabaseError databaseError) {
        this.f16955e.a(databaseError);
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public EventRegistration a(QuerySpec querySpec) {
        return new ValueEventRegistration(this.f16954d, this.f16955e, querySpec);
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public boolean a(EventRegistration eventRegistration) {
        return (eventRegistration instanceof ValueEventRegistration) && ((ValueEventRegistration) eventRegistration).f16955e.equals(this.f16955e);
    }

    @Override // com.google.firebase.database.core.EventRegistration
    @NotNull
    public QuerySpec a() {
        return this.f16956f;
    }
}
