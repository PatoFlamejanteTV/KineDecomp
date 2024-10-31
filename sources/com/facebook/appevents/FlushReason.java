package com.facebook.appevents;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public enum FlushReason {
    EXPLICIT,
    TIMER,
    SESSION_CHANGE,
    PERSISTED_EVENTS,
    EVENT_THRESHOLD,
    EAGER_FLUSHING_EVENT
}
