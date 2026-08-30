package tp09_Exo1;

import java.io.File;
import java.io.IOException;

public class HierarchyCreation {
	public static void hierarchyCreation(String path) throws IOException {
		File f = new File(path);
		if(!f.exists()) {
			path = System.getProperty("user.home");
		}
		path = path + File.separator + "hierarchy" + File.separator;
		// directory dir1 and dir11
		String path_tmp = path + File.separator + "dir1" + File.separator + "dir11";
		File f_tmp = new File(path_tmp);
		f_tmp.mkdirs();
		// directory dir2
		path_tmp = path + File.separator + "dir2";
		f_tmp = new File(path_tmp);
		f_tmp.mkdir();
		// content of hierarchy
		f = new File(path + "file1");
		f.createNewFile();
		f.setExecutable(true);
		f = new File(path + "file2");
		f.createNewFile();
		f.setExecutable(false);
		f = new File(path + ".file3");
		f.createNewFile();
		f.setExecutable(true);
		// content of dir1
		f = new File(path + File.separator + "dir1" + File.separator + "file11");
		f.createNewFile();
		f.setExecutable(true);
		f = new File(path + File.separator + "dir1" + File.separator + "file12");
		f.createNewFile();
		f.setExecutable(false);
		f = new File(path + File.separator + "dir1" + File.separator + ".file13");
		f.createNewFile();
		f.setExecutable(true);
		// content of dir2
		f = new File(path + File.separator + "dir2" + File.separator + "file21");
		f.createNewFile();
		f.setExecutable(true);
		f = new File(path + File.separator + "dir2" + File.separator + "file22");
		f.createNewFile();
		f.setExecutable(false);
		f = new File(path + File.separator + "dir2" + File.separator + ".file23");
		f.createNewFile();
		f.setExecutable(true);
		// content of dir11
		f = new File(path + File.separator + "dir1" + File.separator + "dir11" + File.separator + "file111");
		f.createNewFile();
		f.setExecutable(true);
		f = new File(path + File.separator + "dir1" + File.separator + "dir11" + File.separator + "file112");
		f.createNewFile();
		f.setExecutable(false);
		f = new File(path + File.separator + "dir1" + File.separator + "dir11" + File.separator + ".file113");
		f.createNewFile();
		f.setExecutable(true);
	}
}
