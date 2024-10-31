package com.nexstreaming.kinemaster.util.update;

import android.content.Context;
import android.preference.PreferenceManager;
import android.support.v4.media.session.PlaybackStateCompat;
import com.nexstreaming.app.general.task.ResultTask;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes2.dex */
public class AssetUpdateChecker {

    /* renamed from: a, reason: collision with root package name */
    private static AssetUpdateChecker f23944a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f23945b;

    /* renamed from: c, reason: collision with root package name */
    private final com.nexstreaming.app.general.nexasset.assetpackage.h f23946c;

    /* renamed from: e, reason: collision with root package name */
    private ResultTask f23948e;

    /* renamed from: g, reason: collision with root package name */
    private long f23950g;

    /* renamed from: h, reason: collision with root package name */
    private long f23951h;

    /* renamed from: d, reason: collision with root package name */
    private final List<com.nexstreaming.app.general.nexasset.assetpackage.b> f23947d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private State f23949f = State.NONE;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum State {
        NONE,
        PENDING,
        PROGRESS,
        DONE
    }

    private AssetUpdateChecker(Context context) {
        this.f23945b = context.getApplicationContext();
        this.f23946c = com.nexstreaming.app.general.nexasset.assetpackage.h.a(this.f23945b);
        this.f23950g = PreferenceManager.getDefaultSharedPreferences(this.f23945b).getLong("com.nexstreaming.app.kinemasterfree.LAST_ASSET_UPDATE_CHECK", 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f23950g = System.currentTimeMillis();
        PreferenceManager.getDefaultSharedPreferences(this.f23945b).edit().putLong("com.nexstreaming.app.kinemasterfree.LAST_ASSET_UPDATE_CHECK", this.f23950g).apply();
    }

    private boolean e() {
        return PreferenceManager.getDefaultSharedPreferences(this.f23945b).getBoolean("asset_update_check_always", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        if (this.f23950g > 0 && !e()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(1);
            int i2 = calendar.get(2);
            int i3 = calendar.get(5);
            calendar.setTimeInMillis(this.f23950g);
            if (i <= calendar.get(1) && i2 <= calendar.get(2) && i3 <= calendar.get(5)) {
                return false;
            }
        }
        return true;
    }

    public ResultTask<List<com.nexstreaming.app.general.nexasset.assetpackage.b>> b() {
        this.f23948e = new ResultTask();
        if ((this.f23949f == State.PENDING) | (this.f23949f == State.PROGRESS)) {
            return this.f23948e;
        }
        if (this.f23949f == State.DONE) {
            this.f23948e.sendResult(this.f23947d);
            return this.f23948e;
        }
        new q(this).start();
        a(State.PENDING);
        return this.f23948e;
    }

    public long c() {
        return this.f23951h;
    }

    public String d() {
        return a(c());
    }

    public static AssetUpdateChecker a(Context context) {
        if (f23944a == null) {
            f23944a = new AssetUpdateChecker(context);
        }
        return f23944a;
    }

    public void a() {
        this.f23947d.clear();
        this.f23949f = State.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state) {
        if (this.f23949f != state) {
            this.f23949f = state;
        }
    }

    private static String a(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###,###");
        if (j > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return decimalFormat.format(((float) j) / 1048576.0f) + "MB";
        }
        return decimalFormat.format(((float) j) / 1024.0f) + "KB";
    }
}
