package com.google.type;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* loaded from: classes2.dex */
public final class TimeOfDay extends GeneratedMessageLite<TimeOfDay, Builder> implements TimeOfDayOrBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final TimeOfDay f18929d = new TimeOfDay();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Parser<TimeOfDay> f18930e;

    /* renamed from: f, reason: collision with root package name */
    private int f18931f;

    /* renamed from: g, reason: collision with root package name */
    private int f18932g;

    /* renamed from: h, reason: collision with root package name */
    private int f18933h;
    private int i;

    /* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<TimeOfDay, Builder> implements TimeOfDayOrBuilder {
        /* synthetic */ Builder(g gVar) {
            this();
        }

        private Builder() {
            super(TimeOfDay.f18929d);
        }
    }

    static {
        f18929d.l();
    }

    private TimeOfDay() {
    }

    public static TimeOfDay n() {
        return f18929d;
    }

    public static Parser<TimeOfDay> o() {
        return f18929d.f();
    }

    @Override // com.google.protobuf.MessageLite
    public void a(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.f18931f;
        if (i != 0) {
            codedOutputStream.g(1, i);
        }
        int i2 = this.f18932g;
        if (i2 != 0) {
            codedOutputStream.g(2, i2);
        }
        int i3 = this.f18933h;
        if (i3 != 0) {
            codedOutputStream.g(3, i3);
        }
        int i4 = this.i;
        if (i4 != 0) {
            codedOutputStream.g(4, i4);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int d() {
        int i = this.f18584c;
        if (i != -1) {
            return i;
        }
        int i2 = this.f18931f;
        int c2 = i2 != 0 ? 0 + CodedOutputStream.c(1, i2) : 0;
        int i3 = this.f18932g;
        if (i3 != 0) {
            c2 += CodedOutputStream.c(2, i3);
        }
        int i4 = this.f18933h;
        if (i4 != 0) {
            c2 += CodedOutputStream.c(3, i4);
        }
        int i5 = this.i;
        if (i5 != 0) {
            c2 += CodedOutputStream.c(4, i5);
        }
        this.f18584c = c2;
        return c2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        g gVar = null;
        switch (g.f18939a[methodToInvoke.ordinal()]) {
            case 1:
                return new TimeOfDay();
            case 2:
                return f18929d;
            case 3:
                return null;
            case 4:
                return new Builder(gVar);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                TimeOfDay timeOfDay = (TimeOfDay) obj2;
                this.f18931f = visitor.a(this.f18931f != 0, this.f18931f, timeOfDay.f18931f != 0, timeOfDay.f18931f);
                this.f18932g = visitor.a(this.f18932g != 0, this.f18932g, timeOfDay.f18932g != 0, timeOfDay.f18932g);
                this.f18933h = visitor.a(this.f18933h != 0, this.f18933h, timeOfDay.f18933h != 0, timeOfDay.f18933h);
                this.i = visitor.a(this.i != 0, this.i, timeOfDay.i != 0, timeOfDay.i);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 8) {
                                    this.f18931f = codedInputStream.j();
                                } else if (x == 16) {
                                    this.f18932g = codedInputStream.j();
                                } else if (x == 24) {
                                    this.f18933h = codedInputStream.j();
                                } else if (x != 32) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.i = codedInputStream.j();
                                }
                            }
                            r1 = true;
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
                if (f18930e == null) {
                    synchronized (TimeOfDay.class) {
                        if (f18930e == null) {
                            f18930e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18929d);
                        }
                    }
                }
                return f18930e;
            default:
                throw new UnsupportedOperationException();
        }
        return f18929d;
    }
}
