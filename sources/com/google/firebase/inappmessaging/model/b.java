package com.google.firebase.inappmessaging.model;

import com.google.firebase.inappmessaging.model.InAppMessage;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
final class b extends InAppMessage {

    /* renamed from: a */
    private final InAppMessage.Text f18016a;

    /* renamed from: b */
    private final InAppMessage.Text f18017b;

    /* renamed from: c */
    private final String f18018c;

    /* renamed from: d */
    private final InAppMessage.ImageData f18019d;

    /* renamed from: e */
    private final InAppMessage.Button f18020e;

    /* renamed from: f */
    private final InAppMessage.Action f18021f;

    /* renamed from: g */
    private final String f18022g;

    /* renamed from: h */
    private final String f18023h;
    private final String i;
    private final Boolean j;
    private final MessageType k;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class a extends InAppMessage.Builder {

        /* renamed from: a */
        private InAppMessage.Text f18024a;

        /* renamed from: b */
        private InAppMessage.Text f18025b;

        /* renamed from: c */
        private String f18026c;

        /* renamed from: d */
        private InAppMessage.ImageData f18027d;

        /* renamed from: e */
        private InAppMessage.Button f18028e;

        /* renamed from: f */
        private InAppMessage.Action f18029f;

        /* renamed from: g */
        private String f18030g;

        /* renamed from: h */
        private String f18031h;
        private String i;
        private Boolean j;
        private MessageType k;

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Builder
        public InAppMessage.Builder a(@Nullable InAppMessage.Text text) {
            this.f18025b = text;
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Builder
        public InAppMessage.Builder b(@Nullable InAppMessage.Text text) {
            this.f18024a = text;
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Builder
        public InAppMessage.Builder c(String str) {
            if (str != null) {
                this.i = str;
                return this;
            }
            throw new NullPointerException("Null campaignName");
        }

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Builder
        public InAppMessage.Builder d(@Nullable String str) {
            this.f18026c = str;
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Builder
        public InAppMessage.Builder a(@Nullable InAppMessage.Button button) {
            this.f18028e = button;
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Builder
        public InAppMessage.Builder b(String str) {
            if (str != null) {
                this.f18031h = str;
                return this;
            }
            throw new NullPointerException("Null campaignId");
        }

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Builder
        public InAppMessage.Builder a(@Nullable InAppMessage.Action action) {
            this.f18029f = action;
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Builder
        public InAppMessage.Builder a(@Nullable String str) {
            this.f18030g = str;
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Builder
        public InAppMessage.Builder a(Boolean bool) {
            if (bool != null) {
                this.j = bool;
                return this;
            }
            throw new NullPointerException("Null isTestMessage");
        }

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Builder
        public InAppMessage.Builder a(MessageType messageType) {
            if (messageType != null) {
                this.k = messageType;
                return this;
            }
            throw new NullPointerException("Null messageType");
        }

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Builder
        public InAppMessage a() {
            String str = "";
            if (this.f18031h == null) {
                str = " campaignId";
            }
            if (this.i == null) {
                str = str + " campaignName";
            }
            if (this.j == null) {
                str = str + " isTestMessage";
            }
            if (this.k == null) {
                str = str + " messageType";
            }
            if (str.isEmpty()) {
                return new b(this.f18024a, this.f18025b, this.f18026c, this.f18027d, this.f18028e, this.f18029f, this.f18030g, this.f18031h, this.i, this.j, this.k);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* synthetic */ b(InAppMessage.Text text, InAppMessage.Text text2, String str, InAppMessage.ImageData imageData, InAppMessage.Button button, InAppMessage.Action action, String str2, String str3, String str4, Boolean bool, MessageType messageType, com.google.firebase.inappmessaging.model.a aVar) {
        this(text, text2, str, imageData, button, action, str2, str3, str4, bool, messageType);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InAppMessage)) {
            return false;
        }
        InAppMessage inAppMessage = (InAppMessage) obj;
        InAppMessage.Text text = this.f18016a;
        if (text != null ? text.equals(inAppMessage.getTitle()) : inAppMessage.getTitle() == null) {
            InAppMessage.Text text2 = this.f18017b;
            if (text2 != null ? text2.equals(inAppMessage.getBody()) : inAppMessage.getBody() == null) {
                String str = this.f18018c;
                if (str != null ? str.equals(inAppMessage.getImageUrl()) : inAppMessage.getImageUrl() == null) {
                    InAppMessage.ImageData imageData = this.f18019d;
                    if (imageData != null ? imageData.equals(inAppMessage.getImageData()) : inAppMessage.getImageData() == null) {
                        InAppMessage.Button button = this.f18020e;
                        if (button != null ? button.equals(inAppMessage.getActionButton()) : inAppMessage.getActionButton() == null) {
                            InAppMessage.Action action = this.f18021f;
                            if (action != null ? action.equals(inAppMessage.getAction()) : inAppMessage.getAction() == null) {
                                String str2 = this.f18022g;
                                if (str2 != null ? str2.equals(inAppMessage.getBackgroundHexColor()) : inAppMessage.getBackgroundHexColor() == null) {
                                    if (this.f18023h.equals(inAppMessage.getCampaignId()) && this.i.equals(inAppMessage.getCampaignName()) && this.j.equals(inAppMessage.getIsTestMessage()) && this.k.equals(inAppMessage.getMessageType())) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Nullable
    public InAppMessage.Action getAction() {
        return this.f18021f;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Nullable
    public InAppMessage.Button getActionButton() {
        return this.f18020e;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Nullable
    public String getBackgroundHexColor() {
        return this.f18022g;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Nullable
    public InAppMessage.Text getBody() {
        return this.f18017b;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public String getCampaignId() {
        return this.f18023h;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public String getCampaignName() {
        return this.i;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Nullable
    public InAppMessage.ImageData getImageData() {
        return this.f18019d;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Nullable
    public String getImageUrl() {
        return this.f18018c;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public Boolean getIsTestMessage() {
        return this.j;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    public MessageType getMessageType() {
        return this.k;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage
    @Nullable
    public InAppMessage.Text getTitle() {
        return this.f18016a;
    }

    public int hashCode() {
        InAppMessage.Text text = this.f18016a;
        int hashCode = ((text == null ? 0 : text.hashCode()) ^ 1000003) * 1000003;
        InAppMessage.Text text2 = this.f18017b;
        int hashCode2 = (hashCode ^ (text2 == null ? 0 : text2.hashCode())) * 1000003;
        String str = this.f18018c;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        InAppMessage.ImageData imageData = this.f18019d;
        int hashCode4 = (hashCode3 ^ (imageData == null ? 0 : imageData.hashCode())) * 1000003;
        InAppMessage.Button button = this.f18020e;
        int hashCode5 = (hashCode4 ^ (button == null ? 0 : button.hashCode())) * 1000003;
        InAppMessage.Action action = this.f18021f;
        int hashCode6 = (hashCode5 ^ (action == null ? 0 : action.hashCode())) * 1000003;
        String str2 = this.f18022g;
        return ((((((((hashCode6 ^ (str2 != null ? str2.hashCode() : 0)) * 1000003) ^ this.f18023h.hashCode()) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.j.hashCode()) * 1000003) ^ this.k.hashCode();
    }

    public String toString() {
        return "InAppMessage{title=" + this.f18016a + ", body=" + this.f18017b + ", imageUrl=" + this.f18018c + ", imageData=" + this.f18019d + ", actionButton=" + this.f18020e + ", action=" + this.f18021f + ", backgroundHexColor=" + this.f18022g + ", campaignId=" + this.f18023h + ", campaignName=" + this.i + ", isTestMessage=" + this.j + ", messageType=" + this.k + "}";
    }

    private b(@Nullable InAppMessage.Text text, @Nullable InAppMessage.Text text2, @Nullable String str, @Nullable InAppMessage.ImageData imageData, @Nullable InAppMessage.Button button, @Nullable InAppMessage.Action action, @Nullable String str2, String str3, String str4, Boolean bool, MessageType messageType) {
        this.f18016a = text;
        this.f18017b = text2;
        this.f18018c = str;
        this.f18019d = imageData;
        this.f18020e = button;
        this.f18021f = action;
        this.f18022g = str2;
        this.f18023h = str3;
        this.i = str4;
        this.j = bool;
        this.k = messageType;
    }
}
