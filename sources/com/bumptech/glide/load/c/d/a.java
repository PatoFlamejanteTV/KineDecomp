package com.bumptech.glide.load.c.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.b.a;
import com.bumptech.glide.g.n;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* compiled from: ByteBufferGifDecoder.java */
/* loaded from: classes.dex */
public class a implements com.bumptech.glide.load.h<ByteBuffer, c> {

    /* renamed from: a, reason: collision with root package name */
    private static final C0054a f8685a = new C0054a();

    /* renamed from: b, reason: collision with root package name */
    private static final b f8686b = new b();

    /* renamed from: c, reason: collision with root package name */
    private final Context f8687c;

    /* renamed from: d, reason: collision with root package name */
    private final List<ImageHeaderParser> f8688d;

    /* renamed from: e, reason: collision with root package name */
    private final b f8689e;

    /* renamed from: f, reason: collision with root package name */
    private final C0054a f8690f;

    /* renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.load.c.d.b f8691g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteBufferGifDecoder.java */
    /* renamed from: com.bumptech.glide.load.c.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0054a {
        C0054a() {
        }

        com.bumptech.glide.b.a a(a.InterfaceC0045a interfaceC0045a, com.bumptech.glide.b.c cVar, ByteBuffer byteBuffer, int i) {
            return new com.bumptech.glide.b.e(interfaceC0045a, cVar, byteBuffer, i);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.a.e eVar, com.bumptech.glide.load.engine.a.b bVar) {
        this(context, list, eVar, bVar, f8686b, f8685a);
    }

    a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.a.e eVar, com.bumptech.glide.load.engine.a.b bVar, b bVar2, C0054a c0054a) {
        this.f8687c = context.getApplicationContext();
        this.f8688d = list;
        this.f8690f = c0054a;
        this.f8691g = new com.bumptech.glide.load.c.d.b(eVar, bVar);
        this.f8689e = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteBufferGifDecoder.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Queue<com.bumptech.glide.b.d> f8692a = n.a(0);

        b() {
        }

        synchronized com.bumptech.glide.b.d a(ByteBuffer byteBuffer) {
            com.bumptech.glide.b.d poll;
            poll = this.f8692a.poll();
            if (poll == null) {
                poll = new com.bumptech.glide.b.d();
            }
            poll.a(byteBuffer);
            return poll;
        }

        synchronized void a(com.bumptech.glide.b.d dVar) {
            dVar.a();
            this.f8692a.offer(dVar);
        }
    }

    @Override // com.bumptech.glide.load.h
    public boolean a(ByteBuffer byteBuffer, com.bumptech.glide.load.g gVar) throws IOException {
        return !((Boolean) gVar.a(i.f8720b)).booleanValue() && com.bumptech.glide.load.b.a(this.f8688d, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    @Override // com.bumptech.glide.load.h
    public e a(ByteBuffer byteBuffer, int i, int i2, com.bumptech.glide.load.g gVar) {
        com.bumptech.glide.b.d a2 = this.f8689e.a(byteBuffer);
        try {
            return a(byteBuffer, i, i2, a2, gVar);
        } finally {
            this.f8689e.a(a2);
        }
    }

    private e a(ByteBuffer byteBuffer, int i, int i2, com.bumptech.glide.b.d dVar, com.bumptech.glide.load.g gVar) {
        long a2 = com.bumptech.glide.g.h.a();
        try {
            com.bumptech.glide.b.c b2 = dVar.b();
            if (b2.b() > 0 && b2.c() == 0) {
                Bitmap.Config config = gVar.a(i.f8719a) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                com.bumptech.glide.b.a a3 = this.f8690f.a(this.f8691g, b2, byteBuffer, a(b2, i, i2));
                a3.a(config);
                a3.advance();
                Bitmap a4 = a3.a();
                if (a4 == null) {
                    return null;
                }
                e eVar = new e(new c(this.f8687c, a3, com.bumptech.glide.load.c.b.a(), i, i2, a4));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.g.h.a(a2));
                }
                return eVar;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.g.h.a(a2));
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.g.h.a(a2));
            }
        }
    }

    private static int a(com.bumptech.glide.b.c cVar, int i, int i2) {
        int min = Math.min(cVar.a() / i2, cVar.d() / i);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + FragmentC2201x.f23219a + i2 + "], actual dimens: [" + cVar.d() + FragmentC2201x.f23219a + cVar.a() + "]");
        }
        return max;
    }
}
