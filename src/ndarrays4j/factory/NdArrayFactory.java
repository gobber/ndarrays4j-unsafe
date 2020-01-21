package ndarrays4j.factory;

import ndarrays4j.arrays.AbstractNdArray;
import ndarrays4j.arrays.integer.NdByteArray;
import ndarrays4j.arrays.integer.NdIntArray;
import ndarrays4j.arrays.integer.NdLongArray;
import ndarrays4j.arrays.integer.NdShortArray;
import ndarrays4j.arrays.integer.NdUnsignedByteArray;
import ndarrays4j.arrays.integer.NdUnsignedIntArray;
import ndarrays4j.arrays.integer.NdUnsignedLongArray;
import ndarrays4j.arrays.integer.NdUnsignedShortArray;
import ndarrays4j.arrays.real.NdDoubleArray;
import ndarrays4j.arrays.real.NdFloatArray;
import ndarrays4j.dtype.Dtype;
import ndarrays4j.dtype.integer.ByteUnsafe;
import ndarrays4j.dtype.integer.IntUnsafe;
import ndarrays4j.dtype.integer.LongUnsafe;
import ndarrays4j.dtype.integer.ShortUnsafe;
import ndarrays4j.dtype.real.DoubleUnsafe;
import ndarrays4j.dtype.real.FloatUnsafe;
import ndarrays4j.factory.integer.FactoryNdByteArray;
import ndarrays4j.factory.integer.FactoryNdIntArray;
import ndarrays4j.factory.integer.FactoryNdLongArray;
import ndarrays4j.factory.integer.FactoryNdShortArray;
import ndarrays4j.factory.integer.FactoryNdUnsignedByteArray;
import ndarrays4j.factory.integer.FactoryNdUnsignedIntArray;
import ndarrays4j.factory.integer.FactoryNdUnsignedLongArray;
import ndarrays4j.factory.integer.FactoryNdUnsignedShortArray;
import ndarrays4j.factory.real.FactoryNdDoubleArray;
import ndarrays4j.factory.real.FactoryNdFloatArray;

public abstract class NdArrayFactory<T extends AbstractNdArray<K>, K extends Dtype> {		
	
	public static final NdArrayFactory<NdByteArray, ByteUnsafe> BYTE = new FactoryNdByteArray();	
	public static final NdArrayFactory<NdUnsignedByteArray, ByteUnsafe> U_BYTE = new FactoryNdUnsignedByteArray();
	public static final NdArrayFactory<NdShortArray, ShortUnsafe> SHORT = new FactoryNdShortArray();
	public static final NdArrayFactory<NdUnsignedShortArray, ShortUnsafe> U_SHORT = new FactoryNdUnsignedShortArray();
	public static final NdArrayFactory<NdFloatArray, FloatUnsafe> FLOAT = new FactoryNdFloatArray();
	public static final NdArrayFactory<NdDoubleArray, DoubleUnsafe> DOUBLE = new FactoryNdDoubleArray();	
	public static final NdArrayFactory<NdIntArray, IntUnsafe> INT = new FactoryNdIntArray();
	public static final NdArrayFactory<NdUnsignedIntArray, IntUnsafe> U_INT = new FactoryNdUnsignedIntArray();	
	public static final NdArrayFactory<NdLongArray, LongUnsafe> LONG = new FactoryNdLongArray();
	public static final NdArrayFactory<NdUnsignedLongArray, LongUnsafe> U_LONG = new FactoryNdUnsignedLongArray();
	
	public abstract T create(int[] shape, int[] strides, int order, K vector);
	
	public abstract T create (int[] shape, int[] strides, K vector);
	
	public abstract T create (int[] shape, K vector);

	public abstract T create (int[] shape);
	
	public abstract T create (int[] shape, int order);
	
	public abstract T create (long address, int[] shape, int order);
	
	public abstract T create (long address, int[] shape);
	
	public abstract T create (long address, int[] shape, int[] strides, int order);
	
	public abstract T create (long address, int[] shape, int[] strides);
	
}
