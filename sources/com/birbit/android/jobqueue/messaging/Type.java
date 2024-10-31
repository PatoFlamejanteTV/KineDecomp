package com.birbit.android.jobqueue.messaging;

import com.birbit.android.jobqueue.messaging.a.j;
import com.birbit.android.jobqueue.messaging.a.k;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum Type {
    CALLBACK(com.birbit.android.jobqueue.messaging.a.b.class, 0),
    CANCEL_RESULT_CALLBACK(com.birbit.android.jobqueue.messaging.a.d.class, 0),
    RUN_JOB(com.birbit.android.jobqueue.messaging.a.i.class, 0),
    COMMAND(com.birbit.android.jobqueue.messaging.a.e.class, 0),
    PUBLIC_QUERY(com.birbit.android.jobqueue.messaging.a.h.class, 0),
    JOB_CONSUMER_IDLE(com.birbit.android.jobqueue.messaging.a.g.class, 0),
    ADD_JOB(com.birbit.android.jobqueue.messaging.a.a.class, 1),
    CANCEL(com.birbit.android.jobqueue.messaging.a.c.class, 1),
    CONSTRAINT_CHANGE(com.birbit.android.jobqueue.messaging.a.f.class, 2),
    RUN_JOB_RESULT(j.class, 3),
    SCHEDULER(k.class, 4);

    static final int MAX_PRIORITY;
    static final Map<Class<? extends b>, Type> mapping = new HashMap();
    final Class<? extends b> klass;
    final int priority;

    static {
        int i = 0;
        for (Type type : values()) {
            mapping.put(type.klass, type);
            int i2 = type.priority;
            if (i2 > i) {
                i = i2;
            }
        }
        MAX_PRIORITY = i;
    }

    Type(Class cls, int i) {
        this.klass = cls;
        this.priority = i;
    }
}
