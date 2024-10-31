package com.nexstreaming.kinemaster.mediastore.v2.providers;

import android.graphics.BitmapFactory;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediastore.v2.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.a;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: GoogleDriveMediaStoreProvider.java */
/* loaded from: classes.dex */
final class t implements a.InterfaceC0071a {
    @Override // com.nexstreaming.kinemaster.mediastore.v2.a.InterfaceC0071a
    public void a(com.nexstreaming.kinemaster.mediastore.v2.a aVar) {
        if (!aVar.n()) {
            if (aVar.b() == MediaItemType.VIDEO) {
                MediaInfo a2 = MediaInfo.a(aVar.h());
                aVar.a(a2.u(), a2.v());
                aVar.c(a2.r());
                aVar.e(a2.y());
                aVar.f(a2.B());
                MediaStoreItem.MediaSupportType n = a2.n();
                if (n != MediaStoreItem.MediaSupportType.Unknown && n != MediaStoreItem.MediaSupportType.Supported) {
                    aVar.a(n);
                    return;
                }
                if (EditorGlobal.a() != null) {
                    switch (EditorGlobal.a().d().a(a2.D(), a2.E(), a2.u(), a2.v(), a2.B(), a2.F(), a2.H(), a2.I())) {
                        case 0:
                            aVar.a(MediaStoreItem.MediaSupportType.Supported);
                            return;
                        case 1:
                            aVar.a(MediaStoreItem.MediaSupportType.NeedTranscodeRes);
                            return;
                        case 2:
                            aVar.a(MediaStoreItem.MediaSupportType.NeedTranscodeFPS);
                            return;
                        case 3:
                            aVar.a(MediaStoreItem.MediaSupportType.NotSupported_VideoProfile);
                            return;
                        case 4:
                            aVar.a(MediaStoreItem.MediaSupportType.NotSupported_ResolutionTooHigh);
                            return;
                        case 5:
                            aVar.a(MediaStoreItem.MediaSupportType.NotSupported);
                            return;
                        default:
                            aVar.a(MediaStoreItem.MediaSupportType.Unknown);
                            return;
                    }
                }
                aVar.a(a2.n());
                return;
            }
            if (aVar.b() == MediaItemType.IMAGE) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(aVar.h(), options);
                aVar.a(options.outWidth, options.outHeight);
                aVar.c(false);
                aVar.a(MediaStoreItem.MediaSupportType.Supported);
                return;
            }
            return;
        }
        if (aVar.b() == MediaItemType.IMAGE) {
            aVar.a(0, 0);
            aVar.c(false);
        }
    }
}
