package application;

public class Metric<T> {
	private String	functionId;
	private T		dataType;

	public Metric(String functionId, T dataType)
	{
		this.functionId = functionId;
		this.dataType = dataType;
	}

	/**
	 * Gets the function ID associated with this instance.
	 *
	 * @return The function ID.
	 */
	public String getFunctionId() {
		return functionId;
	}

	/**
	 * Gets a string representation of the data type associated with this instance.
	 *
	 * @return A string representation of the data type.
	 */
	public String getDataStr() {
		return dataType.toString();
	}

	/**
	 * Gets the data type associated with this instance.
	 *
	 * @return The data type.
	 */
	public T getDataType() {
		return dataType;
	}

	/**
	 * Sets the data type for this instance.
	 *
	 * @param dataType The data type to be set.
	 */
	public void setDataType(T dataType) {
		this.dataType = dataType;
	}
}
