package com.fit.nlu.DHHCeramic.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Log extends BaseModel {
    private int id;
    private String ip;
    private int level;
    private String address;
    private String prevalue;
    private String value;
    private int status;
    static Map<Integer, String> levelMapping = new HashMap<>();

    static {
        levelMapping.put(0, "INFO");
        levelMapping.put(1, "ERROR");
        levelMapping.put(2, "WARNING");
        levelMapping.put(3, "DANGER");
    }

    public static int INFO = 0;
    public static int ERROR = 1;
    public static int WARNING = 2;
    public static int DANGER = 3;

    public Log() {
    }

    public Log(int id, String ip, int level, String resource, String prevalue, String value) {
        this.id = id;
        this.ip = ip;
        this.level = level;
        this.address = address;
        this.prevalue = prevalue;
        this.value = value;
    }

    public Log(int id, String ip, int level, String address, String prevalue, String value, int status) {
        this.id = id;
        this.ip = ip;
        this.level = level;
        this.address = address;
        this.prevalue = prevalue;
        this.value = value;
        this.status = status;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLevelWithName() {
        return levelMapping.get(levelMapping.containsKey(this.level) ? this.level : 0);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrevalue() {
        return prevalue;
    }

    public void setPrevalue(String prevalue) {
        this.prevalue = prevalue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static Map<Integer, String> getLevelMapping() {
        return levelMapping;
    }

    public static void setLevelMapping(Map<Integer, String> levelMapping) {
        Log.levelMapping = levelMapping;
    }

    public static int getINFO() {
        return INFO;
    }

    public static void setINFO(int INFO) {
        Log.INFO = INFO;
    }

    public static int getWARNING() {
        return WARNING;
    }

    public static void setWARNING(int WARNING) {
        Log.WARNING = WARNING;
    }

    public static int getDANGER() {
        return DANGER;
    }

    public static void setDANGER(int DANGER) {
        Log.DANGER = DANGER;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static int getERROR() {
        return ERROR;
    }

    public static void setERROR(int ERROR) {
        Log.ERROR = ERROR;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", level=" + level +
                ", address='" + address + '\'' +
                ", prevalue='" + prevalue + '\'' +
                ", value='" + value + '\'' +
                ", status=" + status +
                '}';
    }

}