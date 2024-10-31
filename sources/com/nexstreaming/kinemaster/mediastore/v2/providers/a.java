package com.nexstreaming.kinemaster.mediastore.v2.providers;

import android.graphics.BitmapFactory;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediastore.v2.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.a;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: AndroidMediaStoreProvider.java */
/* loaded from: classes.dex */
final class a implements a.InterfaceC0071a {
    @Override // com.nexstreaming.kinemaster.mediastore.v2.a.InterfaceC0071a
    public void a(com.nexstreaming.kinemaster.mediastore.v2.a aVar) {
        if (aVar.b() == MediaItemType.VIDEO) {
            MediaInfo a2 = MediaInfo.a(aVar.h());
            if (a2.m()) {
                aVar.a(0, 0);
                aVar.c(false);
                aVar.a(a2.n());
                return;
            }
            aVar.c(a2.i());
            aVar.a(a2.u(), a2.v());
            aVar.f(a2.B());
            aVar.c(a2.r());
            MediaStoreItem.MediaSupportType n = a2.n();
            if (n != MediaStoreItem.MediaSupportType.Unknown && n != MediaStoreItem.MediaSupportType.Supported) {
                aVar.a(n);
                return;
            }
            if (EditorGlobal.a() != null) {
                switch (EditorGlobal.a().d().a(a2.D(), a2.E(), a2.u(), a2.v(), a2.B(), a2.F(), a2.H(), a2.I())) {
                    case 0:
                        aVar.a(MediaStoreItem.MediaSupportType.Supported);
                        break;
                    case 1:
                        aVar.a(MediaStoreItem.MediaSupportType.NeedTranscodeRes);
                        break;
                    case 2:
                        aVar.a(MediaStoreItem.MediaSupportType.NeedTranscodeFPS);
                        break;
                    case 3:
                        aVar.a(MediaStoreItem.MediaSupportType.NotSupported_VideoProfile);
                        break;
                    case 4:
                        aVar.a(MediaStoreItem.MediaSupportType.NotSupported_ResolutionTooHigh);
                        break;
                    case 5:
                        aVar.a(MediaStoreItem.MediaSupportType.NotSupported);
                        break;
                    default:
                        aVar.a(MediaStoreItem.MediaSupportType.Unknown);
                        break;
                }
            } else {
                aVar.a(a2.n());
            }
            aVar.e(a2.y());
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
        aVar.a(MediaStoreItem.MediaSupportType.Supported);
    }
}
