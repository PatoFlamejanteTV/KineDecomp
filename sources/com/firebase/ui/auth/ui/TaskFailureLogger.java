package com.firebase.ui.auth.ui;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;

/* loaded from: classes.dex */
public class TaskFailureLogger implements OnFailureListener {
    private String mMessage;
    private String mTag;

    public TaskFailureLogger(String str, String str2) {
        this.mTag = str;
        this.mMessage = str2;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        Log.w(this.mTag, this.mMessage, exc);
    }
}
