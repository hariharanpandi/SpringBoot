package com.ex.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CodingChallenge {
	  public static void main(String[] args) {
	        List<Integer> duplicates = new ArrayList<>();
	        for (int i = 0; i <= 500; i++) {
	            if (hasDuplicateDigits(i)) {
	                duplicates.add(i);
	            }
	        }

	        List<Integer> result = new ArrayList<>();
	        for (int num : duplicates) {
	            if (digitSum(num) <= 5) {
	                result.add(num);
	            }
	        }

	        System.out.println(result);
	    }

	    private static boolean hasDuplicateDigits(int num) {
	        Set<Integer> digits = new HashSet<>();
	        while (num > 0) {
	            int digit = num % 10;
	            if (digits.contains(digit)) {
	                return true;
	            }
	            digits.add(digit);
	            num /= 10;
	        }
	        return false;
	    }

	    private static int digitSum(int num) {
	        int sum = 0;
	        while (num > 0) {
	            sum += num % 10;
	            num /= 10;
	        }
	        return sum;
	    }

}
