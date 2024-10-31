package com.firebase.ui.auth.provider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public interface Provider {
    int getButtonLayout();

    String getName(Context context);

    void onActivityResult(int i, int i2, Intent intent);

    void startLogin(Activity activity);
}
