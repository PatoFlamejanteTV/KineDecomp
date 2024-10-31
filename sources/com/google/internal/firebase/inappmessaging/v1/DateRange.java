package com.google.internal.firebase.inappmessaging.v1;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class DateRange extends GeneratedMessageLite<DateRange, Builder> implements DateRangeOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final DateRange f18240d = new DateRange();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<DateRange> f18241e;

    /* renamed from: f, reason: collision with root package name */
    private long f18242f;

    /* renamed from: g, reason: collision with root package name */
    private long f18243g;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<DateRange, Builder> implements DateRangeOrBuilder {
        /* synthetic */ Builder(d dVar) {
            this();
        }

        private Builder() {
            super(DateRange.f18240d);
        }
    }

    static {
        f18240d.l();
    }

    private DateRange() {
    }

    public static DateRange n() {
        return f18240d;
    }

    public static Parser<DateRange> o() {
        return f18240d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.f18242f;
        if (j != 0) {
            codedOutputStream.e(1, j);
        }
        long j2 = this.f18243g;
        if (j2 != 0) {
            codedOutputStream.e(2, j2);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        long j = this.f18242f;
        int b2 = j != 0 ? 0 + CodedOutputStream.b(1, j) : 0;
        long j2 = this.f18243g;
        if (j2 != 0) {
            b2 += CodedOutputStream.b(2, j2);
        }
        this.f18584c = b2;
        return b2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        d dVar = null;
        boolean z = false;
        switch (d.f18293a[methodToInvoke.ordinal()]) {
            case 1:
                return new DateRange();
            case 2:
                return f18240d;
            case 3:
                return null;
            case 4:
                return new Builder(dVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                DateRange dateRange = (DateRange) obj2;
                this.f18242f = visitor.a(this.f18242f != 0, this.f18242f, dateRange.f18242f != 0, dateRange.f18242f);
                this.f18243g = visitor.a(this.f18243g != 0, this.f18243g, dateRange.f18243g != 0, dateRange.f18243g);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!z) {
                    try {
                        int x = codedInputStream.x();
                        if (x != 0) {
                            if (x == 8) {
                                this.f18242f = codedInputStream.k();
                            } else if (x != 16) {
                                if (!codedInputStream.f(x)) {
                                }
                            } else {
                                this.f18243g = codedInputStream.k();
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
                if (f18241e == null) {
                    synchronized (DateRange.class) {
                        if (f18241e == null) {
                            f18241e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18240d);
                        }
                    }
                }
                return f18241e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18240d;
    }
}
