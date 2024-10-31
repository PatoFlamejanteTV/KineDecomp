package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Property extends GeneratedMessageLite<Property, Builder> implements PropertyOrBuilder {

    /* renamed from: d */
    private static final Property f14523d = new Property();

    /* renamed from: e */
    private static volatile Parser<Property> f14524e;

    /* renamed from: g */
    private int f14526g;

    /* renamed from: f */
    private String f14525f = "";

    /* renamed from: h */
    private String f14527h = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Property, Builder> implements PropertyOrBuilder {
        /* synthetic */ Builder(M m) {
            this();
        }

        private Builder() {
            super(Property.f14523d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public enum PropertyType implements Internal.EnumLite {
        UNSPECIFIED(0),
        INT64(1),
        BOOL(2),
        STRING(3),
        DOUBLE(4),
        UNRECOGNIZED(-1);

        public static final int BOOL_VALUE = 2;
        public static final int DOUBLE_VALUE = 4;
        public static final int INT64_VALUE = 1;
        public static final int STRING_VALUE = 3;
        public static final int UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<PropertyType> internalValueMap = new N();
        private final int value;

        PropertyType(int i) {
            this.value = i;
        }

        public static PropertyType forNumber(int i) {
            if (i == 0) {
                return UNSPECIFIED;
            }
            if (i == 1) {
                return INT64;
            }
            if (i == 2) {
                return BOOL;
            }
            if (i == 3) {
                return STRING;
            }
            if (i != 4) {
                return null;
            }
            return DOUBLE;
        }

        public static Internal.EnumLiteMap<PropertyType> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static PropertyType valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        f14523d.l();
    }

    private Property() {
    }

    public static Parser<Property> p() {
        return f14523d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14525f.isEmpty()) {
            codedOutputStream.b(1, o());
        }
        if (this.f14526g != PropertyType.UNSPECIFIED.getNumber()) {
            codedOutputStream.e(2, this.f14526g);
        }
        if (this.f14527h.isEmpty()) {
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
        int a2 = this.f14525f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, o());
        if (this.f14526g != PropertyType.UNSPECIFIED.getNumber()) {
            a2 += CodedOutputStream.a(2, this.f14526g);
        }
        if (!this.f14527h.isEmpty()) {
            a2 += CodedOutputStream.a(3, n());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f14527h;
    }

    public String o() {
        return this.f14525f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (M.f14472a[methodToInvoke.ordinal()]) {
            case 1:
                return new Property();
            case 2:
                return f14523d;
            case 3:
                return null;
            case 4:
                return new Builder(null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Property property = (Property) obj2;
                this.f14525f = visitor.a(!this.f14525f.isEmpty(), this.f14525f, !property.f14525f.isEmpty(), property.f14525f);
                this.f14526g = visitor.a(this.f14526g != 0, this.f14526g, property.f14526g != 0, property.f14526g);
                this.f14527h = visitor.a(!this.f14527h.isEmpty(), this.f14527h, !property.f14527h.isEmpty(), property.f14527h);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f14525f = codedInputStream.w();
                            } else if (x == 16) {
                                this.f14526g = codedInputStream.f();
                            } else if (x != 26) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f14527h = codedInputStream.w();
                            }
                        }
                        r1 = true;
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
                if (f14524e == null) {
                    synchronized (Property.class) {
                        if (f14524e == null) {
                            f14524e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14523d);
                        }
                    }
                }
                return f14524e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14523d;
    }
}
