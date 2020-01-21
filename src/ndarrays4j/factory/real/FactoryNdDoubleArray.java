package ndarrays4j.factory.real;

import ndarrays4j.arrays.real.NdDoubleArray;
import ndarrays4j.dtype.real.DoubleUnsafe;
import ndarrays4j.factory.NdArrayFactory;

public class FactoryNdDoubleArray extends NdArrayFactory<NdDoubleArray, DoubleUnsafe>{

	@Override
	public NdDoubleArray create(int[] shape, int[] strides, int order, DoubleUnsafe vector) {
		return new NdDoubleArray(shape, strides, order, vector);
	}

	@Override
	public NdDoubleArray create(int[] shape, int[] strides, DoubleUnsafe vector) {
		return new NdDoubleArray(shape, strides, vector);
	}

	@Override
	public NdDoubleArray create(int[] shape, DoubleUnsafe vector) {
		return new NdDoubleArray(shape, vector);
	}

	@Override
	public NdDoubleArray create(int[] shape) {
		return new NdDoubleArray(shape);
	}

	@Override
	public NdDoubleArray create(int[] shape, int order) {
		return new NdDoubleArray(shape, order);
	}

	@Override
	public NdDoubleArray create(long address, int[] shape, int order) {
		return new NdDoubleArray(address, shape, order);
	}

	@Override
	public NdDoubleArray create(long address, int[] shape) {
		return new NdDoubleArray(address, shape);
	}

	@Override
	public NdDoubleArray create(long address, int[] shape, int[] strides, int order) {
		return new NdDoubleArray(address, shape, strides, order);
	}

	@Override
	public NdDoubleArray create(long address, int[] shape, int[] strides) {
		return new NdDoubleArray(address, shape, strides);
	}
	
}
