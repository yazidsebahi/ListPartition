package org.adneom.util.partitions;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.Validate;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class ListPartition {

	public ListPartition() {
	}

	public static <T> List<List<T>> partition(List<T> list, int n) {
		Validate.notEmpty(list, "List must be not null");
		if (n <= 0) {
			throw new IllegalArgumentException("The partition size must be greater then 0");
		}
		List<List<T>> partition = Lists.newArrayList();
		Iterator<List<T>> iterator = Iterables.partition(list, n).iterator();
		iterator.forEachRemaining(partition::add);
		return partition;
	}

}
