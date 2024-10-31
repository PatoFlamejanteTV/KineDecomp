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
public final class Help extends GeneratedMessageLite<Help, Builder> implements HelpOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Help f18848d = new Help();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Help> f18849e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<Link> f18850f = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Help, Builder> implements HelpOrBuilder {
        /* synthetic */ Builder(d dVar) {
            this();
        }

        private Builder() {
            super(Help.f18848d);
        }
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface LinkOrBuilder extends MessageLiteOrBuilder {
    }

    static {
        f18848d.l();
    }

    private Help() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f18850f.size(); i++) {
            codedOutputStream.c(1, this.f18850f.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f18850f.size(); i3++) {
            i2 += CodedOutputStream.a(1, this.f18850f.get(i3));
        }
        this.f18584c = i2;
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        d dVar = null;
        switch (d.f18893a[methodToInvoke.ordinal()]) {
            case 1:
                return new Help();
            case 2:
                return f18848d;
            case 3:
                this.f18850f.L();
                return null;
            case 4:
                return new Builder(dVar);
            case 5:
                this.f18850f = ((GeneratedMessageLite.Visitor) obj).a(this.f18850f, ((Help) obj2).f18850f);
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
                                    if (!this.f18850f.M()) {
                                        this.f18850f = GeneratedMessageLite.a(this.f18850f);
                                    }
                                    this.f18850f.add((Link) codedInputStream.a(Link.p(), extensionRegistryLite));
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
                if (f18849e == null) {
                    synchronized (Help.class) {
                        if (f18849e == null) {
                            f18849e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18848d);
                        }
                    }
                }
                return f18849e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18848d;
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Link extends GeneratedMessageLite<Link, Builder> implements LinkOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final Link f18851d = new Link();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<Link> f18852e;

        /* renamed from: f, reason: collision with root package name */
        private String f18853f = "";

        /* renamed from: g, reason: collision with root package name */
        private String f18854g = "";

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Link, Builder> implements LinkOrBuilder {
            /* synthetic */ Builder(d dVar) {
                this();
            }

            private Builder() {
                super(Link.f18851d);
            }
        }

        static {
            f18851d.l();
        }

        private Link() {
        }

        public static Parser<Link> p() {
            return f18851d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.f18853f.isEmpty()) {
                codedOutputStream.b(1, n());
            }
            if (this.f18854g.isEmpty()) {
                return;
            }
            codedOutputStream.b(2, o());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f18853f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
            if (!this.f18854g.isEmpty()) {
                a2 += CodedOutputStream.a(2, o());
            }
            this.f18584c = a2;
            return a2;
        }

        public String n() {
            return this.f18853f;
        }

        public String o() {
            return this.f18854g;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            d dVar = null;
            switch (d.f18893a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Link();
                case 2:
                    return f18851d;
                case 3:
                    return null;
                case 4:
                    return new Builder(dVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Link link = (Link) obj2;
                    this.f18853f = visitor.a(!this.f18853f.isEmpty(), this.f18853f, !link.f18853f.isEmpty(), link.f18853f);
                    this.f18854g = visitor.a(!this.f18854g.isEmpty(), this.f18854g, true ^ link.f18854g.isEmpty(), link.f18854g);
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
                                    this.f18853f = codedInputStream.w();
                                } else if (x != 18) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f18854g = codedInputStream.w();
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
                    if (f18852e == null) {
                        synchronized (Link.class) {
                            if (f18852e == null) {
                                f18852e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18851d);
                            }
                        }
                    }
                    return f18852e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18851d;
        }
    }
}
