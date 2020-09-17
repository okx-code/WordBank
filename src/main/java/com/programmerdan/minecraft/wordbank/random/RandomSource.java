package com.programmerdan.minecraft.wordbank.random;

public interface RandomSource {
	float getFloat();

	int getInt(int bound);

	<T> T pick(T[] ts);
}
