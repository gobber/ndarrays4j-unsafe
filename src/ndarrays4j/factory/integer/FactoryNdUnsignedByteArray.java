package ndarrays4j.factory.integer;

import ndarrays4j.arrays.integer.NdUnsignedByteArray;
import ndarrays4j.dtype.integer.ByteUnsafe;
import ndarrays4j.factory.NdArrayFactory;

public class FactoryNdUnsignedByteArray extends NdArrayFactory<NdUnsignedByteArray, ByteUnsafe>{

	@Override
	public NdUnsignedByteArray create(int[] shape, int[] strides, int order, ByteUnsafe vector) {
		return new NdUnsignedByteArray(shape, strides, order, vector);
	}

	@Override
	public NdUnsignedByteArray create(int[] shape, int[] strides, ByteUnsafe vector) {
		return new NdUnsignedByteArray(shape, strides, vector);
	}

	@Override
	public NdUnsignedByteArray create(int[] shape, ByteUnsafe vector) {
		return new NdUnsignedByteArray(shape, vector);
	}

	@Override
	public NdUnsignedByteArray create(int[] shape) {
		return new NdUnsignedByteArray(shape);
	}

	@Override
	public NdUnsignedByteArray create(int[] shape, int order) {
		return new NdUnsignedByteArray(shape, order);
	}

	@Override
	public NdUnsignedByteArray create(long address, int[] shape, int order) {
		return new NdUnsignedByteArray(address, shape, order);
	}

	@Override
	public NdUnsignedByteArray create(long address, int[] shape) {
		return new NdUnsignedByteArray(address, shape);
	}

	@Override
	public NdUnsignedByteArray create(long address, int[] shape, int[] strides, int order) {
		return new NdUnsignedByteArray(address, shape, strides, order);
	}

	@Override
	public NdUnsignedByteArray create(long address, int[] shape, int[] strides) {
		return new NdUnsignedByteArray(address, shape, strides);
	}
	
}
