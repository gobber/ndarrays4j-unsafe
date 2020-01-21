package ndarrays4j.utils;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

import sun.misc.Unsafe;

public class UnsafeUtil {

	public static final Unsafe UNSAFE;
	static
	{
		try
		{
			final PrivilegedExceptionAction< Unsafe > action = () -> {
				final Field field = Unsafe.class.getDeclaredField( "theUnsafe" );
				field.setAccessible( true );
				return ( Unsafe ) field.get( null );
			};

			UNSAFE = AccessController.doPrivileged( action );
		}
		catch ( final Exception ex )
		{
			throw new RuntimeException( ex );
		}
	}
	
	public static final long getAddress( final Object store ) {
		final Object[] array = new Object[] { store };

		final long baseOffset = UNSAFE.arrayBaseOffset( Object[].class );
		final int addressSize = UNSAFE.addressSize();
		long objectAddress;
		switch ( addressSize )
		{
		case 4:
			objectAddress = UNSAFE.getInt( array, baseOffset );
			break;
		case 8:
			objectAddress = UNSAFE.getLong( array, baseOffset );
			break;
		default:
			throw new Error( "unsupported address size: " + addressSize );
		}

		return objectAddress;
	}

	public static long getFirstArrayElementAddress( final Object array ) {
		final long arrayAddress = getAddress( array );
		final long baseOffset = UNSAFE.arrayBaseOffset( array.getClass() );
		return arrayAddress + baseOffset;
		
	}
	
}
