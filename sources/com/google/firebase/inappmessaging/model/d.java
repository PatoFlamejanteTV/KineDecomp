package com.google.firebase.inappmessaging.model;

import com.google.firebase.inappmessaging.model.InAppMessage;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
final class d extends InAppMessage.Action {

    /* renamed from: a */
    private final String f18032a;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class a extends InAppMessage.Action.Builder {

        /* renamed from: a */
        private String f18033a;

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Action.Builder
        public InAppMessage.Action.Builder a(@Nullable String str) {
            this.f18033a = str;
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.InAppMessage.Action.Builder
        public InAppMessage.Action a() {
            return new d(this.f18033a);
        }
    }

    /* synthetic */ d(String str, c cVar) {
        this(str);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InAppMessage.Action)) {
            return false;
        }
        InAppMessage.Action action = (InAppMessage.Action) obj;
        String str = this.f18032a;
        return str == null ? action.getActionUrl() == null : str.equals(action.getActionUrl());
    }

    @Override // com.google.firebase.inappmessaging.model.InAppMessage.Action
    @Nullable
    public String getActionUrl() {
        return this.f18032a;
    }

    public int hashCode() {
        String str = this.f18032a;
        return (str == null ? 0 : str.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "Action{actionUrl=" + this.f18032a + "}";
    }

    private d(@Nullable String str) {
        this.f18032a = str;
    }
}
