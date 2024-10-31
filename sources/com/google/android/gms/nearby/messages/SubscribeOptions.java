package com.google.android.gms.nearby.messages;

/* loaded from: classes.dex */
public final class SubscribeOptions {

    /* renamed from: a, reason: collision with root package name */
    public static final SubscribeOptions f2103a = new Builder().a();
    private final Strategy b;
    private final MessageFilter c;
    private final SubscribeCallback d;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Strategy f2104a = Strategy.f2101a;
        private MessageFilter b = MessageFilter.f2096a;
        private SubscribeCallback c;

        public SubscribeOptions a() {
            return new SubscribeOptions(this.f2104a, this.b, this.c);
        }
    }

    private SubscribeOptions(Strategy strategy, MessageFilter messageFilter, SubscribeCallback subscribeCallback) {
        this.b = strategy;
        this.c = messageFilter;
        this.d = subscribeCallback;
    }
}
