package com.google.android.gms.games.internal.notification;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public final class GameNotificationRef extends zzc implements GameNotification {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GameNotificationRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public long a() {
        return b("_id");
    }

    public String c() {
        return e("notification_id");
    }

    public int d() {
        return c("type");
    }

    public String e() {
        return e("ticker");
    }

    public String f() {
        return e(ShareConstants.WEB_DIALOG_PARAM_TITLE);
    }

    public String g() {
        return e("text");
    }

    public String h() {
        return e("coalesced_text");
    }

    public boolean i() {
        return c("acknowledged") > 0;
    }

    public boolean j() {
        return c("alert_level") == 0;
    }

    public String toString() {
        return zzw.a(this).a("Id", Long.valueOf(a())).a("NotificationId", c()).a("Type", Integer.valueOf(d())).a("Title", f()).a("Ticker", e()).a("Text", g()).a("CoalescedText", h()).a("isAcknowledged", Boolean.valueOf(i())).a("isSilent", Boolean.valueOf(j())).toString();
    }
}
