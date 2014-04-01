package com.mype.homesync.bt;

import java.io.File;
import java.io.IOException;

/**
 * @author Vitaliy Gerya
 */
public interface Environment {
    File getPathBTExecutable() throws IOException;
    String getAPIKey();
}
