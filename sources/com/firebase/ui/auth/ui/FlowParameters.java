package com.firebase.ui.auth.ui;

import android.content.Intent;
import android.os.Bundle;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.util.Preconditions;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class FlowParameters implements Serializable {
    public final boolean allowNewEmailAccounts;
    public final String appName;
    public final boolean enableCredentials;
    public final boolean enableHints;
    public final int logoId;
    public final String privacyPolicyUrl;
    public final List<AuthUI.IdpConfig> providerInfo;
    public final String termsOfServiceUrl;
    public final int themeId;
    public final String title;

    public FlowParameters(String str, List<AuthUI.IdpConfig> list, int i, int i2, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        Preconditions.checkNotNull(str, "appName cannot be null", new Object[0]);
        this.appName = str;
        Preconditions.checkNotNull(list, "providerInfo cannot be null", new Object[0]);
        this.providerInfo = Collections.unmodifiableList(list);
        this.themeId = i;
        this.logoId = i2;
        this.termsOfServiceUrl = str2;
        this.privacyPolicyUrl = str3;
        this.enableCredentials = z;
        this.enableHints = z2;
        this.allowNewEmailAccounts = z3;
        this.title = str4;
    }

    public static FlowParameters fromBundle(Bundle bundle) {
        return (FlowParameters) bundle.getSerializable(ExtraConstants.EXTRA_FLOW_PARAMS);
    }

    public static FlowParameters fromIntent(Intent intent) {
        return (FlowParameters) intent.getSerializableExtra(ExtraConstants.EXTRA_FLOW_PARAMS);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ExtraConstants.EXTRA_FLOW_PARAMS, this);
        return bundle;
    }
}
