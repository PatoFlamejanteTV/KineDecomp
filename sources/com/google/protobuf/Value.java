package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ListValue;
import com.google.protobuf.Struct;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Value extends GeneratedMessageLite<Value, Builder> implements ValueOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Value f18732d = new Value();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Value> f18733e;

    /* renamed from: f, reason: collision with root package name */
    private int f18734f = 0;

    /* renamed from: g, reason: collision with root package name */
    private Object f18735g;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
        /* synthetic */ Builder(ja jaVar) {
            this();
        }

        private Builder() {
            super(Value.f18732d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public enum KindCase implements Internal.EnumLite {
        NULL_VALUE(1),
        NUMBER_VALUE(2),
        STRING_VALUE(3),
        BOOL_VALUE(4),
        STRUCT_VALUE(5),
        LIST_VALUE(6),
        KIND_NOT_SET(0);

        private final int value;

        KindCase(int i) {
            this.value = i;
        }

        public static KindCase forNumber(int i) {
            switch (i) {
                case 0:
                    return KIND_NOT_SET;
                case 1:
                    return NULL_VALUE;
                case 2:
                    return NUMBER_VALUE;
                case 3:
                    return STRING_VALUE;
                case 4:
                    return BOOL_VALUE;
                case 5:
                    return STRUCT_VALUE;
                case 6:
                    return LIST_VALUE;
                default:
                    return null;
            }
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static KindCase valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        f18732d.l();
    }

    private Value() {
    }

    public static Value n() {
        return f18732d;
    }

    public static Parser<Value> q() {
        return f18732d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f18734f == 1) {
            codedOutputStream.e(1, ((Integer) this.f18735g).intValue());
        }
        if (this.f18734f == 2) {
            codedOutputStream.b(2, ((Double) this.f18735g).doubleValue());
        }
        if (this.f18734f == 3) {
            codedOutputStream.b(3, p());
        }
        if (this.f18734f == 4) {
            codedOutputStream.b(4, ((Boolean) this.f18735g).booleanValue());
        }
        if (this.f18734f == 5) {
            codedOutputStream.c(5, (Struct) this.f18735g);
        }
        if (this.f18734f == 6) {
            codedOutputStream.c(6, (ListValue) this.f18735g);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18734f == 1 ? 0 + CodedOutputStream.a(1, ((Integer) this.f18735g).intValue()) : 0;
        if (this.f18734f == 2) {
            a2 += CodedOutputStream.a(2, ((Double) this.f18735g).doubleValue());
        }
        if (this.f18734f == 3) {
            a2 += CodedOutputStream.a(3, p());
        }
        if (this.f18734f == 4) {
            a2 += CodedOutputStream.a(4, ((Boolean) this.f18735g).booleanValue());
        }
        if (this.f18734f == 5) {
            a2 += CodedOutputStream.a(5, (Struct) this.f18735g);
        }
        if (this.f18734f == 6) {
            a2 += CodedOutputStream.a(6, (ListValue) this.f18735g);
        }
        this.f18584c = a2;
        return a2;
    }

    public KindCase o() {
        return KindCase.forNumber(this.f18734f);
    }

    public String p() {
        return this.f18734f == 3 ? (String) this.f18735g : "";
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i;
        ja jaVar = null;
        switch (ja.f18788b[methodToInvoke.ordinal()]) {
            case 1:
                return new Value();
            case 2:
                return f18732d;
            case 3:
                return null;
            case 4:
                return new Builder(jaVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Value value = (Value) obj2;
                switch (ja.f18787a[value.o().ordinal()]) {
                    case 1:
                        this.f18735g = visitor.c(this.f18734f == 1, this.f18735g, value.f18735g);
                        break;
                    case 2:
                        this.f18735g = visitor.b(this.f18734f == 2, this.f18735g, value.f18735g);
                        break;
                    case 3:
                        this.f18735g = visitor.a(this.f18734f == 3, this.f18735g, value.f18735g);
                        break;
                    case 4:
                        this.f18735g = visitor.d(this.f18734f == 4, this.f18735g, value.f18735g);
                        break;
                    case 5:
                        this.f18735g = visitor.e(this.f18734f == 5, this.f18735g, value.f18735g);
                        break;
                    case 6:
                        this.f18735g = visitor.e(this.f18734f == 6, this.f18735g, value.f18735g);
                        break;
                    case 7:
                        visitor.a(this.f18734f != 0);
                        break;
                }
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a && (i = value.f18734f) != 0) {
                    this.f18734f = i;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r6) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 8) {
                                int f2 = codedInputStream.f();
                                this.f18734f = 1;
                                this.f18735g = Integer.valueOf(f2);
                            } else if (x == 17) {
                                this.f18734f = 2;
                                this.f18735g = Double.valueOf(codedInputStream.e());
                            } else if (x == 26) {
                                String w = codedInputStream.w();
                                this.f18734f = 3;
                                this.f18735g = w;
                            } else if (x == 32) {
                                this.f18734f = 4;
                                this.f18735g = Boolean.valueOf(codedInputStream.c());
                            } else if (x == 42) {
                                Struct.Builder b2 = this.f18734f == 5 ? ((Struct) this.f18735g).b() : null;
                                this.f18735g = codedInputStream.a(Struct.o(), extensionRegistryLite);
                                if (b2 != null) {
                                    b2.b((Struct.Builder) this.f18735g);
                                    this.f18735g = b2.T();
                                }
                                this.f18734f = 5;
                            } else if (x != 50) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                ListValue.Builder b3 = this.f18734f == 6 ? ((ListValue) this.f18735g).b() : null;
                                this.f18735g = codedInputStream.a(ListValue.n(), extensionRegistryLite);
                                if (b3 != null) {
                                    b3.b((ListValue.Builder) this.f18735g);
                                    this.f18735g = b3.T();
                                }
                                this.f18734f = 6;
                            }
                        }
                        r6 = true;
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
                if (f18733e == null) {
                    synchronized (Value.class) {
                        if (f18733e == null) {
                            f18733e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18732d);
                        }
                    }
                }
                return f18733e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18732d;
    }
}
