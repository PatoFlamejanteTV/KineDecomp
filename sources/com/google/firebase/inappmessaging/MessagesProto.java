package com.google.firebase.inappmessaging;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class MessagesProto {

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface ActionOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface BannerMessageOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface ButtonOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface ContentOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface ImageOnlyMessageOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface ModalMessageOrBuilder extends MessageLiteOrBuilder {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface TextOrBuilder extends MessageLiteOrBuilder {
    }

    private MessagesProto() {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Action extends GeneratedMessageLite<Action, Builder> implements ActionOrBuilder {

        /* renamed from: d */
        private static final Action f17479d = new Action();

        /* renamed from: e */
        private static volatile Parser<Action> f17480e;

        /* renamed from: f */
        private String f17481f = "";

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Action, Builder> implements ActionOrBuilder {
            /* synthetic */ Builder(m mVar) {
                this();
            }

            private Builder() {
                super(Action.f17479d);
            }
        }

        static {
            f17479d.l();
        }

        private Action() {
        }

        public static Action o() {
            return f17479d;
        }

        public static Parser<Action> p() {
            return f17479d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f17481f.isEmpty()) {
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
            int a2 = this.f17481f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, n());
            this.f18584c = a2;
            return a2;
        }

        public String n() {
            return this.f17481f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (m.f18012b[methodToInvoke.ordinal()]) {
                case 1:
                    return new Action();
                case 2:
                    return f17479d;
                case 3:
                    return null;
                case 4:
                    return new Builder(null);
                case 5:
                    Action action = (Action) obj2;
                    this.f17481f = ((GeneratedMessageLite.Visitor) obj).a(!this.f17481f.isEmpty(), this.f17481f, true ^ action.f17481f.isEmpty(), action.f17481f);
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
                                    this.f17481f = codedInputStream.w();
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
                    if (f17480e == null) {
                        synchronized (Action.class) {
                            if (f17480e == null) {
                                f17480e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17479d);
                            }
                        }
                    }
                    return f17480e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f17479d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Button extends GeneratedMessageLite<Button, Builder> implements ButtonOrBuilder {

        /* renamed from: d */
        private static final Button f17487d = new Button();

        /* renamed from: e */
        private static volatile Parser<Button> f17488e;

        /* renamed from: f */
        private Text f17489f;

        /* renamed from: g */
        private String f17490g = "";

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Button, Builder> implements ButtonOrBuilder {
            /* synthetic */ Builder(m mVar) {
                this();
            }

            private Builder() {
                super(Button.f17487d);
            }
        }

        static {
            f17487d.l();
        }

        private Button() {
        }

        public static Button o() {
            return f17487d;
        }

        public static Parser<Button> r() {
            return f17487d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f17489f != null) {
                codedOutputStream.c(1, p());
            }
            if (this.f17490g.isEmpty()) {
                return;
            }
            codedOutputStream.b(2, n());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f17489f != null ? 0 + CodedOutputStream.a(1, p()) : 0;
            if (!this.f17490g.isEmpty()) {
                a2 += CodedOutputStream.a(2, n());
            }
            this.f18584c = a2;
            return a2;
        }

        public String n() {
            return this.f17490g;
        }

        public Text p() {
            Text text = this.f17489f;
            return text == null ? Text.n() : text;
        }

        public boolean q() {
            return this.f17489f != null;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (m.f18012b[methodToInvoke.ordinal()]) {
                case 1:
                    return new Button();
                case 2:
                    return f17487d;
                case 3:
                    return null;
                case 4:
                    return new Builder(null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Button button = (Button) obj2;
                    this.f17489f = (Text) visitor.a(this.f17489f, button.f17489f);
                    this.f17490g = visitor.a(!this.f17490g.isEmpty(), this.f17490g, true ^ button.f17490g.isEmpty(), button.f17490g);
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
                                    Text.Builder b2 = this.f17489f != null ? this.f17489f.b() : null;
                                    this.f17489f = (Text) codedInputStream.a(Text.q(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((Text.Builder) this.f17489f);
                                        this.f17489f = b2.T();
                                    }
                                } else if (x != 18) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f17490g = codedInputStream.w();
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
                    if (f17488e == null) {
                        synchronized (Button.class) {
                            if (f17488e == null) {
                                f17488e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17487d);
                            }
                        }
                    }
                    return f17488e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f17487d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class ImageOnlyMessage extends GeneratedMessageLite<ImageOnlyMessage, Builder> implements ImageOnlyMessageOrBuilder {

        /* renamed from: d */
        private static final ImageOnlyMessage f17495d = new ImageOnlyMessage();

        /* renamed from: e */
        private static volatile Parser<ImageOnlyMessage> f17496e;

        /* renamed from: f */
        private String f17497f = "";

        /* renamed from: g */
        private Action f17498g;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ImageOnlyMessage, Builder> implements ImageOnlyMessageOrBuilder {
            /* synthetic */ Builder(m mVar) {
                this();
            }

            private Builder() {
                super(ImageOnlyMessage.f17495d);
            }
        }

        static {
            f17495d.l();
        }

        private ImageOnlyMessage() {
        }

        public static ImageOnlyMessage o() {
            return f17495d;
        }

        public static Parser<ImageOnlyMessage> r() {
            return f17495d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.f17497f.isEmpty()) {
                codedOutputStream.b(1, p());
            }
            if (this.f17498g != null) {
                codedOutputStream.c(2, n());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f17497f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, p());
            if (this.f17498g != null) {
                a2 += CodedOutputStream.a(2, n());
            }
            this.f18584c = a2;
            return a2;
        }

        public Action n() {
            Action action = this.f17498g;
            return action == null ? Action.o() : action;
        }

        public String p() {
            return this.f17497f;
        }

        public boolean q() {
            return this.f17498g != null;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (m.f18012b[methodToInvoke.ordinal()]) {
                case 1:
                    return new ImageOnlyMessage();
                case 2:
                    return f17495d;
                case 3:
                    return null;
                case 4:
                    return new Builder(null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ImageOnlyMessage imageOnlyMessage = (ImageOnlyMessage) obj2;
                    this.f17497f = visitor.a(!this.f17497f.isEmpty(), this.f17497f, true ^ imageOnlyMessage.f17497f.isEmpty(), imageOnlyMessage.f17497f);
                    this.f17498g = (Action) visitor.a(this.f17498g, imageOnlyMessage.f17498g);
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
                                    this.f17497f = codedInputStream.w();
                                } else if (x != 18) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    Action.Builder b2 = this.f17498g != null ? this.f17498g.b() : null;
                                    this.f17498g = (Action) codedInputStream.a(Action.p(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((Action.Builder) this.f17498g);
                                        this.f17498g = b2.T();
                                    }
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
                    if (f17496e == null) {
                        synchronized (ImageOnlyMessage.class) {
                            if (f17496e == null) {
                                f17496e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17495d);
                            }
                        }
                    }
                    return f17496e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f17495d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Text extends GeneratedMessageLite<Text, Builder> implements TextOrBuilder {

        /* renamed from: d */
        private static final Text f17504d = new Text();

        /* renamed from: e */
        private static volatile Parser<Text> f17505e;

        /* renamed from: f */
        private String f17506f = "";

        /* renamed from: g */
        private String f17507g = "";

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Text, Builder> implements TextOrBuilder {
            /* synthetic */ Builder(m mVar) {
                this();
            }

            private Builder() {
                super(Text.f17504d);
            }
        }

        static {
            f17504d.l();
        }

        private Text() {
        }

        public static Text n() {
            return f17504d;
        }

        public static Parser<Text> q() {
            return f17504d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.f17506f.isEmpty()) {
                codedOutputStream.b(1, p());
            }
            if (this.f17507g.isEmpty()) {
                return;
            }
            codedOutputStream.b(2, o());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f17506f.isEmpty() ? 0 : 0 + CodedOutputStream.a(1, p());
            if (!this.f17507g.isEmpty()) {
                a2 += CodedOutputStream.a(2, o());
            }
            this.f18584c = a2;
            return a2;
        }

        public String o() {
            return this.f17507g;
        }

        public String p() {
            return this.f17506f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (m.f18012b[methodToInvoke.ordinal()]) {
                case 1:
                    return new Text();
                case 2:
                    return f17504d;
                case 3:
                    return null;
                case 4:
                    return new Builder(null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Text text = (Text) obj2;
                    this.f17506f = visitor.a(!this.f17506f.isEmpty(), this.f17506f, !text.f17506f.isEmpty(), text.f17506f);
                    this.f17507g = visitor.a(!this.f17507g.isEmpty(), this.f17507g, true ^ text.f17507g.isEmpty(), text.f17507g);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    this.f17506f = codedInputStream.w();
                                } else if (x != 18) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    this.f17507g = codedInputStream.w();
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
                    if (f17505e == null) {
                        synchronized (Text.class) {
                            if (f17505e == null) {
                                f17505e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17504d);
                            }
                        }
                    }
                    return f17505e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f17504d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Content extends GeneratedMessageLite<Content, Builder> implements ContentOrBuilder {

        /* renamed from: d */
        private static final Content f17491d = new Content();

        /* renamed from: e */
        private static volatile Parser<Content> f17492e;

        /* renamed from: f */
        private int f17493f = 0;

        /* renamed from: g */
        private Object f17494g;

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Content, Builder> implements ContentOrBuilder {
            /* synthetic */ Builder(m mVar) {
                this();
            }

            private Builder() {
                super(Content.f17491d);
            }
        }

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public enum MessageDetailsCase implements Internal.EnumLite {
            BANNER(1),
            MODAL(2),
            IMAGE_ONLY(3),
            MESSAGEDETAILS_NOT_SET(0);

            private final int value;

            MessageDetailsCase(int i) {
                this.value = i;
            }

            public static MessageDetailsCase forNumber(int i) {
                if (i == 0) {
                    return MESSAGEDETAILS_NOT_SET;
                }
                if (i == 1) {
                    return BANNER;
                }
                if (i == 2) {
                    return MODAL;
                }
                if (i != 3) {
                    return null;
                }
                return IMAGE_ONLY;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static MessageDetailsCase valueOf(int i) {
                return forNumber(i);
            }
        }

        static {
            f17491d.l();
        }

        private Content() {
        }

        public static Content o() {
            return f17491d;
        }

        public static Parser<Content> s() {
            return f17491d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f17493f == 1) {
                codedOutputStream.c(1, (BannerMessage) this.f17494g);
            }
            if (this.f17493f == 2) {
                codedOutputStream.c(2, (ModalMessage) this.f17494g);
            }
            if (this.f17493f == 3) {
                codedOutputStream.c(3, (ImageOnlyMessage) this.f17494g);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f17493f == 1 ? 0 + CodedOutputStream.a(1, (BannerMessage) this.f17494g) : 0;
            if (this.f17493f == 2) {
                a2 += CodedOutputStream.a(2, (ModalMessage) this.f17494g);
            }
            if (this.f17493f == 3) {
                a2 += CodedOutputStream.a(3, (ImageOnlyMessage) this.f17494g);
            }
            this.f18584c = a2;
            return a2;
        }

        public BannerMessage n() {
            if (this.f17493f == 1) {
                return (BannerMessage) this.f17494g;
            }
            return BannerMessage.q();
        }

        public ImageOnlyMessage p() {
            if (this.f17493f == 3) {
                return (ImageOnlyMessage) this.f17494g;
            }
            return ImageOnlyMessage.o();
        }

        public MessageDetailsCase q() {
            return MessageDetailsCase.forNumber(this.f17493f);
        }

        public ModalMessage r() {
            if (this.f17493f == 2) {
                return (ModalMessage) this.f17494g;
            }
            return ModalMessage.r();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i;
            switch (m.f18012b[methodToInvoke.ordinal()]) {
                case 1:
                    return new Content();
                case 2:
                    return f17491d;
                case 3:
                    return null;
                case 4:
                    return new Builder(null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Content content = (Content) obj2;
                    int i2 = m.f18011a[content.q().ordinal()];
                    if (i2 == 1) {
                        this.f17494g = visitor.e(this.f17493f == 1, this.f17494g, content.f17494g);
                    } else if (i2 == 2) {
                        this.f17494g = visitor.e(this.f17493f == 2, this.f17494g, content.f17494g);
                    } else if (i2 == 3) {
                        this.f17494g = visitor.e(this.f17493f == 3, this.f17494g, content.f17494g);
                    } else if (i2 == 4) {
                        visitor.a(this.f17493f != 0);
                    }
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.f18600a && (i = content.f17493f) != 0) {
                        this.f17493f = i;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r2) {
                        try {
                            int x = codedInputStream.x();
                            if (x != 0) {
                                if (x == 10) {
                                    BannerMessage.Builder b2 = this.f17493f == 1 ? ((BannerMessage) this.f17494g).b() : null;
                                    this.f17494g = codedInputStream.a(BannerMessage.w(), extensionRegistryLite);
                                    if (b2 != null) {
                                        b2.b((BannerMessage.Builder) this.f17494g);
                                        this.f17494g = b2.T();
                                    }
                                    this.f17493f = 1;
                                } else if (x == 18) {
                                    ModalMessage.Builder b3 = this.f17493f == 2 ? ((ModalMessage) this.f17494g).b() : null;
                                    this.f17494g = codedInputStream.a(ModalMessage.y(), extensionRegistryLite);
                                    if (b3 != null) {
                                        b3.b((ModalMessage.Builder) this.f17494g);
                                        this.f17494g = b3.T();
                                    }
                                    this.f17493f = 2;
                                } else if (x != 26) {
                                    if (!codedInputStream.f(x)) {
                                    }
                                } else {
                                    ImageOnlyMessage.Builder b4 = this.f17493f == 3 ? ((ImageOnlyMessage) this.f17494g).b() : null;
                                    this.f17494g = codedInputStream.a(ImageOnlyMessage.r(), extensionRegistryLite);
                                    if (b4 != null) {
                                        b4.b((ImageOnlyMessage.Builder) this.f17494g);
                                        this.f17494g = b4.T();
                                    }
                                    this.f17493f = 3;
                                }
                            }
                            r2 = true;
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
                    if (f17492e == null) {
                        synchronized (Content.class) {
                            if (f17492e == null) {
                                f17492e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17491d);
                            }
                        }
                    }
                    return f17492e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f17491d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class BannerMessage extends GeneratedMessageLite<BannerMessage, Builder> implements BannerMessageOrBuilder {

        /* renamed from: d */
        private static final BannerMessage f17482d = new BannerMessage();

        /* renamed from: e */
        private static volatile Parser<BannerMessage> f17483e;

        /* renamed from: f */
        private Text f17484f;

        /* renamed from: g */
        private Text f17485g;
        private Action i;

        /* renamed from: h */
        private String f17486h = "";
        private String j = "";

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<BannerMessage, Builder> implements BannerMessageOrBuilder {
            /* synthetic */ Builder(m mVar) {
                this();
            }

            private Builder() {
                super(BannerMessage.f17482d);
            }
        }

        static {
            f17482d.l();
        }

        private BannerMessage() {
        }

        public static BannerMessage q() {
            return f17482d;
        }

        public static Parser<BannerMessage> w() {
            return f17482d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f17484f != null) {
                codedOutputStream.c(1, s());
            }
            if (this.f17485g != null) {
                codedOutputStream.c(2, p());
            }
            if (!this.f17486h.isEmpty()) {
                codedOutputStream.b(3, r());
            }
            if (this.i != null) {
                codedOutputStream.c(4, n());
            }
            if (this.j.isEmpty()) {
                return;
            }
            codedOutputStream.b(5, o());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f17484f != null ? 0 + CodedOutputStream.a(1, s()) : 0;
            if (this.f17485g != null) {
                a2 += CodedOutputStream.a(2, p());
            }
            if (!this.f17486h.isEmpty()) {
                a2 += CodedOutputStream.a(3, r());
            }
            if (this.i != null) {
                a2 += CodedOutputStream.a(4, n());
            }
            if (!this.j.isEmpty()) {
                a2 += CodedOutputStream.a(5, o());
            }
            this.f18584c = a2;
            return a2;
        }

        public Action n() {
            Action action = this.i;
            return action == null ? Action.o() : action;
        }

        public String o() {
            return this.j;
        }

        public Text p() {
            Text text = this.f17485g;
            return text == null ? Text.n() : text;
        }

        public String r() {
            return this.f17486h;
        }

        public Text s() {
            Text text = this.f17484f;
            return text == null ? Text.n() : text;
        }

        public boolean t() {
            return this.i != null;
        }

        public boolean u() {
            return this.f17485g != null;
        }

        public boolean v() {
            return this.f17484f != null;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (m.f18012b[methodToInvoke.ordinal()]) {
                case 1:
                    return new BannerMessage();
                case 2:
                    return f17482d;
                case 3:
                    return null;
                case 4:
                    return new Builder(null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    BannerMessage bannerMessage = (BannerMessage) obj2;
                    this.f17484f = (Text) visitor.a(this.f17484f, bannerMessage.f17484f);
                    this.f17485g = (Text) visitor.a(this.f17485g, bannerMessage.f17485g);
                    this.f17486h = visitor.a(!this.f17486h.isEmpty(), this.f17486h, !bannerMessage.f17486h.isEmpty(), bannerMessage.f17486h);
                    this.i = (Action) visitor.a(this.i, bannerMessage.i);
                    this.j = visitor.a(!this.j.isEmpty(), this.j, true ^ bannerMessage.j.isEmpty(), bannerMessage.j);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x == 10) {
                                        Text.Builder b2 = this.f17484f != null ? this.f17484f.b() : null;
                                        this.f17484f = (Text) codedInputStream.a(Text.q(), extensionRegistryLite);
                                        if (b2 != null) {
                                            b2.b((Text.Builder) this.f17484f);
                                            this.f17484f = b2.T();
                                        }
                                    } else if (x == 18) {
                                        Text.Builder b3 = this.f17485g != null ? this.f17485g.b() : null;
                                        this.f17485g = (Text) codedInputStream.a(Text.q(), extensionRegistryLite);
                                        if (b3 != null) {
                                            b3.b((Text.Builder) this.f17485g);
                                            this.f17485g = b3.T();
                                        }
                                    } else if (x == 26) {
                                        this.f17486h = codedInputStream.w();
                                    } else if (x == 34) {
                                        Action.Builder b4 = this.i != null ? this.i.b() : null;
                                        this.i = (Action) codedInputStream.a(Action.p(), extensionRegistryLite);
                                        if (b4 != null) {
                                            b4.b((Action.Builder) this.i);
                                            this.i = b4.T();
                                        }
                                    } else if (x != 42) {
                                        if (!codedInputStream.f(x)) {
                                        }
                                    } else {
                                        this.j = codedInputStream.w();
                                    }
                                }
                                z = true;
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
                    if (f17483e == null) {
                        synchronized (BannerMessage.class) {
                            if (f17483e == null) {
                                f17483e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17482d);
                            }
                        }
                    }
                    return f17483e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f17482d;
        }
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class ModalMessage extends GeneratedMessageLite<ModalMessage, Builder> implements ModalMessageOrBuilder {

        /* renamed from: d */
        private static final ModalMessage f17499d = new ModalMessage();

        /* renamed from: e */
        private static volatile Parser<ModalMessage> f17500e;

        /* renamed from: f */
        private Text f17501f;

        /* renamed from: g */
        private Text f17502g;
        private Button i;
        private Action j;

        /* renamed from: h */
        private String f17503h = "";
        private String k = "";

        /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ModalMessage, Builder> implements ModalMessageOrBuilder {
            /* synthetic */ Builder(m mVar) {
                this();
            }

            private Builder() {
                super(ModalMessage.f17499d);
            }
        }

        static {
            f17499d.l();
        }

        private ModalMessage() {
        }

        public static ModalMessage r() {
            return f17499d;
        }

        public static Parser<ModalMessage> y() {
            return f17499d.f();
        }

        @Override // com.google.protobuf.MessageLite
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (this.f17501f != null) {
                codedOutputStream.c(1, t());
            }
            if (this.f17502g != null) {
                codedOutputStream.c(2, q());
            }
            if (!this.f17503h.isEmpty()) {
                codedOutputStream.b(3, s());
            }
            if (this.i != null) {
                codedOutputStream.c(4, o());
            }
            if (this.j != null) {
                codedOutputStream.c(5, n());
            }
            if (this.k.isEmpty()) {
                return;
            }
            codedOutputStream.b(6, p());
        }

        @Override // com.google.protobuf.MessageLite
        public int d() {
            int i = this.f18584c;
            if (i != -1) {
                return i;
            }
            int a2 = this.f17501f != null ? 0 + CodedOutputStream.a(1, t()) : 0;
            if (this.f17502g != null) {
                a2 += CodedOutputStream.a(2, q());
            }
            if (!this.f17503h.isEmpty()) {
                a2 += CodedOutputStream.a(3, s());
            }
            if (this.i != null) {
                a2 += CodedOutputStream.a(4, o());
            }
            if (this.j != null) {
                a2 += CodedOutputStream.a(5, n());
            }
            if (!this.k.isEmpty()) {
                a2 += CodedOutputStream.a(6, p());
            }
            this.f18584c = a2;
            return a2;
        }

        public Action n() {
            Action action = this.j;
            return action == null ? Action.o() : action;
        }

        public Button o() {
            Button button = this.i;
            return button == null ? Button.o() : button;
        }

        public String p() {
            return this.k;
        }

        public Text q() {
            Text text = this.f17502g;
            return text == null ? Text.n() : text;
        }

        public String s() {
            return this.f17503h;
        }

        public Text t() {
            Text text = this.f17501f;
            return text == null ? Text.n() : text;
        }

        public boolean u() {
            return this.j != null;
        }

        public boolean v() {
            return this.i != null;
        }

        public boolean w() {
            return this.f17502g != null;
        }

        public boolean x() {
            return this.f17501f != null;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (m.f18012b[methodToInvoke.ordinal()]) {
                case 1:
                    return new ModalMessage();
                case 2:
                    return f17499d;
                case 3:
                    return null;
                case 4:
                    return new Builder(null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ModalMessage modalMessage = (ModalMessage) obj2;
                    this.f17501f = (Text) visitor.a(this.f17501f, modalMessage.f17501f);
                    this.f17502g = (Text) visitor.a(this.f17502g, modalMessage.f17502g);
                    this.f17503h = visitor.a(!this.f17503h.isEmpty(), this.f17503h, !modalMessage.f17503h.isEmpty(), modalMessage.f17503h);
                    this.i = (Button) visitor.a(this.i, modalMessage.i);
                    this.j = (Action) visitor.a(this.j, modalMessage.j);
                    this.k = visitor.a(!this.k.isEmpty(), this.k, true ^ modalMessage.k.isEmpty(), modalMessage.k);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.f18600a;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int x = codedInputStream.x();
                                if (x != 0) {
                                    if (x == 10) {
                                        Text.Builder b2 = this.f17501f != null ? this.f17501f.b() : null;
                                        this.f17501f = (Text) codedInputStream.a(Text.q(), extensionRegistryLite);
                                        if (b2 != null) {
                                            b2.b((Text.Builder) this.f17501f);
                                            this.f17501f = b2.T();
                                        }
                                    } else if (x == 18) {
                                        Text.Builder b3 = this.f17502g != null ? this.f17502g.b() : null;
                                        this.f17502g = (Text) codedInputStream.a(Text.q(), extensionRegistryLite);
                                        if (b3 != null) {
                                            b3.b((Text.Builder) this.f17502g);
                                            this.f17502g = b3.T();
                                        }
                                    } else if (x == 26) {
                                        this.f17503h = codedInputStream.w();
                                    } else if (x == 34) {
                                        Button.Builder b4 = this.i != null ? this.i.b() : null;
                                        this.i = (Button) codedInputStream.a(Button.r(), extensionRegistryLite);
                                        if (b4 != null) {
                                            b4.b((Button.Builder) this.i);
                                            this.i = b4.T();
                                        }
                                    } else if (x == 42) {
                                        Action.Builder b5 = this.j != null ? this.j.b() : null;
                                        this.j = (Action) codedInputStream.a(Action.p(), extensionRegistryLite);
                                        if (b5 != null) {
                                            b5.b((Action.Builder) this.j);
                                            this.j = b5.T();
                                        }
                                    } else if (x != 50) {
                                        if (!codedInputStream.f(x)) {
                                        }
                                    } else {
                                        this.k = codedInputStream.w();
                                    }
                                }
                                z = true;
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
                    if (f17500e == null) {
                        synchronized (ModalMessage.class) {
                            if (f17500e == null) {
                                f17500e = new GeneratedMessageLite.DefaultInstanceBasedParser(f17499d);
                            }
                        }
                    }
                    return f17500e;
                default:
                    throw new UnsupportedOperationException();
            }
            return f17499d;
        }
    }
}
