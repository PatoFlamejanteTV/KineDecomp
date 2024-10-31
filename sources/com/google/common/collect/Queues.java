package com.google.common.collect;

import com.google.common.annotations.Beta;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Beta
/* loaded from: classes2.dex */
public final class Queues {
    private Queues() {
    }

    public static <E> ConcurrentLinkedQueue<E> a() {
        return new ConcurrentLinkedQueue<>();
    }

    public static <E> LinkedBlockingQueue<E> b() {
        return new LinkedBlockingQueue<>();
    }
}
