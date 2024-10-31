package com.google.protos.datapol;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class RetentionAnnotations {

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface RetentionSpecOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public enum RetentionTag implements Internal.EnumLite {
        RT_DEFAULT(0),
        RT_OBSOLETE(1),
        RT_WEEK(10),
        RT_MONTH(20),
        RT_5_WEEKS(21),
        RT_QUARTER(30),
        RT_HALF_A_YEAR(40),
        RT_YEAR(50),
        RT_16_MONTHS(58),
        RT_YEAR_AND_A_HALF(60),
        RT_2_YEARS(70),
        RT_3_YEARS(80),
        RT_ARCHIVAL(1000);

        public static final int RT_16_MONTHS_VALUE = 58;
        public static final int RT_2_YEARS_VALUE = 70;
        public static final int RT_3_YEARS_VALUE = 80;
        public static final int RT_5_WEEKS_VALUE = 21;
        public static final int RT_ARCHIVAL_VALUE = 1000;
        public static final int RT_DEFAULT_VALUE = 0;
        public static final int RT_HALF_A_YEAR_VALUE = 40;
        public static final int RT_MONTH_VALUE = 20;
        public static final int RT_OBSOLETE_VALUE = 1;
        public static final int RT_QUARTER_VALUE = 30;
        public static final int RT_WEEK_VALUE = 10;
        public static final int RT_YEAR_AND_A_HALF_VALUE = 60;
        public static final int RT_YEAR_VALUE = 50;
        private static final Internal.EnumLiteMap<RetentionTag> internalValueMap = new b();
        private final int value;

        RetentionTag(int i) {
            this.value = i;
        }

        public static RetentionTag forNumber(int i) {
            if (i == 0) {
                return RT_DEFAULT;
            }
            if (i == 1) {
                return RT_OBSOLETE;
            }
            if (i == 10) {
                return RT_WEEK;
            }
            if (i == 30) {
                return RT_QUARTER;
            }
            if (i == 40) {
                return RT_HALF_A_YEAR;
            }
            if (i == 50) {
                return RT_YEAR;
            }
            if (i == 58) {
                return RT_16_MONTHS;
            }
            if (i == 60) {
                return RT_YEAR_AND_A_HALF;
            }
            if (i == 70) {
                return RT_2_YEARS;
            }
            if (i == 80) {
                return RT_3_YEARS;
            }
            if (i == 1000) {
                return RT_ARCHIVAL;
            }
            if (i == 20) {
                return RT_MONTH;
            }
            if (i != 21) {
                return null;
            }
            return RT_5_WEEKS;
        }

        public static Internal.EnumLiteMap<RetentionTag> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static RetentionTag valueOf(int i) {
            return forNumber(i);
        }
    }

    private RetentionAnnotations() {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class RetentionSpec extends GeneratedMessageLite<RetentionSpec, Builder> implements RetentionSpecOrBuilder {

        /* renamed from: d */
        private static final RetentionSpec f18803d = new RetentionSpec();

        /* renamed from: e */
        private static volatile Parser<RetentionSpec> f18804e;

        /* renamed from: f */
        private int f18805f;

        /* renamed from: g */
        private int f18806g;

        /* renamed from: h */
        private String f18807h = "*";

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<RetentionSpec, Builder> implements RetentionSpecOrBuilder {
            /* synthetic */ Builder(a aVar) {
                this();
            }

            private Builder() {
                super(RetentionSpec.f18803d);
            }
        }

        static {
            f18803d.l();
        }

        private RetentionSpec() {
        }

        public static RetentionSpec o() {
            return f18803d;
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.f18805f & 1) == 1) {
                codedOutputStream.e(1, this.f18806g);
            }
            if ((this.f18805f & 2) == 2) {
                codedOutputStream.b(2, n());
            }
            this.f18583b.a(codedOutputStream);
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = (this.f18805f & 1) == 1 ? 0 + CodedOutputStream.a(1, this.f18806g) : 0;
            if ((this.f18805f & 2) == 2) {
                a2 += CodedOutputStream.a(2, n());
            }
            int c2 = a2 + this.f18583b.c();
            this.f18584c = c2;
            return c2;
        }

        public String n() {
            return this.f18807h;
        }

        public boolean p() {
            return (this.f18805f & 2) == 2;
        }

        public boolean q() {
            return (this.f18805f & 1) == 1;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (a.f18834a[methodToInvoke.ordinal()]) {
                case 1:
                    return new RetentionSpec();
                case 2:
                    return f18803d;
                case 3:
                    return null;
                case 4:
                    return new Builder(null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    RetentionSpec retentionSpec = (RetentionSpec) obj2;
                    this.f18806g = visitor.a(q(), this.f18806g, retentionSpec.q(), retentionSpec.f18806g);
                    this.f18807h = visitor.a(p(), this.f18807h, retentionSpec.p(), retentionSpec.f18807h);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a) {
                        this.f18805f |= retentionSpec.f18805f;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 8) {
                                    int f2 = codedInputStream.f();
                                    if (RetentionTag.forNumber(f2) == null) {
                                        super.a(1, f2);
                                    } else {
                                        this.f18805f = 1 | this.f18805f;
                                        this.f18806g = f2;
                                    }
                                } else if (x != 18) {
                                    if (!a(x, codedInputStream)) {
                                    }
                                } else {
                                    String v = codedInputStream.v();
                                    this.f18805f |= 2;
                                    this.f18807h = v;
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
                    if (f18804e == null) {
                        synchronized (RetentionSpec.class) {
                            if (f18804e == null) {
                                f18804e = new GeneratedMessageLite.DefaultInstanceBasedParser(f18803d);
                            }
                        }
                    }
                    return f18804e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f18803d;
        }
    }
}
