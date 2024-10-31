package io.opencensus.trace;

import io.opencensus.trace.NetworkEvent;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: AutoValue_NetworkEvent.java */
@Immutable
/* loaded from: classes3.dex */
final class d extends NetworkEvent {

    /* renamed from: a */
    private final e.a.a.b f28062a;

    /* renamed from: b */
    private final NetworkEvent.Type f28063b;

    /* renamed from: c */
    private final long f28064c;

    /* renamed from: d */
    private final long f28065d;

    /* renamed from: e */
    private final long f28066e;

    /* synthetic */ d(e.a.a.b bVar, NetworkEvent.Type type, long j, long j2, long j3, c cVar) {
        this(bVar, type, j, j2, j3);
    }

    @Override // io.opencensus.trace.NetworkEvent
    public long a() {
        return this.f28066e;
    }

    @Override // io.opencensus.trace.NetworkEvent
    @Nullable
    public e.a.a.b b() {
        return this.f28062a;
    }

    @Override // io.opencensus.trace.NetworkEvent
    public long c() {
        return this.f28064c;
    }

    @Override // io.opencensus.trace.NetworkEvent
    public NetworkEvent.Type d() {
        return this.f28063b;
    }

    @Override // io.opencensus.trace.NetworkEvent
    public long e() {
        return this.f28065d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkEvent)) {
            return false;
        }
        NetworkEvent networkEvent = (NetworkEvent) obj;
        e.a.a.b bVar = this.f28062a;
        if (bVar != null ? bVar.equals(networkEvent.b()) : networkEvent.b() == null) {
            if (this.f28063b.equals(networkEvent.d()) && this.f28064c == networkEvent.c() && this.f28065d == networkEvent.e() && this.f28066e == networkEvent.a()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        e.a.a.b bVar = this.f28062a;
        long hashCode = ((((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003) ^ this.f28063b.hashCode()) * 1000003;
        long j = this.f28064c;
        long j2 = ((int) (hashCode ^ (j ^ (j >>> 32)))) * 1000003;
        long j3 = this.f28065d;
        long j4 = ((int) (j2 ^ (j3 ^ (j3 >>> 32)))) * 1000003;
        long j5 = this.f28066e;
        return (int) (j4 ^ (j5 ^ (j5 >>> 32)));
    }

    public String toString() {
        return "NetworkEvent{kernelTimestamp=" + this.f28062a + ", type=" + this.f28063b + ", messageId=" + this.f28064c + ", uncompressedMessageSize=" + this.f28065d + ", compressedMessageSize=" + this.f28066e + "}";
    }

    /* compiled from: AutoValue_NetworkEvent.java */
    /* loaded from: classes3.dex */
    public static final class a extends NetworkEvent.a {

        /* renamed from: a */
        private e.a.a.b f28067a;

        /* renamed from: b */
        private NetworkEvent.Type f28068b;

        /* renamed from: c */
        private Long f28069c;

        /* renamed from: d */
        private Long f28070d;

        /* renamed from: e */
        private Long f28071e;

        public NetworkEvent.a a(NetworkEvent.Type type) {
            if (type != null) {
                this.f28068b = type;
                return this;
            }
            throw new NullPointerException("Null type");
        }

        @Override // io.opencensus.trace.NetworkEvent.a
        NetworkEvent.a b(long j) {
            this.f28069c = Long.valueOf(j);
            return this;
        }

        @Override // io.opencensus.trace.NetworkEvent.a
        public NetworkEvent.a c(long j) {
            this.f28070d = Long.valueOf(j);
            return this;
        }

        @Override // io.opencensus.trace.NetworkEvent.a
        public NetworkEvent.a a(long j) {
            this.f28071e = Long.valueOf(j);
            return this;
        }

        @Override // io.opencensus.trace.NetworkEvent.a
        public NetworkEvent a() {
            String str = "";
            if (this.f28068b == null) {
                str = " type";
            }
            if (this.f28069c == null) {
                str = str + " messageId";
            }
            if (this.f28070d == null) {
                str = str + " uncompressedMessageSize";
            }
            if (this.f28071e == null) {
                str = str + " compressedMessageSize";
            }
            if (str.isEmpty()) {
                return new d(this.f28067a, this.f28068b, this.f28069c.longValue(), this.f28070d.longValue(), this.f28071e.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    private d(@Nullable e.a.a.b bVar, NetworkEvent.Type type, long j, long j2, long j3) {
        this.f28062a = bVar;
        this.f28063b = type;
        this.f28064c = j;
        this.f28065d = j2;
        this.f28066e = j3;
    }
}
