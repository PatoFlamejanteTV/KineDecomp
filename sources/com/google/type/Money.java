package com.google.type;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class Money extends GeneratedMessageLite<Money, Builder> implements MoneyOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Money f18919d = new Money();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<Money> f18920e;

    /* renamed from: f, reason: collision with root package name */
    private String f18921f = "";

    /* renamed from: g, reason: collision with root package name */
    private long f18922g;

    /* renamed from: h, reason: collision with root package name */
    private int f18923h;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Money, Builder> implements MoneyOrBuilder {
        /* synthetic */ Builder(e eVar) {
            this();
        }

        private Builder() {
            super(Money.f18919d);
        }
    }

    static {
        f18919d.l();
    }

    private Money() {
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f18921f.isEmpty()) {
            codedOutputStream.b(1, n());
        }
        long j = this.f18922g;
        if (j != 0) {
            codedOutputStream.e(2, j);
        }
        int i = this.f18923h;
        if (i != 0) {
            codedOutputStream.g(3, i);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int a2 = this.f18921f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
        long j = this.f18922g;
        if (j != 0) {
            a2 += CodedOutputStream.b(2, j);
        }
        int i2 = this.f18923h;
        if (i2 != 0) {
            a2 += CodedOutputStream.c(3, i2);
        }
        this.f18584c = a2;
        return a2;
    }

    public String n() {
        return this.f18921f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        e eVar = null;
        switch (e.f18937a[methodToInvoke.ordinal()]) {
            case 1:
                return new Money();
            case 2:
                return f18919d;
            case 3:
                return null;
            case 4:
                return new Builder(eVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Money money = (Money) obj2;
                this.f18921f = visitor.a(!this.f18921f.isEmpty(), this.f18921f, !money.f18921f.isEmpty(), money.f18921f);
                this.f18922g = visitor.a(this.f18922g != 0, this.f18922g, money.f18922g != 0, money.f18922g);
                this.f18923h = visitor.a(this.f18923h != 0, this.f18923h, money.f18923h != 0, money.f18923h);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 10) {
                                this.f18921f = codedInputStream.w();
                            } else if (x == 16) {
                                this.f18922g = codedInputStream.k();
                            } else if (x != 24) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18923h = codedInputStream.j();
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
                if (f18920e == null) {
                    synchronized (Money.class) {
                        if (f18920e == null) {
                            f18920e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18919d);
                        }
                    }
                }
                return f18920e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18919d;
    }
}
