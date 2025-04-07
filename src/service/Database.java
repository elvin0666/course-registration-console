package service;

import entity.HumanWrapper;
import util.FileUtil;

public class Database {

    static {
        HUMAN_WRAPPER = getHumanWrapper();
    }

    private static final String FILE_NAME = "registration-db.obj";

    public static final HumanWrapper HUMAN_WRAPPER;

    private static HumanWrapper getHumanWrapper() {
        HumanWrapper humanWrapper = (HumanWrapper) FileUtil.readObjectFromFile(FILE_NAME);

        return humanWrapper == null ? new HumanWrapper() : humanWrapper;
    }

    public static void save() {
        FileUtil.writeObjectToFile(HUMAN_WRAPPER, FILE_NAME);
    }

}
