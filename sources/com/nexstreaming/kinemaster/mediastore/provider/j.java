package com.nexstreaming.kinemaster.mediastore.provider;

import android.graphics.BitmapFactory;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.item.b;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: AndroidMediaStoreProvider.java */
/* loaded from: classes.dex */
class j implements b.a {
    @Override // com.nexstreaming.kinemaster.mediastore.item.b.a
    public void a(com.nexstreaming.kinemaster.mediastore.item.b bVar) {
        if (bVar.getType() == MediaItemType.VIDEO) {
            MediaInfo a2 = MediaInfo.a(bVar.getPath());
            if (a2.V()) {
                bVar.a(0, 0);
                bVar.b(false);
                bVar.a(a2.y());
                return;
            }
            bVar.b(a2.u());
            bVar.a(a2.D(), a2.C());
            bVar.d(a2.t());
            bVar.b(a2.S());
            MediaSupportType y = a2.y();
            if (y != MediaSupportType.Unknown && y != MediaSupportType.Supported) {
                bVar.a(y);
                return;
            }
            if (EditorGlobal.i() != null) {
                int a3 = EditorGlobal.i().i().a(a2.N(), a2.M(), a2.D(), a2.C(), a2.t(), a2.I(), a2.q(), a2.m(), a2.L(), a2.p(), a2.J(), a2.O());
                if (EditorGlobal.w() && (a3 == 1 || a3 == 4)) {
                    bVar.a(MediaSupportType.Supported);
                } else if (a3 == 0) {
                    bVar.a(MediaSupportType.Supported);
                } else if (a3 == 1) {
                    bVar.a(MediaSupportType.NeedTranscodeRes);
                } else if (a3 == 2) {
                    bVar.a(MediaSupportType.NeedTranscodeFPS);
                } else if (a3 == 3) {
                    bVar.a(MediaSupportType.NotSupported_VideoProfile);
                } else if (a3 == 4) {
                    bVar.a(MediaSupportType.NotSupported_ResolutionTooHigh);
                } else if (a3 == 5) {
                    bVar.a(MediaSupportType.NotSupported);
                } else if (a3 != 8) {
                    bVar.a(MediaSupportType.Unknown);
                } else {
                    bVar.a(MediaSupportType.NeedTranscodeAVSync);
                }
            } else {
                bVar.a(a2.y());
            }
            bVar.c(a2.r());
            return;
        }
        if (bVar.getType() == MediaItemType.IMAGE) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(bVar.getPath(), options);
            bVar.a(options.outWidth, options.outHeight);
            bVar.b(false);
            bVar.a(MediaSupportType.Supported);
            return;
        }
        bVar.a(MediaSupportType.Supported);
    }
}
