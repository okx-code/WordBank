package com.programmerdan.minecraft.wordbank.random;

import java.security.SecureRandom;

public class SecureRandomSource implements RandomSource {
	private static final SecureRandom RANDOM = new SecureRandom();

	@Override
	public float getFloat() {
		return RANDOM.nextFloat();
	}

	@Override
	public int getInt(int bound) {
		return RANDOM.nextInt(bound);
	}

	@Override
	public <T> T pick(T[] ts) {
		return ts[RANDOM.nextInt(ts.length)];
	}
}
