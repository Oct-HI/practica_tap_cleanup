package decorator;
import java.util.function.Function;

/**
 * A decorator class that measures execution time.
 */
public class TimerDecorator<T, R> extends Decorator<T, R>{

	
    /**
     * Constructs a timer decorator with the specified function to be wrapped.
     *
     * @param function The function to be wrapped by the timer decorator.
     */
	public TimerDecorator(Function<T, R> function) {
		super(function);
	}

	/**
<<<<<<< Updated upstream
	 * Applies the timer decorator logic to the given argument, measuring the execution time of the underlying function.
	 *
	 * @param t The argument to be passed to the decorated function.
	 * @return The result of applying the timer decorator logic to the provided argument.
	 */
=======
     * Applies the wrapped function to the given input parameter, measures the execution time,
     * and prints the time of execution to the console.
     *
     * @param t The input parameter for the wrapped function.
     * @return The result returned by the wrapped function.
     */
>>>>>>> Stashed changes
	@Override
	public R apply(T t) {
		long	timeExecution;
		R		result;

		timeExecution = System.nanoTime();
		result = getFunction().apply(t);
		timeExecution = System.nanoTime() - timeExecution;
		System.out.println("Time of execution is " + timeExecution + " ns.");
		return (result);
	}

}
