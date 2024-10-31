package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.util.Date;

/* loaded from: classes.dex */
public class ExpiredActivity extends AppCompatActivity {

    /* renamed from: a, reason: collision with root package name */
    private static final Date f24032a = EditorGlobal.r();

    /* renamed from: b, reason: collision with root package name */
    private Activity f24033b;

    public static boolean a(Activity activity) {
        Date date;
        Date date2 = new Date();
        if (EditorGlobal.u && EditorGlobal.f24026e == EditorGlobal.VersionType.Beta && (date = f24032a) != null) {
            if (date2.after(date)) {
                e.a aVar = new e.a(activity);
                aVar.c(R.string.km3xbeta_expired_message);
                aVar.c(R.string.beta_quit, new D(activity));
                aVar.b(R.string.beta_go_to_google_play, new C(activity));
                aVar.a(false);
                aVar.a().show();
            }
            return false;
        }
        Date date3 = f24032a;
        if (date3 == null || !date2.after(date3)) {
            return false;
        }
        activity.startActivityForResult(new Intent(activity, (Class<?>) ExpiredActivity.class), 0);
        activity.finish();
        return true;
    }

    public static Task b(Activity activity) {
        if (EditorGlobal.u && EditorGlobal.f24026e == EditorGlobal.VersionType.Beta && f24032a != null) {
            Date date = new Date();
            if (!date.after(f24032a)) {
                int max = (int) Math.max((f24032a.getTime() - date.getTime()) / 86400000, 1L);
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
                int i = defaultSharedPreferences.getInt("beta_days_remaining_last_shown", -1);
                int i2 = defaultSharedPreferences.getInt("beta_days_remaining_last_shown_ver", -1);
                int i3 = max < 5 ? 1 : max < 10 ? 2 : 3;
                if (i > 0 && Math.abs(i - max) < i3 && 14242 == i2) {
                    return Task.COMPLETED_TASK;
                }
                e.a aVar = new e.a(activity);
                if (i2 != 14242) {
                    aVar.g(R.layout.km30beta_firsttime);
                } else {
                    aVar.c(R.string.km3xbeta_reenter_message);
                    aVar.a(R.string.beta_support, new DialogInterfaceOnClickListenerC2345z(activity));
                }
                String quantityString = activity.getResources().getQuantityString(R.plurals.beta_remaining, max, Integer.valueOf(max));
                Task task = new Task();
                aVar.d(quantityString);
                aVar.c(R.string.beta_ok, new B(defaultSharedPreferences, max, task));
                aVar.b(R.string.km3xbeta_opt_in_out, new A(activity));
                aVar.a(false);
                com.nexstreaming.kinemaster.ui.a.e a2 = aVar.a();
                a2.show();
                TextView textView = (TextView) a2.findViewById(R.id.beta_expiration);
                if (textView != null) {
                    textView.setText(quantityString);
                }
                return task;
            }
            throw new IllegalStateException();
        }
        return Task.COMPLETED_TASK;
    }

    public static Date s() {
        return f24032a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        this.f24033b = this;
        TextView textView = new TextView(this);
        textView.setGravity(17);
        textView.setTextSize(20.0f);
        textView.setText(getResources().getText(R.string.demo_expired));
        setContentView(textView);
    }
}
