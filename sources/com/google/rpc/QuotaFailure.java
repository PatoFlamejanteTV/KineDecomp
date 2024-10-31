package com.google.rpc;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class QuotaFailure extends GeneratedMessageLite<QuotaFailure, Builder> implements QuotaFailureOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final QuotaFailure f18867d = new QuotaFailure();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<QuotaFailure> f18868e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<Violation> f18869f = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<QuotaFailure, Builder> implements QuotaFailureOrBuilder {
        /* synthetic */ Builder(g gVar) {
            this();
        }

        private Builder() {
            super(QuotaFailure.f18867d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface ViolationOrBuilder extends MessageLiteOrBuilder {
    }

    static {
        f18867d.l();
    }

    private QuotaFailure() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f18869f.size(); i++) {
            codedOutputStream.c(1, this.f18869f.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f18869f.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f18869f.get(i3));
        }
        this.f18584c = i2;
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        g gVar = null;
        switch (g.f18896a[methodToInvoke.ordinal()]) {
            case 1:
                return new QuotaFailure();
            case 2:
                return f18867d;
            case 3:
                this.f18869f.L();
                return null;
            case 4:
                return new Builder(gVar);
            case 5:
                this.f18869f = ((GeneratedMessageLite.Visitor) obj).a(this.f18869f, ((QuotaFailure) obj2).f18869f);
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
                                    if (!this.f18869f.M()) {
                                        this.f18869f = GeneratedMessageLite.a(this.f18869f);
                                    }
                                    this.f18869f.add((Violation) codedInputStream.a(Violation.p(), extensionRegistryLite));
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
                if (f18868e == null) {
                    synchronized (QuotaFailure.class) {
                        if (f18868e == null) {
                            f18868e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18867d);
                        }
                    }
                }
                return f18868e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18867d;
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Violation extends GeneratedMessageLite<Violation, Builder> implements ViolationOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final Violation f18870d = new Violation();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<Violation> f18871e;

        /* renamed from: f, reason: collision with root package name */
        private String f18872f = "";

        /* renamed from: g, reason: collision with root package name */
        private String f18873g = "";

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Violation, Builder> implements ViolationOrBuilder {
            /* synthetic */ Builder(g gVar) {
                this();
            }

            private Builder() {
                super(Violation.f18870d);
            }
        }

        static {
            f18870d.l();
        }

        private Violation() {
        }

        public static Parser<Violation> p() {
            return f18870d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.f18872f.isEmpty()) {
                codedOutputStream.b(1, o());
            }
            if (this.f18873g.isEmpty()) {
                return;
            }
            codedOutputStream.b(2, n());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f18872f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, o());
            if (!this.f18873g.isEmpty()) {
                a2 += CodedOutputStream.a(2, n());
            }
            this.f18584c = a2;
            return a2;
        }

        public String n() {
            return this.f18873g;
        }

        public String o() {
            return this.f18872f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            g gVar = null;
            switch (g.f18896a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Violation();
                case 2:
                    return f18870d;
                case 3:
                    return null;
                case 4:
                    return new Builder(gVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Violation violation = (Violation) obj2;
                    this.f18872f = visitor.a(!this.f18872f.isEmpty(), this.f18872f, !violation.f18872f.isEmpty(), violation.f18872f);
                    this.f18873g = visitor.a(!this.f18873g.isEmpty(), this.f18873g, true ^ violation.f18873g.isEmpty(), violation.f18873g);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    this.f18872f = codedInputStream.w();
                                } else if (x != 18) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f18873g = codedInputStream.w();
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
                    if (f18871e == null) {
                        synchronized (Violation.class) {
                            if (f18871e == null) {
                                f18871e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18870d);
                            }
                        }
                    }
                    return f18871e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18870d;
        }
    }
}
