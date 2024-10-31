package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.ads.impl.R;
import java.util.Map;

@zzark
/* loaded from: classes2.dex */
public final class zzanx extends zzaok {
    private final Context mContext;
    private final Map<String, String> zzczl;
    private String zzdoz;
    private long zzdpa;
    private long zzdpb;
    private String zzdpc;
    private String zzdpd;

    public zzanx(zzbgg zzbggVar, Map<String, String> map) {
        super(zzbggVar, "createCalendarEvent");
        this.zzczl = map;
        this.mContext = zzbggVar.zzabw();
        this.zzdoz = zzcy("description");
        this.zzdpc = zzcy("summary");
        this.zzdpa = zzcz("start_ticks");
        this.zzdpb = zzcz("end_ticks");
        this.zzdpd = zzcy(PlaceFields.LOCATION);
    }

    private final String zzcy(String str) {
        return TextUtils.isEmpty(this.zzczl.get(str)) ? "" : this.zzczl.get(str);
    }

    private final long zzcz(String str) {
        String str2 = this.zzczl.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    @TargetApi(14)
    public final Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzdoz);
        data.putExtra("eventLocation", this.zzdpd);
        data.putExtra("description", this.zzdpc);
        long j = this.zzdpa;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zzdpb;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void execute() {
        if (this.mContext == null) {
            zzda("Activity context is not available.");
            return;
        }
        com.google.android.gms.ads.internal.zzbv.e();
        if (!zzayh.zzam(this.mContext).zzqu()) {
            zzda("This feature is not available on the device.");
            return;
        }
        com.google.android.gms.ads.internal.zzbv.e();
        AlertDialog.Builder zzal = zzayh.zzal(this.mContext);
        Resources resources = com.google.android.gms.ads.internal.zzbv.i().getResources();
        zzal.setTitle(resources != null ? resources.getString(R.string.s5) : "Create calendar event");
        zzal.setMessage(resources != null ? resources.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        zzal.setPositiveButton(resources != null ? resources.getString(R.string.s3) : io.fabric.sdk.android.services.common.a.HEADER_ACCEPT, new Ib(this));
        zzal.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new Jb(this));
        zzal.create().show();
    }
}
