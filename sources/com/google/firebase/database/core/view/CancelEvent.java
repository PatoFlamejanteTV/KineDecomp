package com.google.firebase.database.core.view;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class CancelEvent implements Event {

    /* renamed from: a */
    private final Path f17101a;

    /* renamed from: b */
    private final EventRegistration f17102b;

    /* renamed from: c */
    private final DatabaseError f17103c;

    public CancelEvent(EventRegistration eventRegistration, DatabaseError databaseError, Path path) {
        this.f17102b = eventRegistration;
        this.f17101a = path;
        this.f17103c = databaseError;
    }

    @Override // com.google.firebase.database.core.view.Event
    public void a() {
        this.f17102b.a(this.f17103c);
    }

    public Path b() {
        return this.f17101a;
    }

    @Override // com.google.firebase.database.core.view.Event
    public String toString() {
        return b() + ":CANCEL";
    }
}
