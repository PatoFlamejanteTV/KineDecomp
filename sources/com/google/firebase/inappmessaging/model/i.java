package com.google.firebase.inappmessaging.model;

import com.google.firebase.inappmessaging.model.InAppMessage;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
final class i extends InAppMessage.Text {

    /* renamed from: a */
    private final String f18038a;

    /* renamed from: b */
    private final String f18039b;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class a extends InAppMessage.Text.Builder {

        /* renamed from: a */
        private String f18040a;

        /* renamed from: b */
        private String f18041b;

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Text.Builder
        public InAppMessage.Text.Builder a(@Nullable String str) {
            this.f18041b = str;
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Text.Builder
        public InAppMessage.Text.Builder b(@Nullable String str) {
            this.f18040a = str;
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Text.Builder
        public InAppMessage.Text a() {
            return new i(this.f18040a, this.f18041b);
        }
    }

    /* synthetic */ i(String str, String str2, h hVar) {
        this(str, str2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InAppMessage.Text)) {
            return false;
        }
        InAppMessage.Text text = (InAppMessage.Text) obj;
        String str = this.f18038a;
        if (str != null ? str.equals(text.getText()) : text.getText() == null) {
            String str2 = this.f18039b;
            if (str2 == null) {
                if (text.getHexColor() == null) {
                    return true;
                }
            } else if (str2.equals(text.getHexColor())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage.Text
    @Nullable
    public String getHexColor() {
        return this.f18039b;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage.Text
    @Nullable
    public String getText() {
        return this.f18038a;
    }

    public int hashCode() {
        String str = this.f18038a;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f18039b;
        return hashCode ^ (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Text{text=" + this.f18038a + ", hexColor=" + this.f18039b + "}";
    }

    private i(@Nullable String str, @Nullable String str2) {
        this.f18038a = str;
        this.f18039b = str2;
    }
}
