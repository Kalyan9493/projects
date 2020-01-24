package superMarket;

/**
 * SuperMarket is an interface with the fields and abstract methods
 * Rice,Dal,Flour are the constant variables
 * Display() function is used to display the details of the products
 * selectRice() function is used to select the rice from the user in Kg's
 * selectDal() function is used to select the Dal from the user in Kg's
 * selectRice() function is used to select the Flour from the user in Kg's
 * @author Kalyan
 *
 */

public interface SuperMarket {
	public static float RICE=40.0f;
	public static float DAL=60.0f;
	public static float FLOUR=80.0f;
	abstract void display();
	abstract float selectRice();
	abstract float selectDal();
	abstract float selectFlour();
	abstract void bill(float rice1, float dal1, float flour1);
	

}
