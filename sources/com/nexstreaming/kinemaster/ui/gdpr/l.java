package com.nexstreaming.kinemaster.ui.gdpr;

import android.app.Activity;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.k;

/* compiled from: PrivacyPolicyAgreeUtil.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a */
    public static Object f21611a = new Object();

    /* renamed from: b */
    public static boolean f21612b = false;

    public static void a(Activity activity) {
        if (c.d.b.c.a.a() && !f21612b) {
            synchronized (f21611a) {
                c.d.b.b.a.e b2 = c.d.b.b.i.b().b();
                int b3 = c.d.b.b.i.c().b();
                if (b2 != null && b2.getPrivacyVersion() < b3) {
                    f21612b = true;
                    k.a a2 = com.nexstreaming.kinemaster.ui.a.k.a(activity);
                    a2.b(R.string.GDPR_account_update_popup_title);
                    a2.a(R.string.GDPR_account_update_popup_msg);
                    a2.a(R.string.GDPR_account_Privacy_policy_link, "https://support.kinemaster.com/hc/ko/articles/115000079081-Privacy-Policy-NexStreamingUSA-Inc-");
                    a2.a(new i(b2, b3, activity));
                    a2.a().show(activity.getFragmentManager(), "Privacy");
                }
            }
        }
    }

    public static void a(Activity activity, k.b bVar) {
        if (!c.d.b.c.a.a()) {
            bVar.onDialogOk(null, null);
            return;
        }
        if (f21612b) {
            return;
        }
        synchronized (f21611a) {
            f21612b = true;
            k.a a2 = com.nexstreaming.kinemaster.ui.a.k.a(activity);
            a2.b(R.string.GDPR_account_check_popup_title);
            a2.a(R.string.GDPR_account_check_popup_msg);
            a2.a(R.string.GDPR_account_Privacy_policy_link, "https://support.kinemaster.com/hc/ko/articles/115000079081-Privacy-Policy-NexStreamingUSA-Inc-");
            a2.a(new j(bVar));
            a2.a().show(activity.getFragmentManager(), "Privacy");
        }
    }
}
