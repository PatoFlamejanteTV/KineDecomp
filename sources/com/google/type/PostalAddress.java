package com.google.type;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class PostalAddress extends GeneratedMessageLite<PostalAddress, Builder> implements PostalAddressOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final PostalAddress f18924d = new PostalAddress();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<PostalAddress> f18925e;

    /* renamed from: f, reason: collision with root package name */
    private int f18926f;

    /* renamed from: g, reason: collision with root package name */
    private int f18927g;

    /* renamed from: h, reason: collision with root package name */
    private String f18928h = "";
    private String i = "";
    private String j = "";
    private String k = "";
    private String l = "";
    private String m = "";
    private String n = "";
    private Internal.ProtobufList<String> o = GeneratedMessageLite.k();
    private Internal.ProtobufList<String> p = GeneratedMessageLite.k();
    private String q = "";

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<PostalAddress, Builder> implements PostalAddressOrBuilder {
        /* synthetic */ Builder(f fVar) {
            this();
        }

        private Builder() {
            super(PostalAddress.f18924d);
        }
    }

    static {
        f18924d.l();
    }

    private PostalAddress() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.f18927g;
        if (i != 0) {
            codedOutputStream.g(1, i);
        }
        if (!this.f18928h.isEmpty()) {
            codedOutputStream.b(2, u());
        }
        if (!this.i.isEmpty()) {
            codedOutputStream.b(3, p());
        }
        if (!this.j.isEmpty()) {
            codedOutputStream.b(4, s());
        }
        if (!this.k.isEmpty()) {
            codedOutputStream.b(5, v());
        }
        if (!this.l.isEmpty()) {
            codedOutputStream.b(6, o());
        }
        if (!this.m.isEmpty()) {
            codedOutputStream.b(7, q());
        }
        if (!this.n.isEmpty()) {
            codedOutputStream.b(8, w());
        }
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            codedOutputStream.b(9, this.o.get(i2));
        }
        for (int i3 = 0; i3 < this.p.size(); i3++) {
            codedOutputStream.b(10, this.p.get(i3));
        }
        if (this.q.isEmpty()) {
            return;
        }
        codedOutputStream.b(11, r());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = this.f18927g;
        int c2 = i2 != 0 ? CodedOutputStream.c(1, i2) + 0 : 0;
        if (!this.f18928h.isEmpty()) {
            c2 += CodedOutputStream.a(2, u());
        }
        if (!this.i.isEmpty()) {
            c2 += CodedOutputStream.a(3, p());
        }
        if (!this.j.isEmpty()) {
            c2 += CodedOutputStream.a(4, s());
        }
        if (!this.k.isEmpty()) {
            c2 += CodedOutputStream.a(5, v());
        }
        if (!this.l.isEmpty()) {
            c2 += CodedOutputStream.a(6, o());
        }
        if (!this.m.isEmpty()) {
            c2 += CodedOutputStream.a(7, q());
        }
        if (!this.n.isEmpty()) {
            c2 += CodedOutputStream.a(8, w());
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.o.size(); i4++) {
            i3 += CodedOutputStream.a(this.o.get(i4));
        }
        int size = c2 + i3 + (n().size() * 1);
        int i5 = 0;
        for (int i6 = 0; i6 < this.p.size(); i6++) {
            i5 += CodedOutputStream.a(this.p.get(i6));
        }
        int size2 = size + i5 + (t().size() * 1);
        if (!this.q.isEmpty()) {
            size2 += CodedOutputStream.a(11, r());
        }
        this.f18584c = size2;
        return size2;
    }

    public List<String> n() {
        return this.o;
    }

    public String o() {
        return this.l;
    }

    public String p() {
        return this.i;
    }

    public String q() {
        return this.m;
    }

    public String r() {
        return this.q;
    }

    public String s() {
        return this.j;
    }

    public List<String> t() {
        return this.p;
    }

    public String u() {
        return this.f18928h;
    }

    public String v() {
        return this.k;
    }

    public String w() {
        return this.n;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        f fVar = null;
        switch (f.f18938a[methodToInvoke.ordinal()]) {
            case 1:
                return new PostalAddress();
            case 2:
                return f18924d;
            case 3:
                this.o.L();
                this.p.L();
                return null;
            case 4:
                return new Builder(fVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                PostalAddress postalAddress = (PostalAddress) obj2;
                this.f18927g = visitor.a(this.f18927g != 0, this.f18927g, postalAddress.f18927g != 0, postalAddress.f18927g);
                this.f18928h = visitor.a(!this.f18928h.isEmpty(), this.f18928h, !postalAddress.f18928h.isEmpty(), postalAddress.f18928h);
                this.i = visitor.a(!this.i.isEmpty(), this.i, !postalAddress.i.isEmpty(), postalAddress.i);
                this.j = visitor.a(!this.j.isEmpty(), this.j, !postalAddress.j.isEmpty(), postalAddress.j);
                this.k = visitor.a(!this.k.isEmpty(), this.k, !postalAddress.k.isEmpty(), postalAddress.k);
                this.l = visitor.a(!this.l.isEmpty(), this.l, !postalAddress.l.isEmpty(), postalAddress.l);
                this.m = visitor.a(!this.m.isEmpty(), this.m, !postalAddress.m.isEmpty(), postalAddress.m);
                this.n = visitor.a(!this.n.isEmpty(), this.n, !postalAddress.n.isEmpty(), postalAddress.n);
                this.o = visitor.a(this.o, postalAddress.o);
                this.p = visitor.a(this.p, postalAddress.p);
                this.q = visitor.a(!this.q.isEmpty(), this.q, !postalAddress.q.isEmpty(), postalAddress.q);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f18926f |= postalAddress.f18926f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        switch (x) {
                            case 0:
                                r1 = true;
                            case 8:
                                this.f18927g = codedInputStream.j();
                            case 18:
                                this.f18928h = codedInputStream.w();
                            case 26:
                                this.i = codedInputStream.w();
                            case 34:
                                this.j = codedInputStream.w();
                            case 42:
                                this.k = codedInputStream.w();
                            case 50:
                                this.l = codedInputStream.w();
                            case 58:
                                this.m = codedInputStream.w();
                            case 66:
                                this.n = codedInputStream.w();
                            case 74:
                                String w = codedInputStream.w();
                                if (!this.o.M()) {
                                    this.o = GeneratedMessageLite.a(this.o);
                                }
                                this.o.add(w);
                            case 82:
                                String w2 = codedInputStream.w();
                                if (!this.p.M()) {
                                    this.p = GeneratedMessageLite.a(this.p);
                                }
                                this.p.add(w2);
                            case 90:
                                this.q = codedInputStream.w();
                            default:
                                if (!codedInputStream.f(x)) {
                                    r1 = true;
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
                if (f18925e == null) {
                    synchronized (PostalAddress.class) {
                        if (f18925e == null) {
                            f18925e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18924d);
                        }
                    }
                }
                return f18925e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18924d;
    }
}
