package com.google.longrunning;

import com.google.protobuf.Any;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.rpc.Status;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Operation extends GeneratedMessageLite<Operation, Builder> implements OperationOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Operation f18357d = new Operation();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Operation> f18358e;

    /* renamed from: g, reason: collision with root package name */
    private Object f18360g;
    private Any i;
    private boolean j;

    /* renamed from: f, reason: collision with root package name */
    private int f18359f = 0;

    /* renamed from: h, reason: collision with root package name */
    private String f18361h = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Operation, Builder> implements OperationOrBuilder {
        /* synthetic */ Builder(f fVar) {
            this();
        }

        private Builder() {
            super(Operation.f18357d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public enum ResultCase implements Internal.EnumLite {
        ERROR(4),
        RESPONSE(5),
        RESULT_NOT_SET(0);

        private final int value;

        ResultCase(int i) {
            this.value = i;
        }

        public static ResultCase forNumber(int i) {
            if (i == 0) {
                return RESULT_NOT_SET;
            }
            if (i == 4) {
                return ERROR;
            }
            if (i != 5) {
                return null;
            }
            return RESPONSE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ResultCase valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        f18357d.l();
    }

    private Operation() {
    }

    public static Parser<Operation> q() {
        return f18357d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18361h.isEmpty()) {
            codedOutputStream.b(1, o());
        }
        if (this.i != null) {
            codedOutputStream.c(2, n());
        }
        boolean z = this.j;
        if (z) {
            codedOutputStream.b(3, z);
        }
        if (this.f18359f == 4) {
            codedOutputStream.c(4, (Status) this.f18360g);
        }
        if (this.f18359f == 5) {
            codedOutputStream.c(5, (Any) this.f18360g);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18361h.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, o());
        if (this.i != null) {
            a2 += CodedOutputStream.a(2, n());
        }
        boolean z = this.j;
        if (z) {
            a2 += CodedOutputStream.a(3, z);
        }
        if (this.f18359f == 4) {
            a2 += CodedOutputStream.a(4, (Status) this.f18360g);
        }
        if (this.f18359f == 5) {
            a2 += CodedOutputStream.a(5, (Any) this.f18360g);
        }
        this.f18584c = a2;
        return a2;
    }

    public Any n() {
        Any any = this.i;
        return any == null ? Any.n() : any;
    }

    public String o() {
        return this.f18361h;
    }

    public ResultCase p() {
        return ResultCase.forNumber(this.f18359f);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i;
        f fVar = null;
        switch (f.f18368b[methodToInvoke.ordinal()]) {
            case 1:
                return new Operation();
            case 2:
                return f18357d;
            case 3:
                return null;
            case 4:
                return new Builder(fVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Operation operation = (Operation) obj2;
                this.f18361h = visitor.a(!this.f18361h.isEmpty(), this.f18361h, !operation.f18361h.isEmpty(), operation.f18361h);
                this.i = (Any) visitor.a(this.i, operation.i);
                boolean z = this.j;
                boolean z2 = operation.j;
                this.j = visitor.a(z, z, z2, z2);
                int i2 = f.f18367a[operation.p().ordinal()];
                if (i2 == 1) {
                    this.f18360g = visitor.e(this.f18359f == 4, this.f18360g, operation.f18360g);
                } else if (i2 == 2) {
                    this.f18360g = visitor.e(this.f18359f == 5, this.f18360g, operation.f18360g);
                } else if (i2 == 3) {
                    visitor.a(this.f18359f != 0);
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a && (i = operation.f18359f) != 0) {
                    this.f18359f = i;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r2) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f18361h = codedInputStream.w();
                            } else if (x == 18) {
                                Any.Builder b2 = this.i != null ? this.i.b() : null;
                                this.i = (Any) codedInputStream.a(Any.p(), extensionRegistryLite);
                                if (b2 != null) {
                                    b2.b((Any.Builder) this.i);
                                    this.i = b2.T();
                                }
                            } else if (x == 24) {
                                this.j = codedInputStream.c();
                            } else if (x == 34) {
                                Status.Builder b3 = this.f18359f == 4 ? ((Status) this.f18360g).b() : null;
                                this.f18360g = codedInputStream.a(Status.p(), extensionRegistryLite);
                                if (b3 != null) {
                                    b3.b((Status.Builder) this.f18360g);
                                    this.f18360g = b3.T();
                                }
                                this.f18359f = 4;
                            } else if (x != 42) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                Any.Builder b4 = this.f18359f == 5 ? ((Any) this.f18360g).b() : null;
                                this.f18360g = codedInputStream.a(Any.p(), extensionRegistryLite);
                                if (b4 != null) {
                                    b4.b((Any.Builder) this.f18360g);
                                    this.f18360g = b4.T();
                                }
                                this.f18359f = 5;
                            }
                        }
                        r2 = true;
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
                if (f18358e == null) {
                    synchronized (Operation.class) {
                        if (f18358e == null) {
                            f18358e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18357d);
                        }
                    }
                }
                return f18358e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18357d;
    }
}
