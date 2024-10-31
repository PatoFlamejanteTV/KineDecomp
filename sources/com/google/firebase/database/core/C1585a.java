package com.google.firebase.database.core;

import com.google.firebase.database.core.view.Event;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.a */
/* loaded from: classes2.dex */
/* synthetic */ class C1585a {

    /* renamed from: a */
    static final /* synthetic */ int[] f16965a = new int[Event.EventType.values().length];

    static {
        try {
            f16965a[Event.EventType.CHILD_ADDED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f16965a[Event.EventType.CHILD_CHANGED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f16965a[Event.EventType.CHILD_MOVED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f16965a[Event.EventType.CHILD_REMOVED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
