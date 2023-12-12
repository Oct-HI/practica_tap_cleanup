package application;

public class PairValues {

	private Object args;
	private Object result;

	public PairValues(Object args, Object result)
	{
		this.args = args;
		this.result = result;
	}

	/**
	 * Gets the arguments from this instance.
	 *
	 * @return The arguments.
	 */
	public Object getArgs() {
		return args;
	}

	/**
	 * Gets the results from  this instance.
	 *
	 * @return The result.
	 */
	public Object getResult() {
		return result;
	}
}
