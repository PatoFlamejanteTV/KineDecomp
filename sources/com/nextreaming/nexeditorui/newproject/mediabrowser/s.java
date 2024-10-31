package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import com.google.android.gms.common.AccountPicker;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import java.util.Stack;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class s implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserFragment f4741a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MediaBrowserFragment mediaBrowserFragment) {
        this.f4741a = mediaBrowserFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Stack stack;
        MediaStoreItem mediaStoreItem;
        MediaStoreItem mediaStoreItem2;
        MediaStoreItem mediaStoreItem3 = (MediaStoreItem) view.getTag();
        switch (mediaStoreItem3.b()) {
            case IMAGE:
            case VIDEO:
                if (mediaStoreItem3.o().equals("Backgrounds") || mediaStoreItem3.i() > 0) {
                    this.f4741a.d(mediaStoreItem3);
                    return;
                } else {
                    this.f4741a.a(R.string.engine_error_filereader_fail_size_zero, R.string.mediabrowser_ok);
                    return;
                }
            case FOLDER:
                String namespace = mediaStoreItem3.c().getNamespace();
                NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
                if (namespace.equals("CloudFolder") && !deviceProfile.getUseMediaExtractor()) {
                    KMAppUsage.a(this.f4741a.getActivity()).a(KMAppUsage.KMMetric.CloudFolderTap);
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f4741a.getActivity());
                    Long valueOf = Long.valueOf(defaultSharedPreferences.getLong("notice_time_no_media_extractor", 0L));
                    Long valueOf2 = Long.valueOf(System.currentTimeMillis());
                    if (valueOf2.longValue() - valueOf.longValue() > 86400000) {
                        this.f4741a.a(R.string.cannot_check_before_download, R.string.mediabrowser_ok);
                        defaultSharedPreferences.edit().putLong("notice_time_no_media_extractor", valueOf2.longValue());
                    }
                }
                this.f4741a.n = mediaStoreItem3;
                stack = this.f4741a.r;
                mediaStoreItem = this.f4741a.n;
                stack.push(mediaStoreItem);
                KMUsage kMUsage = KMUsage.MediaBrowser_EnterFolder;
                mediaStoreItem2 = this.f4741a.n;
                kMUsage.logEvent("folderType", mediaStoreItem2.c().getGenericNamespace());
                this.f4741a.c();
                return;
            case SPECIAL:
                if (mediaStoreItem3.c().equals(com.nextreaming.nexeditorui.aw.c)) {
                    this.f4741a.startActivityForResult(AccountPicker.a(null, null, new String[]{"com.google"}, false, this.f4741a.getResources().getString(R.string.cloud_add_gdrive), null, null, null), R.id.choose_google_drive_account);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
