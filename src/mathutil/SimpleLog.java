/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathutil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author bangmaple
 */
public final class SimpleLog {

    private static SimpleLog SINGLE_INSTANCE = null;
    private static String dateFormat = "dd/MM/yyyy HH:mm:ss";
    public static final Integer INFO = 0;
    public static final Integer ERROR = 1;
    public static final Integer DEBUG = 2;
    
    private Integer level;
    private String className = "";
    private Map<Integer, String> map = null;
    private String location = "";

    private void init() {
        this.map = new TreeMap<>();
        map.put(0, "[INFO] - ");
        map.put(1, "[ERROR] - ");
        map.put(2, "[DEBUG] - ");
    }

    private SimpleLog(String className, String location) {
        init();
        this.className = className;
        this.level = 0;
        this.location = location;
    }

    private SimpleLog(final Integer logLevel, final String className, String location) {
        init();
        this.level = logLevel;
        this.className = className;
        this.location = location;
    }

    public static SimpleLog getLogger(final String name, final String location) {
        synchronized (SimpleLog.class) {
            SINGLE_INSTANCE = new SimpleLog(name, location);
        }
        return SINGLE_INSTANCE;
    }

    public static SimpleLog getLogger(String name, Integer level, String location) {
        synchronized (SimpleLog.class) {
            SINGLE_INSTANCE = new SimpleLog(level, name, location);
        }
        return SINGLE_INSTANCE;
    }

    private void handleException(final PrintWriter out, BufferedWriter bw, FileWriter fw) {
        try {
            if (out != null) {
                out.close();
            }
            if (bw != null) {
                bw.append("FATAL ERROR!!!! CANNOT WRITE LOG!");
            }
            if (fw != null) {
                fw.close();
            }

        } catch (IOException ex) {
            System.out.println("Error in Simple Log Program!!!" + ex.getMessage());
        }
        System.exit(0);
    }

    public void writeLog(final Object msg) {
        final Date d = new Date(System.currentTimeMillis());
        final String rawDate = new SimpleDateFormat(dateFormat).format(d);
        int range = getQualifiedDate();
        String date = rawDate.substring(0, range).replaceAll("/", "_");
        BufferedWriter bw = null;
        PrintWriter out = null;
        FileWriter fw = null;
        try {
            File ff = new File(location + "/" + date + "_" + className + ".txt");
            fw = new FileWriter(ff, true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            String message;
            if (msg instanceof String) {
                message = String.valueOf(msg);

            } else if (msg instanceof Exception) {
                Exception exc = (Exception) msg;
                message = exc.toString();
            } else {
                return;
            }
            bw.append(rawDate + " - " + map.get(level) + "[" + className + "] - " + message);
            bw.newLine();
        } catch (IOException e) {
            handleException(out, bw, fw);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {

            }
        }
    }

    private int getQualifiedDate() {
        int range = 0;
        for (int i = 0; i < dateFormat.length(); i++) {
            if (dateFormat.charAt(i) == ' ') {
                range = i;
                break;
            }
        }
        return range;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public static String getDateFormat() {
        return dateFormat;
    }

    public static void setDateFormat(String dateFormat) {
        SimpleLog.dateFormat = dateFormat;
    }

}
