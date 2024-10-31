package com.google.api;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class MetricDescriptor extends GeneratedMessageLite<MetricDescriptor, Builder> implements MetricDescriptorOrBuilder {

    /* renamed from: d */
    private static final MetricDescriptor f14479d = new MetricDescriptor();

    /* renamed from: e */
    private static volatile Parser<MetricDescriptor> f14480e;

    /* renamed from: f */
    private int f14481f;
    private int j;
    private int k;

    /* renamed from: g */
    private String f14482g = "";

    /* renamed from: h */
    private String f14483h = "";
    private Internal.ProtobufList<LabelDescriptor> i = GeneratedMessageLite.k();
    private String l = "";
    private String m = "";
    private String n = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<MetricDescriptor, Builder> implements MetricDescriptorOrBuilder {
        /* synthetic */ Builder(C c2) {
            this();
        }

        private Builder() {
            super(MetricDescriptor.f14479d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public enum MetricKind implements Internal.EnumLite {
        METRIC_KIND_UNSPECIFIED(0),
        GAUGE(1),
        DELTA(2),
        CUMULATIVE(3),
        UNRECOGNIZED(-1);

        public static final int CUMULATIVE_VALUE = 3;
        public static final int DELTA_VALUE = 2;
        public static final int GAUGE_VALUE = 1;
        public static final int METRIC_KIND_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<MetricKind> internalValueMap = new D();
        private final int value;

        MetricKind(int i) {
            this.value = i;
        }

        public static MetricKind forNumber(int i) {
            if (i == 0) {
                return METRIC_KIND_UNSPECIFIED;
            }
            if (i == 1) {
                return GAUGE;
            }
            if (i == 2) {
                return DELTA;
            }
            if (i != 3) {
                return null;
            }
            return CUMULATIVE;
        }

        public static Internal.EnumLiteMap<MetricKind> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static MetricKind valueOf(int i) {
            return forNumber(i);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public enum ValueType implements Internal.EnumLite {
        VALUE_TYPE_UNSPECIFIED(0),
        BOOL(1),
        INT64(2),
        DOUBLE(3),
        STRING(4),
        DISTRIBUTION(5),
        MONEY(6),
        UNRECOGNIZED(-1);

        public static final int BOOL_VALUE = 1;
        public static final int DISTRIBUTION_VALUE = 5;
        public static final int DOUBLE_VALUE = 3;
        public static final int INT64_VALUE = 2;
        public static final int MONEY_VALUE = 6;
        public static final int STRING_VALUE = 4;
        public static final int VALUE_TYPE_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<ValueType> internalValueMap = new E();
        private final int value;

        ValueType(int i) {
            this.value = i;
        }

        public static ValueType forNumber(int i) {
            switch (i) {
                case 0:
                    return VALUE_TYPE_UNSPECIFIED;
                case 1:
                    return BOOL;
                case 2:
                    return INT64;
                case 3:
                    return DOUBLE;
                case 4:
                    return STRING;
                case 5:
                    return DISTRIBUTION;
                case 6:
                    return MONEY;
                default:
                    return null;
            }
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
        f14479d.l();
    }

    private MetricDescriptor() {
    }

    public static Parser<MetricDescriptor> s() {
        return f14479d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14482g.isEmpty()) {
            codedOutputStream.b(1, p());
        }
        for (int i = 0; i < this.i.size(); i++) {
            codedOutputStream.c(2, this.i.get(i));
        }
        if (this.j != MetricKind.METRIC_KIND_UNSPECIFIED.getNumber()) {
            codedOutputStream.e(3, this.j);
        }
        if (this.k != ValueType.VALUE_TYPE_UNSPECIFIED.getNumber()) {
            codedOutputStream.e(4, this.k);
        }
        if (!this.l.isEmpty()) {
            codedOutputStream.b(5, r());
        }
        if (!this.m.isEmpty()) {
            codedOutputStream.b(6, n());
        }
        if (!this.n.isEmpty()) {
            codedOutputStream.b(7, o());
        }
        if (this.f14483h.isEmpty()) {
            return;
        }
        codedOutputStream.b(8, q());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f14482g.isEmpty() ? CodedOutputStream.a(1, p()) + 0 : 0;
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            a2 += CodedOutputStream.a(2, this.i.get(i2));
        }
        if (this.j != MetricKind.METRIC_KIND_UNSPECIFIED.getNumber()) {
            a2 += CodedOutputStream.a(3, this.j);
        }
        if (this.k != ValueType.VALUE_TYPE_UNSPECIFIED.getNumber()) {
            a2 += CodedOutputStream.a(4, this.k);
        }
        if (!this.l.isEmpty()) {
            a2 += CodedOutputStream.a(5, r());
        }
        if (!this.m.isEmpty()) {
            a2 += CodedOutputStream.a(6, n());
        }
        if (!this.n.isEmpty()) {
            a2 += CodedOutputStream.a(7, o());
        }
        if (!this.f14483h.isEmpty()) {
            a2 += CodedOutputStream.a(8, q());
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.m;
    }

    public String o() {
        return this.n;
    }

    public String p() {
        return this.f14482g;
    }

    public String q() {
        return this.f14483h;
    }

    public String r() {
        return this.l;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (C.f14367a[methodToInvoke.ordinal()]) {
            case 1:
                return new MetricDescriptor();
            case 2:
                return f14479d;
            case 3:
                this.i.L();
                return null;
            case 4:
                return new Builder(null);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                MetricDescriptor metricDescriptor = (MetricDescriptor) obj2;
                this.f14482g = visitor.a(!this.f14482g.isEmpty(), this.f14482g, !metricDescriptor.f14482g.isEmpty(), metricDescriptor.f14482g);
                this.f14483h = visitor.a(!this.f14483h.isEmpty(), this.f14483h, !metricDescriptor.f14483h.isEmpty(), metricDescriptor.f14483h);
                this.i = visitor.a(this.i, metricDescriptor.i);
                this.j = visitor.a(this.j != 0, this.j, metricDescriptor.j != 0, metricDescriptor.j);
                this.k = visitor.a(this.k != 0, this.k, metricDescriptor.k != 0, metricDescriptor.k);
                this.l = visitor.a(!this.l.isEmpty(), this.l, !metricDescriptor.l.isEmpty(), metricDescriptor.l);
                this.m = visitor.a(!this.m.isEmpty(), this.m, !metricDescriptor.m.isEmpty(), metricDescriptor.m);
                this.n = visitor.a(!this.n.isEmpty(), this.n, !metricDescriptor.n.isEmpty(), metricDescriptor.n);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14481f |= metricDescriptor.f14481f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f14482g = codedInputStream.w();
                            } else if (x == 18) {
                                if (!this.i.M()) {
                                    this.i = GeneratedMessageLite.a(this.i);
                                }
                                this.i.add((LabelDescriptor) codedInputStream.a(LabelDescriptor.p(), extensionRegistryLite));
                            } else if (x == 24) {
                                this.j = codedInputStream.f();
                            } else if (x == 32) {
                                this.k = codedInputStream.f();
                            } else if (x == 42) {
                                this.l = codedInputStream.w();
                            } else if (x == 50) {
                                this.m = codedInputStream.w();
                            } else if (x == 58) {
                                this.n = codedInputStream.w();
                            } else if (x != 66) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f14483h = codedInputStream.w();
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
                if (f14480e == null) {
                    synchronized (MetricDescriptor.class) {
                        if (f14480e == null) {
                            f14480e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14479d);
                        }
                    }
                }
                return f14480e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14479d;
    }
}
