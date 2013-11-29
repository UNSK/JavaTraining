package ex01_16;

import static org.junit.Assert.*;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class MyUtilitiesTest {
	private static final double DELTA = 1e-15;
	private String test_file_name = "test.dset";
	private MyUtilities util;

	/**
	 * テスト用のデータセットを作成する
	 * @throws java.io.IOException 例外
	 */
	@Before
	public void setUp() throws IOException {
		util = new MyUtilities();
		File test_file = new File(test_file_name);
		test_file.createNewFile();
		FileOutputStream fos = new FileOutputStream(test_file);
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeDouble(3.1415);
		dos.writeDouble(1.4142);
		dos.close();
	}

	/**
	 * テスト用に作成したデータセットを削除する
	 * @throws java.io.IOException 例外
	 */
	@After
	public void tearDown() throws IOException {
		File test_File = new File(test_file_name);
		test_File.delete();
	}

	@Test
	public void getDataSetTest() throws BadDataSetException {
		double[] data_set = util.getDataSet("test");
		assertEquals(3.1415, data_set[0], DELTA);
		assertEquals(1.4142, data_set[1], DELTA);
	}

}
