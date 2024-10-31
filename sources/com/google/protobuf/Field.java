package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Field extends GeneratedMessageLite<Field, Builder> implements FieldOrBuilder {

    /* renamed from: d */
    private static final Field f18567d = new Field();

    /* renamed from: e */
    private static volatile Parser<Field> f18568e;

    /* renamed from: f */
    private int f18569f;

    /* renamed from: g */
    private int f18570g;

    /* renamed from: h */
    private int f18571h;
    private int i;
    private int l;
    private boolean m;
    private String j = "";
    private String k = "";
    private Internal.ProtobufList<Option> n = GeneratedMessageLite.k();
    private String o = "";
    private String p = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Field, Builder> implements FieldOrBuilder {
        /* synthetic */ Builder(C1667v c1667v) {
            this();
        }

        private Builder() {
            super(Field.f18567d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public enum Cardinality implements Internal.EnumLite {
        CARDINALITY_UNKNOWN(0),
        CARDINALITY_OPTIONAL(1),
        CARDINALITY_REQUIRED(2),
        CARDINALITY_REPEATED(3),
        UNRECOGNIZED(-1);

        public static final int CARDINALITY_OPTIONAL_VALUE = 1;
        public static final int CARDINALITY_REPEATED_VALUE = 3;
        public static final int CARDINALITY_REQUIRED_VALUE = 2;
        public static final int CARDINALITY_UNKNOWN_VALUE = 0;
        private static final Internal.EnumLiteMap<Cardinality> internalValueMap = new C1668w();
        private final int value;

        Cardinality(int i) {
            this.value = i;
        }

        public static Cardinality forNumber(int i) {
            if (i == 0) {
                return CARDINALITY_UNKNOWN;
            }
            if (i == 1) {
                return CARDINALITY_OPTIONAL;
            }
            if (i == 2) {
                return CARDINALITY_REQUIRED;
            }
            if (i != 3) {
                return null;
            }
            return CARDINALITY_REPEATED;
        }

        public static Internal.EnumLiteMap<Cardinality> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static Cardinality valueOf(int i) {
            return forNumber(i);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public enum Kind implements Internal.EnumLite {
        TYPE_UNKNOWN(0),
        TYPE_DOUBLE(1),
        TYPE_FLOAT(2),
        TYPE_INT64(3),
        TYPE_UINT64(4),
        TYPE_INT32(5),
        TYPE_FIXED64(6),
        TYPE_FIXED32(7),
        TYPE_BOOL(8),
        TYPE_STRING(9),
        TYPE_GROUP(10),
        TYPE_MESSAGE(11),
        TYPE_BYTES(12),
        TYPE_UINT32(13),
        TYPE_ENUM(14),
        TYPE_SFIXED32(15),
        TYPE_SFIXED64(16),
        TYPE_SINT32(17),
        TYPE_SINT64(18),
        UNRECOGNIZED(-1);

        public static final int TYPE_BOOL_VALUE = 8;
        public static final int TYPE_BYTES_VALUE = 12;
        public static final int TYPE_DOUBLE_VALUE = 1;
        public static final int TYPE_ENUM_VALUE = 14;
        public static final int TYPE_FIXED32_VALUE = 7;
        public static final int TYPE_FIXED64_VALUE = 6;
        public static final int TYPE_FLOAT_VALUE = 2;
        public static final int TYPE_GROUP_VALUE = 10;
        public static final int TYPE_INT32_VALUE = 5;
        public static final int TYPE_INT64_VALUE = 3;
        public static final int TYPE_MESSAGE_VALUE = 11;
        public static final int TYPE_SFIXED32_VALUE = 15;
        public static final int TYPE_SFIXED64_VALUE = 16;
        public static final int TYPE_SINT32_VALUE = 17;
        public static final int TYPE_SINT64_VALUE = 18;
        public static final int TYPE_STRING_VALUE = 9;
        public static final int TYPE_UINT32_VALUE = 13;
        public static final int TYPE_UINT64_VALUE = 4;
        public static final int TYPE_UNKNOWN_VALUE = 0;
        private static final Internal.EnumLiteMap<Kind> internalValueMap = new C1669x();
        private final int value;

        Kind(int i) {
            this.value = i;
        }

        public static Kind forNumber(int i) {
            switch (i) {
                case 0:
                    return TYPE_UNKNOWN;
                case 1:
                    return TYPE_DOUBLE;
                case 2:
                    return TYPE_FLOAT;
                case 3:
                    return TYPE_INT64;
                case 4:
                    return TYPE_UINT64;
                case 5:
                    return TYPE_INT32;
                case 6:
                    return TYPE_FIXED64;
                case 7:
                    return TYPE_FIXED32;
                case 8:
                    return TYPE_BOOL;
                case 9:
                    return TYPE_STRING;
                case 10:
                    return TYPE_GROUP;
                case 11:
                    return TYPE_MESSAGE;
                case 12:
                    return TYPE_BYTES;
                case 13:
                    return TYPE_UINT32;
                case 14:
                    return TYPE_ENUM;
                case 15:
                    return TYPE_SFIXED32;
                case 16:
                    return TYPE_SFIXED64;
                case 17:
                    return TYPE_SINT32;
                case 18:
                    return TYPE_SINT64;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static Kind valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        f18567d.l();
    }

    private Field() {
    }

    public static Parser<Field> r() {
        return f18567d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f18570g != Kind.TYPE_UNKNOWN.getNumber()) {
            codedOutputStream.e(1, this.f18570g);
        }
        if (this.f18571h != Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
            codedOutputStream.e(2, this.f18571h);
        }
        int i = this.i;
        if (i != 0) {
            codedOutputStream.g(3, i);
        }
        if (!this.j.isEmpty()) {
            codedOutputStream.b(4, p());
        }
        if (!this.k.isEmpty()) {
            codedOutputStream.b(6, q());
        }
        int i2 = this.l;
        if (i2 != 0) {
            codedOutputStream.g(7, i2);
        }
        boolean z = this.m;
        if (z) {
            codedOutputStream.b(8, z);
        }
        for (int i3 = 0; i3 < this.n.size(); i3++) {
            codedOutputStream.c(9, this.n.get(i3));
        }
        if (!this.o.isEmpty()) {
            codedOutputStream.b(10, o());
        }
        if (this.p.isEmpty()) {
            return;
        }
        codedOutputStream.b(11, n());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18570g != Kind.TYPE_UNKNOWN.getNumber() ? CodedOutputStream.a(1, this.f18570g) + 0 : 0;
        if (this.f18571h != Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
            a2 += CodedOutputStream.a(2, this.f18571h);
        }
        int i2 = this.i;
        if (i2 != 0) {
            a2 += CodedOutputStream.c(3, i2);
        }
        if (!this.j.isEmpty()) {
            a2 += CodedOutputStream.a(4, p());
        }
        if (!this.k.isEmpty()) {
            a2 += CodedOutputStream.a(6, q());
        }
        int i3 = this.l;
        if (i3 != 0) {
            a2 += CodedOutputStream.c(7, i3);
        }
        boolean z = this.m;
        if (z) {
            a2 += CodedOutputStream.a(8, z);
        }
        for (int i4 = 0; i4 < this.n.size(); i4++) {
            a2 += CodedOutputStream.a(9, this.n.get(i4));
        }
        if (!this.o.isEmpty()) {
            a2 += CodedOutputStream.a(10, o());
        }
        if (!this.p.isEmpty()) {
            a2 += CodedOutputStream.a(11, n());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.p;
    }

    public String o() {
        return this.o;
    }

    public String p() {
        return this.j;
    }

    public String q() {
        return this.k;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C1667v.f18799a[methodToInvoke.ordinal()]) {
            case 1:
                return new Field();
            case 2:
                return f18567d;
            case 3:
                this.n.L();
                return null;
            case 4:
                return new Builder(null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Field field = (Field) obj2;
                this.f18570g = visitor.a(this.f18570g != 0, this.f18570g, field.f18570g != 0, field.f18570g);
                this.f18571h = visitor.a(this.f18571h != 0, this.f18571h, field.f18571h != 0, field.f18571h);
                this.i = visitor.a(this.i != 0, this.i, field.i != 0, field.i);
                this.j = visitor.a(!this.j.isEmpty(), this.j, !field.j.isEmpty(), field.j);
                this.k = visitor.a(!this.k.isEmpty(), this.k, !field.k.isEmpty(), field.k);
                this.l = visitor.a(this.l != 0, this.l, field.l != 0, field.l);
                boolean z = this.m;
                boolean z2 = field.m;
                this.m = visitor.a(z, z, z2, z2);
                this.n = visitor.a(this.n, field.n);
                this.o = visitor.a(!this.o.isEmpty(), this.o, !field.o.isEmpty(), field.o);
                this.p = visitor.a(!this.p.isEmpty(), this.p, !field.p.isEmpty(), field.p);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f18569f |= field.f18569f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        switch (x) {
                            case 0:
                                r1 = true;
                            case 8:
                                this.f18570g = codedInputStream.f();
                            case 16:
                                this.f18571h = codedInputStream.f();
                            case 24:
                                this.i = codedInputStream.j();
                            case 34:
                                this.j = codedInputStream.w();
                            case 50:
                                this.k = codedInputStream.w();
                            case 56:
                                this.l = codedInputStream.j();
                            case 64:
                                this.m = codedInputStream.c();
                            case 74:
                                if (!this.n.M()) {
                                    this.n = GeneratedMessageLite.a(this.n);
                                }
                                this.n.add((Option) codedInputStream.a(Option.p(), extensionRegistryLite));
                            case 82:
                                this.o = codedInputStream.w();
                            case 90:
                                this.p = codedInputStream.w();
                            default:
                                if (!codedInputStream.f(x)) {
                                    r1 = true;
                                }
                        }
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
                if (f18568e == null) {
                    synchronized (Field.class) {
                        if (f18568e == null) {
                            f18568e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18567d);
                        }
                    }
                }
                return f18568e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18567d;
    }
}
