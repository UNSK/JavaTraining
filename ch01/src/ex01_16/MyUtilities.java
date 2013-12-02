package ex01_16;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class MyUtilities {
	private static final int kMaxDataSet = 10;
	public double[] getDataSet(String setName) throws BadDataSetException {
		String file = setName + ".dset";
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			return readDataSet(in);
		} catch (IOException e) {
			throw new BadDataSetException(file, e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				//nop
			}
		}
	}
	
	public double[] readDataSet(FileInputStream in) throws IOException {
		double[] data_set = new double[kMaxDataSet];
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(in);
			for (int i = 0; dis.available() > 0; i++) {
				data_set[i] = dis.readDouble();
			}
			return data_set;
		} catch (IOException e) {
			throw e;
		} finally {
			if (dis != null) {
				dis.close();
			}
		}
	}
}
