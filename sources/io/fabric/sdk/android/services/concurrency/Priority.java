package io.fabric.sdk.android.services.concurrency;

/* loaded from: classes3.dex */
public enum Priority {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    public static <Y> int compareTo(m mVar, Y y) {
        Priority priority;
        if (y instanceof m) {
            priority = ((m) y).getPriority();
        } else {
            priority = NORMAL;
        }
        return priority.ordinal() - mVar.getPriority().ordinal();
    }
}
