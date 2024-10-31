package com.google.api;

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
public final class Endpoint extends GeneratedMessageLite<Endpoint, Builder> implements EndpointOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Endpoint f14424d = new Endpoint();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Endpoint> f14425e;

    /* renamed from: f, reason: collision with root package name */
    private int f14426f;

    /* renamed from: g, reason: collision with root package name */
    private String f14427g = "";

    /* renamed from: h, reason: collision with root package name */
    private Internal.ProtobufList<String> f14428h = GeneratedMessageLite.k();
    private Internal.ProtobufList<String> i = GeneratedMessageLite.k();
    private Internal.ProtobufList<String> j = GeneratedMessageLite.k();
    private String k = "";
    private boolean l;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Endpoint, Builder> implements EndpointOrBuilder {
        /* synthetic */ Builder(C1480s c1480s) {
            this();
        }

        private Builder() {
            super(Endpoint.f14424d);
        }
    }

    static {
        f14424d.l();
    }

    private Endpoint() {
    }

    public static Parser<Endpoint> s() {
        return f14424d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f14427g.isEmpty()) {
            codedOutputStream.b(1, q());
        }
        for (int i = 0; i < this.f14428h.size(); i++) {
            codedOutputStream.b(2, this.f14428h.get(i));
        }
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            codedOutputStream.b(3, this.i.get(i2));
        }
        for (int i3 = 0; i3 < this.j.size(); i3++) {
            codedOutputStream.b(4, this.j.get(i3));
        }
        boolean z = this.l;
        if (z) {
            codedOutputStream.b(5, z);
        }
        if (this.k.isEmpty()) {
            return;
        }
        codedOutputStream.b(101, r());
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = !this.f14427g.isEmpty() ? CodedOutputStream.a(1, q()) + 0 : 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f14428h.size(); i3++) {
            i2 += CodedOutputStream.a(this.f14428h.get(i3));
        }
        int size = a2 + i2 + (n().size() * 1);
        int i4 = 0;
        for (int i5 = 0; i5 < this.i.size(); i5++) {
            i4 += CodedOutputStream.a(this.i.get(i5));
        }
        int size2 = size + i4 + (o().size() * 1);
        int i6 = 0;
        for (int i7 = 0; i7 < this.j.size(); i7++) {
            i6 += CodedOutputStream.a(this.j.get(i7));
        }
        int size3 = size2 + i6 + (p().size() * 1);
        boolean z = this.l;
        if (z) {
            size3 += CodedOutputStream.a(5, z);
        }
        if (!this.k.isEmpty()) {
            size3 += CodedOutputStream.a(101, r());
        }
        this.f18584c = size3;
        return size3;
    }

    public List<String> n() {
        return this.f14428h;
    }

    public List<String> o() {
        return this.i;
    }

    public List<String> p() {
        return this.j;
    }

    public String q() {
        return this.f14427g;
    }

    public String r() {
        return this.k;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C1480s c1480s = null;
        switch (C1480s.f15036a[methodToInvoke.ordinal()]) {
            case 1:
                return new Endpoint();
            case 2:
                return f14424d;
            case 3:
                this.f14428h.L();
                this.i.L();
                this.j.L();
                return null;
            case 4:
                return new Builder(c1480s);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Endpoint endpoint = (Endpoint) obj2;
                this.f14427g = visitor.a(!this.f14427g.isEmpty(), this.f14427g, !endpoint.f14427g.isEmpty(), endpoint.f14427g);
                this.f14428h = visitor.a(this.f14428h, endpoint.f14428h);
                this.i = visitor.a(this.i, endpoint.i);
                this.j = visitor.a(this.j, endpoint.j);
                this.k = visitor.a(!this.k.isEmpty(), this.k, true ^ endpoint.k.isEmpty(), endpoint.k);
                boolean z = this.l;
                boolean z2 = endpoint.l;
                this.l = visitor.a(z, z, z2, z2);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                    this.f14426f |= endpoint.f14426f;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z3 = false;
                while (!z3) {
                    try {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    this.f14427g = codedInputStream.w();
                                } else if (x == 18) {
                                    String w = codedInputStream.w();
                                    if (!this.f14428h.M()) {
                                        this.f14428h = GeneratedMessageLite.a(this.f14428h);
                                    }
                                    this.f14428h.add(w);
                                } else if (x == 26) {
                                    String w2 = codedInputStream.w();
                                    if (!this.i.M()) {
                                        this.i = GeneratedMessageLite.a(this.i);
                                    }
                                    this.i.add(w2);
                                } else if (x == 34) {
                                    String w3 = codedInputStream.w();
                                    if (!this.j.M()) {
                                        this.j = GeneratedMessageLite.a(this.j);
                                    }
                                    this.j.add(w3);
                                } else if (x == 40) {
                                    this.l = codedInputStream.c();
                                } else if (x != 810) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.k = codedInputStream.w();
                                }
                            }
                            z3 = true;
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
                if (f14425e == null) {
                    synchronized (Endpoint.class) {
                        if (f14425e == null) {
                            f14425e = new GeneratedMessageLite.DefaultInstanceBasedParser(f14424d);
                        }
                    }
                }
                return f14425e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14424d;
    }
}
