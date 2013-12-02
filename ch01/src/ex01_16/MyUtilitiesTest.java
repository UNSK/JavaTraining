package ex01_16;

import static org.junit.Assert.*;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * {@link MyUtilities}のテストコード
 * 一時的にtest.dsetを作成する
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
	public void testGetDataSet() throws BadDataSetException {
		double[] data_set = util.getDataSet("test");
		assertEquals(3.1415, data_set[0], DELTA);
		assertEquals(1.4142, data_set[1], DELTA);
	}
	
	/**
	 * 例外をキャッチし、BadDataSetExceptionの仕様を満たしているか確認する
	 * @throws BadDataSetException
	 */
	@Test
	public void testBadDataSetException() throws BadDataSetException {
		try {
			double[] bad_data_set = util.getDataSet("bad");
			fail("incoceivable");
		} catch (BadDataSetException e) {
			assertEquals("bad.dset", e.getFileName());
			/* 例外の内容がfileNotFoundかどうかを確認する*/
			assertTrue(e.getException().toString().startsWith(
					"java.io.FileNotFoundException"));
		}
	}
}
