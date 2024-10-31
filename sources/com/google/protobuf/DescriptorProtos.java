package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protos.datapol.SemanticAnnotations;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class DescriptorProtos {

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class DescriptorProto extends GeneratedMessageLite<DescriptorProto, Builder> implements DescriptorProtoOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final DescriptorProto f18419d = new DescriptorProto();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<DescriptorProto> f18420e;

        /* renamed from: f, reason: collision with root package name */
        private int f18421f;
        private MessageOptions n;
        private byte q = -1;

        /* renamed from: g, reason: collision with root package name */
        private String f18422g = "";

        /* renamed from: h, reason: collision with root package name */
        private Internal.ProtobufList<FieldDescriptorProto> f18423h = GeneratedMessageLite.k();
        private Internal.ProtobufList<FieldDescriptorProto> i = GeneratedMessageLite.k();
        private Internal.ProtobufList<DescriptorProto> j = GeneratedMessageLite.k();
        private Internal.ProtobufList<EnumDescriptorProto> k = GeneratedMessageLite.k();
        private Internal.ProtobufList<ExtensionRange> l = GeneratedMessageLite.k();
        private Internal.ProtobufList<OneofDescriptorProto> m = GeneratedMessageLite.k();
        private Internal.ProtobufList<ReservedRange> o = GeneratedMessageLite.k();
        private Internal.ProtobufList<String> p = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DescriptorProto, Builder> implements DescriptorProtoOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(DescriptorProto.f18419d);
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public interface ExtensionRangeOrBuilder extends MessageLiteOrBuilder {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public interface ReservedRangeOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            f18419d.l();
        }

        private DescriptorProto() {
        }

        public static Parser<DescriptorProto> y() {
            return f18419d.f();
        }

        public EnumDescriptorProto a(int i) {
            return this.k.get(i);
        }

        public FieldDescriptorProto b(int i) {
            return this.i.get(i);
        }

        public ExtensionRange c(int i) {
            return this.l.get(i);
        }

        public FieldDescriptorProto d(int i) {
            return this.f18423h.get(i);
        }

        public DescriptorProto e(int i) {
            return this.j.get(i);
        }

        public OneofDescriptorProto f(int i) {
            return this.m.get(i);
        }

        public int n() {
            return this.k.size();
        }

        public int o() {
            return this.i.size();
        }

        public int p() {
            return this.l.size();
        }

        public int q() {
            return this.f18423h.size();
        }

        public String r() {
            return this.f18422g;
        }

        public int s() {
            return this.j.size();
        }

        public int t() {
            return this.m.size();
        }

        public MessageOptions u() {
            MessageOptions messageOptions = this.n;
            return messageOptions == null ? MessageOptions.q() : messageOptions;
        }

        public List<String> v() {
            return this.p;
        }

        public boolean w() {
            return (this.f18421f & 1) == 1;
        }

        public boolean x() {
            return (this.f18421f & 2) == 2;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.f18421f & 1) == 1) {
                codedOutputStream.b(1, r());
            }
            for (int i = 0; i < this.f18423h.size(); i++) {
                codedOutputStream.c(2, this.f18423h.get(i));
            }
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                codedOutputStream.c(3, this.j.get(i2));
            }
            for (int i3 = 0; i3 < this.k.size(); i3++) {
                codedOutputStream.c(4, this.k.get(i3));
            }
            for (int i4 = 0; i4 < this.l.size(); i4++) {
                codedOutputStream.c(5, this.l.get(i4));
            }
            for (int i5 = 0; i5 < this.i.size(); i5++) {
                codedOutputStream.c(6, this.i.get(i5));
            }
            if ((this.f18421f & 2) == 2) {
                codedOutputStream.c(7, u());
            }
            for (int i6 = 0; i6 < this.m.size(); i6++) {
                codedOutputStream.c(8, this.m.get(i6));
            }
            for (int i7 = 0; i7 < this.o.size(); i7++) {
                codedOutputStream.c(9, this.o.get(i7));
            }
            for (int i8 = 0; i8 < this.p.size(); i8++) {
                codedOutputStream.b(10, this.p.get(i8));
            }
            this.f18583b.a(codedOutputStream);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18421f & 1) == 1 ? CodedOutputStream.a(1, r()) + 0 : 0;
            for (int i2 = 0; i2 < this.f18423h.size(); i2++) {
                a2 += CodedOutputStream.a(2, this.f18423h.get(i2));
            }
            for (int i3 = 0; i3 < this.j.size(); i3++) {
                a2 += CodedOutputStream.a(3, this.j.get(i3));
            }
            for (int i4 = 0; i4 < this.k.size(); i4++) {
                a2 += CodedOutputStream.a(4, this.k.get(i4));
            }
            for (int i5 = 0; i5 < this.l.size(); i5++) {
                a2 += CodedOutputStream.a(5, this.l.get(i5));
            }
            for (int i6 = 0; i6 < this.i.size(); i6++) {
                a2 += CodedOutputStream.a(6, this.i.get(i6));
            }
            if ((this.f18421f & 2) == 2) {
                a2 += CodedOutputStream.a(7, u());
            }
            for (int i7 = 0; i7 < this.m.size(); i7++) {
                a2 += CodedOutputStream.a(8, this.m.get(i7));
            }
            for (int i8 = 0; i8 < this.o.size(); i8++) {
                a2 += CodedOutputStream.a(9, this.o.get(i8));
            }
            int i9 = 0;
            for (int i10 = 0; i10 < this.p.size(); i10++) {
                i9 += CodedOutputStream.a(this.p.get(i10));
            }
            int size = a2 + i9 + (v().size() * 1) + this.f18583b.c();
            this.f18584c = size;
            return size;
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class ReservedRange extends GeneratedMessageLite<ReservedRange, Builder> implements ReservedRangeOrBuilder {

            /* renamed from: d, reason: collision with root package name */
            private static final ReservedRange f18429d = new ReservedRange();

            /* renamed from: e, reason: collision with root package name */
            private static volatile Parser<ReservedRange> f18430e;

            /* renamed from: f, reason: collision with root package name */
            private int f18431f;

            /* renamed from: g, reason: collision with root package name */
            private int f18432g;

            /* renamed from: h, reason: collision with root package name */
            private int f18433h;

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<ReservedRange, Builder> implements ReservedRangeOrBuilder {
                /* synthetic */ Builder(C1654h c1654h) {
                    this();
                }

                private Builder() {
                    super(ReservedRange.f18429d);
                }
            }

            static {
                f18429d.l();
            }

            private ReservedRange() {
            }

            public static Parser<ReservedRange> p() {
                return f18429d.f();
            }

            @Override // com.google.protobuf.MessageLite
            public void a(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.f18431f & 1) == 1) {
                    codedOutputStream.g(1, this.f18432g);
                }
                if ((this.f18431f & 2) == 2) {
                    codedOutputStream.g(2, this.f18433h);
                }
                this.f18583b.a(codedOutputStream);
            }

            @Override // com.google.protobuf.MessageLite
            public int d() {
                int i = this.f18584c;
                if (i != -1) {
                    return i;
                }
                int c2 = (this.f18431f & 1) == 1 ? 0 + CodedOutputStream.c(1, this.f18432g) : 0;
                if ((this.f18431f & 2) == 2) {
                    c2 += CodedOutputStream.c(2, this.f18433h);
                }
                int c3 = c2 + this.f18583b.c();
                this.f18584c = c3;
                return c3;
            }

            public boolean n() {
                return (this.f18431f & 2) == 2;
            }

            public boolean o() {
                return (this.f18431f & 1) == 1;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                C1654h c1654h = null;
                switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ReservedRange();
                    case 2:
                        return f18429d;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(c1654h);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        ReservedRange reservedRange = (ReservedRange) obj2;
                        this.f18432g = visitor.a(o(), this.f18432g, reservedRange.o(), reservedRange.f18432g);
                        this.f18433h = visitor.a(n(), this.f18433h, reservedRange.n(), reservedRange.f18433h);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                            this.f18431f |= reservedRange.f18431f;
                        }
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        boolean z = false;
                        while (!z) {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x == 8) {
                                        this.f18431f |= 1;
                                        this.f18432g = codedInputStream.j();
                                    } else if (x != 16) {
                                        if (!a(x, codedInputStream)) {
                                        }
                                    } else {
                                        this.f18431f |= 2;
                                        this.f18433h = codedInputStream.j();
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
                        if (f18430e == null) {
                            synchronized (ReservedRange.class) {
                                if (f18430e == null) {
                                    f18430e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18429d);
                                }
                            }
                        }
                        return f18430e;
                    default:
                        throw new UnsupportedOperationException();
                }
                return f18429d;
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class ExtensionRange extends GeneratedMessageLite<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {

            /* renamed from: d, reason: collision with root package name */
            private static final ExtensionRange f18424d = new ExtensionRange();

            /* renamed from: e, reason: collision with root package name */
            private static volatile Parser<ExtensionRange> f18425e;

            /* renamed from: f, reason: collision with root package name */
            private int f18426f;

            /* renamed from: g, reason: collision with root package name */
            private int f18427g;

            /* renamed from: h, reason: collision with root package name */
            private int f18428h;
            private ExtensionRangeOptions i;
            private byte j = -1;

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {
                /* synthetic */ Builder(C1654h c1654h) {
                    this();
                }

                private Builder() {
                    super(ExtensionRange.f18424d);
                }
            }

            static {
                f18424d.l();
            }

            private ExtensionRange() {
            }

            public static Parser<ExtensionRange> r() {
                return f18424d.f();
            }

            @Override // com.google.protobuf.MessageLite
            public void a(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.f18426f & 1) == 1) {
                    codedOutputStream.g(1, this.f18427g);
                }
                if ((this.f18426f & 2) == 2) {
                    codedOutputStream.g(2, this.f18428h);
                }
                if ((this.f18426f & 4) == 4) {
                    codedOutputStream.c(3, n());
                }
                this.f18583b.a(codedOutputStream);
            }

            @Override // com.google.protobuf.MessageLite
            public int d() {
                int i = this.f18584c;
                if (i != -1) {
                    return i;
                }
                int c2 = (this.f18426f & 1) == 1 ? 0 + CodedOutputStream.c(1, this.f18427g) : 0;
                if ((this.f18426f & 2) == 2) {
                    c2 += CodedOutputStream.c(2, this.f18428h);
                }
                if ((this.f18426f & 4) == 4) {
                    c2 += CodedOutputStream.a(3, n());
                }
                int c3 = c2 + this.f18583b.c();
                this.f18584c = c3;
                return c3;
            }

            public ExtensionRangeOptions n() {
                ExtensionRangeOptions extensionRangeOptions = this.i;
                return extensionRangeOptions == null ? ExtensionRangeOptions.q() : extensionRangeOptions;
            }

            public boolean o() {
                return (this.f18426f & 2) == 2;
            }

            public boolean p() {
                return (this.f18426f & 4) == 4;
            }

            public boolean q() {
                return (this.f18426f & 1) == 1;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                boolean z = false;
                C1654h c1654h = null;
                switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ExtensionRange();
                    case 2:
                        byte b2 = this.j;
                        if (b2 == 1) {
                            return f18424d;
                        }
                        if (b2 == 0) {
                            return null;
                        }
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        if (!p() || n().isInitialized()) {
                            if (booleanValue) {
                                this.j = (byte) 1;
                            }
                            return f18424d;
                        }
                        if (booleanValue) {
                            this.j = (byte) 0;
                        }
                        return null;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(c1654h);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        ExtensionRange extensionRange = (ExtensionRange) obj2;
                        this.f18427g = visitor.a(q(), this.f18427g, extensionRange.q(), extensionRange.f18427g);
                        this.f18428h = visitor.a(o(), this.f18428h, extensionRange.o(), extensionRange.f18428h);
                        this.i = (ExtensionRangeOptions) visitor.a(this.i, extensionRange.i);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                            this.f18426f |= extensionRange.f18426f;
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
                                        this.f18426f |= 1;
                                        this.f18427g = codedInputStream.j();
                                    } else if (x == 16) {
                                        this.f18426f |= 2;
                                        this.f18428h = codedInputStream.j();
                                    } else if (x != 26) {
                                        if (!a(x, codedInputStream)) {
                                        }
                                    } else {
                                        ExtensionRangeOptions.Builder builder = (this.f18426f & 4) == 4 ? (ExtensionRangeOptions.Builder) this.i.b() : null;
                                        this.i = (ExtensionRangeOptions) codedInputStream.a(ExtensionRangeOptions.s(), extensionRegistryLite);
                                        if (builder != null) {
                                            builder.b((ExtensionRangeOptions.Builder) this.i);
                                            this.i = builder.T();
                                        }
                                        this.f18426f |= 4;
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
                        if (f18425e == null) {
                            synchronized (ExtensionRange.class) {
                                if (f18425e == null) {
                                    f18425e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18424d);
                                }
                            }
                        }
                        return f18425e;
                    default:
                        throw new UnsupportedOperationException();
                }
                return f18424d;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C1654h c1654h = null;
            boolean z = false;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new DescriptorProto();
                case 2:
                    byte b2 = this.q;
                    if (b2 == 1) {
                        return f18419d;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < q(); i++) {
                        if (!d(i).isInitialized()) {
                            if (booleanValue) {
                                this.q = (byte) 0;
                            }
                            return null;
                        }
                    }
                    for (int i2 = 0; i2 < o(); i2++) {
                        if (!b(i2).isInitialized()) {
                            if (booleanValue) {
                                this.q = (byte) 0;
                            }
                            return null;
                        }
                    }
                    for (int i3 = 0; i3 < s(); i3++) {
                        if (!e(i3).isInitialized()) {
                            if (booleanValue) {
                                this.q = (byte) 0;
                            }
                            return null;
                        }
                    }
                    for (int i4 = 0; i4 < n(); i4++) {
                        if (!a(i4).isInitialized()) {
                            if (booleanValue) {
                                this.q = (byte) 0;
                            }
                            return null;
                        }
                    }
                    for (int i5 = 0; i5 < p(); i5++) {
                        if (!c(i5).isInitialized()) {
                            if (booleanValue) {
                                this.q = (byte) 0;
                            }
                            return null;
                        }
                    }
                    for (int i6 = 0; i6 < t(); i6++) {
                        if (!f(i6).isInitialized()) {
                            if (booleanValue) {
                                this.q = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (!x() || u().isInitialized()) {
                        if (booleanValue) {
                            this.q = (byte) 1;
                        }
                        return f18419d;
                    }
                    if (booleanValue) {
                        this.q = (byte) 0;
                    }
                    return null;
                case 3:
                    this.f18423h.L();
                    this.i.L();
                    this.j.L();
                    this.k.L();
                    this.l.L();
                    this.m.L();
                    this.o.L();
                    this.p.L();
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    DescriptorProto descriptorProto = (DescriptorProto) obj2;
                    this.f18422g = visitor.a(w(), this.f18422g, descriptorProto.w(), descriptorProto.f18422g);
                    this.f18423h = visitor.a(this.f18423h, descriptorProto.f18423h);
                    this.i = visitor.a(this.i, descriptorProto.i);
                    this.j = visitor.a(this.j, descriptorProto.j);
                    this.k = visitor.a(this.k, descriptorProto.k);
                    this.l = visitor.a(this.l, descriptorProto.l);
                    this.m = visitor.a(this.m, descriptorProto.m);
                    this.n = (MessageOptions) visitor.a(this.n, descriptorProto.n);
                    this.o = visitor.a(this.o, descriptorProto.o);
                    this.p = visitor.a(this.p, descriptorProto.p);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18421f |= descriptorProto.f18421f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            switch (x) {
                                case 0:
                                    z = true;
                                case 10:
                                    String v = codedInputStream.v();
                                    this.f18421f |= 1;
                                    this.f18422g = v;
                                case 18:
                                    if (!this.f18423h.M()) {
                                        this.f18423h = GeneratedMessageLite.a(this.f18423h);
                                    }
                                    this.f18423h.add((FieldDescriptorProto) codedInputStream.a(FieldDescriptorProto.D(), extensionRegistryLite));
                                case 26:
                                    if (!this.j.M()) {
                                        this.j = GeneratedMessageLite.a(this.j);
                                    }
                                    this.j.add((DescriptorProto) codedInputStream.a(y(), extensionRegistryLite));
                                case 34:
                                    if (!this.k.M()) {
                                        this.k = GeneratedMessageLite.a(this.k);
                                    }
                                    this.k.add((EnumDescriptorProto) codedInputStream.a(EnumDescriptorProto.t(), extensionRegistryLite));
                                case 42:
                                    if (!this.l.M()) {
                                        this.l = GeneratedMessageLite.a(this.l);
                                    }
                                    this.l.add((ExtensionRange) codedInputStream.a(ExtensionRange.r(), extensionRegistryLite));
                                case 50:
                                    if (!this.i.M()) {
                                        this.i = GeneratedMessageLite.a(this.i);
                                    }
                                    this.i.add((FieldDescriptorProto) codedInputStream.a(FieldDescriptorProto.D(), extensionRegistryLite));
                                case 58:
                                    MessageOptions.Builder builder = (this.f18421f & 2) == 2 ? (MessageOptions.Builder) this.n.b() : null;
                                    this.n = (MessageOptions) codedInputStream.a(MessageOptions.w(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.b((MessageOptions.Builder) this.n);
                                        this.n = builder.T();
                                    }
                                    this.f18421f |= 2;
                                case 66:
                                    if (!this.m.M()) {
                                        this.m = GeneratedMessageLite.a(this.m);
                                    }
                                    this.m.add((OneofDescriptorProto) codedInputStream.a(OneofDescriptorProto.r(), extensionRegistryLite));
                                case 74:
                                    if (!this.o.M()) {
                                        this.o = GeneratedMessageLite.a(this.o);
                                    }
                                    this.o.add((ReservedRange) codedInputStream.a(ReservedRange.p(), extensionRegistryLite));
                                case 82:
                                    String v2 = codedInputStream.v();
                                    if (!this.p.M()) {
                                        this.p = GeneratedMessageLite.a(this.p);
                                    }
                                    this.p.add(v2);
                                default:
                                    if (!a(x, codedInputStream)) {
                                        z = true;
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
                    if (f18420e == null) {
                        synchronized (DescriptorProto.class) {
                            if (f18420e == null) {
                                f18420e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18419d);
                            }
                        }
                    }
                    return f18420e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18419d;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface DescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class EnumDescriptorProto extends GeneratedMessageLite<EnumDescriptorProto, Builder> implements EnumDescriptorProtoOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final EnumDescriptorProto f18434d = new EnumDescriptorProto();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<EnumDescriptorProto> f18435e;

        /* renamed from: f, reason: collision with root package name */
        private int f18436f;
        private EnumOptions i;
        private byte l = -1;

        /* renamed from: g, reason: collision with root package name */
        private String f18437g = "";

        /* renamed from: h, reason: collision with root package name */
        private Internal.ProtobufList<EnumValueDescriptorProto> f18438h = GeneratedMessageLite.k();
        private Internal.ProtobufList<EnumReservedRange> j = GeneratedMessageLite.k();
        private Internal.ProtobufList<String> k = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<EnumDescriptorProto, Builder> implements EnumDescriptorProtoOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(EnumDescriptorProto.f18434d);
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public interface EnumReservedRangeOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            f18434d.l();
        }

        private EnumDescriptorProto() {
        }

        public static Parser<EnumDescriptorProto> t() {
            return f18434d.f();
        }

        public EnumValueDescriptorProto a(int i) {
            return this.f18438h.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18436f & 1) == 1 ? CodedOutputStream.a(1, n()) + 0 : 0;
            for (int i2 = 0; i2 < this.f18438h.size(); i2++) {
                a2 += CodedOutputStream.a(2, this.f18438h.get(i2));
            }
            if ((this.f18436f & 2) == 2) {
                a2 += CodedOutputStream.a(3, o());
            }
            for (int i3 = 0; i3 < this.j.size(); i3++) {
                a2 += CodedOutputStream.a(4, this.j.get(i3));
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.k.size(); i5++) {
                i4 += CodedOutputStream.a(this.k.get(i5));
            }
            int size = a2 + i4 + (p().size() * 1) + this.f18583b.c();
            this.f18584c = size;
            return size;
        }

        public String n() {
            return this.f18437g;
        }

        public EnumOptions o() {
            EnumOptions enumOptions = this.i;
            return enumOptions == null ? EnumOptions.q() : enumOptions;
        }

        public List<String> p() {
            return this.k;
        }

        public int q() {
            return this.f18438h.size();
        }

        public boolean r() {
            return (this.f18436f & 1) == 1;
        }

        public boolean s() {
            return (this.f18436f & 2) == 2;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.f18436f & 1) == 1) {
                codedOutputStream.b(1, n());
            }
            for (int i = 0; i < this.f18438h.size(); i++) {
                codedOutputStream.c(2, this.f18438h.get(i));
            }
            if ((this.f18436f & 2) == 2) {
                codedOutputStream.c(3, o());
            }
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                codedOutputStream.c(4, this.j.get(i2));
            }
            for (int i3 = 0; i3 < this.k.size(); i3++) {
                codedOutputStream.b(5, this.k.get(i3));
            }
            this.f18583b.a(codedOutputStream);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class EnumReservedRange extends GeneratedMessageLite<EnumReservedRange, Builder> implements EnumReservedRangeOrBuilder {

            /* renamed from: d, reason: collision with root package name */
            private static final EnumReservedRange f18439d = new EnumReservedRange();

            /* renamed from: e, reason: collision with root package name */
            private static volatile Parser<EnumReservedRange> f18440e;

            /* renamed from: f, reason: collision with root package name */
            private int f18441f;

            /* renamed from: g, reason: collision with root package name */
            private int f18442g;

            /* renamed from: h, reason: collision with root package name */
            private int f18443h;

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<EnumReservedRange, Builder> implements EnumReservedRangeOrBuilder {
                /* synthetic */ Builder(C1654h c1654h) {
                    this();
                }

                private Builder() {
                    super(EnumReservedRange.f18439d);
                }
            }

            static {
                f18439d.l();
            }

            private EnumReservedRange() {
            }

            public static Parser<EnumReservedRange> p() {
                return f18439d.f();
            }

            @Override // com.google.protobuf.MessageLite
            public void a(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.f18441f & 1) == 1) {
                    codedOutputStream.g(1, this.f18442g);
                }
                if ((this.f18441f & 2) == 2) {
                    codedOutputStream.g(2, this.f18443h);
                }
                this.f18583b.a(codedOutputStream);
            }

            @Override // com.google.protobuf.MessageLite
            public int d() {
                int i = this.f18584c;
                if (i != -1) {
                    return i;
                }
                int c2 = (this.f18441f & 1) == 1 ? 0 + CodedOutputStream.c(1, this.f18442g) : 0;
                if ((this.f18441f & 2) == 2) {
                    c2 += CodedOutputStream.c(2, this.f18443h);
                }
                int c3 = c2 + this.f18583b.c();
                this.f18584c = c3;
                return c3;
            }

            public boolean n() {
                return (this.f18441f & 2) == 2;
            }

            public boolean o() {
                return (this.f18441f & 1) == 1;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                C1654h c1654h = null;
                switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new EnumReservedRange();
                    case 2:
                        return f18439d;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(c1654h);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        EnumReservedRange enumReservedRange = (EnumReservedRange) obj2;
                        this.f18442g = visitor.a(o(), this.f18442g, enumReservedRange.o(), enumReservedRange.f18442g);
                        this.f18443h = visitor.a(n(), this.f18443h, enumReservedRange.n(), enumReservedRange.f18443h);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                            this.f18441f |= enumReservedRange.f18441f;
                        }
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        boolean z = false;
                        while (!z) {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x == 8) {
                                        this.f18441f |= 1;
                                        this.f18442g = codedInputStream.j();
                                    } else if (x != 16) {
                                        if (!a(x, codedInputStream)) {
                                        }
                                    } else {
                                        this.f18441f |= 2;
                                        this.f18443h = codedInputStream.j();
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
                        if (f18440e == null) {
                            synchronized (EnumReservedRange.class) {
                                if (f18440e == null) {
                                    f18440e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18439d);
                                }
                            }
                        }
                        return f18440e;
                    default:
                        throw new UnsupportedOperationException();
                }
                return f18439d;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumDescriptorProto();
                case 2:
                    byte b2 = this.l;
                    if (b2 == 1) {
                        return f18434d;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < q(); i++) {
                        if (!a(i).isInitialized()) {
                            if (booleanValue) {
                                this.l = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (!s() || o().isInitialized()) {
                        if (booleanValue) {
                            this.l = (byte) 1;
                        }
                        return f18434d;
                    }
                    if (booleanValue) {
                        this.l = (byte) 0;
                    }
                    return null;
                case 3:
                    this.f18438h.L();
                    this.j.L();
                    this.k.L();
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    EnumDescriptorProto enumDescriptorProto = (EnumDescriptorProto) obj2;
                    this.f18437g = visitor.a(r(), this.f18437g, enumDescriptorProto.r(), enumDescriptorProto.f18437g);
                    this.f18438h = visitor.a(this.f18438h, enumDescriptorProto.f18438h);
                    this.i = (EnumOptions) visitor.a(this.i, enumDescriptorProto.i);
                    this.j = visitor.a(this.j, enumDescriptorProto.j);
                    this.k = visitor.a(this.k, enumDescriptorProto.k);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18436f |= enumDescriptorProto.f18436f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    String v = codedInputStream.v();
                                    this.f18436f |= 1;
                                    this.f18437g = v;
                                } else if (x == 18) {
                                    if (!this.f18438h.M()) {
                                        this.f18438h = GeneratedMessageLite.a(this.f18438h);
                                    }
                                    this.f18438h.add((EnumValueDescriptorProto) codedInputStream.a(EnumValueDescriptorProto.s(), extensionRegistryLite));
                                } else if (x == 26) {
                                    EnumOptions.Builder builder = (this.f18436f & 2) == 2 ? (EnumOptions.Builder) this.i.b() : null;
                                    this.i = (EnumOptions) codedInputStream.a(EnumOptions.u(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.b((EnumOptions.Builder) this.i);
                                        this.i = builder.T();
                                    }
                                    this.f18436f |= 2;
                                } else if (x == 34) {
                                    if (!this.j.M()) {
                                        this.j = GeneratedMessageLite.a(this.j);
                                    }
                                    this.j.add((EnumReservedRange) codedInputStream.a(EnumReservedRange.p(), extensionRegistryLite));
                                } else if (x != 42) {
                                    if (!a(x, codedInputStream)) {
                                    }
                                } else {
                                    String v2 = codedInputStream.v();
                                    if (!this.k.M()) {
                                        this.k = GeneratedMessageLite.a(this.k);
                                    }
                                    this.k.add(v2);
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
                    if (f18435e == null) {
                        synchronized (EnumDescriptorProto.class) {
                            if (f18435e == null) {
                                f18435e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18434d);
                            }
                        }
                    }
                    return f18435e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18434d;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface EnumDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class EnumOptions extends GeneratedMessageLite.ExtendableMessage<EnumOptions, Builder> implements EnumOptionsOrBuilder {

        /* renamed from: e, reason: collision with root package name */
        private static final EnumOptions f18444e = new EnumOptions();

        /* renamed from: f, reason: collision with root package name */
        private static volatile Parser<EnumOptions> f18445f;

        /* renamed from: g, reason: collision with root package name */
        private int f18446g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f18447h;
        private boolean i;
        private byte k = -1;
        private Internal.ProtobufList<UninterpretedOption> j = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumOptions, Builder> implements EnumOptionsOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(EnumOptions.f18444e);
            }
        }

        static {
            f18444e.l();
        }

        private EnumOptions() {
        }

        public static EnumOptions q() {
            return f18444e;
        }

        public static Parser<EnumOptions> u() {
            return f18444e.f();
        }

        public UninterpretedOption a(int i) {
            return this.j.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18446g & 1) == 1 ? CodedOutputStream.a(2, this.f18447h) + 0 : 0;
            if ((this.f18446g & 2) == 2) {
                a2 += CodedOutputStream.a(3, this.i);
            }
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                a2 += CodedOutputStream.a(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.j.get(i2));
            }
            int n = a2 + n() + this.f18583b.c();
            this.f18584c = n;
            return n;
        }

        public int r() {
            return this.j.size();
        }

        public boolean s() {
            return (this.f18446g & 1) == 1;
        }

        public boolean t() {
            return (this.f18446g & 2) == 2;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter o = o();
            if ((this.f18446g & 1) == 1) {
                codedOutputStream.b(2, this.f18447h);
            }
            if ((this.f18446g & 2) == 2) {
                codedOutputStream.b(3, this.i);
            }
            for (int i = 0; i < this.j.size(); i++) {
                codedOutputStream.c(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.j.get(i));
            }
            o.a(536870912, codedOutputStream);
            this.f18583b.a(codedOutputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumOptions();
                case 2:
                    byte b2 = this.k;
                    if (b2 == 1) {
                        return f18444e;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < r(); i++) {
                        if (!a(i).isInitialized()) {
                            if (booleanValue) {
                                this.k = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (m()) {
                        if (booleanValue) {
                            this.k = (byte) 1;
                        }
                        return f18444e;
                    }
                    if (booleanValue) {
                        this.k = (byte) 0;
                    }
                    return null;
                case 3:
                    this.j.L();
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    EnumOptions enumOptions = (EnumOptions) obj2;
                    this.f18447h = visitor.a(s(), this.f18447h, enumOptions.s(), enumOptions.f18447h);
                    this.i = visitor.a(t(), this.i, enumOptions.t(), enumOptions.i);
                    this.j = visitor.a(this.j, enumOptions.j);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18446g |= enumOptions.f18446g;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 16) {
                                    this.f18446g |= 1;
                                    this.f18447h = codedInputStream.c();
                                } else if (x == 24) {
                                    this.f18446g |= 2;
                                    this.i = codedInputStream.c();
                                } else if (x != 7994) {
                                    if (!a((EnumOptions) a(), codedInputStream, extensionRegistryLite, x)) {
                                    }
                                } else {
                                    if (!this.j.M()) {
                                        this.j = GeneratedMessageLite.a(this.j);
                                    }
                                    this.j.add((UninterpretedOption) codedInputStream.a(UninterpretedOption.w(), extensionRegistryLite));
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
                    if (f18445f == null) {
                        synchronized (EnumOptions.class) {
                            if (f18445f == null) {
                                f18445f = new GeneratedMessageLite.DefaultInstanceBasedParser(f18444e);
                            }
                        }
                    }
                    return f18445f;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18444e;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface EnumOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumOptions, EnumOptions.Builder> {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface EnumValueDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class EnumValueOptions extends GeneratedMessageLite.ExtendableMessage<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {

        /* renamed from: e, reason: collision with root package name */
        private static final EnumValueOptions f18453e = new EnumValueOptions();

        /* renamed from: f, reason: collision with root package name */
        private static volatile Parser<EnumValueOptions> f18454f;

        /* renamed from: g, reason: collision with root package name */
        private int f18455g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f18456h;
        private byte j = -1;
        private Internal.ProtobufList<UninterpretedOption> i = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(EnumValueOptions.f18453e);
            }
        }

        static {
            f18453e.l();
        }

        private EnumValueOptions() {
        }

        public static EnumValueOptions q() {
            return f18453e;
        }

        public static Parser<EnumValueOptions> t() {
            return f18453e.f();
        }

        public UninterpretedOption a(int i) {
            return this.i.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18455g & 1) == 1 ? CodedOutputStream.a(1, this.f18456h) + 0 : 0;
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                a2 += CodedOutputStream.a(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.i.get(i2));
            }
            int n = a2 + n() + this.f18583b.c();
            this.f18584c = n;
            return n;
        }

        public int r() {
            return this.i.size();
        }

        public boolean s() {
            return (this.f18455g & 1) == 1;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter o = o();
            if ((this.f18455g & 1) == 1) {
                codedOutputStream.b(1, this.f18456h);
            }
            for (int i = 0; i < this.i.size(); i++) {
                codedOutputStream.c(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.i.get(i));
            }
            o.a(536870912, codedOutputStream);
            this.f18583b.a(codedOutputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumValueOptions();
                case 2:
                    byte b2 = this.j;
                    if (b2 == 1) {
                        return f18453e;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < r(); i++) {
                        if (!a(i).isInitialized()) {
                            if (booleanValue) {
                                this.j = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (m()) {
                        if (booleanValue) {
                            this.j = (byte) 1;
                        }
                        return f18453e;
                    }
                    if (booleanValue) {
                        this.j = (byte) 0;
                    }
                    return null;
                case 3:
                    this.i.L();
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    EnumValueOptions enumValueOptions = (EnumValueOptions) obj2;
                    this.f18456h = visitor.a(s(), this.f18456h, enumValueOptions.s(), enumValueOptions.f18456h);
                    this.i = visitor.a(this.i, enumValueOptions.i);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18455g |= enumValueOptions.f18455g;
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
                                    this.f18455g |= 1;
                                    this.f18456h = codedInputStream.c();
                                } else if (x != 7994) {
                                    if (!a((EnumValueOptions) a(), codedInputStream, extensionRegistryLite, x)) {
                                    }
                                } else {
                                    if (!this.i.M()) {
                                        this.i = GeneratedMessageLite.a(this.i);
                                    }
                                    this.i.add((UninterpretedOption) codedInputStream.a(UninterpretedOption.w(), extensionRegistryLite));
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
                    if (f18454f == null) {
                        synchronized (EnumValueOptions.class) {
                            if (f18454f == null) {
                                f18454f = new GeneratedMessageLite.DefaultInstanceBasedParser(f18453e);
                            }
                        }
                    }
                    return f18454f;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18453e;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface EnumValueOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumValueOptions, EnumValueOptions.Builder> {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class ExtensionRangeOptions extends GeneratedMessageLite.ExtendableMessage<ExtensionRangeOptions, Builder> implements ExtensionRangeOptionsOrBuilder {

        /* renamed from: e, reason: collision with root package name */
        private static final ExtensionRangeOptions f18457e = new ExtensionRangeOptions();

        /* renamed from: f, reason: collision with root package name */
        private static volatile Parser<ExtensionRangeOptions> f18458f;

        /* renamed from: h, reason: collision with root package name */
        private byte f18460h = -1;

        /* renamed from: g, reason: collision with root package name */
        private Internal.ProtobufList<UninterpretedOption> f18459g = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ExtensionRangeOptions, Builder> implements ExtensionRangeOptionsOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(ExtensionRangeOptions.f18457e);
            }
        }

        static {
            f18457e.l();
        }

        private ExtensionRangeOptions() {
        }

        public static ExtensionRangeOptions q() {
            return f18457e;
        }

        public static Parser<ExtensionRangeOptions> s() {
            return f18457e.f();
        }

        public UninterpretedOption a(int i) {
            return this.f18459g.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f18459g.size(); i3++) {
                i2 += CodedOutputStream.a(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.f18459g.get(i3));
            }
            int n = i2 + n() + this.f18583b.c();
            this.f18584c = n;
            return n;
        }

        public int r() {
            return this.f18459g.size();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter o = o();
            for (int i = 0; i < this.f18459g.size(); i++) {
                codedOutputStream.c(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.f18459g.get(i));
            }
            o.a(536870912, codedOutputStream);
            this.f18583b.a(codedOutputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExtensionRangeOptions();
                case 2:
                    byte b2 = this.f18460h;
                    if (b2 == 1) {
                        return f18457e;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < r(); i++) {
                        if (!a(i).isInitialized()) {
                            if (booleanValue) {
                                this.f18460h = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (m()) {
                        if (booleanValue) {
                            this.f18460h = (byte) 1;
                        }
                        return f18457e;
                    }
                    if (booleanValue) {
                        this.f18460h = (byte) 0;
                    }
                    return null;
                case 3:
                    this.f18459g.L();
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    this.f18459g = ((GeneratedMessageLite.Visitor) obj).a(this.f18459g, ((ExtensionRangeOptions) obj2).f18459g);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x != 7994) {
                                    if (!a((ExtensionRangeOptions) a(), codedInputStream, extensionRegistryLite, x)) {
                                    }
                                } else {
                                    if (!this.f18459g.M()) {
                                        this.f18459g = GeneratedMessageLite.a(this.f18459g);
                                    }
                                    this.f18459g.add((UninterpretedOption) codedInputStream.a(UninterpretedOption.w(), extensionRegistryLite));
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
                    if (f18458f == null) {
                        synchronized (ExtensionRangeOptions.class) {
                            if (f18458f == null) {
                                f18458f = new GeneratedMessageLite.DefaultInstanceBasedParser(f18457e);
                            }
                        }
                    }
                    return f18458f;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18457e;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface ExtensionRangeOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<ExtensionRangeOptions, ExtensionRangeOptions.Builder> {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface FieldDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class FieldOptions extends GeneratedMessageLite.ExtendableMessage<FieldOptions, Builder> implements FieldOptionsOrBuilder {

        /* renamed from: e, reason: collision with root package name */
        private static final FieldOptions f18466e = new FieldOptions();

        /* renamed from: f, reason: collision with root package name */
        private static volatile Parser<FieldOptions> f18467f;

        /* renamed from: g, reason: collision with root package name */
        private int f18468g;

        /* renamed from: h, reason: collision with root package name */
        private int f18469h;
        private boolean i;
        private int j;
        private boolean k;
        private boolean l;
        private boolean m;
        private byte o = -1;
        private Internal.ProtobufList<UninterpretedOption> n = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FieldOptions, Builder> implements FieldOptionsOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(FieldOptions.f18466e);
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public enum CType implements Internal.EnumLite {
            STRING(0),
            CORD(1),
            STRING_PIECE(2);

            public static final int CORD_VALUE = 1;
            public static final int STRING_PIECE_VALUE = 2;
            public static final int STRING_VALUE = 0;
            private static final Internal.EnumLiteMap<CType> internalValueMap = new C1657k();
            private final int value;

            CType(int i) {
                this.value = i;
            }

            public static CType forNumber(int i) {
                if (i == 0) {
                    return STRING;
                }
                if (i == 1) {
                    return CORD;
                }
                if (i != 2) {
                    return null;
                }
                return STRING_PIECE;
            }

            public static Internal.EnumLiteMap<CType> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static CType valueOf(int i) {
                return forNumber(i);
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public enum JSType implements Internal.EnumLite {
            JS_NORMAL(0),
            JS_STRING(1),
            JS_NUMBER(2);

            public static final int JS_NORMAL_VALUE = 0;
            public static final int JS_NUMBER_VALUE = 2;
            public static final int JS_STRING_VALUE = 1;
            private static final Internal.EnumLiteMap<JSType> internalValueMap = new C1658l();
            private final int value;

            JSType(int i) {
                this.value = i;
            }

            public static JSType forNumber(int i) {
                if (i == 0) {
                    return JS_NORMAL;
                }
                if (i == 1) {
                    return JS_STRING;
                }
                if (i != 2) {
                    return null;
                }
                return JS_NUMBER;
            }

            public static Internal.EnumLiteMap<JSType> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static JSType valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            f18466e.l();
        }

        private FieldOptions() {
        }

        public static FieldOptions q() {
            return f18466e;
        }

        public static Parser<FieldOptions> y() {
            return f18466e.f();
        }

        public UninterpretedOption a(int i) {
            return this.n.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18468g & 1) == 1 ? CodedOutputStream.a(1, this.f18469h) + 0 : 0;
            if ((this.f18468g & 2) == 2) {
                a2 += CodedOutputStream.a(2, this.i);
            }
            if ((this.f18468g & 16) == 16) {
                a2 += CodedOutputStream.a(3, this.l);
            }
            if ((this.f18468g & 8) == 8) {
                a2 += CodedOutputStream.a(5, this.k);
            }
            if ((this.f18468g & 4) == 4) {
                a2 += CodedOutputStream.a(6, this.j);
            }
            if ((this.f18468g & 32) == 32) {
                a2 += CodedOutputStream.a(10, this.m);
            }
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                a2 += CodedOutputStream.a(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.n.get(i2));
            }
            int n = a2 + n() + this.f18583b.c();
            this.f18584c = n;
            return n;
        }

        public int r() {
            return this.n.size();
        }

        public boolean s() {
            return (this.f18468g & 1) == 1;
        }

        public boolean t() {
            return (this.f18468g & 16) == 16;
        }

        public boolean u() {
            return (this.f18468g & 4) == 4;
        }

        public boolean v() {
            return (this.f18468g & 8) == 8;
        }

        public boolean w() {
            return (this.f18468g & 2) == 2;
        }

        public boolean x() {
            return (this.f18468g & 32) == 32;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter o = o();
            if ((this.f18468g & 1) == 1) {
                codedOutputStream.e(1, this.f18469h);
            }
            if ((this.f18468g & 2) == 2) {
                codedOutputStream.b(2, this.i);
            }
            if ((this.f18468g & 16) == 16) {
                codedOutputStream.b(3, this.l);
            }
            if ((this.f18468g & 8) == 8) {
                codedOutputStream.b(5, this.k);
            }
            if ((this.f18468g & 4) == 4) {
                codedOutputStream.e(6, this.j);
            }
            if ((this.f18468g & 32) == 32) {
                codedOutputStream.b(10, this.m);
            }
            for (int i = 0; i < this.n.size(); i++) {
                codedOutputStream.c(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.n.get(i));
            }
            o.a(536870912, codedOutputStream);
            this.f18583b.a(codedOutputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldOptions();
                case 2:
                    byte b2 = this.o;
                    if (b2 == 1) {
                        return f18466e;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < r(); i++) {
                        if (!a(i).isInitialized()) {
                            if (booleanValue) {
                                this.o = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (m()) {
                        if (booleanValue) {
                            this.o = (byte) 1;
                        }
                        return f18466e;
                    }
                    if (booleanValue) {
                        this.o = (byte) 0;
                    }
                    return null;
                case 3:
                    this.n.L();
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    FieldOptions fieldOptions = (FieldOptions) obj2;
                    this.f18469h = visitor.a(s(), this.f18469h, fieldOptions.s(), fieldOptions.f18469h);
                    this.i = visitor.a(w(), this.i, fieldOptions.w(), fieldOptions.i);
                    this.j = visitor.a(u(), this.j, fieldOptions.u(), fieldOptions.j);
                    this.k = visitor.a(v(), this.k, fieldOptions.v(), fieldOptions.k);
                    this.l = visitor.a(t(), this.l, fieldOptions.t(), fieldOptions.l);
                    this.m = visitor.a(x(), this.m, fieldOptions.x(), fieldOptions.m);
                    this.n = visitor.a(this.n, fieldOptions.n);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18468g |= fieldOptions.f18468g;
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
                                    int f2 = codedInputStream.f();
                                    if (CType.forNumber(f2) == null) {
                                        super.a(1, f2);
                                    } else {
                                        this.f18468g |= 1;
                                        this.f18469h = f2;
                                    }
                                } else if (x == 16) {
                                    this.f18468g |= 2;
                                    this.i = codedInputStream.c();
                                } else if (x == 24) {
                                    this.f18468g |= 16;
                                    this.l = codedInputStream.c();
                                } else if (x == 40) {
                                    this.f18468g |= 8;
                                    this.k = codedInputStream.c();
                                } else if (x == 48) {
                                    int f3 = codedInputStream.f();
                                    if (JSType.forNumber(f3) == null) {
                                        super.a(6, f3);
                                    } else {
                                        this.f18468g |= 4;
                                        this.j = f3;
                                    }
                                } else if (x == 80) {
                                    this.f18468g |= 32;
                                    this.m = codedInputStream.c();
                                } else if (x != 7994) {
                                    if (!a((FieldOptions) a(), codedInputStream, extensionRegistryLite, x)) {
                                    }
                                } else {
                                    if (!this.n.M()) {
                                        this.n = GeneratedMessageLite.a(this.n);
                                    }
                                    this.n.add((UninterpretedOption) codedInputStream.a(UninterpretedOption.w(), extensionRegistryLite));
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
                    if (f18467f == null) {
                        synchronized (FieldOptions.class) {
                            if (f18467f == null) {
                                f18467f = new GeneratedMessageLite.DefaultInstanceBasedParser(f18466e);
                            }
                        }
                    }
                    return f18467f;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18466e;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface FieldOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FieldOptions, FieldOptions.Builder> {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class FileDescriptorProto extends GeneratedMessageLite<FileDescriptorProto, Builder> implements FileDescriptorProtoOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final FileDescriptorProto f18470d = new FileDescriptorProto();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<FileDescriptorProto> f18471e;

        /* renamed from: f, reason: collision with root package name */
        private int f18472f;
        private FileOptions p;
        private SourceCodeInfo q;
        private byte s = -1;

        /* renamed from: g, reason: collision with root package name */
        private String f18473g = "";

        /* renamed from: h, reason: collision with root package name */
        private String f18474h = "";
        private Internal.ProtobufList<String> i = GeneratedMessageLite.k();
        private Internal.IntList j = GeneratedMessageLite.i();
        private Internal.IntList k = GeneratedMessageLite.i();
        private Internal.ProtobufList<DescriptorProto> l = GeneratedMessageLite.k();
        private Internal.ProtobufList<EnumDescriptorProto> m = GeneratedMessageLite.k();
        private Internal.ProtobufList<ServiceDescriptorProto> n = GeneratedMessageLite.k();
        private Internal.ProtobufList<FieldDescriptorProto> o = GeneratedMessageLite.k();
        private String r = "";

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FileDescriptorProto, Builder> implements FileDescriptorProtoOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(FileDescriptorProto.f18470d);
            }
        }

        static {
            f18470d.l();
        }

        private FileDescriptorProto() {
        }

        public static Parser<FileDescriptorProto> D() {
            return f18470d.f();
        }

        public boolean A() {
            return (this.f18472f & 4) == 4;
        }

        public boolean B() {
            return (this.f18472f & 2) == 2;
        }

        public boolean C() {
            return (this.f18472f & 16) == 16;
        }

        public EnumDescriptorProto a(int i) {
            return this.m.get(i);
        }

        public FieldDescriptorProto b(int i) {
            return this.o.get(i);
        }

        public DescriptorProto c(int i) {
            return this.l.get(i);
        }

        public ServiceDescriptorProto d(int i) {
            return this.n.get(i);
        }

        public List<String> n() {
            return this.i;
        }

        public int o() {
            return this.m.size();
        }

        public int p() {
            return this.o.size();
        }

        public int q() {
            return this.l.size();
        }

        public String r() {
            return this.f18473g;
        }

        public FileOptions s() {
            FileOptions fileOptions = this.p;
            return fileOptions == null ? FileOptions.r() : fileOptions;
        }

        public String t() {
            return this.f18474h;
        }

        public List<Integer> u() {
            return this.j;
        }

        public int v() {
            return this.n.size();
        }

        public SourceCodeInfo w() {
            SourceCodeInfo sourceCodeInfo = this.q;
            return sourceCodeInfo == null ? SourceCodeInfo.n() : sourceCodeInfo;
        }

        public String x() {
            return this.r;
        }

        public List<Integer> y() {
            return this.k;
        }

        public boolean z() {
            return (this.f18472f & 1) == 1;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.f18472f & 1) == 1) {
                codedOutputStream.b(1, r());
            }
            if ((this.f18472f & 2) == 2) {
                codedOutputStream.b(2, t());
            }
            for (int i = 0; i < this.i.size(); i++) {
                codedOutputStream.b(3, this.i.get(i));
            }
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                codedOutputStream.c(4, this.l.get(i2));
            }
            for (int i3 = 0; i3 < this.m.size(); i3++) {
                codedOutputStream.c(5, this.m.get(i3));
            }
            for (int i4 = 0; i4 < this.n.size(); i4++) {
                codedOutputStream.c(6, this.n.get(i4));
            }
            for (int i5 = 0; i5 < this.o.size(); i5++) {
                codedOutputStream.c(7, this.o.get(i5));
            }
            if ((this.f18472f & 4) == 4) {
                codedOutputStream.c(8, s());
            }
            if ((this.f18472f & 8) == 8) {
                codedOutputStream.c(9, w());
            }
            for (int i6 = 0; i6 < this.j.size(); i6++) {
                codedOutputStream.g(10, this.j.getInt(i6));
            }
            for (int i7 = 0; i7 < this.k.size(); i7++) {
                codedOutputStream.g(11, this.k.getInt(i7));
            }
            if ((this.f18472f & 16) == 16) {
                codedOutputStream.b(12, x());
            }
            this.f18583b.a(codedOutputStream);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18472f & 1) == 1 ? CodedOutputStream.a(1, r()) + 0 : 0;
            if ((this.f18472f & 2) == 2) {
                a2 += CodedOutputStream.a(2, t());
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                i2 += CodedOutputStream.a(this.i.get(i3));
            }
            int size = a2 + i2 + (n().size() * 1);
            for (int i4 = 0; i4 < this.l.size(); i4++) {
                size += CodedOutputStream.a(4, this.l.get(i4));
            }
            for (int i5 = 0; i5 < this.m.size(); i5++) {
                size += CodedOutputStream.a(5, this.m.get(i5));
            }
            for (int i6 = 0; i6 < this.n.size(); i6++) {
                size += CodedOutputStream.a(6, this.n.get(i6));
            }
            for (int i7 = 0; i7 < this.o.size(); i7++) {
                size += CodedOutputStream.a(7, this.o.get(i7));
            }
            if ((this.f18472f & 4) == 4) {
                size += CodedOutputStream.a(8, s());
            }
            if ((this.f18472f & 8) == 8) {
                size += CodedOutputStream.a(9, w());
            }
            int i8 = 0;
            for (int i9 = 0; i9 < this.j.size(); i9++) {
                i8 += CodedOutputStream.c(this.j.getInt(i9));
            }
            int size2 = size + i8 + (u().size() * 1);
            int i10 = 0;
            for (int i11 = 0; i11 < this.k.size(); i11++) {
                i10 += CodedOutputStream.c(this.k.getInt(i11));
            }
            int size3 = size2 + i10 + (y().size() * 1);
            if ((this.f18472f & 16) == 16) {
                size3 += CodedOutputStream.a(12, x());
            }
            int c2 = size3 + this.f18583b.c();
            this.f18584c = c2;
            return c2;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FileDescriptorProto();
                case 2:
                    byte b2 = this.s;
                    if (b2 == 1) {
                        return f18470d;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < q(); i++) {
                        if (!c(i).isInitialized()) {
                            if (booleanValue) {
                                this.s = (byte) 0;
                            }
                            return null;
                        }
                    }
                    for (int i2 = 0; i2 < o(); i2++) {
                        if (!a(i2).isInitialized()) {
                            if (booleanValue) {
                                this.s = (byte) 0;
                            }
                            return null;
                        }
                    }
                    for (int i3 = 0; i3 < v(); i3++) {
                        if (!d(i3).isInitialized()) {
                            if (booleanValue) {
                                this.s = (byte) 0;
                            }
                            return null;
                        }
                    }
                    for (int i4 = 0; i4 < p(); i4++) {
                        if (!b(i4).isInitialized()) {
                            if (booleanValue) {
                                this.s = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (!A() || s().isInitialized()) {
                        if (booleanValue) {
                            this.s = (byte) 1;
                        }
                        return f18470d;
                    }
                    if (booleanValue) {
                        this.s = (byte) 0;
                    }
                    return null;
                case 3:
                    this.i.L();
                    this.j.L();
                    this.k.L();
                    this.l.L();
                    this.m.L();
                    this.n.L();
                    this.o.L();
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    FileDescriptorProto fileDescriptorProto = (FileDescriptorProto) obj2;
                    this.f18473g = visitor.a(z(), this.f18473g, fileDescriptorProto.z(), fileDescriptorProto.f18473g);
                    this.f18474h = visitor.a(B(), this.f18474h, fileDescriptorProto.B(), fileDescriptorProto.f18474h);
                    this.i = visitor.a(this.i, fileDescriptorProto.i);
                    this.j = visitor.a(this.j, fileDescriptorProto.j);
                    this.k = visitor.a(this.k, fileDescriptorProto.k);
                    this.l = visitor.a(this.l, fileDescriptorProto.l);
                    this.m = visitor.a(this.m, fileDescriptorProto.m);
                    this.n = visitor.a(this.n, fileDescriptorProto.n);
                    this.o = visitor.a(this.o, fileDescriptorProto.o);
                    this.p = (FileOptions) visitor.a(this.p, fileDescriptorProto.p);
                    this.q = (SourceCodeInfo) visitor.a(this.q, fileDescriptorProto.q);
                    this.r = visitor.a(C(), this.r, fileDescriptorProto.C(), fileDescriptorProto.r);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18472f |= fileDescriptorProto.f18472f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            switch (x) {
                                case 0:
                                    z = true;
                                case 10:
                                    String v = codedInputStream.v();
                                    this.f18472f |= 1;
                                    this.f18473g = v;
                                case 18:
                                    String v2 = codedInputStream.v();
                                    this.f18472f |= 2;
                                    this.f18474h = v2;
                                case 26:
                                    String v3 = codedInputStream.v();
                                    if (!this.i.M()) {
                                        this.i = GeneratedMessageLite.a(this.i);
                                    }
                                    this.i.add(v3);
                                case 34:
                                    if (!this.l.M()) {
                                        this.l = GeneratedMessageLite.a(this.l);
                                    }
                                    this.l.add((DescriptorProto) codedInputStream.a(DescriptorProto.y(), extensionRegistryLite));
                                case 42:
                                    if (!this.m.M()) {
                                        this.m = GeneratedMessageLite.a(this.m);
                                    }
                                    this.m.add((EnumDescriptorProto) codedInputStream.a(EnumDescriptorProto.t(), extensionRegistryLite));
                                case 50:
                                    if (!this.n.M()) {
                                        this.n = GeneratedMessageLite.a(this.n);
                                    }
                                    this.n.add((ServiceDescriptorProto) codedInputStream.a(ServiceDescriptorProto.s(), extensionRegistryLite));
                                case 58:
                                    if (!this.o.M()) {
                                        this.o = GeneratedMessageLite.a(this.o);
                                    }
                                    this.o.add((FieldDescriptorProto) codedInputStream.a(FieldDescriptorProto.D(), extensionRegistryLite));
                                case 66:
                                    FileOptions.Builder builder = (this.f18472f & 4) == 4 ? (FileOptions.Builder) this.p.b() : null;
                                    this.p = (FileOptions) codedInputStream.a(FileOptions.S(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.b((FileOptions.Builder) this.p);
                                        this.p = builder.T();
                                    }
                                    this.f18472f |= 4;
                                case 74:
                                    SourceCodeInfo.Builder b3 = (this.f18472f & 8) == 8 ? this.q.b() : null;
                                    this.q = (SourceCodeInfo) codedInputStream.a(SourceCodeInfo.o(), extensionRegistryLite);
                                    if (b3 != null) {
                                        b3.b((SourceCodeInfo.Builder) this.q);
                                        this.q = b3.T();
                                    }
                                    this.f18472f |= 8;
                                case 80:
                                    if (!this.j.M()) {
                                        this.j = GeneratedMessageLite.a(this.j);
                                    }
                                    this.j.i(codedInputStream.j());
                                case 82:
                                    int d2 = codedInputStream.d(codedInputStream.o());
                                    if (!this.j.M() && codedInputStream.a() > 0) {
                                        this.j = GeneratedMessageLite.a(this.j);
                                    }
                                    while (codedInputStream.a() > 0) {
                                        this.j.i(codedInputStream.j());
                                    }
                                    codedInputStream.c(d2);
                                    break;
                                case 88:
                                    if (!this.k.M()) {
                                        this.k = GeneratedMessageLite.a(this.k);
                                    }
                                    this.k.i(codedInputStream.j());
                                case 90:
                                    int d3 = codedInputStream.d(codedInputStream.o());
                                    if (!this.k.M() && codedInputStream.a() > 0) {
                                        this.k = GeneratedMessageLite.a(this.k);
                                    }
                                    while (codedInputStream.a() > 0) {
                                        this.k.i(codedInputStream.j());
                                    }
                                    codedInputStream.c(d3);
                                    break;
                                case 98:
                                    String v4 = codedInputStream.v();
                                    this.f18472f |= 16;
                                    this.r = v4;
                                default:
                                    if (!a(x, codedInputStream)) {
                                        z = true;
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
                    if (f18471e == null) {
                        synchronized (FileDescriptorProto.class) {
                            if (f18471e == null) {
                                f18471e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18470d);
                            }
                        }
                    }
                    return f18471e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18470d;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface FileDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class FileDescriptorSet extends GeneratedMessageLite<FileDescriptorSet, Builder> implements FileDescriptorSetOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final FileDescriptorSet f18475d = new FileDescriptorSet();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<FileDescriptorSet> f18476e;

        /* renamed from: g, reason: collision with root package name */
        private byte f18478g = -1;

        /* renamed from: f, reason: collision with root package name */
        private Internal.ProtobufList<FileDescriptorProto> f18477f = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FileDescriptorSet, Builder> implements FileDescriptorSetOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(FileDescriptorSet.f18475d);
            }
        }

        static {
            f18475d.l();
        }

        private FileDescriptorSet() {
        }

        public FileDescriptorProto a(int i) {
            return this.f18477f.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f18477f.size(); i3++) {
                i2 += CodedOutputStream.a(1, this.f18477f.get(i3));
            }
            int c2 = i2 + this.f18583b.c();
            this.f18584c = c2;
            return c2;
        }

        public int n() {
            return this.f18477f.size();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.f18477f.size(); i++) {
                codedOutputStream.c(1, this.f18477f.get(i));
            }
            this.f18583b.a(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FileDescriptorSet();
                case 2:
                    byte b2 = this.f18478g;
                    if (b2 == 1) {
                        return f18475d;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < n(); i++) {
                        if (!a(i).isInitialized()) {
                            if (booleanValue) {
                                this.f18478g = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (booleanValue) {
                        this.f18478g = (byte) 1;
                    }
                    return f18475d;
                case 3:
                    this.f18477f.L();
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    this.f18477f = ((GeneratedMessageLite.Visitor) obj).a(this.f18477f, ((FileDescriptorSet) obj2).f18477f);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x != 10) {
                                        if (!a(x, codedInputStream)) {
                                        }
                                    } else {
                                        if (!this.f18477f.M()) {
                                            this.f18477f = GeneratedMessageLite.a(this.f18477f);
                                        }
                                        this.f18477f.add((FileDescriptorProto) codedInputStream.a(FileDescriptorProto.D(), extensionRegistryLite));
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
                    if (f18476e == null) {
                        synchronized (FileDescriptorSet.class) {
                            if (f18476e == null) {
                                f18476e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18475d);
                            }
                        }
                    }
                    return f18476e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18475d;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface FileDescriptorSetOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class FileOptions extends GeneratedMessageLite.ExtendableMessage<FileOptions, Builder> implements FileOptionsOrBuilder {

        /* renamed from: e, reason: collision with root package name */
        private static final FileOptions f18479e = new FileOptions();

        /* renamed from: f, reason: collision with root package name */
        private static volatile Parser<FileOptions> f18480f;

        /* renamed from: g, reason: collision with root package name */
        private int f18481g;
        private boolean j;
        private boolean k;
        private boolean l;
        private boolean o;
        private boolean p;
        private boolean q;
        private boolean r;
        private boolean s;
        private boolean t;
        private byte A = -1;

        /* renamed from: h, reason: collision with root package name */
        private String f18482h = "";
        private String i = "";
        private int m = 1;
        private String n = "";
        private String u = "";
        private String v = "";
        private String w = "";
        private String x = "";
        private String y = "";
        private Internal.ProtobufList<UninterpretedOption> z = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FileOptions, Builder> implements FileOptionsOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(FileOptions.f18479e);
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public enum OptimizeMode implements Internal.EnumLite {
            SPEED(1),
            CODE_SIZE(2),
            LITE_RUNTIME(3);

            public static final int CODE_SIZE_VALUE = 2;
            public static final int LITE_RUNTIME_VALUE = 3;
            public static final int SPEED_VALUE = 1;
            private static final Internal.EnumLiteMap<OptimizeMode> internalValueMap = new C1659m();
            private final int value;

            OptimizeMode(int i) {
                this.value = i;
            }

            public static OptimizeMode forNumber(int i) {
                if (i == 1) {
                    return SPEED;
                }
                if (i == 2) {
                    return CODE_SIZE;
                }
                if (i != 3) {
                    return null;
                }
                return LITE_RUNTIME;
            }

            public static Internal.EnumLiteMap<OptimizeMode> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static OptimizeMode valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            f18479e.l();
        }

        private FileOptions() {
        }

        public static Parser<FileOptions> S() {
            return f18479e.f();
        }

        public static FileOptions r() {
            return f18479e;
        }

        public boolean A() {
            return (this.f18481g & 4096) == 4096;
        }

        public boolean B() {
            return (this.f18481g & 128) == 128;
        }

        public boolean C() {
            return (this.f18481g & 16384) == 16384;
        }

        public boolean D() {
            return (this.f18481g & 2048) == 2048;
        }

        public boolean E() {
            return (this.f18481g & 64) == 64;
        }

        @Deprecated
        public boolean F() {
            return (this.f18481g & 8) == 8;
        }

        public boolean G() {
            return (this.f18481g & 256) == 256;
        }

        public boolean H() {
            return (this.f18481g & 4) == 4;
        }

        public boolean I() {
            return (this.f18481g & 2) == 2;
        }

        public boolean J() {
            return (this.f18481g & 1) == 1;
        }

        public boolean K() {
            return (this.f18481g & 16) == 16;
        }

        public boolean L() {
            return (this.f18481g & 8192) == 8192;
        }

        public boolean M() {
            return (this.f18481g & 32) == 32;
        }

        public boolean N() {
            return (this.f18481g & 65536) == 65536;
        }

        public boolean O() {
            return (this.f18481g & 1024) == 1024;
        }

        public boolean P() {
            return (this.f18481g & 131072) == 131072;
        }

        public boolean Q() {
            return (this.f18481g & 512) == 512;
        }

        public boolean R() {
            return (this.f18481g & 32768) == 32768;
        }

        public UninterpretedOption a(int i) {
            return this.z.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18481g & 1) == 1 ? CodedOutputStream.a(1, u()) + 0 : 0;
            if ((this.f18481g & 2) == 2) {
                a2 += CodedOutputStream.a(8, t());
            }
            if ((this.f18481g & 32) == 32) {
                a2 += CodedOutputStream.a(9, this.m);
            }
            if ((this.f18481g & 4) == 4) {
                a2 += CodedOutputStream.a(10, this.j);
            }
            if ((this.f18481g & 64) == 64) {
                a2 += CodedOutputStream.a(11, s());
            }
            if ((this.f18481g & 128) == 128) {
                a2 += CodedOutputStream.a(16, this.o);
            }
            if ((this.f18481g & 256) == 256) {
                a2 += CodedOutputStream.a(17, this.p);
            }
            if ((this.f18481g & 512) == 512) {
                a2 += CodedOutputStream.a(18, this.q);
            }
            if ((this.f18481g & 8) == 8) {
                a2 += CodedOutputStream.a(20, this.k);
            }
            if ((this.f18481g & 2048) == 2048) {
                a2 += CodedOutputStream.a(23, this.s);
            }
            if ((this.f18481g & 16) == 16) {
                a2 += CodedOutputStream.a(27, this.l);
            }
            if ((this.f18481g & 4096) == 4096) {
                a2 += CodedOutputStream.a(31, this.t);
            }
            if ((this.f18481g & 8192) == 8192) {
                a2 += CodedOutputStream.a(36, v());
            }
            if ((this.f18481g & 16384) == 16384) {
                a2 += CodedOutputStream.a(37, q());
            }
            if ((this.f18481g & 32768) == 32768) {
                a2 += CodedOutputStream.a(39, y());
            }
            if ((this.f18481g & 65536) == 65536) {
                a2 += CodedOutputStream.a(40, w());
            }
            if ((this.f18481g & 131072) == 131072) {
                a2 += CodedOutputStream.a(41, x());
            }
            if ((this.f18481g & 1024) == 1024) {
                a2 += CodedOutputStream.a(42, this.r);
            }
            for (int i2 = 0; i2 < this.z.size(); i2++) {
                a2 += CodedOutputStream.a(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.z.get(i2));
            }
            int n = a2 + n() + this.f18583b.c();
            this.f18584c = n;
            return n;
        }

        public String q() {
            return this.v;
        }

        public String s() {
            return this.n;
        }

        public String t() {
            return this.i;
        }

        public String u() {
            return this.f18482h;
        }

        public String v() {
            return this.u;
        }

        public String w() {
            return this.x;
        }

        public String x() {
            return this.y;
        }

        public String y() {
            return this.w;
        }

        public int z() {
            return this.z.size();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter o = o();
            if ((this.f18481g & 1) == 1) {
                codedOutputStream.b(1, u());
            }
            if ((this.f18481g & 2) == 2) {
                codedOutputStream.b(8, t());
            }
            if ((this.f18481g & 32) == 32) {
                codedOutputStream.e(9, this.m);
            }
            if ((this.f18481g & 4) == 4) {
                codedOutputStream.b(10, this.j);
            }
            if ((this.f18481g & 64) == 64) {
                codedOutputStream.b(11, s());
            }
            if ((this.f18481g & 128) == 128) {
                codedOutputStream.b(16, this.o);
            }
            if ((this.f18481g & 256) == 256) {
                codedOutputStream.b(17, this.p);
            }
            if ((this.f18481g & 512) == 512) {
                codedOutputStream.b(18, this.q);
            }
            if ((this.f18481g & 8) == 8) {
                codedOutputStream.b(20, this.k);
            }
            if ((this.f18481g & 2048) == 2048) {
                codedOutputStream.b(23, this.s);
            }
            if ((this.f18481g & 16) == 16) {
                codedOutputStream.b(27, this.l);
            }
            if ((this.f18481g & 4096) == 4096) {
                codedOutputStream.b(31, this.t);
            }
            if ((this.f18481g & 8192) == 8192) {
                codedOutputStream.b(36, v());
            }
            if ((this.f18481g & 16384) == 16384) {
                codedOutputStream.b(37, q());
            }
            if ((this.f18481g & 32768) == 32768) {
                codedOutputStream.b(39, y());
            }
            if ((this.f18481g & 65536) == 65536) {
                codedOutputStream.b(40, w());
            }
            if ((this.f18481g & 131072) == 131072) {
                codedOutputStream.b(41, x());
            }
            if ((this.f18481g & 1024) == 1024) {
                codedOutputStream.b(42, this.r);
            }
            for (int i = 0; i < this.z.size(); i++) {
                codedOutputStream.c(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.z.get(i));
            }
            o.a(536870912, codedOutputStream);
            this.f18583b.a(codedOutputStream);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FileOptions();
                case 2:
                    byte b2 = this.A;
                    if (b2 == 1) {
                        return f18479e;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < z(); i++) {
                        if (!a(i).isInitialized()) {
                            if (booleanValue) {
                                this.A = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (m()) {
                        if (booleanValue) {
                            this.A = (byte) 1;
                        }
                        return f18479e;
                    }
                    if (booleanValue) {
                        this.A = (byte) 0;
                    }
                    return null;
                case 3:
                    this.z.L();
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    FileOptions fileOptions = (FileOptions) obj2;
                    this.f18482h = visitor.a(J(), this.f18482h, fileOptions.J(), fileOptions.f18482h);
                    this.i = visitor.a(I(), this.i, fileOptions.I(), fileOptions.i);
                    this.j = visitor.a(H(), this.j, fileOptions.H(), fileOptions.j);
                    this.k = visitor.a(F(), this.k, fileOptions.F(), fileOptions.k);
                    this.l = visitor.a(K(), this.l, fileOptions.K(), fileOptions.l);
                    this.m = visitor.a(M(), this.m, fileOptions.M(), fileOptions.m);
                    this.n = visitor.a(E(), this.n, fileOptions.E(), fileOptions.n);
                    this.o = visitor.a(B(), this.o, fileOptions.B(), fileOptions.o);
                    this.p = visitor.a(G(), this.p, fileOptions.G(), fileOptions.p);
                    this.q = visitor.a(Q(), this.q, fileOptions.Q(), fileOptions.q);
                    this.r = visitor.a(O(), this.r, fileOptions.O(), fileOptions.r);
                    this.s = visitor.a(D(), this.s, fileOptions.D(), fileOptions.s);
                    this.t = visitor.a(A(), this.t, fileOptions.A(), fileOptions.t);
                    this.u = visitor.a(L(), this.u, fileOptions.L(), fileOptions.u);
                    this.v = visitor.a(C(), this.v, fileOptions.C(), fileOptions.v);
                    this.w = visitor.a(R(), this.w, fileOptions.R(), fileOptions.w);
                    this.x = visitor.a(N(), this.x, fileOptions.N(), fileOptions.x);
                    this.y = visitor.a(P(), this.y, fileOptions.P(), fileOptions.y);
                    this.z = visitor.a(this.z, fileOptions.z);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18481g |= fileOptions.f18481g;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            switch (x) {
                                case 0:
                                    z = true;
                                case 10:
                                    String v = codedInputStream.v();
                                    this.f18481g |= 1;
                                    this.f18482h = v;
                                case 66:
                                    String v2 = codedInputStream.v();
                                    this.f18481g |= 2;
                                    this.i = v2;
                                case 72:
                                    int f2 = codedInputStream.f();
                                    if (OptimizeMode.forNumber(f2) == null) {
                                        super.a(9, f2);
                                    } else {
                                        this.f18481g |= 32;
                                        this.m = f2;
                                    }
                                case 80:
                                    this.f18481g |= 4;
                                    this.j = codedInputStream.c();
                                case 90:
                                    String v3 = codedInputStream.v();
                                    this.f18481g |= 64;
                                    this.n = v3;
                                case 128:
                                    this.f18481g |= 128;
                                    this.o = codedInputStream.c();
                                case 136:
                                    this.f18481g |= 256;
                                    this.p = codedInputStream.c();
                                case 144:
                                    this.f18481g |= 512;
                                    this.q = codedInputStream.c();
                                case 160:
                                    this.f18481g |= 8;
                                    this.k = codedInputStream.c();
                                case 184:
                                    this.f18481g |= 2048;
                                    this.s = codedInputStream.c();
                                case 216:
                                    this.f18481g |= 16;
                                    this.l = codedInputStream.c();
                                case 248:
                                    this.f18481g |= 4096;
                                    this.t = codedInputStream.c();
                                case 290:
                                    String v4 = codedInputStream.v();
                                    this.f18481g |= 8192;
                                    this.u = v4;
                                case 298:
                                    String v5 = codedInputStream.v();
                                    this.f18481g |= 16384;
                                    this.v = v5;
                                case 314:
                                    String v6 = codedInputStream.v();
                                    this.f18481g |= 32768;
                                    this.w = v6;
                                case 322:
                                    String v7 = codedInputStream.v();
                                    this.f18481g |= 65536;
                                    this.x = v7;
                                case 330:
                                    String v8 = codedInputStream.v();
                                    this.f18481g |= 131072;
                                    this.y = v8;
                                case 336:
                                    this.f18481g |= 1024;
                                    this.r = codedInputStream.c();
                                case 7994:
                                    if (!this.z.M()) {
                                        this.z = GeneratedMessageLite.a(this.z);
                                    }
                                    this.z.add((UninterpretedOption) codedInputStream.a(UninterpretedOption.w(), extensionRegistryLite));
                                default:
                                    if (!a((FileOptions) a(), codedInputStream, extensionRegistryLite, x)) {
                                        z = true;
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
                    if (f18480f == null) {
                        synchronized (FileOptions.class) {
                            if (f18480f == null) {
                                f18480f = new GeneratedMessageLite.DefaultInstanceBasedParser(f18479e);
                            }
                        }
                    }
                    return f18480f;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18479e;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface FileOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FileOptions, FileOptions.Builder> {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface GeneratedCodeInfoOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class MessageOptions extends GeneratedMessageLite.ExtendableMessage<MessageOptions, Builder> implements MessageOptionsOrBuilder {

        /* renamed from: e, reason: collision with root package name */
        private static final MessageOptions f18491e = new MessageOptions();

        /* renamed from: f, reason: collision with root package name */
        private static volatile Parser<MessageOptions> f18492f;

        /* renamed from: g, reason: collision with root package name */
        private int f18493g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f18494h;
        private boolean i;
        private boolean j;
        private boolean k;
        private byte m = -1;
        private Internal.ProtobufList<UninterpretedOption> l = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<MessageOptions, Builder> implements MessageOptionsOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(MessageOptions.f18491e);
            }
        }

        static {
            f18491e.l();
        }

        private MessageOptions() {
        }

        public static MessageOptions q() {
            return f18491e;
        }

        public static Parser<MessageOptions> w() {
            return f18491e.f();
        }

        public UninterpretedOption a(int i) {
            return this.l.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18493g & 1) == 1 ? CodedOutputStream.a(1, this.f18494h) + 0 : 0;
            if ((this.f18493g & 2) == 2) {
                a2 += CodedOutputStream.a(2, this.i);
            }
            if ((this.f18493g & 4) == 4) {
                a2 += CodedOutputStream.a(3, this.j);
            }
            if ((this.f18493g & 8) == 8) {
                a2 += CodedOutputStream.a(7, this.k);
            }
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                a2 += CodedOutputStream.a(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.l.get(i2));
            }
            int n = a2 + n() + this.f18583b.c();
            this.f18584c = n;
            return n;
        }

        public int r() {
            return this.l.size();
        }

        public boolean s() {
            return (this.f18493g & 4) == 4;
        }

        public boolean t() {
            return (this.f18493g & 8) == 8;
        }

        public boolean u() {
            return (this.f18493g & 1) == 1;
        }

        public boolean v() {
            return (this.f18493g & 2) == 2;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter o = o();
            if ((this.f18493g & 1) == 1) {
                codedOutputStream.b(1, this.f18494h);
            }
            if ((this.f18493g & 2) == 2) {
                codedOutputStream.b(2, this.i);
            }
            if ((this.f18493g & 4) == 4) {
                codedOutputStream.b(3, this.j);
            }
            if ((this.f18493g & 8) == 8) {
                codedOutputStream.b(7, this.k);
            }
            for (int i = 0; i < this.l.size(); i++) {
                codedOutputStream.c(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.l.get(i));
            }
            o.a(536870912, codedOutputStream);
            this.f18583b.a(codedOutputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new MessageOptions();
                case 2:
                    byte b2 = this.m;
                    if (b2 == 1) {
                        return f18491e;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < r(); i++) {
                        if (!a(i).isInitialized()) {
                            if (booleanValue) {
                                this.m = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (m()) {
                        if (booleanValue) {
                            this.m = (byte) 1;
                        }
                        return f18491e;
                    }
                    if (booleanValue) {
                        this.m = (byte) 0;
                    }
                    return null;
                case 3:
                    this.l.L();
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    MessageOptions messageOptions = (MessageOptions) obj2;
                    this.f18494h = visitor.a(u(), this.f18494h, messageOptions.u(), messageOptions.f18494h);
                    this.i = visitor.a(v(), this.i, messageOptions.v(), messageOptions.i);
                    this.j = visitor.a(s(), this.j, messageOptions.s(), messageOptions.j);
                    this.k = visitor.a(t(), this.k, messageOptions.t(), messageOptions.k);
                    this.l = visitor.a(this.l, messageOptions.l);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18493g |= messageOptions.f18493g;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x == 8) {
                                        this.f18493g |= 1;
                                        this.f18494h = codedInputStream.c();
                                    } else if (x == 16) {
                                        this.f18493g |= 2;
                                        this.i = codedInputStream.c();
                                    } else if (x == 24) {
                                        this.f18493g |= 4;
                                        this.j = codedInputStream.c();
                                    } else if (x == 56) {
                                        this.f18493g |= 8;
                                        this.k = codedInputStream.c();
                                    } else if (x != 7994) {
                                        if (!a((MessageOptions) a(), codedInputStream, extensionRegistryLite, x)) {
                                        }
                                    } else {
                                        if (!this.l.M()) {
                                            this.l = GeneratedMessageLite.a(this.l);
                                        }
                                        this.l.add((UninterpretedOption) codedInputStream.a(UninterpretedOption.w(), extensionRegistryLite));
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
                    if (f18492f == null) {
                        synchronized (MessageOptions.class) {
                            if (f18492f == null) {
                                f18492f = new GeneratedMessageLite.DefaultInstanceBasedParser(f18491e);
                            }
                        }
                    }
                    return f18492f;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18491e;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface MessageOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<MessageOptions, MessageOptions.Builder> {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface MethodDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class MethodOptions extends GeneratedMessageLite.ExtendableMessage<MethodOptions, Builder> implements MethodOptionsOrBuilder {

        /* renamed from: e, reason: collision with root package name */
        private static final MethodOptions f18500e = new MethodOptions();

        /* renamed from: f, reason: collision with root package name */
        private static volatile Parser<MethodOptions> f18501f;

        /* renamed from: g, reason: collision with root package name */
        private int f18502g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f18503h;
        private int i;
        private byte k = -1;
        private Internal.ProtobufList<UninterpretedOption> j = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<MethodOptions, Builder> implements MethodOptionsOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(MethodOptions.f18500e);
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public enum IdempotencyLevel implements Internal.EnumLite {
            IDEMPOTENCY_UNKNOWN(0),
            NO_SIDE_EFFECTS(1),
            IDEMPOTENT(2);

            public static final int IDEMPOTENCY_UNKNOWN_VALUE = 0;
            public static final int IDEMPOTENT_VALUE = 2;
            public static final int NO_SIDE_EFFECTS_VALUE = 1;
            private static final Internal.EnumLiteMap<IdempotencyLevel> internalValueMap = new C1660n();
            private final int value;

            IdempotencyLevel(int i) {
                this.value = i;
            }

            public static IdempotencyLevel forNumber(int i) {
                if (i == 0) {
                    return IDEMPOTENCY_UNKNOWN;
                }
                if (i == 1) {
                    return NO_SIDE_EFFECTS;
                }
                if (i != 2) {
                    return null;
                }
                return IDEMPOTENT;
            }

            public static Internal.EnumLiteMap<IdempotencyLevel> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static IdempotencyLevel valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            f18500e.l();
        }

        private MethodOptions() {
        }

        public static MethodOptions q() {
            return f18500e;
        }

        public static Parser<MethodOptions> u() {
            return f18500e.f();
        }

        public UninterpretedOption a(int i) {
            return this.j.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18502g & 1) == 1 ? CodedOutputStream.a(33, this.f18503h) + 0 : 0;
            if ((this.f18502g & 2) == 2) {
                a2 += CodedOutputStream.a(34, this.i);
            }
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                a2 += CodedOutputStream.a(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.j.get(i2));
            }
            int n = a2 + n() + this.f18583b.c();
            this.f18584c = n;
            return n;
        }

        public int r() {
            return this.j.size();
        }

        public boolean s() {
            return (this.f18502g & 1) == 1;
        }

        public boolean t() {
            return (this.f18502g & 2) == 2;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter o = o();
            if ((this.f18502g & 1) == 1) {
                codedOutputStream.b(33, this.f18503h);
            }
            if ((this.f18502g & 2) == 2) {
                codedOutputStream.e(34, this.i);
            }
            for (int i = 0; i < this.j.size(); i++) {
                codedOutputStream.c(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.j.get(i));
            }
            o.a(536870912, codedOutputStream);
            this.f18583b.a(codedOutputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new MethodOptions();
                case 2:
                    byte b2 = this.k;
                    if (b2 == 1) {
                        return f18500e;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < r(); i++) {
                        if (!a(i).isInitialized()) {
                            if (booleanValue) {
                                this.k = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (m()) {
                        if (booleanValue) {
                            this.k = (byte) 1;
                        }
                        return f18500e;
                    }
                    if (booleanValue) {
                        this.k = (byte) 0;
                    }
                    return null;
                case 3:
                    this.j.L();
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    MethodOptions methodOptions = (MethodOptions) obj2;
                    this.f18503h = visitor.a(s(), this.f18503h, methodOptions.s(), methodOptions.f18503h);
                    this.i = visitor.a(t(), this.i, methodOptions.t(), methodOptions.i);
                    this.j = visitor.a(this.j, methodOptions.j);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18502g |= methodOptions.f18502g;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 264) {
                                    this.f18502g |= 1;
                                    this.f18503h = codedInputStream.c();
                                } else if (x == 272) {
                                    int f2 = codedInputStream.f();
                                    if (IdempotencyLevel.forNumber(f2) == null) {
                                        super.a(34, f2);
                                    } else {
                                        this.f18502g |= 2;
                                        this.i = f2;
                                    }
                                } else if (x != 7994) {
                                    if (!a((MethodOptions) a(), codedInputStream, extensionRegistryLite, x)) {
                                    }
                                } else {
                                    if (!this.j.M()) {
                                        this.j = GeneratedMessageLite.a(this.j);
                                    }
                                    this.j.add((UninterpretedOption) codedInputStream.a(UninterpretedOption.w(), extensionRegistryLite));
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
                    if (f18501f == null) {
                        synchronized (MethodOptions.class) {
                            if (f18501f == null) {
                                f18501f = new GeneratedMessageLite.DefaultInstanceBasedParser(f18500e);
                            }
                        }
                    }
                    return f18501f;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18500e;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface MethodOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<MethodOptions, MethodOptions.Builder> {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface OneofDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class OneofOptions extends GeneratedMessageLite.ExtendableMessage<OneofOptions, Builder> implements OneofOptionsOrBuilder {

        /* renamed from: e, reason: collision with root package name */
        private static final OneofOptions f18509e = new OneofOptions();

        /* renamed from: f, reason: collision with root package name */
        private static volatile Parser<OneofOptions> f18510f;

        /* renamed from: h, reason: collision with root package name */
        private byte f18512h = -1;

        /* renamed from: g, reason: collision with root package name */
        private Internal.ProtobufList<UninterpretedOption> f18511g = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<OneofOptions, Builder> implements OneofOptionsOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(OneofOptions.f18509e);
            }
        }

        static {
            f18509e.l();
        }

        private OneofOptions() {
        }

        public static OneofOptions q() {
            return f18509e;
        }

        public static Parser<OneofOptions> s() {
            return f18509e.f();
        }

        public UninterpretedOption a(int i) {
            return this.f18511g.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f18511g.size(); i3++) {
                i2 += CodedOutputStream.a(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.f18511g.get(i3));
            }
            int n = i2 + n() + this.f18583b.c();
            this.f18584c = n;
            return n;
        }

        public int r() {
            return this.f18511g.size();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter o = o();
            for (int i = 0; i < this.f18511g.size(); i++) {
                codedOutputStream.c(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.f18511g.get(i));
            }
            o.a(536870912, codedOutputStream);
            this.f18583b.a(codedOutputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new OneofOptions();
                case 2:
                    byte b2 = this.f18512h;
                    if (b2 == 1) {
                        return f18509e;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < r(); i++) {
                        if (!a(i).isInitialized()) {
                            if (booleanValue) {
                                this.f18512h = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (m()) {
                        if (booleanValue) {
                            this.f18512h = (byte) 1;
                        }
                        return f18509e;
                    }
                    if (booleanValue) {
                        this.f18512h = (byte) 0;
                    }
                    return null;
                case 3:
                    this.f18511g.L();
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    this.f18511g = ((GeneratedMessageLite.Visitor) obj).a(this.f18511g, ((OneofOptions) obj2).f18511g);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x != 7994) {
                                    if (!a((OneofOptions) a(), codedInputStream, extensionRegistryLite, x)) {
                                    }
                                } else {
                                    if (!this.f18511g.M()) {
                                        this.f18511g = GeneratedMessageLite.a(this.f18511g);
                                    }
                                    this.f18511g.add((UninterpretedOption) codedInputStream.a(UninterpretedOption.w(), extensionRegistryLite));
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
                    if (f18510f == null) {
                        synchronized (OneofOptions.class) {
                            if (f18510f == null) {
                                f18510f = new GeneratedMessageLite.DefaultInstanceBasedParser(f18509e);
                            }
                        }
                    }
                    return f18510f;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18509e;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface OneofOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<OneofOptions, OneofOptions.Builder> {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class ServiceDescriptorProto extends GeneratedMessageLite<ServiceDescriptorProto, Builder> implements ServiceDescriptorProtoOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final ServiceDescriptorProto f18513d = new ServiceDescriptorProto();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<ServiceDescriptorProto> f18514e;

        /* renamed from: f, reason: collision with root package name */
        private int f18515f;
        private ServiceOptions i;
        private byte j = -1;

        /* renamed from: g, reason: collision with root package name */
        private String f18516g = "";

        /* renamed from: h, reason: collision with root package name */
        private Internal.ProtobufList<MethodDescriptorProto> f18517h = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ServiceDescriptorProto, Builder> implements ServiceDescriptorProtoOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(ServiceDescriptorProto.f18513d);
            }
        }

        static {
            f18513d.l();
        }

        private ServiceDescriptorProto() {
        }

        public static Parser<ServiceDescriptorProto> s() {
            return f18513d.f();
        }

        public MethodDescriptorProto a(int i) {
            return this.f18517h.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18515f & 1) == 1 ? CodedOutputStream.a(1, o()) + 0 : 0;
            for (int i2 = 0; i2 < this.f18517h.size(); i2++) {
                a2 += CodedOutputStream.a(2, this.f18517h.get(i2));
            }
            if ((this.f18515f & 2) == 2) {
                a2 += CodedOutputStream.a(3, p());
            }
            int c2 = a2 + this.f18583b.c();
            this.f18584c = c2;
            return c2;
        }

        public int n() {
            return this.f18517h.size();
        }

        public String o() {
            return this.f18516g;
        }

        public ServiceOptions p() {
            ServiceOptions serviceOptions = this.i;
            return serviceOptions == null ? ServiceOptions.q() : serviceOptions;
        }

        public boolean q() {
            return (this.f18515f & 1) == 1;
        }

        public boolean r() {
            return (this.f18515f & 2) == 2;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.f18515f & 1) == 1) {
                codedOutputStream.b(1, o());
            }
            for (int i = 0; i < this.f18517h.size(); i++) {
                codedOutputStream.c(2, this.f18517h.get(i));
            }
            if ((this.f18515f & 2) == 2) {
                codedOutputStream.c(3, p());
            }
            this.f18583b.a(codedOutputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ServiceDescriptorProto();
                case 2:
                    byte b2 = this.j;
                    if (b2 == 1) {
                        return f18513d;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < n(); i++) {
                        if (!a(i).isInitialized()) {
                            if (booleanValue) {
                                this.j = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (!r() || p().isInitialized()) {
                        if (booleanValue) {
                            this.j = (byte) 1;
                        }
                        return f18513d;
                    }
                    if (booleanValue) {
                        this.j = (byte) 0;
                    }
                    return null;
                case 3:
                    this.f18517h.L();
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ServiceDescriptorProto serviceDescriptorProto = (ServiceDescriptorProto) obj2;
                    this.f18516g = visitor.a(q(), this.f18516g, serviceDescriptorProto.q(), serviceDescriptorProto.f18516g);
                    this.f18517h = visitor.a(this.f18517h, serviceDescriptorProto.f18517h);
                    this.i = (ServiceOptions) visitor.a(this.i, serviceDescriptorProto.i);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18515f |= serviceDescriptorProto.f18515f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    String v = codedInputStream.v();
                                    this.f18515f |= 1;
                                    this.f18516g = v;
                                } else if (x == 18) {
                                    if (!this.f18517h.M()) {
                                        this.f18517h = GeneratedMessageLite.a(this.f18517h);
                                    }
                                    this.f18517h.add((MethodDescriptorProto) codedInputStream.a(MethodDescriptorProto.x(), extensionRegistryLite));
                                } else if (x != 26) {
                                    if (!a(x, codedInputStream)) {
                                    }
                                } else {
                                    ServiceOptions.Builder builder = (this.f18515f & 2) == 2 ? (ServiceOptions.Builder) this.i.b() : null;
                                    this.i = (ServiceOptions) codedInputStream.a(ServiceOptions.t(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.b((ServiceOptions.Builder) this.i);
                                        this.i = builder.T();
                                    }
                                    this.f18515f |= 2;
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
                    if (f18514e == null) {
                        synchronized (ServiceDescriptorProto.class) {
                            if (f18514e == null) {
                                f18514e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18513d);
                            }
                        }
                    }
                    return f18514e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18513d;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface ServiceDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class ServiceOptions extends GeneratedMessageLite.ExtendableMessage<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {

        /* renamed from: e, reason: collision with root package name */
        private static final ServiceOptions f18518e = new ServiceOptions();

        /* renamed from: f, reason: collision with root package name */
        private static volatile Parser<ServiceOptions> f18519f;

        /* renamed from: g, reason: collision with root package name */
        private int f18520g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f18521h;
        private byte j = -1;
        private Internal.ProtobufList<UninterpretedOption> i = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(ServiceOptions.f18518e);
            }
        }

        static {
            f18518e.l();
        }

        private ServiceOptions() {
        }

        public static ServiceOptions q() {
            return f18518e;
        }

        public static Parser<ServiceOptions> t() {
            return f18518e.f();
        }

        public UninterpretedOption a(int i) {
            return this.i.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18520g & 1) == 1 ? CodedOutputStream.a(33, this.f18521h) + 0 : 0;
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                a2 += CodedOutputStream.a(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.i.get(i2));
            }
            int n = a2 + n() + this.f18583b.c();
            this.f18584c = n;
            return n;
        }

        public int r() {
            return this.i.size();
        }

        public boolean s() {
            return (this.f18520g & 1) == 1;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter o = o();
            if ((this.f18520g & 1) == 1) {
                codedOutputStream.b(33, this.f18521h);
            }
            for (int i = 0; i < this.i.size(); i++) {
                codedOutputStream.c(SemanticAnnotations.SemanticType.ST_NOT_REQUIRED_VALUE, this.i.get(i));
            }
            o.a(536870912, codedOutputStream);
            this.f18583b.a(codedOutputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ServiceOptions();
                case 2:
                    byte b2 = this.j;
                    if (b2 == 1) {
                        return f18518e;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < r(); i++) {
                        if (!a(i).isInitialized()) {
                            if (booleanValue) {
                                this.j = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (m()) {
                        if (booleanValue) {
                            this.j = (byte) 1;
                        }
                        return f18518e;
                    }
                    if (booleanValue) {
                        this.j = (byte) 0;
                    }
                    return null;
                case 3:
                    this.i.L();
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ServiceOptions serviceOptions = (ServiceOptions) obj2;
                    this.f18521h = visitor.a(s(), this.f18521h, serviceOptions.s(), serviceOptions.f18521h);
                    this.i = visitor.a(this.i, serviceOptions.i);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18520g |= serviceOptions.f18520g;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 264) {
                                    this.f18520g |= 1;
                                    this.f18521h = codedInputStream.c();
                                } else if (x != 7994) {
                                    if (!a((ServiceOptions) a(), codedInputStream, extensionRegistryLite, x)) {
                                    }
                                } else {
                                    if (!this.i.M()) {
                                        this.i = GeneratedMessageLite.a(this.i);
                                    }
                                    this.i.add((UninterpretedOption) codedInputStream.a(UninterpretedOption.w(), extensionRegistryLite));
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
                    if (f18519f == null) {
                        synchronized (ServiceOptions.class) {
                            if (f18519f == null) {
                                f18519f = new GeneratedMessageLite.DefaultInstanceBasedParser(f18518e);
                            }
                        }
                    }
                    return f18519f;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18518e;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface ServiceOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<ServiceOptions, ServiceOptions.Builder> {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface SourceCodeInfoOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class UninterpretedOption extends GeneratedMessageLite<UninterpretedOption, Builder> implements UninterpretedOptionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final UninterpretedOption f18530d = new UninterpretedOption();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<UninterpretedOption> f18531e;

        /* renamed from: f, reason: collision with root package name */
        private int f18532f;
        private long i;
        private long j;
        private double k;
        private byte n = -1;

        /* renamed from: g, reason: collision with root package name */
        private Internal.ProtobufList<NamePart> f18533g = GeneratedMessageLite.k();

        /* renamed from: h, reason: collision with root package name */
        private String f18534h = "";
        private ByteString l = ByteString.EMPTY;
        private String m = "";

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<UninterpretedOption, Builder> implements UninterpretedOptionOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(UninterpretedOption.f18530d);
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public interface NamePartOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            f18530d.l();
        }

        private UninterpretedOption() {
        }

        public static Parser<UninterpretedOption> w() {
            return f18530d.f();
        }

        public NamePart a(int i) {
            return this.f18533g.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f18533g.size(); i3++) {
                i2 += CodedOutputStream.a(2, this.f18533g.get(i3));
            }
            if ((this.f18532f & 1) == 1) {
                i2 += CodedOutputStream.a(3, o());
            }
            if ((this.f18532f & 2) == 2) {
                i2 += CodedOutputStream.c(4, this.i);
            }
            if ((this.f18532f & 4) == 4) {
                i2 += CodedOutputStream.b(5, this.j);
            }
            if ((this.f18532f & 8) == 8) {
                i2 += CodedOutputStream.a(6, this.k);
            }
            if ((this.f18532f & 16) == 16) {
                i2 += CodedOutputStream.a(7, this.l);
            }
            if ((this.f18532f & 32) == 32) {
                i2 += CodedOutputStream.a(8, n());
            }
            int c2 = i2 + this.f18583b.c();
            this.f18584c = c2;
            return c2;
        }

        public String n() {
            return this.m;
        }

        public String o() {
            return this.f18534h;
        }

        public int p() {
            return this.f18533g.size();
        }

        public boolean q() {
            return (this.f18532f & 32) == 32;
        }

        public boolean r() {
            return (this.f18532f & 8) == 8;
        }

        public boolean s() {
            return (this.f18532f & 1) == 1;
        }

        public boolean t() {
            return (this.f18532f & 4) == 4;
        }

        public boolean u() {
            return (this.f18532f & 2) == 2;
        }

        public boolean v() {
            return (this.f18532f & 16) == 16;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.f18533g.size(); i++) {
                codedOutputStream.c(2, this.f18533g.get(i));
            }
            if ((this.f18532f & 1) == 1) {
                codedOutputStream.b(3, o());
            }
            if ((this.f18532f & 2) == 2) {
                codedOutputStream.f(4, this.i);
            }
            if ((this.f18532f & 4) == 4) {
                codedOutputStream.e(5, this.j);
            }
            if ((this.f18532f & 8) == 8) {
                codedOutputStream.b(6, this.k);
            }
            if ((this.f18532f & 16) == 16) {
                codedOutputStream.b(7, this.l);
            }
            if ((this.f18532f & 32) == 32) {
                codedOutputStream.b(8, n());
            }
            this.f18583b.a(codedOutputStream);
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class NamePart extends GeneratedMessageLite<NamePart, Builder> implements NamePartOrBuilder {

            /* renamed from: d, reason: collision with root package name */
            private static final NamePart f18535d = new NamePart();

            /* renamed from: e, reason: collision with root package name */
            private static volatile Parser<NamePart> f18536e;

            /* renamed from: f, reason: collision with root package name */
            private int f18537f;

            /* renamed from: h, reason: collision with root package name */
            private boolean f18539h;
            private byte i = -1;

            /* renamed from: g, reason: collision with root package name */
            private String f18538g = "";

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<NamePart, Builder> implements NamePartOrBuilder {
                /* synthetic */ Builder(C1654h c1654h) {
                    this();
                }

                private Builder() {
                    super(NamePart.f18535d);
                }
            }

            static {
                f18535d.l();
            }

            private NamePart() {
            }

            public static Parser<NamePart> q() {
                return f18535d.f();
            }

            @Override // com.google.protobuf.MessageLite
            public void a(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.f18537f & 1) == 1) {
                    codedOutputStream.b(1, n());
                }
                if ((this.f18537f & 2) == 2) {
                    codedOutputStream.b(2, this.f18539h);
                }
                this.f18583b.a(codedOutputStream);
            }

            @Override // com.google.protobuf.MessageLite
            public int d() {
                int i = this.f18584c;
                if (i != -1) {
                    return i;
                }
                int a2 = (this.f18537f & 1) == 1 ? 0 + CodedOutputStream.a(1, n()) : 0;
                if ((this.f18537f & 2) == 2) {
                    a2 += CodedOutputStream.a(2, this.f18539h);
                }
                int c2 = a2 + this.f18583b.c();
                this.f18584c = c2;
                return c2;
            }

            public String n() {
                return this.f18538g;
            }

            public boolean o() {
                return (this.f18537f & 2) == 2;
            }

            public boolean p() {
                return (this.f18537f & 1) == 1;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                boolean z = false;
                C1654h c1654h = null;
                switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new NamePart();
                    case 2:
                        byte b2 = this.i;
                        if (b2 == 1) {
                            return f18535d;
                        }
                        if (b2 == 0) {
                            return null;
                        }
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        if (!p()) {
                            if (booleanValue) {
                                this.i = (byte) 0;
                            }
                            return null;
                        }
                        if (o()) {
                            if (booleanValue) {
                                this.i = (byte) 1;
                            }
                            return f18535d;
                        }
                        if (booleanValue) {
                            this.i = (byte) 0;
                        }
                        return null;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(c1654h);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        NamePart namePart = (NamePart) obj2;
                        this.f18538g = visitor.a(p(), this.f18538g, namePart.p(), namePart.f18538g);
                        this.f18539h = visitor.a(o(), this.f18539h, namePart.o(), namePart.f18539h);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                            this.f18537f |= namePart.f18537f;
                        }
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        while (!z) {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x == 10) {
                                        String v = codedInputStream.v();
                                        this.f18537f |= 1;
                                        this.f18538g = v;
                                    } else if (x != 16) {
                                        if (!a(x, codedInputStream)) {
                                        }
                                    } else {
                                        this.f18537f |= 2;
                                        this.f18539h = codedInputStream.c();
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
                        if (f18536e == null) {
                            synchronized (NamePart.class) {
                                if (f18536e == null) {
                                    f18536e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18535d);
                                }
                            }
                        }
                        return f18536e;
                    default:
                        throw new UnsupportedOperationException();
                }
                return f18535d;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new UninterpretedOption();
                case 2:
                    byte b2 = this.n;
                    if (b2 == 1) {
                        return f18530d;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < p(); i++) {
                        if (!a(i).isInitialized()) {
                            if (booleanValue) {
                                this.n = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (booleanValue) {
                        this.n = (byte) 1;
                    }
                    return f18530d;
                case 3:
                    this.f18533g.L();
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    UninterpretedOption uninterpretedOption = (UninterpretedOption) obj2;
                    this.f18533g = visitor.a(this.f18533g, uninterpretedOption.f18533g);
                    this.f18534h = visitor.a(s(), this.f18534h, uninterpretedOption.s(), uninterpretedOption.f18534h);
                    this.i = visitor.a(u(), this.i, uninterpretedOption.u(), uninterpretedOption.i);
                    this.j = visitor.a(t(), this.j, uninterpretedOption.t(), uninterpretedOption.j);
                    this.k = visitor.a(r(), this.k, uninterpretedOption.r(), uninterpretedOption.k);
                    this.l = visitor.a(v(), this.l, uninterpretedOption.v(), uninterpretedOption.l);
                    this.m = visitor.a(q(), this.m, uninterpretedOption.q(), uninterpretedOption.m);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18532f |= uninterpretedOption.f18532f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 18) {
                                    if (!this.f18533g.M()) {
                                        this.f18533g = GeneratedMessageLite.a(this.f18533g);
                                    }
                                    this.f18533g.add((NamePart) codedInputStream.a(NamePart.q(), extensionRegistryLite));
                                } else if (x == 26) {
                                    String v = codedInputStream.v();
                                    this.f18532f |= 1;
                                    this.f18534h = v;
                                } else if (x == 32) {
                                    this.f18532f |= 2;
                                    this.i = codedInputStream.z();
                                } else if (x == 40) {
                                    this.f18532f |= 4;
                                    this.j = codedInputStream.k();
                                } else if (x == 49) {
                                    this.f18532f |= 8;
                                    this.k = codedInputStream.e();
                                } else if (x == 58) {
                                    this.f18532f |= 16;
                                    this.l = codedInputStream.d();
                                } else if (x != 66) {
                                    if (!a(x, codedInputStream)) {
                                    }
                                } else {
                                    String v2 = codedInputStream.v();
                                    this.f18532f = 32 | this.f18532f;
                                    this.m = v2;
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
                    if (f18531e == null) {
                        synchronized (UninterpretedOption.class) {
                            if (f18531e == null) {
                                f18531e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18530d);
                            }
                        }
                    }
                    return f18531e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18530d;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface UninterpretedOptionOrBuilder extends MessageLiteOrBuilder {
    }

    private DescriptorProtos() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class GeneratedCodeInfo extends GeneratedMessageLite<GeneratedCodeInfo, Builder> implements GeneratedCodeInfoOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final GeneratedCodeInfo f18483d = new GeneratedCodeInfo();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<GeneratedCodeInfo> f18484e;

        /* renamed from: f, reason: collision with root package name */
        private Internal.ProtobufList<Annotation> f18485f = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public interface AnnotationOrBuilder extends MessageLiteOrBuilder {
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<GeneratedCodeInfo, Builder> implements GeneratedCodeInfoOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(GeneratedCodeInfo.f18483d);
            }
        }

        static {
            f18483d.l();
        }

        private GeneratedCodeInfo() {
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.f18485f.size(); i++) {
                codedOutputStream.c(1, this.f18485f.get(i));
            }
            this.f18583b.a(codedOutputStream);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f18485f.size(); i3++) {
                i2 += CodedOutputStream.a(1, this.f18485f.get(i3));
            }
            int c2 = i2 + this.f18583b.c();
            this.f18584c = c2;
            return c2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new GeneratedCodeInfo();
                case 2:
                    return f18483d;
                case 3:
                    this.f18485f.L();
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    this.f18485f = ((GeneratedMessageLite.Visitor) obj).a(this.f18485f, ((GeneratedCodeInfo) obj2).f18485f);
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
                                        if (!a(x, codedInputStream)) {
                                        }
                                    } else {
                                        if (!this.f18485f.M()) {
                                            this.f18485f = GeneratedMessageLite.a(this.f18485f);
                                        }
                                        this.f18485f.add((Annotation) codedInputStream.a(Annotation.s(), extensionRegistryLite));
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
                    if (f18484e == null) {
                        synchronized (GeneratedCodeInfo.class) {
                            if (f18484e == null) {
                                f18484e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18483d);
                            }
                        }
                    }
                    return f18484e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18483d;
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Annotation extends GeneratedMessageLite<Annotation, Builder> implements AnnotationOrBuilder {

            /* renamed from: d, reason: collision with root package name */
            private static final Annotation f18486d = new Annotation();

            /* renamed from: e, reason: collision with root package name */
            private static volatile Parser<Annotation> f18487e;

            /* renamed from: f, reason: collision with root package name */
            private int f18488f;
            private int j;
            private int k;

            /* renamed from: h, reason: collision with root package name */
            private int f18490h = -1;

            /* renamed from: g, reason: collision with root package name */
            private Internal.IntList f18489g = GeneratedMessageLite.i();
            private String i = "";

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Annotation, Builder> implements AnnotationOrBuilder {
                /* synthetic */ Builder(C1654h c1654h) {
                    this();
                }

                private Builder() {
                    super(Annotation.f18486d);
                }
            }

            static {
                f18486d.l();
            }

            private Annotation() {
            }

            public static Parser<Annotation> s() {
                return f18486d.f();
            }

            @Override // com.google.protobuf.MessageLite
            public void a(CodedOutputStream codedOutputStream) throws IOException {
                d();
                if (n().size() > 0) {
                    codedOutputStream.r(10);
                    codedOutputStream.r(this.f18490h);
                }
                for (int i = 0; i < this.f18489g.size(); i++) {
                    codedOutputStream.n(this.f18489g.getInt(i));
                }
                if ((this.f18488f & 1) == 1) {
                    codedOutputStream.b(2, o());
                }
                if ((this.f18488f & 2) == 2) {
                    codedOutputStream.g(3, this.j);
                }
                if ((this.f18488f & 4) == 4) {
                    codedOutputStream.g(4, this.k);
                }
                this.f18583b.a(codedOutputStream);
            }

            @Override // com.google.protobuf.MessageLite
            public int d() {
                int i = this.f18584c;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                for (int i3 = 0; i3 < this.f18489g.size(); i3++) {
                    i2 += CodedOutputStream.c(this.f18489g.getInt(i3));
                }
                int i4 = 0 + i2;
                if (!n().isEmpty()) {
                    i4 = i4 + 1 + CodedOutputStream.c(i2);
                }
                this.f18490h = i2;
                if ((this.f18488f & 1) == 1) {
                    i4 += CodedOutputStream.a(2, o());
                }
                if ((this.f18488f & 2) == 2) {
                    i4 += CodedOutputStream.c(3, this.j);
                }
                if ((this.f18488f & 4) == 4) {
                    i4 += CodedOutputStream.c(4, this.k);
                }
                int c2 = i4 + this.f18583b.c();
                this.f18584c = c2;
                return c2;
            }

            public List<Integer> n() {
                return this.f18489g;
            }

            public String o() {
                return this.i;
            }

            public boolean p() {
                return (this.f18488f & 2) == 2;
            }

            public boolean q() {
                return (this.f18488f & 4) == 4;
            }

            public boolean r() {
                return (this.f18488f & 1) == 1;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                C1654h c1654h = null;
                switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Annotation();
                    case 2:
                        return f18486d;
                    case 3:
                        this.f18489g.L();
                        return null;
                    case 4:
                        return new Builder(c1654h);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        Annotation annotation = (Annotation) obj2;
                        this.f18489g = visitor.a(this.f18489g, annotation.f18489g);
                        this.i = visitor.a(r(), this.i, annotation.r(), annotation.i);
                        this.j = visitor.a(p(), this.j, annotation.p(), annotation.j);
                        this.k = visitor.a(q(), this.k, annotation.q(), annotation.k);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                            this.f18488f |= annotation.f18488f;
                        }
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        boolean z = false;
                        while (!z) {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x == 8) {
                                        if (!this.f18489g.M()) {
                                            this.f18489g = GeneratedMessageLite.a(this.f18489g);
                                        }
                                        this.f18489g.i(codedInputStream.j());
                                    } else if (x == 10) {
                                        int d2 = codedInputStream.d(codedInputStream.o());
                                        if (!this.f18489g.M() && codedInputStream.a() > 0) {
                                            this.f18489g = GeneratedMessageLite.a(this.f18489g);
                                        }
                                        while (codedInputStream.a() > 0) {
                                            this.f18489g.i(codedInputStream.j());
                                        }
                                        codedInputStream.c(d2);
                                    } else if (x == 18) {
                                        String v = codedInputStream.v();
                                        this.f18488f = 1 | this.f18488f;
                                        this.i = v;
                                    } else if (x == 24) {
                                        this.f18488f |= 2;
                                        this.j = codedInputStream.j();
                                    } else if (x != 32) {
                                        if (!a(x, codedInputStream)) {
                                        }
                                    } else {
                                        this.f18488f |= 4;
                                        this.k = codedInputStream.j();
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
                        if (f18487e == null) {
                            synchronized (Annotation.class) {
                                if (f18487e == null) {
                                    f18487e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18486d);
                                }
                            }
                        }
                        return f18487e;
                    default:
                        throw new UnsupportedOperationException();
                }
                return f18486d;
            }
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class SourceCodeInfo extends GeneratedMessageLite<SourceCodeInfo, Builder> implements SourceCodeInfoOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final SourceCodeInfo f18522d = new SourceCodeInfo();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<SourceCodeInfo> f18523e;

        /* renamed from: f, reason: collision with root package name */
        private Internal.ProtobufList<Location> f18524f = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<SourceCodeInfo, Builder> implements SourceCodeInfoOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(SourceCodeInfo.f18522d);
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public interface LocationOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            f18522d.l();
        }

        private SourceCodeInfo() {
        }

        public static SourceCodeInfo n() {
            return f18522d;
        }

        public static Parser<SourceCodeInfo> o() {
            return f18522d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.f18524f.size(); i++) {
                codedOutputStream.c(1, this.f18524f.get(i));
            }
            this.f18583b.a(codedOutputStream);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f18524f.size(); i3++) {
                i2 += CodedOutputStream.a(1, this.f18524f.get(i3));
            }
            int c2 = i2 + this.f18583b.c();
            this.f18584c = c2;
            return c2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new SourceCodeInfo();
                case 2:
                    return f18522d;
                case 3:
                    this.f18524f.L();
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    this.f18524f = ((GeneratedMessageLite.Visitor) obj).a(this.f18524f, ((SourceCodeInfo) obj2).f18524f);
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
                                        if (!a(x, codedInputStream)) {
                                        }
                                    } else {
                                        if (!this.f18524f.M()) {
                                            this.f18524f = GeneratedMessageLite.a(this.f18524f);
                                        }
                                        this.f18524f.add((Location) codedInputStream.a(Location.u(), extensionRegistryLite));
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
                    if (f18523e == null) {
                        synchronized (SourceCodeInfo.class) {
                            if (f18523e == null) {
                                f18523e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18522d);
                            }
                        }
                    }
                    return f18523e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18522d;
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Location extends GeneratedMessageLite<Location, Builder> implements LocationOrBuilder {

            /* renamed from: d, reason: collision with root package name */
            private static final Location f18525d = new Location();

            /* renamed from: e, reason: collision with root package name */
            private static volatile Parser<Location> f18526e;

            /* renamed from: f, reason: collision with root package name */
            private int f18527f;

            /* renamed from: h, reason: collision with root package name */
            private int f18529h = -1;
            private int j = -1;

            /* renamed from: g, reason: collision with root package name */
            private Internal.IntList f18528g = GeneratedMessageLite.i();
            private Internal.IntList i = GeneratedMessageLite.i();
            private String k = "";
            private String l = "";
            private Internal.ProtobufList<String> m = GeneratedMessageLite.k();

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Location, Builder> implements LocationOrBuilder {
                /* synthetic */ Builder(C1654h c1654h) {
                    this();
                }

                private Builder() {
                    super(Location.f18525d);
                }
            }

            static {
                f18525d.l();
            }

            private Location() {
            }

            public static Parser<Location> u() {
                return f18525d.f();
            }

            @Override // com.google.protobuf.MessageLite
            public void a(CodedOutputStream codedOutputStream) throws IOException {
                d();
                if (p().size() > 0) {
                    codedOutputStream.r(10);
                    codedOutputStream.r(this.f18529h);
                }
                for (int i = 0; i < this.f18528g.size(); i++) {
                    codedOutputStream.n(this.f18528g.getInt(i));
                }
                if (q().size() > 0) {
                    codedOutputStream.r(18);
                    codedOutputStream.r(this.j);
                }
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    codedOutputStream.n(this.i.getInt(i2));
                }
                if ((this.f18527f & 1) == 1) {
                    codedOutputStream.b(3, n());
                }
                if ((this.f18527f & 2) == 2) {
                    codedOutputStream.b(4, r());
                }
                for (int i3 = 0; i3 < this.m.size(); i3++) {
                    codedOutputStream.b(6, this.m.get(i3));
                }
                this.f18583b.a(codedOutputStream);
            }

            @Override // com.google.protobuf.MessageLite
            public int d() {
                int i = this.f18584c;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                for (int i3 = 0; i3 < this.f18528g.size(); i3++) {
                    i2 += CodedOutputStream.c(this.f18528g.getInt(i3));
                }
                int i4 = 0 + i2;
                if (!p().isEmpty()) {
                    i4 = i4 + 1 + CodedOutputStream.c(i2);
                }
                this.f18529h = i2;
                int i5 = 0;
                for (int i6 = 0; i6 < this.i.size(); i6++) {
                    i5 += CodedOutputStream.c(this.i.getInt(i6));
                }
                int i7 = i4 + i5;
                if (!q().isEmpty()) {
                    i7 = i7 + 1 + CodedOutputStream.c(i5);
                }
                this.j = i5;
                if ((this.f18527f & 1) == 1) {
                    i7 += CodedOutputStream.a(3, n());
                }
                if ((this.f18527f & 2) == 2) {
                    i7 += CodedOutputStream.a(4, r());
                }
                int i8 = 0;
                for (int i9 = 0; i9 < this.m.size(); i9++) {
                    i8 += CodedOutputStream.a(this.m.get(i9));
                }
                int size = i7 + i8 + (o().size() * 1) + this.f18583b.c();
                this.f18584c = size;
                return size;
            }

            public String n() {
                return this.k;
            }

            public List<String> o() {
                return this.m;
            }

            public List<Integer> p() {
                return this.f18528g;
            }

            public List<Integer> q() {
                return this.i;
            }

            public String r() {
                return this.l;
            }

            public boolean s() {
                return (this.f18527f & 1) == 1;
            }

            public boolean t() {
                return (this.f18527f & 2) == 2;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                C1654h c1654h = null;
                switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Location();
                    case 2:
                        return f18525d;
                    case 3:
                        this.f18528g.L();
                        this.i.L();
                        this.m.L();
                        return null;
                    case 4:
                        return new Builder(c1654h);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        Location location = (Location) obj2;
                        this.f18528g = visitor.a(this.f18528g, location.f18528g);
                        this.i = visitor.a(this.i, location.i);
                        this.k = visitor.a(s(), this.k, location.s(), location.k);
                        this.l = visitor.a(t(), this.l, location.t(), location.l);
                        this.m = visitor.a(this.m, location.m);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                            this.f18527f |= location.f18527f;
                        }
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        boolean z = false;
                        while (!z) {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x == 8) {
                                        if (!this.f18528g.M()) {
                                            this.f18528g = GeneratedMessageLite.a(this.f18528g);
                                        }
                                        this.f18528g.i(codedInputStream.j());
                                    } else if (x == 10) {
                                        int d2 = codedInputStream.d(codedInputStream.o());
                                        if (!this.f18528g.M() && codedInputStream.a() > 0) {
                                            this.f18528g = GeneratedMessageLite.a(this.f18528g);
                                        }
                                        while (codedInputStream.a() > 0) {
                                            this.f18528g.i(codedInputStream.j());
                                        }
                                        codedInputStream.c(d2);
                                    } else if (x == 16) {
                                        if (!this.i.M()) {
                                            this.i = GeneratedMessageLite.a(this.i);
                                        }
                                        this.i.i(codedInputStream.j());
                                    } else if (x == 18) {
                                        int d3 = codedInputStream.d(codedInputStream.o());
                                        if (!this.i.M() && codedInputStream.a() > 0) {
                                            this.i = GeneratedMessageLite.a(this.i);
                                        }
                                        while (codedInputStream.a() > 0) {
                                            this.i.i(codedInputStream.j());
                                        }
                                        codedInputStream.c(d3);
                                    } else if (x == 26) {
                                        String v = codedInputStream.v();
                                        this.f18527f = 1 | this.f18527f;
                                        this.k = v;
                                    } else if (x == 34) {
                                        String v2 = codedInputStream.v();
                                        this.f18527f |= 2;
                                        this.l = v2;
                                    } else if (x != 50) {
                                        if (!a(x, codedInputStream)) {
                                        }
                                    } else {
                                        String v3 = codedInputStream.v();
                                        if (!this.m.M()) {
                                            this.m = GeneratedMessageLite.a(this.m);
                                        }
                                        this.m.add(v3);
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
                        if (f18526e == null) {
                            synchronized (Location.class) {
                                if (f18526e == null) {
                                    f18526e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18525d);
                                }
                            }
                        }
                        return f18526e;
                    default:
                        throw new UnsupportedOperationException();
                }
                return f18525d;
            }
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class OneofDescriptorProto extends GeneratedMessageLite<OneofDescriptorProto, Builder> implements OneofDescriptorProtoOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final OneofDescriptorProto f18504d = new OneofDescriptorProto();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<OneofDescriptorProto> f18505e;

        /* renamed from: f, reason: collision with root package name */
        private int f18506f;

        /* renamed from: h, reason: collision with root package name */
        private OneofOptions f18508h;
        private byte i = -1;

        /* renamed from: g, reason: collision with root package name */
        private String f18507g = "";

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<OneofDescriptorProto, Builder> implements OneofDescriptorProtoOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(OneofDescriptorProto.f18504d);
            }
        }

        static {
            f18504d.l();
        }

        private OneofDescriptorProto() {
        }

        public static Parser<OneofDescriptorProto> r() {
            return f18504d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.f18506f & 1) == 1) {
                codedOutputStream.b(1, n());
            }
            if ((this.f18506f & 2) == 2) {
                codedOutputStream.c(2, o());
            }
            this.f18583b.a(codedOutputStream);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18506f & 1) == 1 ? 0 + CodedOutputStream.a(1, n()) : 0;
            if ((this.f18506f & 2) == 2) {
                a2 += CodedOutputStream.a(2, o());
            }
            int c2 = a2 + this.f18583b.c();
            this.f18584c = c2;
            return c2;
        }

        public String n() {
            return this.f18507g;
        }

        public OneofOptions o() {
            OneofOptions oneofOptions = this.f18508h;
            return oneofOptions == null ? OneofOptions.q() : oneofOptions;
        }

        public boolean p() {
            return (this.f18506f & 1) == 1;
        }

        public boolean q() {
            return (this.f18506f & 2) == 2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new OneofDescriptorProto();
                case 2:
                    byte b2 = this.i;
                    if (b2 == 1) {
                        return f18504d;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (!q() || o().isInitialized()) {
                        if (booleanValue) {
                            this.i = (byte) 1;
                        }
                        return f18504d;
                    }
                    if (booleanValue) {
                        this.i = (byte) 0;
                    }
                    return null;
                case 3:
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    OneofDescriptorProto oneofDescriptorProto = (OneofDescriptorProto) obj2;
                    this.f18507g = visitor.a(p(), this.f18507g, oneofDescriptorProto.p(), oneofDescriptorProto.f18507g);
                    this.f18508h = (OneofOptions) visitor.a(this.f18508h, oneofDescriptorProto.f18508h);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18506f |= oneofDescriptorProto.f18506f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    String v = codedInputStream.v();
                                    this.f18506f |= 1;
                                    this.f18507g = v;
                                } else if (x != 18) {
                                    if (!a(x, codedInputStream)) {
                                    }
                                } else {
                                    OneofOptions.Builder builder = (this.f18506f & 2) == 2 ? (OneofOptions.Builder) this.f18508h.b() : null;
                                    this.f18508h = (OneofOptions) codedInputStream.a(OneofOptions.s(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.b((OneofOptions.Builder) this.f18508h);
                                        this.f18508h = builder.T();
                                    }
                                    this.f18506f |= 2;
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
                    if (f18505e == null) {
                        synchronized (OneofDescriptorProto.class) {
                            if (f18505e == null) {
                                f18505e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18504d);
                            }
                        }
                    }
                    return f18505e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18504d;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class EnumValueDescriptorProto extends GeneratedMessageLite<EnumValueDescriptorProto, Builder> implements EnumValueDescriptorProtoOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final EnumValueDescriptorProto f18448d = new EnumValueDescriptorProto();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<EnumValueDescriptorProto> f18449e;

        /* renamed from: f, reason: collision with root package name */
        private int f18450f;

        /* renamed from: h, reason: collision with root package name */
        private int f18452h;
        private EnumValueOptions i;
        private byte j = -1;

        /* renamed from: g, reason: collision with root package name */
        private String f18451g = "";

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<EnumValueDescriptorProto, Builder> implements EnumValueDescriptorProtoOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(EnumValueDescriptorProto.f18448d);
            }
        }

        static {
            f18448d.l();
        }

        private EnumValueDescriptorProto() {
        }

        public static Parser<EnumValueDescriptorProto> s() {
            return f18448d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.f18450f & 1) == 1) {
                codedOutputStream.b(1, n());
            }
            if ((this.f18450f & 2) == 2) {
                codedOutputStream.g(2, this.f18452h);
            }
            if ((this.f18450f & 4) == 4) {
                codedOutputStream.c(3, o());
            }
            this.f18583b.a(codedOutputStream);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18450f & 1) == 1 ? 0 + CodedOutputStream.a(1, n()) : 0;
            if ((this.f18450f & 2) == 2) {
                a2 += CodedOutputStream.c(2, this.f18452h);
            }
            if ((this.f18450f & 4) == 4) {
                a2 += CodedOutputStream.a(3, o());
            }
            int c2 = a2 + this.f18583b.c();
            this.f18584c = c2;
            return c2;
        }

        public String n() {
            return this.f18451g;
        }

        public EnumValueOptions o() {
            EnumValueOptions enumValueOptions = this.i;
            return enumValueOptions == null ? EnumValueOptions.q() : enumValueOptions;
        }

        public boolean p() {
            return (this.f18450f & 1) == 1;
        }

        public boolean q() {
            return (this.f18450f & 2) == 2;
        }

        public boolean r() {
            return (this.f18450f & 4) == 4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumValueDescriptorProto();
                case 2:
                    byte b2 = this.j;
                    if (b2 == 1) {
                        return f18448d;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (!r() || o().isInitialized()) {
                        if (booleanValue) {
                            this.j = (byte) 1;
                        }
                        return f18448d;
                    }
                    if (booleanValue) {
                        this.j = (byte) 0;
                    }
                    return null;
                case 3:
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    EnumValueDescriptorProto enumValueDescriptorProto = (EnumValueDescriptorProto) obj2;
                    this.f18451g = visitor.a(p(), this.f18451g, enumValueDescriptorProto.p(), enumValueDescriptorProto.f18451g);
                    this.f18452h = visitor.a(q(), this.f18452h, enumValueDescriptorProto.q(), enumValueDescriptorProto.f18452h);
                    this.i = (EnumValueOptions) visitor.a(this.i, enumValueDescriptorProto.i);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18450f |= enumValueDescriptorProto.f18450f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    String v = codedInputStream.v();
                                    this.f18450f |= 1;
                                    this.f18451g = v;
                                } else if (x == 16) {
                                    this.f18450f |= 2;
                                    this.f18452h = codedInputStream.j();
                                } else if (x != 26) {
                                    if (!a(x, codedInputStream)) {
                                    }
                                } else {
                                    EnumValueOptions.Builder builder = (this.f18450f & 4) == 4 ? (EnumValueOptions.Builder) this.i.b() : null;
                                    this.i = (EnumValueOptions) codedInputStream.a(EnumValueOptions.t(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.b((EnumValueOptions.Builder) this.i);
                                        this.i = builder.T();
                                    }
                                    this.f18450f |= 4;
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
                    if (f18449e == null) {
                        synchronized (EnumValueDescriptorProto.class) {
                            if (f18449e == null) {
                                f18449e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18448d);
                            }
                        }
                    }
                    return f18449e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18448d;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class MethodDescriptorProto extends GeneratedMessageLite<MethodDescriptorProto, Builder> implements MethodDescriptorProtoOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final MethodDescriptorProto f18495d = new MethodDescriptorProto();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<MethodDescriptorProto> f18496e;

        /* renamed from: f, reason: collision with root package name */
        private int f18497f;
        private MethodOptions j;
        private boolean k;
        private boolean l;
        private byte m = -1;

        /* renamed from: g, reason: collision with root package name */
        private String f18498g = "";

        /* renamed from: h, reason: collision with root package name */
        private String f18499h = "";
        private String i = "";

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<MethodDescriptorProto, Builder> implements MethodDescriptorProtoOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(MethodDescriptorProto.f18495d);
            }
        }

        static {
            f18495d.l();
        }

        private MethodDescriptorProto() {
        }

        public static Parser<MethodDescriptorProto> x() {
            return f18495d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.f18497f & 1) == 1) {
                codedOutputStream.b(1, o());
            }
            if ((this.f18497f & 2) == 2) {
                codedOutputStream.b(2, n());
            }
            if ((this.f18497f & 4) == 4) {
                codedOutputStream.b(3, q());
            }
            if ((this.f18497f & 8) == 8) {
                codedOutputStream.c(4, p());
            }
            if ((this.f18497f & 16) == 16) {
                codedOutputStream.b(5, this.k);
            }
            if ((this.f18497f & 32) == 32) {
                codedOutputStream.b(6, this.l);
            }
            this.f18583b.a(codedOutputStream);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18497f & 1) == 1 ? 0 + CodedOutputStream.a(1, o()) : 0;
            if ((this.f18497f & 2) == 2) {
                a2 += CodedOutputStream.a(2, n());
            }
            if ((this.f18497f & 4) == 4) {
                a2 += CodedOutputStream.a(3, q());
            }
            if ((this.f18497f & 8) == 8) {
                a2 += CodedOutputStream.a(4, p());
            }
            if ((this.f18497f & 16) == 16) {
                a2 += CodedOutputStream.a(5, this.k);
            }
            if ((this.f18497f & 32) == 32) {
                a2 += CodedOutputStream.a(6, this.l);
            }
            int c2 = a2 + this.f18583b.c();
            this.f18584c = c2;
            return c2;
        }

        public String n() {
            return this.f18499h;
        }

        public String o() {
            return this.f18498g;
        }

        public MethodOptions p() {
            MethodOptions methodOptions = this.j;
            return methodOptions == null ? MethodOptions.q() : methodOptions;
        }

        public String q() {
            return this.i;
        }

        public boolean r() {
            return (this.f18497f & 16) == 16;
        }

        public boolean s() {
            return (this.f18497f & 2) == 2;
        }

        public boolean t() {
            return (this.f18497f & 1) == 1;
        }

        public boolean u() {
            return (this.f18497f & 8) == 8;
        }

        public boolean v() {
            return (this.f18497f & 4) == 4;
        }

        public boolean w() {
            return (this.f18497f & 32) == 32;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new MethodDescriptorProto();
                case 2:
                    byte b2 = this.m;
                    if (b2 == 1) {
                        return f18495d;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (!u() || p().isInitialized()) {
                        if (booleanValue) {
                            this.m = (byte) 1;
                        }
                        return f18495d;
                    }
                    if (booleanValue) {
                        this.m = (byte) 0;
                    }
                    return null;
                case 3:
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    MethodDescriptorProto methodDescriptorProto = (MethodDescriptorProto) obj2;
                    this.f18498g = visitor.a(t(), this.f18498g, methodDescriptorProto.t(), methodDescriptorProto.f18498g);
                    this.f18499h = visitor.a(s(), this.f18499h, methodDescriptorProto.s(), methodDescriptorProto.f18499h);
                    this.i = visitor.a(v(), this.i, methodDescriptorProto.v(), methodDescriptorProto.i);
                    this.j = (MethodOptions) visitor.a(this.j, methodDescriptorProto.j);
                    this.k = visitor.a(r(), this.k, methodDescriptorProto.r(), methodDescriptorProto.k);
                    this.l = visitor.a(w(), this.l, methodDescriptorProto.w(), methodDescriptorProto.l);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18497f |= methodDescriptorProto.f18497f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x == 10) {
                                        String v = codedInputStream.v();
                                        this.f18497f |= 1;
                                        this.f18498g = v;
                                    } else if (x == 18) {
                                        String v2 = codedInputStream.v();
                                        this.f18497f |= 2;
                                        this.f18499h = v2;
                                    } else if (x == 26) {
                                        String v3 = codedInputStream.v();
                                        this.f18497f |= 4;
                                        this.i = v3;
                                    } else if (x == 34) {
                                        MethodOptions.Builder builder = (this.f18497f & 8) == 8 ? (MethodOptions.Builder) this.j.b() : null;
                                        this.j = (MethodOptions) codedInputStream.a(MethodOptions.u(), extensionRegistryLite);
                                        if (builder != null) {
                                            builder.b((MethodOptions.Builder) this.j);
                                            this.j = builder.T();
                                        }
                                        this.f18497f |= 8;
                                    } else if (x == 40) {
                                        this.f18497f |= 16;
                                        this.k = codedInputStream.c();
                                    } else if (x != 48) {
                                        if (!a(x, codedInputStream)) {
                                        }
                                    } else {
                                        this.f18497f |= 32;
                                        this.l = codedInputStream.c();
                                    }
                                }
                                z = true;
                            } catch (InvalidProtocolBufferException e2) {
                                throw new RuntimeException(e2.setUnfinishedMessage(this));
                            }
                        } catch (IOException e3) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (f18496e == null) {
                        synchronized (MethodDescriptorProto.class) {
                            if (f18496e == null) {
                                f18496e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18495d);
                            }
                        }
                    }
                    return f18496e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18495d;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class FieldDescriptorProto extends GeneratedMessageLite<FieldDescriptorProto, Builder> implements FieldDescriptorProtoOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final FieldDescriptorProto f18461d = new FieldDescriptorProto();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<FieldDescriptorProto> f18462e;

        /* renamed from: f, reason: collision with root package name */
        private int f18463f;

        /* renamed from: h, reason: collision with root package name */
        private int f18465h;
        private int n;
        private FieldOptions p;
        private byte q = -1;

        /* renamed from: g, reason: collision with root package name */
        private String f18464g = "";
        private int i = 1;
        private int j = 1;
        private String k = "";
        private String l = "";
        private String m = "";
        private String o = "";

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldDescriptorProto, Builder> implements FieldDescriptorProtoOrBuilder {
            /* synthetic */ Builder(C1654h c1654h) {
                this();
            }

            private Builder() {
                super(FieldDescriptorProto.f18461d);
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public enum Label implements Internal.EnumLite {
            LABEL_OPTIONAL(1),
            LABEL_REQUIRED(2),
            LABEL_REPEATED(3);

            public static final int LABEL_OPTIONAL_VALUE = 1;
            public static final int LABEL_REPEATED_VALUE = 3;
            public static final int LABEL_REQUIRED_VALUE = 2;
            private static final Internal.EnumLiteMap<Label> internalValueMap = new C1655i();
            private final int value;

            Label(int i) {
                this.value = i;
            }

            public static Label forNumber(int i) {
                if (i == 1) {
                    return LABEL_OPTIONAL;
                }
                if (i == 2) {
                    return LABEL_REQUIRED;
                }
                if (i != 3) {
                    return null;
                }
                return LABEL_REPEATED;
            }

            public static Internal.EnumLiteMap<Label> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Label valueOf(int i) {
                return forNumber(i);
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public enum Type implements Internal.EnumLite {
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
            TYPE_SINT64(18);

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
            private static final Internal.EnumLiteMap<Type> internalValueMap = new C1656j();
            private final int value;

            Type(int i) {
                this.value = i;
            }

            public static Type forNumber(int i) {
                switch (i) {
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

            public static Internal.EnumLiteMap<Type> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Type valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            f18461d.l();
        }

        private FieldDescriptorProto() {
        }

        public static Parser<FieldDescriptorProto> D() {
            return f18461d.f();
        }

        public boolean A() {
            return (this.f18463f & 512) == 512;
        }

        public boolean B() {
            return (this.f18463f & 8) == 8;
        }

        public boolean C() {
            return (this.f18463f & 16) == 16;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.f18463f & 1) == 1) {
                codedOutputStream.b(1, q());
            }
            if ((this.f18463f & 32) == 32) {
                codedOutputStream.b(2, o());
            }
            if ((this.f18463f & 2) == 2) {
                codedOutputStream.g(3, this.f18465h);
            }
            if ((this.f18463f & 4) == 4) {
                codedOutputStream.e(4, this.i);
            }
            if ((this.f18463f & 8) == 8) {
                codedOutputStream.e(5, this.j);
            }
            if ((this.f18463f & 16) == 16) {
                codedOutputStream.b(6, s());
            }
            if ((this.f18463f & 64) == 64) {
                codedOutputStream.b(7, n());
            }
            if ((this.f18463f & 512) == 512) {
                codedOutputStream.c(8, r());
            }
            if ((this.f18463f & 128) == 128) {
                codedOutputStream.g(9, this.n);
            }
            if ((this.f18463f & 256) == 256) {
                codedOutputStream.b(10, p());
            }
            this.f18583b.a(codedOutputStream);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18463f & 1) == 1 ? 0 + CodedOutputStream.a(1, q()) : 0;
            if ((this.f18463f & 32) == 32) {
                a2 += CodedOutputStream.a(2, o());
            }
            if ((this.f18463f & 2) == 2) {
                a2 += CodedOutputStream.c(3, this.f18465h);
            }
            if ((this.f18463f & 4) == 4) {
                a2 += CodedOutputStream.a(4, this.i);
            }
            if ((this.f18463f & 8) == 8) {
                a2 += CodedOutputStream.a(5, this.j);
            }
            if ((this.f18463f & 16) == 16) {
                a2 += CodedOutputStream.a(6, s());
            }
            if ((this.f18463f & 64) == 64) {
                a2 += CodedOutputStream.a(7, n());
            }
            if ((this.f18463f & 512) == 512) {
                a2 += CodedOutputStream.a(8, r());
            }
            if ((this.f18463f & 128) == 128) {
                a2 += CodedOutputStream.c(9, this.n);
            }
            if ((this.f18463f & 256) == 256) {
                a2 += CodedOutputStream.a(10, p());
            }
            int c2 = a2 + this.f18583b.c();
            this.f18584c = c2;
            return c2;
        }

        public String n() {
            return this.m;
        }

        public String o() {
            return this.l;
        }

        public String p() {
            return this.o;
        }

        public String q() {
            return this.f18464g;
        }

        public FieldOptions r() {
            FieldOptions fieldOptions = this.p;
            return fieldOptions == null ? FieldOptions.q() : fieldOptions;
        }

        public String s() {
            return this.k;
        }

        public boolean t() {
            return (this.f18463f & 64) == 64;
        }

        public boolean u() {
            return (this.f18463f & 32) == 32;
        }

        public boolean v() {
            return (this.f18463f & 256) == 256;
        }

        public boolean w() {
            return (this.f18463f & 4) == 4;
        }

        public boolean x() {
            return (this.f18463f & 1) == 1;
        }

        public boolean y() {
            return (this.f18463f & 2) == 2;
        }

        public boolean z() {
            return (this.f18463f & 128) == 128;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            C1654h c1654h = null;
            switch (C1654h.f18781a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldDescriptorProto();
                case 2:
                    byte b2 = this.q;
                    if (b2 == 1) {
                        return f18461d;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (!A() || r().isInitialized()) {
                        if (booleanValue) {
                            this.q = (byte) 1;
                        }
                        return f18461d;
                    }
                    if (booleanValue) {
                        this.q = (byte) 0;
                    }
                    return null;
                case 3:
                    return null;
                case 4:
                    return new Builder(c1654h);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    FieldDescriptorProto fieldDescriptorProto = (FieldDescriptorProto) obj2;
                    this.f18464g = visitor.a(x(), this.f18464g, fieldDescriptorProto.x(), fieldDescriptorProto.f18464g);
                    this.f18465h = visitor.a(y(), this.f18465h, fieldDescriptorProto.y(), fieldDescriptorProto.f18465h);
                    this.i = visitor.a(w(), this.i, fieldDescriptorProto.w(), fieldDescriptorProto.i);
                    this.j = visitor.a(B(), this.j, fieldDescriptorProto.B(), fieldDescriptorProto.j);
                    this.k = visitor.a(C(), this.k, fieldDescriptorProto.C(), fieldDescriptorProto.k);
                    this.l = visitor.a(u(), this.l, fieldDescriptorProto.u(), fieldDescriptorProto.l);
                    this.m = visitor.a(t(), this.m, fieldDescriptorProto.t(), fieldDescriptorProto.m);
                    this.n = visitor.a(z(), this.n, fieldDescriptorProto.z(), fieldDescriptorProto.n);
                    this.o = visitor.a(v(), this.o, fieldDescriptorProto.v(), fieldDescriptorProto.o);
                    this.p = (FieldOptions) visitor.a(this.p, fieldDescriptorProto.p);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18463f |= fieldDescriptorProto.f18463f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            switch (x) {
                                case 0:
                                    z = true;
                                case 10:
                                    String v = codedInputStream.v();
                                    this.f18463f |= 1;
                                    this.f18464g = v;
                                case 18:
                                    String v2 = codedInputStream.v();
                                    this.f18463f |= 32;
                                    this.l = v2;
                                case 24:
                                    this.f18463f |= 2;
                                    this.f18465h = codedInputStream.j();
                                case 32:
                                    int f2 = codedInputStream.f();
                                    if (Label.forNumber(f2) == null) {
                                        super.a(4, f2);
                                    } else {
                                        this.f18463f |= 4;
                                        this.i = f2;
                                    }
                                case 40:
                                    int f3 = codedInputStream.f();
                                    if (Type.forNumber(f3) == null) {
                                        super.a(5, f3);
                                    } else {
                                        this.f18463f |= 8;
                                        this.j = f3;
                                    }
                                case 50:
                                    String v3 = codedInputStream.v();
                                    this.f18463f |= 16;
                                    this.k = v3;
                                case 58:
                                    String v4 = codedInputStream.v();
                                    this.f18463f |= 64;
                                    this.m = v4;
                                case 66:
                                    FieldOptions.Builder builder = (this.f18463f & 512) == 512 ? (FieldOptions.Builder) this.p.b() : null;
                                    this.p = (FieldOptions) codedInputStream.a(FieldOptions.y(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.b((FieldOptions.Builder) this.p);
                                        this.p = builder.T();
                                    }
                                    this.f18463f |= 512;
                                case 72:
                                    this.f18463f |= 128;
                                    this.n = codedInputStream.j();
                                case 82:
                                    String v5 = codedInputStream.v();
                                    this.f18463f |= 256;
                                    this.o = v5;
                                default:
                                    if (!a(x, codedInputStream)) {
                                        z = true;
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
                    if (f18462e == null) {
                        synchronized (FieldDescriptorProto.class) {
                            if (f18462e == null) {
                                f18462e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18461d);
                            }
                        }
                    }
                    return f18462e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18461d;
        }
    }
}
