package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingQueue;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public abstract class ForwardingBlockingQueue<E> extends ForwardingQueue<E> implements BlockingQueue<E> {
    protected ForwardingBlockingQueue() {
    }
}
