package com.google.protobuf.compiler;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
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
public final class PluginProtos {

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class CodeGeneratorRequest extends GeneratedMessageLite<CodeGeneratorRequest, Builder> implements CodeGeneratorRequestOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final CodeGeneratorRequest f18748d = new CodeGeneratorRequest();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<CodeGeneratorRequest> f18749e;

        /* renamed from: f, reason: collision with root package name */
        private int f18750f;
        private Version j;
        private byte k = -1;

        /* renamed from: g, reason: collision with root package name */
        private Internal.ProtobufList<String> f18751g = GeneratedMessageLite.k();

        /* renamed from: h, reason: collision with root package name */
        private String f18752h = "";
        private Internal.ProtobufList<DescriptorProtos.FileDescriptorProto> i = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorRequest, Builder> implements CodeGeneratorRequestOrBuilder {
            /* synthetic */ Builder(a aVar) {
                this();
            }

            private Builder() {
                super(CodeGeneratorRequest.f18748d);
            }
        }

        static {
            f18748d.l();
        }

        private CodeGeneratorRequest() {
        }

        public DescriptorProtos.FileDescriptorProto a(int i) {
            return this.i.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f18751g.size(); i3++) {
                i2 += CodedOutputStream.a(this.f18751g.get(i3));
            }
            int size = i2 + 0 + (o().size() * 1);
            if ((this.f18750f & 1) == 1) {
                size += CodedOutputStream.a(2, p());
            }
            if ((this.f18750f & 2) == 2) {
                size += CodedOutputStream.a(3, n());
            }
            for (int i4 = 0; i4 < this.i.size(); i4++) {
                size += CodedOutputStream.a(15, this.i.get(i4));
            }
            int c2 = size + this.f18583b.c();
            this.f18584c = c2;
            return c2;
        }

        public Version n() {
            Version version = this.j;
            return version == null ? Version.n() : version;
        }

        public List<String> o() {
            return this.f18751g;
        }

        public String p() {
            return this.f18752h;
        }

        public int q() {
            return this.i.size();
        }

        public boolean r() {
            return (this.f18750f & 1) == 1;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.f18751g.size(); i++) {
                codedOutputStream.b(1, this.f18751g.get(i));
            }
            if ((this.f18750f & 1) == 1) {
                codedOutputStream.b(2, p());
            }
            if ((this.f18750f & 2) == 2) {
                codedOutputStream.c(3, n());
            }
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                codedOutputStream.c(15, this.i.get(i2));
            }
            this.f18583b.a(codedOutputStream);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            a aVar = null;
            switch (a.f18768a[methodToInvoke.ordinal()]) {
                case 1:
                    return new CodeGeneratorRequest();
                case 2:
                    byte b2 = this.k;
                    if (b2 == 1) {
                        return f18748d;
                    }
                    if (b2 == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < q(); i++) {
                        if (!a(i).isInitialized()) {
                            if (booleanValue) {
                                this.k = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (booleanValue) {
                        this.k = (byte) 1;
                    }
                    return f18748d;
                case 3:
                    this.f18751g.L();
                    this.i.L();
                    return null;
                case 4:
                    return new Builder(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CodeGeneratorRequest codeGeneratorRequest = (CodeGeneratorRequest) obj2;
                    this.f18751g = visitor.a(this.f18751g, codeGeneratorRequest.f18751g);
                    this.f18752h = visitor.a(r(), this.f18752h, codeGeneratorRequest.r(), codeGeneratorRequest.f18752h);
                    this.i = visitor.a(this.i, codeGeneratorRequest.i);
                    this.j = (Version) visitor.a(this.j, codeGeneratorRequest.j);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18750f |= codeGeneratorRequest.f18750f;
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
                                    if (!this.f18751g.M()) {
                                        this.f18751g = GeneratedMessageLite.a(this.f18751g);
                                    }
                                    this.f18751g.add(v);
                                } else if (x == 18) {
                                    String v2 = codedInputStream.v();
                                    this.f18750f |= 1;
                                    this.f18752h = v2;
                                } else if (x == 26) {
                                    Version.Builder b3 = (this.f18750f & 2) == 2 ? this.j.b() : null;
                                    this.j = (Version) codedInputStream.a(Version.t(), extensionRegistryLite);
                                    if (b3 != null) {
                                        b3.b((Version.Builder) this.j);
                                        this.j = b3.T();
                                    }
                                    this.f18750f |= 2;
                                } else if (x != 122) {
                                    if (!a(x, codedInputStream)) {
                                    }
                                } else {
                                    if (!this.i.M()) {
                                        this.i = GeneratedMessageLite.a(this.i);
                                    }
                                    this.i.add((DescriptorProtos.FileDescriptorProto) codedInputStream.a(DescriptorProtos.FileDescriptorProto.D(), extensionRegistryLite));
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
                    if (f18749e == null) {
                        synchronized (CodeGeneratorRequest.class) {
                            if (f18749e == null) {
                                f18749e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18748d);
                            }
                        }
                    }
                    return f18749e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18748d;
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface CodeGeneratorRequestOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface CodeGeneratorResponseOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface VersionOrBuilder extends MessageLiteOrBuilder {
    }

    private PluginProtos() {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class CodeGeneratorResponse extends GeneratedMessageLite<CodeGeneratorResponse, Builder> implements CodeGeneratorResponseOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final CodeGeneratorResponse f18753d = new CodeGeneratorResponse();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<CodeGeneratorResponse> f18754e;

        /* renamed from: f, reason: collision with root package name */
        private int f18755f;

        /* renamed from: g, reason: collision with root package name */
        private String f18756g = "";

        /* renamed from: h, reason: collision with root package name */
        private Internal.ProtobufList<File> f18757h = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorResponse, Builder> implements CodeGeneratorResponseOrBuilder {
            /* synthetic */ Builder(a aVar) {
                this();
            }

            private Builder() {
                super(CodeGeneratorResponse.f18753d);
            }
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public interface FileOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            f18753d.l();
        }

        private CodeGeneratorResponse() {
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.f18755f & 1) == 1) {
                codedOutputStream.b(1, n());
            }
            for (int i = 0; i < this.f18757h.size(); i++) {
                codedOutputStream.c(15, this.f18757h.get(i));
            }
            this.f18583b.a(codedOutputStream);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18755f & 1) == 1 ? CodedOutputStream.a(1, n()) + 0 : 0;
            for (int i2 = 0; i2 < this.f18757h.size(); i2++) {
                a2 += CodedOutputStream.a(15, this.f18757h.get(i2));
            }
            int c2 = a2 + this.f18583b.c();
            this.f18584c = c2;
            return c2;
        }

        public String n() {
            return this.f18756g;
        }

        public boolean o() {
            return (this.f18755f & 1) == 1;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f18768a[methodToInvoke.ordinal()]) {
                case 1:
                    return new CodeGeneratorResponse();
                case 2:
                    return f18753d;
                case 3:
                    this.f18757h.L();
                    return null;
                case 4:
                    return new Builder(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CodeGeneratorResponse codeGeneratorResponse = (CodeGeneratorResponse) obj2;
                    this.f18756g = visitor.a(o(), this.f18756g, codeGeneratorResponse.o(), codeGeneratorResponse.f18756g);
                    this.f18757h = visitor.a(this.f18757h, codeGeneratorResponse.f18757h);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18755f |= codeGeneratorResponse.f18755f;
                    }
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
                                    if (x == 10) {
                                        String v = codedInputStream.v();
                                        this.f18755f = 1 | this.f18755f;
                                        this.f18756g = v;
                                    } else if (x != 122) {
                                        if (!a(x, codedInputStream)) {
                                        }
                                    } else {
                                        if (!this.f18757h.M()) {
                                            this.f18757h = GeneratedMessageLite.a(this.f18757h);
                                        }
                                        this.f18757h.add((File) codedInputStream.a(File.t(), extensionRegistryLite));
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
                    if (f18754e == null) {
                        synchronized (CodeGeneratorResponse.class) {
                            if (f18754e == null) {
                                f18754e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18753d);
                            }
                        }
                    }
                    return f18754e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18753d;
        }

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class File extends GeneratedMessageLite<File, Builder> implements FileOrBuilder {

            /* renamed from: d, reason: collision with root package name */
            private static final File f18758d = new File();

            /* renamed from: e, reason: collision with root package name */
            private static volatile Parser<File> f18759e;

            /* renamed from: f, reason: collision with root package name */
            private int f18760f;

            /* renamed from: g, reason: collision with root package name */
            private String f18761g = "";

            /* renamed from: h, reason: collision with root package name */
            private String f18762h = "";
            private String i = "";

            /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<File, Builder> implements FileOrBuilder {
                /* synthetic */ Builder(a aVar) {
                    this();
                }

                private Builder() {
                    super(File.f18758d);
                }
            }

            static {
                f18758d.l();
            }

            private File() {
            }

            public static Parser<File> t() {
                return f18758d.f();
            }

            @Override // com.google.protobuf.MessageLite
            public void a(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.f18760f & 1) == 1) {
                    codedOutputStream.b(1, p());
                }
                if ((this.f18760f & 2) == 2) {
                    codedOutputStream.b(2, o());
                }
                if ((this.f18760f & 4) == 4) {
                    codedOutputStream.b(15, n());
                }
                this.f18583b.a(codedOutputStream);
            }

            @Override // com.google.protobuf.MessageLite
            public int d() {
                int i = this.f18584c;
                if (i != -1) {
                    return i;
                }
                int a2 = (this.f18760f & 1) == 1 ? 0 + CodedOutputStream.a(1, p()) : 0;
                if ((this.f18760f & 2) == 2) {
                    a2 += CodedOutputStream.a(2, o());
                }
                if ((this.f18760f & 4) == 4) {
                    a2 += CodedOutputStream.a(15, n());
                }
                int c2 = a2 + this.f18583b.c();
                this.f18584c = c2;
                return c2;
            }

            public String n() {
                return this.i;
            }

            public String o() {
                return this.f18762h;
            }

            public String p() {
                return this.f18761g;
            }

            public boolean q() {
                return (this.f18760f & 4) == 4;
            }

            public boolean r() {
                return (this.f18760f & 2) == 2;
            }

            public boolean s() {
                return (this.f18760f & 1) == 1;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                a aVar = null;
                switch (a.f18768a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new File();
                    case 2:
                        return f18758d;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(aVar);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        File file = (File) obj2;
                        this.f18761g = visitor.a(s(), this.f18761g, file.s(), file.f18761g);
                        this.f18762h = visitor.a(r(), this.f18762h, file.r(), file.f18762h);
                        this.i = visitor.a(q(), this.i, file.q(), file.i);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                            this.f18760f |= file.f18760f;
                        }
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        boolean z = false;
                        while (!z) {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x == 10) {
                                        String v = codedInputStream.v();
                                        this.f18760f = 1 | this.f18760f;
                                        this.f18761g = v;
                                    } else if (x == 18) {
                                        String v2 = codedInputStream.v();
                                        this.f18760f |= 2;
                                        this.f18762h = v2;
                                    } else if (x != 122) {
                                        if (!a(x, codedInputStream)) {
                                        }
                                    } else {
                                        String v3 = codedInputStream.v();
                                        this.f18760f |= 4;
                                        this.i = v3;
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
                        if (f18759e == null) {
                            synchronized (File.class) {
                                if (f18759e == null) {
                                    f18759e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18758d);
                                }
                            }
                        }
                        return f18759e;
                    default:
                        throw new UnsupportedOperationException();
                }
                return f18758d;
            }
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Version extends GeneratedMessageLite<Version, Builder> implements VersionOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final Version f18763d = new Version();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<Version> f18764e;

        /* renamed from: f, reason: collision with root package name */
        private int f18765f;

        /* renamed from: g, reason: collision with root package name */
        private int f18766g;

        /* renamed from: h, reason: collision with root package name */
        private int f18767h;
        private int i;
        private String j = "";

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Version, Builder> implements VersionOrBuilder {
            /* synthetic */ Builder(a aVar) {
                this();
            }

            private Builder() {
                super(Version.f18763d);
            }
        }

        static {
            f18763d.l();
        }

        private Version() {
        }

        public static Version n() {
            return f18763d;
        }

        public static Parser<Version> t() {
            return f18763d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.f18765f & 1) == 1) {
                codedOutputStream.g(1, this.f18766g);
            }
            if ((this.f18765f & 2) == 2) {
                codedOutputStream.g(2, this.f18767h);
            }
            if ((this.f18765f & 4) == 4) {
                codedOutputStream.g(3, this.i);
            }
            if ((this.f18765f & 8) == 8) {
                codedOutputStream.b(4, o());
            }
            this.f18583b.a(codedOutputStream);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int c2 = (this.f18765f & 1) == 1 ? 0 + CodedOutputStream.c(1, this.f18766g) : 0;
            if ((this.f18765f & 2) == 2) {
                c2 += CodedOutputStream.c(2, this.f18767h);
            }
            if ((this.f18765f & 4) == 4) {
                c2 += CodedOutputStream.c(3, this.i);
            }
            if ((this.f18765f & 8) == 8) {
                c2 += CodedOutputStream.a(4, o());
            }
            int c3 = c2 + this.f18583b.c();
            this.f18584c = c3;
            return c3;
        }

        public String o() {
            return this.j;
        }

        public boolean p() {
            return (this.f18765f & 1) == 1;
        }

        public boolean q() {
            return (this.f18765f & 2) == 2;
        }

        public boolean r() {
            return (this.f18765f & 4) == 4;
        }

        public boolean s() {
            return (this.f18765f & 8) == 8;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f18768a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Version();
                case 2:
                    return f18763d;
                case 3:
                    return null;
                case 4:
                    return new Builder(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Version version = (Version) obj2;
                    this.f18766g = visitor.a(p(), this.f18766g, version.p(), version.f18766g);
                    this.f18767h = visitor.a(q(), this.f18767h, version.q(), version.f18767h);
                    this.i = visitor.a(r(), this.i, version.r(), version.i);
                    this.j = visitor.a(s(), this.j, version.s(), version.j);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18765f |= version.f18765f;
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
                                    this.f18765f |= 1;
                                    this.f18766g = codedInputStream.j();
                                } else if (x == 16) {
                                    this.f18765f |= 2;
                                    this.f18767h = codedInputStream.j();
                                } else if (x == 24) {
                                    this.f18765f |= 4;
                                    this.i = codedInputStream.j();
                                } else if (x != 34) {
                                    if (!a(x, codedInputStream)) {
                                    }
                                } else {
                                    String v = codedInputStream.v();
                                    this.f18765f |= 8;
                                    this.j = v;
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
                    if (f18764e == null) {
                        synchronized (Version.class) {
                            if (f18764e == null) {
                                f18764e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18763d);
                            }
                        }
                    }
                    return f18764e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18763d;
        }
    }
}
