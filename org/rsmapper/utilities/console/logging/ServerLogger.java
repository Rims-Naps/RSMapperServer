//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.utilities.console.logging;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.RsMapperServer;

public class ServerLogger extends PrintStream {
    public ServerLogger(OutputStream out) {
        super(out);
    }

    public void print(boolean message) {
        Throwable throwable = new Throwable();
        String name = throwable.getStackTrace()[2].getFileName().replaceAll(".java", "");
        String line = String.valueOf(throwable.getStackTrace()[2].getLineNumber());
        this.log(name + ":" + line, "" + message);
    }

    public void print(int message) {
        Throwable throwable = new Throwable();
        String name = throwable.getStackTrace()[2].getFileName().replaceAll(".java", "");
        String line = String.valueOf(throwable.getStackTrace()[2].getLineNumber());
        this.log(name + ":" + line, "" + message);
    }

    public void print(String message) {
        Throwable throwable = new Throwable();
        String name = throwable.getStackTrace()[2].getFileName().replaceAll(".java", "");
        String line = String.valueOf(throwable.getStackTrace()[2].getLineNumber());
        this.log(name + ":" + line, message);
    }

    private void log(String className, String text) {
        super.print("[" + className + "][" + this.getDate() + "]" + text);
        RsMapperServer.print("[" + className + "][" + this.getDate() + "]" + text);
    }

    private String getDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("America/Toronto"));
        Date date = cal.getTime();
        String formatted = new String(date.getMonth() + "/" + date.getDay() + "/" + cal.get(1));
        int hours = date.getHours();
        formatted = formatted + ", " + (hours > 12 ? hours - 12 : hours) + ":" + date.getMinutes() + ":" + date.getSeconds() + " " + (hours > 12 ? "PM" : "AM");
        return formatted;
    }
}
