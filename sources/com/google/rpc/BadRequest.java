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
public final class BadRequest extends GeneratedMessageLite<BadRequest, Builder> implements BadRequestOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final BadRequest f18836d = new BadRequest();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<BadRequest> f18837e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<FieldViolation> f18838f = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<BadRequest, Builder> implements BadRequestOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        private Builder() {
            super(BadRequest.f18836d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface FieldViolationOrBuilder extends MessageLiteOrBuilder {
    }

    static {
        f18836d.l();
    }

    private BadRequest() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f18838f.size(); i++) {
            codedOutputStream.c(1, this.f18838f.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f18838f.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f18838f.get(i3));
        }
        this.f18584c = i2;
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f18891a[methodToInvoke.ordinal()]) {
            case 1:
                return new BadRequest();
            case 2:
                return f18836d;
            case 3:
                this.f18838f.L();
                return null;
            case 4:
                return new Builder(aVar);
            case 5:
                this.f18838f = ((GeneratedMessageLite.Visitor) obj).a(this.f18838f, ((BadRequest) obj2).f18838f);
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
                                    if (!this.f18838f.M()) {
                                        this.f18838f = GeneratedMessageLite.a(this.f18838f);
                                    }
                                    this.f18838f.add((FieldViolation) codedInputStream.a(FieldViolation.p(), extensionRegistryLite));
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
                if (f18837e == null) {
                    synchronized (BadRequest.class) {
                        if (f18837e == null) {
                            f18837e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18836d);
                        }
                    }
                }
                return f18837e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18836d;
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class FieldViolation extends GeneratedMessageLite<FieldViolation, Builder> implements FieldViolationOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final FieldViolation f18839d = new FieldViolation();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<FieldViolation> f18840e;

        /* renamed from: f, reason: collision with root package name */
        private String f18841f = "";

        /* renamed from: g, reason: collision with root package name */
        private String f18842g = "";

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldViolation, Builder> implements FieldViolationOrBuilder {
            /* synthetic */ Builder(a aVar) {
                this();
            }

            private Builder() {
                super(FieldViolation.f18839d);
            }
        }

        static {
            f18839d.l();
        }

        private FieldViolation() {
        }

        public static Parser<FieldViolation> p() {
            return f18839d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.f18841f.isEmpty()) {
                codedOutputStream.b(1, o());
            }
            if (this.f18842g.isEmpty()) {
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
            int a2 = this.f18841f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, o());
            if (!this.f18842g.isEmpty()) {
                a2 += CodedOutputStream.a(2, n());
            }
            this.f18584c = a2;
            return a2;
        }

        public String n() {
            return this.f18842g;
        }

        public String o() {
            return this.f18841f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f18891a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldViolation();
                case 2:
                    return f18839d;
                case 3:
                    return null;
                case 4:
                    return new Builder(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    FieldViolation fieldViolation = (FieldViolation) obj2;
                    this.f18841f = visitor.a(!this.f18841f.isEmpty(), this.f18841f, !fieldViolation.f18841f.isEmpty(), fieldViolation.f18841f);
                    this.f18842g = visitor.a(!this.f18842g.isEmpty(), this.f18842g, true ^ fieldViolation.f18842g.isEmpty(), fieldViolation.f18842g);
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
                                    this.f18841f = codedInputStream.w();
                                } else if (x != 18) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f18842g = codedInputStream.w();
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
                    if (f18840e == null) {
                        synchronized (FieldViolation.class) {
                            if (f18840e == null) {
                                f18840e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18839d);
                            }
                        }
                    }
                    return f18840e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18839d;
        }
    }
}
