package com.firebase.ui.auth.ui;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.firebase.ui.auth.util.AuthHelper;

/* loaded from: classes.dex */
public class FragmentBase extends Fragment {
    private AuthHelper mAuthHelper;
    private FlowParameters mFlowParameters;
    private ProgressDialogHolder mProgressDialogHolder;

    public void finish(int i, Intent intent) {
        getActivity().setResult(i, intent);
        getActivity().finish();
    }

    public AuthHelper getAuthHelper() {
        return this.mAuthHelper;
    }

    public ProgressDialogHolder getDialogHolder() {
        return this.mProgressDialogHolder;
    }

    public FlowParameters getFlowParams() {
        if (this.mFlowParameters == null) {
            this.mFlowParameters = FlowParameters.fromBundle(getArguments());
        }
        return this.mFlowParameters;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideSoftInput() {
        View currentFocus;
        if (getActivity() == null || (currentFocus = getActivity().getCurrentFocus()) == null) {
            return;
        }
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAuthHelper = new AuthHelper(getFlowParams());
        this.mProgressDialogHolder = new ProgressDialogHolder(new ContextThemeWrapper(getContext(), getFlowParams().themeId));
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mProgressDialogHolder.dismissDialog();
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i) throws IntentSender.SendIntentException {
        startIntentSenderForResult(intentSender, i, null, 0, 0, 0, null);
    }
}
