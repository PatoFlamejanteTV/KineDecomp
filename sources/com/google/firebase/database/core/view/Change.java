package com.google.firebase.database.core.view;

import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class Change {

    /* renamed from: a */
    private final Event.EventType f17104a;

    /* renamed from: b */
    private final IndexedNode f17105b;

    /* renamed from: c */
    private final IndexedNode f17106c;

    /* renamed from: d */
    private final ChildKey f17107d;

    /* renamed from: e */
    private final ChildKey f17108e;

    private Change(Event.EventType eventType, IndexedNode indexedNode, ChildKey childKey, ChildKey childKey2, IndexedNode indexedNode2) {
        this.f17104a = eventType;
        this.f17105b = indexedNode;
        this.f17107d = childKey;
        this.f17108e = childKey2;
        this.f17106c = indexedNode2;
    }

    public static Change a(IndexedNode indexedNode) {
        return new Change(Event.EventType.VALUE, indexedNode, null, null, null);
    }

    public static Change b(ChildKey childKey, Node node) {
        return c(childKey, IndexedNode.b(node));
    }

    public static Change c(ChildKey childKey, IndexedNode indexedNode) {
        return new Change(Event.EventType.CHILD_REMOVED, indexedNode, childKey, null, null);
    }

    public IndexedNode d() {
        return this.f17106c;
    }

    public ChildKey e() {
        return this.f17108e;
    }

    public String toString() {
        return "Change: " + this.f17104a + " " + this.f17107d;
    }

    public static Change a(ChildKey childKey, Node node) {
        return a(childKey, IndexedNode.b(node));
    }

    public static Change b(ChildKey childKey, IndexedNode indexedNode) {
        return new Change(Event.EventType.CHILD_MOVED, indexedNode, childKey, null, null);
    }

    public IndexedNode c() {
        return this.f17105b;
    }

    public static Change a(ChildKey childKey, IndexedNode indexedNode) {
        return new Change(Event.EventType.CHILD_ADDED, indexedNode, childKey, null, null);
    }

    public Event.EventType b() {
        return this.f17104a;
    }

    public static Change a(ChildKey childKey, Node node, Node node2) {
        return a(childKey, IndexedNode.b(node), IndexedNode.b(node2));
    }

    public static Change a(ChildKey childKey, IndexedNode indexedNode, IndexedNode indexedNode2) {
        return new Change(Event.EventType.CHILD_CHANGED, indexedNode, childKey, null, indexedNode2);
    }

    public Change a(ChildKey childKey) {
        return new Change(this.f17104a, this.f17105b, this.f17107d, childKey, this.f17106c);
    }

    public ChildKey a() {
        return this.f17107d;
    }
}
