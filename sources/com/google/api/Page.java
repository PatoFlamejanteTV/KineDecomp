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
public final class Page extends GeneratedMessageLite<Page, Builder> implements PageOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Page f14515d = new Page();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Page> f14516e;

    /* renamed from: f, reason: collision with root package name */
    private int f14517f;

    /* renamed from: g, reason: collision with root package name */
    private String f14518g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f14519h = "";
    private Internal.ProtobufList<Page> i = GeneratedMessageLite.k();

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Page, Builder> implements PageOrBuilder {
        /* synthetic */ Builder(K k) {
            this();
        }

        private Builder() {
            super(Page.f14515d);
        }
    }

    static {
        f14515d.l();
    }

    private Page() {
    }

    public static Parser<Page> p() {
        return f14515d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14518g.isEmpty()) {
            codedOutputStream.b(1, o());
        }
        if (!this.f14519h.isEmpty()) {
            codedOutputStream.b(2, n());
        }
        for (int i = 0; i < this.i.size(); i++) {
            codedOutputStream.c(3, this.i.get(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f14518g.isEmpty() ? CodedOutputStream.a(1, o()) + 0 : 0;
        if (!this.f14519h.isEmpty()) {
            a2 += CodedOutputStream.a(2, n());
        }
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            a2 += CodedOutputStream.a(3, this.i.get(i2));
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f14519h;
    }

    public String o() {
        return this.f14518g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        K k = null;
        switch (K.f14451a[methodToInvoke.ordinal()]) {
            case 1:
                return new Page();
            case 2:
                return f14515d;
            case 3:
                this.i.L();
                return null;
            case 4:
                return new Builder(k);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Page page = (Page) obj2;
                this.f14518g = visitor.a(!this.f14518g.isEmpty(), this.f14518g, !page.f14518g.isEmpty(), page.f14518g);
                this.f14519h = visitor.a(!this.f14519h.isEmpty(), this.f14519h, true ^ page.f14519h.isEmpty(), page.f14519h);
                this.i = visitor.a(this.i, page.i);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14517f |= page.f14517f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f14518g = codedInputStream.w();
                            } else if (x == 18) {
                                this.f14519h = codedInputStream.w();
                            } else if (x != 26) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                if (!this.i.M()) {
                                    this.i = GeneratedMessageLite.a(this.i);
                                }
                                this.i.add((Page) codedInputStream.a(p(), extensionRegistryLite));
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
                if (f14516e == null) {
                    synchronized (Page.class) {
                        if (f14516e == null) {
                            f14516e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14515d);
                        }
                    }
                }
                return f14516e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14515d;
    }
}
