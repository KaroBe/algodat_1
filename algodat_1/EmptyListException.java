package algodat_1;

@SuppressWarnings("serial")

class EmptyListException extends Exception
{
	EmptyListException()
	{
		super("Method cannot be called on empty list");
	}

}
