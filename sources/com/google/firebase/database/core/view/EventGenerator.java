package com.google.firebase.database.core.view;

import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class EventGenerator {

    /* renamed from: a, reason: collision with root package name */
    private final QuerySpec f17113a;

    /* renamed from: b, reason: collision with root package name */
    private final Index f17114b;

    public EventGenerator(QuerySpec querySpec) {
        this.f17113a = querySpec;
        this.f17114b = querySpec.a();
    }

    private void a(List<DataEvent> list, Event.EventType eventType, List<Change> list2, List<EventRegistration> list3, IndexedNode indexedNode) {
        ArrayList<Change> arrayList = new ArrayList();
        for (Change change : list2) {
            if (change.b().equals(eventType)) {
                arrayList.add(change);
            }
        }
        Collections.sort(arrayList, a());
        for (Change change2 : arrayList) {
            for (EventRegistration eventRegistration : list3) {
                if (eventRegistration.a(eventType)) {
                    list.add(a(change2, eventRegistration, indexedNode));
                }
            }
        }
    }

    private DataEvent a(Change change, EventRegistration eventRegistration, IndexedNode indexedNode) {
        if (!change.b().equals(Event.EventType.VALUE) && !change.b().equals(Event.EventType.CHILD_REMOVED)) {
            change = change.a(indexedNode.a(change.a(), change.c().e(), this.f17114b));
        }
        return eventRegistration.a(change, this.f17113a);
    }

    public List<DataEvent> a(List<Change> list, IndexedNode indexedNode, List<EventRegistration> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Change change : list) {
            if (change.b().equals(Event.EventType.CHILD_CHANGED) && this.f17114b.a(change.d().e(), change.c().e())) {
                arrayList2.add(Change.b(change.a(), change.c()));
            }
        }
        a(arrayList, Event.EventType.CHILD_REMOVED, list, list2, indexedNode);
        a(arrayList, Event.EventType.CHILD_ADDED, list, list2, indexedNode);
        a(arrayList, Event.EventType.CHILD_MOVED, arrayList2, list2, indexedNode);
        a(arrayList, Event.EventType.CHILD_CHANGED, list, list2, indexedNode);
        a(arrayList, Event.EventType.VALUE, list, list2, indexedNode);
        return arrayList;
    }

    private Comparator<Change> a() {
        return new a(this);
    }
}
