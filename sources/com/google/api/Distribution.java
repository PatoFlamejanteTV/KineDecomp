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
public final class Distribution extends GeneratedMessageLite<Distribution, Builder> implements DistributionOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Distribution f14388d = new Distribution();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Distribution> f14389e;

    /* renamed from: f, reason: collision with root package name */
    private int f14390f;

    /* renamed from: g, reason: collision with root package name */
    private long f14391g;

    /* renamed from: h, reason: collision with root package name */
    private double f14392h;
    private double i;
    private Range j;
    private BucketOptions k;
    private Internal.LongList l = GeneratedMessageLite.j();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface BucketOptionsOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Distribution, Builder> implements DistributionOrBuilder {
        /* synthetic */ Builder(C1478p c1478p) {
            this();
        }

        private Builder() {
            super(Distribution.f14388d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface RangeOrBuilder extends MessageLiteOrBuilder {
    }

    static {
        f14388d.l();
    }

    private Distribution() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        d();
        long j = this.f14391g;
        if (j != 0) {
            codedOutputStream.e(1, j);
        }
        double d2 = this.f14392h;
        if (d2 != 0.0d) {
            codedOutputStream.b(2, d2);
        }
        double d3 = this.i;
        if (d3 != 0.0d) {
            codedOutputStream.b(3, d3);
        }
        if (this.j != null) {
            codedOutputStream.c(4, p());
        }
        if (this.k != null) {
            codedOutputStream.c(6, o());
        }
        for (int i = 0; i < this.l.size(); i++) {
            codedOutputStream.e(7, this.l.getLong(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        long j = this.f14391g;
        int b2 = j != 0 ? CodedOutputStream.b(1, j) + 0 : 0;
        double d2 = this.f14392h;
        if (d2 != 0.0d) {
            b2 += CodedOutputStream.a(2, d2);
        }
        double d3 = this.i;
        if (d3 != 0.0d) {
            b2 += CodedOutputStream.a(3, d3);
        }
        if (this.j != null) {
            b2 += CodedOutputStream.a(4, p());
        }
        if (this.k != null) {
            b2 += CodedOutputStream.a(6, o());
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            i2 += CodedOutputStream.b(this.l.getLong(i3));
        }
        int size = b2 + i2 + (n().size() * 1);
        this.f18584c = size;
        return size;
    }

    public List<Long> n() {
        return this.l;
    }

    public BucketOptions o() {
        BucketOptions bucketOptions = this.k;
        return bucketOptions == null ? BucketOptions.n() : bucketOptions;
    }

    public Range p() {
        Range range = this.j;
        return range == null ? Range.n() : range;
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class BucketOptions extends GeneratedMessageLite<BucketOptions, Builder> implements BucketOptionsOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final BucketOptions f14393d = new BucketOptions();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<BucketOptions> f14394e;

        /* renamed from: f, reason: collision with root package name */
        private int f14395f = 0;

        /* renamed from: g, reason: collision with root package name */
        private Object f14396g;

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<BucketOptions, Builder> implements BucketOptionsOrBuilder {
            /* synthetic */ Builder(C1478p c1478p) {
                this();
            }

            private Builder() {
                super(BucketOptions.f14393d);
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public interface ExplicitOrBuilder extends MessageLiteOrBuilder {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public interface ExponentialOrBuilder extends MessageLiteOrBuilder {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public interface LinearOrBuilder extends MessageLiteOrBuilder {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public enum OptionsCase implements Internal.EnumLite {
            LINEAR_BUCKETS(1),
            EXPONENTIAL_BUCKETS(2),
            EXPLICIT_BUCKETS(3),
            OPTIONS_NOT_SET(0);

            private final int value;

            OptionsCase(int i) {
                this.value = i;
            }

            public static OptionsCase forNumber(int i) {
                if (i == 0) {
                    return OPTIONS_NOT_SET;
                }
                if (i == 1) {
                    return LINEAR_BUCKETS;
                }
                if (i == 2) {
                    return EXPONENTIAL_BUCKETS;
                }
                if (i != 3) {
                    return null;
                }
                return EXPLICIT_BUCKETS;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static OptionsCase valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            f14393d.l();
        }

        private BucketOptions() {
        }

        public static BucketOptions n() {
            return f14393d;
        }

        public static Parser<BucketOptions> p() {
            return f14393d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f14395f == 1) {
                codedOutputStream.c(1, (Linear) this.f14396g);
            }
            if (this.f14395f == 2) {
                codedOutputStream.c(2, (Exponential) this.f14396g);
            }
            if (this.f14395f == 3) {
                codedOutputStream.c(3, (Explicit) this.f14396g);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f14395f == 1 ? 0 + CodedOutputStream.a(1, (Linear) this.f14396g) : 0;
            if (this.f14395f == 2) {
                a2 += CodedOutputStream.a(2, (Exponential) this.f14396g);
            }
            if (this.f14395f == 3) {
                a2 += CodedOutputStream.a(3, (Explicit) this.f14396g);
            }
            this.f18584c = a2;
            return a2;
        }

        public OptionsCase o() {
            return OptionsCase.forNumber(this.f14395f);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Explicit extends GeneratedMessageLite<Explicit, Builder> implements ExplicitOrBuilder {

            /* renamed from: d, reason: collision with root package name */
            private static final Explicit f14397d = new Explicit();

            /* renamed from: e, reason: collision with root package name */
            private static volatile Parser<Explicit> f14398e;

            /* renamed from: f, reason: collision with root package name */
            private Internal.DoubleList f14399f = GeneratedMessageLite.h();

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Explicit, Builder> implements ExplicitOrBuilder {
                /* synthetic */ Builder(C1478p c1478p) {
                    this();
                }

                private Builder() {
                    super(Explicit.f14397d);
                }
            }

            static {
                f14397d.l();
            }

            private Explicit() {
            }

            public static Parser<Explicit> o() {
                return f14397d.f();
            }

            @Override // com.google.protobuf.MessageLite
            public void a(CodedOutputStream codedOutputStream) throws IOException {
                d();
                for (int i = 0; i < this.f14399f.size(); i++) {
                    codedOutputStream.b(1, this.f14399f.getDouble(i));
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int d() {
                int i = this.f18584c;
                if (i != -1) {
                    return i;
                }
                int size = (n().size() * 8) + 0 + (n().size() * 1);
                this.f18584c = size;
                return size;
            }

            public List<Double> n() {
                return this.f14399f;
            }

            /* JADX WARN: Type inference failed for: r6v11, types: [com.google.protobuf.Internal$DoubleList] */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                C1478p c1478p = null;
                switch (C1478p.f15032a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Explicit();
                    case 2:
                        return f14397d;
                    case 3:
                        this.f14399f.L();
                        return null;
                    case 4:
                        return new Builder(c1478p);
                    case 5:
                        this.f14399f = ((GeneratedMessageLite.Visitor) obj).a(this.f14399f, ((Explicit) obj2).f14399f);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        boolean z = false;
                        while (!z) {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x == 9) {
                                        if (!this.f14399f.M()) {
                                            this.f14399f = GeneratedMessageLite.a(this.f14399f);
                                        }
                                        this.f14399f.a(codedInputStream.e());
                                    } else if (x != 10) {
                                        if (!codedInputStream.f(x)) {
                                        }
                                    } else {
                                        int o = codedInputStream.o();
                                        int d2 = codedInputStream.d(o);
                                        if (!this.f14399f.M() && codedInputStream.a() > 0) {
                                            this.f14399f = this.f14399f.h2(this.f14399f.size() + (o / 8));
                                        }
                                        while (codedInputStream.a() > 0) {
                                            this.f14399f.a(codedInputStream.e());
                                        }
                                        codedInputStream.c(d2);
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
                        if (f14398e == null) {
                            synchronized (Explicit.class) {
                                if (f14398e == null) {
                                    f14398e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14397d);
                                }
                            }
                        }
                        return f14398e;
                    default:
                        throw new UnsupportedOperationException();
                }
                return f14397d;
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Exponential extends GeneratedMessageLite<Exponential, Builder> implements ExponentialOrBuilder {

            /* renamed from: d, reason: collision with root package name */
            private static final Exponential f14400d = new Exponential();

            /* renamed from: e, reason: collision with root package name */
            private static volatile Parser<Exponential> f14401e;

            /* renamed from: f, reason: collision with root package name */
            private int f14402f;

            /* renamed from: g, reason: collision with root package name */
            private double f14403g;

            /* renamed from: h, reason: collision with root package name */
            private double f14404h;

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Exponential, Builder> implements ExponentialOrBuilder {
                /* synthetic */ Builder(C1478p c1478p) {
                    this();
                }

                private Builder() {
                    super(Exponential.f14400d);
                }
            }

            static {
                f14400d.l();
            }

            private Exponential() {
            }

            public static Parser<Exponential> n() {
                return f14400d.f();
            }

            @Override // com.google.protobuf.MessageLite
            public void a(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.f14402f;
                if (i != 0) {
                    codedOutputStream.g(1, i);
                }
                double d2 = this.f14403g;
                if (d2 != 0.0d) {
                    codedOutputStream.b(2, d2);
                }
                double d3 = this.f14404h;
                if (d3 != 0.0d) {
                    codedOutputStream.b(3, d3);
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int d() {
                int i = this.f18584c;
                if (i != -1) {
                    return i;
                }
                int i2 = this.f14402f;
                int c2 = i2 != 0 ? 0 + CodedOutputStream.c(1, i2) : 0;
                double d2 = this.f14403g;
                if (d2 != 0.0d) {
                    c2 += CodedOutputStream.a(2, d2);
                }
                double d3 = this.f14404h;
                if (d3 != 0.0d) {
                    c2 += CodedOutputStream.a(3, d3);
                }
                this.f18584c = c2;
                return c2;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                C1478p c1478p = null;
                boolean z = false;
                switch (C1478p.f15032a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Exponential();
                    case 2:
                        return f14400d;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(c1478p);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        Exponential exponential = (Exponential) obj2;
                        this.f14402f = visitor.a(this.f14402f != 0, this.f14402f, exponential.f14402f != 0, exponential.f14402f);
                        this.f14403g = visitor.a(this.f14403g != 0.0d, this.f14403g, exponential.f14403g != 0.0d, exponential.f14403g);
                        this.f14404h = visitor.a(this.f14404h != 0.0d, this.f14404h, exponential.f14404h != 0.0d, exponential.f14404h);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        while (!z) {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x == 8) {
                                        this.f14402f = codedInputStream.j();
                                    } else if (x == 17) {
                                        this.f14403g = codedInputStream.e();
                                    } else if (x != 25) {
                                        if (!codedInputStream.f(x)) {
                                        }
                                    } else {
                                        this.f14404h = codedInputStream.e();
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
                        if (f14401e == null) {
                            synchronized (Exponential.class) {
                                if (f14401e == null) {
                                    f14401e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14400d);
                                }
                            }
                        }
                        return f14401e;
                    default:
                        throw new UnsupportedOperationException();
                }
                return f14400d;
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Linear extends GeneratedMessageLite<Linear, Builder> implements LinearOrBuilder {

            /* renamed from: d, reason: collision with root package name */
            private static final Linear f14405d = new Linear();

            /* renamed from: e, reason: collision with root package name */
            private static volatile Parser<Linear> f14406e;

            /* renamed from: f, reason: collision with root package name */
            private int f14407f;

            /* renamed from: g, reason: collision with root package name */
            private double f14408g;

            /* renamed from: h, reason: collision with root package name */
            private double f14409h;

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Linear, Builder> implements LinearOrBuilder {
                /* synthetic */ Builder(C1478p c1478p) {
                    this();
                }

                private Builder() {
                    super(Linear.f14405d);
                }
            }

            static {
                f14405d.l();
            }

            private Linear() {
            }

            public static Parser<Linear> n() {
                return f14405d.f();
            }

            @Override // com.google.protobuf.MessageLite
            public void a(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.f14407f;
                if (i != 0) {
                    codedOutputStream.g(1, i);
                }
                double d2 = this.f14408g;
                if (d2 != 0.0d) {
                    codedOutputStream.b(2, d2);
                }
                double d3 = this.f14409h;
                if (d3 != 0.0d) {
                    codedOutputStream.b(3, d3);
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int d() {
                int i = this.f18584c;
                if (i != -1) {
                    return i;
                }
                int i2 = this.f14407f;
                int c2 = i2 != 0 ? 0 + CodedOutputStream.c(1, i2) : 0;
                double d2 = this.f14408g;
                if (d2 != 0.0d) {
                    c2 += CodedOutputStream.a(2, d2);
                }
                double d3 = this.f14409h;
                if (d3 != 0.0d) {
                    c2 += CodedOutputStream.a(3, d3);
                }
                this.f18584c = c2;
                return c2;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                C1478p c1478p = null;
                boolean z = false;
                switch (C1478p.f15032a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Linear();
                    case 2:
                        return f14405d;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(c1478p);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        Linear linear = (Linear) obj2;
                        this.f14407f = visitor.a(this.f14407f != 0, this.f14407f, linear.f14407f != 0, linear.f14407f);
                        this.f14408g = visitor.a(this.f14408g != 0.0d, this.f14408g, linear.f14408g != 0.0d, linear.f14408g);
                        this.f14409h = visitor.a(this.f14409h != 0.0d, this.f14409h, linear.f14409h != 0.0d, linear.f14409h);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        while (!z) {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x == 8) {
                                        this.f14407f = codedInputStream.j();
                                    } else if (x == 17) {
                                        this.f14408g = codedInputStream.e();
                                    } else if (x != 25) {
                                        if (!codedInputStream.f(x)) {
                                        }
                                    } else {
                                        this.f14409h = codedInputStream.e();
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
                        if (f14406e == null) {
                            synchronized (Linear.class) {
                                if (f14406e == null) {
                                    f14406e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14405d);
                                }
                            }
                        }
                        return f14406e;
                    default:
                        throw new UnsupportedOperationException();
                }
                return f14405d;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i;
            C1478p c1478p = null;
            switch (C1478p.f15032a[methodToInvoke.ordinal()]) {
                case 1:
                    return new BucketOptions();
                case 2:
                    return f14393d;
                case 3:
                    return null;
                case 4:
                    return new Builder(c1478p);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    BucketOptions bucketOptions = (BucketOptions) obj2;
                    int i2 = C1478p.f15033b[bucketOptions.o().ordinal()];
                    if (i2 == 1) {
                        this.f14396g = visitor.e(this.f14395f == 1, this.f14396g, bucketOptions.f14396g);
                    } else if (i2 == 2) {
                        this.f14396g = visitor.e(this.f14395f == 2, this.f14396g, bucketOptions.f14396g);
                    } else if (i2 == 3) {
                        this.f14396g = visitor.e(this.f14395f == 3, this.f14396g, bucketOptions.f14396g);
                    } else if (i2 == 4) {
                        visitor.a(this.f14395f != 0);
                    }
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a && (i = bucketOptions.f14395f) != 0) {
                        this.f14395f = i;
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
                                    Linear.Builder b2 = this.f14395f == 1 ? ((Linear) this.f14396g).b() : null;
                                    this.f14396g = codedInputStream.a(Linear.n(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((Linear.Builder) this.f14396g);
                                        this.f14396g = b2.T();
                                    }
                                    this.f14395f = 1;
                                } else if (x == 18) {
                                    Exponential.Builder b3 = this.f14395f == 2 ? ((Exponential) this.f14396g).b() : null;
                                    this.f14396g = codedInputStream.a(Exponential.n(), extensionRegistryLite);
                                    if (b3 != null) {
                                        b3.b((Exponential.Builder) this.f14396g);
                                        this.f14396g = b3.T();
                                    }
                                    this.f14395f = 2;
                                } else if (x != 26) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    Explicit.Builder b4 = this.f14395f == 3 ? ((Explicit) this.f14396g).b() : null;
                                    this.f14396g = codedInputStream.a(Explicit.o(), extensionRegistryLite);
                                    if (b4 != null) {
                                        b4.b((Explicit.Builder) this.f14396g);
                                        this.f14396g = b4.T();
                                    }
                                    this.f14395f = 3;
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
                    if (f14394e == null) {
                        synchronized (BucketOptions.class) {
                            if (f14394e == null) {
                                f14394e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14393d);
                            }
                        }
                    }
                    return f14394e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f14393d;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Range extends GeneratedMessageLite<Range, Builder> implements RangeOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final Range f14410d = new Range();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<Range> f14411e;

        /* renamed from: f, reason: collision with root package name */
        private double f14412f;

        /* renamed from: g, reason: collision with root package name */
        private double f14413g;

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Range, Builder> implements RangeOrBuilder {
            /* synthetic */ Builder(C1478p c1478p) {
                this();
            }

            private Builder() {
                super(Range.f14410d);
            }
        }

        static {
            f14410d.l();
        }

        private Range() {
        }

        public static Range n() {
            return f14410d;
        }

        public static Parser<Range> o() {
            return f14410d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            double d2 = this.f14412f;
            if (d2 != 0.0d) {
                codedOutputStream.b(1, d2);
            }
            double d3 = this.f14413g;
            if (d3 != 0.0d) {
                codedOutputStream.b(2, d3);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            double d2 = this.f14412f;
            int a2 = d2 != 0.0d ? 0 + CodedOutputStream.a(1, d2) : 0;
            double d3 = this.f14413g;
            if (d3 != 0.0d) {
                a2 += CodedOutputStream.a(2, d3);
            }
            this.f18584c = a2;
            return a2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C1478p c1478p = null;
            boolean z = false;
            switch (C1478p.f15032a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Range();
                case 2:
                    return f14410d;
                case 3:
                    return null;
                case 4:
                    return new Builder(c1478p);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Range range = (Range) obj2;
                    this.f14412f = visitor.a(this.f14412f != 0.0d, this.f14412f, range.f14412f != 0.0d, range.f14412f);
                    this.f14413g = visitor.a(this.f14413g != 0.0d, this.f14413g, range.f14413g != 0.0d, range.f14413g);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 9) {
                                    this.f14412f = codedInputStream.e();
                                } else if (x != 17) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f14413g = codedInputStream.e();
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
                    if (f14411e == null) {
                        synchronized (Range.class) {
                            if (f14411e == null) {
                                f14411e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14410d);
                            }
                        }
                    }
                    return f14411e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f14410d;
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1478p c1478p = null;
        boolean z = false;
        switch (C1478p.f15032a[methodToInvoke.ordinal()]) {
            case 1:
                return new Distribution();
            case 2:
                return f14388d;
            case 3:
                this.l.L();
                return null;
            case 4:
                return new Builder(c1478p);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Distribution distribution = (Distribution) obj2;
                this.f14391g = visitor.a(this.f14391g != 0, this.f14391g, distribution.f14391g != 0, distribution.f14391g);
                this.f14392h = visitor.a(this.f14392h != 0.0d, this.f14392h, distribution.f14392h != 0.0d, distribution.f14392h);
                this.i = visitor.a(this.i != 0.0d, this.i, distribution.i != 0.0d, distribution.i);
                this.j = (Range) visitor.a(this.j, distribution.j);
                this.k = (BucketOptions) visitor.a(this.k, distribution.k);
                this.l = visitor.a(this.l, distribution.l);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14390f |= distribution.f14390f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 8) {
                                this.f14391g = codedInputStream.k();
                            } else if (x == 17) {
                                this.f14392h = codedInputStream.e();
                            } else if (x == 25) {
                                this.i = codedInputStream.e();
                            } else if (x == 34) {
                                Range.Builder b2 = this.j != null ? this.j.b() : null;
                                this.j = (Range) codedInputStream.a(Range.o(), extensionRegistryLite);
                                if (b2 != null) {
                                    b2.b((Range.Builder) this.j);
                                    this.j = b2.T();
                                }
                            } else if (x == 50) {
                                BucketOptions.Builder b3 = this.k != null ? this.k.b() : null;
                                this.k = (BucketOptions) codedInputStream.a(BucketOptions.p(), extensionRegistryLite);
                                if (b3 != null) {
                                    b3.b((BucketOptions.Builder) this.k);
                                    this.k = b3.T();
                                }
                            } else if (x == 56) {
                                if (!this.l.M()) {
                                    this.l = GeneratedMessageLite.a(this.l);
                                }
                                this.l.g(codedInputStream.k());
                            } else if (x != 58) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                int d2 = codedInputStream.d(codedInputStream.o());
                                if (!this.l.M() && codedInputStream.a() > 0) {
                                    this.l = GeneratedMessageLite.a(this.l);
                                }
                                while (codedInputStream.a() > 0) {
                                    this.l.g(codedInputStream.k());
                                }
                                codedInputStream.c(d2);
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
                if (f14389e == null) {
                    synchronized (Distribution.class) {
                        if (f14389e == null) {
                            f14389e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14388d);
                        }
                    }
                }
                return f14389e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14388d;
    }
}
