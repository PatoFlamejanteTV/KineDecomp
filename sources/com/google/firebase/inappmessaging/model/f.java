package com.google.firebase.inappmessaging.model;

import com.google.firebase.inappmessaging.model.InAppMessage;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
final class f extends InAppMessage.Button {

    /* renamed from: a */
    private final InAppMessage.Text f18034a;

    /* renamed from: b */
    private final String f18035b;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class a extends InAppMessage.Button.Builder {

        /* renamed from: a */
        private InAppMessage.Text f18036a;

        /* renamed from: b */
        private String f18037b;

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Button.Builder
        public InAppMessage.Button.Builder a(@Nullable InAppMessage.Text text) {
            this.f18036a = text;
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Button.Builder
        public InAppMessage.Button.Builder a(@Nullable String str) {
            this.f18037b = str;
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Button.Builder
        public InAppMessage.Button a() {
            return new f(this.f18036a, this.f18037b);
        }
    }

    /* synthetic */ f(InAppMessage.Text text, String str, e eVar) {
        this(text, str);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InAppMessage.Button)) {
            return false;
        }
        InAppMessage.Button button = (InAppMessage.Button) obj;
        InAppMessage.Text text = this.f18034a;
        if (text != null ? text.equals(button.getText()) : button.getText() == null) {
            String str = this.f18035b;
            if (str == null) {
                if (button.getButtonHexColor() == null) {
                    return true;
                }
            } else if (str.equals(button.getButtonHexColor())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage.Button
    @Nullable
    public String getButtonHexColor() {
        return this.f18035b;
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage.Button
    @Nullable
    public InAppMessage.Text getText() {
        return this.f18034a;
    }

    public int hashCode() {
        InAppMessage.Text text = this.f18034a;
        int hashCode = ((text == null ? 0 : text.hashCode()) ^ 1000003) * 1000003;
        String str = this.f18035b;
        return hashCode ^ (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "Button{text=" + this.f18034a + ", buttonHexColor=" + this.f18035b + "}";
    }

    private f(@Nullable InAppMessage.Text text, @Nullable String str) {
        this.f18034a = text;
        this.f18035b = str;
    }
}
