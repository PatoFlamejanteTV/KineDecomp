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
public final class Monitoring extends GeneratedMessageLite<Monitoring, Builder> implements MonitoringOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Monitoring f14501d = new Monitoring();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Monitoring> f14502e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<MonitoringDestination> f14503f = GeneratedMessageLite.k();

    /* renamed from: g, reason: collision with root package name */
    private Internal.ProtobufList<MonitoringDestination> f14504g = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Monitoring, Builder> implements MonitoringOrBuilder {
        /* synthetic */ Builder(I i) {
            this();
        }

        private Builder() {
            super(Monitoring.f14501d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface MonitoringDestinationOrBuilder extends MessageLiteOrBuilder {
    }

    static {
        f14501d.l();
    }

    private Monitoring() {
    }

    public static Monitoring n() {
        return f14501d;
    }

    public static Parser<Monitoring> o() {
        return f14501d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f14503f.size(); i++) {
            codedOutputStream.c(1, this.f14503f.get(i));
        }
        for (int i2 = 0; i2 < this.f14504g.size(); i2++) {
            codedOutputStream.c(2, this.f14504g.get(i2));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f14503f.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f14503f.get(i3));
        }
        for (int i4 = 0; i4 < this.f14504g.size(); i4++) {
            i2 += CodedOutputStream.a(2, this.f14504g.get(i4));
        }
        this.f18584c = i2;
        return i2;
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class MonitoringDestination extends GeneratedMessageLite<MonitoringDestination, Builder> implements MonitoringDestinationOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final MonitoringDestination f14505d = new MonitoringDestination();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<MonitoringDestination> f14506e;

        /* renamed from: f, reason: collision with root package name */
        private int f14507f;

        /* renamed from: g, reason: collision with root package name */
        private String f14508g = "";

        /* renamed from: h, reason: collision with root package name */
        private Internal.ProtobufList<String> f14509h = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<MonitoringDestination, Builder> implements MonitoringDestinationOrBuilder {
            /* synthetic */ Builder(I i) {
                this();
            }

            private Builder() {
                super(MonitoringDestination.f14505d);
            }
        }

        static {
            f14505d.l();
        }

        private MonitoringDestination() {
        }

        public static Parser<MonitoringDestination> p() {
            return f14505d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.f14508g.isEmpty()) {
                codedOutputStream.b(1, o());
            }
            for (int i = 0; i < this.f14509h.size(); i++) {
                codedOutputStream.b(2, this.f14509h.get(i));
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = !this.f14508g.isEmpty() ? CodedOutputStream.a(1, o()) + 0 : 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f14509h.size(); i3++) {
                i2 += CodedOutputStream.a(this.f14509h.get(i3));
            }
            int size = a2 + i2 + (n().size() * 1);
            this.f18584c = size;
            return size;
        }

        public List<String> n() {
            return this.f14509h;
        }

        public String o() {
            return this.f14508g;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            I i = null;
            switch (I.f14449a[methodToInvoke.ordinal()]) {
                case 1:
                    return new MonitoringDestination();
                case 2:
                    return f14505d;
                case 3:
                    this.f14509h.L();
                    return null;
                case 4:
                    return new Builder(i);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    MonitoringDestination monitoringDestination = (MonitoringDestination) obj2;
                    this.f14508g = visitor.a(!this.f14508g.isEmpty(), this.f14508g, true ^ monitoringDestination.f14508g.isEmpty(), monitoringDestination.f14508g);
                    this.f14509h = visitor.a(this.f14509h, monitoringDestination.f14509h);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f14507f |= monitoringDestination.f14507f;
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
                                    this.f14508g = codedInputStream.w();
                                } else if (x != 18) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    String w = codedInputStream.w();
                                    if (!this.f14509h.M()) {
                                        this.f14509h = GeneratedMessageLite.a(this.f14509h);
                                    }
                                    this.f14509h.add(w);
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
                    if (f14506e == null) {
                        synchronized (MonitoringDestination.class) {
                            if (f14506e == null) {
                                f14506e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14505d);
                            }
                        }
                    }
                    return f14506e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f14505d;
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        I i = null;
        switch (I.f14449a[methodToInvoke.ordinal()]) {
            case 1:
                return new Monitoring();
            case 2:
                return f14501d;
            case 3:
                this.f14503f.L();
                this.f14504g.L();
                return null;
            case 4:
                return new Builder(i);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Monitoring monitoring = (Monitoring) obj2;
                this.f14503f = visitor.a(this.f14503f, monitoring.f14503f);
                this.f14504g = visitor.a(this.f14504g, monitoring.f14504g);
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
                                if (!this.f14503f.M()) {
                                    this.f14503f = GeneratedMessageLite.a(this.f14503f);
                                }
                                this.f14503f.add((MonitoringDestination) codedInputStream.a(MonitoringDestination.p(), extensionRegistryLite));
                            } else if (x != 18) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                if (!this.f14504g.M()) {
                                    this.f14504g = GeneratedMessageLite.a(this.f14504g);
                                }
                                this.f14504g.add((MonitoringDestination) codedInputStream.a(MonitoringDestination.p(), extensionRegistryLite));
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
                if (f14502e == null) {
                    synchronized (Monitoring.class) {
                        if (f14502e == null) {
                            f14502e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14501d);
                        }
                    }
                }
                return f14502e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14501d;
    }
}
