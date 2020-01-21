package ndarrays4j.factory.integer;

import ndarrays4j.arrays.integer.NdUnsignedShortArray;
import ndarrays4j.dtype.integer.ShortUnsafe;
import ndarrays4j.factory.NdArrayFactory;

public class FactoryNdUnsignedShortArray extends NdArrayFactory<NdUnsignedShortArray, ShortUnsafe>{

	@Override
	public NdUnsignedShortArray create(int[] shape, int[] strides, int order, ShortUnsafe vector) {
		return new NdUnsignedShortArray(shape, strides, order, vector);
	}

	@Override
	public NdUnsignedShortArray create(int[] shape, int[] strides, ShortUnsafe vector) {
		return new NdUnsignedShortArray(shape, strides, vector);
	}

	@Override
	public NdUnsignedShortArray create(int[] shape, ShortUnsafe vector) {
		return new NdUnsignedShortArray(shape, vector);
	}

	@Override
	public NdUnsignedShortArray create(int[] shape) {
		return new NdUnsignedShortArray(shape);
	}

	@Override
	public NdUnsignedShortArray create(int[] shape, int order) {
		return new NdUnsignedShortArray(shape, order);
	}

	@Override
	public NdUnsignedShortArray create(long address, int[] shape, int order) {
		return new NdUnsignedShortArray(address, shape, order);
	}

	@Override
	public NdUnsignedShortArray create(long address, int[] shape) {
		return new NdUnsignedShortArray(address, shape);
	}

	@Override
	public NdUnsignedShortArray create(long address, int[] shape, int[] strides, int order) {
		return new NdUnsignedShortArray(address, shape, strides, order);
	}

	@Override
	public NdUnsignedShortArray create(long address, int[] shape, int[] strides) {
		return new NdUnsignedShortArray(address, shape, strides);
	}
	
}
