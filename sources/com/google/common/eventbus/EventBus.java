package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

@Beta
/* loaded from: classes2.dex */
public class EventBus {

    /* renamed from: a */
    private static final Logger f15899a = Logger.getLogger(EventBus.class.getName());

    /* renamed from: b */
    private final String f15900b;

    /* renamed from: c */
    private final Executor f15901c;

    /* renamed from: d */
    private final SubscriberExceptionHandler f15902d;

    /* renamed from: e */
    private final g f15903e;

    /* renamed from: f */
    private final d f15904f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a implements SubscriberExceptionHandler {

        /* renamed from: a */
        static final a f15905a = new a();

        a() {
        }
    }

    public EventBus() {
        this("default");
    }

    public String toString() {
        return MoreObjects.a(this).a(this.f15900b).toString();
    }

    public EventBus(String str) {
        this(str, MoreExecutors.a(), d.a(), a.f15905a);
    }

    EventBus(String str, Executor executor, d dVar, SubscriberExceptionHandler subscriberExceptionHandler) {
        this.f15903e = new g(this);
        Preconditions.a(str);
        this.f15900b = str;
        Preconditions.a(executor);
        this.f15901c = executor;
        Preconditions.a(dVar);
        this.f15904f = dVar;
        Preconditions.a(subscriberExceptionHandler);
        this.f15902d = subscriberExceptionHandler;
    }
}
