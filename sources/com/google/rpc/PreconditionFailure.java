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
public final class PreconditionFailure extends GeneratedMessageLite<PreconditionFailure, Builder> implements PreconditionFailureOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final PreconditionFailure f18859d = new PreconditionFailure();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<PreconditionFailure> f18860e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<Violation> f18861f = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<PreconditionFailure, Builder> implements PreconditionFailureOrBuilder {
        /* synthetic */ Builder(f fVar) {
            this();
        }

        private Builder() {
            super(PreconditionFailure.f18859d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface ViolationOrBuilder extends MessageLiteOrBuilder {
    }

    static {
        f18859d.l();
    }

    private PreconditionFailure() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f18861f.size(); i++) {
            codedOutputStream.c(1, this.f18861f.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f18861f.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f18861f.get(i3));
        }
        this.f18584c = i2;
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        f fVar = null;
        switch (f.f18895a[methodToInvoke.ordinal()]) {
            case 1:
                return new PreconditionFailure();
            case 2:
                return f18859d;
            case 3:
                this.f18861f.L();
                return null;
            case 4:
                return new Builder(fVar);
            case 5:
                this.f18861f = ((GeneratedMessageLite.Visitor) obj).a(this.f18861f, ((PreconditionFailure) obj2).f18861f);
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
                                    if (!this.f18861f.M()) {
                                        this.f18861f = GeneratedMessageLite.a(this.f18861f);
                                    }
                                    this.f18861f.add((Violation) codedInputStream.a(Violation.q(), extensionRegistryLite));
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
                if (f18860e == null) {
                    synchronized (PreconditionFailure.class) {
                        if (f18860e == null) {
                            f18860e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18859d);
                        }
                    }
                }
                return f18860e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18859d;
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Violation extends GeneratedMessageLite<Violation, Builder> implements ViolationOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final Violation f18862d = new Violation();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<Violation> f18863e;

        /* renamed from: f, reason: collision with root package name */
        private String f18864f = "";

        /* renamed from: g, reason: collision with root package name */
        private String f18865g = "";

        /* renamed from: h, reason: collision with root package name */
        private String f18866h = "";

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Violation, Builder> implements ViolationOrBuilder {
            /* synthetic */ Builder(f fVar) {
                this();
            }

            private Builder() {
                super(Violation.f18862d);
            }
        }

        static {
            f18862d.l();
        }

        private Violation() {
        }

        public static Parser<Violation> q() {
            return f18862d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.f18864f.isEmpty()) {
                codedOutputStream.b(1, p());
            }
            if (!this.f18865g.isEmpty()) {
                codedOutputStream.b(2, o());
            }
            if (this.f18866h.isEmpty()) {
                return;
            }
            codedOutputStream.b(3, n());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f18864f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, p());
            if (!this.f18865g.isEmpty()) {
                a2 += CodedOutputStream.a(2, o());
            }
            if (!this.f18866h.isEmpty()) {
                a2 += CodedOutputStream.a(3, n());
            }
            this.f18584c = a2;
            return a2;
        }

        public String n() {
            return this.f18866h;
        }

        public String o() {
            return this.f18865g;
        }

        public String p() {
            return this.f18864f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            f fVar = null;
            switch (f.f18895a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Violation();
                case 2:
                    return f18862d;
                case 3:
                    return null;
                case 4:
                    return new Builder(fVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Violation violation = (Violation) obj2;
                    this.f18864f = visitor.a(!this.f18864f.isEmpty(), this.f18864f, !violation.f18864f.isEmpty(), violation.f18864f);
                    this.f18865g = visitor.a(!this.f18865g.isEmpty(), this.f18865g, !violation.f18865g.isEmpty(), violation.f18865g);
                    this.f18866h = visitor.a(!this.f18866h.isEmpty(), this.f18866h, true ^ violation.f18866h.isEmpty(), violation.f18866h);
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
                                    this.f18864f = codedInputStream.w();
                                } else if (x == 18) {
                                    this.f18865g = codedInputStream.w();
                                } else if (x != 26) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f18866h = codedInputStream.w();
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
                    if (f18863e == null) {
                        synchronized (Violation.class) {
                            if (f18863e == null) {
                                f18863e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18862d);
                            }
                        }
                    }
                    return f18863e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18862d;
        }
    }
}
