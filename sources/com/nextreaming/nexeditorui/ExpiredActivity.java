package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.util.Date;

/* loaded from: classes.dex */
public class ExpiredActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private static final Date f4475a = EditorGlobal.l();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TextView textView = new TextView(this);
        textView.setGravity(17);
        textView.setTextSize(20.0f);
        textView.setText(getResources().getText(R.string.demo_expired));
        setContentView(textView);
    }

    public static boolean a(Activity activity, boolean z) {
        int i;
        Date date = new Date();
        if (EditorGlobal.j && EditorGlobal.f == EditorGlobal.VersionType.Beta && f4475a != null) {
            if (date.after(f4475a)) {
                new a.C0074a(activity).a(R.string.km3xbeta_expired_message).a(R.string.beta_quit, new ab(activity)).c(R.string.beta_go_to_google_play, new aa(activity)).a(false).a().show();
            } else {
                if (!z) {
                    return false;
                }
                int max = (int) Math.max((f4475a.getTime() - date.getTime()) / 86400000, 1L);
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
                int i2 = defaultSharedPreferences.getInt("beta_days_remaining_last_shown", -1);
                int i3 = defaultSharedPreferences.getInt("beta_days_remaining_last_shown_ver", -1);
                if (max < 5) {
                    i = 1;
                } else if (max < 10) {
                    i = 2;
                } else {
                    i = 3;
                }
                if (i2 > 0 && Math.abs(i2 - max) < i && 8291 == i3) {
                    return false;
                }
                a.C0074a c0074a = new a.C0074a(activity);
                if (i3 != 8291) {
                    c0074a.b(R.layout.km30beta_firsttime);
                } else {
                    c0074a.a(R.string.km3xbeta_reenter_message);
                    c0074a.b(R.string.beta_support, new ac(activity));
                }
                String quantityString = activity.getResources().getQuantityString(R.plurals.beta_remaining, max, Integer.valueOf(max));
                c0074a.c(quantityString).a(R.string.beta_ok, new ae(defaultSharedPreferences, max)).c(R.string.km3xbeta_opt_in_out, new ad(activity)).a(false);
                com.nexstreaming.kinemaster.ui.a.a a2 = c0074a.a();
                a2.show();
                TextView textView = (TextView) a2.findViewById(R.id.beta_expiration);
                if (textView != null) {
                    textView.setText(quantityString);
                }
            }
            return false;
        }
        if (f4475a == null || !date.after(f4475a)) {
            return false;
        }
        activity.startActivityForResult(new Intent(activity, (Class<?>) ExpiredActivity.class), 0);
        activity.finish();
        return true;
    }

    public static Date a() {
        return f4475a;
    }
}
