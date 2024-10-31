package com.google.android.gms.nearby.messages;

/* loaded from: classes.dex */
public final class PublishOptions {

    /* renamed from: a, reason: collision with root package name */
    public static final PublishOptions f2099a = new Builder().a();
    private final Strategy b;
    private final PublishCallback c;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Strategy f2100a = Strategy.f2101a;
        private PublishCallback b;

        public PublishOptions a() {
            return new PublishOptions(this.f2100a, this.b);
        }
    }

    private PublishOptions(Strategy strategy, PublishCallback publishCallback) {
        this.b = strategy;
        this.c = publishCallback;
    }
}
