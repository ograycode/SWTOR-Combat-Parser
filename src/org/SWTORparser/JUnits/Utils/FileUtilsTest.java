package org.SWTORparser.JUnits.Utils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.SWTORparser.Utils.FileUtils;
import org.junit.Test;

/**
 * Unit testing for org.SWTORpars.File.File
 * 
 * @author Jason Gray
 *
 */
public class FileUtilsTest {

	/**
	 * Unit test for readFile() method
	 */
	@Test
	public void testReadFile() {
		FileUtils file = new FileUtils("C:\\Users\\jason.a.gray\\Documents\\SWTORparser\\Unit Test Supporting Files\\File Reading Unit Test.txt");
		List<String> list = file.readFile();
		String[] actual = list.toArray(new String[list.size()]);
		String[] expected = {"test line 1", "test line 2"};
		assertArrayEquals(expected, actual);
	}

}
