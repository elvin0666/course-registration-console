package service;

import entity.HumanWrapper;
import util.FileUtil;

public class Database {

    public static final HumanWrapper HUMAN_WRAPPER = (HumanWrapper) FileUtil.readObjectFromFile();

}
