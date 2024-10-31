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
public final class LabelDescriptor extends GeneratedMessageLite<LabelDescriptor, Builder> implements LabelDescriptorOrBuilder {

    /* renamed from: d */
    private static final LabelDescriptor f14453d = new LabelDescriptor();

    /* renamed from: e */
    private static volatile Parser<LabelDescriptor> f14454e;

    /* renamed from: g */
    private int f14456g;

    /* renamed from: f */
    private String f14455f = "";

    /* renamed from: h */
    private String f14457h = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<LabelDescriptor, Builder> implements LabelDescriptorOrBuilder {
        /* synthetic */ Builder(C1485x c1485x) {
            this();
        }

        private Builder() {
            super(LabelDescriptor.f14453d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public enum ValueType implements Internal.EnumLite {
        STRING(0),
        BOOL(1),
        INT64(2),
        UNRECOGNIZED(-1);

        public static final int BOOL_VALUE = 1;
        public static final int INT64_VALUE = 2;
        public static final int STRING_VALUE = 0;
        private static final Internal.EnumLiteMap<ValueType> internalValueMap = new y();
        private final int value;

        ValueType(int i) {
            this.value = i;
        }

        public static ValueType forNumber(int i) {
            if (i == 0) {
                return STRING;
            }
            if (i == 1) {
                return BOOL;
            }
            if (i != 2) {
                return null;
            }
            return INT64;
        }

        public static Internal.EnumLiteMap<ValueType> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ValueType valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        f14453d.l();
    }

    private LabelDescriptor() {
    }

    public static Parser<LabelDescriptor> p() {
        return f14453d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14455f.isEmpty()) {
            codedOutputStream.b(1, o());
        }
        if (this.f14456g != ValueType.STRING.getNumber()) {
            codedOutputStream.e(2, this.f14456g);
        }
        if (this.f14457h.isEmpty()) {
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
        int a2 = this.f14455f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, o());
        if (this.f14456g != ValueType.STRING.getNumber()) {
            a2 += CodedOutputStream.a(2, this.f14456g);
        }
        if (!this.f14457h.isEmpty()) {
            a2 += CodedOutputStream.a(3, n());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f14457h;
    }

    public String o() {
        return this.f14455f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C1485x.f15043a[methodToInvoke.ordinal()]) {
            case 1:
                return new LabelDescriptor();
            case 2:
                return f14453d;
            case 3:
                return null;
            case 4:
                return new Builder(null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                LabelDescriptor labelDescriptor = (LabelDescriptor) obj2;
                this.f14455f = visitor.a(!this.f14455f.isEmpty(), this.f14455f, !labelDescriptor.f14455f.isEmpty(), labelDescriptor.f14455f);
                this.f14456g = visitor.a(this.f14456g != 0, this.f14456g, labelDescriptor.f14456g != 0, labelDescriptor.f14456g);
                this.f14457h = visitor.a(!this.f14457h.isEmpty(), this.f14457h, !labelDescriptor.f14457h.isEmpty(), labelDescriptor.f14457h);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f14455f = codedInputStream.w();
                            } else if (x == 16) {
                                this.f14456g = codedInputStream.f();
                            } else if (x != 26) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f14457h = codedInputStream.w();
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
                if (f14454e == null) {
                    synchronized (LabelDescriptor.class) {
                        if (f14454e == null) {
                            f14454e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14453d);
                        }
                    }
                }
                return f14454e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14453d;
    }
}
