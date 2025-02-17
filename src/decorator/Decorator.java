package decorator;
import java.util.function.Function;

/**
 * A generic decorator class for wrapping a function.
 */
public abstract class Decorator<T, R> implements Function<T, R> {

	protected Function<T, R> function;

	/**
     * Constructs a decorator with the specified function to be wrapped.
     *
     * @param function The function to be wrapped by the decorator.
     */
	public Decorator(Function<T, R> function) {
		super();
		this.function = function;
	}

	/**
<<<<<<< Updated upstream
	 * Applies the decorated function to the given argument.
	 *
	 * @param t The argument to be passed to the decorated function.
	 * @return The result of applying the decorated function to the provided argument.
	 */
=======
     * Applies the wrapped function to the given input parameter.
     *
     * @param t The input parameter for the wrapped function.
     * @return The result returned by the wrapped function.
     */
>>>>>>> Stashed changes
	@Override
	public R apply(T t) {
		return (function.apply(t));
	}

	/**
<<<<<<< Updated upstream
	 * Gets the underlying function associated with this decorator.
	 *
	 * @return The underlying function.
	 */
=======
     * Retrieves the wrapped function.
     *
     * @return The wrapped function.
     */
>>>>>>> Stashed changes
	public Function<T, R> getFunction()
	{
		return (function);
	}

}
