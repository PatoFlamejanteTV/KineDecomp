package com.google.firebase.database.core.view;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public interface Event {

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public enum EventType {
        CHILD_REMOVED,
        CHILD_ADDED,
        CHILD_MOVED,
        CHILD_CHANGED,
        VALUE
    }

    void a();

    String toString();
}
