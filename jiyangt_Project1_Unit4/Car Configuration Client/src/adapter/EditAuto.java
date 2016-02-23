package adapter;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 12, 2016
 * 
 * This file gives an interface to define the method that can edit the model
 */
import scale.EditOptions.EditOptionEnumerator;

public interface EditAuto {
	public void edit(EditOptionEnumerator editOptionEnumerator, String[] args);
}