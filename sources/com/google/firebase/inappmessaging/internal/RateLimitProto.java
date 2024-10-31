package com.google.firebase.inappmessaging.internal;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class RateLimitProto {

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Counter extends GeneratedMessageLite<Counter, Builder> implements CounterOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final Counter f17812d = new Counter();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<Counter> f17813e;

        /* renamed from: f, reason: collision with root package name */
        private long f17814f;

        /* renamed from: g, reason: collision with root package name */
        private long f17815g;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Counter, Builder> implements CounterOrBuilder {
            /* synthetic */ Builder(ka kaVar) {
                this();
            }

            public Builder a(long j) {
                b();
                ((Counter) this.f18586b).a(j);
                return this;
            }

            public Builder b(long j) {
                b();
                ((Counter) this.f18586b).b(j);
                return this;
            }

            public Builder c() {
                b();
                ((Counter) this.f18586b).r();
                return this;
            }

            private Builder() {
                super(Counter.f17812d);
            }
        }

        static {
            f17812d.l();
        }

        private Counter() {
        }

        public static Counter n() {
            return f17812d;
        }

        public static Builder q() {
            return f17812d.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r() {
            this.f17814f = 0L;
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            long j = this.f17814f;
            int b2 = j != 0 ? 0 + CodedOutputStream.b(1, j) : 0;
            long j2 = this.f17815g;
            if (j2 != 0) {
                b2 += CodedOutputStream.b(2, j2);
            }
            this.f18584c = b2;
            return b2;
        }

        public long o() {
            return this.f17815g;
        }

        public long p() {
            return this.f17814f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(long j) {
            this.f17814f = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j) {
            this.f17815g = j;
        }

        public static Builder b(Counter counter) {
            return f17812d.b().b((Builder) counter);
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            long j = this.f17814f;
            if (j != 0) {
                codedOutputStream.e(1, j);
            }
            long j2 = this.f17815g;
            if (j2 != 0) {
                codedOutputStream.e(2, j2);
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            ka kaVar = null;
            boolean z = false;
            switch (ka.f17972a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Counter();
                case 2:
                    return f17812d;
                case 3:
                    return null;
                case 4:
                    return new Builder(kaVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Counter counter = (Counter) obj2;
                    this.f17814f = visitor.a(this.f17814f != 0, this.f17814f, counter.f17814f != 0, counter.f17814f);
                    this.f17815g = visitor.a(this.f17815g != 0, this.f17815g, counter.f17815g != 0, counter.f17815g);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 8) {
                                    this.f17814f = codedInputStream.k();
                                } else if (x != 16) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f17815g = codedInputStream.k();
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        } catch (IOException e3) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (f17813e == null) {
                        synchronized (Counter.class) {
                            if (f17813e == null) {
                                f17813e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17812d);
                            }
                        }
                    }
                    return f17813e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f17812d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface CounterOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class RateLimit extends GeneratedMessageLite<RateLimit, Builder> implements RateLimitOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final RateLimit f17816d = new RateLimit();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<RateLimit> f17817e;

        /* renamed from: f, reason: collision with root package name */
        private MapFieldLite<String, Counter> f17818f = MapFieldLite.emptyMapField();

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<RateLimit, Builder> implements RateLimitOrBuilder {
            /* synthetic */ Builder(ka kaVar) {
                this();
            }

            public Builder a(String str, Counter counter) {
                if (str == null) {
                    throw new NullPointerException();
                }
                if (counter != null) {
                    b();
                    ((RateLimit) this.f18586b).p().put(str, counter);
                    return this;
                }
                throw new NullPointerException();
            }

            private Builder() {
                super(RateLimit.f17816d);
            }
        }

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        private static final class a {

            /* renamed from: a, reason: collision with root package name */
            static final MapEntryLite<String, Counter> f17819a = MapEntryLite.a(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Counter.n());
        }

        static {
            f17816d.l();
        }

        private RateLimit() {
        }

        public static Builder b(RateLimit rateLimit) {
            return f17816d.b().b((Builder) rateLimit);
        }

        public static RateLimit n() {
            return f17816d;
        }

        public static Parser<RateLimit> o() {
            return f17816d.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Counter> p() {
            return r();
        }

        private MapFieldLite<String, Counter> q() {
            return this.f17818f;
        }

        private MapFieldLite<String, Counter> r() {
            if (!this.f17818f.isMutable()) {
                this.f17818f = this.f17818f.mutableCopy();
            }
            return this.f17818f;
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (Map.Entry<String, Counter> entry : q().entrySet()) {
                i2 += a.f17819a.a(1, (int) entry.getKey(), (String) entry.getValue());
            }
            this.f18584c = i2;
            return i2;
        }

        public Counter a(String str, Counter counter) {
            if (str != null) {
                MapFieldLite<String, Counter> q = q();
                return q.containsKey(str) ? q.get(str) : counter;
            }
            throw new NullPointerException();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            for (Map.Entry<String, Counter> entry : q().entrySet()) {
                a.f17819a.a(codedOutputStream, 1, (int) entry.getKey(), (String) entry.getValue());
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            ka kaVar = null;
            switch (ka.f17972a[methodToInvoke.ordinal()]) {
                case 1:
                    return new RateLimit();
                case 2:
                    return f17816d;
                case 3:
                    this.f17818f.makeImmutable();
                    return null;
                case 4:
                    return new Builder(kaVar);
                case 5:
                    this.f17818f = ((GeneratedMessageLite.Visitor) obj).a(this.f17818f, ((RateLimit) obj2).q());
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x != 10) {
                                        if (!codedInputStream.f(x)) {
                                        }
                                    } else {
                                        if (!this.f17818f.isMutable()) {
                                            this.f17818f = this.f17818f.mutableCopy();
                                        }
                                        a.f17819a.a(this.f17818f, codedInputStream, extensionRegistryLite);
                                    }
                                }
                                z = true;
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        } catch (InvalidProtocolBufferException e3) {
                            throw new RuntimeException(e3.setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (f17817e == null) {
                        synchronized (RateLimit.class) {
                            if (f17817e == null) {
                                f17817e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17816d);
                            }
                        }
                    }
                    return f17817e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f17816d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface RateLimitOrBuilder extends MessageLiteOrBuilder {
    }

    private RateLimitProto() {
    }
}
