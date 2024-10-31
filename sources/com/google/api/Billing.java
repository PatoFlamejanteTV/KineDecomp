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
public final class Billing extends GeneratedMessageLite<Billing, Builder> implements BillingOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Billing f14359d = new Billing();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Billing> f14360e;

    /* renamed from: f, reason: collision with root package name */
    private Internal.ProtobufList<BillingDestination> f14361f = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public interface BillingDestinationOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Billing, Builder> implements BillingOrBuilder {
        /* synthetic */ Builder(C1471i c1471i) {
            this();
        }

        private Builder() {
            super(Billing.f14359d);
        }
    }

    static {
        f14359d.l();
    }

    private Billing() {
    }

    public static Billing n() {
        return f14359d;
    }

    public static Parser<Billing> o() {
        return f14359d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f14361f.size(); i++) {
            codedOutputStream.c(8, this.f14361f.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f14361f.size(); i3++) {
            i2 += CodedOutputStream.a(8, this.f14361f.get(i3));
        }
        this.f18584c = i2;
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1471i c1471i = null;
        switch (C1471i.f15026a[methodToInvoke.ordinal()]) {
            case 1:
                return new Billing();
            case 2:
                return f14359d;
            case 3:
                this.f14361f.L();
                return null;
            case 4:
                return new Builder(c1471i);
            case 5:
                this.f14361f = ((GeneratedMessageLite.Visitor) obj).a(this.f14361f, ((Billing) obj2).f14361f);
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
                                if (x != 66) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    if (!this.f14361f.M()) {
                                        this.f14361f = GeneratedMessageLite.a(this.f14361f);
                                    }
                                    this.f14361f.add((BillingDestination) codedInputStream.a(BillingDestination.p(), extensionRegistryLite));
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
                if (f14360e == null) {
                    synchronized (Billing.class) {
                        if (f14360e == null) {
                            f14360e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14359d);
                        }
                    }
                }
                return f14360e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14359d;
    }

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class BillingDestination extends GeneratedMessageLite<BillingDestination, Builder> implements BillingDestinationOrBuilder {

        /* renamed from: d, reason: collision with root package name */
        private static final BillingDestination f14362d = new BillingDestination();

        /* renamed from: e, reason: collision with root package name */
        private static volatile Parser<BillingDestination> f14363e;

        /* renamed from: f, reason: collision with root package name */
        private int f14364f;

        /* renamed from: g, reason: collision with root package name */
        private String f14365g = "";

        /* renamed from: h, reason: collision with root package name */
        private Internal.ProtobufList<String> f14366h = GeneratedMessageLite.k();

        /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<BillingDestination, Builder> implements BillingDestinationOrBuilder {
            /* synthetic */ Builder(C1471i c1471i) {
                this();
            }

            private Builder() {
                super(BillingDestination.f14362d);
            }
        }

        static {
            f14362d.l();
        }

        private BillingDestination() {
        }

        public static Parser<BillingDestination> p() {
            return f14362d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.f14365g.isEmpty()) {
                codedOutputStream.b(1, o());
            }
            for (int i = 0; i < this.f14366h.size(); i++) {
                codedOutputStream.b(2, this.f14366h.get(i));
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = !this.f14365g.isEmpty() ? CodedOutputStream.a(1, o()) + 0 : 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f14366h.size(); i3++) {
                i2 += CodedOutputStream.a(this.f14366h.get(i3));
            }
            int size = a2 + i2 + (n().size() * 1);
            this.f18584c = size;
            return size;
        }

        public List<String> n() {
            return this.f14366h;
        }

        public String o() {
            return this.f14365g;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            C1471i c1471i = null;
            switch (C1471i.f15026a[methodToInvoke.ordinal()]) {
                case 1:
                    return new BillingDestination();
                case 2:
                    return f14362d;
                case 3:
                    this.f14366h.L();
                    return null;
                case 4:
                    return new Builder(c1471i);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    BillingDestination billingDestination = (BillingDestination) obj2;
                    this.f14365g = visitor.a(!this.f14365g.isEmpty(), this.f14365g, true ^ billingDestination.f14365g.isEmpty(), billingDestination.f14365g);
                    this.f14366h = visitor.a(this.f14366h, billingDestination.f14366h);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f14364f |= billingDestination.f14364f;
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
                                    this.f14365g = codedInputStream.w();
                                } else if (x != 18) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    String w = codedInputStream.w();
                                    if (!this.f14366h.M()) {
                                        this.f14366h = GeneratedMessageLite.a(this.f14366h);
                                    }
                                    this.f14366h.add(w);
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
                    if (f14363e == null) {
                        synchronized (BillingDestination.class) {
                            if (f14363e == null) {
                                f14363e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14362d);
                            }
                        }
                    }
                    return f14363e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f14362d;
        }
    }
}
