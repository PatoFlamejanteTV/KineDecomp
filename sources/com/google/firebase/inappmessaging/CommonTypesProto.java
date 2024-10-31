package com.google.firebase.inappmessaging;

import a.b;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.type.Date;
import com.google.type.TimeOfDay;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class CommonTypesProto {

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public enum CampaignState implements Internal.EnumLite {
        UNKNOWN_CAMPAIGN_STATE(0),
        DRAFT(1),
        PUBLISHED(2),
        STOPPED(3),
        DELETED(4),
        UNRECOGNIZED(-1);

        public static final int DELETED_VALUE = 4;
        public static final int DRAFT_VALUE = 1;
        public static final int PUBLISHED_VALUE = 2;
        public static final int STOPPED_VALUE = 3;
        public static final int UNKNOWN_CAMPAIGN_STATE_VALUE = 0;
        private static final Internal.EnumLiteMap<CampaignState> internalValueMap = new d();
        private final int value;

        CampaignState(int i) {
            this.value = i;
        }

        public static CampaignState forNumber(int i) {
            if (i == 0) {
                return UNKNOWN_CAMPAIGN_STATE;
            }
            if (i == 1) {
                return DRAFT;
            }
            if (i == 2) {
                return PUBLISHED;
            }
            if (i == 3) {
                return STOPPED;
            }
            if (i != 4) {
                return null;
            }
            return DELETED;
        }

        public static Internal.EnumLiteMap<CampaignState> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static CampaignState valueOf(int i) {
            return forNumber(i);
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface CampaignTimeOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface DailyAnalyticsSummaryOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface DailyConversionSummaryOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface ExperimentVariantOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public enum ExperimentalCampaignState implements Internal.EnumLite {
        UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE(0),
        EXPERIMENT_DRAFT(1),
        EXPERIMENT_RUNNING(2),
        EXPERIMENT_STOPPED(3),
        EXPERIMENT_ROLLED_OUT(4),
        UNRECOGNIZED(-1);

        public static final int EXPERIMENT_DRAFT_VALUE = 1;
        public static final int EXPERIMENT_ROLLED_OUT_VALUE = 4;
        public static final int EXPERIMENT_RUNNING_VALUE = 2;
        public static final int EXPERIMENT_STOPPED_VALUE = 3;
        public static final int UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE_VALUE = 0;
        private static final Internal.EnumLiteMap<ExperimentalCampaignState> internalValueMap = new e();
        private final int value;

        ExperimentalCampaignState(int i) {
            this.value = i;
        }

        public static ExperimentalCampaignState forNumber(int i) {
            if (i == 0) {
                return UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE;
            }
            if (i == 1) {
                return EXPERIMENT_DRAFT;
            }
            if (i == 2) {
                return EXPERIMENT_RUNNING;
            }
            if (i == 3) {
                return EXPERIMENT_STOPPED;
            }
            if (i != 4) {
                return null;
            }
            return EXPERIMENT_ROLLED_OUT;
        }

        public static Internal.EnumLiteMap<ExperimentalCampaignState> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ExperimentalCampaignState valueOf(int i) {
            return forNumber(i);
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface PriorityOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface ScionConversionEventOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public enum Trigger implements Internal.EnumLite {
        UNKNOWN_TRIGGER(0),
        APP_LAUNCH(1),
        ON_FOREGROUND(2),
        UNRECOGNIZED(-1);

        public static final int APP_LAUNCH_VALUE = 1;
        public static final int ON_FOREGROUND_VALUE = 2;
        public static final int UNKNOWN_TRIGGER_VALUE = 0;
        private static final Internal.EnumLiteMap<Trigger> internalValueMap = new f();
        private final int value;

        Trigger(int i) {
            this.value = i;
        }

        public static Trigger forNumber(int i) {
            if (i == 0) {
                return UNKNOWN_TRIGGER;
            }
            if (i == 1) {
                return APP_LAUNCH;
            }
            if (i != 2) {
                return null;
            }
            return ON_FOREGROUND;
        }

        public static Internal.EnumLiteMap<Trigger> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static Trigger valueOf(int i) {
            return forNumber(i);
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface TriggeringConditionOrBuilder extends MessageLiteOrBuilder {
    }

    private CommonTypesProto() {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Priority extends GeneratedMessageLite<Priority, Builder> implements PriorityOrBuilder {

        /* renamed from: d */
        private static final Priority f17461d = new Priority();

        /* renamed from: e */
        private static volatile Parser<Priority> f17462e;

        /* renamed from: f */
        private int f17463f;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Priority, Builder> implements PriorityOrBuilder {
            /* synthetic */ Builder(c cVar) {
                this();
            }

            private Builder() {
                super(Priority.f17461d);
            }
        }

        static {
            f17461d.l();
        }

        private Priority() {
        }

        public static Priority n() {
            return f17461d;
        }

        public static Parser<Priority> p() {
            return f17461d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.f17463f;
            if (i != 0) {
                codedOutputStream.g(1, i);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = this.f17463f;
            int c2 = i2 != 0 ? 0 + CodedOutputStream.c(1, i2) : 0;
            this.f18584c = c2;
            return c2;
        }

        public int o() {
            return this.f17463f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (c.f17511a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Priority();
                case 2:
                    return f17461d;
                case 3:
                    return null;
                case 4:
                    return new Builder(null);
                case 5:
                    Priority priority = (Priority) obj2;
                    this.f17463f = ((GeneratedMessageLite.Visitor) obj).a(this.f17463f != 0, this.f17463f, priority.f17463f != 0, priority.f17463f);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!r1) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x != 8) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f17463f = codedInputStream.j();
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
                    if (f17462e == null) {
                        synchronized (Priority.class) {
                            if (f17462e == null) {
                                f17462e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17461d);
                            }
                        }
                    }
                    return f17462e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f17461d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class ScionConversionEvent extends GeneratedMessageLite<ScionConversionEvent, Builder> implements ScionConversionEventOrBuilder {

        /* renamed from: d */
        private static final ScionConversionEvent f17464d = new ScionConversionEvent();

        /* renamed from: e */
        private static volatile Parser<ScionConversionEvent> f17465e;

        /* renamed from: f */
        private String f17466f = "";

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ScionConversionEvent, Builder> implements ScionConversionEventOrBuilder {
            /* synthetic */ Builder(c cVar) {
                this();
            }

            private Builder() {
                super(ScionConversionEvent.f17464d);
            }
        }

        static {
            f17464d.l();
        }

        private ScionConversionEvent() {
        }

        public static Parser<ScionConversionEvent> o() {
            return f17464d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f17466f.isEmpty()) {
                return;
            }
            codedOutputStream.b(1, n());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f17466f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
            this.f18584c = a2;
            return a2;
        }

        public String n() {
            return this.f17466f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (c.f17511a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ScionConversionEvent();
                case 2:
                    return f17464d;
                case 3:
                    return null;
                case 4:
                    return new Builder(null);
                case 5:
                    ScionConversionEvent scionConversionEvent = (ScionConversionEvent) obj2;
                    this.f17466f = ((GeneratedMessageLite.Visitor) obj).a(!this.f17466f.isEmpty(), this.f17466f, true ^ scionConversionEvent.f17466f.isEmpty(), scionConversionEvent.f17466f);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x != 10) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f17466f = codedInputStream.w();
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
                    if (f17465e == null) {
                        synchronized (ScionConversionEvent.class) {
                            if (f17465e == null) {
                                f17465e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17464d);
                            }
                        }
                    }
                    return f17465e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f17464d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class DailyConversionSummary extends GeneratedMessageLite<DailyConversionSummary, Builder> implements DailyConversionSummaryOrBuilder {

        /* renamed from: d */
        private static final DailyConversionSummary f17453d = new DailyConversionSummary();

        /* renamed from: e */
        private static volatile Parser<DailyConversionSummary> f17454e;

        /* renamed from: f */
        private long f17455f;

        /* renamed from: g */
        private int f17456g;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DailyConversionSummary, Builder> implements DailyConversionSummaryOrBuilder {
            /* synthetic */ Builder(c cVar) {
                this();
            }

            private Builder() {
                super(DailyConversionSummary.f17453d);
            }
        }

        static {
            f17453d.l();
        }

        private DailyConversionSummary() {
        }

        public static Parser<DailyConversionSummary> n() {
            return f17453d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            long j = this.f17455f;
            if (j != 0) {
                codedOutputStream.e(1, j);
            }
            int i = this.f17456g;
            if (i != 0) {
                codedOutputStream.g(2, i);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            long j = this.f17455f;
            int b2 = j != 0 ? 0 + CodedOutputStream.b(1, j) : 0;
            int i2 = this.f17456g;
            if (i2 != 0) {
                b2 += CodedOutputStream.c(2, i2);
            }
            this.f18584c = b2;
            return b2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (c.f17511a[methodToInvoke.ordinal()]) {
                case 1:
                    return new DailyConversionSummary();
                case 2:
                    return f17453d;
                case 3:
                    return null;
                case 4:
                    return new Builder(null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    DailyConversionSummary dailyConversionSummary = (DailyConversionSummary) obj2;
                    this.f17455f = visitor.a(this.f17455f != 0, this.f17455f, dailyConversionSummary.f17455f != 0, dailyConversionSummary.f17455f);
                    this.f17456g = visitor.a(this.f17456g != 0, this.f17456g, dailyConversionSummary.f17456g != 0, dailyConversionSummary.f17456g);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!r1) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 8) {
                                    this.f17455f = codedInputStream.k();
                                } else if (x != 16) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f17456g = codedInputStream.j();
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
                    if (f17454e == null) {
                        synchronized (DailyConversionSummary.class) {
                            if (f17454e == null) {
                                f17454e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17453d);
                            }
                        }
                    }
                    return f17454e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f17453d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class ExperimentVariant extends GeneratedMessageLite<ExperimentVariant, Builder> implements ExperimentVariantOrBuilder {

        /* renamed from: d */
        private static final ExperimentVariant f17457d = new ExperimentVariant();

        /* renamed from: e */
        private static volatile Parser<ExperimentVariant> f17458e;

        /* renamed from: f */
        private int f17459f;

        /* renamed from: g */
        private MessagesProto.Content f17460g;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ExperimentVariant, Builder> implements ExperimentVariantOrBuilder {
            /* synthetic */ Builder(c cVar) {
                this();
            }

            private Builder() {
                super(ExperimentVariant.f17457d);
            }
        }

        static {
            f17457d.l();
        }

        private ExperimentVariant() {
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.f17459f;
            if (i != 0) {
                codedOutputStream.g(1, i);
            }
            if (this.f17460g != null) {
                codedOutputStream.c(2, n());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int i2 = this.f17459f;
            int c2 = i2 != 0 ? 0 + CodedOutputStream.c(1, i2) : 0;
            if (this.f17460g != null) {
                c2 += CodedOutputStream.a(2, n());
            }
            this.f18584c = c2;
            return c2;
        }

        public MessagesProto.Content n() {
            MessagesProto.Content content = this.f17460g;
            return content == null ? MessagesProto.Content.o() : content;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (c.f17511a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExperimentVariant();
                case 2:
                    return f17457d;
                case 3:
                    return null;
                case 4:
                    return new Builder(null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ExperimentVariant experimentVariant = (ExperimentVariant) obj2;
                    this.f17459f = visitor.a(this.f17459f != 0, this.f17459f, experimentVariant.f17459f != 0, experimentVariant.f17459f);
                    this.f17460g = (MessagesProto.Content) visitor.a(this.f17460g, experimentVariant.f17460g);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r0) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 8) {
                                    this.f17459f = codedInputStream.j();
                                } else if (x != 18) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    MessagesProto.Content.Builder b2 = this.f17460g != null ? this.f17460g.b() : null;
                                    this.f17460g = (MessagesProto.Content) codedInputStream.a(MessagesProto.Content.s(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((MessagesProto.Content.Builder) this.f17460g);
                                        this.f17460g = b2.T();
                                    }
                                }
                            }
                            r0 = true;
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
                    if (f17458e == null) {
                        synchronized (ExperimentVariant.class) {
                            if (f17458e == null) {
                                f17458e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17457d);
                            }
                        }
                    }
                    return f17458e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f17457d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class TriggeringCondition extends GeneratedMessageLite<TriggeringCondition, Builder> implements TriggeringConditionOrBuilder {

        /* renamed from: d */
        private static final TriggeringCondition f17467d = new TriggeringCondition();

        /* renamed from: e */
        private static volatile Parser<TriggeringCondition> f17468e;

        /* renamed from: f */
        private int f17469f = 0;

        /* renamed from: g */
        private Object f17470g;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<TriggeringCondition, Builder> implements TriggeringConditionOrBuilder {
            /* synthetic */ Builder(c cVar) {
                this();
            }

            private Builder() {
                super(TriggeringCondition.f17467d);
            }
        }

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public enum ConditionCase implements Internal.EnumLite {
            FIAM_TRIGGER(1),
            EVENT(2),
            CONDITION_NOT_SET(0);

            private final int value;

            ConditionCase(int i) {
                this.value = i;
            }

            public static ConditionCase forNumber(int i) {
                if (i == 0) {
                    return CONDITION_NOT_SET;
                }
                if (i == 1) {
                    return FIAM_TRIGGER;
                }
                if (i != 2) {
                    return null;
                }
                return EVENT;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static ConditionCase valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            f17467d.l();
        }

        private TriggeringCondition() {
        }

        public static Parser<TriggeringCondition> q() {
            return f17467d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f17469f == 1) {
                codedOutputStream.e(1, ((Integer) this.f17470g).intValue());
            }
            if (this.f17469f == 2) {
                codedOutputStream.c(2, (a.b) this.f17470g);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f17469f == 1 ? 0 + CodedOutputStream.a(1, ((Integer) this.f17470g).intValue()) : 0;
            if (this.f17469f == 2) {
                a2 += CodedOutputStream.a(2, (a.b) this.f17470g);
            }
            this.f18584c = a2;
            return a2;
        }

        public ConditionCase n() {
            return ConditionCase.forNumber(this.f17469f);
        }

        public a.b o() {
            if (this.f17469f == 2) {
                return (a.b) this.f17470g;
            }
            return a.b.n();
        }

        public Trigger p() {
            if (this.f17469f == 1) {
                Trigger forNumber = Trigger.forNumber(((Integer) this.f17470g).intValue());
                return forNumber == null ? Trigger.UNRECOGNIZED : forNumber;
            }
            return Trigger.UNKNOWN_TRIGGER;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i;
            switch (c.f17511a[methodToInvoke.ordinal()]) {
                case 1:
                    return new TriggeringCondition();
                case 2:
                    return f17467d;
                case 3:
                    return null;
                case 4:
                    return new Builder(null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    TriggeringCondition triggeringCondition = (TriggeringCondition) obj2;
                    int i2 = c.f17512b[triggeringCondition.n().ordinal()];
                    if (i2 == 1) {
                        this.f17470g = visitor.c(this.f17469f == 1, this.f17470g, triggeringCondition.f17470g);
                    } else if (i2 == 2) {
                        this.f17470g = visitor.e(this.f17469f == 2, this.f17470g, triggeringCondition.f17470g);
                    } else if (i2 == 3) {
                        visitor.a(this.f17469f != 0);
                    }
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a && (i = triggeringCondition.f17469f) != 0) {
                        this.f17469f = i;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r1) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 8) {
                                    int f2 = codedInputStream.f();
                                    this.f17469f = 1;
                                    this.f17470g = Integer.valueOf(f2);
                                } else if (x != 18) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    b.a b2 = this.f17469f == 2 ? ((a.b) this.f17470g).b() : null;
                                    this.f17470g = codedInputStream.a(a.b.t(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((b.a) this.f17470g);
                                        this.f17470g = b2.T();
                                    }
                                    this.f17469f = 2;
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
                    if (f17468e == null) {
                        synchronized (TriggeringCondition.class) {
                            if (f17468e == null) {
                                f17468e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17467d);
                            }
                        }
                    }
                    return f17468e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f17467d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class CampaignTime extends GeneratedMessageLite<CampaignTime, Builder> implements CampaignTimeOrBuilder {

        /* renamed from: d */
        private static final CampaignTime f17443d = new CampaignTime();

        /* renamed from: e */
        private static volatile Parser<CampaignTime> f17444e;

        /* renamed from: f */
        private Date f17445f;

        /* renamed from: g */
        private TimeOfDay f17446g;

        /* renamed from: h */
        private String f17447h = "";

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<CampaignTime, Builder> implements CampaignTimeOrBuilder {
            /* synthetic */ Builder(c cVar) {
                this();
            }

            private Builder() {
                super(CampaignTime.f17443d);
            }
        }

        static {
            f17443d.l();
        }

        private CampaignTime() {
        }

        public static CampaignTime o() {
            return f17443d;
        }

        public static Parser<CampaignTime> r() {
            return f17443d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f17445f != null) {
                codedOutputStream.c(1, n());
            }
            if (this.f17446g != null) {
                codedOutputStream.c(2, p());
            }
            if (this.f17447h.isEmpty()) {
                return;
            }
            codedOutputStream.b(3, q());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f17445f != null ? 0 + CodedOutputStream.a(1, n()) : 0;
            if (this.f17446g != null) {
                a2 += CodedOutputStream.a(2, p());
            }
            if (!this.f17447h.isEmpty()) {
                a2 += CodedOutputStream.a(3, q());
            }
            this.f18584c = a2;
            return a2;
        }

        public Date n() {
            Date date = this.f17445f;
            return date == null ? Date.n() : date;
        }

        public TimeOfDay p() {
            TimeOfDay timeOfDay = this.f17446g;
            return timeOfDay == null ? TimeOfDay.n() : timeOfDay;
        }

        public String q() {
            return this.f17447h;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (c.f17511a[methodToInvoke.ordinal()]) {
                case 1:
                    return new CampaignTime();
                case 2:
                    return f17443d;
                case 3:
                    return null;
                case 4:
                    return new Builder(null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CampaignTime campaignTime = (CampaignTime) obj2;
                    this.f17445f = (Date) visitor.a(this.f17445f, campaignTime.f17445f);
                    this.f17446g = (TimeOfDay) visitor.a(this.f17446g, campaignTime.f17446g);
                    this.f17447h = visitor.a(!this.f17447h.isEmpty(), this.f17447h, true ^ campaignTime.f17447h.isEmpty(), campaignTime.f17447h);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
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
                                    Date.Builder b2 = this.f17445f != null ? this.f17445f.b() : null;
                                    this.f17445f = (Date) codedInputStream.a(Date.o(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((Date.Builder) this.f17445f);
                                        this.f17445f = b2.T();
                                    }
                                } else if (x == 18) {
                                    TimeOfDay.Builder b3 = this.f17446g != null ? this.f17446g.b() : null;
                                    this.f17446g = (TimeOfDay) codedInputStream.a(TimeOfDay.o(), extensionRegistryLite);
                                    if (b3 != null) {
                                        b3.b((TimeOfDay.Builder) this.f17446g);
                                        this.f17446g = b3.T();
                                    }
                                } else if (x != 26) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f17447h = codedInputStream.w();
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
                    if (f17444e == null) {
                        synchronized (CampaignTime.class) {
                            if (f17444e == null) {
                                f17444e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17443d);
                            }
                        }
                    }
                    return f17444e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f17443d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class DailyAnalyticsSummary extends GeneratedMessageLite<DailyAnalyticsSummary, Builder> implements DailyAnalyticsSummaryOrBuilder {

        /* renamed from: d */
        private static final DailyAnalyticsSummary f17448d = new DailyAnalyticsSummary();

        /* renamed from: e */
        private static volatile Parser<DailyAnalyticsSummary> f17449e;

        /* renamed from: f */
        private long f17450f;

        /* renamed from: g */
        private int f17451g;

        /* renamed from: h */
        private int f17452h;
        private int i;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DailyAnalyticsSummary, Builder> implements DailyAnalyticsSummaryOrBuilder {
            /* synthetic */ Builder(c cVar) {
                this();
            }

            private Builder() {
                super(DailyAnalyticsSummary.f17448d);
            }
        }

        static {
            f17448d.l();
        }

        private DailyAnalyticsSummary() {
        }

        public static Parser<DailyAnalyticsSummary> n() {
            return f17448d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            long j = this.f17450f;
            if (j != 0) {
                codedOutputStream.e(1, j);
            }
            int i = this.f17451g;
            if (i != 0) {
                codedOutputStream.g(2, i);
            }
            int i2 = this.f17452h;
            if (i2 != 0) {
                codedOutputStream.g(3, i2);
            }
            int i3 = this.i;
            if (i3 != 0) {
                codedOutputStream.g(4, i3);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            long j = this.f17450f;
            int b2 = j != 0 ? 0 + CodedOutputStream.b(1, j) : 0;
            int i2 = this.f17451g;
            if (i2 != 0) {
                b2 += CodedOutputStream.c(2, i2);
            }
            int i3 = this.f17452h;
            if (i3 != 0) {
                b2 += CodedOutputStream.c(3, i3);
            }
            int i4 = this.i;
            if (i4 != 0) {
                b2 += CodedOutputStream.c(4, i4);
            }
            this.f18584c = b2;
            return b2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (c.f17511a[methodToInvoke.ordinal()]) {
                case 1:
                    return new DailyAnalyticsSummary();
                case 2:
                    return f17448d;
                case 3:
                    return null;
                case 4:
                    return new Builder(null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    DailyAnalyticsSummary dailyAnalyticsSummary = (DailyAnalyticsSummary) obj2;
                    this.f17450f = visitor.a(this.f17450f != 0, this.f17450f, dailyAnalyticsSummary.f17450f != 0, dailyAnalyticsSummary.f17450f);
                    this.f17451g = visitor.a(this.f17451g != 0, this.f17451g, dailyAnalyticsSummary.f17451g != 0, dailyAnalyticsSummary.f17451g);
                    this.f17452h = visitor.a(this.f17452h != 0, this.f17452h, dailyAnalyticsSummary.f17452h != 0, dailyAnalyticsSummary.f17452h);
                    this.i = visitor.a(this.i != 0, this.i, dailyAnalyticsSummary.i != 0, dailyAnalyticsSummary.i);
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
                                        this.f17450f = codedInputStream.k();
                                    } else if (x == 16) {
                                        this.f17451g = codedInputStream.j();
                                    } else if (x == 24) {
                                        this.f17452h = codedInputStream.j();
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
                    if (f17449e == null) {
                        synchronized (DailyAnalyticsSummary.class) {
                            if (f17449e == null) {
                                f17449e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17448d);
                            }
                        }
                    }
                    return f17449e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f17448d;
        }
    }
}
