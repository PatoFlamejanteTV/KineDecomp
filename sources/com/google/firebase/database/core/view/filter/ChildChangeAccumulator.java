package com.google.firebase.database.core.view.filter;

import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class ChildChangeAccumulator {

    /* renamed from: a */
    private final Map<ChildKey, Change> f17148a = new HashMap();

    public void a(Change change) {
        Event.EventType b2 = change.b();
        ChildKey a2 = change.a();
        if (this.f17148a.containsKey(a2)) {
            Change change2 = this.f17148a.get(a2);
            Event.EventType b3 = change2.b();
            if (b2 == Event.EventType.CHILD_ADDED && b3 == Event.EventType.CHILD_REMOVED) {
                this.f17148a.put(change.a(), Change.a(a2, change.c(), change2.c()));
                return;
            }
            if (b2 == Event.EventType.CHILD_REMOVED && b3 == Event.EventType.CHILD_ADDED) {
                this.f17148a.remove(a2);
                return;
            }
            if (b2 == Event.EventType.CHILD_REMOVED && b3 == Event.EventType.CHILD_CHANGED) {
                this.f17148a.put(a2, Change.c(a2, change2.d()));
                return;
            }
            if (b2 == Event.EventType.CHILD_CHANGED && b3 == Event.EventType.CHILD_ADDED) {
                this.f17148a.put(a2, Change.a(a2, change.c()));
                return;
            }
            Event.EventType eventType = Event.EventType.CHILD_CHANGED;
            if (b2 == eventType && b3 == eventType) {
                this.f17148a.put(a2, Change.a(a2, change.c(), change2.d()));
                return;
            }
            throw new IllegalStateException("Illegal combination of changes: " + change + " occurred after " + change2);
        }
        this.f17148a.put(change.a(), change);
    }

    public List<Change> a() {
        return new ArrayList(this.f17148a.values());
    }
}
