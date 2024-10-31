package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class EnumValue extends GeneratedMessageLite<EnumValue, Builder> implements EnumValueOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final EnumValue f18557d = new EnumValue();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<EnumValue> f18558e;

    /* renamed from: f, reason: collision with root package name */
    private int f18559f;

    /* renamed from: h, reason: collision with root package name */
    private int f18561h;

    /* renamed from: g, reason: collision with root package name */
    private String f18560g = "";
    private Internal.ProtobufList<Option> i = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<EnumValue, Builder> implements EnumValueOrBuilder {
        /* synthetic */ Builder(C1665t c1665t) {
            this();
        }

        private Builder() {
            super(EnumValue.f18557d);
        }
    }

    static {
        f18557d.l();
    }

    private EnumValue() {
    }

    public static Parser<EnumValue> o() {
        return f18557d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18560g.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        int i = this.f18561h;
        if (i != 0) {
            codedOutputStream.g(2, i);
        }
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            codedOutputStream.c(3, this.i.get(i2));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f18560g.isEmpty() ? CodedOutputStream.a(1, n()) + 0 : 0;
        int i2 = this.f18561h;
        if (i2 != 0) {
            a2 += CodedOutputStream.c(2, i2);
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            a2 += CodedOutputStream.a(3, this.i.get(i3));
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f18560g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1665t c1665t = null;
        switch (C1665t.f18797a[methodToInvoke.ordinal()]) {
            case 1:
                return new EnumValue();
            case 2:
                return f18557d;
            case 3:
                this.i.L();
                return null;
            case 4:
                return new Builder(c1665t);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                EnumValue enumValue = (EnumValue) obj2;
                this.f18560g = visitor.a(!this.f18560g.isEmpty(), this.f18560g, !enumValue.f18560g.isEmpty(), enumValue.f18560g);
                this.f18561h = visitor.a(this.f18561h != 0, this.f18561h, enumValue.f18561h != 0, enumValue.f18561h);
                this.i = visitor.a(this.i, enumValue.i);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f18559f |= enumValue.f18559f;
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
                                this.f18560g = codedInputStream.w();
                            } else if (x == 16) {
                                this.f18561h = codedInputStream.j();
                            } else if (x != 26) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                if (!this.i.M()) {
                                    this.i = GeneratedMessageLite.a(this.i);
                                }
                                this.i.add((Option) codedInputStream.a(Option.p(), extensionRegistryLite));
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
                if (f18558e == null) {
                    synchronized (EnumValue.class) {
                        if (f18558e == null) {
                            f18558e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18557d);
                        }
                    }
                }
                return f18558e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18557d;
    }
}
