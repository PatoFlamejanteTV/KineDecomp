package com.crashlytics.android.answers;

/* loaded from: classes.dex */
public class LoginEvent extends PredefinedEvent<LoginEvent> {
    static final String METHOD_ATTRIBUTE = "method";
    static final String SUCCESS_ATTRIBUTE = "success";
    static final String TYPE = "login";

    @Override // com.crashlytics.android.answers.PredefinedEvent
    public String getPredefinedType() {
        return TYPE;
    }

    public LoginEvent putMethod(String str) {
        this.predefinedAttributes.put(METHOD_ATTRIBUTE, str);
        return this;
    }

    public LoginEvent putSuccess(boolean z) {
        this.predefinedAttributes.put("success", Boolean.toString(z));
        return this;
    }
}
