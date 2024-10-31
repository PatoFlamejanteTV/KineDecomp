package com.facebook.login.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.login.DeviceLoginManager;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;

/* loaded from: classes.dex */
public class DeviceLoginButton extends LoginButton {
    private Uri deviceRedirectUri;

    /* loaded from: classes.dex */
    private class a extends LoginButton.LoginClickListener {
        private a() {
            super();
        }

        @Override // com.facebook.login.widget.LoginButton.LoginClickListener
        protected LoginManager getLoginManager() {
            DeviceLoginManager deviceLoginManager = DeviceLoginManager.getInstance();
            deviceLoginManager.setDefaultAudience(DeviceLoginButton.this.getDefaultAudience());
            deviceLoginManager.setLoginBehavior(LoginBehavior.DEVICE_AUTH);
            deviceLoginManager.setDeviceRedirectUri(DeviceLoginButton.this.getDeviceRedirectUri());
            return deviceLoginManager;
        }
    }

    public DeviceLoginButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public Uri getDeviceRedirectUri() {
        return this.deviceRedirectUri;
    }

    @Override // com.facebook.login.widget.LoginButton
    protected LoginButton.LoginClickListener getNewLoginClickListener() {
        return new a();
    }

    public void setDeviceRedirectUri(Uri uri) {
        this.deviceRedirectUri = uri;
    }

    public DeviceLoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DeviceLoginButton(Context context) {
        super(context);
    }
}
