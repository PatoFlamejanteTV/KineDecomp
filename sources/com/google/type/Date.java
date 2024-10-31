package com.google.type;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Date extends GeneratedMessageLite<Date, Builder> implements DateOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Date f18910d = new Date();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Date> f18911e;

    /* renamed from: f, reason: collision with root package name */
    private int f18912f;

    /* renamed from: g, reason: collision with root package name */
    private int f18913g;

    /* renamed from: h, reason: collision with root package name */
    private int f18914h;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Date, Builder> implements DateOrBuilder {
        /* synthetic */ Builder(b bVar) {
            this();
        }

        private Builder() {
            super(Date.f18910d);
        }
    }

    static {
        f18910d.l();
    }

    private Date() {
    }

    public static Date n() {
        return f18910d;
    }

    public static Parser<Date> o() {
        return f18910d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.f18912f;
        if (i != 0) {
            codedOutputStream.g(1, i);
        }
        int i2 = this.f18913g;
        if (i2 != 0) {
            codedOutputStream.g(2, i2);
        }
        int i3 = this.f18914h;
        if (i3 != 0) {
            codedOutputStream.g(3, i3);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = this.f18912f;
        int c2 = i2 != 0 ? 0 + CodedOutputStream.c(1, i2) : 0;
        int i3 = this.f18913g;
        if (i3 != 0) {
            c2 += CodedOutputStream.c(2, i3);
        }
        int i4 = this.f18914h;
        if (i4 != 0) {
            c2 += CodedOutputStream.c(3, i4);
        }
        this.f18584c = c2;
        return c2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        b bVar = null;
        switch (b.f18935a[methodToInvoke.ordinal()]) {
            case 1:
                return new Date();
            case 2:
                return f18910d;
            case 3:
                return null;
            case 4:
                return new Builder(bVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Date date = (Date) obj2;
                this.f18912f = visitor.a(this.f18912f != 0, this.f18912f, date.f18912f != 0, date.f18912f);
                this.f18913g = visitor.a(this.f18913g != 0, this.f18913g, date.f18913g != 0, date.f18913g);
                this.f18914h = visitor.a(this.f18914h != 0, this.f18914h, date.f18914h != 0, date.f18914h);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 8) {
                                this.f18912f = codedInputStream.j();
                            } else if (x == 16) {
                                this.f18913g = codedInputStream.j();
                            } else if (x != 24) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18914h = codedInputStream.j();
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
                if (f18911e == null) {
                    synchronized (Date.class) {
                        if (f18911e == null) {
                            f18911e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18910d);
                        }
                    }
                }
                return f18911e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18910d;
    }
}
