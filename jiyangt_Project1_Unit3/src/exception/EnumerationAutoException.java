package exception;

public enum EnumerationAutoException {
	WrongFileName(1),
	MissingMake(2),
	MissingModel(3),
	MissingBasePrice(4),
	MissingOptionSetName(5),
	MissingOptionSetSize(6),
	MissingOptionName(7),
	MissingOptionPrice(8),
	WrongCarModel(9),
	WrongOptionSetName(10),
	WrongOptionName(11);
	
	private int exceptionIndex;
	
	private EnumerationAutoException(int index) {
		this.exceptionIndex = index;
	}
	
	public int getExceptionIndex() {
		return this.exceptionIndex;
	}
}