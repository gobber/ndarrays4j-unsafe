package ndarrays4j.factory.integer;

import ndarrays4j.arrays.integer.NdUnsignedIntArray;
import ndarrays4j.dtype.integer.IntUnsafe;
import ndarrays4j.factory.NdArrayFactory;

public class FactoryNdUnsignedIntArray extends NdArrayFactory<NdUnsignedIntArray, IntUnsafe>{
	
	@Override
	public NdUnsignedIntArray create(int[] shape) {			
		return new NdUnsignedIntArray(shape);			
	}

	@Override
	public NdUnsignedIntArray create(int[] shape, int[] strides, int order, IntUnsafe vector) {	
		return new NdUnsignedIntArray(shape, strides, order, vector);
	}

	@Override
	public NdUnsignedIntArray create(int[] shape, int[] strides, IntUnsafe vector) {
		return new NdUnsignedIntArray(shape, strides, vector);
	}

	@Override
	public NdUnsignedIntArray create(int[] shape, IntUnsafe vector) {
		return new NdUnsignedIntArray(shape, vector);
	}

	@Override
	public NdUnsignedIntArray create(long address, int[] shape, int order) {
		return new NdUnsignedIntArray(address, shape, order);
	}

	@Override
	public NdUnsignedIntArray create(long address, int[] shape) {
		return new NdUnsignedIntArray(address, shape);
	}

	@Override
	public NdUnsignedIntArray create(long address, int[] shape, int[] strides, int order) {
		return new NdUnsignedIntArray(address, shape, strides, order);
	}

	@Override
	public NdUnsignedIntArray create(long address, int[] shape, int[] strides) {
		return new NdUnsignedIntArray(address, shape, strides);
	}

	@Override
	public NdUnsignedIntArray create(int[] shape, int order) {
		return new NdUnsignedIntArray(shape, order);
	}
}
