package org.dvdprofilermvc.io;

import java.io.File;

public class IO {

	private static final String PROJECT_FOLDER = ".dvdprofilermvc";

	public File getProjectDir() {
		final File projectFolder = new File(System.getProperty("user.home") + File.separatorChar + PROJECT_FOLDER);
		if (!projectFolder.exists()) {
			projectFolder.mkdir();
		}
		return projectFolder;
	}

}
