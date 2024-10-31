package c.d.b.d.a.b;

import android.util.Xml;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FcpXmlGenerator.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private c.d.b.d.a.a.c.a f3697a;

    /* renamed from: b */
    private String f3698b;

    public a(c.d.b.d.a.a.c.a aVar, String str) {
        this.f3697a = aVar;
        this.f3698b = str;
    }

    public String a() throws IOException {
        StringWriter stringWriter;
        FileOutputStream fileOutputStream;
        XmlSerializer newSerializer = Xml.newSerializer();
        String str = this.f3698b;
        if (str != null) {
            File file = new File(str);
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            newSerializer.setOutput(fileOutputStream, "UTF-8");
            stringWriter = null;
        } else {
            StringWriter stringWriter2 = new StringWriter();
            newSerializer.setOutput(stringWriter2);
            stringWriter = stringWriter2;
            fileOutputStream = null;
        }
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", true);
        newSerializer.docdecl(" xmeml");
        c.d.b.d.a.b.a.a aVar = new c.d.b.d.a.b.a.a(newSerializer);
        aVar.a(this.f3697a);
        aVar.d();
        newSerializer.endDocument();
        newSerializer.flush();
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        if (stringWriter != null) {
            return stringWriter.toString();
        }
        return null;
    }
}
