package c.d.b.j;

import android.content.Context;
import com.nexstreaming.app.general.nexasset.assetpackage.ItemCategory;
import com.nexstreaming.app.general.nexasset.assetpackage.h;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nexstreaming.app.general.nexasset.assetpackage.u;
import com.nexstreaming.app.general.nexasset.assetpackage.y;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ThemeApplicatorFactory.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static c f3822a = new d();

    public static c a(c.d.b.i.a aVar) {
        if (aVar == null) {
            return f3822a;
        }
        return new a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ThemeApplicatorFactory.java */
    /* loaded from: classes.dex */
    public static class a extends c.d.b.j.a {

        /* renamed from: a, reason: collision with root package name */
        private final c.d.b.i.a f3823a;

        public a(c.d.b.i.a aVar) {
            this.f3823a = aVar;
        }

        @Override // c.d.b.j.a
        protected boolean a(b bVar, NexLayerItem nexLayerItem) {
            return false;
        }

        @Override // c.d.b.j.a
        protected boolean a(b bVar, NexAudioClipItem nexAudioClipItem) {
            return false;
        }

        @Override // c.d.b.j.a
        protected boolean a(b bVar, NexTimeline nexTimeline) {
            return false;
        }

        @Override // c.d.b.j.a
        protected boolean a(b bVar, NexTransitionItem nexTransitionItem, NexVideoClipItem nexVideoClipItem, NexVideoClipItem nexVideoClipItem2, int i, int i2) {
            r a2;
            int min;
            Context context = bVar.getContext();
            String a3 = this.f3823a.a(i, i2);
            int b2 = this.f3823a.b(i, i2);
            int duration = nexTransitionItem.getDuration();
            boolean z = false;
            if (a3 != null && b2 > 15 && (a2 = h.a(context).a(a3)) != null && a2.getCategory() == ItemCategory.transition) {
                u uVar = null;
                try {
                    uVar = y.a(context, a3);
                } catch (IOException | XmlPullParserException unused) {
                }
                if (uVar != null && ((min = Math.min(nexTransitionItem.getMaximumDuration(), b2)) >= 500 || min >= b2)) {
                    nexTransitionItem.setTransitionEffectID(a2.getAssetPackage().getAssetIdx() + "/" + a2.getId());
                    if (nexVideoClipItem != null && nexVideoClipItem2 != null && min > duration && (nexVideoClipItem2.getAbsEndTime() - nexVideoClipItem2.getAbsStartTime()) - min <= min) {
                        z = true;
                    }
                    nexTransitionItem.setDuration(min);
                    if (z) {
                        bVar.getTimeline().requestCalcTimes();
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:            if (r14 < 0) goto L31;     */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00c8  */
        @Override // c.d.b.j.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected boolean a(c.d.b.j.b r12, com.nextreaming.nexeditorui.NexVideoClipItem r13, int r14, int r15) {
            /*
                r11 = this;
                android.content.Context r0 = r12.getContext()
                c.d.b.i.a r1 = r11.f3823a
                java.lang.String r1 = r1.c(r14, r15)
                c.d.b.i.a r2 = r11.f3823a
                int r2 = r2.d(r14, r15)
                r3 = 2
                r4 = 1
                if (r2 != r4) goto L16
                r2 = 2
                goto L19
            L16:
                if (r2 != r3) goto L19
                r2 = 1
            L19:
                r3 = 0
                if (r2 < 0) goto L2c
                int r5 = r12.a()
                if (r2 >= r5) goto L2c
                java.lang.String r5 = r12.a(r2)
                if (r5 == 0) goto L2d
                r12.a(r2, r4)
                goto L2d
            L2c:
                r5 = r3
            L2d:
                if (r1 == 0) goto L38
                com.nexstreaming.app.general.nexasset.assetpackage.h r6 = com.nexstreaming.app.general.nexasset.assetpackage.h.a(r0)
                com.nexstreaming.app.general.nexasset.assetpackage.r r6 = r6.a(r1)
                goto L39
            L38:
                r6 = r3
            L39:
                r7 = 0
                if (r6 == 0) goto Lc5
                int r8 = r13.getEffectStartTime()
                int r9 = r13.getEffectEndTime()
                if (r8 != 0) goto L65
                r10 = 2147483647(0x7fffffff, float:NaN)
                if (r9 != r10) goto L65
                if (r14 <= 0) goto L59
                int r14 = r14 + r4
                if (r14 != r15) goto L59
                int r9 = r13.getRepresentedDuration()
                int r14 = r9 + (-10000)
                if (r14 >= 0) goto L66
                goto L63
            L59:
                int r14 = r13.getRepresentedDuration()
                r15 = 10000(0x2710, float:1.4013E-41)
                int r9 = java.lang.Math.min(r14, r15)
            L63:
                r14 = 0
                goto L66
            L65:
                r14 = r8
            L66:
                int r15 = r9 - r14
                r8 = 3000(0xbb8, float:4.204E-42)
                if (r15 <= r8) goto Lc5
                java.lang.StringBuilder r15 = new java.lang.StringBuilder
                r15.<init>()
                com.nexstreaming.app.general.nexasset.assetpackage.b r8 = r6.getAssetPackage()
                int r8 = r8.getAssetIdx()
                r15.append(r8)
                java.lang.String r8 = "/"
                r15.append(r8)
                java.lang.String r6 = r6.getId()
                r15.append(r6)
                java.lang.String r15 = r15.toString()
                r13.setEffectID(r15)
                r13.setEffectTiming(r14, r9)
                if (r5 == 0) goto Lc6
                com.nexstreaming.app.general.nexasset.assetpackage.u r14 = com.nexstreaming.app.general.nexasset.assetpackage.y.a(r0, r1)     // Catch: java.lang.Throwable -> L99
                goto L9a
            L99:
                r14 = r3
            L9a:
                if (r14 == 0) goto Lc6
                java.util.List r14 = r14.e()
                java.util.Iterator r14 = r14.iterator()
            La4:
                boolean r15 = r14.hasNext()
                if (r15 == 0) goto Lc6
                java.lang.Object r15 = r14.next()
                com.nexstreaming.app.general.nexasset.assetpackage.s r15 = (com.nexstreaming.app.general.nexasset.assetpackage.s) r15
                com.nexstreaming.app.general.nexasset.assetpackage.ItemParameterType r0 = r15.getType()
                com.nexstreaming.app.general.nexasset.assetpackage.ItemParameterType r1 = com.nexstreaming.app.general.nexasset.assetpackage.ItemParameterType.TEXT
                if (r0 != r1) goto La4
                java.util.Map r0 = r13.getEffectOptions()
                java.lang.String r15 = r15.getId()
                r0.put(r15, r5)
                r5 = r3
                goto La4
            Lc5:
                r4 = 0
            Lc6:
                if (r5 == 0) goto Lea
                int r14 = r13.getAbsStartTime()
                int r15 = r14 + 10000
                int r13 = r13.getAbsEndTime()
                int r13 = java.lang.Math.min(r15, r13)
                int r13 = r13 - r14
                r15 = 2000(0x7d0, float:2.803E-42)
                if (r13 <= r15) goto Le7
                com.nexstreaming.kinemaster.layer.TextLayer r13 = com.nexstreaming.kinemaster.layer.TextLayer.newInstance(r5, r14, r13)
                com.nextreaming.nexeditorui.NexTimeline r12 = r12.getTimeline()
                r12.addLayer(r13)
                goto Lea
            Le7:
                r12.a(r2, r7)
            Lea:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: c.d.b.j.e.a.a(c.d.b.j.b, com.nextreaming.nexeditorui.NexVideoClipItem, int, int):boolean");
        }
    }
}
