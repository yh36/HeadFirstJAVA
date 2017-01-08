package self;

public class BottlesOfBeer {
	public static void main(String[] args) {
		int bottles = 99;
		String word = "bottles";
		while (bottles > 0) {
			System.out.print(bottles + " " + word + " of beer on the wall, ");
			System.out.println(bottles + " " + word + " of beer.");
			bottles--;
			if (bottles == 1) {
				word = "bottle";
			}
			System.out.print("Take one down and pass it around, ");
			if (bottles > 0) {
				System.out.println(bottles + " " + word + " of beer on the wall.");
			}
			else {
				System.out.println("No more bottles of beer on the wall, no more bottles of beer."); 
				System.out.println("Go to the store and buy some more, 99 bottles of beer on the wall.");
			}
		}
	}
}
