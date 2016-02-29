package adapter;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 5, 2016
 */
public interface UpdateAuto {
	public void updateOptionSetName(String ModelName, String OptionSetName, String newName);
	
	public void updateOptionPrice(String ModelName, String OptionName, String Option, float newPrice);
}