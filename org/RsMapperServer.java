//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org;

import com.dropbox.core.v2.DbxClientV2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;
import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import org.rsmapper.Constants;
import org.rsmapper.engine.CoresManager;
import org.rsmapper.engine.game.GameLoader;
import org.rsmapper.networking.ServerChannelHandler;
import org.rsmapper.utilities.misc.Stopwatch;

public class RsMapperServer extends JFrame {
    private static final long serialVersionUID = -4839712424564486491L;
    public static JPanel client_panel;
    private static JEditorPane output;
    public static final DbxClientV2 DBXCLIENT = null;
    public static long STARTUP_TIME = -1L;
    public static final Stopwatch STOPWATCH = Stopwatch.start();

    public static void main(String[] args) {
        try {
            new RsMapperServer();
        } catch (Exception var2) {
            Exception e = var2;
            print(e.toString());
            e.printStackTrace();
        }

    }

    public RsMapperServer() {
        try {
            this.setTitle("RSMapper Server");
            this.setLayout(new BorderLayout());
            this.setFocusable(true);
            client_panel = new JPanel();
            client_panel.setLayout((LayoutManager)null);
            client_panel.setPreferredSize(new Dimension(480, 200));
            client_panel.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102), 3));
            client_panel.setFocusable(true);
            client_panel.setRequestFocusEnabled(true);
            JLabel titleLabel = this.createTitleLabel();
            output = this.createOutputTextPane();
            output.setBounds(0, 30, 480, 170);
            JScrollPane outputScrollPane = new JScrollPane(output, 22, 32);
            outputScrollPane.setBounds(4, 30, 483, 177);
            client_panel.add(titleLabel);
            client_panel.add(outputScrollPane);
            this.getContentPane().add(client_panel, "Center");
            this.setVisible(true);
            this.setResizable(false);
            this.pack();
            this.setLocationRelativeTo((Component)null);
            this.setDefaultCloseOperation(0);
            this.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                    RsMapperServer.shutdown();
                    System.exit(-1);
                }
            });
            print("Loading the RSMapper Server...");
            GameLoader.get().getBackgroundLoader().waitForPendingTasks().shutdown();
            print("...Server Successfully Loaded (<font style=\"color:green\">" + STOPWATCH.elapsed() + "</font> ms).");
            System.out.println("...Server Successfully Loaded. (" + STOPWATCH.elapsed() + " ms)");
            STARTUP_TIME = System.currentTimeMillis();
        } catch (ExecutionException var3) {
            ExecutionException e = var3;
            print("...<font style=\"color:red\">The server failed to load!</font>");
            e.printStackTrace();
        }

    }

    public JLabel createTitleLabel() {
        JLabel title = new JLabel("<html>This <u>MUST</u> be opened <u>first</u> and <u>remain open until the client is closed.</u></html>");
        title.setBounds(0, 0, 490, 30);
        title.setHorizontalAlignment(0);
        title.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102), 3));
        title.setOpaque(true);
        title.setBackground(new Color(220, 220, 220));
        return title;
    }

    public JEditorPane createOutputTextPane() {
        JEditorPane outputArea = new JEditorPane();
        outputArea.setContentType("text/html");
        outputArea.setEditable(false);
        return outputArea;
    }

    public static void print(String message) {
        Throwable throwable = new Throwable();
        String name = throwable.getStackTrace()[2].getFileName().replaceAll(".java", "");
        String line = String.valueOf(throwable.getStackTrace()[2].getLineNumber());
        log(Constants.DEBUG ? name + ":" + line : "", message);
    }

    public static void print(boolean message) {
        Throwable throwable = new Throwable();
        String name = throwable.getStackTrace()[2].getFileName().replaceAll(".java", "");
        String line = String.valueOf(throwable.getStackTrace()[2].getLineNumber());
        log(Constants.DEBUG ? name + ":" + line : "", "" + message);
    }

    public static void print(int message) {
        Throwable throwable = new Throwable();
        String name = throwable.getStackTrace()[2].getFileName().replaceAll(".java", "");
        String line = String.valueOf(throwable.getStackTrace()[2].getLineNumber());
        log(Constants.DEBUG ? name + ":" + line : "", "" + message);
    }

    private static void log(String className, String text) {
        HTMLDocument doc = (HTMLDocument)output.getDocument();
        HTMLEditorKit editorKit = (HTMLEditorKit)output.getEditorKit();

        try {
            editorKit.insertHTML(doc, doc.getLength(), "<b>" + (Constants.DEBUG ? "[" + className.replace("RsMapperServer", "Server").replace("GameLoader", "Loader") + "]" : "") + "[" + getDate() + "]</b> " + text + "\n", 0, 0, (HTML.Tag)null);
            output.setCaretPosition(output.getDocument().getLength());
        } catch (IOException | BadLocationException var5) {
            Exception e = var5;
            e.printStackTrace();
        }

    }

    private static String getDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("America/Toronto"));
        Date date = cal.getTime();
        int hours = date.getHours();
        String formatted = (hours > 12 ? hours - 12 : hours) + ":" + date.getMinutes() + ":" + date.getSeconds() + " " + (hours > 12 ? "PM" : "AM");
        return formatted;
    }

    public static void shutdown() {
        print("Shutting down...");
        closeServices();
        System.out.println("Shutting down...");
    }

    public static void closeServices() {
        ServerChannelHandler.shutdown();
        CoresManager.shutdown();
    }

    public static void restart() {
        closeServices();
        System.exit(-1);
    }
}
