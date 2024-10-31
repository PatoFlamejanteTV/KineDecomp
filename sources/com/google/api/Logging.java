package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Logging extends GeneratedMessageLite<Logging, Builder> implements LoggingOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Logging f14463d = new Logging();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Logging> f14464e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<LoggingDestination> f14465f = GeneratedMessageLite.k();

    /* renamed from: g, reason: collision with root package name */
    private Internal.ProtobufList<LoggingDestination> f14466g = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Logging, Builder> implements LoggingOrBuilder {
        /* synthetic */ Builder(A a2) {
            this();
        }

        private Builder() {
            super(Logging.f14463d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface LoggingDestinationOrBuilder extends MessageLiteOrBuilder {
    }

    static {
        f14463d.l();
    }

    private Logging() {
    }

    public static Logging n() {
        return f14463d;
    }

    public static Parser<Logging> o() {
        return f14463d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f14465f.size(); i++) {
            codedOutputStream.c(1, this.f14465f.get(i));
        }
        for (int i2 = 0; i2 < this.f14466g.size(); i2++) {
            codedOutputStream.c(2, this.f14466g.get(i2));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f14465f.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f14465f.get(i3));
        }
        for (int i4 = 0; i4 < this.f14466g.size(); i4++) {
            i2 += CodedOutputStream.a(2, this.f14466g.get(i4));
        }
        this.f18584c = i2;
        return i2;
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class LoggingDestination extends GeneratedMessageLite<LoggingDestination, Builder> implements LoggingDestinationOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final LoggingDestination f14467d = new LoggingDestination();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<LoggingDestination> f14468e;

        /* renamed from: f, reason: collision with root package name */
        private int f14469f;

        /* renamed from: g, reason: collision with root package name */
        private String f14470g = "";

        /* renamed from: h, reason: collision with root package name */
        private Internal.ProtobufList<String> f14471h = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<LoggingDestination, Builder> implements LoggingDestinationOrBuilder {
            /* synthetic */ Builder(A a2) {
                this();
            }

            private Builder() {
                super(LoggingDestination.f14467d);
            }
        }

        static {
            f14467d.l();
        }

        private LoggingDestination() {
        }

        public static Parser<LoggingDestination> p() {
            return f14467d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.f14471h.size(); i++) {
                codedOutputStream.b(1, this.f14471h.get(i));
            }
            if (this.f14470g.isEmpty()) {
                return;
            }
            codedOutputStream.b(3, o());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f14471h.size(); i3++) {
                i2 += CodedOutputStream.a(this.f14471h.get(i3));
            }
            int size = 0 + i2 + (n().size() * 1);
            if (!this.f14470g.isEmpty()) {
                size += CodedOutputStream.a(3, o());
            }
            this.f18584c = size;
            return size;
        }

        public List<String> n() {
            return this.f14471h;
        }

        public String o() {
            return this.f14470g;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            A a2 = null;
            switch (A.f14324a[methodToInvoke.ordinal()]) {
                case 1:
                    return new LoggingDestination();
                case 2:
                    return f14467d;
                case 3:
                    this.f14471h.L();
                    return null;
                case 4:
                    return new Builder(a2);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    LoggingDestination loggingDestination = (LoggingDestination) obj2;
                    this.f14470g = visitor.a(!this.f14470g.isEmpty(), this.f14470g, true ^ loggingDestination.f14470g.isEmpty(), loggingDestination.f14470g);
                    this.f14471h = visitor.a(this.f14471h, loggingDestination.f14471h);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f14469f |= loggingDestination.f14469f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    String w = codedInputStream.w();
                                    if (!this.f14471h.M()) {
                                        this.f14471h = GeneratedMessageLite.a(this.f14471h);
                                    }
                                    this.f14471h.add(w);
                                } else if (x != 26) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f14470g = codedInputStream.w();
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
                    if (f14468e == null) {
                        synchronized (LoggingDestination.class) {
                            if (f14468e == null) {
                                f14468e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14467d);
                            }
                        }
                    }
                    return f14468e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f14467d;
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        A a2 = null;
        switch (A.f14324a[methodToInvoke.ordinal()]) {
            case 1:
                return new Logging();
            case 2:
                return f14463d;
            case 3:
                this.f14465f.L();
                this.f14466g.L();
                return null;
            case 4:
                return new Builder(a2);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Logging logging = (Logging) obj2;
                this.f14465f = visitor.a(this.f14465f, logging.f14465f);
                this.f14466g = visitor.a(this.f14466g, logging.f14466g);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                if (!this.f14465f.M()) {
                                    this.f14465f = GeneratedMessageLite.a(this.f14465f);
                                }
                                this.f14465f.add((LoggingDestination) codedInputStream.a(LoggingDestination.p(), extensionRegistryLite));
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                if (!this.f14466g.M()) {
                                    this.f14466g = GeneratedMessageLite.a(this.f14466g);
                                }
                                this.f14466g.add((LoggingDestination) codedInputStream.a(LoggingDestination.p(), extensionRegistryLite));
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
                if (f14464e == null) {
                    synchronized (Logging.class) {
                        if (f14464e == null) {
                            f14464e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14463d);
                        }
                    }
                }
                return f14464e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14463d;
    }
}
