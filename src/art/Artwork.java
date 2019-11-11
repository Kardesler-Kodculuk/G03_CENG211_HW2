package art;

import trade.ITradable;
import utility.IComparable;

public abstract class Artwork implements IComparable<Artwork>, ITradable {
	protected String name;
	protected PriceMultiplier style;
	
	public abstract double calculateCost();
	
}
