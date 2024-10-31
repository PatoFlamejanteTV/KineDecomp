package com.facebook.login.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.R;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.LoginAuthorizationType;
import com.facebook.internal.Utility;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.ToolTipPopup;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class LoginButton extends FacebookButtonBase {
    private static final String TAG = LoginButton.class.getName();
    private AccessTokenTracker accessTokenTracker;
    private boolean confirmLogout;
    private String loginLogoutEventName;
    private LoginManager loginManager;
    private String loginText;
    private String logoutText;
    private a properties;
    private boolean toolTipChecked;
    private long toolTipDisplayTime;
    private ToolTipMode toolTipMode;
    private ToolTipPopup toolTipPopup;
    private ToolTipPopup.Style toolTipStyle;

    /* loaded from: classes.dex */
    public enum ToolTipMode {
        AUTOMATIC(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, 0),
        DISPLAY_ALWAYS("display_always", 1),
        NEVER_DISPLAY("never_display", 2);

        public static ToolTipMode DEFAULT = AUTOMATIC;
        private int intValue;
        private String stringValue;

        public static ToolTipMode fromInt(int i) {
            for (ToolTipMode toolTipMode : values()) {
                if (toolTipMode.getValue() == i) {
                    return toolTipMode;
                }
            }
            return null;
        }

        ToolTipMode(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.stringValue;
        }

        public int getValue() {
            return this.intValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private DefaultAudience f319a = DefaultAudience.FRIENDS;
        private List<String> b = Collections.emptyList();
        private LoginAuthorizationType c = null;
        private LoginBehavior d = LoginBehavior.NATIVE_WITH_FALLBACK;

        a() {
        }

        public void a(DefaultAudience defaultAudience) {
            this.f319a = defaultAudience;
        }

        public DefaultAudience a() {
            return this.f319a;
        }

        public void a(List<String> list) {
            if (LoginAuthorizationType.PUBLISH.equals(this.c)) {
                throw new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
            }
            this.b = list;
            this.c = LoginAuthorizationType.READ;
        }

        public void b(List<String> list) {
            if (LoginAuthorizationType.READ.equals(this.c)) {
                throw new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
            }
            if (Utility.isNullOrEmpty(list)) {
                throw new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
            }
            this.b = list;
            this.c = LoginAuthorizationType.PUBLISH;
        }

        List<String> b() {
            return this.b;
        }

        public void c() {
            this.b = null;
            this.c = null;
        }

        public void a(LoginBehavior loginBehavior) {
            this.d = loginBehavior;
        }

        public LoginBehavior d() {
            return this.d;
        }
    }

    public LoginButton(Context context) {
        super(context, null, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
        this.properties = new a();
        this.loginLogoutEventName = AnalyticsEvents.EVENT_LOGIN_VIEW_USAGE;
        this.toolTipStyle = ToolTipPopup.Style.BLUE;
        this.toolTipDisplayTime = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
    }

    public LoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
        this.properties = new a();
        this.loginLogoutEventName = AnalyticsEvents.EVENT_LOGIN_VIEW_USAGE;
        this.toolTipStyle = ToolTipPopup.Style.BLUE;
        this.toolTipDisplayTime = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
    }

    public LoginButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
        this.properties = new a();
        this.loginLogoutEventName = AnalyticsEvents.EVENT_LOGIN_VIEW_USAGE;
        this.toolTipStyle = ToolTipPopup.Style.BLUE;
        this.toolTipDisplayTime = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
    }

    public void setDefaultAudience(DefaultAudience defaultAudience) {
        this.properties.a(defaultAudience);
    }

    public DefaultAudience getDefaultAudience() {
        return this.properties.a();
    }

    public void setReadPermissions(List<String> list) {
        this.properties.a(list);
    }

    public void setReadPermissions(String... strArr) {
        this.properties.a(Arrays.asList(strArr));
    }

    public void setPublishPermissions(List<String> list) {
        this.properties.b(list);
    }

    public void setPublishPermissions(String... strArr) {
        this.properties.b(Arrays.asList(strArr));
    }

    public void clearPermissions() {
        this.properties.c();
    }

    public void setLoginBehavior(LoginBehavior loginBehavior) {
        this.properties.a(loginBehavior);
    }

    public LoginBehavior getLoginBehavior() {
        return this.properties.d();
    }

    public void setToolTipStyle(ToolTipPopup.Style style) {
        this.toolTipStyle = style;
    }

    public void setToolTipMode(ToolTipMode toolTipMode) {
        this.toolTipMode = toolTipMode;
    }

    public ToolTipMode getToolTipMode() {
        return this.toolTipMode;
    }

    public void setToolTipDisplayTime(long j) {
        this.toolTipDisplayTime = j;
    }

    public long getToolTipDisplayTime() {
        return this.toolTipDisplayTime;
    }

    public void dismissToolTip() {
        if (this.toolTipPopup != null) {
            this.toolTipPopup.dismiss();
            this.toolTipPopup = null;
        }
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<LoginResult> facebookCallback) {
        getLoginManager().registerCallback(callbackManager, facebookCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.FacebookButtonBase, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.accessTokenTracker != null && !this.accessTokenTracker.isTracking()) {
            this.accessTokenTracker.startTracking();
            setButtonText();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.FacebookButtonBase, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.toolTipChecked && !isInEditMode()) {
            this.toolTipChecked = true;
            checkToolTipSettings();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToolTipPerSettings(Utility.FetchedAppSettings fetchedAppSettings) {
        if (fetchedAppSettings != null && fetchedAppSettings.getNuxEnabled() && getVisibility() == 0) {
            displayToolTip(fetchedAppSettings.getNuxContent());
        }
    }

    private void displayToolTip(String str) {
        this.toolTipPopup = new ToolTipPopup(str, this);
        this.toolTipPopup.setStyle(this.toolTipStyle);
        this.toolTipPopup.setNuxDisplayTime(this.toolTipDisplayTime);
        this.toolTipPopup.show();
    }

    private void checkToolTipSettings() {
        switch (this.toolTipMode) {
            case AUTOMATIC:
                FacebookSdk.getExecutor().execute(new com.facebook.login.widget.a(this, Utility.getMetadataApplicationId(getContext())));
                return;
            case DISPLAY_ALWAYS:
                displayToolTip(getResources().getString(R.string.com_facebook_tooltip_default));
                return;
            default:
                return;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setButtonText();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.accessTokenTracker != null) {
            this.accessTokenTracker.stopTracking();
        }
        dismissToolTip();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            dismissToolTip();
        }
    }

    List<String> getPermissions() {
        return this.properties.b();
    }

    void setProperties(a aVar) {
        this.properties = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.FacebookButtonBase
    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super.configureButton(context, attributeSet, i, i2);
        setInternalOnClickListener(new b(this, null));
        parseLoginButtonAttributes(context, attributeSet, i, i2);
        if (isInEditMode()) {
            setBackgroundColor(getResources().getColor(R.color.com_facebook_blue));
            this.loginText = "Log in with Facebook";
        } else {
            this.accessTokenTracker = new c(this);
        }
        setButtonText();
    }

    @Override // com.facebook.FacebookButtonBase
    protected int getDefaultStyleResource() {
        return R.style.com_facebook_loginview_default_style;
    }

    private void parseLoginButtonAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        this.toolTipMode = ToolTipMode.DEFAULT;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.com_facebook_login_view, i, i2);
        try {
            this.confirmLogout = obtainStyledAttributes.getBoolean(R.styleable.com_facebook_login_view_com_facebook_confirm_logout, true);
            this.loginText = obtainStyledAttributes.getString(R.styleable.com_facebook_login_view_com_facebook_login_text);
            this.logoutText = obtainStyledAttributes.getString(R.styleable.com_facebook_login_view_com_facebook_logout_text);
            this.toolTipMode = ToolTipMode.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_login_view_com_facebook_tooltip_mode, ToolTipMode.DEFAULT.getValue()));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        int compoundPaddingBottom = getCompoundPaddingBottom() + ((int) Math.ceil(Math.abs(fontMetrics.bottom) + Math.abs(fontMetrics.top))) + getCompoundPaddingTop();
        Resources resources = getResources();
        String str = this.loginText;
        if (str == null) {
            str = resources.getString(R.string.com_facebook_loginview_log_in_button_long);
            int measureButtonWidth = measureButtonWidth(str);
            if (resolveSize(measureButtonWidth, i) < measureButtonWidth) {
                str = resources.getString(R.string.com_facebook_loginview_log_in_button);
            }
        }
        int measureButtonWidth2 = measureButtonWidth(str);
        String str2 = this.logoutText;
        if (str2 == null) {
            str2 = resources.getString(R.string.com_facebook_loginview_log_out_button);
        }
        setMeasuredDimension(resolveSize(Math.max(measureButtonWidth2, measureButtonWidth(str2)), i), compoundPaddingBottom);
    }

    private int measureButtonWidth(String str) {
        return measureTextWidth(str) + getCompoundPaddingLeft() + getCompoundDrawablePadding() + getCompoundPaddingRight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setButtonText() {
        Resources resources = getResources();
        if (!isInEditMode() && AccessToken.getCurrentAccessToken() != null) {
            setText(this.logoutText != null ? this.logoutText : resources.getString(R.string.com_facebook_loginview_log_out_button));
            return;
        }
        if (this.loginText != null) {
            setText(this.loginText);
            return;
        }
        String string = resources.getString(R.string.com_facebook_loginview_log_in_button_long);
        int width = getWidth();
        if (width != 0 && measureButtonWidth(string) > width) {
            string = resources.getString(R.string.com_facebook_loginview_log_in_button);
        }
        setText(string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.FacebookButtonBase
    public int getDefaultRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private b() {
        }

        /* synthetic */ b(LoginButton loginButton, com.facebook.login.widget.a aVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string;
            LoginButton.this.callExternalOnClickListener(view);
            Context context = LoginButton.this.getContext();
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (currentAccessToken != null) {
                if (LoginButton.this.confirmLogout) {
                    String string2 = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_log_out_action);
                    String string3 = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_cancel_action);
                    Profile currentProfile = Profile.getCurrentProfile();
                    if (currentProfile != null && currentProfile.getName() != null) {
                        string = String.format(LoginButton.this.getResources().getString(R.string.com_facebook_loginview_logged_in_as), currentProfile.getName());
                    } else {
                        string = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_logged_in_using_facebook);
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage(string).setCancelable(true).setPositiveButton(string2, new e(this)).setNegativeButton(string3, (DialogInterface.OnClickListener) null);
                    builder.create().show();
                } else {
                    LoginButton.this.getLoginManager().logOut();
                }
            } else {
                LoginManager loginManager = LoginButton.this.getLoginManager();
                loginManager.setDefaultAudience(LoginButton.this.getDefaultAudience());
                loginManager.setLoginBehavior(LoginButton.this.getLoginBehavior());
                if (LoginAuthorizationType.PUBLISH.equals(LoginButton.this.properties.c)) {
                    if (LoginButton.this.getFragment() != null) {
                        loginManager.logInWithPublishPermissions(LoginButton.this.getFragment(), LoginButton.this.properties.b);
                    } else {
                        loginManager.logInWithPublishPermissions(LoginButton.this.getActivity(), LoginButton.this.properties.b);
                    }
                } else if (LoginButton.this.getFragment() != null) {
                    loginManager.logInWithReadPermissions(LoginButton.this.getFragment(), LoginButton.this.properties.b);
                } else {
                    loginManager.logInWithReadPermissions(LoginButton.this.getActivity(), LoginButton.this.properties.b);
                }
            }
            AppEventsLogger newLogger = AppEventsLogger.newLogger(LoginButton.this.getContext());
            Bundle bundle = new Bundle();
            bundle.putInt("logging_in", currentAccessToken != null ? 0 : 1);
            newLogger.logSdkEvent(LoginButton.this.loginLogoutEventName, null, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoginManager getLoginManager() {
        if (this.loginManager == null) {
            this.loginManager = LoginManager.getInstance();
        }
        return this.loginManager;
    }

    void setLoginManager(LoginManager loginManager) {
        this.loginManager = loginManager;
    }
}
