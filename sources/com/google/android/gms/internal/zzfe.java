package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.R;
import java.util.Map;

@zzgr
/* loaded from: classes.dex */
public class zzfe extends zzfh {
    private final Context mContext;
    private final Map<String, String> zzvS;

    public zzfe(zziz zzizVar, Map<String, String> map) {
        super(zzizVar, "storePicture");
        this.zzvS = map;
        this.mContext = zzizVar.zzgZ();
    }

    public void execute() {
        if (this.mContext == null) {
            zzak("Activity context is not available");
            return;
        }
        if (!com.google.android.gms.ads.internal.zzp.e().zzL(this.mContext).zzcY()) {
            zzak("Feature is not supported by the device.");
            return;
        }
        String str = this.zzvS.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzak("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            zzak("Invalid image url: " + str);
            return;
        }
        String zzaj = zzaj(str);
        if (!com.google.android.gms.ads.internal.zzp.e().zzaB(zzaj)) {
            zzak("Image type not recognized: " + zzaj);
            return;
        }
        AlertDialog.Builder zzK = com.google.android.gms.ads.internal.zzp.e().zzK(this.mContext);
        zzK.setTitle(com.google.android.gms.ads.internal.zzp.h().zzd(R.string.store_picture_title, "Save image"));
        zzK.setMessage(com.google.android.gms.ads.internal.zzp.h().zzd(R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
        zzK.setPositiveButton(com.google.android.gms.ads.internal.zzp.h().zzd(R.string.accept, "Accept"), new ch(this, str, zzaj));
        zzK.setNegativeButton(com.google.android.gms.ads.internal.zzp.h().zzd(R.string.decline, "Decline"), new ci(this));
        zzK.create().show();
    }

    String zzaj(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DownloadManager.Request zzg(String str, String str2) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        com.google.android.gms.ads.internal.zzp.g().zza(request);
        return request;
    }
}
