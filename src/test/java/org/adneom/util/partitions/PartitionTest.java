package org.adneom.util.partitions;

import java.util.List;

import org.adneom.util.partitions.ListPartition;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public class PartitionTest {

	@Test
	public void testStringPartition() {
		List<String> listStrings = initListStrings(5);
		List<List<String>> listPartitions = ListPartition.partition(listStrings, 2);
		Assert.assertFalse("listPartitions is empty ", listPartitions.isEmpty());
		Assert.assertEquals("listPartions size doesn't match ", 3, listPartitions.size());
		List<String> firstPartition = Lists.newArrayList();
		firstPartition.add("element 0");
		firstPartition.add("element 1");
		Assert.assertEquals(firstPartition, listPartitions.get(0));
		Assert.assertEquals("Size of last partition doesn't match ", 1, listPartitions.get(2).size());
	}

	@Test
	public void testIntPartition() {
		List<Integer> listIntegers = initListIntegers(14);
		List<List<Integer>> listPartitions = ListPartition.partition(listIntegers, 3);
		Assert.assertFalse("listPartitions is empty ", listPartitions.isEmpty());
		Assert.assertEquals("listPartions size doesn't match ", 5, listPartitions.size());
		List<Integer> secondPartition = Lists.newArrayList();
		secondPartition.add(Integer.valueOf(3));
		secondPartition.add(Integer.valueOf(4));
		secondPartition.add(Integer.valueOf(5));
		Assert.assertEquals(secondPartition, listPartitions.get(1));
		Assert.assertEquals("Size of last partition doesn't match ", 2, listPartitions.get(4).size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFailurePartition() {
		List<String> listStrings = initListStrings(10);
		ListPartition.partition(listStrings, 0);
	}

//	Helpers
	private List<String> initListStrings(int n) {
		List<String> elements = Lists.newArrayList();
		for (int i = 0; i < n; i++) {
			elements.add("element " + i);
		}
		return elements;
	}

	private List<Integer> initListIntegers(int n) {
		List<Integer> elements = Lists.newArrayList();
		for (int i = 0; i < n; i++) {
			elements.add(Integer.valueOf(i));
		}
		return elements;
	}

}
