package algodat_1;

class EmptyListException extends Exception
{
	EmptyListException()
	{
		super("Method cannot be called on empty list");
	}

}
