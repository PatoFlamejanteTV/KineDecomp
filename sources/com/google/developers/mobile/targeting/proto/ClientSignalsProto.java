package com.google.developers.mobile.targeting.proto;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ClientSignalsProto {

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface AppInstanceClaimOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class ClientSignals extends GeneratedMessageLite<ClientSignals, Builder> implements ClientSignalsOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final ClientSignals f16237d = new ClientSignals();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<ClientSignals> f16238e;

        /* renamed from: f, reason: collision with root package name */
        private String f16239f = "";

        /* renamed from: g, reason: collision with root package name */
        private String f16240g = "";

        /* renamed from: h, reason: collision with root package name */
        private String f16241h = "";
        private String i = "";

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ClientSignals, Builder> implements ClientSignalsOrBuilder {
            /* synthetic */ Builder(a aVar) {
                this();
            }

            public Builder a(String str) {
                b();
                ((ClientSignals) this.f18586b).b(str);
                return this;
            }

            public Builder b(String str) {
                b();
                ((ClientSignals) this.f18586b).c(str);
                return this;
            }

            public Builder c(String str) {
                b();
                ((ClientSignals) this.f18586b).d(str);
                return this;
            }

            public Builder d(String str) {
                b();
                ((ClientSignals) this.f18586b).e(str);
                return this;
            }

            private Builder() {
                super(ClientSignals.f16237d);
            }
        }

        static {
            f16237d.l();
        }

        private ClientSignals() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(String str) {
            if (str != null) {
                this.i = str;
                return;
            }
            throw new NullPointerException();
        }

        public static ClientSignals o() {
            return f16237d;
        }

        public static Builder s() {
            return f16237d.b();
        }

        public static Parser<ClientSignals> t() {
            return f16237d.f();
        }

        public String n() {
            return this.f16239f;
        }

        public String p() {
            return this.f16241h;
        }

        public String q() {
            return this.f16240g;
        }

        public String r() {
            return this.i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            if (str != null) {
                this.f16239f = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(String str) {
            if (str != null) {
                this.f16241h = str;
                return;
            }
            throw new NullPointerException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(String str) {
            if (str != null) {
                this.f16240g = str;
                return;
            }
            throw new NullPointerException();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.f16239f.isEmpty()) {
                codedOutputStream.b(1, n());
            }
            if (!this.f16240g.isEmpty()) {
                codedOutputStream.b(2, q());
            }
            if (!this.f16241h.isEmpty()) {
                codedOutputStream.b(3, p());
            }
            if (this.i.isEmpty()) {
                return;
            }
            codedOutputStream.b(4, r());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f16239f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
            if (!this.f16240g.isEmpty()) {
                a2 += CodedOutputStream.a(2, q());
            }
            if (!this.f16241h.isEmpty()) {
                a2 += CodedOutputStream.a(3, p());
            }
            if (!this.i.isEmpty()) {
                a2 += CodedOutputStream.a(4, r());
            }
            this.f18584c = a2;
            return a2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f16317a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ClientSignals();
                case 2:
                    return f16237d;
                case 3:
                    return null;
                case 4:
                    return new Builder(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ClientSignals clientSignals = (ClientSignals) obj2;
                    this.f16239f = visitor.a(!this.f16239f.isEmpty(), this.f16239f, !clientSignals.f16239f.isEmpty(), clientSignals.f16239f);
                    this.f16240g = visitor.a(!this.f16240g.isEmpty(), this.f16240g, !clientSignals.f16240g.isEmpty(), clientSignals.f16240g);
                    this.f16241h = visitor.a(!this.f16241h.isEmpty(), this.f16241h, !clientSignals.f16241h.isEmpty(), clientSignals.f16241h);
                    this.i = visitor.a(!this.i.isEmpty(), this.i, true ^ clientSignals.i.isEmpty(), clientSignals.i);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x == 10) {
                                        this.f16239f = codedInputStream.w();
                                    } else if (x == 18) {
                                        this.f16240g = codedInputStream.w();
                                    } else if (x == 26) {
                                        this.f16241h = codedInputStream.w();
                                    } else if (x != 34) {
                                        if (!codedInputStream.f(x)) {
                                        }
                                    } else {
                                        this.i = codedInputStream.w();
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
                    if (f16238e == null) {
                        synchronized (ClientSignals.class) {
                            if (f16238e == null) {
                                f16238e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16237d);
                            }
                        }
                    }
                    return f16238e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16237d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface ClientSignalsOrBuilder extends MessageLiteOrBuilder {
    }

    private ClientSignalsProto() {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class AppInstanceClaim extends GeneratedMessageLite<AppInstanceClaim, Builder> implements AppInstanceClaimOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final AppInstanceClaim f16232d = new AppInstanceClaim();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<AppInstanceClaim> f16233e;

        /* renamed from: f, reason: collision with root package name */
        private String f16234f = "";

        /* renamed from: g, reason: collision with root package name */
        private String f16235g = "";

        /* renamed from: h, reason: collision with root package name */
        private String f16236h = "";

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<AppInstanceClaim, Builder> implements AppInstanceClaimOrBuilder {
            /* synthetic */ Builder(a aVar) {
                this();
            }

            private Builder() {
                super(AppInstanceClaim.f16232d);
            }
        }

        static {
            f16232d.l();
        }

        private AppInstanceClaim() {
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.f16234f.isEmpty()) {
                codedOutputStream.b(1, n());
            }
            if (!this.f16235g.isEmpty()) {
                codedOutputStream.b(2, o());
            }
            if (this.f16236h.isEmpty()) {
                return;
            }
            codedOutputStream.b(3, p());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f16234f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
            if (!this.f16235g.isEmpty()) {
                a2 += CodedOutputStream.a(2, o());
            }
            if (!this.f16236h.isEmpty()) {
                a2 += CodedOutputStream.a(3, p());
            }
            this.f18584c = a2;
            return a2;
        }

        public String n() {
            return this.f16234f;
        }

        public String o() {
            return this.f16235g;
        }

        public String p() {
            return this.f16236h;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f16317a[methodToInvoke.ordinal()]) {
                case 1:
                    return new AppInstanceClaim();
                case 2:
                    return f16232d;
                case 3:
                    return null;
                case 4:
                    return new Builder(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    AppInstanceClaim appInstanceClaim = (AppInstanceClaim) obj2;
                    this.f16234f = visitor.a(!this.f16234f.isEmpty(), this.f16234f, !appInstanceClaim.f16234f.isEmpty(), appInstanceClaim.f16234f);
                    this.f16235g = visitor.a(!this.f16235g.isEmpty(), this.f16235g, !appInstanceClaim.f16235g.isEmpty(), appInstanceClaim.f16235g);
                    this.f16236h = visitor.a(!this.f16236h.isEmpty(), this.f16236h, true ^ appInstanceClaim.f16236h.isEmpty(), appInstanceClaim.f16236h);
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
                                    this.f16234f = codedInputStream.w();
                                } else if (x == 18) {
                                    this.f16235g = codedInputStream.w();
                                } else if (x != 26) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f16236h = codedInputStream.w();
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
                    if (f16233e == null) {
                        synchronized (AppInstanceClaim.class) {
                            if (f16233e == null) {
                                f16233e = new GeneratedMessageLite.DefaultInstanceBasedParser(f16232d);
                            }
                        }
                    }
                    return f16233e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f16232d;
        }
    }
}
