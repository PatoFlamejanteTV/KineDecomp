package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import java.util.Map;

@zzark
/* loaded from: classes2.dex */
public final class zzaod extends zzaok {
    private final Context mContext;
    private final Map<String, String> zzczl;

    public zzaod(zzbgg zzbggVar, Map<String, String> map) {
        super(zzbggVar, "storePicture");
        this.zzczl = map;
        this.mContext = zzbggVar.zzabw();
    }

    public final void execute() {
        if (this.mContext == null) {
            zzda("Activity context is not available");
            return;
        }
        com.google.android.gms.ads.internal.zzbv.e();
        if (!zzayh.zzam(this.mContext).zzqt()) {
            zzda("Feature is not supported by the device.");
            return;
        }
        String str = this.zzczl.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzda("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            String valueOf = String.valueOf(str);
            zzda(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        com.google.android.gms.ads.internal.zzbv.e();
        if (!zzayh.zzdz(lastPathSegment)) {
            String valueOf2 = String.valueOf(lastPathSegment);
            zzda(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
            return;
        }
        Resources resources = com.google.android.gms.ads.internal.zzbv.i().getResources();
        com.google.android.gms.ads.internal.zzbv.e();
        AlertDialog.Builder zzal = zzayh.zzal(this.mContext);
        zzal.setTitle(resources != null ? resources.getString(R.string.s1) : "Save image");
        zzal.setMessage(resources != null ? resources.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
        zzal.setPositiveButton(resources != null ? resources.getString(R.string.s3) : io.fabric.sdk.android.services.common.a.HEADER_ACCEPT, new Mb(this, str, lastPathSegment));
        zzal.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new Nb(this));
        zzal.create().show();
    }
}
