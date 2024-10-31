package com.firebase.ui.auth.ui.email;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import b.b.c.j;
import com.firebase.ui.auth.ui.FlowParameters;
import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes.dex */
public class PreambleHandler {
    private static final String BTN_TARGET = "%BTN%";
    private static final String PP_TARGET = "%PP%";
    private static final String TOS_TARGET = "%TOS%";
    private SpannableStringBuilder mBuilder;
    private final int mButtonText;
    private final Context mContext;
    private final FlowParameters mFlowParameters;
    private final ForegroundColorSpan mLinkSpan;

    /* loaded from: classes.dex */
    public class CustomTabsSpan extends ClickableSpan {
        private final j mCustomTabsIntent;
        private final String mUrl;

        public CustomTabsSpan(String str) {
            this.mUrl = str;
            TypedValue typedValue = new TypedValue();
            PreambleHandler.this.mContext.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
            int i = typedValue.data;
            j.a aVar = new j.a();
            aVar.a(i);
            aVar.a(true);
            this.mCustomTabsIntent = aVar.a();
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.mCustomTabsIntent.a(PreambleHandler.this.mContext, Uri.parse(this.mUrl));
        }
    }

    public PreambleHandler(Context context, FlowParameters flowParameters, int i) {
        this.mContext = context;
        this.mFlowParameters = flowParameters;
        this.mButtonText = i;
        this.mLinkSpan = new ForegroundColorSpan(ContextCompat.getColor(this.mContext, R.color.linkColor));
        setupCreateAccountPreamble();
    }

    private String getPreambleStringWithTargets() {
        boolean z = !TextUtils.isEmpty(this.mFlowParameters.termsOfServiceUrl);
        boolean z2 = !TextUtils.isEmpty(this.mFlowParameters.privacyPolicyUrl);
        if (z && z2) {
            return this.mContext.getString(R.string.fui_create_account_preamble_tos_and_pp, BTN_TARGET, TOS_TARGET, PP_TARGET);
        }
        if (z) {
            return this.mContext.getString(R.string.fui_create_account_preamble_tos_only, BTN_TARGET, TOS_TARGET);
        }
        if (z2) {
            return this.mContext.getString(R.string.fui_create_account_preamble_pp_only, BTN_TARGET, PP_TARGET);
        }
        return null;
    }

    private void replaceTarget(String str, int i) {
        int indexOf = this.mBuilder.toString().indexOf(str);
        if (indexOf != -1) {
            this.mBuilder.replace(indexOf, str.length() + indexOf, (CharSequence) this.mContext.getString(i));
        }
    }

    private void replaceUrlTarget(String str, int i, String str2) {
        int indexOf = this.mBuilder.toString().indexOf(str);
        if (indexOf != -1) {
            String string = this.mContext.getString(i);
            this.mBuilder.replace(indexOf, str.length() + indexOf, (CharSequence) string);
            int length = string.length() + indexOf;
            this.mBuilder.setSpan(this.mLinkSpan, indexOf, length, 0);
            this.mBuilder.setSpan(new CustomTabsSpan(str2), indexOf, length, 0);
        }
    }

    private void setupCreateAccountPreamble() {
        String preambleStringWithTargets = getPreambleStringWithTargets();
        if (preambleStringWithTargets == null) {
            return;
        }
        this.mBuilder = new SpannableStringBuilder(preambleStringWithTargets);
        replaceTarget(BTN_TARGET, this.mButtonText);
        replaceUrlTarget(TOS_TARGET, R.string.about_kinemaster_terms_of_service, this.mFlowParameters.termsOfServiceUrl);
        replaceUrlTarget(PP_TARGET, R.string.about_kinemaster_privacy_info, this.mFlowParameters.privacyPolicyUrl);
    }

    public void setPreamble(TextView textView) {
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(this.mBuilder);
    }
}
