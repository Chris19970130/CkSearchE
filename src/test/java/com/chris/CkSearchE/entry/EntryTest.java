package com.chris.CkSearchE.entry;

import org.junit.Test;

import com.chris.CkSearchE.entrance.ExtractEntrance;

public class EntryTest {
	@Test
	public void test(){
		ExtractEntrance.main(new String[]{"-I","config/config.ini"});
	}

}
