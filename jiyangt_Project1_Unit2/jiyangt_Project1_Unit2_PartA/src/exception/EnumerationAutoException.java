package exception;

public enum EnumerationAutoException {
	WrongFileName(1),
	MissingModelName(2),
	MissingBasePrice(3),
	MissingSize(4),
	MissingOptionSetName(5),
	MissingOptionSetSize(6),
	MissingOptionName(7),
	MissingOptionPrice(8),
	MissingOptionSet(9),
	MissingOption(10),
	ExceedingOptionSet(11),
	ExceedingOption(12);
	
	private int exceptionIndex;
	
	private EnumerationAutoException(int index) {
		this.exceptionIndex = index;
	}
	
	public int getExceptionIndex() {
		return this.exceptionIndex;
	}
}