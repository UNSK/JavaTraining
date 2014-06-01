package ex21_06;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Concat {

	public static void main(String[] args) throws IOException {
		InputStream in;
		Enumeration<InputStream> files = null;
		if (args.length == 0) {
			in = System.in;
		} else {
			InputStream fileIn, bufIn;
			List<InputStream> inputs =
					new ArrayList<>(args.length);
			for (String arg : args) {
				fileIn = new FileInputStream(arg);
				bufIn = new BufferedInputStream(fileIn);
				inputs.add(bufIn);
			}
			files =	Collections.enumeration(inputs);
			in = files.nextElement();
 		}
		int ch;
		for (;;) {
			while ((ch = in.read()) != -1) {
				System.out.write(ch);
			}
			if (files != null && files.hasMoreElements()) {
				in = files.nextElement();
			} else {
				break;
			}
		}
	}
}
