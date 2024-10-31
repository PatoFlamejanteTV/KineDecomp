package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.media.ExifInterface;
import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.ListView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.GroupLayer;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediainfo.CodecType;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.ui.projectedit.C1935kd;
import com.nexstreaming.kinemaster.ui.projectedit.OptionMenuItem;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;

/* compiled from: OptionMenuItemClickHandler.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.xd, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2073xd {

    /* renamed from: a, reason: collision with root package name */
    private final ListView f22767a;

    /* renamed from: b, reason: collision with root package name */
    private final C1935kd f22768b;

    /* renamed from: c, reason: collision with root package name */
    private final Bg f22769c;

    /* renamed from: d, reason: collision with root package name */
    private final C1935kd.a f22770d;

    /* renamed from: e, reason: collision with root package name */
    private final InterfaceC1997rd f22771e;

    /* renamed from: f, reason: collision with root package name */
    private OptionMenuItem f22772f = null;

    /* renamed from: g, reason: collision with root package name */
    private a f22773g = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OptionMenuItemClickHandler.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.xd$b */
    /* loaded from: classes2.dex */
    public interface b {
        void a(a aVar, NexTimelineItem nexTimelineItem);
    }

    /* compiled from: OptionMenuItemClickHandler.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.xd$c */
    /* loaded from: classes2.dex */
    private static class c extends SpannableStringBuilder {
        c() {
        }

        c a(CharSequence charSequence, Object obj) {
            int length = length();
            append(charSequence);
            setSpan(obj, length, charSequence.length() + length, 33);
            return this;
        }

        @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
        public /* bridge */ /* synthetic */ Editable append(CharSequence charSequence) {
            append(charSequence);
            return this;
        }

        @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
        public /* bridge */ /* synthetic */ SpannableStringBuilder append(CharSequence charSequence) {
            append(charSequence);
            return this;
        }

        @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) throws IOException {
            append(charSequence);
            return this;
        }

        public c a(CharSequence charSequence, boolean z) {
            super.append(charSequence);
            if (z) {
                super.append("\n");
            }
            return this;
        }

        @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
        public c append(CharSequence charSequence) {
            super.append(charSequence);
            return this;
        }
    }

    public C2073xd(ListView listView, C1935kd c1935kd, Bg bg, C1935kd.a aVar, InterfaceC1997rd interfaceC1997rd) {
        this.f22767a = listView;
        this.f22768b = c1935kd;
        this.f22769c = bg;
        this.f22770d = aVar;
        this.f22771e = interfaceC1997rd;
    }

    public static void b(TextView textView, NexTimelineItem nexTimelineItem) {
        if (nexTimelineItem instanceof NexLayerItem) {
            textView.setText(((NexLayerItem) nexTimelineItem).getLayerName());
        } else if (nexTimelineItem instanceof NexAudioClipItem) {
            textView.setText(((NexAudioClipItem) nexTimelineItem).getClipName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OptionMenuItemClickHandler.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.xd$a */
    /* loaded from: classes2.dex */
    public static class a extends com.nexstreaming.kinemaster.ui.a.e implements View.OnClickListener {
        NexTimelineItem I;
        com.nexstreaming.app.kinemasterfree.a.i J;
        b K;

        public a(Context context, NexTimelineItem nexTimelineItem) {
            super(context, 2131886510);
            this.I = nexTimelineItem;
        }

        public void a(NexTimelineItem nexTimelineItem) {
            this.I = nexTimelineItem;
            com.nexstreaming.app.kinemasterfree.a.i iVar = this.J;
            if (iVar != null) {
                iVar.a(nexTimelineItem);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != R.id.label) {
                dismiss();
                return;
            }
            b bVar = this.K;
            if (bVar != null) {
                bVar.a(this, this.J.h());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nexstreaming.kinemaster.ui.a.e, android.app.Dialog
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.dimAmount = 0.3f;
            attributes.width = -1;
            attributes.height = -1;
            attributes.windowAnimations = 0;
            getWindow().setAttributes(attributes);
            getWindow().addFlags(2);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            com.nexstreaming.app.kinemasterfree.a.i a2 = com.nexstreaming.app.kinemasterfree.a.i.a(getLayoutInflater());
            a(a2);
            this.J = a2;
            this.J.a((View.OnClickListener) this);
            this.J.a(this.I);
            this.J.y.setAlpha(0.0f);
            this.J.y.setScaleX(0.9f);
            this.J.y.setScaleY(0.9f);
            this.J.y.animate().setInterpolator(new OvershootInterpolator()).setDuration(250L).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).start();
        }

        @Override // android.app.Dialog
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (super.onTouchEvent(motionEvent)) {
                return true;
            }
            dismiss();
            return true;
        }

        private com.nexstreaming.app.kinemasterfree.a.i a(com.nexstreaming.app.kinemasterfree.a.i iVar) {
            setContentView(iVar.e());
            return iVar;
        }

        public void a(b bVar) {
            this.K = bVar;
        }
    }

    public C1935kd a() {
        return this.f22768b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0211, code lost:            if (r9.u != false) goto L105;     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0213, code lost:            r0 = com.nexstreaming.app.kinemasterfree.R.id.expandedOptionPanelHolder;     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0217, code lost:            r0 = com.nexstreaming.app.kinemasterfree.R.id.optionPanelHolder;     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0226, code lost:            if (r9.u != false) goto L105;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.nexstreaming.kinemaster.ui.projectedit.OptionMenuItem r9, com.nexstreaming.app.general.util.z r10) {
        /*
            Method dump skipped, instructions count: 632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.C2073xd.a(com.nexstreaming.kinemaster.ui.projectedit.OptionMenuItem, com.nexstreaming.app.general.util.z):void");
    }

    private static String b(MediaInfo mediaInfo) {
        try {
            String absolutePath = mediaInfo.B().getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            sb.append(absolutePath.substring(absolutePath.lastIndexOf(".") + 1).toUpperCase(Locale.US));
            sb.append(" (");
            CodecType J = mediaInfo.J();
            CodecType n = mediaInfo.n();
            if (J != null) {
                sb.append(J.Oc.toUpperCase(Locale.US));
                if (n != null) {
                    sb.append("/");
                }
            }
            if (n != null) {
                sb.append(n.Oc.toUpperCase(Locale.US));
            }
            sb.append(")");
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public void a(int i, int i2, Intent intent) {
        Bg bg;
        if (i == 8213 && this.f22772f != null && i2 == 1) {
            String e2 = FullScreenInputActivity.e(intent);
            String c2 = FullScreenInputActivity.c(intent);
            OptionMenuItem optionMenuItem = this.f22772f;
            OptionMenuItem.Type type = optionMenuItem.p;
            if (type == OptionMenuItem.Type.TextField) {
                this.f22771e.a(optionMenuItem, e2);
            } else if (type == OptionMenuItem.Type.TextFieldWithFont) {
                this.f22771e.a(optionMenuItem, c2 + "\u001b" + e2);
            }
            this.f22767a.clearChoices();
            this.f22768b.notifyDataSetChanged();
            this.f22772f = null;
            return;
        }
        if (i2 == 1 && i == 8193 && (bg = this.f22769c) != null) {
            NexTimelineItem Y = bg.Y();
            if (Y instanceof NexLayerItem) {
                ((NexLayerItem) Y).setLayerName(FullScreenInputActivity.e(intent));
            } else if (Y instanceof NexAudioClipItem) {
                ((NexAudioClipItem) Y).setClipName(FullScreenInputActivity.e(intent));
            }
            if (Y instanceof GroupLayer) {
                Bg bg2 = this.f22769c;
                if (bg2 instanceof Pa) {
                    ((Pa) bg2).Aa();
                }
            }
            this.f22769c.G();
            this.f22768b.notifyDataSetChanged();
            a aVar = this.f22773g;
            if (aVar != null) {
                aVar.a(Y);
            }
        }
    }

    private void a(Context context, NexTimelineItem nexTimelineItem) {
        a aVar = this.f22773g;
        if (aVar != null) {
            aVar.dismiss();
        }
        this.f22773g = new a(context, nexTimelineItem);
        this.f22773g.a(new C2056vd(this));
        this.f22773g.setOnDismissListener(new DialogInterfaceOnDismissListenerC2065wd(this));
        this.f22773g.show();
    }

    public static void a(TextView textView, NexTimelineItem nexTimelineItem) {
        Log.d("OptMenuItemClickHnd", "[setInfoDetail] item: " + nexTimelineItem);
        if (nexTimelineItem instanceof VideoLayer) {
            MediaInfo mediaInfo = ((VideoLayer) nexTimelineItem).getMediaInfo();
            c cVar = new c();
            cVar.a("Name: ", new StyleSpan(1));
            cVar.a((CharSequence) mediaInfo.B().getName(), true);
            cVar.a("Location: ", new StyleSpan(1));
            cVar.a((CharSequence) mediaInfo.B().getAbsolutePath(), true);
            cVar.a("Type: ", new StyleSpan(1));
            cVar.a((CharSequence) b(mediaInfo), true);
            cVar.a("Resolution: ", new StyleSpan(1));
            cVar.a((CharSequence) a(mediaInfo.Q(), mediaInfo.P()), true);
            cVar.a("Size: ", new StyleSpan(1));
            cVar.a((CharSequence) a(mediaInfo.u()), true);
            cVar.a("Duration: ", new StyleSpan(1));
            cVar.a((CharSequence) a(textView.getResources(), mediaInfo.r()), true);
            textView.setText(cVar);
            return;
        }
        if (nexTimelineItem instanceof ImageLayer) {
            ImageLayer imageLayer = (ImageLayer) nexTimelineItem;
            if (imageLayer.isSolid()) {
                c cVar2 = new c();
                cVar2.a("RGB: ", new StyleSpan(1));
                cVar2.append((CharSequence) String.format(Locale.US, "#%06X", Integer.valueOf(imageLayer.getSolidColor() & ViewCompat.MEASURED_SIZE_MASK)));
                textView.setText(cVar2);
                return;
            }
            if (com.nexstreaming.kinemaster.mediastore.provider.s.a(textView.getContext(), imageLayer.getMediaPath()) != null) {
                textView.setText((CharSequence) null);
                return;
            }
            File file = new File(imageLayer.getMediaPath());
            c cVar3 = new c();
            cVar3.a("Name: ", new StyleSpan(1));
            cVar3.a((CharSequence) file.getName(), true);
            cVar3.a("Location: ", new StyleSpan(1));
            cVar3.a((CharSequence) file.getAbsolutePath(), true);
            if (file.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                if (options.outMimeType != null) {
                    cVar3.a("Type: ", new StyleSpan(1));
                    String str = options.outMimeType;
                    cVar3.a((CharSequence) str.substring(str.lastIndexOf("/") + 1).toUpperCase(Locale.US), true);
                }
                cVar3.a("Resolution: ", new StyleSpan(1));
                cVar3.a((CharSequence) a(options.outWidth, options.outHeight), true);
                cVar3.a("Size: ", new StyleSpan(1));
                cVar3.a((CharSequence) a(file.length()), true);
                ExifInterface a2 = a(file.getAbsolutePath());
                if (a2 != null) {
                    cVar3.a("EXIF: \n", new StyleSpan(1));
                    for (String str2 : new String[]{"FNumber", "DateTime", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ImageLength", "ImageWidth", "ISOSpeedRatings", "Make", "Model", "Orientation", "WhiteBalance"}) {
                        String attribute = a2.getAttribute(str2);
                        if (attribute != null) {
                            cVar3.append((CharSequence) "   ");
                            cVar3.append((CharSequence) str2);
                            cVar3.append('=');
                            cVar3.append((CharSequence) attribute);
                            cVar3.append('\n');
                        }
                    }
                }
            }
            textView.setText(cVar3);
            return;
        }
        if (nexTimelineItem instanceof NexAudioClipItem) {
            NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) nexTimelineItem;
            if (nexAudioClipItem.isAssetMusic()) {
                c cVar4 = new c();
                cVar4.a("Song Title: ", new StyleSpan(1));
                cVar4.a((CharSequence) nexAudioClipItem.getTitle(textView.getContext()), true);
                MediaInfo mediaInfo2 = nexAudioClipItem.getMediaInfo();
                if (mediaInfo2 != null) {
                    cVar4.a("Duration: ", new StyleSpan(1));
                    cVar4.a((CharSequence) a(textView.getResources(), mediaInfo2.r()), true);
                    String a3 = a(mediaInfo2);
                    if (a3 != null) {
                        cVar4.a("Type: ", new StyleSpan(1));
                        cVar4.a((CharSequence) a3, true);
                    }
                    cVar4.a("Sample rate: ", new StyleSpan(1));
                    cVar4.a((CharSequence) a(mediaInfo2.q()), true);
                }
                textView.setText(cVar4);
                return;
            }
            if (nexAudioClipItem.getIsVoiceRecording()) {
                c cVar5 = new c();
                File file2 = new File(nexAudioClipItem.getMediaPath());
                cVar5.a("Name: ", new StyleSpan(1));
                cVar5.a((CharSequence) file2.getName(), true);
                cVar5.a("Location: ", new StyleSpan(1));
                cVar5.a((CharSequence) file2.getAbsolutePath(), true);
                MediaInfo mediaInfo3 = nexAudioClipItem.getMediaInfo();
                if (mediaInfo3 != null) {
                    cVar5.a("Duration: ", new StyleSpan(1));
                    cVar5.a((CharSequence) a(textView.getResources(), mediaInfo3.r()), true);
                    String a4 = a(mediaInfo3);
                    if (a4 != null) {
                        cVar5.a("Type: ", new StyleSpan(1));
                        cVar5.a((CharSequence) a4, true);
                    }
                    cVar5.a("Sample rate: ", new StyleSpan(1));
                    cVar5.a((CharSequence) a(mediaInfo3.q()), true);
                }
                textView.setText(cVar5);
                return;
            }
            c cVar6 = new c();
            cVar6.a("Song Title: ", new StyleSpan(1));
            cVar6.a((CharSequence) nexAudioClipItem.getTitle(textView.getContext()), true);
            File file3 = new File(nexAudioClipItem.getMediaPath());
            cVar6.a("Name: ", new StyleSpan(1));
            cVar6.a((CharSequence) file3.getName(), true);
            cVar6.a("Location: ", new StyleSpan(1));
            cVar6.a((CharSequence) file3.getAbsolutePath(), true);
            MediaInfo mediaInfo4 = nexAudioClipItem.getMediaInfo();
            if (mediaInfo4 != null) {
                cVar6.a("Duration: ", new StyleSpan(1));
                cVar6.a((CharSequence) a(textView.getResources(), mediaInfo4.r()), true);
                String a5 = a(mediaInfo4);
                if (a5 != null) {
                    cVar6.a("Type: ", new StyleSpan(1));
                    cVar6.a((CharSequence) a5, true);
                }
                cVar6.a("Sample rate: ", new StyleSpan(1));
                cVar6.a((CharSequence) a(mediaInfo4.q()), true);
            }
            textView.setText(cVar6);
        }
    }

    private static String a(MediaInfo mediaInfo) {
        CodecType n = mediaInfo.n();
        if (n != null) {
            return n.Oc.toUpperCase(Locale.US);
        }
        return null;
    }

    private static String a(int i, int i2) {
        return i + FragmentC2201x.f23219a + i2;
    }

    private static String a(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###,###");
        if (j > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return decimalFormat.format(((float) j) / 1048576.0f) + "MB";
        }
        return decimalFormat.format(((float) j) / 1024.0f) + "KB";
    }

    private static String a(Resources resources, int i) {
        return EditorGlobal.a(resources, i);
    }

    private static String a(int i) {
        return new DecimalFormat("#,###,###").format(i);
    }

    private static ExifInterface a(String str) {
        try {
            return new ExifInterface(str);
        } catch (IOException unused) {
            return null;
        }
    }
}
